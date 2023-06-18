package com.example.madrassamanagemnetsystem;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText idEditText, nameEditText, ageEditText, classEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        classEditText = findViewById(R.id.classEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String className = classEditText.getText().toString();

                // Create a Student object
                Student student = new Student(id, name, age, className);

                // Insert the student details into the database using DatabaseHelper
                DatabaseHelper databaseHelper = new DatabaseHelper(AddStudentActivity.this);
                boolean success = databaseHelper.insertStudent(student);

                if (success) {
                    Toast.makeText(AddStudentActivity.this, "Student added successfully", Toast.LENGTH_SHORT).show();
                    finish(); // Close the activity after successful insertion
                } else {
                    Toast.makeText(AddStudentActivity.this, "Failed to add student", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
