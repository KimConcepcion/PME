package dk.pme.kim.sensormanagertest

import android.app.Activity
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Some private members:
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors:MutableList<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        //  Update the textview:
        val msg:StringBuilder = StringBuilder()
        msg.append("Sensors on this device are:\n-----------------------------------------------\n")

        for(e in deviceSensors)
        {
            msg.append("Name: " + e.name + "\nType: " + sensorTypeToString(e.type) + "\n\n")
        }
        txtSensorList.setText(msg)
    }

    fun sensorTypeToString(sensorType:Int):String
    {
        when(sensorType)
        {
            Sensor.TYPE_ACCELEROMETER -> return "Accelerometer"
            Sensor.TYPE_AMBIENT_TEMPERATURE, Sensor.TYPE_TEMPERATURE -> return "Ambient Temperature"
            Sensor.TYPE_GAME_ROTATION_VECTOR -> return "Game Rotation Vector"
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR -> return "Geomagnetic Rotation Vector"
            Sensor.TYPE_GRAVITY -> return "Gravity"
            Sensor.TYPE_GYROSCOPE -> return "Gyroscope"
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED -> return "Gyroscope Uncalibrated"
            Sensor.TYPE_HEART_RATE -> return "Heart Rate Monitor"
            Sensor.TYPE_LIGHT -> return "Light"
            Sensor.TYPE_LINEAR_ACCELERATION -> return "Linear Acceleration"
            Sensor.TYPE_MAGNETIC_FIELD -> return "Magnetic Field"
            Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED -> return "Magnetic Field Uncalibrated"
            Sensor.TYPE_ORIENTATION -> return "Orientation"
            Sensor.TYPE_PRESSURE -> return "Orientation"
            Sensor.TYPE_PROXIMITY -> return "Proximity"
            Sensor.TYPE_RELATIVE_HUMIDITY -> return "Relative Humidity"
            Sensor.TYPE_ROTATION_VECTOR -> return "Rotation Vector"
            Sensor.TYPE_SIGNIFICANT_MOTION -> return "Significant Motion"
            Sensor.TYPE_STEP_COUNTER -> return "Step Counter"
            Sensor.TYPE_STEP_DETECTOR -> return "Step Detector"
            else -> return "Unknown"
        }
    }
}
