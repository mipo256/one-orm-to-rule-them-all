package com.mpolivaha.jimmer.models;

import java.lang.Override;
import java.util.function.Consumer;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = CommentReply.class
)
public class CommentReplyFetcher extends AbstractTypedFetcher<CommentReply, CommentReplyFetcher> {
    public static final CommentReplyFetcher $ = new CommentReplyFetcher(null);

    private CommentReplyFetcher(FetcherImpl<CommentReply> base) {
        super(CommentReply.class, base);
    }

    private CommentReplyFetcher(CommentReplyFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private CommentReplyFetcher(CommentReplyFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static CommentReplyFetcher $from(Fetcher<CommentReply> base) {
        return base instanceof CommentReplyFetcher ? 
        	(CommentReplyFetcher)base : 
        	new CommentReplyFetcher((FetcherImpl<CommentReply>)base);
    }

    @NewChain
    public CommentReplyFetcher body() {
        return add("body");
    }

    @NewChain
    public CommentReplyFetcher body(boolean enabled) {
        return enabled ? add("body") : remove("body");
    }

    @NewChain
    public CommentReplyFetcher postComment() {
        return add("postComment");
    }

    @NewChain
    public CommentReplyFetcher postComment(boolean enabled) {
        return enabled ? add("postComment") : remove("postComment");
    }

    @NewChain
    public CommentReplyFetcher postComment(Fetcher<PostComment> childFetcher) {
        return add("postComment", childFetcher);
    }

    @NewChain
    public CommentReplyFetcher postComment(Fetcher<PostComment> childFetcher,
            Consumer<FieldConfig<PostComment, PostCommentTable>> fieldConfig) {
        return add("postComment", childFetcher, fieldConfig);
    }

    @NewChain
    public CommentReplyFetcher postComment(IdOnlyFetchType idOnlyFetchType) {
        return add("postComment", idOnlyFetchType);
    }

    @NewChain
    public CommentReplyFetcher createdAt() {
        return add("createdAt");
    }

    @NewChain
    public CommentReplyFetcher createdAt(boolean enabled) {
        return enabled ? add("createdAt") : remove("createdAt");
    }

    @Override
    protected CommentReplyFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new CommentReplyFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected CommentReplyFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new CommentReplyFetcher(this, prop, fieldConfig);
    }
}
