package f.c.a.b;

/* loaded from: classes.dex */
public abstract class c<T>  {
    public static <T> f.c.a.b.c<T> d(T t) {
        a aVar = new a(0, t, d.DEFAULT);
        return aVar;
    }

    public static <T> f.c.a.b.c<T> e(T t) {
        a aVar = new a(0, t, d.VERY_LOW);
        return aVar;
    }

    public static <T> f.c.a.b.c<T> f(T t) {
        a aVar = new a(0, t, d.HIGHEST);
        return aVar;
    }

    public abstract Integer a();

    public abstract T b();

    public abstract f.c.a.b.d c();
}
