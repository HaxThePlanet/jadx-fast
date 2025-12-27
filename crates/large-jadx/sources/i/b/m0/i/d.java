package i.b.m0.i;

import i.b.m0.c.g;
import m.c.b;

/* compiled from: EmptySubscription.java */
/* loaded from: classes3.dex */
public enum d implements g<Object> {

    INSTANCE;
    public static void complete(b<?> bVar) {
        bVar.onSubscribe(d.INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, b<?> bVar) {
        bVar.onSubscribe(d.INSTANCE);
        bVar.onError(th);
    }

    @Override // java.lang.Enum
    public boolean offer(Object object) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // java.lang.Enum
    public void request(long j) {
        g.validate(j);
    }

    @Override // java.lang.Enum
    public boolean offer(Object object, Object object2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // java.lang.Enum
    public void cancel() {
    }

    @Override // java.lang.Enum
    public void clear() {
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

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
