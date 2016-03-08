package com.example.mel76.fuelwatch11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class gauge_view extends Activity {

    int currentOilLevel;
  //  private TextView oilLevelCurrent = (TextView)findViewById(R.id.textViewOilLevelGauge);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauge_view);


        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        //Log.d("Message123456789", message);

        //currentOilLevel = Integer.parseInt(message);



      //  oilLevelCurrent.setText(message);




        TextView txtView = (TextView) findViewById(R.id.textViewOilLevelGauge);
        txtView.setText(message);

        WebView webview = (WebView) findViewById(R.id.webViewGauge);



        String content = "<html>"
                + "  <head>"
                + "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>"
                + "    <script type=\"text/javascript\">"
                + "      google.charts.load('current', {'packages':['gauge']});"
                + "      google.charts.setOnLoadCallback(drawChart);"
                + "      function drawChart() {"
                + "        var data = google.visualization.arrayToDataTable(["
                + "          ['Label', 'Value'],"
                + "          ['Oil Level', 15],"
                + "        ]);"
                + "        var options = {"
                + "          width: 800, height: 240,"
                + "          redFrom: 0, redTo: 10,"
                + "          yellowFrom:10, yellowTo: 20,"
                + "          minorTicks: 5"
                + "        };"

                + "        var chart = new google.visualization.Gauge(document.getElementById('chart_div'));"
                + "        chart.draw(data, options);"
                + "        setInterval(function() {"
                + "        data.setValue(0, 1, 10));"
                + "        chart.draw(data, options);"
                + "        }, 13000);"
                + "      }"

                + "    </script>"
                + "  </head>"
                + "  <body>"
                + "    <div id=\"chart_div\" style=\"width: 400px; height: 120px;\"></div>"
                + "  </body>" + "</html>";



        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.requestFocusFromTouch();

        webview.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf-8", null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gauge_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
