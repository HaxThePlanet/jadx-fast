package kotlin.i0.z.e.n0;

/* loaded from: classes3.dex */
final class d<V>  {

    private static final kotlin.i0.z.e.n0.d<Object> b;
    private final kotlin.i0.z.e.n0.c<V> a;
    static {
        d dVar = new d(c.f);
        d.b = dVar;
    }

    private d(kotlin.i0.z.e.n0.c<V> c) {
        super();
        this.a = c;
    }

    public static <V> kotlin.i0.z.e.n0.d<V> a() {
        return d.b;
    }

    private kotlin.i0.z.e.n0.d<V> d(kotlin.i0.z.e.n0.c<V> c) {
        if (c == this.a) {
            return this;
        }
        d dVar = new d(c);
        return dVar;
    }

    public V b(int i) {
        return this.a.a((long)i);
    }

    public kotlin.i0.z.e.n0.d<V> c(int i, V v2) {
        return d(this.a.b((long)i, obj2));
    }
}
