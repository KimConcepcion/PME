package dk.pme.kim.githubinfoactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.net.Uri
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private fun showMap(geoLocation: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //  Action listener for show location button:
    fun scheduleListener(view: View)
    {
        //  Import string arrays:
        val days:Array<String> = resources.getStringArray(R.array.days)
        val courses:Array<String> = resources.getStringArray(R.array.courses)

        //  Create intent:
        val intent_schedule:Intent = Intent(this, ScheduleActivity::class.java)

        //  Evaluate radio buttons:
        val selectedID:Int = rGroup.checkedRadioButtonId
        val id = findViewById<RadioButton>(selectedID)

        if(id == radioMon.findViewById(R.id.radioMon))
        {
            Toast.makeText(this, "Monday", Toast.LENGTH_SHORT).show()
            intent_schedule.putExtra("extra_day", days[0])
        }

        else if(id == radioTue.findViewById(R.id.radioTue))
        {
            Toast.makeText(this, "Tuesday", Toast.LENGTH_SHORT).show()
            intent_schedule.putExtra("extra_day", days[1])

        }

        else if(id == radioWed.findViewById(R.id.radioWed))
        {
            Toast.makeText(this, "Wednesday", Toast.LENGTH_SHORT).show()
            intent_schedule.putExtra("extra_day", days[2])
        }

        else if(id == radioThu.findViewById(R.id.radioThu))
        {
            Toast.makeText(this, "Thursday", Toast.LENGTH_SHORT).show()
            intent_schedule.putExtra("extra_day", days[3])
        }

        else if(id == radioFri.findViewById(R.id.radioFri))
        {
            Toast.makeText(this, "Friday", Toast.LENGTH_SHORT).show()
            intent_schedule.putExtra("extra_day", days[4])
        }

        //  add course string array:
        intent_schedule.putExtra("extra_course", courses)

        //  Start the activity:
        startActivity(intent_schedule)
    }

    //  Action listener for show location button:
    fun locationListener(view: View)
    {
        val latitude=56.166666
        val longitude=10.1999992
        val myUri = Uri.parse("geo:$latitude,$longitude")
        showMap(myUri)
    }

    //  Action listener for contact administration button:
    fun contactListener(view: View)
    {
        val intent_contact:Intent = Intent(this, ContactActivity::class.java)
        startActivity(intent_contact)
    }
}
