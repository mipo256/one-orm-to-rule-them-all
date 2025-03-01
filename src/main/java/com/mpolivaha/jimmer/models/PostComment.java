package com.mpolivaha.jimmer.models;

import java.time.Instant;
import java.util.List;
import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.JoinColumn;
import org.babyfish.jimmer.sql.ManyToOne;
import org.babyfish.jimmer.sql.OneToMany;

@Entity
public interface PostComment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id();

  @Column(name = "comment")
  String comment();

  @JoinColumn(name = "post_id")
  @ManyToOne
  Post post();

  @Column(name = "created_at")
  Instant createdAt();

  @OneToMany(mappedBy = "postComment")
  List<CommentReply> commentReplies();
}
