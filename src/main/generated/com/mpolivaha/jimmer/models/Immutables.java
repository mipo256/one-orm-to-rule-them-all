package com.mpolivaha.jimmer.models;

import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.internal.GeneratedBy;

@GeneratedBy
public interface Immutables {
    static CommentReply createCommentReply(DraftConsumer<CommentReplyDraft> block) {
        return CommentReplyDraft.$.produce(block);
    }

    static CommentReply createCommentReply(CommentReply base,
            DraftConsumer<CommentReplyDraft> block) {
        return CommentReplyDraft.$.produce(base, block);
    }

    static Post createPost(DraftConsumer<PostDraft> block) {
        return PostDraft.$.produce(block);
    }

    static Post createPost(Post base, DraftConsumer<PostDraft> block) {
        return PostDraft.$.produce(base, block);
    }

    static PostComment createPostComment(DraftConsumer<PostCommentDraft> block) {
        return PostCommentDraft.$.produce(block);
    }

    static PostComment createPostComment(PostComment base, DraftConsumer<PostCommentDraft> block) {
        return PostCommentDraft.$.produce(base, block);
    }
}
