package net.time4j.g1.z;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.time4j.engine.ChronoException;
import net.time4j.engine.p;
import net.time4j.g0;
import net.time4j.h0;

/* loaded from: classes3.dex */
class v extends net.time4j.g1.z.t<net.time4j.g1.z.v> {

    private static final Set<p<?>> C;
    private boolean A = false;
    private int B = -1;
    private Object[] a = null;
    private Object[] b;
    private Map<p<?>, Object> c = null;
    private int[] v;
    private int w = Integer.MIN_VALUE;
    private int x;
    private int y = Integer.MIN_VALUE;
    private int z;

    static class a {
    }

    private class b implements Iterator<p<?>> {

        int a;
        int b;
        final net.time4j.g1.z.v c;
        private b(net.time4j.g1.z.v v) {
            this.c = v;
            super();
            this.a = v.O(v);
            this.b = v.P(v);
        }

        b(net.time4j.g1.z.v v, net.time4j.g1.z.v.a v$a2) {
            super(v);
        }

        public p<?> b() {
            int i;
            int i2;
            Object obj;
            if (this.b <= 0) {
            } else {
                i = v.Q(this.c);
                i3--;
                this.a = i2;
                while (i2 >= 0) {
                    i3--;
                    this.a = i2;
                }
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.b > 0 ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
            throw unsupportedOperationException;
        }
    }

    private class c extends AbstractSet<p<?>> {

        final net.time4j.g1.z.v a;
        private c(net.time4j.g1.z.v v) {
            this.a = v;
            super();
        }

        c(net.time4j.g1.z.v v, net.time4j.g1.z.v.a v$a2) {
            super(v);
        }

        public Iterator<p<?>> iterator() {
            v.b bVar = new v.b(this.a, 0);
            return bVar;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return v.P(this.a);
        }
    }
    static {
        HashSet hashSet = new HashSet();
        hashSet.add(g0.H);
        hashSet.add(g0.L);
        hashSet.add(g0.M);
        hashSet.add(h0.M);
        hashSet.add(h0.O);
        hashSet.add(h0.Q);
        hashSet.add(h0.U);
        v.C = Collections.unmodifiableSet(hashSet);
    }

    v(int i, boolean z2) {
        int i2;
        int[] iArr;
        super();
        int i3 = -1;
        int i4 = 0;
        if (z2) {
            int obj4 = Integer.MIN_VALUE;
            this.x = obj4;
            this.z = obj4;
            this.b = i4;
            int obj5 = 3;
            this.v = new int[obj5];
            while (true) {
                this.v[i2] = obj4;
                i2++;
            }
        }
        obj4 = v.R(i);
        this.w = obj4;
        this.x = obj4 + -1;
        this.y = v.W(obj4);
        obj4 = this.w;
        this.a = new Object[obj4];
        this.b = i4;
        this.v = new int[obj4];
        this.z = 0;
    }

    static int O(net.time4j.g1.z.v v) {
        return v.w;
    }

    static int P(net.time4j.g1.z.v v) {
        return v.z;
    }

    static Object[] Q(net.time4j.g1.z.v v) {
        return v.a;
    }

    private static int R(int i) {
        return Math.max(2, v.Y((int)ceil));
    }

    private static p<Integer> S(int i) {
        switch (i) {
            case 0:
                return g0.H;
            case 1:
                return g0.L;
            case 2:
                return g0.M;
            case 3:
                return h0.M;
            case 4:
                return h0.O;
            case 5:
                return h0.Q;
            case 6:
                return h0.U;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No element index: ");
                stringBuilder.append(i);
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
        }
    }

    private int T(p<?> p) {
        int key;
        int i;
        boolean equals;
        Object[] objArr = this.a;
        key = 1;
        final int i4 = Integer.MIN_VALUE;
        if (objArr == null && p == g0.H) {
            if (p == g0.H) {
                return this.v[0];
            }
            if (p == g0.L) {
                return this.v[key];
            }
            if (p == g0.M) {
                return this.v[2];
            }
            if (p == h0.M) {
                return this.w;
            }
            if (p == h0.O) {
                return this.x;
            }
            if (p == h0.Q) {
                return this.y;
            }
            if (p == h0.U) {
                return this.z;
            }
            Map map = this.c;
            if (map != null && map.containsKey(p)) {
                if (map.containsKey(p)) {
                    return (Integer)Integer.class.cast(map.get(p)).intValue();
                }
            }
            return i4;
        }
        i6 &= i8;
        Object obj2 = objArr[i];
        if (obj2 == null) {
            return i4;
        }
        if (p.equals(obj2)) {
            return this.v[i];
        }
        i7 &= i9;
        Object obj3 = objArr[i];
        while (obj3 == null) {
            i7 &= i9;
            obj3 = objArr[i];
        }
        return i4;
    }

    static boolean V(p<?> p) {
        return v.C.contains(p);
    }

    private static int W(int i) {
        final int i4 = 1061158912;
        return Math.min((int)ceil, i--);
    }

    private static int X(int i) {
        i *= i2;
        return obj1 ^= i3;
    }

    private static int Y(int i) {
        final int i2 = 1;
        if (i == 0) {
            return i2;
        }
        i--;
        obj2 |= i3;
        obj2 |= i4;
        obj2 |= i5;
        obj2 |= i6;
        return obj2 += i2;
    }

    private void a0(int i) {
        Object[] arr;
        int i3;
        int i4;
        int i2;
        int i5;
        Object obj2;
        Object obj;
        final Object[] objArr = this.a;
        final Object[] objArr2 = this.b;
        final int i6 = i + -1;
        final Object[] arr2 = new Object[i];
        arr = objArr2 == null ? 0 : new Object[i];
        final int[] iArr2 = new int[i];
        i3 = this.w;
        i4 = 0;
        while (i4 < this.z) {
            i3--;
            while (objArr[i3] == null) {
                i3--;
            }
            if (arr2[i9 &= i6] != null) {
            }
            arr2[i2] = objArr[i3];
            if (objArr2 != null) {
            }
            iArr2[i2] = this.v[i3];
            i4++;
            arr[i2] = objArr2[i3];
            while (arr2[i10 &= i6] != null) {
            }
        }
        this.w = i;
        this.x = i6;
        this.y = v.W(i);
        this.a = arr2;
        this.b = arr;
        this.v = iArr2;
    }

    private void b0(Object object) {
        net.time4j.l0 l0Var;
        int i;
        boolean equals;
        int[] obj5;
        Object[] objArr = this.a;
        final int i2 = 1;
        if (objArr == null) {
            int i3 = Integer.MIN_VALUE;
            if (object == g0.H) {
                this.v[0] = i3;
            } else {
                if (object == g0.L) {
                    this.v[i2] = i3;
                } else {
                    if (object == g0.M) {
                        this.v[2] = i3;
                    } else {
                        if (object == h0.M) {
                            this.w = i3;
                        } else {
                            if (object == h0.O) {
                                this.x = i3;
                            } else {
                                if (object == h0.Q) {
                                    this.y = i3;
                                } else {
                                    if (object == h0.U) {
                                        this.z = i3;
                                    } else {
                                        l0Var = this.c;
                                        if (l0Var != null) {
                                            l0Var.remove(object);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        i5 &= i7;
        Object obj = objArr[i];
        if (obj == null) {
        }
        if (object.equals(obj)) {
            c0(i);
        }
        i6 &= i8;
        Object obj2 = objArr[i];
        while (obj2 == null) {
            i6 &= i8;
            obj2 = objArr[i];
        }
    }

    private void c0(int i) {
        int i3;
        int[] iArr;
        int i4;
        int i2;
        int i5;
        int obj6;
        this.z = i6--;
        Object[] objArr = this.a;
        while (/* condition */) {
            i4 = objArr[i3];
            while (i4 == 0) {
                i5 = this.x;
                i12 &= i5;
                if (obj6 >= i2) {
                    break loop_2;
                } else {
                }
                i10 &= i5;
                i4 = objArr[i3];
                if (i2 > i3) {
                    break loop_2;
                } else {
                }
                if (i2 > i3) {
                    break loop_2;
                } else {
                }
            }
            i5 = this.x;
            i12 &= i5;
            if (obj6 <= i3) {
            } else {
            }
            if (obj6 >= i2) {
            } else {
            }
            i10 &= i5;
            if (i2 > i3) {
            } else {
            }
            objArr[obj6] = i4;
            Object[] objArr2 = this.b;
            if (objArr2 != null) {
            }
            iArr = this.v;
            iArr[obj6] = iArr[i3];
            obj6 = i3;
            i8 &= i4;
            objArr2[obj6] = objArr2[i3];
            if (obj6 < i2) {
            } else {
            }
            if (i2 > i3) {
            } else {
            }
        }
        objArr[obj6] = 0;
    }

    public Set<p<?>> A() {
        int i6;
        int i3;
        int i;
        int i2;
        int i5;
        int i7;
        int i4;
        Object keySet;
        HashSet hashSet = new HashSet();
        int i10 = Integer.MIN_VALUE;
        if (this.a == null && this.v[0] != i10) {
            hashSet = new HashSet();
            i10 = Integer.MIN_VALUE;
            if (this.v[0] != i10) {
                hashSet.add(g0.H);
            }
            if (this.v[1] != i10) {
                hashSet.add(g0.L);
            }
            if (this.v[2] != i10) {
                hashSet.add(g0.M);
            }
            if (this.w != i10) {
                hashSet.add(h0.M);
            }
            if (this.x != i10) {
                hashSet.add(h0.O);
            }
            if (this.y != i10) {
                hashSet.add(h0.Q);
            }
            if (this.z != i10) {
                hashSet.add(h0.U);
            }
            keySet = this.c;
            if (keySet != null) {
                hashSet.addAll(keySet.keySet());
            }
            return Collections.unmodifiableSet(hashSet);
        }
        v.c cVar = new v.c(this, 0);
        return cVar;
    }

    <E> E I() {
        return 0;
    }

    void J(p<?> p, int i2) {
        boolean z3;
        boolean z;
        boolean z2;
        Object hashMap;
        int i4;
        boolean equals2;
        int i;
        Object obj;
        boolean equals;
        int i3;
        int obj5;
        Object[] objArr = this.a;
        i4 = 1;
        if (objArr == null) {
            int i9 = Integer.MIN_VALUE;
            if (p == g0.H) {
                i4 = 0;
                z2 = this.v;
                if (!this.A && z2[i4] != i9) {
                    z2 = this.v;
                    if (z2[i4] != i9) {
                        if (z2[i4] != i2) {
                        } else {
                        }
                        a obj6 = new a(p);
                        throw obj6;
                    }
                }
                this.v[i4] = i2;
            } else {
                if (p == g0.L) {
                    z2 = this.v;
                    if (!this.A && z2[i4] != i9) {
                        z2 = this.v;
                        if (z2[i4] != i9) {
                            if (z2[i4] != i2) {
                            } else {
                            }
                            obj6 = new a(p);
                            throw obj6;
                        }
                    }
                    this.v[i4] = i2;
                } else {
                    if (p == g0.M) {
                        i4 = 2;
                        z2 = this.v;
                        if (!this.A && z2[i4] != i9) {
                            z2 = this.v;
                            if (z2[i4] != i9) {
                                if (z2[i4] != i2) {
                                } else {
                                }
                                obj6 = new a(p);
                                throw obj6;
                            }
                        }
                        this.v[i4] = i2;
                    } else {
                        if (p == h0.M) {
                            z2 = this.w;
                            if (!this.A && z2 != i9) {
                                z2 = this.w;
                                if (z2 != i9) {
                                    if (z2 != i2) {
                                    } else {
                                    }
                                    obj6 = new a(p);
                                    throw obj6;
                                }
                            }
                            this.w = i2;
                        } else {
                            if (p == h0.O) {
                                z2 = this.x;
                                if (!this.A && z2 != i9) {
                                    z2 = this.x;
                                    if (z2 != i9) {
                                        if (z2 != i2) {
                                        } else {
                                        }
                                        obj6 = new a(p);
                                        throw obj6;
                                    }
                                }
                                this.x = i2;
                            } else {
                                if (p == h0.Q) {
                                    z2 = this.y;
                                    if (!this.A && z2 != i9) {
                                        z2 = this.y;
                                        if (z2 != i9) {
                                            if (z2 != i2) {
                                            } else {
                                            }
                                            obj6 = new a(p);
                                            throw obj6;
                                        }
                                    }
                                    this.y = i2;
                                } else {
                                    z2 = this.z;
                                    if (p == h0.U && !this.A && z2 != i9) {
                                        if (!this.A) {
                                            z2 = this.z;
                                            if (z2 != i9) {
                                                if (z2 != i2) {
                                                } else {
                                                }
                                                obj6 = new a(p);
                                                throw obj6;
                                            }
                                        }
                                        this.z = i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.c == null) {
                hashMap = new HashMap();
                this.c = hashMap;
            }
            obj6 = Integer.valueOf(i2);
            if (!this.A && hashMap.containsKey(p)) {
                if (hashMap.containsKey(p)) {
                    if (!obj6.equals(hashMap.get(p))) {
                    } else {
                    }
                    obj6 = new a(p);
                    throw obj6;
                }
            }
            hashMap.put(p, obj6);
        }
        i7 &= i10;
        obj = objArr[i];
        if (obj != null && obj.equals(p) && !this.A) {
            if (obj.equals(p)) {
                if (!this.A) {
                    if (this.v[i] != i2) {
                    } else {
                    }
                    obj6 = new a(p);
                    throw obj6;
                }
                this.v[i] = i2;
            }
            i8 &= i11;
            obj = objArr[i];
            while (obj != null) {
                i8 &= i11;
                obj = objArr[i];
            }
        }
        objArr[i] = p;
        this.v[i] = i2;
        obj5 = this.z;
        obj6 = obj5 + 1;
        this.z = obj6;
        if (obj5 >= this.y) {
            a0(v.R(obj6));
        }
    }

    void K(p<?> p, Object object2) {
        Object hashMap;
        boolean equals;
        boolean equals4;
        boolean equals3;
        Object[] arr;
        int i;
        Object obj;
        boolean equals2;
        int obj4;
        Class<Integer> obj2 = Integer.class;
        if (object2 == null) {
            b0(p);
        }
        if (p.getType() == obj2) {
            J(p, (Integer)obj2.cast(object2).intValue());
        }
        Object[] objArr = this.a;
        if (objArr == null && this.c == null) {
            if (this.c == null) {
                hashMap = new HashMap();
                this.c = hashMap;
            }
            if (!this.A && hashMap.containsKey(p)) {
                if (hashMap.containsKey(p)) {
                    if (!object2.equals(hashMap.get(p))) {
                    } else {
                    }
                    a obj5 = new a(p);
                    throw obj5;
                }
            }
            hashMap.put(p, object2);
        }
        if (this.b == null) {
            this.b = new Object[this.w];
        }
        i4 &= i7;
        obj = objArr[i];
        if (obj != null && obj.equals(p) && !this.A) {
            if (obj.equals(p)) {
                if (!this.A) {
                    if (!object2.equals(this.b[i])) {
                    } else {
                    }
                    obj5 = new a(p);
                    throw obj5;
                }
                this.b[i] = object2;
            }
            i5 &= i8;
            obj = objArr[i];
            while (obj != null) {
                i5 &= i8;
                obj = objArr[i];
            }
        }
        objArr[i] = p;
        this.b[i] = object2;
        obj4 = this.z;
        obj5 = obj4 + 1;
        this.z = obj5;
        if (obj4 >= this.y) {
            a0(v.R(obj5));
        }
    }

    @Override // net.time4j.g1.z.t
    void L(Object object) {
    }

    @Override // net.time4j.g1.z.t
    int U() {
        return this.B;
    }

    @Override // net.time4j.g1.z.t
    void Z(net.time4j.g1.z.v v) {
        int i3;
        int iterator;
        int next;
        Object cast;
        int i2;
        int i;
        boolean z;
        next = 0;
        int i4 = v.w;
        i2 = Integer.MIN_VALUE;
        i = this.w;
        if (this.a == null && i4 != i2 && i != i2 && !this.A) {
            i4 = v.w;
            i2 = Integer.MIN_VALUE;
            if (i4 != i2) {
                i = this.w;
                if (i != i2) {
                    if (!this.A) {
                        if (i != i4) {
                        } else {
                        }
                        a obj6 = new a(h0.M);
                        throw obj6;
                    }
                }
                this.w = i4;
            }
            int i5 = v.x;
            i = this.x;
            if (i5 != i2 && i != i2 && !this.A) {
                i = this.x;
                if (i != i2) {
                    if (!this.A) {
                        if (i != i5) {
                        } else {
                        }
                        obj6 = new a(h0.O);
                        throw obj6;
                    }
                }
                this.x = i5;
            }
            int i6 = v.y;
            i = this.y;
            if (i6 != i2 && i != i2 && !this.A) {
                i = this.y;
                if (i != i2) {
                    if (!this.A) {
                        if (i != i6) {
                        } else {
                        }
                        obj6 = new a(h0.Q);
                        throw obj6;
                    }
                }
                this.y = i6;
            }
            i3 = v.z;
            i = this.z;
            if (i3 != i2 && i != i2 && !this.A) {
                i = this.z;
                if (i != i2) {
                    if (!this.A) {
                        if (i != i3) {
                        } else {
                        }
                        obj6 = new a(h0.U);
                        throw obj6;
                    }
                }
                this.z = i3;
            }
            while (next < 3) {
                i3 = v.v[next];
                next++;
                i = this.v;
                i[next] = i3;
            }
            obj6 = v.c;
            if (obj6 != null) {
                iterator = obj6.keySet().iterator();
                for (p next : iterator) {
                    K(next, obj6.get(next));
                }
            }
        }
        Object[] objArr2 = v.a;
        while (next < objArr2.length) {
            cast = objArr2[next];
            if (cast != null) {
            }
            next++;
            cast = p.class.cast(cast);
            if ((p)cast.getType() == Integer.class) {
            } else {
            }
            K(cast, v.b[next]);
            J(cast, v.v[next]);
        }
    }

    @Override // net.time4j.g1.z.t
    void d0() {
        Object[] arr;
        int i;
        int[] iArr;
        Object[] objArr = this.a;
        final int i3 = 0;
        if (objArr == null) {
            int i2 = Integer.MIN_VALUE;
            this.w = i2;
            this.x = i2;
            this.y = i2;
            this.z = i2;
            i = i3;
            while (i < 3) {
                this.v[i] = i2;
                i++;
            }
            this.c = 0;
        } else {
            this.a = new Object[objArr.length];
        }
        this.z = i3;
    }

    public int e(p<Integer> p) {
        return T(p);
    }

    @Override // net.time4j.g1.z.t
    void e0() {
        this.A = true;
    }

    @Override // net.time4j.g1.z.t
    void f0(int i) {
        this.B = i;
    }

    public <V> V p(p<V> p) {
        Object[] key;
        Object[] objArr;
        Object obj;
        boolean equals;
        Class type = p.getType();
        final String str = "No value found for: ";
        if (type == Integer.class) {
            int i = T(p);
            if (i == Integer.MIN_VALUE) {
            } else {
                return type.cast(Integer.valueOf(i));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(p.name());
            ChronoException chronoException = new ChronoException(stringBuilder.toString());
            throw chronoException;
        }
        key = this.a;
        if (key == null) {
            Map map = this.c;
            if (map == null) {
            } else {
                if (!map.containsKey(p)) {
                } else {
                    return p.getType().cast(map.get(p));
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str);
            stringBuilder4.append(p.name());
            ChronoException chronoException4 = new ChronoException(stringBuilder4.toString());
            throw chronoException4;
        }
        if (this.b == null) {
        } else {
            i4 &= i6;
            obj = key[objArr];
            if (obj == null) {
            } else {
                if (p.equals(obj)) {
                    return type.cast(this.b[objArr]);
                }
                i5 &= i7;
                Object obj3 = key[objArr];
                while (obj3 != null) {
                    i5 &= i7;
                    obj3 = key[objArr];
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append(p.name());
                ChronoException chronoException3 = new ChronoException(stringBuilder3.toString());
                throw chronoException3;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(p.name());
        ChronoException chronoException2 = new ChronoException(stringBuilder2.toString());
        throw chronoException2;
    }

    public boolean v(p<?> p) {
        int i;
        int i2;
        boolean equals;
        net.time4j.c obj6;
        i = 0;
        if (p == null) {
            return i;
        }
        Object[] objArr = this.a;
        final int i4 = 1;
        int i5 = Integer.MIN_VALUE;
        if (objArr == null && p == g0.H && this.v[i] != i5) {
            i5 = Integer.MIN_VALUE;
            if (p == g0.H) {
                if (this.v[i] != i5) {
                    i = i4;
                }
                return i;
            }
            if (p == g0.L && this.v[i4] != i5) {
                if (this.v[i4] != i5) {
                    i = i4;
                }
                return i;
            }
            if (p == g0.M && this.v[2] != i5) {
                if (this.v[2] != i5) {
                    i = i4;
                }
                return i;
            }
            if (p == h0.M && this.w != i5) {
                if (this.w != i5) {
                    i = i4;
                }
                return i;
            }
            if (p == h0.O && this.x != i5) {
                if (this.x != i5) {
                    i = i4;
                }
                return i;
            }
            if (p == h0.Q && this.y != i5) {
                if (this.y != i5) {
                    i = i4;
                }
                return i;
            }
            if (p == h0.U && this.z != i5) {
                if (this.z != i5) {
                    i = i4;
                }
                return i;
            }
            Map map = this.c;
            if (map != null && map.containsKey(p)) {
                if (map.containsKey(p)) {
                    i = i4;
                }
            }
            return i;
        }
        Object obj = objArr[i7 &= i9];
        if (obj == null) {
            return i;
        }
        if (p.equals(obj)) {
            return i4;
        }
        Object obj2 = objArr[i8 &= i10];
        while (obj2 == null) {
            obj2 = objArr[i8 &= i10];
        }
        return i;
    }
}
