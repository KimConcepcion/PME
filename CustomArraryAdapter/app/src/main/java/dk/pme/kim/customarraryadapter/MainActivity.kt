
package dk.pme.kim.customarraryadapter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

//  Class to store data:
data class Animal(val name: String, val ressourceID: Int, val race: String, val gender: String,
                  val weight: Int)

//  Class for custom arrayadapter:
class animalAdapter(context: Context?, resource: Int, objects: MutableList<Animal>?) : ArrayAdapter<Animal>(context, resource, objects)
{
    // Object instant of viewholder class initialized variables with id's in the init scope:
    private class ViewHolder(itemView: View?)
    {
        var imgImage : ImageView? = null
        var txtName : TextView? = null
        var txtRace : TextView? = null
        var txtGender : TextView? = null
        var txtWeight : TextView? = null

        init
        {
            this.imgImage = itemView?.findViewById(R.id.animalImg)
            this.txtName = itemView?.findViewById(R.id.animalName)
            this.txtRace = itemView?.findViewById(R.id.animalRace)
            this.txtGender = itemView?.findViewById(R.id.animalGender)
            this.txtWeight = itemView?.findViewById(R.id.animalWeight)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var listItemView : View?
        val viewHolder : ViewHolder

        if(convertView == null)
        {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,
                    false)
            viewHolder = ViewHolder(listItemView)
            listItemView?.tag = viewHolder
        }

        else
        {
            listItemView = convertView
            viewHolder = listItemView.tag as ViewHolder
        }

        //  Get the specific item at its position:
        val animal = getItem(position)

        viewHolder.imgImage?.setImageResource(animal.ressourceID)
        viewHolder.txtName?.text = animal.name.toString()
        viewHolder.txtRace?.text = animal.race.toString()
        viewHolder.txtGender?.text = animal.gender.toString()
        viewHolder.txtWeight?.text = animal.weight.toString()

        return listItemView as View
    }
}

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener
{
    override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long)
    {
        val text : String = parent.getItemAtPosition(position).toString()
        val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        toast.show()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  String array:
        val animalList = ArrayList<Animal>()
        animalList.add(Animal("Lion", R.drawable.lion, "Predator", "Male", 80))
        animalList.add(Animal("Tiger", R.drawable.tiger, "Predator", "Female", 70))
        animalList.add(Animal("Harambe", R.drawable.harambe, "Mammal", "Male", 150))
        animalList.add(Animal("Elephant", R.drawable.elephant, "Mammal", "Female", 500))
        animalList.add(Animal("Dog", R.drawable.dog, "Predator", "Male", 40))
        animalList.add(Animal("Cat", R.drawable.cat, "Predator", "Male", 25))

        //  custom Adapter - If you used simply arrayAdapter, the app cannot run:
        val adapter = animalAdapter(this, 0, animalList)
        listView.adapter = adapter
        listView.onItemClickListener = this
    }
}