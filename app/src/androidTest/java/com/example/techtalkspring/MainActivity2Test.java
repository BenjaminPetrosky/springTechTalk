package com.example.techtalkspring;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivity2Test {

    public static final String STRING_NAME_TEST = "James Stark the awesome developer guy, such programming!, Much WOW!";

    @Rule public ActivityScenarioRule<MainActivity2> activity2ActivityScenarioRule
            = new ActivityScenarioRule<>(MainActivity2.class);

    @Test
    public void changeName_nextActivity() {

        // Simulate text typed then submit
        onView(withId(R.id.edtTxtPersonName)).perform(clearText());
        onView(withId(R.id.edtTxtPersonName)).perform(typeText(STRING_NAME_TEST), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());

        /*
        Note: This program is for demonstration purposes only. In this case we did not limit
        the number of characters a user can type. So the test is merely testing that the text
        in the field is accurate and not that it is within a certain window. As you may see the
        string cuts off.
         */

        // Check if the next activity displays successfully
        onView(withId(R.id.tvName)).check(matches(withText(STRING_NAME_TEST)));
    }


    @Test
    public void isTeacherSwitchDefault_nextActivity () {

        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.tvRole)).check(matches(withText("Is a teacher.")));

    }

    @Test
    public void isTeacherSwitch_nextActivity () {

        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.tvRole)).check(matches(withText("Is a teacher.")));
        pressBack();

        onView(withId(R.id.btnSwitch)).perform(click()).perform(click());
        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.tvRole)).check(matches(withText("Is a teacher.")));

    }

    @Test
    public void isStudentSwitch_nextActivity () {

        onView(withId(R.id.btnSwitch)).perform(click());
        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.tvRole)).check(matches(withText("Is a student.")));

    }


}