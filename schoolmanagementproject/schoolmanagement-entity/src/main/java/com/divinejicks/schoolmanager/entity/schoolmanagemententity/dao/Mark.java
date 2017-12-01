package com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Mark implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private int ca_mark;

    @Basic(optional = false)
    private int exam_mark;

    @Basic(optional = false)
    private int total_mark;

    @Basic(optional = false)
    private String uuid;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private List<Course> course;

    public Mark() {

    }

    public Mark(int ca_mark, int exam_mark, int total_mark, String uuid, List<Course> course) {
        this.ca_mark = ca_mark;
        this.exam_mark = exam_mark;
        this.total_mark = total_mark;
        this.uuid = uuid;
        this.course = course;
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    @PrePersist
    private void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }

    public int getCa_mark() {
        return ca_mark;
    }

    public void setCa_mark(int ca_mark) {
        this.ca_mark = ca_mark;
    }

    public int getExam_mark() {
        return exam_mark;
    }

    public void setExam_mark(int exam_mark) {
        this.exam_mark = exam_mark;
    }

    public int getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(int total_mark) {
        this.total_mark = total_mark;
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

    @Override
    public String toString() {
        return "Mark{" +
                "ca_mark=" + ca_mark +
                ", exam_mark=" + exam_mark +
                ", total_mark=" + total_mark +
                ", uuid='" + uuid + '\'' +
                ", course=" + course +
                '}';
    }
}
