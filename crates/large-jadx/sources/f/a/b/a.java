package f.a.b;

/* loaded from: classes.dex */
public class a<T>  implements f.a.b.b<T> {

    private static final Object c;
    private volatile f.a.b.b<T> a;
    private volatile Object b;
    static {
        Object object = new Object();
        a.c = object;
    }

    private a(f.a.b.b<T> b) {
        super();
        this.b = a.c;
        this.a = b;
    }

    public static <P extends f.a.b.b<T>, T> f.a.b.b<T> a(P p) {
        if (p == null) {
        } else {
            if (p instanceof a) {
                return p;
            }
            a aVar = new a(p);
            return aVar;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("delegate cannot be null");
        throw obj1;
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
        Object obj2;
        Object obj;
        obj = a.c;
        if (this.b == obj && this.b == obj) {
            synchronized (this) {
                obj2 = this.a.get();
                a.b(this.b, obj2);
                this.b = obj2;
                this.a = 0;
            }
        }
        return obj2;
    }
}
