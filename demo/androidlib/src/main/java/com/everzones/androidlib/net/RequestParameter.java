package com.everzones.androidlib.net;

/**
 * Created by sunny on 2017/11/15.
 * anthor:sunny
 * date: 2017/11/15
 * function:请求的键值对
 */

public class RequestParameter {
    private String name;    //键
    private String value;   //值

    public RequestParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int compareTo(final Object another) {
        int compared;
        /**
         * 值比较
         */
        final RequestParameter parameter = (RequestParameter) another;
        compared = name.compareTo(parameter.name);
        if (compared == 0) {
            compared = value.compareTo(parameter.value);
        }
        return compared;
    }

    public boolean equals(final Object o) {
        if (null == o) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (o instanceof RequestParameter) {
            final RequestParameter parameter = (RequestParameter) o;
            return name.equals(parameter.name) && value.equals(parameter.value);
        }

        return false;
    }
}
