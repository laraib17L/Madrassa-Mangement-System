package com.example.madrassamanagemnetsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText etId, etName, etAge, etClass;
    private Button btnAddStudent;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etClass = findViewById(R.id.etClass);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        databaseHelper = new DatabaseHelper(this);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString());
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                String className = etClass.getText().toString();

                Student student = new Student(id, name, age, className);
                long result = databaseHelper.addStudent(student);

                if (result != -1) {
                    Toast.makeText(AddStudentActivity.this, "Student added successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(AddStudentActivity.this, "Failed to add student", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearFields() {
        etId.setText("");
        etName.setText("");
        etAge.setText("");
        etClass.setText("");
    }
}
