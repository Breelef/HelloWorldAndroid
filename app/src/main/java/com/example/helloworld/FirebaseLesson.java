package com.example.helloworld;
import com.example.helloworld.FirebaseService;
import com.example.helloworld.model.Note;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirebaseLesson extends AppCompatActivity {
    private FirebaseService fs;
    private List<Note> notesList = new ArrayList<>();
    ArrayAdapter adapter;
    private static final int REQUEST_CODE_PICK_IMAGE = 1;
    ImageView imageView;
    private ImageView imageView2;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageexcersise);
        //listView = findViewById(R.id.listViewRow);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        fs = new FirebaseService(imageView);
        //adapter = new ArrayAdapter(this, R.layout.myrow, R.id.rowTextView);
        //fs = new FirebaseService(adapter);
        //adapter.add(fs.notesList);
        //listView.setAdapter(adapter);
        //firebaseService.add2Note("Hello from Android with feedback");
        //fs.startListener();
        fs.getImageFromStorage();

    }

    public void pickImageFromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            imageView2.setImageURI(imageUri);

            // Do something with the image URI
        }
    }

}