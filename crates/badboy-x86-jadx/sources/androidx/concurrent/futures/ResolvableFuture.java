package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class ResolvableFuture<V>  extends androidx.concurrent.futures.AbstractResolvableFuture<V> {
    public static <V> androidx.concurrent.futures.ResolvableFuture<V> create() {
        ResolvableFuture resolvableFuture = new ResolvableFuture();
        return resolvableFuture;
    }

    public boolean set(V v) {
        return super.set(v);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
