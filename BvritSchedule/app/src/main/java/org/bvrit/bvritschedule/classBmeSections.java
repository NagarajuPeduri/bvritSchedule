package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class classBmeSections extends AppCompatActivity {

    private Button bme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_bme_sections);

        bme = (Button)findViewById(R.id.bme);

        Intent in = getIntent();
        final String str = in.getStringExtra("deptname");

        bme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(classBmeSections.this, classDetails.class);
                intent.putExtra("section", str+"bme");
                startActivity(intent);
            }
        });

    }
}
