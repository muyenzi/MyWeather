package com.moringaschool.myweather.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myweather.ClothingActivity;
import com.moringaschool.myweather.R;
import com.moringaschool.myweather.models.Common;
import com.moringaschool.myweather.models.WeatherForecastResult;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder> {
//    public static  final String TAG = WeatherForecastAdapter.class
    Context context;
    WeatherForecastResult weatherForecastResult;
    CardView cardView;


    public WeatherForecastAdapter(Context context, WeatherForecastResult weatherForecastResult) {
        this.context = context;
        this.weatherForecastResult = weatherForecastResult;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast,parent,false);

    return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

//        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/wn/").append(weatherForecastResult.getList().get(position).getWeather().get(0).getIcon()).append(".png").toString()).into(holder.img_weather);
        holder.txt_date_time.setText(new StringBuilder(Common.convertUnixToDate(weatherForecastResult.getList().get(position).getDt())));
        holder.txt_description.setText(new StringBuilder (String.valueOf(weatherForecastResult.getList().get(position).getWeather().get(0).getDescription())));
        holder.txt_temperature.setText(new StringBuilder(String.valueOf(weatherForecastResult.getList().get(position).getMain().getTemp())).append("°C"));
        holder.txt_main.setText(new StringBuilder(String.valueOf(weatherForecastResult.getList().get(position).getWeather().get(0).getMain())));
        holder.txt_temp.setText(new StringBuilder(String.valueOf(weatherForecastResult.getList().get(position).getMain().getTemp())));

        holder.txt_temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClothingActivity.class);
                intent.putExtra("temp",holder.txt_temp.getText());
                intent.putExtra("description",holder.txt_main.getText());
//                System.out.println("temp" + holder.txt_temperature.getText().toString());
                context.startActivity(intent);

            }
        });

        holder.txt_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClothingActivity.class);
                intent.putExtra("temp",holder.txt_temp.getText());
                intent.putExtra("description",holder.txt_main.getText());
//                System.out.println("temp" + holder.txt_temperature.getText().toString());
                context.startActivity(intent);

            }
        });

        holder.txt_date_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClothingActivity.class);
                intent.putExtra("temp",holder.txt_temp.getText());
                intent.putExtra("description",holder.txt_main.getText());
//                System.out.println("temp" + holder.txt_temperature.getText().toString());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return weatherForecastResult.getList().size();
    }



    public class MyViewHolder extends  RecyclerView.ViewHolder  {

        TextView txt_date_time,txt_description,txt_temperature,txt_main,txt_temp;
        ImageView img_weather;
        public MyViewHolder(View itemView){
            super(itemView);

            txt_date_time =(TextView) itemView.findViewById(R.id.txt_date);
//            img_weather = (ImageView) itemView.findViewById(R.id.img_weather);
            txt_temperature = (TextView) itemView.findViewById(R.id.txt_temperature);
            txt_description = (TextView) itemView.findViewById(R.id.txt_description);

            txt_main = (TextView) itemView.findViewById(R.id.main);
            txt_temp = (TextView) itemView.findViewById(R.id.txt_temp);


        }

    }
}
