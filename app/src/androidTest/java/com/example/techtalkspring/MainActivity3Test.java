package com.example.techtalkspring;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.annotation.ContentView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import java.security.PublicKey;

public class MainActivity3Test {

    public static final String STRING_NAME_CHANGE = "Billy Bob";

    @Rule public ActivityScenarioRule<MainActivity3> activity3ActivityScenarioRule = new ActivityScenarioRule<>(MainActivity3.class);

    @Test
    public void changeName_sameActivity() {

        onView(withId(R.id.edtTxtPersonNameChange)).perform(clearText());
        onView(withId(R.id.edtTxtPersonNameChange)).perform(typeText(STRING_NAME_CHANGE));
        onView(withId(R.id.btnNameChange)).perform(click());

        onView(withId(R.id.tvName)).check(matches(withText(STRING_NAME_CHANGE)));

    }

    @Test
    public void changeRole_sameActivity() {

        onView(withId(R.id.switchRole)).perform(click());
        onView(withId(R.id.btnChangeTS)).perform(click());
        onView(withId(R.id.tvRole)).check(matches(withText("Is a student.")));

    }

}