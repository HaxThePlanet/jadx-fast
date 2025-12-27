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

/* compiled from: ParsedValues.java */
/* loaded from: classes3.dex */
class v extends t<v> {

    private static final Set<p<?>> C;
    private boolean A = false;
    private int B = -1;
    private Object[] a = null;
    private Object[] b;
    private Map<p<?>, Object> c = null;
    private int[] v;
    private int w = Integer.MIN_VALUE;
    private int x = Integer.MIN_VALUE;
    private int y = Integer.MIN_VALUE;
    private int z = Integer.MIN_VALUE;

    static class a {
    }

    private class b implements Iterator<p<?>> {

        int a;
        int b;
        final /* synthetic */ v c;
        private b() {
            this.c = vVar;
            super();
            this.a = vVar.w;
            this.b = vVar.z;
        }

        public p<?> b() {
            Object obj;
            if (this.b <= 0) {
                throw new NoSuchElementException();
            } else {
                Object[] objArr = this.c.a;
                this.a--;
                while (this.a >= 0) {
                    if (objArr[i2] != null) {
                        this.b--;
                        return (p)p.class.cast(objArr[i2]);
                    }
                    this.a--;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z = true;
            int r0 = this.b > 0 ? 1 : 0;
            return (this.b > 0 ? 1 : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        /* synthetic */ b(v.a aVar) {
            this(vVar);
        }
    }

    private class c extends AbstractSet<p<?>> {

        final /* synthetic */ v a;
        private c() {
            this.a = vVar;
            super();
        }

        @Override // java.util.AbstractSet
        public Iterator<p<?>> iterator() {
            return new v.b(this.a, null);
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.z;
        }

        /* synthetic */ c(v.a aVar) {
            this(vVar);
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

    v(int i, boolean z) {
        int i2 = 0;
        super();
        i2 = 0;
        Object[] objArr = null;
        if (z) {
            this.b = objArr;
            int i8 = 3;
            this.v = new int[i8];
            while (true) {
                this.v[i2] = -2147483648;
                i2 = i2 + 1;
            }
        }
        int i5 = v.R(i);
        this.w = i5;
        this.x = i5 - 1;
        this.y = v.W(i5);
        this.a = new Object[i7];
        this.b = objArr;
        this.v = new int[i7];
        this.z = 0;
    }

    static /* synthetic */ int O(v vVar) {
        return vVar.w;
    }

    static /* synthetic */ int P(v vVar) {
        return vVar.z;
    }

    static /* synthetic */ Object[] Q(v vVar) {
        return vVar.a;
    }

    private static int R(int i) {
        return Math.max(2, v.Y((int)(Math.ceil((double)(float)i / 0.75f))));
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
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "No element index: ";
                i = str2 + i;
                throw new IllegalStateException(str2 + i);
        }
    }

    private int T(p<?> pVar) {
        int i2;
        int i = 1;
        final int i5 = Integer.MIN_VALUE;
        if (this.a == null && pVar == g0.H) {
            return this.v[0];
        }
        i2 = v.X(pVar.hashCode()) & this.x;
        Object obj2 = objArr[i2];
        if (this.x == null) {
            return Integer.MIN_VALUE;
        }
        if (pVar.equals(obj2)) {
            return this.v[i2];
        }
        i2 = (i2 + i) & this.x;
        Object obj3 = objArr[i2];
        while (this.x == null) {
            if (pVar.equals(obj3)) {
                return this.v[i2];
            }
            i2 = (i2 + i) & this.x;
            obj3 = objArr[i2];
        }
        return Integer.MIN_VALUE;
    }

    static boolean V(p<?> pVar) {
        return v.C.contains(pVar);
    }

    private static int W(int i) {
        final float f3 = 0.75f;
        return Math.min((int)(Math.ceil((double)(float)i * f3)), i - 1);
    }

    private void a0(int i) {
        Object[] arr = null;
        int i2;
        int i3 = 0;
        int i4;
        final int i6 = i - 1;
        final Object[] arr2 = new Object[i];
        int r5 = this.b == null ? 0 : new Object[i];
        final int[] iArr2 = new int[i];
        i3 = 0;
        while (i3 < this.z) {
            i2 = i2 - 1;
            while (objArr[i2] == null) {
                i2 = i2 - 1;
            }
            i4 = v.X(objArr[i2].hashCode()) & i6;
            arr2[i4] = objArr[i2];
            iArr2[i4] = this.v[i2];
            i3 = i3 + 1;
        }
        this.w = i;
        this.x = i6;
        this.y = v.W(i);
        this.a = arr2;
        this.b = arr;
        this.v = iArr2;
    }

    private void b0(Object object) {
        int i;
        final int i4 = 1;
        if (this.a == null) {
            int i5 = Integer.MIN_VALUE;
            if (object == g0.H) {
                this.v[0] = Integer.MIN_VALUE;
            } else {
                if (this.v == g0.L) {
                    this.v[i4] = Integer.MIN_VALUE;
                } else {
                    if (this.v == g0.M) {
                        this.v[2] = Integer.MIN_VALUE;
                    } else {
                        if (this.v == h0.M) {
                            this.w = Integer.MIN_VALUE;
                        } else {
                            if (this.v == h0.O) {
                                this.x = Integer.MIN_VALUE;
                            } else {
                                if (this.v == h0.Q) {
                                    this.y = Integer.MIN_VALUE;
                                } else {
                                    if (this.v == h0.U) {
                                        this.z = Integer.MIN_VALUE;
                                    } else {
                                        if (this.c != null) {
                                            this.c.remove(object);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return;
        }
        i = v.X(object.hashCode()) & this.x;
        Object obj = objArr[i];
        if (this.x == null) {
            return;
        }
        if (object.equals(obj)) {
            c0(i);
            return;
        }
        i = (i + i4) & this.x;
        Object obj2 = objArr[i];
        while (this.x == null) {
            if (object.equals(obj2)) {
                c0(i);
                return;
            }
            i = (i + i4) & this.x;
            obj2 = objArr[i];
        }
    }

    private void c0(int i) {
        int i2;
        int i4;
        int i5;
        this.z--;
        while (/* condition */) {
            int i3 = objArr[i2];
            while (i3 == 0) {
                i4 = v.X(i3.hashCode()) & i5;
                if (i2 >= i4) {
                    break loop_2;
                }
                if (i4 > i2) {
                    break loop_2;
                }
            }
            i4 = v.X(i3.hashCode()) & i5;
        }
        this.a[i2] = 0;
    }

    @Override // net.time4j.g1.z.t
    public Set<p<?>> A() {
        if (this.a == null) {
            HashSet hashSet = new HashSet();
            int i10 = Integer.MIN_VALUE;
            if (this.v[0] != Integer.MIN_VALUE) {
                hashSet.add(g0.H);
            }
            if (this.v[1] != Integer.MIN_VALUE) {
                hashSet.add(g0.L);
            }
            if (this.v[2] != Integer.MIN_VALUE) {
                hashSet.add(g0.M);
            }
            if (this.w != Integer.MIN_VALUE) {
                hashSet.add(h0.M);
            }
            if (this.x != Integer.MIN_VALUE) {
                hashSet.add(h0.O);
            }
            if (this.y != Integer.MIN_VALUE) {
                hashSet.add(h0.Q);
            }
            if (this.z != Integer.MIN_VALUE) {
                hashSet.add(h0.U);
            }
            if (this.c != null) {
                hashSet.addAll(this.c.keySet());
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return new v.c(this, null);
    }

    @Override // net.time4j.g1.z.t
    void J(p<?> pVar, int i) throws a {
        boolean z3;
        Map map;
        int i3;
        int i4;
        i = 1;
        if (this.a == null) {
            int i19 = Integer.MIN_VALUE;
            if (pVar == g0.H) {
                i = 0;
                if (!this.A && iArr4[i] != Integer.MIN_VALUE) {
                    if (iArr4[i] != i) {
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) new a(pVar);
                    }
                }
                this.v[i] = i;
                return;
            } else {
                if (this.v == g0.L) {
                    if (!this.A && iArr5[i] != Integer.MIN_VALUE) {
                        if (iArr5[i] != i) {
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) new a(pVar);
                        }
                    }
                    this.v[i] = i;
                } else {
                    if (this.v == g0.M) {
                        i = 2;
                        if (!this.A && iArr6[i] != Integer.MIN_VALUE) {
                            if (iArr6[i] != i) {
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) new a(pVar);
                            }
                        }
                        this.v[i] = i;
                    } else {
                        if (this.v == h0.M) {
                            if (!this.A && this.w != Integer.MIN_VALUE) {
                                if (this.w != i) {
                                    /* Dexterity WARN: Type inference failed for thrown value */
                                    throw (Throwable) new a(pVar);
                                }
                            }
                            this.w = i;
                        } else {
                            if (this.v == h0.O) {
                                if (!this.A && this.x != Integer.MIN_VALUE) {
                                    if (this.x != i) {
                                        /* Dexterity WARN: Type inference failed for thrown value */
                                        throw (Throwable) new a(pVar);
                                    }
                                }
                                this.x = i;
                            } else {
                                if (this.v == h0.Q) {
                                    if (!this.A && this.y != Integer.MIN_VALUE) {
                                        if (this.y != i) {
                                            /* Dexterity WARN: Type inference failed for thrown value */
                                            throw (Throwable) new a(pVar);
                                        }
                                    }
                                    this.y = i;
                                } else {
                                    if (this.v == h0.U && !this.A && this.z != Integer.MIN_VALUE) {
                                        if (this.z != i) {
                                            /* Dexterity WARN: Type inference failed for thrown value */
                                            throw (Throwable) new a(pVar);
                                        } else {
                                            this.z = i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.c == null) {
                this.c = new HashMap();
            }
            Integer num = Integer.valueOf(i);
            if (!this.A && h0.U.containsKey(this.v)) {
                if (!num.equals(map.get(pVar))) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(pVar);
                }
            }
            map.put(pVar, num);
            return;
        }
        i3 = v.X(pVar.hashCode()) & this.x;
        Object obj = objArr[i3];
        if (this.x != null && this.x.equals(this.v)) {
            if (!this.A) {
                if (this.v[i3] != i) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(pVar);
                }
            }
            this.v[i3] = i;
            return;
        }
        this.a[i3] = pVar;
        this.v[i3] = i;
        this.z++;
        if (this.z >= this.y) {
            a0(v.R(i22));
        }
    }

    @Override // net.time4j.g1.z.t
    void K(p<?> pVar, Object object) throws a {
        Map map;
        int i;
        Class<Integer> obj2 = Integer.class;
        if (object == null) {
            b0(pVar);
            return;
        }
        if (pVar.getType() == obj2) {
            J(pVar, (Integer)obj2.cast(object).intValue());
            return;
        }
        if (this.a == null && this.c == null) {
            this.c = new HashMap();
            if (!this.A && this.c.containsKey(pVar)) {
                if (!object.equals(map.get(pVar))) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(pVar);
                }
            }
            map.put(pVar, object);
            return;
        }
        if (this.b == null) {
            this.b = new Object[this.w];
        }
        i = v.X(pVar.hashCode()) & this.x;
        Object obj = objArr[i];
        if (this.x != null && this.x.equals(pVar)) {
            if (!this.A) {
                if (!object.equals(this.b[i])) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(pVar);
                }
            }
            this.b[i] = object;
            return;
        }
        this.a[i] = pVar;
        this.b[i] = object;
        this.z++;
        if (this.z >= this.y) {
            a0(v.R(i10));
        }
    }

    @Override // net.time4j.g1.z.t
    int U() {
        return this.B;
    }

    @Override // net.time4j.g1.z.t
    void Z(v vVar) throws a {
        int i3 = 0;
        Object cast;
        int i4 = -2147483648;
        int i5;
        int i6;
        Class<Integer> obj;
        boolean z;
        int i7;
        i3 = 0;
        if (this.a == null) {
            i4 = Integer.MIN_VALUE;
            if (vVar.w != Integer.MIN_VALUE && this.w != Integer.MIN_VALUE && !this.A) {
                if (this.w != vVar.w) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(h0.M);
                } else {
                    this.w = vVar.w;
                }
            }
            if (vVar.x != Integer.MIN_VALUE && this.x != Integer.MIN_VALUE && !this.A) {
                if (this.x != vVar.x) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(h0.O);
                } else {
                    this.x = vVar.x;
                }
            }
            if (vVar.y != Integer.MIN_VALUE && this.y != Integer.MIN_VALUE && !this.A) {
                if (this.y != vVar.y) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new a(h0.Q);
                } else {
                    this.y = vVar.y;
                }
            }
            if (vVar.z != Integer.MIN_VALUE && this.z != Integer.MIN_VALUE) {
                if (!this.A) {
                    if (this.z != vVar.z) {
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) new a(h0.U);
                    }
                }
                this.z = vVar.z;
            }
            int i2 = 3;
            while (i3 < 3) {
                int i = vVar.v[i3];
                if (vVar.x != Integer.MIN_VALUE) {
                }
            }
            if (vVar.c != null) {
                Iterator it = vVar.c.keySet().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    K(item, vVar.c.get(item));
                }
            }
            return;
        }
        for (Object cast : objArr2) {
        }
    }

    @Override // net.time4j.g1.z.t
    void d0() {
        int i;
        i = 0;
        if (this.a == null) {
            int i3 = Integer.MIN_VALUE;
            this.w = i3;
            this.x = i3;
            this.y = i3;
            this.z = i3;
            int i2 = 3;
            while (i < 3) {
                this.v[i] = i3;
                i = i + 1;
                i2 = 3;
            }
            this.c = null;
        } else {
            this.a = new Object[objArr.length];
        }
        this.z = i;
    }

    @Override // net.time4j.g1.z.t
    public int e(p<Integer> pVar) {
        return T(pVar);
    }

    @Override // net.time4j.g1.z.t
    void e0() {
        this.A = true;
    }

    @Override // net.time4j.g1.z.t
    void f0(int i) {
        this.B = i;
    }

    @Override // net.time4j.g1.z.t
    public <V> V p(p<V> pVar) throws ChronoException {
        int i;
        Class type = pVar.getType();
        final String str = "No value found for: ";
        if (type == Integer.class) {
            int i2 = T(pVar);
            if (i2 == -2147483648) {
                StringBuilder stringBuilder = new StringBuilder();
                String name = pVar.name();
                pVar = str + name;
                throw new ChronoException(pVar);
            } else {
                return type.cast(Integer.valueOf(i2));
            }
        }
        if (this.a == null) {
            if (this.c == null) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String name4 = pVar.name();
                pVar = str + name4;
                throw new ChronoException(pVar);
            } else {
                if (this.c.containsKey(pVar)) {
                    return pVar.getType().cast(this.c.get(pVar));
                }
            }
        }
        if (this.b == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String name2 = pVar.name();
            pVar = str + name2;
            throw new ChronoException(pVar);
        } else {
            i = v.X(pVar.hashCode()) & this.x;
            Object obj = objArr[i];
            if (this.x != null) {
                if (pVar.equals(obj)) {
                    return type.cast(this.b[i]);
                }
                i = (i + 1) & this.x;
                Object obj3 = objArr[i];
                while (this.x != null) {
                    if (pVar.equals(obj3)) {
                        return type.cast(this.b[i]);
                    }
                    i = (i + 1) & this.x;
                    obj3 = objArr[i];
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                String name3 = pVar.name();
                pVar = str + name3;
                throw new ChronoException(pVar);
            }
        }
    }

    @Override // net.time4j.g1.z.t
    public boolean v(p<?> pVar) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i2;
        int i3 = 0;
        if (pVar == null) {
            return false;
        }
        final int i = 1;
        if (this.a == null) {
            int i5 = Integer.MIN_VALUE;
            if (pVar == g0.H) {
                if (this.v[i3] != Integer.MIN_VALUE) {
                }
                return z;
            }
            if (this.v[i3] == g0.L) {
                if (this.v[i] != Integer.MIN_VALUE) {
                }
                return z2;
            }
            if (this.v[i] == g0.M) {
                if (this.v[2] != Integer.MIN_VALUE) {
                }
                return z3;
            }
            if (this.v[i] == h0.M && this.w != Integer.MIN_VALUE) {
                return z4;
            }
            if (this.v == h0.O && this.x != Integer.MIN_VALUE) {
                return z5;
            }
            if (this.v == h0.Q && this.y != Integer.MIN_VALUE) {
                return z6;
            }
            if (this.z == h0.U && this.z != Integer.MIN_VALUE) {
                return z7;
            }
            if (this.c != null && this.c.containsKey(this.z)) {
            }
            return z8;
        }
        i2 = v.X(pVar.hashCode()) & this.x;
        Object obj = objArr[i2];
        if (this.x == null) {
            return false;
        }
        if (pVar.equals(obj)) {
            return true;
        }
        i2 = (i2 + i) & this.x;
        Object obj2 = objArr[i2];
        while (this.x == null) {
            if (pVar.equals(obj2)) {
                return true;
            }
            i2 = (i2 + i) & this.x;
            obj2 = objArr[i2 + i & this.x];
        }
        return false;
    }

    private static int X(int i) {
        i *= -1640531527;
        return i4 ^ (i4 >>> 16);
    }

    private static int Y(int i) {
        final int i2 = 1;
        if (i == 0) {
            return i2;
        }
        i--;
        int i9 = i8 | (i8 >> 1);
        i9 |= i4;
        int i11 = i10 | (i10 >> 4);
        i11 |= i6;
        return (i12 | (i12 >> 16)) + i2;
    }

    @Override // net.time4j.g1.z.t
    <E> E I() {
        return null;
    }

    @Override // net.time4j.g1.z.t
    void L(Object object) {
    }
}
