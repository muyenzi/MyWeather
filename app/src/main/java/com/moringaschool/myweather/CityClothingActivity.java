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

public class CityClothingActivity extends AppCompatActivity {

    public static final String TAG = CityClothingActivity.class.getSimpleName();
    private String mMain;
    @BindView(R.id.avatar) ImageView mImage;
    @BindView(R.id.suggestedText) TextView mSuggestedText;
    @BindView(R.id.scarf) ImageView mScarf;
    @BindView(R.id.bike) ImageView mBike;
    @BindView(R.id.walk) ImageView mWalk;
    @BindView(R.id.car) ImageView mCar;
    @BindView(R.id.umbrella) ImageView mUmbrella;
    @BindView(R.id.glasses) ImageView mGlasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_clothing);
        ButterKnife.bind(this);


        String gender = MainActivity.gender;


        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        String maxStringTemp = intent.getStringExtra("maxTemp");
        String minStringTemp = intent.getStringExtra("minTemp");
        mMain = intent.getStringExtra("main");
        Double mMaxTemp = Double.parseDouble(maxStringTemp);
        Double mMinTemp = Double.parseDouble(minStringTemp);



        switch(gender){
            case "male":
                if (mMaxTemp<=10.000){
                    int imageResource = getResources().getIdentifier("@drawable/mharshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay extra covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>10.000 && mMaxTemp<=15.900){
                    int imageResource = getResources().getIdentifier("@drawable/mwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay well covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>15.900 && mMaxTemp<=18.900){
                    int imageResource = getResources().getIdentifier("@drawable/mcold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>18.900 && mMaxTemp<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/mwarm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("wear something warm.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>20.900 && mMaxTemp<=22.900){
                    int imageResource = getResources().getIdentifier("@drawable/mcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's cool outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (mMinTemp>22.900 && mMaxTemp<=30.900){
                    int imageResource = getResources().getIdentifier("@drawable/msunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (mMinTemp>30.900 && mMaxTemp<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/msunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's very hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }

                else if (mMaxTemp>35.900){
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
                if (mMaxTemp<=10.000){
                    int imageResource = getResources().getIdentifier("@drawable/fharshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay extra covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>10.000 && mMaxTemp<=15.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay well covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>15.900 && mMaxTemp<=18.900){
                    int imageResource = getResources().getIdentifier("@drawable/fwarm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("stay covered.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>18.900 && mMaxTemp<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/fmoderatewarm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("wear something warm.");
                    mScarf.setVisibility(View.VISIBLE);
                    recommendation();
                }
                else if (mMinTemp>20.900 && mMaxTemp<=22.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcool",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's cool outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (mMinTemp>22.900 && mMaxTemp<=30.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }
                else if (mMinTemp>30.900 && mMaxTemp<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/fsunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                    mSuggestedText.setText("It's very hot outside.");
                    mScarf.setVisibility(View.GONE);
                    recommendation();
                }

                else if (mMaxTemp>35.900){
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

        if (mMain.toLowerCase().equals("rain")){
            System.out.println("description"+mMain);

            Log.i(TAG,"description: "+mMain);

            mCar.setVisibility(View.VISIBLE);  // make image visible

            mGlasses.setVisibility(View.GONE); // hide image (make the view gone)

            mUmbrella.setVisibility(View.VISIBLE);  // make image visible

            mBike.setVisibility(View.GONE);  // hide image (make the view gone)

            mWalk.setVisibility(View.GONE);  // make image invisible

        } else if (mMain.toLowerCase().equals("clouds")){
            System.out.println("description: "+mMain);

            mBike.setVisibility(View.VISIBLE);

            mGlasses.setVisibility(View.GONE);

            mUmbrella.setVisibility(View.GONE);  // make image visible

            mWalk.setVisibility(View.VISIBLE);

            mCar.setVisibility(View.VISIBLE);

        } else if (mMain.toLowerCase().equals("clear")){
            System.out.println("description: "+mMain);

            mBike.setVisibility(View.VISIBLE);

            mUmbrella.setVisibility(View.GONE);  // make image visible

            mWalk.setVisibility(View.VISIBLE);

            mGlasses.setVisibility(View.VISIBLE);

            mCar.setVisibility(View.VISIBLE);
        } else {
            System.out.println("description:        "+mMain.toLowerCase());

            mBike.setVisibility(View.VISIBLE);

            mUmbrella.setVisibility(View.VISIBLE);  // make image visible

            mGlasses.setVisibility(View.GONE);

            mWalk.setVisibility(View.VISIBLE);

            mCar.setVisibility(View.VISIBLE);
        }

    }

}



