package com.example.myapplication.Objects;

public class Object {
    private String name;
    private String teacher;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object(String name, String teacher, String info){
        this.name = name;
        this.teacher = teacher;
        this.info = info;
    }
}
