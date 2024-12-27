package com.mpolivaha.mybatis;

import java.time.Instant;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostComment {

  @EqualsAndHashCode.Include
  private Long id;

  private String comment;

  private Post post;

  private Instant createdAt;

  private List<CommentReply> commentReplies;
}
