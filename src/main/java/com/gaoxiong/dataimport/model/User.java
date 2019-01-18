package com.gaoxiong.dataimport.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_user")
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
@Builder //创建模式
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Long id;

  @Column(name = "uid", nullable = false)
  private Long uid;

  @Column(name = "name")
  private String name;

  @Column(name = "birth_at")
  private Date birthAt;

  
}