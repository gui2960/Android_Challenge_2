package com.example.tacom_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        Thread {
            var low = 1
            var high = 1000

            while (low < high) {
                var flag = false
                for (i in 2..low / 2) {
                    if (low % i == 0) {
                        flag = true
                        break
                    }
                }
                if (!flag)
                    sleep(3000)
                    runOnUiThread{
                        Toast.makeText(this, low.toString(), Toast.LENGTH_LONG).show()
                    }
                ++low
                high++
            }
        }.start()
    }
}