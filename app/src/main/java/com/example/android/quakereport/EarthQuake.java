package com.example.android.quakereport;

public class EarthQuake {

    private String mNumberText;
    private Long mTimeInMillisecondst;
    private String mCityText;

    public EarthQuake(String number,String city,Long timeInMilliseconds){
        mCityText = city;
        mTimeInMillisecondst = timeInMilliseconds;
        mNumberText =number;

    }

    public String getCityText(){return mCityText;}

    public Long getTimeInMilliseconds (){return mTimeInMillisecondst;}

    public String getNumberText(){return mNumberText;}
}
