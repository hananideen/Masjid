package com.android.masjid;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    public static String TITLE = "title";
    public static String DATE = "date";
    public static String SPEAKER = "speaker";
    public static String TIME = "time";

    private String title, date, speaker, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        title = getIntent().getStringExtra(TITLE);
        date = getIntent().getStringExtra(DATE);
        speaker = getIntent().getStringExtra(SPEAKER);
        time = getIntent().getStringExtra(TIME);

        setToolbar();

        setData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Favourite!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        collapsingToolbarLayout.setTitle(title);
        toolbar.setTitle(title);
    }

    private void  setData(){
        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        TextView tvSpeaker = (TextView) findViewById(R.id.tvSpeaker);
        TextView tvTime = (TextView) findViewById(R.id.tvTime);
        TextView tvPlace = (TextView) findViewById(R.id.tvPlace);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);

        tvDate.setText(date);
        tvSpeaker.setText(speaker);
        tvTime.setText(time);
        tvPlace.setText("Masjid Kita");
        tvDescription.setText(getString(R.string.large_text));
    }
}
