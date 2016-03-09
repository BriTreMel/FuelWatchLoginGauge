package com.example.mel76.fuelwatch11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;




public class MainActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // handler to move from splash screen to login screen

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //create an intent that will start the log in screen
                Intent logInIntent = new Intent(MainActivity.this,log_in_screen.class);
                MainActivity.this.startActivity(logInIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}
