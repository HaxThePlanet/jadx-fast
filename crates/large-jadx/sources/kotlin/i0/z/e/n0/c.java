package kotlin.i0.z.e.n0;

/* loaded from: classes3.dex */
final class c<V>  {

    static final kotlin.i0.z.e.n0.c<Object> f;
    private final long a;
    private final V b;
    private final kotlin.i0.z.e.n0.c<V> c;
    private final kotlin.i0.z.e.n0.c<V> d;
    private final int e;
    static {
        c cVar = new c();
        c.f = cVar;
    }

    private c() {
        super();
        this.e = 0;
        this.a = 0;
        int i3 = 0;
        this.b = i3;
        this.c = i3;
        this.d = i3;
    }

    private c(long l, V v2, kotlin.i0.z.e.n0.c<V> c3, kotlin.i0.z.e.n0.c<V> c4) {
        super();
        this.a = l;
        this.b = c3;
        this.c = c4;
        this.d = obj5;
        this.e = obj1 += obj2;
    }

    private static <V> kotlin.i0.z.e.n0.c<V> c(long l, V v2, kotlin.i0.z.e.n0.c<V> c3, kotlin.i0.z.e.n0.c<V> c4) {
        int i2;
        int i;
        Object obj;
        Object obj5 = c4;
        obj = obj21;
        i2 = obj5.e;
        int i4 = obj.e;
        i = i4 * 5;
        kotlin.i0.z.e.n0.c cVar46 = obj5.c;
        kotlin.i0.z.e.n0.c cVar2 = obj5.d;
        i15 *= 2;
        if (i2 + i4 > 1 && i2 >= i && cVar2.e < i16) {
            i = i4 * 5;
            if (i2 >= i) {
                cVar46 = obj5.c;
                cVar2 = obj5.d;
                i15 *= 2;
                if (cVar2.e < i16) {
                    long l5 = obj5.a;
                    Object obj9 = obj21;
                    super(-l5, i16, c3, cVar2.e(l14 += l5), obj9);
                    super(l5 + l, obj9, obj5.b, cVar46, cVar48);
                    return cVar42;
                }
                kotlin.i0.z.e.n0.c cVar10 = cVar2.c;
                kotlin.i0.z.e.n0.c cVar12 = cVar2.d;
                long l10 = cVar2.a;
                int i33 = -l10;
                kotlin.i0.z.e.n0.c cVar37 = cVar52;
                Object obj16 = obj2;
                super(i33, i33, obj16, cVar46, cVar10.e(l8 += l10));
                long l7 = obj5.a;
                long l2 = cVar2.a;
                Object obj11 = obj21;
                super(i27 -= l2, cVar12, c3, cVar12.e(i34 += l7), obj11);
                super(i32 + l, obj11, cVar2.b, cVar37, cVar40);
                return cVar51;
            }
            obj = obj21;
            kotlin.i0.z.e.n0.c cVar38 = obj.c;
            kotlin.i0.z.e.n0.c cVar41 = obj.d;
            if (i4 >= i2 *= 5 && cVar38.e < i9 *= 2) {
                cVar38 = obj.c;
                cVar41 = obj.d;
                if (cVar38.e < i9 *= 2) {
                    long l3 = obj.a;
                    int i17 = -l3;
                    super(i17, i17, c3, c4, cVar38.e(l15 += l3));
                    super(l3 + l, i17, obj.b, cVar50, cVar41);
                    return cVar43;
                }
                kotlin.i0.z.e.n0.c cVar7 = cVar38.c;
                kotlin.i0.z.e.n0.c cVar44 = cVar38.d;
                long l6 = cVar38.a;
                long l13 = obj.a;
                super(i22 -= l6, i, c3, c4, cVar7.e(i41 += l13));
                long l4 = cVar38.a;
                int i18 = -l4;
                Object obj4 = obj6;
                super(i18, i18, obj4, cVar44.e(l9 += l4), cVar41);
                super(i39 += l, obj4, cVar38.b, cVar53, cVar47);
                return cVar45;
            }
        }
        super(l, i, c3, c4, obj21);
        return cVar35;
    }

    private kotlin.i0.z.e.n0.c<V> d(kotlin.i0.z.e.n0.c<V> c, kotlin.i0.z.e.n0.c<V> c2) {
        kotlin.i0.z.e.n0.c cVar;
        if (c == this.c && c2 == this.d) {
            if (c2 == this.d) {
                return this;
            }
        }
        return c.c(this.a, obj1, this.b, c);
    }

    private kotlin.i0.z.e.n0.c<V> e(long l) {
        int cmp;
        if (this.e != 0 && Long.compare(l, l2) == 0) {
            if (Long.compare(l, l2) == 0) {
            }
            super(l, obj3, this.b, this.c, this.d);
            return cVar;
        }
        return this;
    }

    V a(long l) {
        if (this.e == 0) {
            return 0;
        }
        long l2 = this.a;
        if (Long.compare(l, l2) < 0) {
            return this.c.a(l -= l2);
        }
        if (Long.compare(l, l2) > 0) {
            return this.d.a(l -= l2);
        }
        return this.b;
    }

    kotlin.i0.z.e.n0.c<V> b(long l, V v2) {
        if (this.e == 0) {
            super(l, obj3, obj10, this, this);
            return cVar2;
        }
        long l2 = this.a;
        if (Long.compare(l, l2) < 0) {
            return d(this.c.b(l -= l2, v2), this.d);
        }
        if (Long.compare(l, l2) > 0) {
            return d(this.c, this.d.b(l -= l2, v2));
        }
        if (obj10 == this.b) {
            return this;
        }
        super(l, obj3, obj10, this.c, this.d);
        return cVar;
    }
}
