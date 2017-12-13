package com.everzones.androidlib.bean;

/**
 * Created by sunny on 2017/11/15.
 * anthor:sunny
 * date: 2017/11/15
 * function:xml中的数据
 */

public class Data {
    private String key;
    private long expires;       //数据缓存
    private String netType;     //get or post
    private String url;         //请求的地址

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
