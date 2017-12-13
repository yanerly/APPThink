package com.everzones.androidlib.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
   * 作者：sunny
   * 时间：2017/10/30
   * 功能：用于存放业务无关的公用逻辑
  */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("result","BaseActivity-->oncreate()");

        initVariables();//初始化变量

        initView(savedInstanceState);//初始化布局及控件

        loadData();//加载数据
    }
    protected abstract void initVariables();
    protected abstract void initView(Bundle savedInstanceState);
    protected abstract void loadData();
 }
