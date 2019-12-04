package com.moringaschool.myweather;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.moringaschool.myweather.adapter.ViewPagerAdapter;
import com.moringaschool.myweather.drawer.EditLocation;
import com.moringaschool.myweather.drawer.HelpActivity;
import com.moringaschool.myweather.drawer.PrivateActivity;
import com.moringaschool.myweather.drawer.RateStars;
import com.moringaschool.myweather.models.Common;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    ELIANE
    public static final String TAG = MainActivity.class.getSimpleName();
    private String gender;
//  Eliane
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;

 //chelsea
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
//    @BindView(R.id.clickForCloth) ImageView mClickForCloth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        eliane
        Intent intent = getIntent();
        gender = intent.getStringExtra( "gender" );
//        eliane

        relativeLayout = (RelativeLayout) findViewById(R.id.root_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Request permission

        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                      if (report.areAllPermissionsGranted())
                      {
                          buildLocationRequest();
                          buildLocationCallBack();

                       if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                       {
                           return;
                       }
                       fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
                       fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper());
                      }

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Snackbar.make(relativeLayout, "Permission Denied",Snackbar.LENGTH_LONG)
                                .show();

                    }
                }).check();

//        mDrawerLayout = findViewById( R.id.root_view );
//        mToggle = new ActionBarDrawerToggle( this , mDrawerLayout , R.string.open , R.string.close );
//        mDrawerLayout.addDrawerListener( mToggle );
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
//        NavigationView nvDrawer = (NavigationView) findViewById( R.id.nav_header );
//        setupDrawerContent( nvDrawer );
    }




    private void buildLocationCallBack() {
        locationCallback = new LocationCallback(){

            @Override
            public  void onLocationResult(LocationResult locationResult){
                super.onLocationResult(locationResult);

                Common.current_location=locationResult.getLastLocation();

                viewPager = (ViewPager)findViewById(R.id.view_pager);
                setupViewPager(viewPager);
                tabLayout=(TabLayout)findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(viewPager);

                // log

                Log.d("Location",locationResult.getLastLocation().getLatitude()+"/"+locationResult.getLastLocation().getLongitude());
            }
        };
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(TodayWeatherFragment.getInstance(),"Today");
        adapter.addFragment(ForecastFragment.getInstance(),"5days");

        viewPager.setAdapter(adapter);

    }

    private void buildLocationRequest() {
        locationRequest=new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10000.0f);
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
        if (id == R.id.nav_language) {
            Intent intent = new Intent( MainActivity.this , RateStars.class );
            startActivity( intent );
            return true;
        } else if (id == R.id.nav_rate) {
            Intent intent = new Intent( MainActivity.this , RateStars.class );
            startActivity( intent );
            return true;
        } else if (id == R.id.nav_location) {
            Intent intent = new Intent( MainActivity.this , EditLocation.class );
            startActivity( intent );
            return true;
        } else if (id == R.id.nav_Privacy) {
            Intent intent = new Intent( MainActivity.this , PrivateActivity.class );
            startActivity( intent );
            return true;
        }else if (id == R.id.nav_help) {
            Intent intent = new Intent( MainActivity.this , HelpActivity.class );
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


}
