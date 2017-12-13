package com.everzones.androidlib.net;

import android.os.Handler;

import com.everzones.androidlib.bean.Data;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;


/**
 * Created by sunny on 2017/11/16.
 * anthor:sunny
 * date: 2017/11/16
 * function:
 */

public class HttpRequest implements Runnable{
    private HttpUriRequest request;
    private Data urldata;                  //请求的实体（url等）
    private RequestParameter params;    //请求的参数（有key）
    private RequestCallback callback;   //请求的回调
    private String key;                 //请求的key
    private DefaultHttpClient client;
    protected Handler handler;            //？？

    public HttpRequest(Data data, List<RequestParameter> params,RequestCallback callback){
        this.urldata = data;
        key = urldata.getKey();
        if (client == null){
            client = new DefaultHttpClient();
        }

        //注意导入os下的包
        handler = new Handler();
    }


    /**
     * 获取HttpUriRequest请求
     * @return
     */
    public HttpUriRequest getRequest(){
        return request;
    }

    @Override
    public void run() {
        //通过get方式获取
        if (urldata.getNetType().equals("get")){

        }
    }
}
