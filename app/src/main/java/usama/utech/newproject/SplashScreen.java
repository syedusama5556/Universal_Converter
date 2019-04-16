package usama.utech.newproject;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import usama.utech.newproject.MainActivity;
import usama.utech.newproject.R;


public class SplashScreen extends AppCompatActivity {

    RelativeLayout relativeLayout;
    int splash_screen_timeout = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        relativeLayout = (RelativeLayout) findViewById(R.id.ret);
        // ImageView image = (ImageView)findViewById(R.id.utech); //or we can use this instead of relative-layout
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_animation);
        relativeLayout.startAnimation(animation);

        new CountDownTimer(splash_screen_timeout, 1000) {
            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


                finish();

            }

            @Override
            public void onTick(long l) {

            }
        }.start();

    }


}




