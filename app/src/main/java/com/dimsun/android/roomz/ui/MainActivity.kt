package com.dimsun.android.roomz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimsun.android.roomz.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val model: ContactsViewModel  by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.contacts_recycler_view)
        val adapter = ContactRecyclerAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        model.allContacts.observe(this, Observer { contact ->
            // Update the cached copy of the words in the adapter.
            if(contact != null) { adapter.setContacts(contact) }
        })

        button.setOnClickListener {
            model.insertSampleContact()
        }

        button.setOnLongClickListener { model.deleteAll() }
    }
}
