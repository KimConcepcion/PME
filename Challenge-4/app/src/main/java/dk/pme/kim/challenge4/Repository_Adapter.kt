package dk.pme.kim.challenge4

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class Repository_Adapter(val repos : Repos, val context : Context) : RecyclerView.Adapter<Repository_Adapter.MyViewHolder>()
{
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        var parentLayout : CardView? = null
        var txtName : TextView? = null
        var txtDate : TextView? = null
        var txtOwner : TextView? = null
        var txtStars : TextView? = null

        init
        {
            this.parentLayout = itemView.findViewById<CardView>(R.id.parentLayout)
            this.txtName = itemView.findViewById<TextView>(R.id.txtName)
            this.txtDate = itemView.findViewById<TextView>(R.id.txtDate)
            this.txtOwner = itemView.findViewById<TextView>(R.id.txtOwner)
            this.txtStars = itemView.findViewById<TextView>(R.id.txtStars)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var listItemView : View
        listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return MyViewHolder(listItemView)
    }

    //  Combine data and created views here:
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.d("Repository_Adapter", "onBindViewHolder: Called!")
        val repo = repos.reposList[position]

        //  update views:
        holder.txtName?.text = repo.name
        holder.txtDate?.text = repo.updated_at
        holder.txtOwner?.text = repo.owner.login
        holder.txtStars?.text = repo.stargazers_count.toString()

        //  Click listener:
        holder.parentLayout?.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(context, GitHubInfoActivity::class.java)
            intent.putExtra("extra_name", repo.name)
            intent.putExtra("extra_date", repo.updated_at)
            intent.putExtra("extra_owner", repo.owner.login)
            intent.putExtra("extra_html_url", repo.html_url)
            intent.putExtra("extra_stars", repo.stargazers_count.toString())
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int{
        return repos.reposList.size
    }


}