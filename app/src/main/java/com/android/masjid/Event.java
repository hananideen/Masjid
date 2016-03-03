package com.android.masjid;

/**
 * Created by Hanani on 2/3/2016.
 */
public class Event {
    String title, date, speaker, time, description;

    Event(String title, String date, String speaker, String time, String description) {
        this.title = title;
        this.date = date;
        this.speaker = speaker;
        this.time = time;
        this.description = description;
    }
}
