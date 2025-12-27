package g.b;

import j.a.a;

/* compiled from: SingleCheck.java */
/* loaded from: classes2.dex */
public final class e<T> implements a<T> {

    private static final Object c = new Object();
    private volatile a<T> a;
    private volatile Object b;

    private e(a<T> aVar) {
        super();
        this.b = e.c;
        this.a = aVar;
    }

    public static <P extends a<T>, T> a<T> a(P p) {
        z = p instanceof e;
        if (!(p instanceof e)) {
            z = p instanceof a;
            d.b(p);
            return new e(p);
        }
        return p;
    }

    public T get() {
        Object obj;
        if (this.b == e.c && this.a == null) {
        }
        return obj;
    }
}
