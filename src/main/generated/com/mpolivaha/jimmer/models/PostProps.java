package com.mpolivaha.jimmer.models;

import java.lang.Long;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = Post.class
)
@PropsFor(Post.class)
public interface PostProps extends Props {
    TypedProp.Scalar<Post, Long> ID = 
        TypedProp.scalar(ImmutableType.get(Post.class).getProp("id"));

    TypedProp.Scalar<Post, String> TITLE = 
        TypedProp.scalar(ImmutableType.get(Post.class).getProp("title"));

    TypedProp.Scalar<Post, String> CONTENT = 
        TypedProp.scalar(ImmutableType.get(Post.class).getProp("content"));

    TypedProp.Scalar<Post, Instant> CREATED_AT = 
        TypedProp.scalar(ImmutableType.get(Post.class).getProp("createdAt"));

    TypedProp.ReferenceList<Post, PostComment> COMMENTS = 
        TypedProp.referenceList(ImmutableType.get(Post.class).getProp("comments"));

    PropExpression.Num<Long> id();

    PropExpression.Str title();

    PropExpression.Str content();

    PropExpression.Cmp<Instant> createdAt();

    Predicate comments(Function<PostCommentTableEx, Predicate> block);
}
