package com.example.android.quakereport;

public class EarthQuakeAdapter extends android.widget.ArrayAdapter<com.example.android.quakereport.EarthQuake> {

    public EarthQuakeAdapter (android.app.Activity context, java.util.ArrayList<EarthQuake> earthQuake){
        super(context,0, (java.util.List<com.example.android.quakereport.EarthQuake>) earthQuake);
    }

    @android.support.annotation.NonNull
    @Override
    public android.view.View getView(int position, @android.support.annotation.Nullable android.view.View convertView, @android.support.annotation.NonNull android.view.ViewGroup parent) {
        android.view.View listView = convertView;
        if (listView == null){
            listView = android.view.LayoutInflater.from(getContext()).inflate(com.example.android.quakereport.R.layout.earth_quake_data_layout,parent,false);
        }
        EarthQuake currentEarthQuake = getItem(position);
        android.widget.TextView cityText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.city_text_view);
        cityText.setText(currentEarthQuake.getCityText());
        android.widget.TextView numberText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.number_text_view);
        numberText.setText(currentEarthQuake.getNumberText());
        java.util.Date dateObject = new java.util.Date(currentEarthQuake.getDateText());
        android.widget.TextView dateText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.date_text_view);
        String formatedDate = formatDate(dateObject);
        dateText.setText(formatedDate);
        android.widget.TextView timeText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.time_text_view);
        String formatedTime = formatTime(dateObject);
        timeText.setText(formatedTime);
        return listView;
    }


    private String formatDate (java.util.Date dateObject){
        @android.annotation.SuppressLint("SimpleDateFormat") java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("LLL dd,yy");
        return simpleDateFormat.format(dateObject);
    }


    private String formatTime (java.util.Date dateObject){
        @android.annotation.SuppressLint("SimpleDateFormat") java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(dateObject);
    }

}
