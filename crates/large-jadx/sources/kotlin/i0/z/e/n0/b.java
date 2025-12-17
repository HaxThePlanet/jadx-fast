package kotlin.i0.z.e.n0;

/* loaded from: classes3.dex */
public final class b<K, V>  {

    private static final kotlin.i0.z.e.n0.b<Object, Object> c;
    private final kotlin.i0.z.e.n0.d<kotlin.i0.z.e.n0.a<kotlin.i0.z.e.n0.e<K, V>>> a;
    private final int b;
    static {
        b bVar = new b(d.a(), 0);
        b.c = bVar;
    }

    private b(kotlin.i0.z.e.n0.d<kotlin.i0.z.e.n0.a<kotlin.i0.z.e.n0.e<K, V>>> d, int i2) {
        super();
        this.a = d;
        this.b = i2;
    }

    private static void a(int i) {
        String obj3;
        Object[] arr = new Object[2];
        int i4 = 1;
        if (i != i4) {
            arr[i4] = "empty";
        } else {
            arr[i4] = "minus";
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", arr));
        throw illegalStateException;
    }

    public static <K, V> kotlin.i0.z.e.n0.b<K, V> b() {
        kotlin.i0.z.e.n0.b bVar = b.c;
        if (bVar == null) {
        } else {
            return bVar;
        }
        b.a(0);
        throw 0;
    }

    private kotlin.i0.z.e.n0.a<kotlin.i0.z.e.n0.e<K, V>> d(int i) {
        Object obj2;
        if ((a)this.a.b(i) == null) {
            obj2 = a.d();
        }
        return obj2;
    }

    private static <K, V> int e(kotlin.i0.z.e.n0.a<kotlin.i0.z.e.n0.e<K, V>> a, Object object2) {
        int i;
        boolean equals;
        Object obj2;
        i = 0;
        while (obj2 != null) {
            obj2 = obj2.b;
            i++;
        }
        return -1;
    }

    public V c(Object object) {
        kotlin.i0.z.e.n0.a aVar;
        Object size;
        boolean equals;
        aVar = d(object.hashCode());
        while (aVar != null) {
            size = aVar.a;
            aVar = aVar.b;
        }
        return 0;
    }

    public kotlin.i0.z.e.n0.b<K, V> f(K k, V v2) {
        kotlin.i0.z.e.n0.a aVar;
        aVar = d(k.hashCode());
        int i2 = b.e(aVar, k);
        if (i2 != -1) {
            aVar = aVar.h(i2);
        }
        e eVar = new e(k, v2);
        kotlin.i0.z.e.n0.a obj6 = aVar.l(eVar);
        b bVar = new b(this.a.c(k.hashCode(), obj6), i4 += obj6);
        return bVar;
    }
}
