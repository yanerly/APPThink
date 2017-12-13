package com.everzones.reflectdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.everzones.androidlib.activity.BaseActivity;
import com.everzones.reflectdemo.R;
import com.everzones.reflectdemo.bean.Person;
import com.everzones.reflectdemo.utils.APPConstant;

public class SecondActivity extends BaseActivity {
    private TextView tv_showMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_second);
        tv_showMsg = findViewById(R.id.tv_showMsg);
    }

    @Override
    protected void loadData() {
        Intent i = getIntent();
        Person p = (Person) i.getSerializableExtra(APPConstant.person);
        tv_showMsg.setText(p.toString());
    }
}
