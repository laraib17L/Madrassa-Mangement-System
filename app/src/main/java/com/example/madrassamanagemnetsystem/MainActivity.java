package com.example.madrassamanagemnetsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addStudentButton = findViewById(R.id.addStudentButton);
        Button addStudentRecordButton = findViewById(R.id.addStudentRecordButton);
        Button searchStudentButton = findViewById(R.id.searchStudentButton);
        Button gitHubButton = findViewById(R.id.gitHubButton);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddStudentActivity.class));
            }
        });

        addStudentRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddStudentRecordActivity.class));
            }
        });

        searchStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchStudent.class));
            }
        });

        gitHubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/laraib17L/Madrassa-Mangement-System";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
