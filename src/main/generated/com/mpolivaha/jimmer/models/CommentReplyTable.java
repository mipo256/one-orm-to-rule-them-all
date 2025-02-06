package com.mpolivaha.jimmer.models;

import java.lang.Deprecated;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = CommentReply.class
)
public class CommentReplyTable extends AbstractTypedTable<CommentReply> implements CommentReplyProps {
    public static final CommentReplyTable $ = new CommentReplyTable();

    public CommentReplyTable() {
        super(CommentReply.class);
    }

    public CommentReplyTable(AbstractTypedTable.DelayedOperation<CommentReply> delayedOperation) {
        super(CommentReply.class, delayedOperation);
    }

    public CommentReplyTable(TableImplementor<CommentReply> table) {
        super(table);
    }

    protected CommentReplyTable(CommentReplyTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(CommentReplyProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str body() {
        return __get(CommentReplyProps.BODY.unwrap());
    }

    @Override
    public PostCommentTable postComment() {
        __beforeJoin();
        if (raw != null) {
            return new PostCommentTable(raw.joinImplementor(CommentReplyProps.POST_COMMENT.unwrap()));
        }
        return new PostCommentTable(joinOperation(CommentReplyProps.POST_COMMENT.unwrap()));
    }

    @Override
    public PostCommentTable postComment(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new PostCommentTable(raw.joinImplementor(CommentReplyProps.POST_COMMENT.unwrap(), joinType));
        }
        return new PostCommentTable(joinOperation(CommentReplyProps.POST_COMMENT.unwrap(), joinType));
    }

    @Override
    public PropExpression.Num<Long> postCommentId() {
        return __getAssociatedId(CommentReplyProps.POST_COMMENT.unwrap());
    }

    @Override
    public PropExpression.Cmp<Instant> createdAt() {
        return __get(CommentReplyProps.CREATED_AT.unwrap());
    }

    @Override
    public CommentReplyTableEx asTableEx() {
        return new CommentReplyTableEx(this, null);
    }

    @Override
    public CommentReplyTable __disableJoin(String reason) {
        return new CommentReplyTable(this, reason);
    }

    @GeneratedBy(
            type = CommentReply.class
    )
    public static class Remote extends AbstractTypedTable<CommentReply> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(CommentReply.class, delayedOperation);
        }

        public Remote(TableImplementor<CommentReply> table) {
            super(table);
        }

        public PropExpression.Num<Long> id() {
            return __get(CommentReplyProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<CommentReply> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
