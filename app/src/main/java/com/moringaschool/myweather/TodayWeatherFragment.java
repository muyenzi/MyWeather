package com.moringaschool.myweather;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.moringaschool.myweather.models.Common;
import com.moringaschool.myweather.models.WeatherResult;
import com.moringaschool.myweather.network.WeatherApi;
import com.moringaschool.myweather.network.WeatherClient;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodayWeatherFragment extends Fragment {

    ImageView img_weather;
    TextView txt_city_name, txt_description, txt_temperature, txt_date_time;
    ProgressBar loading;
    LinearLayout weather_panel;

    CompositeDisposable compositeDisposable;
    WeatherApi mService;

    static TodayWeatherFragment instance;

    public static TodayWeatherFragment getInstance() {
        if (instance == null)
            instance = new TodayWeatherFragment();
        return instance;

    }

    public TodayWeatherFragment() {

        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = WeatherClient.getInstance();
        mService = retrofit.create(WeatherApi.class);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View itemView = inflater.inflate(R.layout.fragment_today_weather, container, false);

        img_weather = (ImageView) itemView.findViewById(R.id.img_weather);
        txt_city_name = (TextView) itemView.findViewById(R.id.txt_city_name);
        txt_description = (TextView) itemView.findViewById(R.id.txt_description);
        txt_temperature = (TextView) itemView.findViewById(R.id.txt_temperature);
        txt_date_time = (TextView) itemView.findViewById(R.id.txt_date_time);

        weather_panel = (LinearLayout) itemView.findViewById(R.id.weather_panel);
        loading = (ProgressBar) itemView.findViewById(R.id.loading);

        getWeatherInformation();

        return itemView;
    }

    private void getWeatherInformation() {
        compositeDisposable.add(mService.getWeather(String.valueOf(Common.current_location.getLatitude()),
                String.valueOf(Common.current_location.getLongitude()),
                Common.APP_ID, "metric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherResult>() {
                    @Override
                    public void accept(WeatherResult weatherResult) throws Exception {



                        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/wn/").append(weatherResult.getWeather().get(0).getIcon()).append(".png").toString()).into(img_weather);
                        txt_city_name.setText(weatherResult.getName());
                        System.out.println(weatherResult.getName());
//                        txt_description.setText(new StringBuilder("Weather in ").append(weatherResult.getName()).toString());

                        txt_description.setText(weatherResult.getWeather().get(0).getDescription());
                        txt_temperature.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getTemp())).append("°C").toString());
                        txt_date_time.setText(Common.convertUnixToDate(weatherResult.getDt()));

                        // Display
                        weather_panel.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Toast.makeText(getActivity(),""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })


        );


    }
}
