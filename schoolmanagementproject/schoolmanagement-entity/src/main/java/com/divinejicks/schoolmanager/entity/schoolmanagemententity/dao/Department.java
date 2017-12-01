package com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String uuid;

    @ManyToOne(targetEntity = Faculty.class)
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Course> course;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Student> student;

    public Department() {

    }

    public Department(String name, String uuid, Faculty faculty, List<Course> course, List<Student> student) {
        this.name = name;
        this.uuid = uuid;
        this.faculty = faculty;
        this.course = course;
        this.student = student;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", faculty=" + faculty +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
