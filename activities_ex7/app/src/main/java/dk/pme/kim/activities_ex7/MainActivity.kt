package dk.pme.kim.activities_ex7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Login button listener:
        buttonLogin.setOnClickListener {

            //  Evaluate email and password:
            if(txtEmail.text.toString() == "user@email.com" && txtPassword.text.toString() == "ILOVEAND")
                Toast.makeText(applicationContext, "welcome", Toast.LENGTH_LONG).show();

            else
            {
                Toast.makeText(applicationContext, "Please enter email and password!",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
