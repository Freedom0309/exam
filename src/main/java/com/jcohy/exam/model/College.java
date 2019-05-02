package com.jcohy.exam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Description  :学院表
 */
@Entity
@Table(name = "college")
public class College implements Serializable {


    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //编号，用于登录
    @Column(name = "college_num")
    private Integer num;

    @Column(name = "college_name")
    private String name;

    @Column(name = "college_chairman")
    private String collegeChairman;

    @Column(name = "college_tel")
    private String collegeTel;

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

    public String getCollegeChairman() {
        return collegeChairman;
    }

    public void setCollegeChairman(String collegeChairman) {
        this.collegeChairman = collegeChairman;
    }

    public String getCollegeTel() {
        return collegeTel;
    }

    public void setCollegeTel(String collegeTel) {
        this.collegeTel = collegeTel;
    }

    public String getCollegeDesc() {
        return collegeDesc;
    }

    public void setCollegeDesc(String collegeDesc) {
        this.collegeDesc = collegeDesc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "college_desc")
    private String collegeDesc;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatetime")
    private Date updateTime;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "status")
    private Integer status;
}
