package com.example.abubucker.myfirstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.abubucker.myfirstkotlinapp.R.id.*
import com.example.abubucker.myfirstkotlinapp.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersDBHelper = UsersDBHelper(this)
        button_add_user.setOnClickListener {
            addUser(activity_main)
        }
        button_delete_user.setOnClickListener{
            deleteUser(activity_main)
        }
        button_show_all.setOnClickListener{
            showAllUsers(activity_main)
        }
    }

    fun addUser(v:View){
        var userid = edittext_userid.text.toString()
        var name = edittext_name.text.toString()
        var age = edittext_age.text.toString()
        var result = usersDBHelper.insertUser(UserModel(userid = userid,name = name,age = age))

        //clear all edittext s

        edittext_age.setText("")
        edittext_name.setText("")
        edittext_userid.setText("")
        textview_result.text = "Added user : "+result
        ll_entries.removeAllViews()
    }

    fun deleteUser(v:View){
        var userid = edittext_userid.text.toString()
        val result = usersDBHelper.deleteUser(userid)
        textview_result.text = "Deleted user : "+result
        ll_entries.removeAllViews()
    }

    fun showAllUsers(v:View){
        var users = usersDBHelper.readAllUsers()
        ll_entries.removeAllViews()
        users.forEach {
            var tv_user = TextView(this)
            tv_user.textSize = 30F
            tv_user.text = it.name.toString() + " - " + it.age.toString()
            ll_entries.addView(tv_user)
        }
        textview_result.text = "Fetched " + users.size + " users"
    }
}


