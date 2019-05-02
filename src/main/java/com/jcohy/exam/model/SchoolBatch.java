package com.jcohy.exam.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "school_batch")
public class SchoolBatch implements Serializable {

    private static final long serialVersionUID = -1843243741214787197L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "batch_id")
    private Integer batchId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }


    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

}
