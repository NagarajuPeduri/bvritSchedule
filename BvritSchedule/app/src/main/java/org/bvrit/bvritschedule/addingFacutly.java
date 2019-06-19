package org.bvrit.bvritschedule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class addingFacutly extends AppCompatActivity implements dialogHandle.ExampleDialogListener {

    EditText name1;
    EditText email1;
    EditText number1;
    Button browse;
    Button addSchedule;
    String profileUrl, scheduleUrl;
    private RadioGroup check;

    String[] inTake = new String[168];
    
    String period="";
    
    private RadioButton monday1;
    private RadioButton monday2;
    private RadioButton monday3;
    private RadioButton monday4;
    private RadioButton monday5;
    private RadioButton monday6;
    private RadioButton monday7;
    private RadioButton tuesday1;
    private RadioButton tuesday2;
    private RadioButton tuesday3;
    private RadioButton tuesday4;
    private RadioButton tuesday5;
    private RadioButton tuesday6;
    private RadioButton tuesday7;
    private RadioButton wednesday1;
    private RadioButton wednesday2;
    private RadioButton wednesday3;
    private RadioButton wednesday4;
    private RadioButton wednesday5;
    private RadioButton wednesday6;
    private RadioButton wednesday7;
    private RadioButton thursday1;
    private RadioButton thursday2;
    private RadioButton thursday3;
    private RadioButton thursday4;
    private RadioButton thursday5;
    private RadioButton thursday6;
    private RadioButton thursday7;
    private RadioButton friday1;
    private RadioButton friday2;
    private RadioButton friday3;
    private RadioButton friday4;
    private RadioButton friday5;
    private RadioButton friday6;
    private RadioButton friday7;
    private RadioButton saturday1;
    private RadioButton saturday2;
    private RadioButton saturday3;
    private RadioButton saturday4;
    private RadioButton saturday5;
    private RadioButton saturday6;
    private RadioButton saturday7;

    private Button ok1;
    private Button ok2;
    private Button ok3;
    private Button ok4;
    private Button ok5;
    private Button ok6;
    private Button ok7;
    private Button ok8;
    private Button ok9;
    private Button ok10;
    private Button ok11;
    private Button ok12;
    private Button ok13;
    private Button ok14;
    private Button ok15;
    private Button ok16;
    private Button ok17;
    private Button ok18;
    private Button ok19;
    private Button ok20;
    private Button ok21;
    private Button ok22;
    private Button ok23;
    private Button ok24;
    private Button ok25;
    private Button ok26;
    private Button ok27;
    private Button ok28;
    private Button ok29;
    private Button ok30;
    private Button ok31;
    private Button ok32;
    private Button ok33;
    private Button ok34;
    private Button ok35;
    private Button ok36;
    private Button ok37;
    private Button ok38;
    private Button ok39;
    private Button ok40;
    private Button ok41;
    private Button ok42;

    private int flag=0, mainCount=0;

    String s = "";

    String sname,semail,snumber;
    FirebaseDatabase database;
    DatabaseReference reference;
    private static final int GALLERY_INTENT = 2;
    private ProgressDialog mprogress;
    private StorageReference mstorage;
    private DatabaseReference mRootRef, facultyRef;
    String deptname;

    @Override
    public void applyTexts(String subject, String room, String clas, String year) {
        
        //period+=subject+" "+room+" "+clas+" "+year+" ";

        inTake[mainCount*4]=subject;
        inTake[mainCount*4+1] = room;
        inTake[mainCount*4+2] = clas;
        inTake[mainCount*4+3] = year;

        Toast.makeText(addingFacutly.this, "Done", Toast.LENGTH_LONG).show();
    }

    public void openDialog(){
        dialogHandle exampleDialog;
        exampleDialog = new dialogHandle();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_facutly);

        Intent in = getIntent();
        deptname = in.getStringExtra("deptname");

        for(int i=0; i<168; i++){
            inTake[i] = "free";
        }

        ok1 = (Button)findViewById(R.id.ok1);
        ok2 = (Button)findViewById(R.id.ok2);
        ok3 = (Button)findViewById(R.id.ok3);
        ok4 = (Button)findViewById(R.id.ok4);
        ok5 = (Button)findViewById(R.id.ok5);
        ok6 = (Button)findViewById(R.id.ok6);
        ok7 = (Button)findViewById(R.id.ok7);
        ok8 = (Button)findViewById(R.id.ok8);
        ok9 = (Button)findViewById(R.id.ok9);
        ok10 = (Button)findViewById(R.id.ok10);
        ok11 = (Button)findViewById(R.id.ok11);
        ok12 = (Button)findViewById(R.id.ok12);
        ok13 = (Button)findViewById(R.id.ok13);
        ok14 = (Button)findViewById(R.id.ok14);
        ok15 = (Button)findViewById(R.id.ok15);
        ok16 = (Button)findViewById(R.id.ok16);
        ok17 = (Button)findViewById(R.id.ok17);
        ok18 = (Button)findViewById(R.id.ok18);
        ok19 = (Button)findViewById(R.id.ok19);
        ok20 = (Button)findViewById(R.id.ok20);
        ok21 = (Button)findViewById(R.id.ok21);
        ok22 = (Button)findViewById(R.id.ok22);
        ok23 = (Button)findViewById(R.id.ok23);
        ok24 = (Button)findViewById(R.id.ok24);
        ok25 = (Button)findViewById(R.id.ok25);
        ok26 = (Button)findViewById(R.id.ok26);
        ok27 = (Button)findViewById(R.id.ok27);
        ok28 = (Button)findViewById(R.id.ok28);
        ok29 = (Button)findViewById(R.id.ok29);
        ok30 = (Button)findViewById(R.id.ok30);
        ok31 = (Button)findViewById(R.id.ok31);
        ok32 = (Button)findViewById(R.id.ok32);
        ok33 = (Button)findViewById(R.id.ok33);
        ok34 = (Button)findViewById(R.id.ok34);
        ok35 = (Button)findViewById(R.id.ok35);
        ok36 = (Button)findViewById(R.id.ok36);
        ok37 = (Button)findViewById(R.id.ok37);
        ok38 = (Button)findViewById(R.id.ok38);
        ok39 = (Button)findViewById(R.id.ok39);
        ok40 = (Button)findViewById(R.id.ok40);
        ok41 = (Button)findViewById(R.id.ok41);
        ok42 = (Button)findViewById(R.id.ok42);

        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period1);
                int flag = check.getCheckedRadioButtonId();
                monday1 = (RadioButton)findViewById(flag);
                mainCount=0;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday1.getText().toString().equals("have class")){
                    openDialog();
                }
                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period2);
                int flag = check.getCheckedRadioButtonId();
                monday2 = (RadioButton)findViewById(flag);

                mainCount=1;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday2.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period3);
                int flag = check.getCheckedRadioButtonId();
                monday3 = (RadioButton)findViewById(flag);

                mainCount=2;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday3.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period4);
                int flag = check.getCheckedRadioButtonId();
                monday4 = (RadioButton)findViewById(flag);

                mainCount=3;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday4.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period5);
                int flag = check.getCheckedRadioButtonId();
                monday5 = (RadioButton)findViewById(flag);

                mainCount=4;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday5.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period6);
                int flag = check.getCheckedRadioButtonId();
                monday6 = (RadioButton)findViewById(flag);

                mainCount=5;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday6.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.monday_period7);
                int flag = check.getCheckedRadioButtonId();
                monday7 = (RadioButton)findViewById(flag);

                mainCount=6;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(monday7.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period1);
                int flag = check.getCheckedRadioButtonId();
                tuesday1 = (RadioButton)findViewById(flag);

                mainCount=7;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday1.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period2);
                int flag = check.getCheckedRadioButtonId();
                tuesday2 = (RadioButton)findViewById(flag);

                mainCount=8;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday2.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period3);
                int flag = check.getCheckedRadioButtonId();
                tuesday3 = (RadioButton)findViewById(flag);

                mainCount=9;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday3.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period4);
                int flag = check.getCheckedRadioButtonId();
                tuesday4 = (RadioButton)findViewById(flag);

                mainCount=10;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday4.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period5);
                int flag = check.getCheckedRadioButtonId();
                tuesday5 = (RadioButton)findViewById(flag);

                mainCount=11;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday5.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period6);
                int flag = check.getCheckedRadioButtonId();
                tuesday6 = (RadioButton)findViewById(flag);

                mainCount=12;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday6.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.tuesday_period7);
                int flag = check.getCheckedRadioButtonId();
                tuesday7 = (RadioButton)findViewById(flag);

                mainCount=13;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(tuesday7.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period1);
                int flag = check.getCheckedRadioButtonId();
                wednesday1 = (RadioButton)findViewById(flag);

                mainCount=14;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday1.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period2);
                int flag = check.getCheckedRadioButtonId();
                wednesday2 = (RadioButton)findViewById(flag);

                mainCount=15;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday2.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period3);
                int flag = check.getCheckedRadioButtonId();
                wednesday3 = (RadioButton)findViewById(flag);

                mainCount=16;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday3.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period4);
                int flag = check.getCheckedRadioButtonId();
                wednesday4 = (RadioButton)findViewById(flag);

                mainCount=17;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday4.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period5);
                int flag = check.getCheckedRadioButtonId();
                wednesday5 = (RadioButton)findViewById(flag);

                mainCount=18;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday5.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period6);
                int flag = check.getCheckedRadioButtonId();
                wednesday6 = (RadioButton)findViewById(flag);

                mainCount=19;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday6.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.wednesday_period7);
                int flag = check.getCheckedRadioButtonId();
                wednesday7 = (RadioButton)findViewById(flag);

                mainCount=20;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(wednesday7.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period1);
                int flag = check.getCheckedRadioButtonId();
                thursday1 = (RadioButton)findViewById(flag);
                
                mainCount=21;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday1.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period2);
                int flag = check.getCheckedRadioButtonId();
                thursday2 = (RadioButton)findViewById(flag);
                
                mainCount=22;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday2.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period3);
                int flag = check.getCheckedRadioButtonId();
                thursday3 = (RadioButton)findViewById(flag);
                
                mainCount=23;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday3.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period4);
                int flag = check.getCheckedRadioButtonId();
                thursday4 = (RadioButton)findViewById(flag);
                
                mainCount=24;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday4.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period5);
                int flag = check.getCheckedRadioButtonId();
                thursday5 = (RadioButton)findViewById(flag);
                
                mainCount=25;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday5.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period6);
                int flag = check.getCheckedRadioButtonId();
                thursday6 = (RadioButton)findViewById(flag);
                
                mainCount=26;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday6.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.thursday_period7);
                int flag = check.getCheckedRadioButtonId();
                thursday7 = (RadioButton)findViewById(flag);
                
                mainCount=27;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(thursday7.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period1);
                int flag = check.getCheckedRadioButtonId();
                friday1 = (RadioButton)findViewById(flag);
                
                mainCount=28;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday1.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period2);
                int flag = check.getCheckedRadioButtonId();
                friday2 = (RadioButton)findViewById(flag);
                
                mainCount=29;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday2.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period3);
                int flag = check.getCheckedRadioButtonId();
                friday3 = (RadioButton)findViewById(flag);
                
                mainCount=30;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday3.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period4);
                int flag = check.getCheckedRadioButtonId();
                friday4 = (RadioButton)findViewById(flag);
                
                mainCount=31;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday4.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period5);
                int flag = check.getCheckedRadioButtonId();
                friday5 = (RadioButton)findViewById(flag);
                
                mainCount=32;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday5.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period6);
                int flag = check.getCheckedRadioButtonId();
                friday6 = (RadioButton)findViewById(flag);
                
                mainCount=33;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday6.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.friday_period7);
                int flag = check.getCheckedRadioButtonId();
                friday7 = (RadioButton)findViewById(flag);
                
                mainCount=34;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(friday7.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period1);
                int flag = check.getCheckedRadioButtonId();
                saturday1 = (RadioButton)findViewById(flag);
                
                mainCount=35;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday1.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period2);
                int flag = check.getCheckedRadioButtonId();
                saturday2 = (RadioButton)findViewById(flag);
                
                mainCount=36;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday2.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period3);
                int flag = check.getCheckedRadioButtonId();
                saturday3 = (RadioButton)findViewById(flag);
                
                mainCount=37;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday3.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period4);
                int flag = check.getCheckedRadioButtonId();
                saturday4 = (RadioButton)findViewById(flag);
                
                mainCount=38;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday4.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period5);
                int flag = check.getCheckedRadioButtonId();
                saturday5 = (RadioButton)findViewById(flag);
                
                mainCount=39;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday5.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period6);
                int flag = check.getCheckedRadioButtonId();
                saturday6 = (RadioButton)findViewById(flag);
                
                mainCount=40;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday6.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        ok42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = (RadioGroup)findViewById(R.id.saturday_period7);
                int flag = check.getCheckedRadioButtonId();
                saturday7 = (RadioButton)findViewById(flag);
                
                mainCount=41;

                //Toast.makeText(addingFacutly.this, haveClass.getText().toString(), Toast.LENGTH_LONG).show();

                if(saturday7.getText().toString().equals("have class")){
                    openDialog();
                }

                else{
                    inTake[mainCount*4]="free";
                    inTake[mainCount*4+1] = "free";
                    inTake[mainCount*4+2] = "free";
                    inTake[mainCount*4+3] = "free";
                    Toast.makeText(addingFacutly.this, "done", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        name1 = (EditText)findViewById(R.id.name);
        email1 = (EditText)findViewById(R.id.email);
        number1 = (EditText)findViewById(R.id.number);
        browse = (Button)findViewById(R.id.browseImage);
        mprogress = new ProgressDialog(this);
        addSchedule = (Button)findViewById(R.id.addSchedule);

        mstorage = FirebaseStorage.getInstance().getReference();

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="browse";
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });

        addSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "schedule";
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK){

            mprogress.setMessage("Uploading image...");
            mprogress.show();

            Uri uri = data.getData();
            final StorageReference filepath = mstorage.child("photos").child(uri.getLastPathSegment());
            filepath.putFile(uri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();
                    }
                    return filepath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful()){
                        mprogress.dismiss();
                        Uri downloadUri = task.getResult();

                        if(s.equals("browse")) {
                            profileUrl = downloadUri.toString();
                        }
                        else{
                            scheduleUrl = downloadUri.toString();
                        }

                        if(flag==1) {
                            String name = name1.getText().toString();
                            String email = email1.getText().toString();
                            String number = number1.getText().toString();

                            for(int i=0; i<168; i++){
                                period += inTake[i]+" ";
                            }

                            intiImageBitmaps(profileUrl, scheduleUrl, name, email, number);

                            finish();
                        }
                        flag=1;
                        //text.setText(s);
                        Toast.makeText(addingFacutly.this, "upload done", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(addingFacutly.this, "upload failed", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void intiImageBitmaps(String profile, String schedule, String name, String email, String number){
        mRootRef = FirebaseDatabase.getInstance().getReference();
        facultyRef = mRootRef.child(deptname);
        String id = facultyRef.push().getKey();

        Profile p = new Profile(name, email, number, profile, schedule, id, deptname, period);

        facultyRef.child(id).setValue(p);
        
    }
}
