package xyz.vadviktor.sensordemo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_LIGHT)
        var sensors = ""
        if (deviceSensors.isEmpty()) {
            tvSensorList.text = "no such sensor"
        } else {
            for (sensor in deviceSensors) {
                sensors = sensors.plus("${sensor.name}\n\n")
            }
            tvSensorList.text = sensors
        }
    }
}
