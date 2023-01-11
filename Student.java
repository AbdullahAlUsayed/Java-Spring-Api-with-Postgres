package com.example.srudent_info.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity
@Table(name= "usayed_student_info")
@JsonRootName(value = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private  int age;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "gender")
    private String gender;

    public Student(int id, String name, int age, String mobile, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.gender = gender;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
