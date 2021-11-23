package com.example.android.employeesmanagementsoftware.Models;

public class Employe {
    private int id;
    private String name;
    private String birthdate;
    private String email;
    private String phone;
    private String department_id;
    private String job;
    private String photo;
    private String notes;

    public Employe() {
    }

    public Employe(int id, String name, String birthdate, String email, String phone, String department_id, String job, String photo, String notes) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.department_id = department_id;
        this.job = job;
        this.photo = photo;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
