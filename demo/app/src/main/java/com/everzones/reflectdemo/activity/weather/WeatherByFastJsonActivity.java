package com.everzones.reflectdemo.activity.weather;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.everzones.androidlib.net.RequestAsyncTask;
import com.everzones.androidlib.net.RequestCallback;
import com.everzones.androidlib.net.RequestParameter;
import com.everzones.reflectdemo.R;
import com.everzones.reflectdemo.activity.base.AppBaseActivity;
import com.everzones.reflectdemo.bean.WeatherInfo;
import com.everzones.reflectdemo.engine.RequestSevice;

import java.util.ArrayList;

public class WeatherByFastJsonActivity extends AppBaseActivity {
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
        @SuppressLint("StaticFieldLeak") RequestAsyncTask asyncTask = new RequestAsyncTask() {
            @Override
            public void onSuccess(String msg) {
                //将json字符串转换为实体类型
                WeatherInfo info = JSON.parseObject(msg,WeatherInfo.class);
                if (info!=null){
                    tv_city.setText(info.getCity());
                    tv_cityId.setText(info.getCityid());
                }
            }

            @Override
            public void onFail(String errorMessage) {
                new AlertDialog.Builder(WeatherByFastJsonActivity.this)
                        .setTitle("出错啦")
                        .setMessage(errorMessage)
                        .setPositiveButton("确定",null)
                        .show();
            }
        };

        //注意最后要调用
        asyncTask.execute(url);

        //请求的参数
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter p1 = new RequestParameter("cityId","1");
        RequestParameter p2 = new RequestParameter("cityName","北京");
        params.add(p1);
        params.add(p2);

        //网络请求
        RequestCallback weathercallback = new RequestCallback() {
            @Override
            public void onSuccess(String content) {

            }

            @Override
            public void onFail(String errorMsg) {

            }
        };

        RequestSevice.getInstance().invoke(this,"getweatherinfo",params,weathercallback);

    }
}
