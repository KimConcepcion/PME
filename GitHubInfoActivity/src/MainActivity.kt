package dk.pme.kim.githubinfoactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //  Action listener for show location button:
    fun scheduleListener(view: View)
    {
        //  Open schedule activity:
        val intent_schedule:Intent = Intent(this, ScheduleActivity::class.java)
        startActivity(intent_schedule)
    }

    //  Action listener for show location button:
    fun locationListener(view: View)
    {

    }

    //  Action listener for contact administration button:
    fun contactListener(view: View)
    {
        val intent_contact:Intent = Intent(this, ContactActivity::class.java)
        startActivity(intent_contact)
    }
}
