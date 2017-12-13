package com.everzones.reflectdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.everzones.androidlib.activity.BaseActivity;
import com.everzones.reflectdemo.R;
import com.everzones.reflectdemo.activity.weather.WeatherByJsonObjectActivity;
import com.everzones.reflectdemo.bean.Person;

public class MainActivity extends BaseActivity{
    private Button bt_click;

    @Override
    protected void loadData() {
        try {
            testReflect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        bt_click = findViewById(R.id.bt_click);
        bt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastTip();
            }
        });
    }

    private void toastTip() {
       /* Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        Person p = new Person();
        p.setName("sunny");
        p.setAge("22");
        intent.putExtra(APPConstant.person,p);
        startActivity(intent);*/

        Intent intent = new Intent(MainActivity.this,WeatherByJsonObjectActivity.class);
        startActivity(intent);
    }

    @Override
    protected void initVariables() {}

    private void testReflect() throws ClassNotFoundException {
        //1.通过类获取完整的类名和包名
        Person person = new Person();
        Log.d("result","包名为："+person.getClass().getName()+"\n");//com.everzones.reflectdemo.bean.Person

        //2.通过类名获取包名(一般采用这种形式)
        Class<?> class1  = Class.forName("com.everzones.reflectdemo.bean.Person");
        Log.d("result","包名为："+class1.getName()+"\n");//com.everzones.reflectdemo.bean.Person

        //3.获取一个对象的父类与实现的接口
        Class<?> parentClass = class1.getSuperclass();
        Log.d("result","父类为："+parentClass.getName()+"\n");//java.lang.Object

        //4.获取所有的接口
        Class<?> intes[] = class1.getInterfaces();
        Log.d("result","clazz实现的接口有：："+intes.length+"\n");
        for (int i = 0; i < intes.length; i++) {
            Log.d("result","clazz实现的接口有：："+intes[i].getName()+"\n");
        }
    }

}
