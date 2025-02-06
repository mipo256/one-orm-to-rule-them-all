package com.mpolivaha.jimmer.models;

import java.lang.Long;
import java.lang.String;
import java.time.Instant;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = CommentReply.class
)
@PropsFor(CommentReply.class)
public interface CommentReplyProps extends Props {
    TypedProp.Scalar<CommentReply, Long> ID = 
        TypedProp.scalar(ImmutableType.get(CommentReply.class).getProp("id"));

    TypedProp.Scalar<CommentReply, String> BODY = 
        TypedProp.scalar(ImmutableType.get(CommentReply.class).getProp("body"));

    TypedProp.Reference<CommentReply, PostComment> POST_COMMENT = 
        TypedProp.reference(ImmutableType.get(CommentReply.class).getProp("postComment"));

    TypedProp.Scalar<CommentReply, Instant> CREATED_AT = 
        TypedProp.scalar(ImmutableType.get(CommentReply.class).getProp("createdAt"));

    PropExpression.Num<Long> id();

    PropExpression.Str body();

    PostCommentTable postComment();

    PostCommentTable postComment(JoinType joinType);

    PropExpression.Num<Long> postCommentId();

    PropExpression.Cmp<Instant> createdAt();
}
