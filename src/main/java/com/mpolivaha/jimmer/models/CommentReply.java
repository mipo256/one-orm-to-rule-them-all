package com.mpolivaha.jimmer.models;

import java.time.Instant;
import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.JoinColumn;
import org.babyfish.jimmer.sql.ManyToOne;

@Entity
public interface CommentReply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id();

  @Column(name = "body")
  String body();

  @JoinColumn(name = "post_comment_id")
  @ManyToOne
  PostComment postComment();

  @Column(name = "created_at")
  Instant createdAt();
}
