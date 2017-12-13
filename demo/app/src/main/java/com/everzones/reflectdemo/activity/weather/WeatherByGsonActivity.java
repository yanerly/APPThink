package com.everzones.reflectdemo.activity.weather;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.everzones.androidlib.net.RequestAsyncTask;
import com.everzones.reflectdemo.R;
import com.everzones.reflectdemo.activity.base.AppBaseActivity;
import com.everzones.reflectdemo.bean.WeatherInfo;
import com.google.gson.Gson;

public class WeatherByGsonActivity extends AppBaseActivity {
    private TextView tv_city;
    private TextView tv_cityId;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setContentView(R.layout.activity_weather_by_fast_json);
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
                Gson gson = new Gson();
                WeatherInfo info  = gson.fromJson(msg,WeatherInfo.class);
                if (info!=null){
                    tv_city.setText(info.getCity());
                    tv_cityId.setText(info.getCityid());
                }
            }

            @Override
            public void onFail(String errorMessage) {
                new AlertDialog.Builder(WeatherByGsonActivity.this)
                        .setTitle("出错啦")
                        .setMessage(errorMessage)
                        .setPositiveButton("确定",null)
                        .show();
            }
        };

        //这一句不要忘了
        requestAsyncTask.execute(url);
    }
}
