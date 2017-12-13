package com.everzones.reflectdemo.engine;

import com.everzones.androidlib.bean.Data;
import com.everzones.androidlib.net.DataManager;
import com.everzones.androidlib.net.RequestCallback;
import com.everzones.androidlib.net.RequestParameter;
import com.everzones.reflectdemo.activity.weather.WeatherByFastJsonActivity;

import java.util.ArrayList;

/**
 * Created by sunny on 2017/11/15.
 * anthor:sunny
 * date: 2017/11/15
 * function:
 */

public class RequestSevice {
    private static RequestSevice service;

    public static RequestSevice getInstance(){
        if(service == null){
            service = new RequestSevice();
        }
        return service;
    }


    public void invoke(WeatherByFastJsonActivity weatherByFastJsonActivity, String getweatherinfo,
                       ArrayList<RequestParameter> params, RequestCallback weathercallback) {
        Data data = DataManager.findURL(weatherByFastJsonActivity,getweatherinfo);

    }
}
