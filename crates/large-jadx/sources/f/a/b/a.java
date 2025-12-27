package f.a.b;

/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public class a<T> implements b<T> {

    private static final Object c = new Object();
    private volatile b<T> a;
    private volatile Object b;

    private a(b<T> bVar) {
        super();
        this.b = a.c;
        this.a = bVar;
    }

    public static <P extends b<T>, T> b<T> a(P p) {
        if (p == null) {
            throw new IllegalArgumentException("delegate cannot be null");
        } else {
            if (p instanceof a) {
                return p;
            }
            return new a(p);
        }
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
