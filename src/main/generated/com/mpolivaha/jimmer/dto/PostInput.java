package com.mpolivaha.jimmer.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mpolivaha.jimmer.models.CommentReply;
import com.mpolivaha.jimmer.models.CommentReplyDraft;
import com.mpolivaha.jimmer.models.CommentReplyFetcher;
import com.mpolivaha.jimmer.models.Post;
import com.mpolivaha.jimmer.models.PostComment;
import com.mpolivaha.jimmer.models.PostCommentDraft;
import com.mpolivaha.jimmer.models.PostCommentFetcher;
import com.mpolivaha.jimmer.models.PostDraft;
import com.mpolivaha.jimmer.models.PostFetcher;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.Input;
import org.babyfish.jimmer.impl.util.DtoPropAccessor;
import org.babyfish.jimmer.internal.FixedInputField;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.fetcher.DtoMetadata;
import org.jetbrains.annotations.NotNull;

@GeneratedBy(
        file = "<one-orm-to-rule-them-all>/src/main/dto/com/mpolivaha/jimmer/dto/Post.dto"
)
@JsonDeserialize(
        builder = PostInput.Builder.class
)
public class PostInput implements Input<Post> {
    public static final DtoMetadata<Post, PostInput> METADATA = 
        new DtoMetadata<Post, PostInput>(
            PostFetcher.$
                .title()
                .content()
                .createdAt()
                .comments(TargetOf_comments.METADATA.getFetcher()),
            PostInput::new
    );

    private static final DtoPropAccessor COMMENTS_ACCESSOR = new DtoPropAccessor(
        true,
        new int[] { PostDraft.Producer.SLOT_COMMENTS },
        DtoPropAccessor.<PostComment, TargetOf_comments>objectListGetter(TargetOf_comments::new),
        DtoPropAccessor.objectListSetter(TargetOf_comments::toEntity)
    );

    @FixedInputField
    private String title;

    @FixedInputField
    private String content;

    @FixedInputField
    private Instant createdAt;

    @FixedInputField
    private List<TargetOf_comments> comments;

    public PostInput() {
    }

    public PostInput(@NotNull Post base) {
        this.title = base.title();
        this.content = base.content();
        this.createdAt = base.createdAt();
        this.comments = COMMENTS_ACCESSOR.get(base);
    }

    @NotNull
    public String getTitle() {
        if (title == null) {
            throw new IllegalStateException("The property \"title\" is not specified");
        }
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getContent() {
        if (content == null) {
            throw new IllegalStateException("The property \"content\" is not specified");
        }
        return content;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    @NotNull
    public Instant getCreatedAt() {
        if (createdAt == null) {
            throw new IllegalStateException("The property \"createdAt\" is not specified");
        }
        return createdAt;
    }

    public void setCreatedAt(@NotNull Instant createdAt) {
        this.createdAt = createdAt;
    }

    @NotNull
    public List<TargetOf_comments> getComments() {
        if (comments == null) {
            throw new IllegalStateException("The property \"comments\" is not specified");
        }
        return comments;
    }

    public void setComments(@NotNull List<TargetOf_comments> comments) {
        this.comments = comments;
    }

    @Override
    public Post toEntity() {
        return PostDraft.$.produce(__draft -> {
            __draft.setTitle(title);
            __draft.setContent(content);
            __draft.setCreatedAt(createdAt);
            COMMENTS_ACCESSOR.set(__draft, comments != null ? comments : Collections.emptyList());
        });
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(title);
        hash = hash * 31 + Objects.hashCode(content);
        hash = hash * 31 + Objects.hashCode(createdAt);
        hash = hash * 31 + Objects.hashCode(comments);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        PostInput other = (PostInput) o;
        if (!Objects.equals(title, other.title)) {
            return false;
        }
        if (!Objects.equals(content, other.content)) {
            return false;
        }
        if (!Objects.equals(createdAt, other.createdAt)) {
            return false;
        }
        if (!Objects.equals(comments, other.comments)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PostInput").append('(');
        builder.append("title=").append(title);
        builder.append(", content=").append(content);
        builder.append(", createdAt=").append(createdAt);
        builder.append(", comments=").append(comments);
        builder.append(')');
        return builder.toString();
    }

    @GeneratedBy
    @JsonDeserialize(
            builder = TargetOf_comments.Builder.class
    )
    public static class TargetOf_comments implements Input<PostComment> {
        public static final DtoMetadata<PostComment, TargetOf_comments> METADATA = 
            new DtoMetadata<PostComment, TargetOf_comments>(
                PostCommentFetcher.$
                    .comment()
                    .createdAt()
                    .commentReplies(TargetOf_commentReplies.METADATA.getFetcher()),
                TargetOf_comments::new
        );

        private static final DtoPropAccessor COMMENT_REPLIES_ACCESSOR = new DtoPropAccessor(
            true,
            new int[] { PostCommentDraft.Producer.SLOT_COMMENT_REPLIES },
            DtoPropAccessor.<CommentReply, TargetOf_commentReplies>objectListGetter(TargetOf_commentReplies::new),
            DtoPropAccessor.objectListSetter(TargetOf_commentReplies::toEntity)
        );

        @FixedInputField
        private String comment;

        @FixedInputField
        private Instant createdAt;

        @FixedInputField
        private List<TargetOf_commentReplies> commentReplies;

        public TargetOf_comments() {
        }

        public TargetOf_comments(@NotNull PostComment base) {
            this.comment = base.comment();
            this.createdAt = base.createdAt();
            this.commentReplies = COMMENT_REPLIES_ACCESSOR.get(base);
        }

        @NotNull
        public String getComment() {
            if (comment == null) {
                throw new IllegalStateException("The property \"comment\" is not specified");
            }
            return comment;
        }

        public void setComment(@NotNull String comment) {
            this.comment = comment;
        }

        @NotNull
        public Instant getCreatedAt() {
            if (createdAt == null) {
                throw new IllegalStateException("The property \"createdAt\" is not specified");
            }
            return createdAt;
        }

        public void setCreatedAt(@NotNull Instant createdAt) {
            this.createdAt = createdAt;
        }

        @NotNull
        public List<TargetOf_commentReplies> getCommentReplies() {
            if (commentReplies == null) {
                throw new IllegalStateException("The property \"commentReplies\" is not specified");
            }
            return commentReplies;
        }

        public void setCommentReplies(@NotNull List<TargetOf_commentReplies> commentReplies) {
            this.commentReplies = commentReplies;
        }

        @Override
        public PostComment toEntity() {
            return PostCommentDraft.$.produce(__draft -> {
                __draft.setComment(comment);
                __draft.setCreatedAt(createdAt);
                COMMENT_REPLIES_ACCESSOR.set(__draft, commentReplies != null ? commentReplies : Collections.emptyList());
            });
        }

        @Override
        public int hashCode() {
            int hash = Objects.hashCode(comment);
            hash = hash * 31 + Objects.hashCode(createdAt);
            hash = hash * 31 + Objects.hashCode(commentReplies);
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            TargetOf_comments other = (TargetOf_comments) o;
            if (!Objects.equals(comment, other.comment)) {
                return false;
            }
            if (!Objects.equals(createdAt, other.createdAt)) {
                return false;
            }
            if (!Objects.equals(commentReplies, other.commentReplies)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("PostInput.TargetOf_comments").append('(');
            builder.append("comment=").append(comment);
            builder.append(", createdAt=").append(createdAt);
            builder.append(", commentReplies=").append(commentReplies);
            builder.append(')');
            return builder.toString();
        }

        @GeneratedBy
        @JsonDeserialize(
                builder = TargetOf_commentReplies.Builder.class
        )
        public static class TargetOf_commentReplies implements Input<CommentReply> {
            public static final DtoMetadata<CommentReply, TargetOf_commentReplies> METADATA = 
                new DtoMetadata<CommentReply, TargetOf_commentReplies>(
                    CommentReplyFetcher.$
                        .body()
                        .createdAt(),
                    TargetOf_commentReplies::new
            );

            @FixedInputField
            private String body;

            @FixedInputField
            private Instant createdAt;

            public TargetOf_commentReplies() {
            }

            public TargetOf_commentReplies(@NotNull CommentReply base) {
                this.body = base.body();
                this.createdAt = base.createdAt();
            }

            @NotNull
            public String getBody() {
                if (body == null) {
                    throw new IllegalStateException("The property \"body\" is not specified");
                }
                return body;
            }

            public void setBody(@NotNull String body) {
                this.body = body;
            }

            @NotNull
            public Instant getCreatedAt() {
                if (createdAt == null) {
                    throw new IllegalStateException("The property \"createdAt\" is not specified");
                }
                return createdAt;
            }

            public void setCreatedAt(@NotNull Instant createdAt) {
                this.createdAt = createdAt;
            }

            @Override
            public CommentReply toEntity() {
                return CommentReplyDraft.$.produce(__draft -> {
                    __draft.setBody(body);
                    __draft.setCreatedAt(createdAt);
                });
            }

            @Override
            public int hashCode() {
                int hash = Objects.hashCode(body);
                hash = hash * 31 + Objects.hashCode(createdAt);
                return hash;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || this.getClass() != o.getClass()) {
                    return false;
                }
                TargetOf_commentReplies other = (TargetOf_commentReplies) o;
                if (!Objects.equals(body, other.body)) {
                    return false;
                }
                if (!Objects.equals(createdAt, other.createdAt)) {
                    return false;
                }
                return true;
            }

            @Override
            public String toString() {
                StringBuilder builder = new StringBuilder();
                builder.append("PostInput.TargetOf_comments.TargetOf_commentReplies").append('(');
                builder.append("body=").append(body);
                builder.append(", createdAt=").append(createdAt);
                builder.append(')');
                return builder.toString();
            }

            @JsonPOJOBuilder(
                    withPrefix = ""
            )
            public static class Builder {
                private String body;

                private Instant createdAt;

                public Builder body(String body) {
                    this.body = Objects.requireNonNull(body, "The property \"body\" cannot be null");
                    return this;
                }

                public Builder createdAt(Instant createdAt) {
                    this.createdAt = Objects.requireNonNull(createdAt, "The property \"createdAt\" cannot be null");
                    return this;
                }

                public TargetOf_commentReplies build() {
                    TargetOf_commentReplies _input = new TargetOf_commentReplies();
                    if (body == null) {
                        throw Input.unknownNonNullProperty(TargetOf_commentReplies.class, "body");
                    }
                    _input.setBody(body);
                    if (createdAt == null) {
                        throw Input.unknownNonNullProperty(TargetOf_commentReplies.class, "createdAt");
                    }
                    _input.setCreatedAt(createdAt);
                    return _input;
                }
            }
        }

        @JsonPOJOBuilder(
                withPrefix = ""
        )
        public static class Builder {
            private String comment;

            private Instant createdAt;

            private List<TargetOf_commentReplies> commentReplies;

            public Builder comment(String comment) {
                this.comment = Objects.requireNonNull(comment, "The property \"comment\" cannot be null");
                return this;
            }

            public Builder createdAt(Instant createdAt) {
                this.createdAt = Objects.requireNonNull(createdAt, "The property \"createdAt\" cannot be null");
                return this;
            }

            public Builder commentReplies(List<TargetOf_commentReplies> commentReplies) {
                this.commentReplies = Objects.requireNonNull(commentReplies, "The property \"commentReplies\" cannot be null");
                return this;
            }

            public TargetOf_comments build() {
                TargetOf_comments _input = new TargetOf_comments();
                if (comment == null) {
                    throw Input.unknownNonNullProperty(TargetOf_comments.class, "comment");
                }
                _input.setComment(comment);
                if (createdAt == null) {
                    throw Input.unknownNonNullProperty(TargetOf_comments.class, "createdAt");
                }
                _input.setCreatedAt(createdAt);
                if (commentReplies == null) {
                    throw Input.unknownNonNullProperty(TargetOf_comments.class, "commentReplies");
                }
                _input.setCommentReplies(commentReplies);
                return _input;
            }
        }
    }

    @JsonPOJOBuilder(
            withPrefix = ""
    )
    public static class Builder {
        private String title;

        private String content;

        private Instant createdAt;

        private List<TargetOf_comments> comments;

        public Builder title(String title) {
            this.title = Objects.requireNonNull(title, "The property \"title\" cannot be null");
            return this;
        }

        public Builder content(String content) {
            this.content = Objects.requireNonNull(content, "The property \"content\" cannot be null");
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = Objects.requireNonNull(createdAt, "The property \"createdAt\" cannot be null");
            return this;
        }

        public Builder comments(List<TargetOf_comments> comments) {
            this.comments = Objects.requireNonNull(comments, "The property \"comments\" cannot be null");
            return this;
        }

        public PostInput build() {
            PostInput _input = new PostInput();
            if (title == null) {
                throw Input.unknownNonNullProperty(PostInput.class, "title");
            }
            _input.setTitle(title);
            if (content == null) {
                throw Input.unknownNonNullProperty(PostInput.class, "content");
            }
            _input.setContent(content);
            if (createdAt == null) {
                throw Input.unknownNonNullProperty(PostInput.class, "createdAt");
            }
            _input.setCreatedAt(createdAt);
            if (comments == null) {
                throw Input.unknownNonNullProperty(PostInput.class, "comments");
            }
            _input.setComments(comments);
            return _input;
        }
    }
}
