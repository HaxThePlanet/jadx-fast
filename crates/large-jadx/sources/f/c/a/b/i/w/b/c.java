package f.c.a.b.i.w.b;

import f.c.a.b.i.w.a;

/* compiled from: InstanceFactory.java */
/* loaded from: classes.dex */
public final class c<T> implements b<T>, a<T> {

    private final T a;
    private c(T t) {
        super();
        this.a = t;
    }

    public static <T> b<T> a(T t) {
        d.c(t, "instance cannot be null");
        return new c(t);
    }

    public T get() {
        return this.a;
    }

}
