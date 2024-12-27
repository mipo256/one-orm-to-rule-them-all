package com.mpolivaha.mybatis.dynamic;

import lombok.Data;

@Data
public class Post {

  private Long id;
  private String topic;
  private Double score;
  private Integer rank;
}
