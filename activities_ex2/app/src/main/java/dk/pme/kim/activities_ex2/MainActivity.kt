package dk.pme.kim.activities_ex2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

public interface Constants
{
    //  Tag for activity name:
    val TAG:String
}

class MainActivity : AppCompatActivity(), Constants
{

    override val TAG:String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate() called")
    }
    
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy() called")
    }
}