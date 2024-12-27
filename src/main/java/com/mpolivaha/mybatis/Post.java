package com.mpolivaha.mybatis;

import java.time.Instant;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {

  @EqualsAndHashCode.Include
  private Long id;

  private String title;

  private String content;

  private Instant createdAt;

  private List<PostComment> comments;
}
