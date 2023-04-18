package com.example.helloworld;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.helloworld.model.Note;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseService {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notesRef = db.collection("notes");
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference reference = storage.getReference();
    private StorageReference imageRef = reference.child("G3ps1uf5KeGxfmcaIiDe");;
    private String notes = "notes";
    private ArrayAdapter adapter;
    private ImageView imageView;

    public FirebaseService(ArrayAdapter<Note> adapter) {
        this.adapter = adapter;
    }
    public FirebaseService (ImageView imageView){
        this.imageView = imageView;
    }

    public void addNote(String text){
        DocumentReference ref = db.collection("notes").document();
        Map<String, String> map = new HashMap<>();
        map.put("text", text);
        ref.set(map);
    }
    public void add2Note(String text){
        DocumentReference ref = db.collection("notes").document();
        Map<String, String> map = new HashMap<>();
        map.put("text", text);
        ref.set(map).addOnCompleteListener(unused ->
                System.out.println("document saved " + text))
        .addOnFailureListener(e -> System.out.println("document NOT Saved" + text));
    }
    public void getImageFromStorage(){
        imageRef.getBytes(Long.MAX_VALUE).addOnSuccessListener(bytes -> {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imageView.setImageBitmap(bitmap);
        }).addOnFailureListener(e -> System.out.println(e));
    }
    public void uploadImage(){

    }




    public void startListener(){
        db.collection(notes).addSnapshotListener((snap, error) ->{
           if(error == null){
               adapter.clear();
               for(DocumentSnapshot s : snap.getDocuments()){
                   System.out.println(s.getData().get("text"));
                   Note note = new Note(s.getId(), s.getData().get("text").toString());
                   adapter.add(note);
               }
               //adapter.clear();
               //adapter.addAll(notesList);
               adapter.notifyDataSetChanged();
           }
        });
    }
    /*public void fetchNotes(){
        notesRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<String> notesList = new ArrayList<>();
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    String note = documentSnapshot.getString("text");
                    notesList.add(note);
                }
                System.out.println(notesList);
            }
        });
    }*/
}
