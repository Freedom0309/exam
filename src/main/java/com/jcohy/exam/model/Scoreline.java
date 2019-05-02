package com.jcohy.exam.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scoreline")
public class Scoreline implements Serializable {

  private static final long serialVersionUID = -8045166288505837156L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "year")
  private Integer year;


  @Column(name = "batch_number")
  private Integer batchNumber;

  @Column(name = "score")
  private Long score;

  @Column(name = "arts_science")
  private String artsScience;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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


  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }


  public String getArtsScience() {
    return artsScience;
  }

  public void setArtsScience(String artsScience) {
    this.artsScience = artsScience;
  }

}
