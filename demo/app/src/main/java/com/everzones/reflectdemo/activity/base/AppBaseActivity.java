package com.everzones.reflectdemo.activity.base;

import android.os.Bundle;

import com.everzones.androidlib.activity.BaseActivity;

/**
   * 作者：sunny
   * 时间：2017/10/30
   * 功能：封装业务相关的公用逻辑，继承的是依赖库中的基类
  */
public class AppBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

     @Override
     protected void loadData() {

     }

     @Override
     protected void initView(Bundle savedInstanceState) {

     }

     @Override
     protected void initVariables() {

     }
 }
