package com.example.madrassamanagemnetsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchStudentActivity extends AppCompatActivity {

    private EditText searchEditText;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student_record);

        searchEditText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchCriteria = searchEditText.getText().toString();

                // Retrieve student records based on search criteria using DatabaseHelper
                databaseHelper = new DatabaseHelper(SearchStudentActivity.this);
                List<Student> studentList = databaseHelper.searchStudents(searchCriteria);

                // Set up RecyclerViewAdapter and display the search results
                studentAdapter = new StudentAdapter(studentList);
                recyclerView.setAdapter(studentAdapter);
            }
        });
    }
}
