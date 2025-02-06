package com.mpolivaha.jimmer.models;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.impl.table.TableProxies;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.WeakJoin;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = CommentReply.class
)
public class CommentReplyTableEx extends CommentReplyTable implements TableEx<CommentReply> {
    public static final CommentReplyTableEx $ = new CommentReplyTableEx(CommentReplyTable.$, null);

    public CommentReplyTableEx() {
        super();
    }

    public CommentReplyTableEx(AbstractTypedTable.DelayedOperation<CommentReply> delayedOperation) {
        super(delayedOperation);
    }

    public CommentReplyTableEx(TableImplementor<CommentReply> table) {
        super(table);
    }

    protected CommentReplyTableEx(CommentReplyTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    public PostCommentTableEx postComment() {
        __beforeJoin();
        if (raw != null) {
            return new PostCommentTableEx(raw.joinImplementor(CommentReplyProps.POST_COMMENT.unwrap()));
        }
        return new PostCommentTableEx(joinOperation(CommentReplyProps.POST_COMMENT.unwrap()));
    }

    public PostCommentTableEx postComment(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new PostCommentTableEx(raw.joinImplementor(CommentReplyProps.POST_COMMENT.unwrap(), joinType));
        }
        return new PostCommentTableEx(joinOperation(CommentReplyProps.POST_COMMENT.unwrap(), joinType));
    }

    @Override
    public CommentReplyTableEx asTableEx() {
        return this;
    }

    @Override
    public CommentReplyTableEx __disableJoin(String reason) {
        return new CommentReplyTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<CommentReplyTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>, WJ extends WeakJoin<CommentReplyTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
