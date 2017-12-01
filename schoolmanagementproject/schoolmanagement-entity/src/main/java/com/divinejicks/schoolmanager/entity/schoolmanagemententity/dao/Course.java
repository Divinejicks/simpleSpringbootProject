package com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String code;

    @Basic(optional = false)
    private String uuid;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department departments;

    @ManyToMany(mappedBy = "course")
    private List<Teacher> teacher;

    @ManyToMany(mappedBy = "course")
    private List<Student> student;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Mark> mark;

    public Course() {

    }

    public Course(String name, String code, String uuid, Department departments, List<Teacher> teacher, List<Student> student, List<Mark> mark) {
        this.name = name;
        this.code = code;
        this.uuid = uuid;
        this.departments = departments;
        this.teacher = teacher;
        this.student = student;
        this.mark = mark;
    }
    @JsonIgnore
    public int getId() {
        return id;
    }

    @PrePersist
    private void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Mark> getMark() {
        return mark;
    }

    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", uuid='" + uuid + '\'' +
                ", departments=" + departments +
                ", teacher=" + teacher +
                ", student=" + student +
                ", mark=" + mark +
                '}';
    }
}
