package com.moringaschool.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityClothingActivity extends AppCompatActivity {

    public static final String TAG = CityClothingActivity.class.getSimpleName();
    @BindView(R.id.avatar)
    ImageView mImage;

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
//        String gender = intent.getStringExtra("gender");


        Double mMaxTemp = Double.parseDouble(maxStringTemp);
        Double mMinTemp = Double.parseDouble(minStringTemp);


//        Double mMaxTemp = Double.parseDouble(maxStringTemp);
//        Double mMinTemp = Double.parseDouble(minStringTemp);

        switch(gender){
            case "male":
                if (mMaxTemp<=5.000){
                    int imageResource = getResources().getIdentifier("@drawable/harshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>5.000 && mMaxTemp<=10.900){
                    int imageResource = getResources().getIdentifier("@drawable/winter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>10.900 && mMaxTemp<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/cold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>20.900 && mMaxTemp<=25.900){
                    int imageResource = getResources().getIdentifier("@drawable/warm",null,this.getPackageName());
                    mImage.setImageResource(imageResource);


                    Log.i(TAG,"SUCcESS");

                }
                else if (mMinTemp>25.900 && mMaxTemp<=30.900){
                    int imageResource = getResources().getIdentifier("@drawable/casual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>30.900 && mMaxTemp<=35.900){

                    int imageResource = getResources().getIdentifier("@drawable/sunny",null,this.getPackageName());

//                    int imageResource = getResources().getIdentifier("@drawable/msunny",null,this.getPackageName());

                    mImage.setImageResource(imageResource);
                }
                else if (mMaxTemp>35.900){
                    int imageResource = getResources().getIdentifier("@drawable/extrasunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else {
                    Log.d(TAG," error male");
                }
                break;



            case "female":
                if (mMaxTemp<=5.000){
                    int imageResource = getResources().getIdentifier("@drawable/fharshwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>5.000 && mMaxTemp<=10.900){
                    int imageResource = getResources().getIdentifier("@drawable/fwinter",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>10.900 && mMaxTemp<=20.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcold",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>20.900 && mMaxTemp<=25.900){

                    int imageResource = getResources().getIdentifier("@drawable/fwarm",null,this.getPackageName());

//                    int imageResource = getResources().getIdentifier("@drawable/fcasual",null,this.getPackageName());

                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>25.900 && mMaxTemp<=30.900){
                    int imageResource = getResources().getIdentifier("@drawable/fcasual",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMinTemp>30.900 && mMaxTemp<=35.900){
                    int imageResource = getResources().getIdentifier("@drawable/fsunny",null,this.getPackageName());
                    mImage.setImageResource(imageResource);
                }
                else if (mMaxTemp>35.900){
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



