package com.example.android.quakereport;

public class EarthQuake {

    private String mNumberText;
    private Long mdateText;
    private String mCityText;

    public EarthQuake(String number,String city,Long date){
        mCityText = city;
        mdateText = date;
        mNumberText =number;

    }

    public String getCityText(){return mCityText;}

    public Long getDateText (){return mdateText;}

    public String getNumberText(){return mNumberText;}
}
