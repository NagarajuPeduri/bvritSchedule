package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class guestClassItSections extends AppCompatActivity {

    private Button itA;
    private Button itB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_class_it_sections);

        itA = (Button)findViewById(R.id.itA);
        itB = (Button)findViewById(R.id.itB);

        Intent in = getIntent();
        final String s= in.getStringExtra("deptname");

        itA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassItSections.this, guestClassDetails.class);
                intent.putExtra("section", s+"itA");
                startActivity(intent);
            }
        });

        itB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassItSections.this, guestClassDetails.class);
                intent.putExtra("section", s+"itB");
                startActivity(intent);
            }
        });

    }
}
