package com.example.contactsapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var nameP: EditText
    lateinit var numberP:EditText
    lateinit var descriptionP:EditText
    lateinit var btn : Button
    lateinit var data: ArrayList<ContactData>
    lateinit var adapter: ContactAdapter

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycler_view)
        nameP = findViewById(R.id.name)
        numberP=findViewById(R.id.number)
        descriptionP= findViewById(R.id.description)
        btn= findViewById(R.id.add_button)
        data = ArrayList()
        adapter= ContactAdapter(data)
        recyclerView.adapter =adapter
        adapter.profileClick = object : OnClickListener {
            override fun onClicked(data: ContactData) {
                val intent = Intent(this@MainActivity , DetailsActivity2::class.java)
                intent.putExtra("name", data.personName)
                intent.putExtra("phone" , data.personNumber)
                intent.putExtra("description",data.description)
                startActivity(intent)


            }

        }



        btn.setOnClickListener {
            var name = nameP.text.toString().trim()
            var phone =numberP.text.toString().trim()
            var description =descriptionP.text.toString().trim()

//        val newContact = ContactData(name,phone,description)
//            data.add(newContact)
            if (name.length<3){
                Toast.makeText(this , "Name should be a 3 characters or more ",Toast.LENGTH_SHORT).show()
            }
            else if(phone.length<11){
                Toast.makeText(this , "Phone should be a 11 Number ",Toast.LENGTH_SHORT).show()

            }else{

            data.add(ContactData(name,phone,description))
            adapter.notifyDataSetChanged()
             clear()
            }

        }
    }
    fun clear(){
        nameP.setText("")
        numberP.setText("")
        descriptionP.setText("")

    }

}