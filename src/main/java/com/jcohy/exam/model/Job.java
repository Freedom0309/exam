package com.jcohy.exam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 5L;

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "job_num")
    private Integer num;


    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @OneToOne
    @JoinColumn(name = "college_id")
    private College college;

    @OneToOne
    @JoinColumn(name = "reqiured_id")
    private Requirement requirement;

    @Column(name = "name")
    private String name;

    @Column(name = "job_title")
    private String title;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Column(name = "loction")
    private String location;

    @Column(name = "numbers")
    private String numbers;

    @Column(name = "work_experience")
    private String experience;

    @Column(name = "description")
    private String desc;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "job_status")
    private Integer status;

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.DATE)
    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
