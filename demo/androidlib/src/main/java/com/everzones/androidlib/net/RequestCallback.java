package com.everzones.androidlib.net;

/**
 * Created by sunny on 2017/11/15.
 * anthor:sunny
 * date: 2017/11/15
 * function:
 */

public interface RequestCallback {
    public void onSuccess(String content);
    public void onFail(String errorMsg);
}
