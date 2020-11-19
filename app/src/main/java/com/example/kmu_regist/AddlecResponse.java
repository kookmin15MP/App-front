package com.example.kmu_regist;

public class AddlecResponse {

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public String getLecture_time() {
        return lecture_time;
    }

    public void setLecture_time(String lecture_time) {
        this.lecture_time = lecture_time;
    }

    public String getLimited_people() {
        return limited_people;
    }

    public void setLimited_people(String limited_people) {
        this.limited_people = limited_people;
    }

    private int lecture_id;
    private String lecture_name;
    private String professor_name;
    private String lecture_time;
    private String limited_people;
}
