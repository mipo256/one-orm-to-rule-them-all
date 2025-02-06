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
        type = Post.class
)
public class PostFetcher extends AbstractTypedFetcher<Post, PostFetcher> {
    public static final PostFetcher $ = new PostFetcher(null);

    private PostFetcher(FetcherImpl<Post> base) {
        super(Post.class, base);
    }

    private PostFetcher(PostFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private PostFetcher(PostFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static PostFetcher $from(Fetcher<Post> base) {
        return base instanceof PostFetcher ? 
        	(PostFetcher)base : 
        	new PostFetcher((FetcherImpl<Post>)base);
    }

    @NewChain
    public PostFetcher title() {
        return add("title");
    }

    @NewChain
    public PostFetcher title(boolean enabled) {
        return enabled ? add("title") : remove("title");
    }

    @NewChain
    public PostFetcher content() {
        return add("content");
    }

    @NewChain
    public PostFetcher content(boolean enabled) {
        return enabled ? add("content") : remove("content");
    }

    @NewChain
    public PostFetcher createdAt() {
        return add("createdAt");
    }

    @NewChain
    public PostFetcher createdAt(boolean enabled) {
        return enabled ? add("createdAt") : remove("createdAt");
    }

    @NewChain
    public PostFetcher comments() {
        return add("comments");
    }

    @NewChain
    public PostFetcher comments(boolean enabled) {
        return enabled ? add("comments") : remove("comments");
    }

    @NewChain
    public PostFetcher comments(Fetcher<PostComment> childFetcher) {
        return add("comments", childFetcher);
    }

    @NewChain
    public PostFetcher comments(Fetcher<PostComment> childFetcher,
            Consumer<ListFieldConfig<PostComment, PostCommentTable>> fieldConfig) {
        return add("comments", childFetcher, fieldConfig);
    }

    @Override
    protected PostFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new PostFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected PostFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new PostFetcher(this, prop, fieldConfig);
    }
}
