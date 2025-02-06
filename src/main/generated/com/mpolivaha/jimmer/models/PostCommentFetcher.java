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
import org.babyfish.jimmer.sql.fetcher.ListFieldConfig;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = PostComment.class
)
public class PostCommentFetcher extends AbstractTypedFetcher<PostComment, PostCommentFetcher> {
    public static final PostCommentFetcher $ = new PostCommentFetcher(null);

    private PostCommentFetcher(FetcherImpl<PostComment> base) {
        super(PostComment.class, base);
    }

    private PostCommentFetcher(PostCommentFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private PostCommentFetcher(PostCommentFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static PostCommentFetcher $from(Fetcher<PostComment> base) {
        return base instanceof PostCommentFetcher ? 
        	(PostCommentFetcher)base : 
        	new PostCommentFetcher((FetcherImpl<PostComment>)base);
    }

    @NewChain
    public PostCommentFetcher comment() {
        return add("comment");
    }

    @NewChain
    public PostCommentFetcher comment(boolean enabled) {
        return enabled ? add("comment") : remove("comment");
    }

    @NewChain
    public PostCommentFetcher post() {
        return add("post");
    }

    @NewChain
    public PostCommentFetcher post(boolean enabled) {
        return enabled ? add("post") : remove("post");
    }

    @NewChain
    public PostCommentFetcher post(Fetcher<Post> childFetcher) {
        return add("post", childFetcher);
    }

    @NewChain
    public PostCommentFetcher post(Fetcher<Post> childFetcher,
            Consumer<FieldConfig<Post, PostTable>> fieldConfig) {
        return add("post", childFetcher, fieldConfig);
    }

    @NewChain
    public PostCommentFetcher post(IdOnlyFetchType idOnlyFetchType) {
        return add("post", idOnlyFetchType);
    }

    @NewChain
    public PostCommentFetcher createdAt() {
        return add("createdAt");
    }

    @NewChain
    public PostCommentFetcher createdAt(boolean enabled) {
        return enabled ? add("createdAt") : remove("createdAt");
    }

    @NewChain
    public PostCommentFetcher commentReplies() {
        return add("commentReplies");
    }

    @NewChain
    public PostCommentFetcher commentReplies(boolean enabled) {
        return enabled ? add("commentReplies") : remove("commentReplies");
    }

    @NewChain
    public PostCommentFetcher commentReplies(Fetcher<CommentReply> childFetcher) {
        return add("commentReplies", childFetcher);
    }

    @NewChain
    public PostCommentFetcher commentReplies(Fetcher<CommentReply> childFetcher,
            Consumer<ListFieldConfig<CommentReply, CommentReplyTable>> fieldConfig) {
        return add("commentReplies", childFetcher, fieldConfig);
    }

    @Override
    protected PostCommentFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new PostCommentFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected PostCommentFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new PostCommentFetcher(this, prop, fieldConfig);
    }
}
