package com.rc.rustandroidbuild

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), JNICallback {
    init {
        System.loadLibrary("rust")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        invokeCallbackViaJNI(this)
    }

    /**
     * A native method that is implemented by the 'rust' native library,
     * which is packaged with this application.
     */
    external fun invokeCallbackViaJNI(callback: JNICallback)


    override fun callback(string: String) {
        val textView = findViewById<View>(R.id.helloLabel) as TextView
        textView.append("From JNI: $string\n")
    }
}