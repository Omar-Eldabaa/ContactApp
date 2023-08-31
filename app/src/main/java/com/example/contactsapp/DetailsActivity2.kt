package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity2 : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var phone : TextView
    lateinit var description : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details2)
        name=findViewById(R.id.Profile_Name)
        phone=findViewById(R.id.Profile_Phone)
        description=findViewById(R.id.Profile_Description)
        name.text = intent?.getStringExtra("name")
        phone.text= intent?.getStringExtra("phone")
        description.text=intent?.getStringExtra("description")




    }
}