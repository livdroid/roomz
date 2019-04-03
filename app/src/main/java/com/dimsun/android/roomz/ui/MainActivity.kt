package com.dimsun.android.roomz.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dimsun.android.roomz.R
import com.dimsun.android.roomz.data.entity.Contact
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<ContactsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.contacts_recycler_view)
        val adapter = ContactRecyclerAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.allContacts.observe(this, Observer { contact ->
            // Update the cached copy of the words in the adapter.
            contact?.let { adapter.setContacts(it) }
        })

        button.setOnClickListener {
            viewModel.insert(
                Contact(
                    0,
                    "Jane",
                    "Doe",
                    "09 02 03 02 92",
                    "jane.doe@ada.com"
                )
            )
        }

        button.setOnLongClickListener { viewModel.deleteAll() }
    }
}
