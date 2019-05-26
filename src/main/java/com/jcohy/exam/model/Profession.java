package com.jcohy.exam.model;

import javax.persistence.*;

/**
 * 专业信息
 */
@Entity
@Table(name = "profession")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "future")
    private String future;

    @Column(name = "compensation")
    private Integer compensation;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }


    public Integer getCompensation() {
        return compensation;
    }

    public void setCompensation(Integer compensation) {
        this.compensation = compensation;
    }

}
