package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class guestLayout extends AppCompatActivity {

    private Button faculty;
    private Button classButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_layout);

        faculty = (Button)findViewById(R.id.faculty);
        classButton = (Button)findViewById(R.id.classButton);

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestLayout.this, guestFacutlyDepartment.class);
                startActivity(intent);
            }
        });

        classButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(guestLayout.this, guestDepartmentYear.class));
            }
        });


    }
}
