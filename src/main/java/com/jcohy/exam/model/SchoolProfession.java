package com.jcohy.exam.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "school_profession")
public class SchoolProfession implements Serializable {

    private static final long serialVersionUID = 5044856367285730867L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "profession_id")
    private Integer professionId;


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


    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

}
