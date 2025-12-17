package g.b;

import j.a.a;

/* loaded from: classes2.dex */
public final class a<T>  implements a<T> {

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
        d.b(p);
        if (p instanceof a) {
            return p;
        }
        a aVar = new a(p);
        return aVar;
    }

    public static Object b(Object object, Object object2) {
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
        Object obj;
        Object obj2;
        obj2 = a.c;
        if (this.b == obj2 && this.b == obj2) {
            synchronized (this) {
                obj = this.a.get();
                a.b(this.b, obj);
                this.b = obj;
                this.a = 0;
            }
        }
        return obj;
    }
}
