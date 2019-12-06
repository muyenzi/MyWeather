package com.moringaschool.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.welcome) Button mWelcome;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
        mWelcome.startAnimation(anim);

        mWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this,GenderActivity.class);
                startActivity(intent);
            }
        });
    }
}
