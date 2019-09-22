package com.dimsun.android.roomz

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.dimsun.android.roomz.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest{

    @Rule
    @JvmField
    val rule  = ActivityTestRule(MainActivity::class.java)

    private val empty = ""
    private val lastname ="Nom de famille"
    private val firstname ="Prenom"
    private val phone_correct_format = "0123456789"
    private val phone_bad_format = "000"
    private val email_correct_format = "test@test.com"
    private val email_bad_format = "test.com"

    @Test
    fun insertSuccess(){
        Espresso.onView(withId(R.id.main_button))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.insert_first_name_et))
            .perform(ViewActions.typeText(firstname))

        Espresso.onView((withId(R.id.insert_last_name_et)))
            .perform(ViewActions.typeText(lastname))

        Espresso.onView(withId(R.id.insert_number_et))
            .perform(ViewActions.typeText(phone_correct_format))

        Espresso.onView(withId(R.id.insert_email_et))
            .perform(ViewActions.typeText(email_correct_format))

        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.insert_button))
            .perform(ViewActions.click())
    }

    @Test
    fun insertNewContactAndFailedWithEmptyEmail(){
        Espresso.onView(withId(R.id.main_button))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.insert_first_name_et))
            .perform(ViewActions.typeText(firstname))

        Espresso.onView((withId(R.id.insert_last_name_et)))
            .perform(ViewActions.typeText(lastname))

        Espresso.onView(withId(R.id.insert_number_et))
            .perform(ViewActions.typeText(phone_correct_format))

        Espresso.onView(withId(R.id.insert_email_et))
            .perform(ViewActions.typeText(empty))

        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.insert_button))
            .perform(ViewActions.click())
    }

    @Test
    fun insertNewContactAndFailedWithWrongEmailFormat(){
        Espresso.onView(withId(R.id.main_button))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.insert_first_name_et))
            .perform(ViewActions.typeText(firstname))

        Espresso.onView((withId(R.id.insert_last_name_et)))
            .perform(ViewActions.typeText(lastname))

        Espresso.onView(withId(R.id.insert_number_et))
            .perform(ViewActions.typeText(phone_correct_format))

        Espresso.onView(withId(R.id.insert_email_et))
            .perform(ViewActions.typeText(email_bad_format))

        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.insert_button))
            .perform(ViewActions.click())
    }

    @Test
    fun insertNewContactAndFailedWithWrongPhoneFormat(){
        Espresso.onView(withId(R.id.main_button))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.insert_first_name_et))
            .perform(ViewActions.typeText(firstname))

        Espresso.onView((withId(R.id.insert_last_name_et)))
            .perform(ViewActions.typeText(lastname))

        Espresso.onView(withId(R.id.insert_number_et))
            .perform(ViewActions.typeText(phone_bad_format))

        Espresso.onView(withId(R.id.insert_email_et))
            .perform(ViewActions.typeText(email_correct_format))

        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.insert_button))
            .perform(ViewActions.click())
    }

    @Test
    fun deleteAllContactsButton(){

        insertSuccess()

        Espresso.onView(withId(R.id.main_button))
            .perform(ViewActions.longClick())
    }
}