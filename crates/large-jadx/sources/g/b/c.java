package g.b;

/* loaded from: classes2.dex */
public final class c<T>  implements g.b.b<T> {

    private final T a;
    static {
    }

    private c(T t) {
        super();
        this.a = t;
    }

    public static <T> g.b.b<T> a(T t) {
        d.c(t, "instance cannot be null");
        c cVar = new c(t);
        return cVar;
    }

    public T get() {
        return this.a;
    }
}
