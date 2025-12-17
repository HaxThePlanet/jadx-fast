package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.caches.SimpleArrayMap;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0008\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017JH\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0019\u001a\u001a\u0008\u0001\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001cJ+\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0086\u0008R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "", "()V", "PermanentFailure", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "Ljava/lang/Object;", "cacheLock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "permanentCache", "Landroidx/compose/ui/text/caches/SimpleArrayMap;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "get", "font", "Landroidx/compose/ui/text/font/Font;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "get-1ASDuI8", "put", "", "result", "forever", "", "runCached", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCachedBlocking", "Lkotlin/Function0;", "AsyncTypefaceResult", "Key", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncTypefaceCache {

    public static final int $stable = 8;
    private final Object PermanentFailure;
    private final SynchronizedObject cacheLock;
    private final SimpleArrayMap<androidx.compose.ui.text.font.AsyncTypefaceCache.Key, androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult> permanentCache;
    private final LruCache<androidx.compose.ui.text.font.AsyncTypefaceCache.Key, androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult> resultCache;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\u0088\u0001\u0002¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "", "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isPermanentFailure", "", "isPermanentFailure-impl", "(Ljava/lang/Object;)Z", "getResult", "()Ljava/lang/Object;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class AsyncTypefaceResult {

        private final Object result;
        private AsyncTypefaceResult(Object result) {
            super();
            this.result = result;
        }

        public static final androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult box-impl(Object object) {
            AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = new AsyncTypefaceCache.AsyncTypefaceResult(object);
            return asyncTypefaceResult;
        }

        public static Object constructor-impl(Object object) {
            return object;
        }

        public static boolean equals-impl(Object object, Object object2) {
            final int i2 = 0;
            if (object2 instanceof AsyncTypefaceCache.AsyncTypefaceResult == null) {
                return i2;
            }
            if (!Intrinsics.areEqual(object, (AsyncTypefaceCache.AsyncTypefaceResult)object2.unbox-impl())) {
                return i2;
            }
            return 1;
        }

        public static final boolean equals-impl0(Object object, Object object2) {
            return Intrinsics.areEqual(object, object2);
        }

        public static int hashCode-impl(Object object) {
            int i;
            if (object == null) {
                i = 0;
            } else {
                i = object.hashCode();
            }
            return i;
        }

        public static final boolean isPermanentFailure-impl(Object arg0) {
            int i;
            i = arg0 == null ? 1 : 0;
            return i;
        }

        public static String toString-impl(Object object) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("AsyncTypefaceResult(result=").append(object).append(')').toString();
        }

        public boolean equals(Object object) {
            return AsyncTypefaceCache.AsyncTypefaceResult.equals-impl(this.result, object);
        }

        public final Object getResult() {
            return this.result;
        }

        public int hashCode() {
            return AsyncTypefaceCache.AsyncTypefaceResult.hashCode-impl(this.result);
        }

        public String toString() {
            return AsyncTypefaceCache.AsyncTypefaceResult.toString-impl(this.result);
        }

        public final Object unbox-impl() {
            return this.result;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0014", d2 = {"Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "", "font", "Landroidx/compose/ui/text/font/Font;", "loaderKey", "(Landroidx/compose/ui/text/font/Font;Ljava/lang/Object;)V", "getFont", "()Landroidx/compose/ui/text/font/Font;", "getLoaderKey", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key {

        public static final int $stable = 8;
        private final androidx.compose.ui.text.font.Font font;
        private final Object loaderKey;
        static {
            final int i = 8;
        }

        public Key(androidx.compose.ui.text.font.Font font, Object loaderKey) {
            super();
            this.font = font;
            this.loaderKey = loaderKey;
        }

        public static androidx.compose.ui.text.font.AsyncTypefaceCache.Key copy$default(androidx.compose.ui.text.font.AsyncTypefaceCache.Key asyncTypefaceCache$Key, androidx.compose.ui.text.font.Font font2, Object object3, int i4, Object object5) {
            androidx.compose.ui.text.font.Font obj1;
            Object obj2;
            if (i4 & 1 != 0) {
                obj1 = key.font;
            }
            if (i4 &= 2 != 0) {
                obj2 = key.loaderKey;
            }
            return key.copy(obj1, obj2);
        }

        public final androidx.compose.ui.text.font.Font component1() {
            return this.font;
        }

        public final Object component2() {
            return this.loaderKey;
        }

        public final androidx.compose.ui.text.font.AsyncTypefaceCache.Key copy(androidx.compose.ui.text.font.Font font, Object object2) {
            AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, object2);
            return key;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AsyncTypefaceCache.Key) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.font, obj.font)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.loaderKey, obj.loaderKey)) {
                return i2;
            }
            return i;
        }

        public final androidx.compose.ui.text.font.Font getFont() {
            return this.font;
        }

        public final Object getLoaderKey() {
            return this.loaderKey;
        }

        public int hashCode() {
            int i;
            if (this.loaderKey == null) {
                i = 0;
            } else {
                i = this.loaderKey.hashCode();
            }
            return i3 += i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Key(font=").append(this.font).append(", loaderKey=").append(this.loaderKey).append(')').toString();
        }
    }
    static {
        final int i = 8;
    }

    public AsyncTypefaceCache() {
        super();
        int i = 0;
        this.PermanentFailure = AsyncTypefaceCache.AsyncTypefaceResult.constructor-impl(i);
        LruCache lruCache = new LruCache(16);
        this.resultCache = lruCache;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(0, 1, i);
        this.permanentCache = simpleArrayMap;
        this.cacheLock = Synchronization_jvmKt.createSynchronizedObject();
    }

    public static final SynchronizedObject access$getCacheLock$p(androidx.compose.ui.text.font.AsyncTypefaceCache $this) {
        return $this.cacheLock;
    }

    public static final SimpleArrayMap access$getPermanentCache$p(androidx.compose.ui.text.font.AsyncTypefaceCache $this) {
        return $this.permanentCache;
    }

    public static final LruCache access$getResultCache$p(androidx.compose.ui.text.font.AsyncTypefaceCache $this) {
        return $this.resultCache;
    }

    public static void put$default(androidx.compose.ui.text.font.AsyncTypefaceCache asyncTypefaceCache, androidx.compose.ui.text.font.Font font2, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader3, Object object4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        asyncTypefaceCache.put(font2, platformFontLoader3, object4, obj4);
    }

    public final androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult get-1ASDuI8(androidx.compose.ui.text.font.Font font, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader) {
        Object obj;
        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
        SynchronizedObject cacheLock = this.cacheLock;
        final int i = 0;
        final int i2 = 0;
        synchronized (cacheLock) {
            obj = this.permanentCache.get(key);
            return obj;
        }
    }

    public final void put(androidx.compose.ui.text.font.Font font, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, Object result, boolean forever) {
        Object obj;
        androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult box-impl;
        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
        SynchronizedObject cacheLock = this.cacheLock;
        final int i = 0;
        final int i2 = 0;
        synchronized (cacheLock) {
            obj = this.permanentCache.put(key, AsyncTypefaceCache.AsyncTypefaceResult.box-impl(this.PermanentFailure));
        }
    }

    public final Object runCached(androidx.compose.ui.text.font.Font font, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader2, boolean z3, Function1<? super Continuation<Object>, ? extends Object> function14, Continuation<Object> continuation5) {
        boolean anon;
        int i3;
        int i;
        Object obj2;
        int i2;
        Unit iNSTANCE;
        Object obj;
        androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult box-impl;
        Object obj8;
        Object obj9;
        boolean obj10;
        Object obj11;
        Object obj12;
        anon = continuation5;
        i = Integer.MIN_VALUE;
        if (continuation5 instanceof AsyncTypefaceCache.runCached.1 && label &= i != 0) {
            anon = continuation5;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj12 -= i;
            } else {
                anon = new AsyncTypefaceCache.runCached.1(this, continuation5);
            }
        } else {
        }
        obj12 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                obj2 = this;
                AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader2.getCacheKey());
                obj9 = key;
                obj8 = obj2.cacheLock;
                i2 = 0;
                int i5 = 0;
                obj = obj2.permanentCache.get(obj9);
                return obj.unbox-impl();
                iNSTANCE = Unit.INSTANCE;
                anon.L$0 = obj2;
                anon.L$1 = obj9;
                anon.Z$0 = z3;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj9 = anon.L$1;
                ResultKt.throwOnFailure(obj12);
                obj2 = obj10;
                obj10 = obj8;
                obj8 = obj12;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        obj11 = obj8;
        int i4 = 0;
        SynchronizedObject cacheLock = obj2.cacheLock;
        int i6 = 0;
        int i7 = 0;
        synchronized (cacheLock) {
            obj2.permanentCache.put(obj9, AsyncTypefaceCache.AsyncTypefaceResult.box-impl(obj2.PermanentFailure));
            obj9 = Unit.INSTANCE;
            return obj8;
        }
    }

    public final Object runCachedBlocking(androidx.compose.ui.text.font.Font font, androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader, Function0<? extends Object> block) {
        androidx.compose.ui.text.font.PlatformFontLoader platformFontLoader2;
        Object obj;
        final int i2 = 0;
        SynchronizedObject synchronizedObject = AsyncTypefaceCache.access$getCacheLock$p(this);
        int i3 = 0;
        int i = 0;
        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
        synchronized (synchronizedObject) {
            obj = AsyncTypefaceCache.access$getPermanentCache$p(this).get(key);
            if (obj != null) {
                return obj.unbox-impl();
            }
            Unit iNSTANCE = Unit.INSTANCE;
            Object invoke = block.invoke();
            final int i7 = 0;
            AsyncTypefaceCache.put$default(this, font, platformFontLoader, invoke, false, 8, 0);
            return invoke;
        }
    }
}
