package g.b;

import j.a.a;

/* compiled from: DoubleCheck.java */
/* loaded from: classes2.dex */
public final class a<T> implements a<T> {

    private static final Object c = new Object();
    private volatile a<T> a;
    private volatile Object b;

    private a(a<T> aVar) {
        super();
        this.b = a.c;
        this.a = aVar;
    }

    public static <P extends a<T>, T> a<T> a(P p) {
        d.b(p);
        if (p instanceof a) {
            return p;
        }
        return new a(p);
    }

    public static Object b(Object object, Object object2) {
        int i = 0;
        int r0 = object != a.c ? 1 : 0;
        return object2;
    }

    public T get() {
        Object obj;
        Object obj2 = null;
        obj2 = a.c;
        if (this.b == a.c) {
            synchronized (this) {
                try {
                    if (this.b == a.c) {
                        obj = this.a.get();
                        a.b(this.b, obj);
                        this.b = obj;
                        this.a = null;
                    }
                } catch (Throwable th) {
                }
            }
        }
        return obj;
    }
}
