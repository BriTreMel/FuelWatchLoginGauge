
package com.example.mel76.fuelwatch11;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.content.Intent;
        import android.view.MenuItem;
        import android.webkit.WebSettings;
        import android.webkit.WebView;



public class log_in_screen extends Activity {

    private EditText emailField, passwordField;
    private TextView oilLevel;
    String oilLevelFromDataBase;
    String message;
    int number = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //reading back data from database
        // Task = new MyAsyncTask();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);


        emailField = (EditText) findViewById(R.id.editTextEmail);
        passwordField = (EditText) findViewById(R.id.editTextPassword);

        oilLevel = (TextView) findViewById(R.id.textViewLevel);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    public void loginPost(View view){
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        // Passes the data to the singinActivity.java
        //oil level passed to new activity, with flag set to 1 (means using a POST method)

     //  while(number > 0) {
           new SigninActivity(this, oilLevel, 1).execute(email, password);
          // oilLevelFromDataBase = SigninActivity.onPost

           oilLevelFromDataBase = oilLevel.getText().toString();

         //  oilLevelFromDataBase = SigninActivity.get().toString();

           WebView webview = (WebView) findViewById(R.id.webView2);

           String content = "<html>"
                   + "<head>"
                   + "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>"
                   + " <script type=\"text/javascript\">"
                   + "     google.charts.load('current', {'packages':['gauge']});"
                   + "google.charts.setOnLoadCallback(drawChart);"
                   + "function drawChart() {"

                   + "var data = google.visualization.arrayToDataTable(["
                   + "['Label', 'Value'],"
                   + "['Oil Level', " + oilLevelFromDataBase + "],"
                   + "]);"

                   + "var options = {"
                   + " width: 400, height: 120,"
                   + " redFrom: 0, redTo: 10,"
                   + " yellowFrom:10, yellowTo: 20,"
                   + " minorTicks: 5"
                   + "};"

                   + "var chart = new google.visualization.Gauge(document.getElementById('chart_div'));"

                   + "chart.draw(data, options);"

                   + "setInterval(function() {"
                   + "data.setValue(0, 1, " + oilLevelFromDataBase + ");"
                   + "chart.draw(data, options);"
                   + "}, 13000);"

                   + "}"
                   + "</script>"
                   + "</head>"
                   + "<body>"
                   + "<div id=\"chart_div\" style=\"width: 400px; height: 120px;\"></div>"
                   + "</body>"
                   + "</html>";


           WebSettings webSettings = webview.getSettings();
           webSettings.setJavaScriptEnabled(true);
           // webview.requestFocusFromTouch();

           webview.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf-8", null);


    //   }// end of while loop

        oilLevelFromDataBase = oilLevel.getText().toString();

        updateGauge(oilLevelFromDataBase);


    }

    public void viewGaugePage(View view){

        Intent viewGaugeIntent = new Intent(log_in_screen.this,gauge_view.class);
 //       viewGaugeIntent.putExtra(oilLevelFromDataBase, oilLevelFromDataBase);
//        log_in_screen.this.startActivity(viewGaugeIntent);
//        log_in_screen.this.finish();


        viewGaugeIntent.putExtra("45", message);
        startActivity(viewGaugeIntent);
        log_in_screen.this.startActivity(viewGaugeIntent);
        log_in_screen.this.finish();

    }

    //getting value back from gauge
    public interface AsyncResponse{
        void processFinish(String databaseValue);
    }


    public void updateGauge(String oilLevelFromDataBase){

       // oilLevelFromDataBase = "50";

        WebView webview = (WebView) findViewById(R.id.webView2);

        String content = "<html>"
                + "<head>"
                + "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>"
                + " <script type=\"text/javascript\">"
                + "     google.charts.load('current', {'packages':['gauge']});"
                + "google.charts.setOnLoadCallback(drawChart);"
                + "function drawChart() {"

                + "var data = google.visualization.arrayToDataTable(["
                + "['Label', 'Value'],"
                + "['Oil Level', " + oilLevelFromDataBase + "],"
                + "]);"

                + "var options = {"
                + " width: 400, height: 120,"
                + " redFrom: 0, redTo: 10,"
                + " yellowFrom:10, yellowTo: 20,"
                + " minorTicks: 5"
                + "};"

                + "var chart = new google.visualization.Gauge(document.getElementById('chart_div'));"

                + "chart.draw(data, options);"

                + "setInterval(function() {"
                + "data.setValue(0, 1, " + oilLevelFromDataBase + ");"
                + "chart.draw(data, options);"
                + "}, 13000);"

                + "}"
                + "</script>"
                + "</head>"
                + "<body>"
                + "<div id=\"chart_div\" style=\"width: 400px; height: 120px;\"></div>"
                + "</body>"
                + "</html>";


        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // webview.requestFocusFromTouch();

        webview.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf-8", null);


    }
}

