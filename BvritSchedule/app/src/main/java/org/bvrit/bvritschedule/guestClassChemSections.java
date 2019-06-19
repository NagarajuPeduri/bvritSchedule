package org.bvrit.bvritschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class guestClassChemSections extends AppCompatActivity {

    private Button chem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_class_chem_sections);

        chem = (Button)findViewById(R.id.chem);
        Intent in = getIntent();
        final String s = in.getStringExtra("deptname");

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestClassChemSections.this, guestClassDetails.class);
                intent.putExtra("section", s+"chem");
                startActivity(intent);
            }
        });

    }
}
