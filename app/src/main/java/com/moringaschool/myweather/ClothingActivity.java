package com.moringaschool.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClothingActivity extends AppCompatActivity {
    public static final String TAG = ClothingActivity.class.getSimpleName();

    @BindView(R.id.avatar) ImageView mImage;
    @BindView(R.id.suggestedText) TextView mSuggestedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        ButterKnife.bind(this);

        String gender = MainActivity.gender;


        Intent intent = getIntent();
        String tempString = intent.getStringExtra("temp");
        Double temperature = new Double(tempString);

        switch(gender){
            case "male":
                if (temperature<=5.000){
                    int imageResource = getResources().getIdentifier("@drawable/harshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay extra covered.");
                }
                else if (temperature>5.000 && temperature<=10.900){
                    int imageResource = getResources().getIdentifier("@drawable/winter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay well covered.");
                }
                else if (temperature>10.900 && temperature<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/cold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay very warm.");
                }
                else if (temperature>20.900 && temperature<=25.900){
                    int imageResource = getResources().getIdentifier("@drawable/warm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay warm");
                    Log.i(TAG,"SUCcESS");
                }
                else if (temperature>25.900 && temperature<=30.900){
                    int imageResource = getResources().getIdentifier("@drawable/casual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's cool outside.");
                }
                else if (temperature>30.900 && temperature<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/msunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's hot outside.");
                }
                else if (temperature>35.900){
                    int imageResource = getResources().getIdentifier("@drawable/extrasunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's very hot outside.");
                }
                else {
                    Log.d(TAG," error male");
                }
                break;
            case "female":
                if (temperature<=5.000){
                    int imageResource = getResources().getIdentifier("@drawable/fharshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (temperature>5.000 && temperature<=10.900){
                    int imageResource = getResources().getIdentifier("@drawable/fwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (temperature>10.900 && temperature<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (temperature>20.900 && temperature<=25.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (temperature>25.900 && temperature<=30.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (temperature>30.900 && temperature<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/fsunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (temperature>35.900){
                    int imageResource = getResources().getIdentifier("@drawable/fextrasunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else {
                    Log.d(TAG," error female");
                }
                break;
            default:
                Log.d(TAG,"Error");
                break;
        }
    }
}