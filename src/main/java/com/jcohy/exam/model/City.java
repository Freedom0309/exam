package com.jcohy.exam.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String name;

  @JoinColumn(name = "province_id")
  @ManyToOne
  private Province province;


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


  public Province getProvince() {
    return province;
  }

  public void setProvince(Province province) {
    this.province = province;
  }
}
