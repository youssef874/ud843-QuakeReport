package com.example.android.quakereport;

public class EarthQuakeAdapter extends android.widget.ArrayAdapter<com.example.android.quakereport.EarthQuake> {

    public EarthQuakeAdapter(android.app.Activity context, java.util.ArrayList<EarthQuake> earthQuake) {
        super(context, 0, (java.util.List<com.example.android.quakereport.EarthQuake>) earthQuake);
    }

    @android.support.annotation.NonNull
    @Override
    public android.view.View getView(int position, @android.support.annotation.Nullable android.view.View convertView, @android.support.annotation.NonNull android.view.ViewGroup parent) {
        android.view.View listView = convertView;
        if (listView == null) {
            listView = android.view.LayoutInflater.from(getContext()).inflate(com.example.android.quakereport.R.layout.earth_quake_data_layout, parent, false);
        }
        EarthQuake currentEarthQuake = getItem(position);
        android.widget.TextView cityText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.city_text_view);
        String[] stringArray = splitString(currentEarthQuake.getCityText());
        cityText.setText(stringArray[1]);
        android.widget.TextView location =(android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.direction_text_view);
        location.setText(stringArray[0]);
        android.widget.TextView numberText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.number_text_view);
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("0.0");
        String output = formatter.format(currentEarthQuake.getNumberText());
        numberText.setText(output);
        android.graphics.drawable.GradientDrawable magnitudeCircle = (android.graphics.drawable.GradientDrawable) numberText.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getNumberText());
        magnitudeCircle.setColor(magnitudeColor);
        java.util.Date dateObject = new java.util.Date(currentEarthQuake.getTimeInMilliseconds());
        android.widget.TextView dateText = (android.widget.TextView) listView.findViewById(com.example.android.quakereport.R.id.date_text_view);
        String formattedDate = formatDate(dateObject);
        dateText.setText(formattedDate);
        android.widget.TextView timeView = (android.widget.TextView) listView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listView;
    }


    private String formatDate(java.util.Date dateObject) {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(java.util.Date dateObject) {
        java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    private String[] splitString(String string){
        if(!string.contains("of")){
            return new String[]{getContext().getString(com.example.android.quakereport.R.string.near_the),string};
        }
        String [] s=string.split(" ",4);
        return new String[]{s[0]+" "+s[1]+ " "+" "+s[2],s[3]};
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return android.support.v4.content.ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}



