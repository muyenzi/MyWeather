package com.moringaschool.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClothingActivity extends AppCompatActivity {

    public static final String TAG = ClothingActivity.class.getSimpleName();
    private String description;

    @BindView(R.id.avatar) ImageView mImage;
    @BindView(R.id.suggestedText) TextView mSuggestedText;
    @BindView(R.id.bike) ImageView mBike;
    @BindView(R.id.walk) ImageView mWalk;
    @BindView(R.id.car) ImageView mCar;
    @BindView(R.id.umbrella) ImageView mUmbrella;
    @BindView(R.id.scarf) ImageView mScarf;
    @BindView(R.id.glasses) ImageView mGlasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        ButterKnife.bind(this);

        String gender = MainActivity.gender;


        Intent intent = getIntent();
        String tempString = intent.getStringExtra("temp");
        Double temperature = new Double(tempString);
        description = intent.getStringExtra("description");

        switch(gender){
            case "male":
                if (temperature<=10.000){
                    int imageResource = getResources().getIdentifier("@drawable/mharshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay extra covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>10.000 && temperature<=15.900){
                    int imageResource = getResources().getIdentifier("@drawable/mwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay well covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>15.900 && temperature<=18.900){
                    int imageResource = getResources().getIdentifier("@drawable/mcold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>18.900 && temperature<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/mwarm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("wear something warm.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>20.900 && temperature<=22.900){
                    int imageResource = getResources().getIdentifier("@drawable/mcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's cool outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (temperature>22.900 && temperature<=26.900){
                    int imageResource = getResources().getIdentifier("@drawable/msunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (temperature>30.900 && temperature<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/msunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's very hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (temperature>35.900){
                    int imageResource = getResources().getIdentifier("@drawable/mextrasunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's extra hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else {
                    Log.d(TAG," error male");
                }
                break;
            case "female":
                if (temperature<=10.000){
                    int imageResource = getResources().getIdentifier("@drawable/fharshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay extra covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>10.000 && temperature<=15.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay well covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>15.900 && temperature<=18.900){
                    int imageResource = getResources().getIdentifier("@drawable/fwarm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>18.900 && temperature<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/fmoderatewarm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("wear something warm.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (temperature>20.900 && temperature<=22.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcool",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's cool outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (temperature>22.900 && temperature<=26.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (temperature>30.900 && temperature<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/fsunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's very hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (temperature>35.900){
                    int imageResource = getResources().getIdentifier("@drawable/fextrasunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's extra hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
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

    private void recommendation() {

        if (description.toLowerCase().equals("rain")){
            System.out.println("description"+description);

            Log.i(TAG,"description: "+description);

            mCar.setVisibility(View.VISIBLE);  // make image visible

            mGlasses.setVisibility(View.GONE); // hide image (make the view gone)

            mUmbrella.setVisibility(View.VISIBLE);  // make image visible

            mBike.setVisibility(View.GONE);  // hide image (make the view gone)

            mWalk.setVisibility(View.GONE);  // make image invisible

        } else if (description.toLowerCase().equals("clouds")){
            System.out.println("description: "+description);

            mBike.setVisibility(View.VISIBLE);

            mGlasses.setVisibility(View.GONE);

            mUmbrella.setVisibility(View.GONE);  // make image visible

            mWalk.setVisibility(View.VISIBLE);

            mCar.setVisibility(View.VISIBLE);

        } else if (description.toLowerCase().equals("clear")){
            System.out.println("description: "+description);

            mBike.setVisibility(View.VISIBLE);

            mUmbrella.setVisibility(View.GONE);  // make image visible

            mWalk.setVisibility(View.VISIBLE);

            mGlasses.setVisibility(View.VISIBLE);

            mCar.setVisibility(View.VISIBLE);
        } else {
            System.out.println("description:        "+description.toLowerCase());

            mBike.setVisibility(View.VISIBLE);

            mUmbrella.setVisibility(View.VISIBLE);  // make image visible

            mGlasses.setVisibility(View.GONE);

            mWalk.setVisibility(View.VISIBLE);

            mCar.setVisibility(View.VISIBLE);
        }

    }

}