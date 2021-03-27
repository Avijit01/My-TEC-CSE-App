package com.example.myteccseapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView circleImageViewStudent;
    public static final int IMAGE_CODE = 1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageViewStudent = findViewById(R.id.circularImageStudentId);

        circleImageViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageStorage();
            }
        });
    }

    private void openImageStorage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_CODE && resultCode == RESULT_OK && data != null && data.getData() != null)
        {
            imageUri = data.getData();
            circleImageViewStudent.setImageURI(imageUri);
        }
    }
}