package com.mpolivaha.jimmer.models;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.impl.table.TableProxies;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.WeakJoin;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = PostComment.class
)
public class PostCommentTableEx extends PostCommentTable implements TableEx<PostComment> {
    public static final PostCommentTableEx $ = new PostCommentTableEx(PostCommentTable.$, null);

    public PostCommentTableEx() {
        super();
    }

    public PostCommentTableEx(AbstractTypedTable.DelayedOperation<PostComment> delayedOperation) {
        super(delayedOperation);
    }

    public PostCommentTableEx(TableImplementor<PostComment> table) {
        super(table);
    }

    protected PostCommentTableEx(PostCommentTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    public PostTableEx post() {
        __beforeJoin();
        if (raw != null) {
            return new PostTableEx(raw.joinImplementor(PostCommentProps.POST.unwrap()));
        }
        return new PostTableEx(joinOperation(PostCommentProps.POST.unwrap()));
    }

    public PostTableEx post(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new PostTableEx(raw.joinImplementor(PostCommentProps.POST.unwrap(), joinType));
        }
        return new PostTableEx(joinOperation(PostCommentProps.POST.unwrap(), joinType));
    }

    public CommentReplyTableEx commentReplies() {
        __beforeJoin();
        if (raw != null) {
            return new CommentReplyTableEx(raw.joinImplementor(PostCommentProps.COMMENT_REPLIES.unwrap()));
        }
        return new CommentReplyTableEx(joinOperation(PostCommentProps.COMMENT_REPLIES.unwrap()));
    }

    public CommentReplyTableEx commentReplies(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new CommentReplyTableEx(raw.joinImplementor(PostCommentProps.COMMENT_REPLIES.unwrap(), joinType));
        }
        return new CommentReplyTableEx(joinOperation(PostCommentProps.COMMENT_REPLIES.unwrap(), joinType));
    }

    @Override
    public Predicate commentReplies(Function<CommentReplyTableEx, Predicate> block) {
        return exists(PostCommentProps.COMMENT_REPLIES.unwrap(), block);
    }

    @Override
    public PostCommentTableEx asTableEx() {
        return this;
    }

    @Override
    public PostCommentTableEx __disableJoin(String reason) {
        return new PostCommentTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<PostCommentTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>, WJ extends WeakJoin<PostCommentTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
