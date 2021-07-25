package com.jack.googlehuawei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jack.googlehuawei.service.ServiceChecker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (ServiceChecker.getAvailableService(this)) {
            ServiceChecker.Type.Google -> {
                message.text = "this device have google play"
            }
            ServiceChecker.Type.Huawei ->{
                message.text = "this device have huawei app gallary"
            }
            else -> {
                message.text = "unknown found"
            }
        }
    }
}