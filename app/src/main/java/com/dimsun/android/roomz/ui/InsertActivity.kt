package com.dimsun.android.roomz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dimsun.android.roomz.R
import kotlinx.android.synthetic.main.activity_insert.*
import org.koin.android.viewmodel.ext.android.viewModel

class InsertActivity : AppCompatActivity() {

    private val model: ContactCreationViewModel  by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        insert_button.setOnClickListener {
            insert_button.isClickable = false
            model.onValidateButtonClicked(
            insert_first_name_et.text.toString(),
            insert_last_name_et.text.toString(),
            insert_number_et.text.toString(),
            insert_email_et.text.toString()
        )
        finish()}
    }

}
