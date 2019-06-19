package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class classEeeSections extends AppCompatActivity {

    private Button eeeA;
    private Button eeeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_eee_sections);

        eeeA = (Button)findViewById(R.id.eeeA);
        eeeB = (Button)findViewById(R.id.eeeB);

        Intent in = getIntent();

        final String s = in.getStringExtra("deptname");

        eeeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classEeeSections.this, classDetails.class);
                intent.putExtra("section", s+"eeeA");
                startActivity(intent);
            }
        });

        eeeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classEeeSections.this, classDetails.class);
                intent.putExtra("section", s+"eeeB");
                startActivity(intent);
            }
        });
    }
}
