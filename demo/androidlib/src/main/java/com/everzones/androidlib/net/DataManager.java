package com.everzones.androidlib.net;

import android.app.Activity;
import android.content.res.XmlResourceParser;

import com.everzones.androidlib.R;
import com.everzones.androidlib.bean.Data;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Created by sunny on 2017/11/15.
 * anthor:sunny
 * date: 2017/11/15
 * function:根据key获取到xml
 */

public class DataManager {
    public static Data findURL(Activity activity,String key){
        //new-->folder-->new file，如果不行，就gradle一下
        XmlResourceParser xmlParser = activity.getApplication()
                .getResources().getXml(R.xml.url);

        int eventType; //是文档的开始还是结束

        try {
            eventType = xmlParser.getEventType();
            //如果不是文档的结尾
            while (eventType!= XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if ("Node".equals(xmlParser.getName())){
                            String keyStr = xmlParser.getAttributeValue(null,"Key");
                            if (key.equals(keyStr)){
                                Data data = new Data();
                                data.setKey(keyStr);
                                data.setExpires(Long.parseLong(xmlParser.getAttributeValue(null,"Expires")));
                                data.setNetType(xmlParser.getAttributeValue(null,"NetType"));
                                data.setUrl(xmlParser.getAttributeValue(null,"Url"));
                                return data;
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return null;
    }
}
