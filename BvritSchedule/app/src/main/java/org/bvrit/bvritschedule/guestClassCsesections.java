package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class guestClassCsesections extends AppCompatActivity {

    private Button cseA;
    private Button cseB;
    private Button cseC;
    private Button cseD;
    private Button cseE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_class_csesections);

        cseA = (Button)findViewById(R.id.cseA);
        cseB = (Button)findViewById(R.id.cseB);
        cseC = (Button)findViewById(R.id.cseC);
        cseD = (Button)findViewById(R.id.cseD);
        cseE = (Button)findViewById(R.id.cseE);

        Intent in = getIntent();
        final String str = in.getStringExtra("deptname");

        cseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassCsesections.this, guestClassDetails.class);
                intent.putExtra("section", str+"cseA");
                startActivity(intent);
            }
        });

        cseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassCsesections.this, guestClassDetails.class);
                intent.putExtra("section", str+"cseB");
                startActivity(intent);
            }
        });

        cseC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassCsesections.this, guestClassDetails.class);
                intent.putExtra("section", str+"cseC");
                startActivity(intent);
            }
        });

        cseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassCsesections.this, guestClassDetails.class);
                intent.putExtra("section", str+"cseD");
                startActivity(intent);
            }
        });

        cseE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassCsesections.this, guestClassDetails.class);
                intent.putExtra("section", str+"cseE");
                startActivity(intent);
            }
        });
    }
}
