package f.c.a.b;

/* compiled from: Event.java */
/* loaded from: classes.dex */
public abstract class c<T> {
    public static <T> c<T> d(T t) {
        return new a(null, t, d.DEFAULT);
    }

    public static <T> c<T> e(T t) {
        return new a(null, t, d.VERY_LOW);
    }

    public static <T> c<T> f(T t) {
        return new a(null, t, d.HIGHEST);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract d c();
}
