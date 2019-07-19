package com.dimsun.android.roomz.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dimsun.android.roomz.R
import com.dimsun.android.roomz.data.entity.Contact

class ContactRecyclerAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<ContactRecyclerAdapter.ContactViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var contacts = emptyList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = inflater.inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val current = contacts[position]
        holder.bind(current)
    }

    internal fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount() = contacts.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val firstName: TextView = itemView.findViewById(R.id.firstname_tv)
        val lastName: TextView = itemView.findViewById(R.id.lastname_tv)
        val contact: TextView = itemView.findViewById(R.id.number_tv)
        val email: TextView = itemView.findViewById(R.id.email_tv)

        fun bind(current: Contact) {
            firstName.text = current.firstname
            lastName.text = current.lastname
            contact.text = current.number
            email.text = current.email
        }
    }
}