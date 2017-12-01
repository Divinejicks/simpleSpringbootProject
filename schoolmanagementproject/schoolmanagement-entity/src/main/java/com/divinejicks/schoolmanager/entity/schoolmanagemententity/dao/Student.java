package com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String matricule;

    @Basic(optional = false)
    private int level;

    @Basic(optional = false)
    private String grade;

    @Basic(optional = false)
    private String uuid;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> course;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private List<Department> department;

    public Student() {

    }

    public Student(String name, String matricule, int level, String grade, String uuid, List<Course> course, List<Department> department) {
        this.name = name;
        this.matricule = matricule;
        this.level = level;
        this.grade = grade;
        this.uuid = uuid;
        this.course = course;
        this.department = department;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", matricule='" + matricule + '\'' +
                ", level=" + level +
                ", grade='" + grade + '\'' +
                ", uuid='" + uuid + '\'' +
                ", course=" + course +
                ", department=" + department +
                '}';
    }
}
