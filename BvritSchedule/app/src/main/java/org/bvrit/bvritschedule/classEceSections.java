package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class classEceSections extends AppCompatActivity {

    private Button eceA;
    private Button eceB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_ece_sections);

        eceA = (Button)findViewById(R.id.eceA);
        eceB = (Button)findViewById(R.id.eceB);

        Intent in = getIntent();
        final String s = in.getStringExtra("deptname");

        eceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classEceSections.this, classDetails.class);
                intent.putExtra("section", s+"eceA");
                startActivity(intent);
            }
        });

        eceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classEceSections.this, classDetails.class);
                intent.putExtra("section", s+"eceB");
                startActivity(intent);
            }
        });
    }
}
