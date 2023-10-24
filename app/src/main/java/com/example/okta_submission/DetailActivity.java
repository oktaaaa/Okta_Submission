package com.example.okta_submission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvName, tvDescription;
    private ImageView imgPhoto;
    private String name, description, photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getView();

        Intent showView = getIntent();
        name = showView.getStringExtra("Nama");
        description = showView.getStringExtra("Description");
        photo = showView.getStringExtra("Foto");

        getSupportActionBar().setTitle(name);

        tvName.setText(name);
        tvDescription.setText(description);

        Glide.with(DetailActivity.this)
                .load(photo)
                .into(imgPhoto);
    }

    private void getView(){
        tvName = findViewById(R.id.tv_item_name);
        tvDescription = findViewById(R.id.tv_item_description);
        imgPhoto = findViewById(R.id.img_item_photo);
    }
}