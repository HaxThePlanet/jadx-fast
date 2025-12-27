package f.c.a.b.i.w.b;

/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public final class a<T> implements j.a.a<T>, f.c.a.b.i.w.a<T> {

    private static final Object c = new Object();
    private volatile j.a.a<T> a;
    private volatile Object b;

    private a(j.a.a<T> aVar) {
        super();
        this.b = a.c;
        this.a = aVar;
    }

    public static <P extends j.a.a<T>, T> f.c.a.b.i.w.a<T> a(P p) {
        if (p instanceof a) {
            return p;
        }
        d.b(p);
        return new a(p);
    }

    public static <P extends j.a.a<T>, T> j.a.a<T> b(P p) {
        d.b(p);
        if (p instanceof a) {
            return p;
        }
        return new a(p);
    }

    public static Object c(Object object, Object object2) {
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
                        a.c(this.b, obj);
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
