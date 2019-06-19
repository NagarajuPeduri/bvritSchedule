package org.bvrit.bvritschedule;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewingFacutly extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    DatabaseReference myRef2;
    RecyclerView recyclerView;
    String s;
    ArrayList<Profile> list;
    ProgressDialog progressDialog;
    MyAdapter adapter;
    FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing_facutly);

        Intent intent = getIntent();
        s = intent.getStringExtra("deptname");

        add = (FloatingActionButton)findViewById(R.id.add);
        getSupportActionBar().setTitle(s);

        DividerItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL );
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(itemDecoration);
        list=new ArrayList<Profile>();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("LOADING...");
        progressDialog.show();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child(intent.getStringExtra("deptname"));
        myRef2 = database.getReference().child(intent.getStringExtra("deptname"));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                list.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Profile p=dataSnapshot1.getValue(Profile.class);
                    list.add(p);
                }
                adapter=new MyAdapter(ViewingFacutly.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ViewingFacutly.this, addingFacutly.class);
                in.putExtra("deptname", s);
                startActivity(in);
                finish();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        final SearchManager searchManager = (SearchManager) ViewingFacutly.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
            final String s=searchView.getQuery().toString();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    //click1(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                   // Toast.makeText(ViewingFacutly.this,newText,Toast.LENGTH_SHORT).show();
                    click1(newText);
                    return false;
                }
            });

        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(ViewingFacutly.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void click1(String s){

        list.clear();
        Toast.makeText(ViewingFacutly.this,s,Toast.LENGTH_SHORT).show();
        Query q=myRef2.orderByChild("name").startAt(s).endAt(s+"\uf8ff");

        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot2:dataSnapshot.getChildren())
                {
                    Profile p=dataSnapshot2.child("profile").getValue(Profile.class);

                    list.add(p);
                }
                if(list.isEmpty()){
                    Toast.makeText(ViewingFacutly.this,"not found",Toast.LENGTH_SHORT).show();
                }

                adapter=new MyAdapter(ViewingFacutly.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewingFacutly.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
