package com.e.livedataexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e.livedataexp.model.Saveconfig
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vobj = ViewModelProvider(this).get(Saveconfig::class.java)
        textView.text = vobj.incre.toString()
        start_button.setOnClickListener {
            vobj.starttimer()
            //starttimerr()
        }

        stop_button.setOnClickListener {

            vobj.stoptimer()
        }

        // receiving updated data from view model
        vobj.starttimer().observe(this, Observer {
            textView.text = vobj.incre.value.toString()

        })

    }
}