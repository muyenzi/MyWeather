package com.moringaschool.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
public class GenderActivity extends AppCompatActivity  implements View.OnClickListener {
    public static final String TAG = GenderActivity.class.getSimpleName();

    @BindView(R.id.maleProfile) LinearLayout mMaleProfile;
    @BindView(R.id.femaleProfile) LinearLayout mFemaleProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_gender );
        ButterKnife.bind( this );
        mMaleProfile.setOnClickListener( this );
        mFemaleProfile.setOnClickListener( this );
    }
    @Override
    public void onClick(View v) {
        if (v == mMaleProfile) {
            Intent intent = new Intent( GenderActivity.this , MainActivity.class );
            intent.putExtra( "gender" , "male" );
            Log.i( TAG , "male avatar selected" );
            startActivity( intent );
        }
        if (v == mFemaleProfile) {
            Intent intent = new Intent( GenderActivity.this , MainActivity.class );
            intent.putExtra( "gender" , "female" );
            Log.i( TAG , "female avatar selected" );
            startActivity( intent );
        }
    }
}