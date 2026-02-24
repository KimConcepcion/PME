package dk.pme.kim.adapterviews

import android.hardware.SensorEventListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.grid_view.*
import kotlinx.android.synthetic.main.list_view.*
import kotlinx.android.synthetic.main.spinner_view.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
        AdapterView.OnItemClickListener
{
    //  Need to override these methods, since we extend the AdapterView.OnItemSelectedListener:
    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long)
    {
        //  Cast int to string:
        val text: String = parent.getItemAtPosition(position) as String
        val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        toast.show()
    }

    //  Will only be called if the adapter is modified. If the choice is removed.
    //  Typically used, when you want to set up a new choice, if a previous one was removed.
    //  This prevents the spinner from automatically selecting the next item in the arraylist.
    override fun onNothingSelected(parent: AdapterView<*>?)
    {
        val toast = Toast.makeText(this, "Item does not exist :(", Toast.LENGTH_LONG)
        toast.show()
    }

    //  Use this, when an item is clicked:
    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long)
    {
        //  Cast int to string:
        val text: String = parent.getItemAtPosition(position) as String
        val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        toast.show()
    }
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner_view)

        //  Arraylist:
        val topics = ArrayList<String>()
        topics.add("Android Studio")
        topics.add("Kotlin vs Java")
        topics.add("Activities")
        topics.add("Intents")
        topics.add("Ressources")
        topics.add("AdapterViews")
        topics.add("Navigation")
        topics.add("Fragments")

        // ###############  List view  ############### Remember to change setcontentview()
        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topics)
        //val adapter = ArrayAdapter(this, R.layout.list_item, topics)
        //listView.adapter = adapter
        //listView.onItemClickListener = this

        // ###############  Grid view  ############### Remember to change setcontentview()
        //val adapter = ArrayAdapter(this, R.layout.list_item, topics)
        //gridView.adapter = adapter

        // ###############  Spinner view  ############### Remember to change setcontentview()
        //  simple_spinner_item  defines the layout for the particular item on the drop down:
        //val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, topics)

        //  ArrayAdapter with string array - using createfromressource - notice the funny swap
        // of parameters:
        val adapter = ArrayAdapter.createFromResource(this, R.array.series,
                android.R.layout.simple_spinner_item)

        //  Specifies the layout for the drop down list of item choices:
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //  Apply the adapter to the desired adapterview:
        spinnerView.adapter = adapter

        //  Implement the interface. Since it is in the mainactivity we can simply refer to
        // the current object by using 'this'
        spinnerView.onItemSelectedListener = this
    }
}