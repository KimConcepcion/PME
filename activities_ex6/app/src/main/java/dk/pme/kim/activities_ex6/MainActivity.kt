package dk.pme.kim.activities_ex6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Button listeners:
        buttonMinus.setOnClickListener {
            progressBar.incrementProgressBy(-1)
        }

        buttonPlus.setOnClickListener {
            progressBar.incrementProgressBy(1)
        }
    }
}
