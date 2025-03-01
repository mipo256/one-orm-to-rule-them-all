package com.mpolivaha.hibernate.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(schema = "one_to_one", name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @ToString.Exclude
  @OneToOne(mappedBy = "owner", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
  private AddressInfo addressInfo;

  public AddressInfo getAddressInfo() {
    return addressInfo;
  }
}
