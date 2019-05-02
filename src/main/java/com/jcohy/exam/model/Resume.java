package com.jcohy.exam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "resume")
public class Resume implements Serializable {
    private static final long serialVersionUID = 4L;

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //简历编号传对应的用户id
    @Column(name = "resume_num")
    private Integer num;

    //简历状态
    @Column(name = "resume_status")
    private Integer status;

    //姓名
    @Column(name = "name")
    private String name;

    //电话
    @Column(name = "phone")
    private String phone;

    //身份证号
    @Column(name = "id_no")
    private String idNo;

    //性别
    @Column(name = "sex")
    private String sex;

    //年龄
    @Column(name = "age")
    private Integer age;

    //出生日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "birth")
    private Date birth;

    //邮箱
    @Column(name = "email")
    private String email;


    //教育经历
    @Column(name = "education_experience")
    private String education;


    //工作经历
    @Column(name = "work_experience")
    private String work;

    //个人评价
    @Column(name = "personal_evaluation")
    private String personal;

    //附件地址
    @Column(name = "annex_url")
    private String annexUrl;


    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatetime")
    private Date updateTime;


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getAnnexUrl() {
        return annexUrl;
    }

    public void setAnnexUrl(String annexUrl) {
        this.annexUrl = annexUrl;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
