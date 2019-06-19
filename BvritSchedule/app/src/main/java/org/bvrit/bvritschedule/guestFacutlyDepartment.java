package org.bvrit.bvritschedule;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class guestFacutlyDepartment extends AppCompatActivity {
    private Button cse;
    private Button eee;
    private Button ece;
    private Button mech;
    private Button it;
    private Button chem;
    private Button bme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_facutly_department);

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
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "Computer Science and engineering");
                startActivity(intent);
                finish();
            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "Electrical and Electronic engineering");
                startActivity(intent);
            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "Electronics and Communication Engineering");
                startActivity(intent);
            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "Mechanical Engineering");
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "Information Technology");
                startActivity(intent);
            }
        });

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "chemical engineering");
                startActivity(intent);
            }
        });

        bme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(guestFacutlyDepartment.this, guestViewingFaculty.class);
                intent.putExtra("deptname", "Bio medical engineering");
                startActivity(intent);
            }
        });

    }

}
