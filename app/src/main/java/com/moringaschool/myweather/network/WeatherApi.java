package com.moringaschool.myweather.network;

import com.moringaschool.myweather.models.WeatherForecastResult;
import com.moringaschool.myweather.models.WeatherResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("data/2.5/weather")
    Observable<WeatherResult> getWeather(
            @Query("lat") String lat,
            @Query("lon") String lng,
            @Query("appid") String appid,
            @Query("units") String unit
    );

    @GET("data/2.5/weather")
    Observable<WeatherResult> getWeatherByName(
            @Query("q") String cityName,
            @Query("appid") String appid,
            @Query("units") String unit
    );

    @GET("data/2.5/forecast")
    Observable<WeatherForecastResult> getForecast(
            @Query("lat") String lat,
            @Query("lon") String lng,
            @Query("appid") String appid,
            @Query("units") String unit
    );

}
