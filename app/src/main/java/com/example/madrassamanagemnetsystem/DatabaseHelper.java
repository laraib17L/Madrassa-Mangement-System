package com.example.madrassamanagemnetsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "madrasa.db";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_STUDENT = "students";
    private static final String TABLE_STUDENT_RECORD = "student_records";

    // Common column names
    private static final String COLUMN_ID = "id";

    // STUDENT Table - column names
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class";

    // STUDENT_RECORD Table - column names
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_SABAQ = "sabaq";
    private static final String COLUMN_SABAQI = "sabaqi";
    private static final String COLUMN_MANZIL = "manzil";

    // Create table statements
    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_STUDENT +
            "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT," +
            COLUMN_AGE + " INTEGER," +
            COLUMN_CLASS + " TEXT" +
            ")";

    private static final String CREATE_TABLE_STUDENT_RECORD = "CREATE TABLE " + TABLE_STUDENT_RECORD +
            "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_STUDENT_ID + " INTEGER," +
            COLUMN_SABAQ + " TEXT," +
            COLUMN_SABAQI + " TEXT," +
            COLUMN_MANZIL + " INTEGER," +
            "FOREIGN KEY(" + COLUMN_STUDENT_ID + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_ID + ")" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);
        db.execSQL(CREATE_TABLE_STUDENT_RECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_RECORD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);

        // Create tables again
        onCreate(db);
    }

    // Adding a student
    public long addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, student.getId());
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.getClassName());

        // Inserting the row
        long result = db.insert(TABLE_STUDENT, null, values);
        db.close();
        return result;
    }

    // Adding a student record
    public long addStudentRecord(StudentRecord studentRecord) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENT_ID, studentRecord.getStudentId());
        values.put(COLUMN_SABAQ, studentRecord.getSabaq());
        values.put(COLUMN_SABAQI, studentRecord.getSabaqi());
        values.put(COLUMN_MANZIL, studentRecord.getManzil());

        // Inserting the row
        long result = db.insert(TABLE_STUDENT_RECORD, null, values);
        db.close();
        return result;
    }

    // Retrieving all students
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                student.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                student.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)));
                student.setClassName(cursor.getString(cursor.getColumnIndex(COLUMN_CLASS)));

                studentList.add(student);
            } while (cursor.moveToNext());
        }

        // Close the cursor and database
        cursor.close();
        db.close();

        return studentList;
    }

    // Searching for students based on criteria
    public List<Student> searchStudents(String searchCriteria) {
        List<Student> studentList = new ArrayList<>();

        // Select Query with WHERE clause
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT +
                " WHERE " + COLUMN_NAME + " LIKE '%" + searchCriteria + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop through all rows and add to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                student.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                student.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_AGE)));
                student.setClassName(cursor.getString(cursor.getColumnIndex(COLUMN_CLASS)));

                studentList.add(student);
            } while (cursor.moveToNext());
        }

        // Close the cursor and database
        cursor.close();
        db.close();

        return studentList;
    }
}
