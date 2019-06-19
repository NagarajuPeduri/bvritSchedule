package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class admin_faculty_details extends AppCompatActivity {

    ImageView schedulePic;
    CircleImageView profilePic;
    TextView name, email, number;
    PhotoViewAttacher pAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_faculty_details);

        profilePic = (CircleImageView) findViewById(R.id.profile);
        schedulePic = (ImageView)findViewById(R.id.schedule);
        name = (TextView)findViewById(R.id.facultyName);
        email = (TextView)findViewById(R.id.facultyEmail);
        number = (TextView)findViewById(R.id.facultyNumber);
        pAttacher = new PhotoViewAttacher(schedulePic);

        ActionBar actionBar = getSupportActionBar();
        TextView details = findViewById(R.id.textView);

        Intent intent = getIntent();
        String dis = intent.getStringExtra("name");
        dis = dis.substring(0, 1).toUpperCase() + dis.substring(1);
        actionBar.setTitle(dis);
        name.setText(intent.getStringExtra("name"));
        email.setText(intent.getStringExtra("email"));
        number.setText(intent.getStringExtra("number"));

        Picasso.with(this)
                .load(intent.getStringExtra("profilePic"))
                .placeholder(R.drawable.user)
                .fit()
                .centerCrop()
                .into(profilePic);

        Picasso.with(this)
                .load(intent.getStringExtra("schedulePic"))
                .placeholder(R.drawable.timetable)
                .fit()
                .centerCrop()
                .into(schedulePic);

        pAttacher.update();

    }
}
