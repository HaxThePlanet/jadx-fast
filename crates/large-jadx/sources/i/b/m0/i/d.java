package i.b.m0.i;

import i.b.m0.c.g;
import m.c.b;

/* loaded from: classes3.dex */
public enum d implements g<Object> {

    INSTANCE;
    public static void complete(b<?> b) {
        b.onSubscribe(d.INSTANCE);
        b.onComplete();
    }

    public static void error(Throwable throwable, b<?> b2) {
        b2.onSubscribe(d.INSTANCE);
        b2.onError(throwable);
    }

    @Override // java.lang.Enum
    public void cancel() {
    }

    @Override // java.lang.Enum
    public void clear() {
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
    public void request(long l) {
        g.validate(l);
    }

    @Override // java.lang.Enum
    public int requestFusion(int i) {
        return i &= 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
