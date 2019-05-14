package com.jcohy.exam.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "school_line")
public class SchoolLine implements Serializable {

    private static final long serialVersionUID = 2159856976060541457L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "school_id")
//    private Integer schoolId;

    @Column(name = "school_line")
    private Integer schoolLine;

    @Column(name = "arts_science")
    private String artsScience;

    @Column(name = "school_name")
    private String schoolName;

//    @Column(name = "profession_id")
//    private Integer professionId;

    @Column(name = "profession_name")
    private String professionName;

    @OneToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    /*public Integer getSchoolId() {
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
*/
    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Integer getSchoolLine() {
        return schoolLine;
    }

    public void setSchoolLine(Integer schoolLine) {
        this.schoolLine = schoolLine;
    }


    public String getArtsScience() {
        return artsScience;
    }

    public void setArtsScience(String artsScience) {
        this.artsScience = artsScience;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
