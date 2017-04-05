package pl.edu.pwr.lab1zimny.lab1;

import android.graphics.Color;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by KubaLaptop on 26.03.2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BMICalculatorTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void isMetricsSwtichClickable(){
        //metrics switch should be clickable
        onView(withId(R.id.metricsSpinner)).check(matches(isClickable()));
    }

    @Test
    public void isCalculateButtonClickable(){
        //calculate button should be clickable
        onView(withId(R.id.calculate)).check(matches(isClickable()));
    }

    @Test
    public void isResultVisibleAfterClickOnCalculate(){
        //when calculate is clicked
        onView(withId(R.id.calculate)).perform(click());
        //result view should be displayed
        onView(withId(R.id.result)).check(matches(isDisplayed()));
    }

    @Test
    public void isKGMCalculatorDoingGood(){
        onView(withId(R.id.heightInput)).perform(clearText());
        //when height is typed
        onView(withId(R.id.heightInput)).perform(typeText("1.8"));
        onView(withId(R.id.massInput)).perform(clearText());
        //when mass is typed
        onView(withId(R.id.massInput)).perform(typeText("80"));
        //when calculate is clicked
        onView(withId(R.id.calculate)).perform(click());
        //then result should be displayed
        onView(withId(R.id.result)).check(matches(withText("24.69136")));
    }

    private void selectSpinnerText(int id, String text) {
        onView(withId(id)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(text))).perform(click());
        onView(withId(id)).check(matches(withSpinnerText(containsString(text))));
    }

    @Test
    public void isLBINCalculatorDoingGood(){
        onView(withId(R.id.heightInput)).perform(clearText());
        //when metrics is changed
        selectSpinnerText(R.id.metricsSpinner, "imperial (lb/in)");
        //when height is typed
        onView(withId(R.id.heightInput)).perform(typeText("80"));
        onView(withId(R.id.massInput)).perform(clearText());
        //when mass is typed
        onView(withId(R.id.massInput)).perform(typeText("300"));
        //when calculate is clicked
        onView(withId(R.id.calculate)).perform(click());
        //then result should be displayed
        onView(withId(R.id.result)).check(matches(withText("32.953125")));
    }
}

