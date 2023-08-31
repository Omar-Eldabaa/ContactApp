package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ContactAdapter(val contData: ArrayList<ContactData>):Adapter<ContactAdapter.viewHolder>() {
    var profileClick :OnClickListener? = null
    class viewHolder (view: View) : ViewHolder(view) {
        var name : TextView = view.findViewById(R.id.person_name)
        var number :TextView = view.findViewById(R.id.person_number)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view =layoutInflater.inflate(R.layout.itemcontact , parent , false)
        return viewHolder(view)

    }

    override fun getItemCount(): Int {
       return contData.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = contData.get(position)
        holder.name.text = item.personName
        holder.number.text = item.personNumber
        holder.itemView.setOnClickListener(){
            profileClick?.onClicked(item)

        }



    }
}