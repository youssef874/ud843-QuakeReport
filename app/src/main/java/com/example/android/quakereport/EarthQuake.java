package com.example.android.quakereport;

public class EarthQuake {

    private String mNumberText;
    private String mdateText;
    private String mCityText;

    public EarthQuake(double number,String city,String date){
        mCityText = city;
        mdateText = date;
        mNumberText =""+ number;

    }

    public String getCityText(){return mCityText;}

    public String getDateText (){return mdateText;}

    public String getNumberText(){return mNumberText;}
}
