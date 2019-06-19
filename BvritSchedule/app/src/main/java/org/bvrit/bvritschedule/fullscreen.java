package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class fullscreen extends AppCompatActivity {

    ImageView fullscreen;
    PhotoViewAttacher pAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        fullscreen = (ImageView)findViewById(R.id.fullscreen);
        pAttacher = new PhotoViewAttacher(fullscreen);

        Intent intent = getIntent();

        Picasso.with(this)
                .load(intent.getStringExtra("scheduleUrl"))
                .into(fullscreen);

        pAttacher.update();

    }
}
