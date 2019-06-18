package com.example.myfirstapplication;


import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.EOFException;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView,textView2,textView3,textView4,textView5,textView6;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city=(EditText) findViewById(R.id.city);
        button=findViewById(R.id.button);
        textView= findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
        textView3= findViewById(R.id.textView3);
        textView4= findViewById(R.id.textView4);
        textView5= findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String City=city.getText().toString();
                String url="https://api.openweathermap.org/data/2.5/weather?q=" + City+"&appid=f4edbdb8c89ae01433e0007cd21e3661";
                weather aunty = new weather(new weathertaskcompletedlistener() {
                    @Override
                    public void onWeatherTaskCompleted(weathertask weather) {
                        Double temp1=weather.getTemp()-273;
                        Double tempmin1=weather.getTempmin()-273;
                        Double tempmax1=weather.getTempmax()-273;
                        DecimalFormat df = new DecimalFormat("#.##");
                        String formatted = df.format(temp1);
                        DecimalFormat df1 = new DecimalFormat("#.##");
                        String formatted1 = df1.format(tempmin1);
                        DecimalFormat df2 = new DecimalFormat("#.##");
                        String formatted2 = df2.format(tempmax1);
                        textView5.setText(formatted +"°C");
                       textView3.setText(formatted1+"°c");
                       textView4.setText(formatted2+"°c");
                       textView.setText(weather.getMainwea());
                       textView6.setText(weather.getDeswea());

                    }
                });
                aunty.execute(url);

            }
        });

    }
}
