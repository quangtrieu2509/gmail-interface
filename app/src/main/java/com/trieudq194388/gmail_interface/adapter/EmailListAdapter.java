package com.trieudq194388.gmail_interface.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trieudq194388.gmail_interface.R;
import com.trieudq194388.gmail_interface.model.Email;

import java.util.List;

public class EmailListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Email> eList;

    public EmailListAdapter() {
    }

    public EmailListAdapter(List<Email> eList) {
        this.eList = eList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Email email = eList.get(position);
        char avatarChar = email.getAccountName().charAt(0);
        myViewHolder.avatar.setText(String.valueOf(avatarChar).toUpperCase());
        myViewHolder.avatar.setBackgroundColor(Color.parseColor(email.getAvatarColor()));
        myViewHolder.accName.setText(email.getAccountName());
        myViewHolder.title.setText(email.getEmailTitle());
        myViewHolder.content.setText(email.getEmailContent());
        myViewHolder.time.setText(email.getTime());
        if(email.isFavEmail()) myViewHolder.favEmail.setBackgroundResource(R.drawable.ic_star_filled);
        else myViewHolder.favEmail.setBackgroundResource(R.drawable.ic_star_outline);

        myViewHolder.favEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.isFavEmail()){
                    email.setFavEmail(true);
                    myViewHolder.favEmail.setBackgroundResource(R.drawable.ic_star_filled);
                }
                else{
                    email.setFavEmail(false);
                    myViewHolder.favEmail.setBackgroundResource(R.drawable.ic_star_outline);
                }
            }
        });

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "From: " + email.getAccountName() + "\nTitle: "
                        + email.getEmailTitle() + "\nContent: " + email.getEmailContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(eList != null) return eList.size();
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView avatar, accName, title, content, time, favEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            accName = itemView.findViewById(R.id.emailName);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            time = itemView.findViewById(R.id.time);
            favEmail = itemView.findViewById(R.id.favoriteIcon);
        }
    }
}
