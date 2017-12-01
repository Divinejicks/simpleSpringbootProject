package com.divinejicks.schoolmanager.entity.schoolmanagemententity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Faculty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String uuid;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Department> department;

    public Faculty() {

    }

    public Faculty(String name, String uuid, List<Department> department) {
        this.name = name;
        this.uuid = uuid;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", department=" + department +
                '}';
    }
}
