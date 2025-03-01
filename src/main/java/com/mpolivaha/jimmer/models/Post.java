package com.mpolivaha.jimmer.models;

import java.time.Instant;
import java.util.List;
import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.OneToMany;

@Entity
public interface Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id();

  @Column(name = "title")
  String title();

  @Column(name = "content")
  String content();

  @Column(name = "created_at")
  Instant createdAt();

  @OneToMany(mappedBy = "post")
  List<PostComment> comments();
}
