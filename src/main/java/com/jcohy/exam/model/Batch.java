package com.jcohy.exam.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "batch")
public class Batch implements Serializable {

    private static final long serialVersionUID = 2634367443722120965L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "arts_science")
    private String artsScience;

    @Column(name = "year")
    private Integer year;

    @Column(name = "batch_number")
    private Integer batchNumber;

    @Column(name = "low_batch")
    private Integer lowBatch;

    @Column(name = "avg_batch")
    private Integer avgBatch;

    @Column(name = "low_score")
    private Integer lowScore;

    @Column(name = "avg_score")
    private Integer avgScore;

    @JoinColumn(name = "school_id")
    @ManyToOne
    private School school;

    @Transient
    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getArtsScience() {
        return artsScience;
    }

    public void setArtsScience(String artsScience) {
        this.artsScience = artsScience;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }


    public Integer getLowBatch() {
        return lowBatch;
    }

    public void setLowBatch(Integer lowBatch) {
        this.lowBatch = lowBatch;
    }


    public Integer getAvgBatch() {
        return avgBatch;
    }

    public void setAvgBatch(Integer avgBatch) {
        this.avgBatch = avgBatch;
    }


    public Integer getLowScore() {
        return lowScore;
    }

    public void setLowScore(Integer lowScore) {
        this.lowScore = lowScore;
    }


    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
