package com.example.abubucker.myfirstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_api.*
import java.net.URL
import android.os.StrictMode
import org.json.JSONObject


class api : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val response = JSONObject( URL("http://ndev.tmmmt.com/api/appversion/am").readText())
        textView.text=response.getString("status")
        /* intent.getStringExtra("username")*/
       /* textView.setOnClickListener{
            Toast.makeText(this,"Rejeeya Begam",Toast.LENGTH_SHORT).show()

        }*/
    }
}
