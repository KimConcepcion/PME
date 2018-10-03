package dk.pme.kim.githubinfoactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        //  Recv data from parent activity:
        recvFromIntent()
    }

    private fun recvFromIntent()
    {
        if(intent.extras.containsKey("extra_day") &&
                intent.extras.containsKey("extra_course"))
        {
            val day = intent.getStringExtra("extra_day")
            val course = intent.getStringArrayExtra("extra_course")

            //  Evalute the content transferred:
            if(day.equals("Monday"))
            {
                txtDay.setText(day)                 //  Write day
                txtFirstCourse.setText(course[3])   //  Write courses
            }

            else if(day.equals("Tuesday"))
            {
                txtDay.setText(day)                 //  Write day
                txtFirstCourse.setText(course[1])   //  Write courses
                txtSecondCourse.setText(course[2])
                txtFourthCourse.setText(course[0])
            }

            else if(day.equals("Wednesday"))
            {
                txtDay.setText(day)                 //  Write day
                txtThirdCourse.setText(course[2])   //  Write courses
            }

            else if(day.equals("Thursday"))
            {
                txtDay.setText(day)                 //  Write day
                txtFirstCourse.setText(course[1])   //  Write courses
                txtThirdCourse.setText(course[3])
            }

            else if(day.equals("Friday"))
            {
                txtDay.setText(day)                 //  Write day
            }
        }
    }
}