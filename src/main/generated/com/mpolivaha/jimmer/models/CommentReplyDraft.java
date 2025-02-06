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
import java.util.Collections;
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
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.ManyToOne;

@GeneratedBy(
        type = CommentReply.class
)
public interface CommentReplyDraft extends CommentReply, Draft {
    CommentReplyDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    CommentReplyDraft setId(long id);

    @OldChain
    CommentReplyDraft setBody(String body);

    PostCommentDraft postComment();

    PostCommentDraft postComment(boolean autoCreate);

    @OldChain
    CommentReplyDraft setPostComment(PostComment postComment);

    long postCommentId();

    @OldChain
    CommentReplyDraft setPostCommentId(long postCommentId);

    @OldChain
    CommentReplyDraft applyPostComment(DraftConsumer<PostCommentDraft> block);

    @OldChain
    CommentReplyDraft applyPostComment(PostComment base, DraftConsumer<PostCommentDraft> block);

    @OldChain
    CommentReplyDraft setCreatedAt(Instant createdAt);

    @GeneratedBy(
            type = CommentReply.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_BODY = 1;

        public static final int SLOT_POST_COMMENT = 2;

        public static final int SLOT_CREATED_AT = 3;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.37",
                CommentReply.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (CommentReply)base)
            )
            .id(SLOT_ID, "id", long.class)
            .add(SLOT_BODY, "body", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_POST_COMMENT, "postComment", ManyToOne.class, PostComment.class, false)
            .add(SLOT_CREATED_AT, "createdAt", ImmutablePropCategory.SCALAR, Instant.class, false)
            .build();

        private Producer() {
        }

        public CommentReply produce(DraftConsumer<CommentReplyDraft> block) {
            return produce(null, block);
        }

        public CommentReply produce(CommentReply base, DraftConsumer<CommentReplyDraft> block) {
            return (CommentReply)Internal.produce(TYPE, base, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = CommentReply.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "body", "postComment", "createdAt"})
        public abstract static class Implementor implements CommentReply, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_BODY:
                    		return body();
                    case SLOT_POST_COMMENT:
                    		return postComment();
                    case SLOT_CREATED_AT:
                    		return createdAt();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "body":
                    		return body();
                    case "postComment":
                    		return postComment();
                    case "createdAt":
                    		return createdAt();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getBody() {
                return body();
            }

            public final PostComment getPostComment() {
                return postComment();
            }

            public final Instant getCreatedAt() {
                return createdAt();
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
                type = CommentReply.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __bodyValue;

            PostComment __postCommentValue;

            Instant __createdAtValue;

            @Override
            @JsonIgnore
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(CommentReply.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            public String body() {
                if (__bodyValue == null) {
                    throw new UnloadedException(CommentReply.class, "body");
                }
                return __bodyValue;
            }

            @Override
            @JsonIgnore
            public PostComment postComment() {
                if (__postCommentValue == null) {
                    throw new UnloadedException(CommentReply.class, "postComment");
                }
                return __postCommentValue;
            }

            @Override
            @JsonIgnore
            public Instant createdAt() {
                if (__createdAtValue == null) {
                    throw new UnloadedException(CommentReply.class, "createdAt");
                }
                return __createdAtValue;
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
                    case SLOT_BODY:
                    		return __bodyValue != null;
                    case SLOT_POST_COMMENT:
                    		return __postCommentValue != null;
                    case SLOT_CREATED_AT:
                    		return __createdAtValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "body":
                    		return __bodyValue != null;
                    case "postComment":
                    		return __postCommentValue != null;
                    case "createdAt":
                    		return __createdAtValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\"");
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
                    case SLOT_BODY:
                    		return __visibility.visible(SLOT_BODY);
                    case SLOT_POST_COMMENT:
                    		return __visibility.visible(SLOT_POST_COMMENT);
                    case SLOT_CREATED_AT:
                    		return __visibility.visible(SLOT_CREATED_AT);
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
                    case "body":
                    		return __visibility.visible(SLOT_BODY);
                    case "postComment":
                    		return __visibility.visible(SLOT_POST_COMMENT);
                    case "createdAt":
                    		return __visibility.visible(SLOT_CREATED_AT);
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
                if (__bodyValue != null) {
                    hash = 31 * hash + __bodyValue.hashCode();
                }
                if (__postCommentValue != null) {
                    hash = 31 * hash + __postCommentValue.hashCode();
                }
                if (__createdAtValue != null) {
                    hash = 31 * hash + __createdAtValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__bodyValue != null) {
                    hash = 31 * hash + System.identityHashCode(__bodyValue);
                }
                if (__postCommentValue != null) {
                    hash = 31 * hash + System.identityHashCode(__postCommentValue);
                }
                if (__createdAtValue != null) {
                    hash = 31 * hash + System.identityHashCode(__createdAtValue);
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
                if (__isVisible(PropId.byIndex(SLOT_BODY)) != __other.__isVisible(PropId.byIndex(SLOT_BODY))) {
                    return false;
                }
                boolean __bodyLoaded = __bodyValue != null;
                if (__bodyLoaded != __other.__isLoaded(PropId.byIndex(SLOT_BODY))) {
                    return false;
                }
                if (__bodyLoaded && !Objects.equals(__bodyValue, __other.body())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_POST_COMMENT)) != __other.__isVisible(PropId.byIndex(SLOT_POST_COMMENT))) {
                    return false;
                }
                boolean __postCommentLoaded = __postCommentValue != null;
                if (__postCommentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_POST_COMMENT))) {
                    return false;
                }
                if (__postCommentLoaded && !Objects.equals(__postCommentValue, __other.postComment())) {
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
                if (__isVisible(PropId.byIndex(SLOT_BODY)) != __other.__isVisible(PropId.byIndex(SLOT_BODY))) {
                    return false;
                }
                boolean __bodyLoaded = __bodyValue != null;
                if (__bodyLoaded != __other.__isLoaded(PropId.byIndex(SLOT_BODY))) {
                    return false;
                }
                if (__bodyLoaded && __bodyValue != __other.body()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_POST_COMMENT)) != __other.__isVisible(PropId.byIndex(SLOT_POST_COMMENT))) {
                    return false;
                }
                boolean __postCommentLoaded = __postCommentValue != null;
                if (__postCommentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_POST_COMMENT))) {
                    return false;
                }
                if (__postCommentLoaded && __postCommentValue != __other.postComment()) {
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
                type = CommentReply.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, CommentReplyDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private CommentReply __resolved;

            DraftImpl(DraftContext ctx, CommentReply base) {
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
            public CommentReplyDraft setId(long id) {
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
            public String body() {
                return (__modified!= null ? __modified : __base).body();
            }

            @Override
            public CommentReplyDraft setBody(String body) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (body == null) {
                    throw new IllegalArgumentException(
                        "'body' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__bodyValue = body;
                return this;
            }

            @Override
            @JsonIgnore
            public PostCommentDraft postComment() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).postComment());
            }

            @Override
            public PostCommentDraft postComment(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_POST_COMMENT)))) {
                    setPostComment(PostCommentDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).postComment());
            }

            @Override
            public CommentReplyDraft setPostComment(PostComment postComment) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (postComment == null) {
                    throw new IllegalArgumentException(
                        "'postComment' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__postCommentValue = postComment;
                return this;
            }

            @Override
            public long postCommentId() {
                return postComment().id();
            }

            @OldChain
            @Override
            public CommentReplyDraft setPostCommentId(long postCommentId) {
                postComment(true).setId(Objects.requireNonNull(postCommentId, "\"postComment\" cannot be null"));
                return this;
            }

            @Override
            public CommentReplyDraft applyPostComment(DraftConsumer<PostCommentDraft> block) {
                applyPostComment(null, block);
                return this;
            }

            @Override
            public CommentReplyDraft applyPostComment(PostComment base,
                    DraftConsumer<PostCommentDraft> block) {
                setPostComment(PostCommentDraft.$.produce(base, block));
                return this;
            }

            @Override
            @JsonIgnore
            public Instant createdAt() {
                return (__modified!= null ? __modified : __base).createdAt();
            }

            @Override
            public CommentReplyDraft setCreatedAt(Instant createdAt) {
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
                    case SLOT_BODY:
                    		setBody((String)value);break;
                    case SLOT_POST_COMMENT:
                    		setPostComment((PostComment)value);break;
                    case SLOT_CREATED_AT:
                    		setCreatedAt((Instant)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\"");
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
                    case "body":
                    		setBody((String)value);break;
                    case "postComment":
                    		setPostComment((PostComment)value);break;
                    case "createdAt":
                    		setCreatedAt((Instant)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\"");
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
                    __modified().__visibility = __visibility = Visibility.of(4);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_ID:
                    		__visibility.show(SLOT_ID, visible);break;
                    case SLOT_BODY:
                    		__visibility.show(SLOT_BODY, visible);break;
                    case SLOT_POST_COMMENT:
                    		__visibility.show(SLOT_POST_COMMENT, visible);break;
                    case SLOT_CREATED_AT:
                    		__visibility.show(SLOT_CREATED_AT, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + 
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
                    __modified().__visibility = __visibility = Visibility.of(4);
                }
                switch (prop) {
                    case "id":
                    		__visibility.show(SLOT_ID, visible);break;
                    case "body":
                    		__visibility.show(SLOT_BODY, visible);break;
                    case "postComment":
                    		__visibility.show(SLOT_POST_COMMENT, visible);break;
                    case "createdAt":
                    		__visibility.show(SLOT_CREATED_AT, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + 
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
                    case SLOT_BODY:
                    		__modified().__bodyValue = null;break;
                    case SLOT_POST_COMMENT:
                    		__modified().__postCommentValue = null;break;
                    case SLOT_CREATED_AT:
                    		__modified().__createdAtValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                    case "body":
                    		__modified().__bodyValue = null;break;
                    case "postComment":
                    		__modified().__postCommentValue = null;break;
                    case "createdAt":
                    		__modified().__createdAtValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.CommentReply\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                        if (base.__isLoaded(PropId.byIndex(SLOT_POST_COMMENT))) {
                            PostComment oldValue = base.postComment();
                            PostComment newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setPostComment(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__postCommentValue = __ctx.resolveObject(__tmpModified.__postCommentValue);
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
            type = CommentReply.class
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

        public Builder body(String body) {
            if (body != null) {
                __draft.setBody(body);
            }
            return this;
        }

        public Builder postComment(PostComment postComment) {
            if (postComment != null) {
                __draft.setPostComment(postComment);
            }
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            if (createdAt != null) {
                __draft.setCreatedAt(createdAt);
            }
            return this;
        }

        public CommentReply build() {
            return (CommentReply)__draft.__modified();
        }
    }
}
