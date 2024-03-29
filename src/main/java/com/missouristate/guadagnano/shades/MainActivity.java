package com.missouristate.guadagnano.shades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import static com.missouristate.guadagnano.shades.R.*;

public class MainActivity extends AppCompatActivity {
    private ConstraintSet set;
    private ConstraintLayout layout;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(id.CL_1);
        layout.setBackgroundColor(Color.parseColor("#c89b6d"));
        buildGUIByCod();
    }
//Used to create the buttons and the design of the app
    private void buildGUIByCod() {
        set = new ConstraintSet();
        set.clone(layout);

        //Button1
        button1 = new Button(this);
        button1.setText(getString(string.plum));
        button1.setId(View.generateViewId());
        button1.setTag("btn1");
        button1.setBackgroundColor(Color.parseColor("#ac7d50"));
        button1.setOnClickListener(ShadeChangeListener);
        layout.addView(button1);
        //Creates the buttons constraints
        set.connect(button1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50);
        set.connect(button1.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,0);
        set.connect(button1.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(button1.getId(), 200);
        set.applyTo(layout);

        //Button2
        button2 = new Button(this);
        button2.setText(getString(string.blue));
        button2.setId(View.generateViewId());
        button2.setTag("btn2");
        button2.setBackgroundColor(Color.parseColor("#ac7d50"));
        button2.setOnClickListener(ShadeChangeListener);
        layout.addView(button2);
        //Creates the buttons constraints
        set.connect(button2.getId(), ConstraintSet.TOP, button1.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(button2.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,0);
        set.connect(button2.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,0);
        set.constrainHeight(button2.getId(), 200);
        set.applyTo(layout);

        //Button3
        button3 = new Button(this);
        button3.setText(getString(string.gold));
        button3.setId(View.generateViewId());
        button3.setTag("btn3");
        button3.setBackgroundColor(Color.parseColor("#ac7d50"));
        button3.setOnClickListener(ShadeChangeListener);
        layout.addView(button3);
        //Creates the buttons constraints
        set.connect(button3.getId(), ConstraintSet.TOP, button2.getId(), ConstraintSet.BOTTOM, 10);
        set.connect(button3.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,0);
        set.connect(button3.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.constrainHeight(button3.getId(), 200);
        set.applyTo(layout);

    }

    private View.OnClickListener ShadeChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);

            switch ((String) v.getTag()){
                case "btn1":
                    textView.setText(string.plum_is);
                    break;
                case "btn2":
                    textView.setText(string.blue_is);
                    break;
                case "btn3":
                    textView.setText(string.gold_is);
                    break;
            }

            textView.setBackgroundColor(Color.parseColor("#ac7d50"));
            textView.setId(View.generateViewId());
            layout.addView(textView);

            set.connect(textView.getId(), ConstraintSet.TOP, button3.getId(), ConstraintSet.BOTTOM, 50);
            set.connect(textView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
            set.connect(textView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,0);
            set.constrainHeight(textView.getId(), 400);
            set.applyTo(layout);

            setContentView(layout);
        }
    };

}





