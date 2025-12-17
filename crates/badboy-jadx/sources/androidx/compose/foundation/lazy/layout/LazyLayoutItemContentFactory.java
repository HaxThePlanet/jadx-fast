package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0001\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J0\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0002\u0008\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0008\u0012\u00060\u000cR\u00020\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function0;)V", "getItemProvider", "()Lkotlin/jvm/functions/Function0;", "lambdasCache", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "getContent", "", "Landroidx/compose/runtime/Composable;", "index", "", "key", "contentType", "(ILjava/lang/Object;Ljava/lang/Object;)Lkotlin/jvm/functions/Function2;", "getContentType", "CachedItemContent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutItemContentFactory {

    public static final int $stable = 8;
    private final Function0<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProvider;
    private final Map<Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent> lambdasCache;
    private final SaveableStateHolder saveableStateHolder;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\nH\u0002¢\u0006\u0002\u0010\u000eR\u001d\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008¢\u0006\u0002\u0008\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\n8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "", "index", "", "key", "contentType", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;ILjava/lang/Object;Ljava/lang/Object;)V", "_content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "getContentType", "()Ljava/lang/Object;", "<set-?>", "getIndex", "()I", "getKey", "createContentLambda", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class CachedItemContent {

        private Function2<? super Composer, ? super Integer, Unit> _content;
        private final Object contentType;
        private int index;
        private final Object key;
        final androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory this$0;
        public CachedItemContent(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory this$0, int index, Object key, Object contentType) {
            this.this$0 = this$0;
            super();
            this.key = key;
            this.contentType = contentType;
            this.index = index;
        }

        public static final void access$setIndex$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent $this, int <set-?>) {
            $this.index = <set-?>;
        }

        public static final void access$set_content$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent $this, Function2 <set-?>) {
            $this._content = <set-?>;
        }

        private final Function2<Composer, Integer, Unit> createContentLambda() {
            LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.1 anon = new LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.1(this.this$0, this);
            return (Function2)ComposableLambdaKt.composableLambdaInstance(1403994769, true, anon);
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            Function2 contentLambda;
            Function2 function2;
            int i;
            if (this._content == null) {
                i = 0;
                this._content = createContentLambda();
            }
            return contentLambda;
        }

        public final Object getContentType() {
            return this.contentType;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Object getKey() {
            return this.key;
        }
    }
    static {
        final int i = 8;
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProvider) {
        super();
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = itemProvider;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.lambdasCache = (Map)linkedHashMap;
    }

    public static final SaveableStateHolder access$getSaveableStateHolder$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory $this) {
        return $this.saveableStateHolder;
    }

    public final Function2<Composer, Integer, Unit> getContent(int index, Object key, Object contentType) {
        Function2 newContent;
        int index2;
        Function2 content;
        Object obj = this.lambdasCache.get(key);
        if (obj != null && (LazyLayoutItemContentFactory.CachedItemContent)obj.getIndex() == index && Intrinsics.areEqual(obj.getContentType(), contentType)) {
            if (obj.getIndex() == index) {
                if (Intrinsics.areEqual(obj.getContentType(), contentType)) {
                    newContent = obj.getContent();
                } else {
                    LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = new LazyLayoutItemContentFactory.CachedItemContent(this, index, key, contentType);
                    this.lambdasCache.put(key, cachedItemContent);
                    newContent = content;
                }
            } else {
            }
        } else {
        }
        return newContent;
    }

    public final Object getContentType(Object key) {
        Object contentType;
        Object invoke;
        int index;
        int i;
        if (key == null) {
            return null;
        }
        Object obj = this.lambdasCache.get(key);
        if ((LazyLayoutItemContentFactory.CachedItemContent)obj != null) {
            contentType = (LazyLayoutItemContentFactory.CachedItemContent)obj.getContentType();
        } else {
            invoke = this.itemProvider.invoke();
            index = (LazyLayoutItemProvider)invoke.getIndex(key);
            if (index != -1) {
                contentType = invoke.getContentType(index);
            } else {
            }
        }
        return contentType;
    }

    public final Function0<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> getItemProvider() {
        return this.itemProvider;
    }
}
