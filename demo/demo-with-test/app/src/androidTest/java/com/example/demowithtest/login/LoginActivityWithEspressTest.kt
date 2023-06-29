package com.example.demowithtest.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.demowithtest.R

@RunWith(AndroidJUnit4::class)
public class LoginActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun shouldShowTitleWhenOpenActivity() {
        onView(withText("Login Screen")).check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowLoginButtonWhenOpenActivity() {
        onView(withId(R.id.btnLogin)).check(matches(withText("Login")))
    }

//    @Test
//    fun shouldShowEmptyMessageErrorWhenFieldsAreEmpty() {
//        onView(withId(R.id.btnLogin)).perform(click())
//
//        onView(withId(R.id.edtPassword)).check(matches(hasErrorText("This field is empty")))
//        onView(withId(R.id.edtEmail)).check(matches(hasErrorText("This field is empty")))
//    }

}