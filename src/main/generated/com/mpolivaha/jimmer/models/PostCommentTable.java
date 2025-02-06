package com.mpolivaha.jimmer.models;

import java.lang.Deprecated;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.Predicate;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = PostComment.class
)
public class PostCommentTable extends AbstractTypedTable<PostComment> implements PostCommentProps {
    public static final PostCommentTable $ = new PostCommentTable();

    public PostCommentTable() {
        super(PostComment.class);
    }

    public PostCommentTable(AbstractTypedTable.DelayedOperation<PostComment> delayedOperation) {
        super(PostComment.class, delayedOperation);
    }

    public PostCommentTable(TableImplementor<PostComment> table) {
        super(table);
    }

    protected PostCommentTable(PostCommentTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(PostCommentProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str comment() {
        return __get(PostCommentProps.COMMENT.unwrap());
    }

    @Override
    public PostTable post() {
        __beforeJoin();
        if (raw != null) {
            return new PostTable(raw.joinImplementor(PostCommentProps.POST.unwrap()));
        }
        return new PostTable(joinOperation(PostCommentProps.POST.unwrap()));
    }

    @Override
    public PostTable post(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new PostTable(raw.joinImplementor(PostCommentProps.POST.unwrap(), joinType));
        }
        return new PostTable(joinOperation(PostCommentProps.POST.unwrap(), joinType));
    }

    @Override
    public PropExpression.Num<Long> postId() {
        return __getAssociatedId(PostCommentProps.POST.unwrap());
    }

    @Override
    public PropExpression.Cmp<Instant> createdAt() {
        return __get(PostCommentProps.CREATED_AT.unwrap());
    }

    @Override
    public Predicate commentReplies(Function<CommentReplyTableEx, Predicate> block) {
        return exists(PostCommentProps.COMMENT_REPLIES.unwrap(), block);
    }

    @Override
    public PostCommentTableEx asTableEx() {
        return new PostCommentTableEx(this, null);
    }

    @Override
    public PostCommentTable __disableJoin(String reason) {
        return new PostCommentTable(this, reason);
    }

    @GeneratedBy(
            type = PostComment.class
    )
    public static class Remote extends AbstractTypedTable<PostComment> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(PostComment.class, delayedOperation);
        }

        public Remote(TableImplementor<PostComment> table) {
            super(table);
        }

        public PropExpression.Num<Long> id() {
            return __get(PostCommentProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<PostComment> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
