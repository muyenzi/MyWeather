package com.moringaschool.myweather.drawer;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.androdocs.httprequest.HttpRequest;
import com.google.android.material.navigation.NavigationView;
import com.moringaschool.myweather.ClothingActivity;
import com.moringaschool.myweather.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
public class LocationActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    String CITY;
    //  eliane's codes
    public static final String TAG = LocationActivity.class.getSimpleName();
    private Double mMaxTemp, mMinTemp;
    private String mDescription;
    private String gender;
    @BindView(R.id.clickForCloth) ImageView mClickForCloth;
    //    end of eliane
//    Intent cheHome = getIntent();
//    String CITY = cheHome.getStringExtra("clothType");
//    Toast.makeText(this, "" + CITY, Toast.LENGTH_SHORT).show();
//    String CITY = "London";
    String API = "4de3768c62b67fe359758977a3efc069";
    TextView addressTxt, updated_atTxt, statusTxt, tempTxt, temp_minTxt, temp_maxTxt, sunriseTxt,
            sunsetTxt;
    //    public  nav_rate
//    @BindView(R.id.clothesTextView) TextView mClothesTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_location );
        ButterKnife.bind( this );
        Intent cheHome = getIntent();
        CITY = cheHome.getStringExtra("clothType");
//        if (! CITY.isEmpty()){
//            CITY = cheHome.getStringExtra("clothType");
//
//
//        }else{
//
//            CITY = "Kigali";
//        }
////        Intent intent = getIntent();
////        String locationName = intent.getStringExtra("locationName");
////
//////        mClothesTextView.setText("For this search "  + " ' "  + locationName   + " ' " + " we have: ");
//
//        Toast.makeText(LocationActivity.this, locationName, Toast.LENGTH_LONG).show();
        addressTxt = findViewById( R.id.address );
        updated_atTxt = findViewById( R.id.updated_at );
        statusTxt = findViewById( R.id.status );
        tempTxt = findViewById( R.id.temp );
        temp_minTxt = findViewById( R.id.temp_min );
        temp_maxTxt = findViewById( R.id.temp_max );
        sunriseTxt = findViewById( R.id.sunrise );
        sunsetTxt = findViewById( R.id.sunset );
        new weatherTask().execute();

//        eliane
//        Intent intent = getIntent();
//        gender = intent.getStringExtra( "gender" );

//        //        eliane
//        Intent intent = getIntent();
//        gender = intent.getStringExtra( "gender" );
////        eliane

        mClickForCloth.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LocationActivity.this , ClothingActivity.class );
//                intent.putExtra( "minTemp" , mMinTemp.toString() );
//                intent.putExtra( "maxTemp" , mMaxTemp.toString() );
//                intent.putExtra( "description" , mDescription );
////                intent.putExtra( "gender" , gender );
//
//                Log.i( TAG , "max: " + mMaxTemp );
//                Log.i( TAG , "min: " + mMaxTemp );
//                Log.i( TAG , mDescription );
////                Log.i( TAG , gender );
//                startActivity( intent );


            }
        } );
//        end of eliane
    }
    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /* Showing the ProgressBar, Making the main design GONE */
            findViewById( R.id.loader ).setVisibility( View.VISIBLE );
            findViewById( R.id.mainContainer ).setVisibility( View.GONE );
            findViewById( R.id.errorText ).setVisibility( View.GONE );
        }
        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet( "https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&units=metric&appid=" + API );
            return response;
        }
        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObj = new JSONObject( result );
                JSONObject main = jsonObj.getJSONObject( "main" );
                JSONObject sys = jsonObj.getJSONObject( "sys" );
                JSONObject wind = jsonObj.getJSONObject( "wind" );
                JSONObject weather = jsonObj.getJSONArray( "weather" ).getJSONObject( 0 );
                Long updatedAt = jsonObj.getLong( "dt" );
                String updatedAtText = "Updated at: " + new SimpleDateFormat( "dd/MM/yyyy hh:mm a" , Locale.ENGLISH ).format( new Date( updatedAt * 1000 ) );
                String temp = main.getString( "temp" ) + "°C";
                String tempMin = "Min Temp: " + main.getString( "temp_min" ) + "°C";
                String tempMax = "Max Temp: " + main.getString( "temp_max" ) + "°C";
                Long sunrise = sys.getLong( "sunrise" );
                Long sunset = sys.getLong( "sunset" );
                String weatherDescription = weather.getString( "description" );
                String address = jsonObj.getString( "name" ) + ", " + sys.getString( "country" );
//              eliane's codes
                mMaxTemp = main.getDouble( "temp_max" );
                mMinTemp = main.getDouble( "temp_min" );
                mDescription = weather.getString( "description" );
//              end of eliane
                /* Populating extracted data into our views */
                addressTxt.setText( address );
                updated_atTxt.setText( updatedAtText );
                statusTxt.setText( weatherDescription.toUpperCase() );
                tempTxt.setText( temp );
                temp_minTxt.setText( tempMin );
                temp_maxTxt.setText( tempMax );
                sunriseTxt.setText( new SimpleDateFormat( "hh:mm a" , Locale.ENGLISH ).format( new Date( sunrise * 1000 ) ) );
                sunsetTxt.setText( new SimpleDateFormat( "hh:mm a" , Locale.ENGLISH ).format( new Date( sunset * 1000 ) ) );
                /* Views populated, Hiding the loader, Showing the main design */
                findViewById( R.id.loader ).setVisibility( View.GONE );
                findViewById( R.id.mainContainer ).setVisibility( View.VISIBLE );
            } catch (JSONException e) {
                findViewById( R.id.loader ).setVisibility( View.GONE );
                findViewById( R.id.errorText ).setVisibility( View.VISIBLE );
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected( item )) {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }
    public boolean selectItemDrawer(MenuItem menuItem) {
        menuItem.setChecked( true );
        setTitle( menuItem.getTitle() );
        mDrawerLayout.closeDrawers();
        int id = menuItem.getItemId();
        if (id == R.id.nav_rate) {
            Intent intent = new Intent( LocationActivity.this , RateStars.class );
            startActivity( intent );
            return true;
        } else if (id == R.id.nav_location) {
            Intent intent = new Intent( LocationActivity.this , EditLocation.class );
            startActivity( intent );
            return true;
        } else if (id == R.id.nav_Privacy) {
            Intent intent = new Intent( LocationActivity.this , PrivateActivity.class );
            startActivity( intent );
            return true;
        }else if (id == R.id.nav_help) {
            Intent intent = new Intent( LocationActivity.this , HelpActivity.class );
            startActivity( intent );
            return true;
        }
        return false;
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer( menuItem );
                return true;
            }
        } );
        {
        }
    }
//       if(v == mFindMallButton) {
//        String location = mLocationEditText.getText().toString();
//        saveLocationToFirebase(location);
//        Intent cheHome = new Intent(ImagesActivity.this, MallsActivity.class);
//        cheHome.putExtra("kigali", location);
//        startActivity(cheHome);
//    }
}

