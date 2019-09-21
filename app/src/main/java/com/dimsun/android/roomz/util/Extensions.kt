package com.dimsun.android.roomz.util

import android.util.Patterns
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Pattern

fun AppCompatEditText?.toNameError() {
    if(!this?.text.isValidName()) {
        this?.error = "This field cannot be empty"
    }
}

fun AppCompatEditText?.toEmailError() {
    if(!this?.text.isValidEmail()) {
        this?.error = "This field cannot be empty"
    }
}

fun AppCompatEditText?.toPhoneError() {
    if(!this?.text.isValidNumber()) {
        this?.error = "This field cannot be empty"
    }
}

fun CharSequence?.isValidNumber() : Boolean {
    val patternPhone = Pattern.compile("^([0-9]{10})")
    return patternPhone.matcher(this).matches()
}

fun CharSequence?.isValidEmail()  : Boolean{
    val patternEmail = Patterns.EMAIL_ADDRESS
    return patternEmail.matcher(this).matches()
}

fun CharSequence?.isValidName() : Boolean {
    return this != null && this.isNotEmpty()
}