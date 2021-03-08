package com.android.learningapp.models;

public class Course_Model {
    public int course_img;
    public String course_title;

    public Course_Model(int course_img, String course_title) {
        this.course_img = course_img;
        this.course_title = course_title;
    }

    public int getCourse_img() {
        return course_img;
    }

    public String getCourse_title() {
        return course_title;
    }
}
