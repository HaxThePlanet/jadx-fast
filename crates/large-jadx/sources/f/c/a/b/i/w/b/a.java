package f.c.a.b.i.w.b;

import f.c.a.b.i.w.a;
import j.a.a;

/* loaded from: classes.dex */
public final class a<T>  implements a<T>, a<T> {

    private static final Object c;
    private volatile a<T> a;
    private volatile Object b;
    static {
        Object object = new Object();
        a.c = object;
    }

    private a(a<T> a) {
        super();
        this.b = a.c;
        this.a = a;
    }

    public static <P extends a<T>, T> a<T> a(P p) {
        if (p instanceof a) {
            return (a)p;
        }
        d.b(p);
        a aVar = new a((a)p);
        return aVar;
    }

    public static <P extends a<T>, T> a<T> b(P p) {
        d.b(p);
        if (p instanceof a) {
            return p;
        }
        a aVar = new a(p);
        return aVar;
    }

    public static Object c(Object object, Object object2) {
        int i;
        i = object != a.c ? 1 : 0;
        if (i != 0) {
            if (object != object2) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scoped provider was invoked recursively returning different results: ");
            stringBuilder.append(object);
            stringBuilder.append(" & ");
            stringBuilder.append(object2);
            stringBuilder.append(". This is likely due to a circular dependency.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        return object2;
    }

    public T get() {
        Object obj2;
        Object obj;
        obj = a.c;
        if (this.b == obj && this.b == obj) {
            synchronized (this) {
                obj2 = this.a.get();
                a.c(this.b, obj2);
                this.b = obj2;
                this.a = 0;
            }
        }
        return obj2;
    }
}
