package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0011J(\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0017J4\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u0010\u001a\u00020\t2\u001e\u0010\u0016\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0017\u0012\u0004\u0012\u00020\n0\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u000c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text_release", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "size", "", "getSize$ui_text_release", "()I", "get", "typefaceRequest", "get$ui_text_release", "preWarmCache", "", "typefaceRequests", "", "resolveTypeface", "Lkotlin/Function1;", "runCached", "Landroidx/compose/runtime/State;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TypefaceRequestCache {

    public static final int $stable = 8;
    private final SynchronizedObject lock;
    private final LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> resultCache;
    static {
        final int i = 8;
    }

    public TypefaceRequestCache() {
        super();
        this.lock = Synchronization_jvmKt.createSynchronizedObject();
        LruCache lruCache = new LruCache(16);
        this.resultCache = lruCache;
    }

    public static final LruCache access$getResultCache$p(androidx.compose.ui.text.font.TypefaceRequestCache $this) {
        return $this.resultCache;
    }

    public final androidx.compose.ui.text.font.TypefaceResult get$ui_text_release(androidx.compose.ui.text.font.TypefaceRequest typefaceRequest) {
        final SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        return (TypefaceResult)this.resultCache.get(typefaceRequest);
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            return (TypefaceResult)this.resultCache.get(typefaceRequest);
        }
    }

    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    public final int getSize$ui_text_release() {
        final SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        return this.resultCache.size();
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            return this.resultCache.size();
        }
    }

    public final void preWarmCache(List<androidx.compose.ui.text.font.TypefaceRequest> typefaceRequests, Function1<? super androidx.compose.ui.text.font.TypefaceRequest, ? extends androidx.compose.ui.text.font.TypefaceResult> resolveTypeface) {
        int i;
        Object obj2;
        Object illegalStateException;
        String lock;
        Throwable th;
        Object obj3;
        int i2;
        Object obj;
        i = 0;
        while (i < typefaceRequests.size()) {
            obj2 = typefaceRequests.get(i);
            illegalStateException = this.lock;
            lock = 0;
            th = 0;
            illegalStateException = resolveTypeface.invoke(obj2);
            if ((TypefaceResult)this.resultCache.get((TypefaceRequest)obj2) == null && !illegalStateException instanceof TypefaceResult.Async) {
            }
            i++;
            illegalStateException = resolveTypeface.invoke(obj2);
            if (!illegalStateException instanceof TypefaceResult.Async) {
            }
            lock = this.lock;
            th = 0;
            i2 = 0;
            obj = this.resultCache.put(obj2, (TypefaceResult)(TypefaceResult)illegalStateException);
        }
    }

    public final State<Object> runCached(androidx.compose.ui.text.font.TypefaceRequest typefaceRequest, Function1<? super Function1<? super androidx.compose.ui.text.font.TypefaceResult, Unit>, ? extends androidx.compose.ui.text.font.TypefaceResult> resolveTypeface) {
        int i;
        Object resultCache;
        Object remove;
        SynchronizedObject lock = this.lock;
        int i2 = 0;
        int i3 = 0;
        Object obj = this.resultCache.get(typefaceRequest);
        synchronized (lock) {
            i = 0;
            if ((TypefaceResult)obj.getCacheable()) {
                return (State)obj;
            }
            remove = this.resultCache.remove(typefaceRequest);
            TypefaceRequestCache.runCached.currentTypefaceResult.1 anon = new TypefaceRequestCache.runCached.currentTypefaceResult.1(this, typefaceRequest);
            Object invoke = resolveTypeface.invoke(anon);
            SynchronizedObject lock2 = this.lock;
            int i4 = 0;
            int i5 = 0;
            synchronized (lock2) {
                anon = new TypefaceRequestCache.runCached.currentTypefaceResult.1(this, typefaceRequest);
                invoke = resolveTypeface.invoke(anon);
                lock2 = this.lock;
                i4 = 0;
                i5 = 0;
            }
        }
        try {
            if ((TypefaceResult)(TypefaceResult)invoke.getCacheable()) {
            }
            this.resultCache.put(typefaceRequest, invoke);
            Unit $i$a$SynchronizedTypefaceRequestCache$runCached$2 = Unit.INSTANCE;
            return (State)invoke;
            throw th;
            String str = "Could not load font";
            Throwable th = currentTypefaceResult;
            IllegalStateException illegalStateException = new IllegalStateException(str, (Throwable)th);
            throw illegalStateException;
            throw str;
        } catch (Exception e) {
        }
    }
}
