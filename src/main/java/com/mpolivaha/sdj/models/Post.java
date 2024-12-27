package com.mpolivaha.sdj.models;

import java.time.Instant;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.lang.NonNull;

@Data
@Table(schema = "sdj")
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post implements BeforeSaveCallback<Post> {

  @Id
  @EqualsAndHashCode.Include
  private Long id;

  private String title;

  private String content;

  private Instant createdAt;

  @MappedCollection(idColumn = "post_id", keyColumn = "post_id")
  private List<PostComment> comments;

  @Override
  public @NonNull Post onBeforeSave(
      @NonNull Post aggregate,
      @NonNull MutableAggregateChange<Post> aggregateChange) {

    aggregate.setCreatedAt(Instant.now());

    aggregate.getComments().forEach(postComment -> {

      postComment.setCreatedAt(Instant.now());

      postComment.getCommentReplies().forEach(commentReply -> {
        commentReply.setCreatedAt(Instant.now());
      });
    });

    return aggregate;
  }
}
