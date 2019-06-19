package org.bvrit.bvritschedule;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

public class classDetails extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    ProgressDialog progressDialog;
    PhotoViewAttacher pAttacher;

    private TextView inchargeName;
    private TextView inchargeNumber;
    private TextView inchargeEmail;
    private TextView cr1Name;
    private TextView cr1Number;
    private TextView cr1Email;
    private TextView cr2Name;
    private TextView cr2Number;
    private TextView cr2Email;
    private ImageView classSchedule;
    private FloatingActionButton edit;
    private static final int REQUEST_CALL=1;
    private TextView callIncharge, callcr1, callcr2;
    int flag1=0, flag2=0, flag3=0;
    String mobile, incNum, cr1Num, cr2Num, classTimeTablePicUrl;
    Button secTimetable;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length>0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else{
                Toast.makeText(classDetails.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_details);

        ActionBar actionBar = getSupportActionBar();

        final Intent intent = getIntent();
        String s = intent.getStringExtra("section");
        actionBar.setTitle(s);

        inchargeName = (TextView)findViewById(R.id.inchargeName);
        inchargeNumber = (TextView)findViewById(R.id.inchargeNumber);
        inchargeEmail = (TextView)findViewById(R.id.inchargeEmail);

        cr1Name = (TextView)findViewById(R.id.cr1Name);
        cr1Number = (TextView)findViewById(R.id.cr1Number);
        cr1Email = (TextView)findViewById(R.id.cr1Email);

        cr2Name = (TextView)findViewById(R.id.cr2Name);
        cr2Number = (TextView)findViewById(R.id.cr2Number);
        cr2Email = (TextView)findViewById(R.id.cr2Email);

        callIncharge = (TextView) findViewById(R.id.callIncharge);
        callcr1 = (TextView)findViewById(R.id.callCr1);
        callcr2 = (TextView)findViewById(R.id.callCr2);

        secTimetable = (Button)findViewById(R.id.sectionTimetable);

        callIncharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1=1;
                makePhoneCall();
            }
        });

        callcr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2=1;
                makePhoneCall();
            }
        });

        callcr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag3=0;
                makePhoneCall();
            }
        });

        edit = (FloatingActionButton)findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(classDetails.this, editClassDetails.class);
                String str = intent.getStringExtra("section");
                intent1.putExtra("whichSection", str);
                startActivity(intent1);
                finish();
            }
        });

        DividerItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL );
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("LOADING...");
        progressDialog.show();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child(intent.getStringExtra("section"));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                classProfile p = dataSnapshot.getValue(classProfile.class);

                if(p!=null) {

                    inchargeName.setText(p.getIncharge());
                    inchargeNumber.setText(p.getInchargeNumber());
                    inchargeEmail.setText(p.getInchargeEmail());

                    cr1Name.setText(p.getCr1());
                    cr1Number.setText(p.getCr1Number());
                    cr1Email.setText(p.getCr1Email());

                    cr2Name.setText(p.getCr2());
                    cr2Number.setText(p.getCr2Number());
                    cr2Email.setText(p.getCr2Email());

                    incNum = p.getInchargeNumber();
                    cr1Num = p.getCr1Number();
                    cr2Num = p.getCr2Number();

                    classTimeTablePicUrl = p.getScheduleUrl();
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(classDetails.this, "Data not uploaded..!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(classDetails.this, "No data available..!", Toast.LENGTH_LONG).show();
            }
        });

        secTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDetails.this, fullscreen.class);
                intent.putExtra("scheduleUrl", classTimeTablePicUrl);
                startActivity(intent);
            }
        });

    }

    private void makePhoneCall(){

        if(flag1==1){
            mobile = incNum;
        }
        else if(flag2==1){
            mobile = cr1Num;
        }
        else {
            mobile = cr2Num;
        }

        if(mobile.trim().length()>0){
            if(ContextCompat.checkSelfPermission(classDetails.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(classDetails.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            else{
                String dial = "tel:" + mobile;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
        else{
            Toast.makeText(classDetails.this, "invalid number", Toast.LENGTH_LONG).show();
        }
        flag1=0;
        flag2=0;
        flag3=0;
    }

}
