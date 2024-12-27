package com.mpolivaha.sdj.models;

import java.time.Instant;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "sdj")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostComment {

  @Id
  @EqualsAndHashCode.Include
  private Long id;

  private String comment;

  private Instant createdAt;

  @MappedCollection(idColumn = "post_comment_id", keyColumn = "post_comment_id")
  private List<CommentReply> commentReplies;
}
