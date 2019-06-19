package org.bvrit.bvritschedule;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.squareup.picasso.Picasso;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Profile> profiles;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    public MyAdapter(Context c, ArrayList<Profile> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.name.setText(profiles.get(position).getName());
        holder.email.setText(profiles.get(position).getEmail());

        final Profile uploadCurrent = profiles.get(position);

        firebaseStorage=FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference();

        Picasso.with(context)
                //.load(uploadCurrent.getProfilePic())
                .load(profiles.get(position).getProfilePic())
                .placeholder(R.drawable.user)
                .fit()
                .centerCrop()
                .into(holder.url);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, facultyDetails.class);
                Profile p = (Profile)profiles.get(position);
                intent.putExtra("name", p.getName());
                intent.putExtra("email", p.getEmail());
                intent.putExtra("number", p.getNumber());
                intent.putExtra("profilePic", p.getProfilePic());
                intent.putExtra("schedulePic", p.getSchedulePic());
                intent.putExtra("profileId", p.getId());
                intent.putExtra("deptname", p.getDeptname());
                intent.putExtra("period", p.getPeriod());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,email;
        ImageView url;
        RelativeLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            url=(ImageView)itemView.findViewById(R.id.profilePic);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            //context = itemView.getContext();
        }
        public void onClick(final int position)
        {
        }
    }
}
