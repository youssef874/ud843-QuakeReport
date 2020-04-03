package com.example.android.quakereport;

public class EarthQuake {

    private Double mNumberText;
    private String mCityText;
    private long mTimeInMilliseconds;
    private String url;

    public EarthQuake(Double number, String city, Long timeInMilliseconds,String url){
        mCityText = city;
        mTimeInMilliseconds = timeInMilliseconds;
        mNumberText =number;
        this.url=url;

    }

    public String getCityText(){return mCityText;}

    public Double getNumberText(){return mNumberText;}

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl(){
        return url;
    }
}
