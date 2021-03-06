/**
 * Created by derek on 4/4/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;

import com.example.qnmd.BuildConfig;
import com.example.qnmd.LoginActivity;
import com.example.qnmd.Main2Activity;
import com.example.qnmd.QuizActivity;
import com.example.qnmd.R;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class QuizActivityTest {
    private EditText ed1;
    private EditText ed2;
    private Button b1;
    //private Button b2;

    @Before
    public void setUp() {


        Intent intent=new Intent();
        intent.putExtra("classname","Classroom1");
        Activity activity = Robolectric.buildActivity(QuizActivity.class,intent).create().get();


        b1 = (Button) activity.findViewById(R.id.submit);
        ed1 = (EditText) activity.findViewById(R.id.choice1);
        ed2 = (EditText) activity.findViewById(R.id.choice2);
        //b2 = (Button) activity.findViewById(R.id.button2);
    }
    @Test
    public void Success() {
        ed1.setText("1");
        ed2.setText("1");
        b1.performClick();

        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        Assert.assertEquals("Quiz uploaded! ", ShadowToast.getTextOfLatestToast());
    }

    @Test
    public void SubmitWithEmptyText() {
        b1.performClick();

        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        //assertThat("Next activity should not started", application.getNextStartedActivity(), is(nullValue()));
        assertThat("Show error for question ", ed1.getError(), is(CoreMatchers.notNullValue()));
        assertThat("Show error for option ", ed2.getError(), is(CoreMatchers.notNullValue()));
    }


}
