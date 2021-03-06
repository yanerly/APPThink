package com.everzones.reflectdemo.bean;

/**
 * Created by sunny on 2017/11/13.
 * anthor:sunny
 * date: 2017/11/13
 * function:天气的实体类
 */

public class WeatherInfo {
    private String city;    //北京
    private String cityid;  //101010100
    private String temp;    //18
    private String WD;      //东南风
    private String WS;      //1级
    private String SD;      //17%
    private String WSE;     //1
    private String time;    //17:05
    private String isRadar; //JC_RADAR_AZ9010_JB
    private String Radar;   //暂无实况
    private String njd;     //1011
    private String qy;      //0

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getWSE() {
        return WSE;
    }

    public void setWSE(String WSE) {
        this.WSE = WSE;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsRadar() {
        return isRadar;
    }

    public void setIsRadar(String isRadar) {
        this.isRadar = isRadar;
    }

    public String getRadar() {
        return Radar;
    }

    public void setRadar(String radar) {
        Radar = radar;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "city='" + city + '\'' +
                ", cityid='" + cityid + '\'' +
                ", temp='" + temp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", SD='" + SD + '\'' +
                ", WSE='" + WSE + '\'' +
                ", time='" + time + '\'' +
                ", isRadar='" + isRadar + '\'' +
                ", Radar='" + Radar + '\'' +
                ", njd='" + njd + '\'' +
                ", qy='" + qy + '\'' +
                '}';
    }
}
