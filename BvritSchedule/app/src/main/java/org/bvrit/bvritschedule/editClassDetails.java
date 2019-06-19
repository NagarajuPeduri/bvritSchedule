package org.bvrit.bvritschedule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class editClassDetails extends AppCompatActivity {

    private EditText inchargeName;
    private EditText inchargeNumber;
    private EditText inchargeEmail;
    private EditText cr1Name;
    private EditText cr1Number;
    private EditText cr1Email;
    private EditText cr2Name;
    private EditText cr2Number;
    private EditText cr2Email;

    private Button sectionTimeTable;
    private String section;

    FirebaseDatabase database;
    DatabaseReference reference;
    private static final int GALLERY_INTENT = 2;
    private ProgressDialog mprogress;
    private StorageReference mstorage;
    private DatabaseReference mRootRef, facultyRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add details");

        Intent intent = getIntent();
        section = intent.getStringExtra("whichSection");

        inchargeName = (EditText)findViewById(R.id.inchargeName);
        inchargeNumber = (EditText)findViewById(R.id.inchargeNumber);
        inchargeEmail = (EditText)findViewById(R.id.inchargeEmail);

        cr1Name = (EditText)findViewById(R.id.cr1Name);
        cr1Number = (EditText)findViewById(R.id.cr1Number);
        cr1Email = (EditText)findViewById(R.id.cr1Email);

        cr2Name = (EditText)findViewById(R.id.cr2Name);
        cr2Number = (EditText)findViewById(R.id.cr2Number);
        cr2Email = (EditText)findViewById(R.id.cr2Email);

        sectionTimeTable = (Button)findViewById(R.id.classTimeTable);

        mprogress = new ProgressDialog(this);
        mstorage = FirebaseStorage.getInstance().getReference();

        sectionTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            mprogress.setMessage("Uploading image...");
            mprogress.show();

            Uri uri = data.getData();
            final StorageReference filepath = mstorage.child("photos").child(uri.getLastPathSegment());
            filepath.putFile(uri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return filepath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        mprogress.dismiss();
                        Uri downloadUri = task.getResult();
                        String inName = inchargeName.getText().toString();
                        String inNumber = inchargeNumber.getText().toString();
                        String inEmail = inchargeEmail.getText().toString();

                        String c1Name = cr1Name.getText().toString();
                        String c1Number = cr1Number.getText().toString();
                        String c1Email = cr1Email.getText().toString();

                        String c2Name = cr2Name.getText().toString();
                        String c2Number = cr2Number.getText().toString();
                        String c2Email = cr2Email.getText().toString();

                        intiImageBitmaps(inName, inNumber, inEmail, c1Name, c1Number, c1Email, c2Name, c2Number, c2Email, downloadUri.toString());

                        //text.setText(s);
                        Toast.makeText(editClassDetails.this, "upload done", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(editClassDetails.this, "upload failed", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void intiImageBitmaps(String inchargeName, String inchargeNumber, String inchargeEmail, String cr1Name, String cr1Number, String cr1Email, String cr2Name, String cr2Number, String cr2Email, String sectionUrl){
        mRootRef = FirebaseDatabase.getInstance().getReference();
        facultyRef = mRootRef.child(section);

        classProfile p = new classProfile(sectionUrl, inchargeName, inchargeNumber, inchargeEmail, cr1Name, cr2Name, cr1Number, cr1Email, cr2Number, cr2Email);
        facultyRef.setValue(p);
    }

}
