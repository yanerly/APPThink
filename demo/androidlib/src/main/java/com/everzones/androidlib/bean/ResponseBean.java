package com.everzones.androidlib.bean;

/**
 * Created by sunny on 2017/11/13.
 * anthor:sunny
 * date: 2017/11/13
 * function:
 */

public class ResponseBean {
    private boolean error;  //成功与否
    private int errorType;	//1为Cookie失效  0：成功
    private String errorMessage; //错误消息
    private String result;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
