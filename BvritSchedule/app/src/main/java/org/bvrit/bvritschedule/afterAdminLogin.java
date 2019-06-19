package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class afterAdminLogin extends AppCompatActivity {
    private Button Facutly;
    private Button Student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_admin_login);

        Facutly = (Button) findViewById(R.id.faculty);
        Student = (Button) findViewById(R.id.classButton);

        Facutly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(afterAdminLogin.this, facultyDepartment.class);
                startActivity(f);
            }
        });

        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(afterAdminLogin.this, departmentYear.class);
                startActivity(s);
            }
        });

    }
}
