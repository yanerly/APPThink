package com.everzones.androidlib.net;

import android.os.AsyncTask;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.everzones.androidlib.bean.ResponseBean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sunny on 2017/11/13.
 * anthor:sunny
 * date: 2017/11/13
 * function:
 */

public abstract class RequestAsyncTask extends AsyncTask<String,Void,ResponseBean>{

    //只需要实现这两个方法就行了
    public abstract void onSuccess(String msg);

    public abstract void onFail(String errorMessage);

    @Override
    protected ResponseBean doInBackground(String... url) {
        return getResponseFromURL(url[0]);
    }

    @Override
    protected void onPostExecute(ResponseBean response) {
        if (response.isError()){
            onFail(response.getErrorMessage());
        }else{
            onSuccess(response.getResult());
        }
    }

    private ResponseBean getResponseFromURL(String url){
        String responseStr = null;
        ResponseBean bean = new ResponseBean();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();

            if (response==null){
                responseStr =  "{'isError':true,'errorType':0,'errorMessage':'错啦错啦','result':{}}";
            }else {
                responseStr =  "{'isError':false,'errorType':0,'errorMessage':'','result':{'city':'北京','cityid':'101010100'," +
                        "'temp':'17','WD':'西南风','WS':'2级','SD':'54%','WSE':'2','time':'23:15','isRadar':'1','Radar':'JC_RADAR_AZ9010_JB','njd':'暂无实况','qy':'1016'}}";
            }
        } catch (IOException e) {
           Log.e("msg","出错啦："+e.getMessage());
        }

        bean = JSON.parseObject(responseStr,ResponseBean.class);
        return bean;
    }
}
