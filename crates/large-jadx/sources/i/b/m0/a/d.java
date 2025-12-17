package i.b.m0.a;

import i.b.d;
import i.b.d0;
import i.b.m0.c.e;
import i.b.n;
import i.b.y;

/* loaded from: classes3.dex */
public enum d implements e<Object> {

    INSTANCE,
    NEVER;
    public static void complete(d d) {
        d.onSubscribe(d.INSTANCE);
        d.onComplete();
    }

    public static void complete(n<?> n) {
        n.onSubscribe(d.INSTANCE);
        n.onComplete();
    }

    public static void complete(y<?> y) {
        y.onSubscribe(d.INSTANCE);
        y.onComplete();
    }

    public static void error(Throwable throwable, d0<?> d02) {
        d02.onSubscribe(d.INSTANCE);
        d02.onError(throwable);
    }

    public static void error(Throwable throwable, d d2) {
        d2.onSubscribe(d.INSTANCE);
        d2.onError(throwable);
    }

    public static void error(Throwable throwable, n<?> n2) {
        n2.onSubscribe(d.INSTANCE);
        n2.onError(throwable);
    }

    public static void error(Throwable throwable, y<?> y2) {
        y2.onSubscribe(d.INSTANCE);
        y2.onError(throwable);
    }

    @Override // java.lang.Enum
    public void clear() {
    }

    @Override // java.lang.Enum
    public void dispose() {
    }

    @Override // java.lang.Enum
    public boolean isDisposed() {
        int i;
        i = this == d.INSTANCE ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean isEmpty() {
        return 1;
    }

    @Override // java.lang.Enum
    public boolean offer(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called!");
        throw obj2;
    }

    @Override // java.lang.Enum
    public boolean offer(Object object, Object object2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Should not be called!");
        throw obj1;
    }

    @Override // java.lang.Enum
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public int requestFusion(int i) {
        return i &= 2;
    }
}
