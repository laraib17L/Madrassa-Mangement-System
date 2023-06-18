package com.example.madrassamanagemnetsystem;

public class StudentRecord {
    private int id;
    private int studentId;
    private String sabaq;
    private String sabaqi;
    private int manzil;

    public StudentRecord() {
    }

    public StudentRecord(int id, int studentId, String sabaq, String sabaqi, int manzil) {
        this.id = id;
        this.studentId = studentId;
        this.sabaq = sabaq;
        this.sabaqi = sabaqi;
        this.manzil = manzil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSabaq() {
        return sabaq;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public String getSabaqi() {
        return sabaqi;
    }

    public void setSabaqi(String sabaqi) {
        this.sabaqi = sabaqi;
    }

    public int getManzil() {
        return manzil;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }
}

