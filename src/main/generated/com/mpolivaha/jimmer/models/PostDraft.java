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
import org.babyfish.jimmer.sql.OneToMany;

@GeneratedBy(
        type = Post.class
)
public interface PostDraft extends Post, Draft {
    PostDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    PostDraft setId(long id);

    @OldChain
    PostDraft setTitle(String title);

    @OldChain
    PostDraft setContent(String content);

    @OldChain
    PostDraft setCreatedAt(Instant createdAt);

    List<PostCommentDraft> comments(boolean autoCreate);

    @OldChain
    PostDraft setComments(List<PostComment> comments);

    @OldChain
    PostDraft addIntoComments(DraftConsumer<PostCommentDraft> block);

    @OldChain
    PostDraft addIntoComments(PostComment base, DraftConsumer<PostCommentDraft> block);

    @GeneratedBy(
            type = Post.class
    )
    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ID = 0;

        public static final int SLOT_TITLE = 1;

        public static final int SLOT_CONTENT = 2;

        public static final int SLOT_CREATED_AT = 3;

        public static final int SLOT_COMMENTS = 4;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.9.37",
                Post.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (Post)base)
            )
            .id(SLOT_ID, "id", long.class)
            .add(SLOT_TITLE, "title", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_CONTENT, "content", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_CREATED_AT, "createdAt", ImmutablePropCategory.SCALAR, Instant.class, false)
            .add(SLOT_COMMENTS, "comments", OneToMany.class, PostComment.class, false)
            .build();

        private Producer() {
        }

        public Post produce(DraftConsumer<PostDraft> block) {
            return produce(null, block);
        }

        public Post produce(Post base, DraftConsumer<PostDraft> block) {
            return (Post)Internal.produce(TYPE, base, block);
        }

        /**
         * Class, not interface, for free-marker
         */
        @GeneratedBy(
                type = Post.class
        )
        @JsonPropertyOrder({"dummyPropForJacksonError__", "id", "title", "content", "createdAt", "comments"})
        public abstract static class Implementor implements Post, ImmutableSpi {
            @Override
            public final Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_ID:
                    		return (Long)id();
                    case SLOT_TITLE:
                    		return title();
                    case SLOT_CONTENT:
                    		return content();
                    case SLOT_CREATED_AT:
                    		return createdAt();
                    case SLOT_COMMENTS:
                    		return comments();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\"");
                }
            }

            @Override
            public final Object __get(String prop) {
                switch (prop) {
                    case "id":
                    		return (Long)id();
                    case "title":
                    		return title();
                    case "content":
                    		return content();
                    case "createdAt":
                    		return createdAt();
                    case "comments":
                    		return comments();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\"");
                }
            }

            public final long getId() {
                return id();
            }

            public final String getTitle() {
                return title();
            }

            public final String getContent() {
                return content();
            }

            public final Instant getCreatedAt() {
                return createdAt();
            }

            public final List<PostComment> getComments() {
                return comments();
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
                type = Post.class
        )
        private static class Impl extends Implementor implements Cloneable, Serializable {
            private Visibility __visibility;

            long __idValue;

            boolean __idLoaded = false;

            String __titleValue;

            String __contentValue;

            Instant __createdAtValue;

            NonSharedList<PostComment> __commentsValue;

            @Override
            @JsonIgnore
            public long id() {
                if (!__idLoaded) {
                    throw new UnloadedException(Post.class, "id");
                }
                return __idValue;
            }

            @Override
            @JsonIgnore
            public String title() {
                if (__titleValue == null) {
                    throw new UnloadedException(Post.class, "title");
                }
                return __titleValue;
            }

            @Override
            @JsonIgnore
            public String content() {
                if (__contentValue == null) {
                    throw new UnloadedException(Post.class, "content");
                }
                return __contentValue;
            }

            @Override
            @JsonIgnore
            public Instant createdAt() {
                if (__createdAtValue == null) {
                    throw new UnloadedException(Post.class, "createdAt");
                }
                return __createdAtValue;
            }

            @Override
            @JsonIgnore
            public List<PostComment> comments() {
                if (__commentsValue == null) {
                    throw new UnloadedException(Post.class, "comments");
                }
                return __commentsValue;
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
                    case SLOT_TITLE:
                    		return __titleValue != null;
                    case SLOT_CONTENT:
                    		return __contentValue != null;
                    case SLOT_CREATED_AT:
                    		return __createdAtValue != null;
                    case SLOT_COMMENTS:
                    		return __commentsValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "id":
                    		return __idLoaded;
                    case "title":
                    		return __titleValue != null;
                    case "content":
                    		return __contentValue != null;
                    case "createdAt":
                    		return __createdAtValue != null;
                    case "comments":
                    		return __commentsValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\"");
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
                    case SLOT_TITLE:
                    		return __visibility.visible(SLOT_TITLE);
                    case SLOT_CONTENT:
                    		return __visibility.visible(SLOT_CONTENT);
                    case SLOT_CREATED_AT:
                    		return __visibility.visible(SLOT_CREATED_AT);
                    case SLOT_COMMENTS:
                    		return __visibility.visible(SLOT_COMMENTS);
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
                    case "title":
                    		return __visibility.visible(SLOT_TITLE);
                    case "content":
                    		return __visibility.visible(SLOT_CONTENT);
                    case "createdAt":
                    		return __visibility.visible(SLOT_CREATED_AT);
                    case "comments":
                    		return __visibility.visible(SLOT_COMMENTS);
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
                if (__titleValue != null) {
                    hash = 31 * hash + __titleValue.hashCode();
                }
                if (__contentValue != null) {
                    hash = 31 * hash + __contentValue.hashCode();
                }
                if (__createdAtValue != null) {
                    hash = 31 * hash + __createdAtValue.hashCode();
                }
                if (__commentsValue != null) {
                    hash = 31 * hash + __commentsValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__idLoaded) {
                    hash = 31 * hash + Long.hashCode(__idValue);
                }
                if (__titleValue != null) {
                    hash = 31 * hash + System.identityHashCode(__titleValue);
                }
                if (__contentValue != null) {
                    hash = 31 * hash + System.identityHashCode(__contentValue);
                }
                if (__createdAtValue != null) {
                    hash = 31 * hash + System.identityHashCode(__createdAtValue);
                }
                if (__commentsValue != null) {
                    hash = 31 * hash + System.identityHashCode(__commentsValue);
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
                if (__isVisible(PropId.byIndex(SLOT_TITLE)) != __other.__isVisible(PropId.byIndex(SLOT_TITLE))) {
                    return false;
                }
                boolean __titleLoaded = __titleValue != null;
                if (__titleLoaded != __other.__isLoaded(PropId.byIndex(SLOT_TITLE))) {
                    return false;
                }
                if (__titleLoaded && !Objects.equals(__titleValue, __other.title())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CONTENT)) != __other.__isVisible(PropId.byIndex(SLOT_CONTENT))) {
                    return false;
                }
                boolean __contentLoaded = __contentValue != null;
                if (__contentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CONTENT))) {
                    return false;
                }
                if (__contentLoaded && !Objects.equals(__contentValue, __other.content())) {
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
                if (__isVisible(PropId.byIndex(SLOT_COMMENTS)) != __other.__isVisible(PropId.byIndex(SLOT_COMMENTS))) {
                    return false;
                }
                boolean __commentsLoaded = __commentsValue != null;
                if (__commentsLoaded != __other.__isLoaded(PropId.byIndex(SLOT_COMMENTS))) {
                    return false;
                }
                if (__commentsLoaded && !Objects.equals(__commentsValue, __other.comments())) {
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
                if (__isVisible(PropId.byIndex(SLOT_TITLE)) != __other.__isVisible(PropId.byIndex(SLOT_TITLE))) {
                    return false;
                }
                boolean __titleLoaded = __titleValue != null;
                if (__titleLoaded != __other.__isLoaded(PropId.byIndex(SLOT_TITLE))) {
                    return false;
                }
                if (__titleLoaded && __titleValue != __other.title()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CONTENT)) != __other.__isVisible(PropId.byIndex(SLOT_CONTENT))) {
                    return false;
                }
                boolean __contentLoaded = __contentValue != null;
                if (__contentLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CONTENT))) {
                    return false;
                }
                if (__contentLoaded && __contentValue != __other.content()) {
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
                if (__isVisible(PropId.byIndex(SLOT_COMMENTS)) != __other.__isVisible(PropId.byIndex(SLOT_COMMENTS))) {
                    return false;
                }
                boolean __commentsLoaded = __commentsValue != null;
                if (__commentsLoaded != __other.__isLoaded(PropId.byIndex(SLOT_COMMENTS))) {
                    return false;
                }
                if (__commentsLoaded && __commentsValue != __other.comments()) {
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
                type = Post.class
        )
        private static class DraftImpl extends Implementor implements DraftSpi, PostDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            private Post __resolved;

            DraftImpl(DraftContext ctx, Post base) {
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
            public PostDraft setId(long id) {
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
            public String title() {
                return (__modified!= null ? __modified : __base).title();
            }

            @Override
            public PostDraft setTitle(String title) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (title == null) {
                    throw new IllegalArgumentException(
                        "'title' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__titleValue = title;
                return this;
            }

            @Override
            @JsonIgnore
            public String content() {
                return (__modified!= null ? __modified : __base).content();
            }

            @Override
            public PostDraft setContent(String content) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (content == null) {
                    throw new IllegalArgumentException(
                        "'content' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__contentValue = content;
                return this;
            }

            @Override
            @JsonIgnore
            public Instant createdAt() {
                return (__modified!= null ? __modified : __base).createdAt();
            }

            @Override
            public PostDraft setCreatedAt(Instant createdAt) {
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
            public List<PostComment> comments() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).comments(), PostComment.class, true);
            }

            @Override
            public List<PostCommentDraft> comments(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_COMMENTS)))) {
                    setComments(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).comments(), PostComment.class, true);
            }

            @Override
            public PostDraft setComments(List<PostComment> comments) {
                if (__resolved != null) {
                    throw new IllegalStateException("The current draft has been resolved so it cannot be modified");
                }
                if (comments == null) {
                    throw new IllegalArgumentException(
                        "'comments' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__commentsValue = NonSharedList.of(__tmpModified.__commentsValue, comments);
                return this;
            }

            @Override
            public PostDraft addIntoComments(DraftConsumer<PostCommentDraft> block) {
                addIntoComments(null, block);
                return this;
            }

            @Override
            public PostDraft addIntoComments(PostComment base,
                    DraftConsumer<PostCommentDraft> block) {
                comments(true).add((PostCommentDraft)PostCommentDraft.$.produce(base, block));
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
                    case SLOT_TITLE:
                    		setTitle((String)value);break;
                    case SLOT_CONTENT:
                    		setContent((String)value);break;
                    case SLOT_CREATED_AT:
                    		setCreatedAt((Instant)value);break;
                    case SLOT_COMMENTS:
                    		setComments((List<PostComment>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\"");
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
                    case "title":
                    		setTitle((String)value);break;
                    case "content":
                    		setContent((String)value);break;
                    case "createdAt":
                    		setCreatedAt((Instant)value);break;
                    case "comments":
                    		setComments((List<PostComment>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\"");
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
                    case SLOT_TITLE:
                    		__visibility.show(SLOT_TITLE, visible);break;
                    case SLOT_CONTENT:
                    		__visibility.show(SLOT_CONTENT, visible);break;
                    case SLOT_CREATED_AT:
                    		__visibility.show(SLOT_CREATED_AT, visible);break;
                    case SLOT_COMMENTS:
                    		__visibility.show(SLOT_COMMENTS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.mpolivaha.jimmer.models.Post\": \"" + 
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
                    case "title":
                    		__visibility.show(SLOT_TITLE, visible);break;
                    case "content":
                    		__visibility.show(SLOT_CONTENT, visible);break;
                    case "createdAt":
                    		__visibility.show(SLOT_CREATED_AT, visible);break;
                    case "comments":
                    		__visibility.show(SLOT_COMMENTS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + 
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
                    case SLOT_TITLE:
                    		__modified().__titleValue = null;break;
                    case SLOT_CONTENT:
                    		__modified().__contentValue = null;break;
                    case SLOT_CREATED_AT:
                    		__modified().__createdAtValue = null;break;
                    case SLOT_COMMENTS:
                    		__modified().__commentsValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                    case "title":
                    		__modified().__titleValue = null;break;
                    case "content":
                    		__modified().__contentValue = null;break;
                    case "createdAt":
                    		__modified().__createdAtValue = null;break;
                    case "comments":
                    		__modified().__commentsValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.mpolivaha.jimmer.models.Post\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                        if (base.__isLoaded(PropId.byIndex(SLOT_COMMENTS))) {
                            List<PostComment> oldValue = base.comments();
                            List<PostComment> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setComments(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__commentsValue = NonSharedList.of(__tmpModified.__commentsValue, __ctx.resolveList(__tmpModified.__commentsValue));
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
            type = Post.class
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

        public Builder title(String title) {
            if (title != null) {
                __draft.setTitle(title);
            }
            return this;
        }

        public Builder content(String content) {
            if (content != null) {
                __draft.setContent(content);
            }
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            if (createdAt != null) {
                __draft.setCreatedAt(createdAt);
            }
            return this;
        }

        public Builder comments(List<PostComment> comments) {
            if (comments != null) {
                __draft.setComments(comments);
            }
            return this;
        }

        public Post build() {
            return (Post)__draft.__modified();
        }
    }
}
