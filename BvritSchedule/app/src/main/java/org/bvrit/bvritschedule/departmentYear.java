package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class departmentYear extends AppCompatActivity {

    private Button firstYear;
    private Button secondYear;
    private Button thirdYear;
    private Button fourthYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_year);

        firstYear = (Button)findViewById(R.id.firstYear);
        secondYear = (Button)findViewById(R.id.secondYear);
        thirdYear = (Button)findViewById(R.id.thirdYear);
        fourthYear = (Button)findViewById(R.id.fourthYear);

        firstYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(departmentYear.this, firstYearSections.class);
                intent.putExtra("year", "First year ");
                startActivity(intent);
                //startActivity(new Intent(departmentYear.this, firstYearSections.class));
            }
        });

        secondYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(departmentYear.this, classDepartment.class);
                intent.putExtra("year", "Second year ");
                startActivity(intent);            }
        });

        thirdYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(departmentYear.this, classDepartment.class);
                intent.putExtra("year", "Third year ");
                startActivity(intent);
            }
        });

        fourthYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(departmentYear.this, classDepartment.class);
                intent.putExtra("year", "Fourth year");
                startActivity(intent);
            }
        });
    }
}
