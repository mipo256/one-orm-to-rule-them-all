package com.mpolivaha.sdj.models;

import java.time.Instant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "sdj")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CommentReply {

  @Id
  @EqualsAndHashCode.Include
  private Long id;

  private String body;

  private Instant createdAt;

}
