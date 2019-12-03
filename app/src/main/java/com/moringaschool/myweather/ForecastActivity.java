//package com.moringaschool.myweather;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.moringaschool.myweather.adapter.WeatherForecastAdapter;
//import com.moringaschool.myweather.models.Common;
//import com.moringaschool.myweather.models.WeatherForecastResult;
//import com.moringaschool.myweather.models.WeatherResult;
//import com.moringaschool.myweather.network.WeatherApi;
//import com.moringaschool.myweather.network.WeatherClient;
//import com.squareup.picasso.Picasso;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.functions.Consumer;
//import io.reactivex.schedulers.Schedulers;
//import retrofit2.Retrofit;
//
//public class ForecastActivity extends AppCompatActivity {
//
//    CompositeDisposable compositeDisposable;
//    WeatherApi mService;
//
//    ImageView img_weather;
//    TextView txt_city_name, txt_description, txt_temperature, txt_date_time;
//    ProgressBar loading;
//    LinearLayout weather_panel;
//    RecyclerView recyclerView_forecast;
//    CardView cardView;
//
//    public ForecastActivity(){
//        compositeDisposable = new CompositeDisposable();
//        Retrofit retrofit = WeatherClient.getInstance();
//        mService = retrofit.create(WeatherApi.class);
//    }
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_forecast);
//
//        img_weather = (ImageView) findViewById(R.id.img_weather);
//        txt_city_name = (TextView) findViewById(R.id.txt_city_name);
//        txt_description = (TextView) findViewById(R.id.txt_description);
//        txt_temperature = (TextView) findViewById(R.id.txt_temperature);
//        txt_date_time = (TextView) findViewById(R.id.txt_date_time);
//
//        weather_panel = (LinearLayout) findViewById(R.id.weather_panel);
//        loading = (ProgressBar) findViewById(R.id.loading);
//        cardView= (CardView) findViewById(R.id.cardView);
//
//
//        recyclerView_forecast = (RecyclerView) findViewById(R.id.recycler_forecast);
//        recyclerView_forecast.setHasFixedSize(true);
//        recyclerView_forecast.setLayoutManager(new LinearLayoutManager(ForecastActivity.this, LinearLayoutManager.HORIZONTAL,false));
//
//        getWeatherInformation();
//        getForecastWeatherInformation();
//
//
//    }
//
//
//    private void getWeatherInformation() {
//        compositeDisposable.add(mService.getWeather(String.valueOf(Common.current_location.getLatitude()),
//                String.valueOf(Common.current_location.getLongitude()),
//                Common.APP_ID, "metric")
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Consumer<WeatherResult>() {
//                            @Override
//                            public void accept(WeatherResult weatherResult) throws Exception {
//
//
//
//                                Picasso.get().load(new StringBuilder("https://openweathermap.org/img/wn/").append(weatherResult.getWeather().get(0).getIcon()).append(".png").toString()).into(img_weather);
//                                txt_city_name.setText(weatherResult.getName());
//                                System.out.println(weatherResult.getName());
////                        txt_description.setText(new StringBuilder("Weather in ").append(weatherResult.getName()).toString());
//
//                                txt_description.setText(weatherResult.getWeather().get(0).getDescription());
//                                txt_temperature.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getTemp())).append("°C").toString());
////                                txt_date_time.setText(Common.convertUnixToDate(weatherResult.getDt()));
//
//                                // Display
//                                weather_panel.setVisibility(View.VISIBLE);
//                                loading.setVisibility(View.GONE);
//
//                            }
//                        }, new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//
////                                Toast.makeText(""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        })
//
//
//        );
//
//
//    }
//
//    private void getForecastWeatherInformation() {
//
//        compositeDisposable.add(mService.getForecast(String.valueOf(Common.current_location.getLatitude()),
//                String.valueOf(Common.current_location.getLongitude()),
//                Common.APP_ID, "metric")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<WeatherForecastResult>() {
//                    @Override
//                    public void accept(WeatherForecastResult weatherForecastResult) throws Exception {
//                        displayForecastWeather(weatherForecastResult);
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                        Log.d("Error",""+throwable.getMessage());
//                    }
//                })
//
//
//        );
//
//
//    }
//
//    private void displayForecastWeather(WeatherForecastResult weatherForecastResult) {
//        WeatherForecastAdapter adapter=new WeatherForecastAdapter(ForecastActivity.this,weatherForecastResult);
//        recyclerView_forecast.setAdapter(adapter);
//
//    }
//}
