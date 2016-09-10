package com.seratic.enterprise.cronodatab;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class CronoActivity extends AppCompatActivity implements View.OnClickListener {

    Chronometer focus;
    Button start, stop, restart, datab;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);

        start = (Button) findViewById(R.id.button1);
        stop = (Button) findViewById(R.id.button2);
        restart = (Button) findViewById(R.id.button3);
        datab = (Button) findViewById(R.id.databinding);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cronometro y Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datab.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        restart.setOnClickListener(this);

        focus = (Chronometer) findViewById(R.id.chronometer1);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            onBackPressed();
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                focus.start();
            break;
            case R.id.button2:
                focus.stop();
                break;
            case R.id.button3:
                focus.setBase(SystemClock.elapsedRealtime());
                break;
            case R.id.databinding:
                startActivity(new Intent(this,DataBindActivity.class));
                break;

        }
    }
}
