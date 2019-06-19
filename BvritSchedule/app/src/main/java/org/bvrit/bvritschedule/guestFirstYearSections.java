package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class guestFirstYearSections extends AppCompatActivity {

    private Button lh1;
    private Button lh2;
    private Button lh3;
    private Button lh4;
    private Button lh5;
    private Button lh6;
    private Button lh7;
    private Button lh8;
    private Button lh9;
    private Button lh10;
    private Button lh11;
    private Button lh12;
    private Button lh13;
    private Button lh14;
    private Button lh15;
    private Button lh16;
    private Button lh17;
    private Button lh18;
    private Button lh19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_first_year_sections);

        lh1 = (Button)findViewById(R.id.lh1);
        lh2 = (Button)findViewById(R.id.lh2);
        lh3 = (Button)findViewById(R.id.lh3);
        lh4 = (Button)findViewById(R.id.lh4);
        lh5 = (Button)findViewById(R.id.lh5);
        lh6 = (Button)findViewById(R.id.lh6);
        lh7 = (Button)findViewById(R.id.lh7);
        lh8 = (Button)findViewById(R.id.lh8);
        lh9 = (Button)findViewById(R.id.lh9);
        lh10 = (Button)findViewById(R.id.lh10);
        lh11 = (Button)findViewById(R.id.lh11);
        lh12 = (Button)findViewById(R.id.lh12);
        lh13 = (Button)findViewById(R.id.lh13);
        lh14 = (Button)findViewById(R.id.lh14);
        lh15 = (Button)findViewById(R.id.lh15);
        lh16 = (Button)findViewById(R.id.lh16);
        lh17 = (Button)findViewById(R.id.lh17);
        lh18 = (Button)findViewById(R.id.lh18);
        lh19 = (Button)findViewById(R.id.lh19);

        Intent intent = getIntent();
        final String str = intent.getStringExtra("year");

        lh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh1");
                startActivity(intent1);
            }
        });

        lh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh2");
                startActivity(intent1);
            }
        });

        lh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh3");
                startActivity(intent1);
            }
        });

        lh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh4");
                startActivity(intent1);
            }
        });

        lh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh5");
                startActivity(intent1);
            }
        });

        lh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh6");
                startActivity(intent1);
            }
        });

        lh7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh7");
                startActivity(intent1);
            }
        });

        lh8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh8");
                startActivity(intent1);
            }
        });

        lh9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh9");
                startActivity(intent1);
            }
        });

        lh10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh10");
                startActivity(intent1);
            }
        });

        lh11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh11");
                startActivity(intent1);
            }
        });

        lh12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh12");
                startActivity(intent1);
            }
        });

        lh13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh13");
                startActivity(intent1);
            }
        });

        lh14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh14");
                startActivity(intent1);
            }
        });

        lh15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh15");
                startActivity(intent1);
            }
        });

        lh16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh16");
                startActivity(intent1);
            }
        });

        lh17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh17");
                startActivity(intent1);
            }
        });

        lh18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh18");
                startActivity(intent1);
            }
        });

        lh19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(guestFirstYearSections.this, guestClassDetails.class);
                intent1.putExtra("section", str+"lh19");
                startActivity(intent1);
            }
        });

    }
}
