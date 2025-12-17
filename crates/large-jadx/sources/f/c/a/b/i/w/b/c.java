package f.c.a.b.i.w.b;

import f.c.a.b.i.w.a;

/* loaded from: classes.dex */
public final class c<T>  implements f.c.a.b.i.w.b.b<T>, a<T> {

    private final T a;
    static {
    }

    private c(T t) {
        super();
        this.a = t;
    }

    public static <T> f.c.a.b.i.w.b.b<T> a(T t) {
        d.c(t, "instance cannot be null");
        c cVar = new c(t);
        return cVar;
    }

    public T get() {
        return this.a;
    }
}
