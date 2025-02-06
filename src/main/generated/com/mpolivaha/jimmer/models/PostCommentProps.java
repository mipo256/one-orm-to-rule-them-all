package com.mpolivaha.jimmer.models;

import java.lang.Long;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = PostComment.class
)
@PropsFor(PostComment.class)
public interface PostCommentProps extends Props {
    TypedProp.Scalar<PostComment, Long> ID = 
        TypedProp.scalar(ImmutableType.get(PostComment.class).getProp("id"));

    TypedProp.Scalar<PostComment, String> COMMENT = 
        TypedProp.scalar(ImmutableType.get(PostComment.class).getProp("comment"));

    TypedProp.Reference<PostComment, Post> POST = 
        TypedProp.reference(ImmutableType.get(PostComment.class).getProp("post"));

    TypedProp.Scalar<PostComment, Instant> CREATED_AT = 
        TypedProp.scalar(ImmutableType.get(PostComment.class).getProp("createdAt"));

    TypedProp.ReferenceList<PostComment, CommentReply> COMMENT_REPLIES = 
        TypedProp.referenceList(ImmutableType.get(PostComment.class).getProp("commentReplies"));

    PropExpression.Num<Long> id();

    PropExpression.Str comment();

    PostTable post();

    PostTable post(JoinType joinType);

    PropExpression.Num<Long> postId();

    PropExpression.Cmp<Instant> createdAt();

    Predicate commentReplies(Function<CommentReplyTableEx, Predicate> block);
}
