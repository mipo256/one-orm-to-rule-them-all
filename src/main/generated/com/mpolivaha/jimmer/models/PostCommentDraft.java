package com.mpolivaha.jimmer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.NonSharedList;
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.ManyToOne;
import org.babyfish.jimmer.sql.OneToMany;

@GeneratedBy(
        type = PostComment.class
)
public interface PostCommentDraft extends PostComment, Draft {
    PostCommentDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    PostCommentDraft setId(long id);

    @OldChain
    PostCommentDraft setComment(String comment);

    PostDraft post();

    PostDraft post(boolean autoCreate);

    @OldChain
    PostCommentDraft setPost(Post post);

    long postId();

    @OldChain
    PostCommentDraft setPostId(long postId);

    @OldChain
    PostCommentDraft applyPost(DraftConsumer<PostDraft> block);

    @OldChain
    PostCommentDraft applyPost(Post base, DraftConsumer<PostDraft> block);

    @OldChain
    PostCommentDraft setCreatedAt(Instant createdAt);

    List<CommentReplyDraft> commentReplies(boolean autoCreate);

    @OldChain
    PostCommentDraft setCommentReplies(List<CommentReply> commentReplies);

    @OldChain
    PostCommentDraft addIntoCommentReplies(DraftConsumer<CommentReplyDraft> block);

    @OldChain
    PostCommentDraft addIntoCommentReplies(CommentReply base,
            DraftConsumer<CommentReplyDraft> block);

    @GeneratedBy(
            type = PostComment.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_COMMENT = 1;

        public static final int SLOT_POST = 2;

        public static final int SLOT_CREATED_AT = 3;

        public static final int SLOT_COMMENT_REPLIES = 4;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.37",
                PostComment.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (PostComment)base)
            )
            .id(SLOT_ID, "id", long.class)
            .add(SLOT_COMMENT, "comment", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_POST, "post", ManyToOne.class, Post.class, false)
            .add(SLOT_CREATED_AT, "createdAt", ImmutablePropCategory.SCALAR, Instant.class, false)
            .add(SLOT_COMMENT_REPLIES, "commentReplies", OneToMany.class, CommentReply.class, false)
            .build();

        private Producer() {
        }

        public PostComment produce(DraftConsumer<PostCommentDraft> block) {
            return produce(null, block);
        }

        public PostComment produce(PostComment base, DraftConsumer<PostCommentDraft> block) {
            return (PostComment)Internal.produce(TYPE, base, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = PostComment.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "comment", "post", "createdAt", "commentReplies"})
        public abstract static class Implementor implements PostComment, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_COMMENT:
                    		return comment();
                    case SLOT_POST:
                    		return post();
                    case SLOT_CREATED_AT:
                    		return createdAt();
                    case SLOT_COMMENT_REPLIES:
                    		return commentReplies();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "comment":
                    		return comment();
                    case "post":
                    		return post();
                    case "createdAt":
                    		return createdAt();
                    case "commentReplies":
                    		return commentReplies();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getComment() {
                return comment();
            }

            public final Post getPost() {
                return post();
            }

            public final Instant getCreatedAt() {
                return createdAt();
            }

            public final List<CommentReply> getCommentReplies() {
                return commentReplies();
            }

            @Override
            public final ImmutableType __type() {
                return TYPE;
            }

            public final int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        @GeneratedBy(
                type = PostComment.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __commentValue;

            Post __postValue;

            Instant __createdAtValue;

            NonSharedList<CommentReply> __commentRepliesValue;

            @Override
            @JsonIgnore
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(PostComment.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            public String comment() {
                if (__commentValue == null) {
                    throw new UnloadedException(PostComment.class, "comment");
                }
                return __commentValue;
            }

            @Override
            @JsonIgnore
            public Post post() {
                if (__postValue == null) {
                    throw new UnloadedException(PostComment.class, "post");
                }
                return __postValue;
            }

            @Override
            @JsonIgnore
            public Instant createdAt() {
                if (__createdAtValue == null) {
                    throw new UnloadedException(PostComment.class, "createdAt");
                }
                return __createdAtValue;
            }

            @Override
            @JsonIgnore
            public List<CommentReply> commentReplies() {
                if (__commentRepliesValue == null) {
                    throw new UnloadedException(PostComment.class, "commentReplies");
                }
                return __commentRepliesValue;
            }

            @Override
            public Impl clone() {
                try {
                    return (Impl)super.clone();
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_ID:
                    		return __idLoaded;
                    case SLOT_COMMENT:
                    		return __commentValue != null;
                    case SLOT_POST:
                    		return __postValue != null;
                    case SLOT_CREATED_AT:
                    		return __createdAtValue != null;
                    case SLOT_COMMENT_REPLIES:
                    		return __commentRepliesValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "comment":
                    		return __commentValue != null;
                    case "post":
                    		return __postValue != null;
                    case "createdAt":
                    		return __createdAtValue != null;
                    case "commentReplies":
                    		return __commentRepliesValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_ID:
                    		return __visibility.visible(SLOT_ID);
                    case SLOT_COMMENT:
                    		return __visibility.visible(SLOT_COMMENT);
                    case SLOT_POST:
                    		return __visibility.visible(SLOT_POST);
                    case SLOT_CREATED_AT:
                    		return __visibility.visible(SLOT_CREATED_AT);
                    case SLOT_COMMENT_REPLIES:
                    		return __visibility.visible(SLOT_COMMENT_REPLIES);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "id":
                    		return __visibility.visible(SLOT_ID);
                    case "comment":
                    		return __visibility.visible(SLOT_COMMENT);
                    case "post":
                    		return __visibility.visible(SLOT_POST);
                    case "createdAt":
                    		return __visibility.visible(SLOT_CREATED_AT);
                    case "commentReplies":
                    		return __visibility.visible(SLOT_COMMENT_REPLIES);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__commentValue != null) {
                    hash = 31 * hash + __commentValue.hashCode();
                }
                if (__postValue != null) {
                    hash = 31 * hash + __postValue.hashCode();
                }
                if (__createdAtValue != null) {
                    hash = 31 * hash + __createdAtValue.hashCode();
                }
                if (__commentRepliesValue != null) {
                    hash = 31 * hash + __commentRepliesValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__commentValue != null) {
                    hash = 31 * hash + System.identityHashCode(__commentValue);
                }
                if (__postValue != null) {
                    hash = 31 * hash + System.identityHashCode(__postValue);
                }
                if (__createdAtValue != null) {
                    hash = 31 * hash + System.identityHashCode(__createdAtValue);
                }
                if (__commentRepliesValue != null) {
                    hash = 31 * hash + System.identityHashCode(__commentRepliesValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded) {
                    // If entity-id is loaded, return directly
                    return __idValue == __other.id();
                }
                if (__isVisible(PropId.byIndex(SLOT_COMMENT)) != __other.__isVisible(PropId.byIndex(SLOT_COMMENT))) {
                    return false;
                }
                boolean __commentLoaded = __commentValue != null;
                if (__commentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_COMMENT))) {
                    return false;
                }
                if (__commentLoaded && !Objects.equals(__commentValue, __other.comment())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_POST)) != __other.__isVisible(PropId.byIndex(SLOT_POST))) {
                    return false;
                }
                boolean __postLoaded = __postValue != null;
                if (__postLoaded != __other.__isLoaded(PropId.byIndex(SLOT_POST))) {
                    return false;
                }
                if (__postLoaded && !Objects.equals(__postValue, __other.post())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATED_AT)) != __other.__isVisible(PropId.byIndex(SLOT_CREATED_AT))) {
                    return false;
                }
                boolean __createdAtLoaded = __createdAtValue != null;
                if (__createdAtLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATED_AT))) {
                    return false;
                }
                if (__createdAtLoaded && !Objects.equals(__createdAtValue, __other.createdAt())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_COMMENT_REPLIES)) != __other.__isVisible(PropId.byIndex(SLOT_COMMENT_REPLIES))) {
                    return false;
                }
                boolean __commentRepliesLoaded = __commentRepliesValue != null;
                if (__commentRepliesLoaded != __other.__isLoaded(PropId.byIndex(SLOT_COMMENT_REPLIES))) {
                    return false;
                }
                if (__commentRepliesLoaded && !Objects.equals(__commentRepliesValue, __other.commentReplies())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                boolean __idLoaded = this.__idLoaded;
                if (__idLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID))) {
                    return false;
                }
                if (__idLoaded && __idValue != __other.id()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_COMMENT)) != __other.__isVisible(PropId.byIndex(SLOT_COMMENT))) {
                    return false;
                }
                boolean __commentLoaded = __commentValue != null;
                if (__commentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_COMMENT))) {
                    return false;
                }
                if (__commentLoaded && __commentValue != __other.comment()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_POST)) != __other.__isVisible(PropId.byIndex(SLOT_POST))) {
                    return false;
                }
                boolean __postLoaded = __postValue != null;
                if (__postLoaded != __other.__isLoaded(PropId.byIndex(SLOT_POST))) {
                    return false;
                }
                if (__postLoaded && __postValue != __other.post()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATED_AT)) != __other.__isVisible(PropId.byIndex(SLOT_CREATED_AT))) {
                    return false;
                }
                boolean __createdAtLoaded = __createdAtValue != null;
                if (__createdAtLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATED_AT))) {
                    return false;
                }
                if (__createdAtLoaded && __createdAtValue != __other.createdAt()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_COMMENT_REPLIES)) != __other.__isVisible(PropId.byIndex(SLOT_COMMENT_REPLIES))) {
                    return false;
                }
                boolean __commentRepliesLoaded = __commentRepliesValue != null;
                if (__commentRepliesLoaded != __other.__isLoaded(PropId.byIndex(SLOT_COMMENT_REPLIES))) {
                    return false;
                }
                if (__commentRepliesLoaded && __commentRepliesValue != __other.commentReplies()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        @GeneratedBy(
                type = PostComment.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, PostCommentDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private PostComment __resolved;

            DraftImpl(DraftContext ctx, PostComment base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }

            @Override
            @JsonIgnore
            public long id() {
                return (__modified!= null ? __modified : __base).id();
            }

            @Override
            public PostCommentDraft setId(long id) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Impl __tmpModified = __modified();
                __tmpModified.__idValue = id;
                __tmpModified.__idLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String comment() {
                return (__modified!= null ? __modified : __base).comment();
            }

            @Override
            public PostCommentDraft setComment(String comment) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (comment == null) {
                    throw new IllegalArgumentException(
                        "'comment' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__commentValue = comment;
                return this;
            }

            @Override
            @JsonIgnore
            public PostDraft post() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).post());
            }

            @Override
            public PostDraft post(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_POST)))) {
                    setPost(PostDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).post());
            }

            @Override
            public PostCommentDraft setPost(Post post) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (post == null) {
                    throw new IllegalArgumentException(
                        "'post' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__postValue = post;
                return this;
            }

            @Override
            public long postId() {
                return post().id();
            }

            @OldChain
            @Override
            public PostCommentDraft setPostId(long postId) {
                post(true).setId(Objects.requireNonNull(postId, "\"post\" cannot be null"));
                return this;
            }

            @Override
            public PostCommentDraft applyPost(DraftConsumer<PostDraft> block) {
                applyPost(null, block);
                return this;
            }

            @Override
            public PostCommentDraft applyPost(Post base, DraftConsumer<PostDraft> block) {
                setPost(PostDraft.$.produce(base, block));
                return this;
            }

            @Override
            @JsonIgnore
            public Instant createdAt() {
                return (__modified!= null ? __modified : __base).createdAt();
            }

            @Override
            public PostCommentDraft setCreatedAt(Instant createdAt) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (createdAt == null) {
                    throw new IllegalArgumentException(
                        "'createdAt' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__createdAtValue = createdAt;
                return this;
            }

            @Override
            @JsonIgnore
            public List<CommentReply> commentReplies() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).commentReplies(), CommentReply.class, true);
            }

            @Override
            public List<CommentReplyDraft> commentReplies(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_COMMENT_REPLIES)))) {
                    setCommentReplies(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).commentReplies(), CommentReply.class, true);
            }

            @Override
            public PostCommentDraft setCommentReplies(List<CommentReply> commentReplies) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (commentReplies == null) {
                    throw new IllegalArgumentException(
                        "'commentReplies' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__commentRepliesValue = NonSharedList.of(__tmpModified.__commentRepliesValue, commentReplies);
                return this;
            }

            @Override
            public PostCommentDraft addIntoCommentReplies(DraftConsumer<CommentReplyDraft> block) {
                addIntoCommentReplies(null, block);
                return this;
            }

            @Override
            public PostCommentDraft addIntoCommentReplies(CommentReply base,
                    DraftConsumer<CommentReplyDraft> block) {
                commentReplies(true).add((CommentReplyDraft)CommentReplyDraft.$.produce(base, block));
                return this;
            }

            @SuppressWarnings("all")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_ID:
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case SLOT_COMMENT:
                    		setComment((String)value);break;
                    case SLOT_POST:
                    		setPost((Post)value);break;
                    case SLOT_CREATED_AT:
                    		setCreatedAt((Instant)value);break;
                    case SLOT_COMMENT_REPLIES:
                    		setCommentReplies((List<CommentReply>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("all")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "id":
                    		if (value == null) throw new IllegalArgumentException("'id' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setId((Long)value);
                            break;
                    case "comment":
                    		setComment((String)value);break;
                    case "post":
                    		setPost((Post)value);break;
                    case "createdAt":
                    		setCreatedAt((Instant)value);break;
                    case "commentReplies":
                    		setCommentReplies((List<CommentReply>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(5);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_COMMENT:
                    		__visibility.show(SLOT_COMMENT, visible);break;
                    case SLOT_POST:
                    		__visibility.show(SLOT_POST, visible);break;
                    case SLOT_CREATED_AT:
                    		__visibility.show(SLOT_CREATED_AT, visible);break;
                    case SLOT_COMMENT_REPLIES:
                    		__visibility.show(SLOT_COMMENT_REPLIES, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.mpolivaha.jimmer.models.PostComment\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(5);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "comment":
                    		__visibility.show(SLOT_COMMENT, visible);break;
                    case "post":
                    		__visibility.show(SLOT_POST, visible);break;
                    case "createdAt":
                    		__visibility.show(SLOT_CREATED_AT, visible);break;
                    case "commentReplies":
                    		__visibility.show(SLOT_COMMENT_REPLIES, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_ID:
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case SLOT_COMMENT:
                    		__modified().__commentValue = null;break;
                    case SLOT_POST:
                    		__modified().__postValue = null;break;
                    case SLOT_CREATED_AT:
                    		__modified().__createdAtValue = null;break;
                    case SLOT_COMMENT_REPLIES:
                    		__modified().__commentRepliesValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                switch (prop) {
                    case "id":
                    		__modified().__idValue = 0;
                    __modified().__idLoaded = false;break;
                    case "comment":
                    		__modified().__commentValue = null;break;
                    case "post":
                    		__modified().__postValue = null;break;
                    case "createdAt":
                    		__modified().__createdAtValue = null;break;
                    case "commentReplies":
                    		__modified().__commentRepliesValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.PostComment\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolved != null) {
                    return __resolved;
                }
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__tmpModified == null) {
                        if (base.__isLoaded(PropId.byIndex(SLOT_POST))) {
                            Post oldValue = base.post();
                            Post newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setPost(newValue);
                            }
                        }
                        if (base.__isLoaded(PropId.byIndex(SLOT_COMMENT_REPLIES))) {
                            List<CommentReply> oldValue = base.commentReplies();
                            List<CommentReply> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setCommentReplies(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__postValue = __ctx.resolveObject(__tmpModified.__postValue);
                        __tmpModified.__commentRepliesValue = NonSharedList.of(__tmpModified.__commentRepliesValue, __ctx.resolveList(__tmpModified.__commentRepliesValue));
                    }
                    if (__base != null && __tmpModified == null) {
                        this.__resolved = base;
                        return base;
                    }
                    this.__resolved = __tmpModified;
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            @Override
            public boolean __isResolved() {
                return __resolved != null;
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    @GeneratedBy(
            type = PostComment.class
    )
    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            __draft = new Producer.DraftImpl(null, null);
        }

        public Builder id(Long id) {
            if (id != null) {
                __draft.setId(id);
            }
            return this;
        }

        public Builder comment(String comment) {
            if (comment != null) {
                __draft.setComment(comment);
            }
            return this;
        }

        public Builder post(Post post) {
            if (post != null) {
                __draft.setPost(post);
            }
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            if (createdAt != null) {
                __draft.setCreatedAt(createdAt);
            }
            return this;
        }

        public Builder commentReplies(List<CommentReply> commentReplies) {
            if (commentReplies != null) {
                __draft.setCommentReplies(commentReplies);
            }
            return this;
        }

        public PostComment build() {
            return (PostComment)__draft.__modified();
        }
    }
}
