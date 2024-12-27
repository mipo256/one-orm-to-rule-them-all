package com.mpolivaha.hibernate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@Setter
@ToString
@Entity
@Table(schema = "jpa")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {

  @Id
  @EqualsAndHashCode.Include
  private Long id;

  private String title;

  private String content;

  private Instant createdAt;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  private List<PostComment> comments;
}
