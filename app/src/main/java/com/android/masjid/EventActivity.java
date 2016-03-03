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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        String title = getIntent().getStringExtra(TITLE);
        String date = getIntent().getStringExtra(DATE);
        String speaker = getIntent().getStringExtra(SPEAKER);
        String time = getIntent().getStringExtra(TIME);

        collapsingToolbarLayout.setTitle(title);
        toolbar.setTitle(title);

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        TextView tvSpeaker = (TextView) findViewById(R.id.tvSpeaker);
        TextView tvTime = (TextView) findViewById(R.id.tvTime);
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);

        tvDate.setText(date);
        tvSpeaker.setText(speaker);
        tvTime.setText(time);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Favourite!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }
}
