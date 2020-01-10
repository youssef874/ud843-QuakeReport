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
        android.widget.TextView offsetTextView = listView.findViewById(com.example.android.quakereport.R.id.offset_text_view);
        if (!currentEarthQuake.getCityText().contentEquals("of")){
            offsetTextView.setText("Near of");
            cityText.setText(currentEarthQuake.getCityText());
        }
        else{
            String[] strings = currentEarthQuake.getCityText().split("",4);
            String ofSet =strings[0]+""+strings[1]+""+strings[3];
            offsetTextView.setText(ofSet);
            String primaryLocation = strings[4];
            cityText.setText(primaryLocation);

        }
        android.widget.TextView numberText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.number_text_view);
        numberText.setText(currentEarthQuake.getNumberText());
        java.util.Date dateObject = new java.util.Date(currentEarthQuake.getTimeInMilliseconds());
        android.widget.TextView dateText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.date_text_view);
        String formattedDate = formatDate(dateObject);
        dateText.setText(formattedDate);
        android.widget.TextView timeText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.time_text_view);
        String formattedTime = formatTime(dateObject);
        timeText.setText(formattedTime);
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
