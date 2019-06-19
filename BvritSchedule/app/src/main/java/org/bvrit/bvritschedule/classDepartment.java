package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class classDepartment extends AppCompatActivity {

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
        setContentView(R.layout.activity_class_department);

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
                Intent intent = new Intent(classDepartment.this, classCseSections.class);
                intent.putExtra("deptname", str+"cse ");
                startActivity(intent);
                finish();
            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDepartment.this, classEeeSections.class);
                intent.putExtra("deptname", str+"eee ");
                startActivity(intent);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDepartment.this, classEceSections.class);
                intent.putExtra("deptname", str+"ece ");
                startActivity(intent);
            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDepartment.this, classMechSections.class);
                intent.putExtra("deptname", str+"mech ");
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDepartment.this, classItSections.class);
                intent.putExtra("deptname", str+"IT");
                startActivity(intent);
            }
        });

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDepartment.this, classChemSections.class);
                intent.putExtra("deptname", str+"chem");
                startActivity(intent);
            }
        });

        bme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classDepartment.this, classBmeSections.class);
                intent.putExtra("deptname", str+"bme");
                startActivity(intent);
            }
        });

    }
}
