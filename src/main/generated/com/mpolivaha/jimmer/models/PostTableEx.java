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
        type = Post.class
)
public class PostTableEx extends PostTable implements TableEx<Post> {
    public static final PostTableEx $ = new PostTableEx(PostTable.$, null);

    public PostTableEx() {
        super();
    }

    public PostTableEx(AbstractTypedTable.DelayedOperation<Post> delayedOperation) {
        super(delayedOperation);
    }

    public PostTableEx(TableImplementor<Post> table) {
        super(table);
    }

    protected PostTableEx(PostTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    public PostCommentTableEx comments() {
        __beforeJoin();
        if (raw != null) {
            return new PostCommentTableEx(raw.joinImplementor(PostProps.COMMENTS.unwrap()));
        }
        return new PostCommentTableEx(joinOperation(PostProps.COMMENTS.unwrap()));
    }

    public PostCommentTableEx comments(JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return new PostCommentTableEx(raw.joinImplementor(PostProps.COMMENTS.unwrap(), joinType));
        }
        return new PostCommentTableEx(joinOperation(PostProps.COMMENTS.unwrap(), joinType));
    }

    @Override
    public Predicate comments(Function<PostCommentTableEx, Predicate> block) {
        return exists(PostProps.COMMENTS.unwrap(), block);
    }

    @Override
    public PostTableEx asTableEx() {
        return this;
    }

    @Override
    public PostTableEx __disableJoin(String reason) {
        return new PostTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<PostTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>, WJ extends WeakJoin<PostTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
