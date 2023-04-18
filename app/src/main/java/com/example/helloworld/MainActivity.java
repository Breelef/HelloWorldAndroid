package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText inputText;
    private EditText editNumber;
    private EditText editNumber2;
    private EditText operator;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editNumber = findViewById(R.id.editNumber);
        editNumber2 = findViewById(R.id.editNumber2);
        operator = findViewById(R.id.operatorIdentifier);
        button = findViewById(R.id.button);
    }
    public void moveToPage(View view){
        Intent intent = new Intent(MainActivity.this, FirebaseLesson.class);
        startActivity(intent);
    }
   /* public void helloWorldButtonPressed (View view){
        int newNumber;
        switch(operator.getText().toString()){
            case "+":
                newNumber = Integer.parseInt(editNumber.getText().toString()) + Integer.parseInt(editNumber2.getText().toString());
                textView.setText("The result of the two numbers: " + newNumber);
                break;
            case "-":
                newNumber = Integer.parseInt(editNumber.getText().toString()) - Integer.parseInt(editNumber2.getText().toString());
                textView.setText("The result of the two numbers: " + newNumber);
                break;
            case "/":
                newNumber = Integer.parseInt(editNumber.getText().toString()) / Integer.parseInt(editNumber2.getText().toString());
                textView.setText("The result of the two numbers: " + newNumber);
                break;
            case "*":
                newNumber = Integer.parseInt(editNumber.getText().toString()) * Integer.parseInt(editNumber2.getText().toString());
                textView.setText("The result of the two numbers: " + newNumber);
                break;
            default:
                textView.setText("No valid operators");
        }
    }*/
}