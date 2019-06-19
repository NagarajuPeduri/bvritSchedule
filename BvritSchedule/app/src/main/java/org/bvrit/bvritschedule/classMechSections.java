package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class classMechSections extends AppCompatActivity {

    private Button mech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_mech_sections);

        mech = (Button)findViewById(R.id.mech);

        Intent in = getIntent();
        final String str = in.getStringExtra("deptname");

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classMechSections.this, classDetails.class);
                intent.putExtra("section", str+"mech");
                startActivity(intent);
            }
        });

    }
}
