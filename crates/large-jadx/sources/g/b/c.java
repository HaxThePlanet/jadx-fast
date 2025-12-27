package g.b;

/* compiled from: InstanceFactory.java */
/* loaded from: classes2.dex */
public final class c<T> implements b<T> {

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
