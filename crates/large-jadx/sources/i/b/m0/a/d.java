package i.b.m0.a;

import i.b.d;
import i.b.d0;
import i.b.m0.c.e;
import i.b.n;
import i.b.y;

/* compiled from: EmptyDisposable.java */
/* loaded from: classes3.dex */
public enum d implements e<Object> {

    INSTANCE,
    NEVER;
    public static void complete(y<?> yVar) {
        yVar.onSubscribe(d.INSTANCE);
        yVar.onComplete();
    }

    public static void error(Throwable th, y<?> yVar) {
        yVar.onSubscribe(d.INSTANCE);
        yVar.onError(th);
    }

    @Override // java.lang.Enum
    public boolean isDisposed() {
        boolean z = true;
        int r0 = this == d.INSTANCE ? 1 : 0;
        return (this == d.INSTANCE ? 1 : 0);
    }

    @Override // java.lang.Enum
    public boolean offer(Object object) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // java.lang.Enum
    public boolean offer(Object object, Object object2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(n<?> nVar) {
        nVar.onSubscribe(d.INSTANCE);
        nVar.onComplete();
    }

    public static void error(Throwable th, d dVar) {
        dVar.onSubscribe(d.INSTANCE);
        dVar.onError(th);
    }

    public static void complete(d dVar) {
        dVar.onSubscribe(d.INSTANCE);
        dVar.onComplete();
    }

    public static void error(Throwable th, d0<?> d0Var) {
        d0Var.onSubscribe(d.INSTANCE);
        d0Var.onError(th);
    }

    public static void error(Throwable th, n<?> nVar) {
        nVar.onSubscribe(d.INSTANCE);
        nVar.onError(th);
    }

    @Override // java.lang.Enum
    public void clear() {
    }

    @Override // java.lang.Enum
    public void dispose() {
    }

    @Override // java.lang.Enum
    public boolean isEmpty() {
        return true;
    }

    @Override // java.lang.Enum
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public int requestFusion(int i) {
        return i & 2;
    }
}
