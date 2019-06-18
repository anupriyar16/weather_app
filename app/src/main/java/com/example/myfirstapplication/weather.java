package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class weather extends AsyncTask<String,Void,String> {
    weathertaskcompletedlistener mListener;

    public weather(weathertaskcompletedlistener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected String doInBackground(String... strings) {
        String resJson="";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(strings[0])
                .build();

        try (Response response = client.newCall(request).execute()) {
            resJson= response.body().string();
            Log.d("resJson:",resJson);
        } catch (Exception e){
            e.printStackTrace();
        }


        return resJson;
    }
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        try
        {
            JSONObject weatherobj=new JSONObject(s);
            JSONArray weatherarr=weatherobj.getJSONArray("weather");
            String mainwea=weatherarr.getJSONObject(0).getString("main");
            String deswea=weatherarr.getJSONObject(0).getString("description");
            JSONObject mainobj=weatherobj.getJSONObject("main");
            Double temp= mainobj.getDouble("temp");
            Double tempmin =mainobj.getDouble("temp_min");
            Double tempmax=mainobj.getDouble("temp_max");
            String city=weatherobj.getString("name");
            weathertask Weathertask=new weathertask(mainwea, deswea, tempmin, tempmax, temp, city);
            mListener.onWeatherTaskCompleted(Weathertask);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
