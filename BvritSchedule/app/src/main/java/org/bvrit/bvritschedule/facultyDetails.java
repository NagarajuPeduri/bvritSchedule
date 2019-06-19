package org.bvrit.bvritschedule;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class facultyDetails extends AppCompatActivity {

    CircleImageView profilePic;
    TextView name, email, number, call, yearSection, subject, roomNo, dayPeriod;
    String profileId, deptname, schedulePic;
    String period, details="", mobile, yearSec="";
    Button fulltimetable;
    private static final int REQUEST_CALL=1;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length>0 &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else{
                Toast.makeText(facultyDetails.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        profilePic = (CircleImageView) findViewById(R.id.profile);
        //schedulePic = (ImageView)findViewById(R.id.schedule);
        name = (TextView)findViewById(R.id.facultyName);
        fulltimetable = (Button)findViewById(R.id.fulltimetable);
        call = (TextView)findViewById(R.id.call);
        yearSection = (TextView)findViewById(R.id.insider);
        subject = (TextView)findViewById(R.id.subject);
        roomNo = (TextView)findViewById(R.id.roomNo);
        dayPeriod = (TextView)findViewById(R.id.dayPeriod);
       // pAttacher = new PhotoViewAttacher(schedulePic);

        ActionBar actionBar = getSupportActionBar();

        Intent intent = getIntent();
        String dis = intent.getStringExtra("name");
        dis = dis.substring(0, 1).toUpperCase() + dis.substring(1);
        actionBar.setTitle(dis);

        details = "Name: "+dis+"\n";
        details += "Email: "+intent.getStringExtra("email")+"\n";
        details += "Number: "+intent.getStringExtra("number");

        mobile = intent.getStringExtra("number");

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });



        name.setText(details);

        profileId = intent.getStringExtra("profileId");
        schedulePic = intent.getStringExtra("schedulePic");
        deptname = intent.getStringExtra("deptname");
        period = intent.getStringExtra("period");

        List<String> p = Arrays.asList(period.split(" "));

       // Toast.makeText(facultyDetails.this, Integer.toString(p.size()), Toast.LENGTH_SHORT).show();

        Date now = new Date();
        SimpleDateFormat day = new SimpleDateFormat("EEEE");
        DateFormat hrMin = new SimpleDateFormat("HH:mm:ss");

        List<String> time = Arrays.asList((hrMin.format(now)).split(":"));

        String today = day.format(now);
        int per = getPeriod(Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));

        //Toast.makeText(facultyDetails.this, time.get(0)+":"+time.get(1), Toast.LENGTH_LONG).show();

        if(per==-1){
            dayPeriod.setText(today);
        }
        else{
            today += ", period : " + Integer.toString(per);
            dayPeriod.setText(today);
        }

        String present = day.format(now);

        int index=0;

        if(present.equals("Monday")){
            index = indexReturn(1, Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));
        }
        else if(present.equals("Tuesday")){
            index = indexReturn(2, Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));
        }
        else if(present.equals("Wednesday")){
            index = indexReturn(3, Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));
        }
        else if(present.equals("Thursday")){
            index = indexReturn(4, Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));
        }
        else if(present.equals("Friday")){
            index = indexReturn(5, Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));
        }
        else if(present.equals("Saturday")){
            index = indexReturn(6, Integer.parseInt(time.get(0)), Integer.parseInt(time.get(1)));
        }
        else{
            index=-1;
        }

        if(index==-1){
            yearSection.setText("Break..!");
            subject.setText("--");
            roomNo.setText("--");
        }
        else if(index>p.size()){
            yearSection.setText("Please enter all the details");
            subject.setText("--");
            roomNo.setText("--");
        }
        else  if(p.get(index).equals("free")){
            yearSection.setText("No class");
            subject.setText("--");
            roomNo.setText("--");
        }
        else{
            yearSec += p.get(index+3)+" year"+"\n"+(p.get(index+2)).toUpperCase();
            yearSection.setText(yearSec);
            subject.setText(p.get(index));
            roomNo.setText(p.get(index+1));
        }

       // Toast.makeText(facultyDetails.this, time.get(0)+":"+time.get(1), Toast.LENGTH_LONG).show();

        Picasso.with(this)
                .load(intent.getStringExtra("profilePic"))
                .placeholder(R.drawable.user)
                .fit()
                .centerInside()
                .into(profilePic);

        fulltimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDetails.this, fullscreen.class);
                intent.putExtra("scheduleUrl", schedulePic);
                startActivity(intent);
            }
        });

       /* Picasso.with(this)
                .load(intent.getStringExtra("schedulePic"))
                .placeholder(R.drawable.timetable)
                .fit()
                .centerCrop()
                .into(schedulePic);

        pAttacher.update();*/

    }

    int indexReturn(int day, int hr, int min){

        int dayPeriod = 28*(day-1);
        int minutes = hr*60 + min;

        if(minutes>=570 && minutes<620){
            return dayPeriod;
        }
        else if(minutes>=620 && minutes<670){
            return dayPeriod+4;
        }
        else if(minutes>=680 && minutes<730){
            return dayPeriod+8;
        }
        else if(minutes>=730 && minutes<780){
            return dayPeriod+12;
        }
        else if(minutes>=820 && minutes<870){
            return dayPeriod+16;
        }
        else if(minutes>=870 && minutes<920){
            return dayPeriod+20;
        }
        else if(minutes>=920 && minutes<960){
            return dayPeriod+24;
        }
        else
            return -1;

    }

    int getPeriod(int hr, int min){
        int minutes = hr*60 + min;

        if(minutes>=570 && minutes<620){
            return 1;
        }
        else if(minutes>=620 && minutes<670){
            return 2;
        }
        else if(minutes>=680 && minutes<730){
            return 3;
        }
        else if(minutes>=730 && minutes<780){
            return 4;
        }
        else if(minutes>=820 && minutes<870){
            return 5;
        }
        else if(minutes>=870 && minutes<920){
            return 6;
        }
        else if(minutes>=920 && minutes<960){
            return 7;
        }
        else
            return -1;

    }

    private void makePhoneCall(){
        if(mobile.trim().length()>0){
            if(ContextCompat.checkSelfPermission(facultyDetails.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(facultyDetails.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            else{
                String dial = "tel:" + mobile;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
        else{
            Toast.makeText(facultyDetails.this, "invalid number", Toast.LENGTH_LONG).show();
        }
    }

}
