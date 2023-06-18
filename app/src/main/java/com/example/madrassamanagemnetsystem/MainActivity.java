package com.example.madrassamanagemnetsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAddStudent, btnAddStudentRecord, btnSearchStudentRecord, btnGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAddStudentRecord = findViewById(R.id.btnAddStudentRecord);
        btnSearchStudentRecord = findViewById(R.id.btnSearchStudentRecord);
        btnGitHub = findViewById(R.id.btnGitHub);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddStudentActivity.class));
            }
        });

        btnAddStudentRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddStudentRecordActivity.class));
            }
        });

        btnSearchStudentRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchStudentRecordActivity.class));
            }
        });

        btnGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/laraib17L/Madrassa-Mangement-System";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
