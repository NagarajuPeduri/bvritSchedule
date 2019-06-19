package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class facultyDepartment extends AppCompatActivity {

    private Button cse;
    private Button eee;
    private Button ece;
    private Button mech;
    private Button it;
    private Button chem;
    private Button bme;

    private Button addFaculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_department);
        // call view faculty layout
        cse = (Button)findViewById(R.id.cse);
        eee = (Button)findViewById(R.id.eee);
        ece = (Button)findViewById(R.id.ece);
        mech = (Button)findViewById(R.id.mech);
        it = (Button)findViewById(R.id.it);
        chem = (Button)findViewById(R.id.che);
        bme = (Button)findViewById(R.id.bme);

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "Computer Science and engineering");
                startActivity(intent);
            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "Electrical and Electronic engineering");
                startActivity(intent);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "Electronics and Communication Engineering");
                startActivity(intent);
            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "Mechanical Engineering");
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "Information Technology");
                startActivity(intent);
            }
        });

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "chemical engineering");
                startActivity(intent);
            }
        });

        bme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(facultyDepartment.this, ViewingFacutly.class);
                intent.putExtra("deptname", "Bio medical engineering");
                startActivity(intent);
            }
        });

    }
}
