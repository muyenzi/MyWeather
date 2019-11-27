package com.moringaschool.myweather;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myweather.adapter.WeatherForecastAdapter;
import com.moringaschool.myweather.models.Common;
import com.moringaschool.myweather.models.WeatherForecastResult;
import com.moringaschool.myweather.network.WeatherApi;
import com.moringaschool.myweather.network.WeatherClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    CompositeDisposable compositeDisposable;
    WeatherApi mService;

    RecyclerView recyclerView_forecast;

    static  ForecastFragment instance;

    public static  ForecastFragment getInstance(){
        if (instance == null)
            instance = new ForecastFragment();
        return instance;
    }

    public  ForecastFragment() {
        // Required empty public constructor
        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = WeatherClient.getInstance();
        mService = retrofit.create(WeatherApi.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_forecast, container, false);
        recyclerView_forecast = (RecyclerView) itemView.findViewById(R.id.recycler_forecast);
        recyclerView_forecast.setHasFixedSize(true);
        recyclerView_forecast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        getForecastWeatherInformation();

        return itemView;
    }

    private void getForecastWeatherInformation() {
        compositeDisposable.add(mService.getForecast(String.valueOf(Common.current_location.getLatitude()),
                String.valueOf(Common.current_location.getLongitude()),
                Common.APP_ID, "metric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResult>() {
                    @Override
                    public void accept(WeatherForecastResult weatherForecastResult) throws Exception {
                        displayForecastWeather(weatherForecastResult);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d("Error",""+throwable.getMessage());
                    }
                })


        );


    }

    private void displayForecastWeather(WeatherForecastResult weatherForecastResult) {
        WeatherForecastAdapter adapter=new WeatherForecastAdapter(getContext(),weatherForecastResult);
        recyclerView_forecast.setAdapter(adapter);
    }
}
