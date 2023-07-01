package com.example.demowithtest.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.action.ViewActions.typeText
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
public class LoginFailureActivityEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun shouldShowEmptyMessageErrorWhenFieldsAreEmpty() {
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.edtPassword)).check(matches(hasErrorText("This field is empty")))
        onView(withId(R.id.edtEmail)).check(matches(hasErrorText("This field is empty")))
    }

    @Test
    fun shouldShowValidationMessageErrorWhenEmailFieldIsInvalid() {
        onView(withId(R.id.edtEmail)).perform(typeText("tw@"))
        onView(withId(R.id.edtPassword)).perform(typeText("CorrectPassword123456"))

        onView(withId(R.id.scrollView)).perform(swipeUp())
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.edtEmail)).check(matches(hasErrorText("Please fill your email correctly")))
    }

    @Test
    fun shouldShowValidationMessageErrorWhenPasswordFieldIsInvalid() {
        onView(withId(R.id.edtEmail)).perform(typeText("tw@tw.com"))
        onView(withId(R.id.edtPassword)).perform(typeText("wrongPass"))

        onView(withId(R.id.scrollView)).perform(swipeUp())
        onView(withId(R.id.btnLogin)).perform(click())

        onView(withId(R.id.edtPassword)).check(matches(hasErrorText("Your password must have at least 8 characters with letters and numbers")))
    }

}