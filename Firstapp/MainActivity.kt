
//  The package that contains our main class:
package com.kimnielsen.firstapp

//  Import packages with methods from Google:
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

//  We inherit with : We use AppCompatActivity
class MainActivity : AppCompatActivity()
{
    //  Overiding the functionality for the function onCrate:
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Variabels with explicit expression:
        val someInt:Int = 10
        val someDouble:Double = 10.5
        val someFloat:Float = 11.5F
        val someString:String = "My name is Kim"

        //  Calculate the sum:
        val sum:Int = someInt + someDouble.toInt()
        








    }
}