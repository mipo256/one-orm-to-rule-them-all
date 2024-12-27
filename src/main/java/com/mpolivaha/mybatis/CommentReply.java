package com.mpolivaha.mybatis;

import java.time.Instant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CommentReply {

  @EqualsAndHashCode.Include
  private Long id;

  private String body;

  private PostComment postComment;

  private Instant createdAt;

}
