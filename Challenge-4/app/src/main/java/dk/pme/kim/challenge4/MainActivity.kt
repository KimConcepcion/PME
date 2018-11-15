package dk.pme.kim.challenge4

//  Remember to use android.support.v7.widget.SearchView.
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.ViewManager
import android.widget.LinearLayout
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.toolbar.*
import okhttp3.*
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity()
{
    private val list = ArrayList<Repo>()
    private var repos = Repos(list)
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    //  Initialize recyclerview:
    fun vRecycler_init(repos : Repos){
        //  Linear layout, since I want the recyclerview to function like a listview:
        viewManager = LinearLayoutManager(this)
        viewAdapter = Repository_Adapter(repos, applicationContext)

        recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
        Log.d("MainActivity", "Recyclerview initialized!")
    }

    fun urlBuilder(query : String) : String{
        val urlBuilder = HttpUrl.Builder()
                .scheme("https")
                .host("api.github.com")
                .addPathSegment("repos")
                .addPathSegment("KimConcepcion")
                .addPathSegment(query)

        //  Build the url as a string and return it:
        val url : String = urlBuilder?.build().toString()
        Log.i("MainActivity", "Created URL:" + url + "\n")
        return url
    }

    //  Consider adding another querry to the url specifying the repo:
    //  https://api.github.com/repos/KimConcepcion/<REPO HERE>
    fun getBody(url : String){
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.isSuccessful){

                    Log.i("MainActivity", "Received response!")
                    val body = response.body()?.string().toString()

                    //  Parse body respons:
                    val gson = Gson()
                    val repo = gson.fromJson(body, Repo::class.java)

                    //  Also log the results:
                    Log.i("MainActivity", "Name:" + repo.name + "\n")
                    Log.i("MainActivity", "Owner:" + repo.owner.login + "\n")
                    Log.i("MainActivity", "Updated at:" + repo.updated_at + "\n")
                    Log.i("MainActivity", "Html_url:" + repo.html_url + "\n")
                    Log.i("MainActivity", "Stars:" + repo.stargazers_count.toString() + "\n")

                    //  Modify updated at value:
                    //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    //repo.updated_at = LocalDate.parse(repo.updated_at, formatter).toString()

                    list.add( Repo(repo.name, repo.owner, repo.html_url, repo.updated_at, repo.stargazers_count) )
                    Log.d("MainActivity", "List has been updated!")

                    //  Run stuff on main thread:
                    this@MainActivity.runOnUiThread(java.lang.Runnable {
                        viewAdapter.notifyDataSetChanged()
                    })
                }
            }
        })
    }

    //  Inflate menu with search menu and setup API with search calls:
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val srchItem = menu?.findItem(R.id.search_bar)

        if(srchItem != null){
            val srchView = srchItem.actionView as SearchView
            srchView.layoutParams = ActionBar.LayoutParams(Gravity.RIGHT)
            srchView.queryHint = "Search GitHub Repositories"

            srchView.isIconified = false
            srchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {

                    if(query != null){
                        //  Use query to search for specific repo:PRO
                        Log.d("SearchBar", "Query:" + query)
                        getBody(urlBuilder(query))
                        Toast.makeText(baseContext, query, Toast.LENGTH_SHORT).show()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    //  onCreate()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(my_toolbar) //  Setup toolbar to main activity
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //  Initialize recyclerview:
        vRecycler_init(repos)
    }
}