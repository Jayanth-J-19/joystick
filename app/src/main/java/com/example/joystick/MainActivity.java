package com.example.joystick;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    SharedPreferences sp;
    RelativeLayout layout_joystick, layout_joystick2;
    TextView textView1, textView2, textView3, textView4;

    ObjectAnimator animatebally,animateballx;

    JoyStickClass js;
    JoyStickClass js2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);


        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);

        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        layout_joystick = (RelativeLayout)findViewById(R.id.layout_joystick);


        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.image_button);
        js.setStickSize(150, 150);
        js.setLayoutSize(400, 400);
        js.setLayoutAlpha(150);
        js.setStickAlpha(100);
        js.setOffset(-50);
        js.setMinimumDistance(50);


        layout_joystick2 = (RelativeLayout)findViewById(R.id.layout_joystick2);


        js2 = new JoyStickClass(getApplicationContext(), layout_joystick2, R.drawable.image_button);
        js2.setStickSize(150, 150);
        js2.setLayoutSize(400, 400);
        js2.setLayoutAlpha(150);
        js2.setStickAlpha(100);
        js2.setOffset(-50);
        js2.setMinimumDistance(50);

        //infinite loop checker for every 100ms of the joystick's direction
        //this is done through the use of sharedpreferences (saved data when we putString() at ontouchlistener)
        //we use ObjectAnimator to move the ball according to joystick's direction
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //personal settings (avatar movement)
                float slowspeed = 3; //increase this value to make the speed slower


                handler1.postDelayed(this, 100);
            }
        }, 10);



        layout_joystick.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                textView1.setText("X : 1500");
                textView2.setText("Y : 1500");
                SharedPreferences.Editor editor2 = sp.edit();
                editor2.putString("joystickdirection", "stop");
                editor2.apply();
                js.drawStick(arg1);
                if(arg1.getAction() == MotionEvent.ACTION_DOWN
                        || arg1.getAction() == MotionEvent.ACTION_MOVE) {
                    textView1.setText("C3T : " + String.valueOf(js.getX()));
                    textView2.setText("C4Y : " + String.valueOf(js.getY()));


                    int direction = js.get8Direction();
                    if(direction == JoyStickClass.STICK_UP) {
                        //this saves the joystick direction to the string "joystickdirection"
                        //it is retrievable using sp.getString("joystickdirection","0");
                        //"0" is the default return when string is null (i.e. empty).
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "up");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_UPRIGHT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "upright");
                        editor.apply();


                    } else if(direction == JoyStickClass.STICK_RIGHT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "right");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_DOWNRIGHT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "downright");
                        editor.apply();
                    } else if(direction == JoyStickClass.STICK_DOWN) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "down");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_DOWNLEFT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "downleft");
                        editor.apply();
                    } else if(direction == JoyStickClass.STICK_LEFT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "left");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_UPLEFT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "upleft");
                        editor.apply();
                    } else if(direction == JoyStickClass.STICK_NONE) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "stop");
                        editor.apply();
                    }
                } else if(arg1.getAction() == MotionEvent.ACTION_UP) {
                    textView1.setText("C3T : 1500");
                    textView2.setText("C4Y : 1500");

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("joystickdirection", "stop");
                    editor.apply();
                }
                return true;
            }
        });

        layout_joystick2.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                textView3.setText("X : 1500");
                textView4.setText("Y : 1500");
                SharedPreferences.Editor editor2 = sp.edit();
                editor2.putString("joystickdirection", "stop");
                editor2.apply();
                js2.drawStick(arg1);
                if(arg1.getAction() == MotionEvent.ACTION_DOWN
                        || arg1.getAction() == MotionEvent.ACTION_MOVE) {
                    textView3.setText("C2P : " + String.valueOf(js2.getX()));
                    textView4.setText("C1R : " + String.valueOf(js2.getY()));


                    int direction = js2.get8Direction();
                    if(direction == JoyStickClass.STICK_UP) {
                        //this saves the joystick direction to the string "joystickdirection"
                        //it is retrievable using sp.getString("joystickdirection","0");
                        //"0" is the default return when string is null (i.e. empty).
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "up");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_UPRIGHT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "upright");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_RIGHT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "right");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_DOWNRIGHT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "downright");
                        editor.apply();
                    } else if(direction == JoyStickClass.STICK_DOWN) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "down");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_DOWNLEFT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "downleft");
                        editor.apply();
                    } else if(direction == JoyStickClass.STICK_LEFT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "left");
                        editor.apply();

                    } else if(direction == JoyStickClass.STICK_UPLEFT) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "upleft");
                        editor.apply();
                    } else if(direction == JoyStickClass.STICK_NONE) {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("joystickdirection", "stop");
                        editor.apply();
                    }
                } else if(arg1.getAction() == MotionEvent.ACTION_UP) {
                    textView3.setText("X : 1500");
                    textView4.setText("Y : 1500");

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("joystickdirection", "stop");
                    editor.apply();
                }
                return true;
            }
        });
    }
}