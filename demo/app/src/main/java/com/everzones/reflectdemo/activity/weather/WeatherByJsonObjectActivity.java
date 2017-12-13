package com.everzones.reflectdemo.activity.weather;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.everzones.androidlib.net.RequestAsyncTask;
import com.everzones.reflectdemo.R;
import com.everzones.reflectdemo.activity.base.AppBaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherByJsonObjectActivity extends AppBaseActivity {
    private TextView tv_city;
    private TextView tv_cityId;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setContentView(R.layout.activity_weather_by_json_object);
        tv_city = findViewById(R.id.tv_city);
        tv_cityId = findViewById(R.id.tv_cityId);
    }

    @Override
    protected void loadData() {
        super.loadData();
        String url = "http://www.weather.com.cn/data/sk/101010100.html";
        @SuppressLint("StaticFieldLeak") RequestAsyncTask requestAsyncTask = new RequestAsyncTask() {
            @Override
            public void onSuccess(String msg) {
                JSONObject jsonObject = new JSONObject();
                try {
                    JSONObject info = jsonObject.getJSONObject("result");
                    Toast.makeText(WeatherByJsonObjectActivity.this,info.toString(),Toast.LENGTH_SHORT).show();
                    tv_city.setText(info.getString("city"));
                    tv_cityId.setText(info.getInt("cityid"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(String errorMessage) {
                new AlertDialog.Builder(WeatherByJsonObjectActivity.this)
                        .setTitle("出错啦")
                        .setMessage(errorMessage)
                        .setPositiveButton("确定",null)
                        .show();
            }
        };

        requestAsyncTask.execute(url);
    }
}
