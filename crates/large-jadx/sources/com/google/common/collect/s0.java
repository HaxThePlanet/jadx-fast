package com.google.common.collect;

import com.google.common.base.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class s0<K, V>  extends com.google.common.collect.x<K, V> {

    private static final long serialVersionUID;
    static final com.google.common.collect.x<Object, Object> y;
    private final transient Object v;
    final transient Object[] w;
    private final transient int x;

    static class a extends com.google.common.collect.z<Map.Entry<K, V>> {

        private final transient com.google.common.collect.x<K, V> c;
        private final transient Object[] v;
        private final transient int w;
        private final transient int x;
        a(com.google.common.collect.x<K, V> x, Object[] object2Arr2, int i3, int i4) {
            super();
            this.c = x;
            this.v = object2Arr2;
            this.w = i3;
            this.x = i4;
        }

        static int C(com.google.common.collect.s0.a s0$a) {
            return a.x;
        }

        static Object[] D(com.google.common.collect.s0.a s0$a) {
            return a.v;
        }

        static int E(com.google.common.collect.s0.a s0$a) {
            return a.w;
        }

        @Override // com.google.common.collect.z
        public boolean contains(Object object) {
            boolean key;
            int i;
            com.google.common.collect.x xVar;
            Object obj4;
            i = 0;
            obj4 = object.getValue();
            if (object instanceof Map.Entry && obj4 != null && obj4.equals(this.c.get((Map.Entry)object.getKey()))) {
                obj4 = object.getValue();
                if (obj4 != null) {
                    if (obj4.equals(this.c.get((Map.Entry)object.getKey()))) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        @Override // com.google.common.collect.z
        int d(Object[] objectArr, int i2) {
            return b().d(objectArr, i2);
        }

        @Override // com.google.common.collect.z
        public Iterator iterator() {
            return m();
        }

        @Override // com.google.common.collect.z
        boolean l() {
            return 1;
        }

        public com.google.common.collect.b1<Map.Entry<K, V>> m() {
            return b().m();
        }

        @Override // com.google.common.collect.z
        public int size() {
            return this.x;
        }

        com.google.common.collect.v<Map.Entry<K, V>> u() {
            s0.a.a aVar = new s0.a.a(this);
            return aVar;
        }
    }

    static final class b extends com.google.common.collect.z<K> {

        private final transient com.google.common.collect.x<K, ?> c;
        private final transient com.google.common.collect.v<K> v;
        b(com.google.common.collect.x<K, ?> x, com.google.common.collect.v<K> v2) {
            super();
            this.c = x;
            this.v = v2;
        }

        public com.google.common.collect.v<K> b() {
            return this.v;
        }

        @Override // com.google.common.collect.z
        public boolean contains(Object object) {
            int obj2;
            obj2 = this.c.get(object) != null ? 1 : 0;
            return obj2;
        }

        @Override // com.google.common.collect.z
        int d(Object[] objectArr, int i2) {
            return b().d(objectArr, i2);
        }

        @Override // com.google.common.collect.z
        public Iterator iterator() {
            return m();
        }

        @Override // com.google.common.collect.z
        boolean l() {
            return 1;
        }

        public com.google.common.collect.b1<K> m() {
            return b().m();
        }

        @Override // com.google.common.collect.z
        public int size() {
            return this.c.size();
        }
    }

    static final class c extends com.google.common.collect.v<Object> {

        private final transient Object[] c;
        private final transient int v;
        private final transient int w;
        c(Object[] objectArr, int i2, int i3) {
            super();
            this.c = objectArr;
            this.v = i2;
            this.w = i3;
        }

        @Override // com.google.common.collect.v
        public Object get(int i) {
            n.m(i, this.w);
            return this.c[obj3 += i3];
        }

        @Override // com.google.common.collect.v
        boolean l() {
            return 1;
        }

        @Override // com.google.common.collect.v
        public int size() {
            return this.w;
        }
    }
    static {
        final int i = 0;
        s0 s0Var = new s0(0, new Object[i], i);
        s0.y = s0Var;
    }

    private s0(Object object, Object[] object2Arr2, int i3) {
        super();
        this.v = object;
        this.w = object2Arr2;
        this.x = i3;
    }

    static <K, V> com.google.common.collect.s0<K, V> m(int i, Object[] object2Arr2) {
        if (i == 0) {
            return (s0)s0.y;
        }
        int i2 = 0;
        int i4 = 1;
        if (i == i4) {
            i.a(object2Arr2[i2], object2Arr2[i4]);
            s0 obj3 = new s0(0, object2Arr2, i4);
            return obj3;
        }
        n.r(i, length >> 1);
        s0 s0Var = new s0(s0.n(object2Arr2, i, z.p(i), i2), object2Arr2, i);
        return s0Var;
    }

    static Object n(Object[] objectArr, int i2, int i3, int i4) {
        int i11;
        int i;
        int i12;
        int i13;
        int i8;
        int i7;
        int i10;
        int i9;
        int i5;
        int i6;
        int equals2;
        boolean equals;
        if (i2 == 1) {
            i.a(objectArr[i4], objectArr[i4 ^ 1]);
            return null;
        }
        int i15 = i3 + -1;
        i12 = 0;
        i13 = -1;
        if (i3 <= 128) {
            byte[] obj11 = new byte[i3];
            Arrays.fill(obj11, i13);
            while (i12 < i2) {
                i16 += i4;
                i13 = objectArr[i17];
                i8 = objectArr[i17 ^ 1];
                i.a(i13, i8);
                i10 = s.b(i13.hashCode());
                i10 &= i15;
                equals2 = 255;
                b &= equals2;
                while (i5 == equals2) {
                    i7++;
                    i10 &= i15;
                    equals2 = 255;
                    b &= equals2;
                }
                i7++;
                obj11[i7] = (byte)i17;
                i12++;
            }
            return obj11;
        }
        if (i3 <= 32768) {
            obj11 = new short[i3];
            Arrays.fill(obj11, i13);
            while (i12 < i2) {
                i19 += i4;
                i13 = objectArr[i20];
                i8 = objectArr[i20 ^ 1];
                i.a(i13, i8);
                i9 = s.b(i13.hashCode());
                i9 &= i15;
                equals2 = 65535;
                s &= equals2;
                while (i5 == equals2) {
                    i7++;
                    i9 &= i15;
                    equals2 = 65535;
                    s &= equals2;
                }
                i7++;
                obj11[i7] = (short)i20;
                i12++;
            }
            return obj11;
        }
        obj11 = new int[i3];
        Arrays.fill(obj11, i13);
        while (i12 < i2) {
            i18 += i4;
            i8 = objectArr[i];
            i7 = objectArr[i ^ 1];
            i.a(i8, i7);
            i6 = s.b(i8.hashCode());
            i6 &= i15;
            equals2 = obj11[i5];
            while (equals2 == i13) {
                i5++;
                i6 &= i15;
                equals2 = obj11[i5];
            }
            i5++;
            obj11[i5] = i;
            i12++;
        }
        return obj11;
    }

    private static java.lang.IllegalArgumentException o(Object object, Object object2, Object[] object3Arr3, int i4) {
        String obj3 = String.valueOf(object);
        String obj4 = String.valueOf(object2);
        String valueOf = String.valueOf(object3Arr3[i4]);
        String obj5 = String.valueOf(object3Arr3[i4 ^= 1]);
        StringBuilder stringBuilder = new StringBuilder(obj6 += length3);
        stringBuilder.append("Multiple entries with same key: ");
        stringBuilder.append(obj3);
        obj3 = "=";
        stringBuilder.append(obj3);
        stringBuilder.append(obj4);
        stringBuilder.append(" and ");
        stringBuilder.append(valueOf);
        stringBuilder.append(obj3);
        stringBuilder.append(obj5);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        return illegalArgumentException;
    }

    static Object p(Object object, Object[] object2Arr2, int i3, int i4, Object object5) {
        int i2;
        int i;
        boolean equals;
        int obj4;
        int obj7;
        i2 = 0;
        if (object5 == null) {
            return i2;
        }
        final int i5 = 1;
        if (i3 == i5 && object2Arr2[i4].equals(object5)) {
            if (object2Arr2[i4].equals(object5)) {
                i2 = object2Arr2[i4 ^ 1];
            }
            return i2;
        }
        if (object == null) {
            return i2;
        }
        if (object instanceof byte[]) {
            Object obj6 = object;
            obj4 = s.b(object5.hashCode());
            obj4 &= obj7;
            int i6 = 255;
            b &= i6;
            while (i == i6) {
                obj4++;
                obj4 &= obj7;
                i6 = 255;
                b &= i6;
            }
            return i2;
        }
        if (object instanceof short[]) {
            obj6 = object;
            obj4 = s.b(object5.hashCode());
            obj4 &= obj7;
            int i8 = 65535;
            s &= i8;
            while (i == i8) {
                obj4++;
                obj4 &= obj7;
                i8 = 65535;
                s &= i8;
            }
            return i2;
        }
        obj7 = s.b(object5.hashCode());
        obj7 &= obj6;
        i = (int[])object[obj7];
        while (i == -1) {
            obj7++;
            obj7 &= obj6;
            i = object[obj7];
        }
        return i2;
    }

    com.google.common.collect.z<Map.Entry<K, V>> e() {
        s0.a aVar = new s0.a(this, this.w, 0, this.x);
        return aVar;
    }

    com.google.common.collect.z<K> f() {
        s0.c cVar = new s0.c(this.w, 0, this.x);
        s0.b bVar = new s0.b(this, cVar);
        return bVar;
    }

    com.google.common.collect.t<V> g() {
        s0.c cVar = new s0.c(this.w, 1, this.x);
        return cVar;
    }

    public V get(Object object) {
        return s0.p(this.v, this.w, this.x, 0, object);
    }

    @Override // com.google.common.collect.x
    boolean i() {
        return 0;
    }

    @Override // com.google.common.collect.x
    public int size() {
        return this.x;
    }
}
