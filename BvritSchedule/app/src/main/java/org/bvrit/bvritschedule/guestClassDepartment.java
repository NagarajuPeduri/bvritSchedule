package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class guestClassDepartment extends AppCompatActivity {

    private Button cse;
    private Button eee;
    private Button ece;
    private Button mech;
    private Button it;
    private Button chem;
    private Button bme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_class_department);

        cse = (Button)findViewById(R.id.cse);
        eee = (Button)findViewById(R.id.eee);
        ece = (Button)findViewById(R.id.ece);
        mech = (Button)findViewById(R.id.mech);
        it = (Button)findViewById(R.id.it);
        chem = (Button)findViewById(R.id.che);
        bme = (Button)findViewById(R.id.bme);

        Intent in = getIntent();

        final String str = in.getStringExtra("year");

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassCsesections.class);
                intent.putExtra("deptname", str+"cse ");
                startActivity(intent);
                finish();
            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassEeeSections.class);
                intent.putExtra("deptname", str+"eee ");
                startActivity(intent);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassEceSections.class);
                intent.putExtra("deptname", str+"ece ");
                startActivity(intent);
            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassMechSections.class);
                intent.putExtra("deptname", str+"mech ");
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassItSections.class);
                intent.putExtra("deptname", str+"IT");
                startActivity(intent);
            }
        });

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassChemSections.class);
                intent.putExtra("deptname", str+"chem");
                startActivity(intent);
            }
        });

        bme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassDepartment.this, guestClassBmeSections.class);
                intent.putExtra("deptname", str+"bme");
                startActivity(intent);
            }
        });

    }
}
