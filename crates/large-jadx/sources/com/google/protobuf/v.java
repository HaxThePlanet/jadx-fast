package com.google.protobuf;

import android.accounts.Account;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class v<T extends com.google.protobuf.v.b<T>>  {

    private static final com.google.protobuf.v d;
    private final com.google.protobuf.o1<T, Object> a;
    private boolean b;
    private boolean c;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            v.a.b = iArr;
            int i2 = 1;
            iArr[y1.b.DOUBLE.ordinal()] = i2;
            int i = 2;
            v.a.b[y1.b.FLOAT.ordinal()] = i;
            int i3 = 3;
            v.a.b[y1.b.INT64.ordinal()] = i3;
            int i4 = 4;
            v.a.b[y1.b.UINT64.ordinal()] = i4;
            int i5 = 5;
            v.a.b[y1.b.INT32.ordinal()] = i5;
            int i6 = 6;
            v.a.b[y1.b.FIXED64.ordinal()] = i6;
            int i7 = 7;
            v.a.b[y1.b.FIXED32.ordinal()] = i7;
            int i8 = 8;
            v.a.b[y1.b.BOOL.ordinal()] = i8;
            int i9 = 9;
            v.a.b[y1.b.GROUP.ordinal()] = i9;
            v.a.b[y1.b.MESSAGE.ordinal()] = 10;
            v.a.b[y1.b.STRING.ordinal()] = 11;
            v.a.b[y1.b.BYTES.ordinal()] = 12;
            v.a.b[y1.b.UINT32.ordinal()] = 13;
            v.a.b[y1.b.SFIXED32.ordinal()] = 14;
            v.a.b[y1.b.SFIXED64.ordinal()] = 15;
            v.a.b[y1.b.SINT32.ordinal()] = 16;
            v.a.b[y1.b.SINT64.ordinal()] = 17;
            v.a.b[y1.b.ENUM.ordinal()] = 18;
            int[] iArr27 = new int[values2.length];
            v.a.a = iArr27;
            iArr27[y1.c.INT.ordinal()] = i2;
            v.a.a[y1.c.LONG.ordinal()] = i;
            v.a.a[y1.c.FLOAT.ordinal()] = i3;
            v.a.a[y1.c.DOUBLE.ordinal()] = i4;
            v.a.a[y1.c.BOOLEAN.ordinal()] = i5;
            v.a.a[y1.c.STRING.ordinal()] = i6;
            v.a.a[y1.c.BYTE_STRING.ordinal()] = i7;
            v.a.a[y1.c.ENUM.ordinal()] = i8;
            v.a.a[y1.c.MESSAGE.ordinal()] = i9;
        }
    }

    public interface b extends Comparable<T> {
        @Override // java.lang.Comparable
        public abstract boolean b();

        @Override // java.lang.Comparable
        public abstract com.google.protobuf.y1.b d();

        @Override // java.lang.Comparable
        public abstract com.google.protobuf.y1.c g();

        @Override // java.lang.Comparable
        public abstract int getNumber();

        @Override // java.lang.Comparable
        public abstract boolean isPacked();

        @Override // java.lang.Comparable
        public abstract com.google.protobuf.t0.a l(com.google.protobuf.t0.a t0$a, com.google.protobuf.t0 t02);
    }
    static {
        v vVar = new v(1);
        v.d = vVar;
    }

    private v() {
        super();
        this.a = o1.r(16);
    }

    private v(com.google.protobuf.o1<T, Object> o1) {
        super();
        this.a = o1;
        t();
    }

    private v(boolean z) {
        super(o1.r(0));
        t();
    }

    static void A(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.y1.b y1$b2, Object object3) {
        long obj2;
        switch (obj2) {
            case 1:
                codedOutputStream.s0((Double)object3.doubleValue());
                break;
            case 2:
                codedOutputStream.A0((Float)object3.floatValue());
                break;
            case 3:
                codedOutputStream.I0((Long)object3.longValue());
                break;
            case 4:
                codedOutputStream.c1((Long)object3.longValue());
                break;
            case 5:
                codedOutputStream.G0((Integer)object3.intValue());
                break;
            case 6:
                codedOutputStream.y0((Long)object3.longValue());
                break;
            case 7:
                codedOutputStream.w0((Integer)object3.intValue());
                break;
            case 8:
                codedOutputStream.m0((Boolean)object3.booleanValue());
                break;
            case 9:
                codedOutputStream.D0((t0)object3);
                break;
            case 10:
                codedOutputStream.K0((t0)object3);
                break;
            case 11:
                codedOutputStream.q0((j)object3);
                codedOutputStream.X0((String)object3);
                break;
            case 12:
                codedOutputStream.q0((j)object3);
                codedOutputStream.n0((byte[])object3);
                break;
            case 13:
                codedOutputStream.a1((Integer)object3.intValue());
                break;
            case 14:
                codedOutputStream.P0((Integer)object3.intValue());
                break;
            case 15:
                codedOutputStream.R0((Long)object3.longValue());
                break;
            case 16:
                codedOutputStream.T0((Integer)object3.intValue());
                break;
            case 17:
                codedOutputStream.V0((Long)object3.longValue());
                break;
            case 18:
                codedOutputStream.u0((c0.c)object3.getNumber());
                codedOutputStream.u0((Integer)object3.intValue());
                break;
            default:
        }
    }

    private static Object c(Object object) {
        if (object instanceof byte[]) {
            byte[] bArr = new byte[object.length];
            final int i = 0;
            System.arraycopy((byte[])object, i, bArr, i, object.length);
            return bArr;
        }
        return object;
    }

    static int d(com.google.protobuf.y1.b y1$b, int i2, Object object3) {
        int obj2;
        if (b == y1.b.GROUP) {
            obj2 *= 2;
        }
        return obj2 += obj1;
    }

    static int e(com.google.protobuf.y1.b y1$b, Object object2) {
        switch (obj1) {
            case 1:
                return CodedOutputStream.k((Double)object2.doubleValue());
            case 2:
                return CodedOutputStream.s((Float)object2.floatValue());
            case 3:
                return CodedOutputStream.z((Long)object2.longValue());
            case 4:
                return CodedOutputStream.a0((Long)object2.longValue());
            case 5:
                return CodedOutputStream.x((Integer)object2.intValue());
            case 6:
                return CodedOutputStream.q((Long)object2.longValue());
            case 7:
                return CodedOutputStream.o((Integer)object2.intValue());
            case 8:
                return CodedOutputStream.f((Boolean)object2.booleanValue());
            case 9:
                return CodedOutputStream.u((t0)object2);
            case 10:
                return CodedOutputStream.C((f0)object2);
                return CodedOutputStream.H((t0)object2);
            case 11:
                return CodedOutputStream.i((j)object2);
                return CodedOutputStream.V((String)object2);
            case 12:
                return CodedOutputStream.i((j)object2);
                return CodedOutputStream.g((byte[])object2);
            case 13:
                return CodedOutputStream.Y((Integer)object2.intValue());
            case 14:
                return CodedOutputStream.N((Integer)object2.intValue());
            case 15:
                return CodedOutputStream.P((Long)object2.longValue());
            case 16:
                return CodedOutputStream.R((Integer)object2.intValue());
            case 17:
                return CodedOutputStream.T((Long)object2.longValue());
            case 18:
                return CodedOutputStream.m((c0.c)object2.getNumber());
                return CodedOutputStream.m((Integer)object2.intValue());
            default:
                RuntimeException obj1 = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw obj1;
        }
    }

    public static int f(com.google.protobuf.v.b<?> v$b, Object object2) {
        int i;
        Object obj4;
        final com.google.protobuf.y1.b bVar = b.d();
        final int number = b.getNumber();
        i = 0;
        if (b.b() && b.isPacked()) {
            i = 0;
            if (b.isPacked()) {
                Iterator obj3 = (List)object2.iterator();
                for (Object obj4 : obj3) {
                    i += obj4;
                }
                return obj3 += obj4;
            }
            obj3 = (List)object2.iterator();
            for (Object obj4 : obj3) {
                i += obj4;
            }
            return i;
        }
        return v.d(bVar, number, object2);
    }

    public static <T extends com.google.protobuf.v.b<T>> com.google.protobuf.v<T> h() {
        return v.d;
    }

    private int k(Map.Entry<T, Object> map$Entry) {
        com.google.protobuf.y1.c packed;
        Object key = entry.getKey();
        final Object value = entry.getValue();
        if ((v.b)key.g() == y1.c.MESSAGE && !key.b() && !key.isPacked() && value instanceof f0) {
            if (!key.b()) {
                if (!key.isPacked()) {
                    if (value instanceof f0) {
                        return CodedOutputStream.A((v.b)entry.getKey().getNumber(), (f0)value);
                    }
                    return CodedOutputStream.E((v.b)entry.getKey().getNumber(), (t0)value);
                }
            }
        }
        return v.f(key, value);
    }

    static int m(com.google.protobuf.y1.b y1$b, boolean z2) {
        if (z2) {
            return 2;
        }
        return b.getWireType();
    }

    private static <T extends com.google.protobuf.v.b<T>> boolean q(Map.Entry<T, Object> map$Entry) {
        boolean initialized;
        Object next;
        com.google.protobuf.y1.c cVar;
        boolean obj4;
        next = entry.getKey();
        final int i = 1;
        if ((v.b)next.g() == y1.c.MESSAGE) {
            cVar = 0;
            if (next.b()) {
                obj4 = (List)entry.getValue().iterator();
                for (t0 next2 : obj4) {
                }
            } else {
                obj4 = entry.getValue();
                if (obj4 instanceof t0) {
                    if (!(t0)obj4.isInitialized()) {
                        return cVar;
                    }
                } else {
                    if (!obj4 instanceof f0) {
                    } else {
                        return i;
                    }
                }
            }
            obj4 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            throw obj4;
        }
        return i;
    }

    private static boolean r(com.google.protobuf.y1.b y1$b, Object object2) {
        int i;
        int i2;
        boolean obj2;
        c0.a(object2);
        i = 1;
        final int i4 = 0;
        switch (obj2) {
            case 1:
                return object2 instanceof Integer;
            case 2:
                return object2 instanceof Long;
            case 3:
                return object2 instanceof Float;
            case 4:
                return object2 instanceof Double;
            case 5:
                return object2 instanceof Boolean;
            case 6:
                return object2 instanceof String;
            case 7:
                i = i4;
                return i;
            case 8:
                i = i4;
                return i;
            case 9:
                i = i4;
                return i;
            default:
                return i4;
        }
    }

    private void v(Map.Entry<T, Object> map$Entry) {
        Object arrayList;
        Object obj2;
        boolean mESSAGE;
        Object obj;
        Object obj5;
        final Object key = entry.getKey();
        obj5 = entry.getValue();
        if (obj5 instanceof f0) {
            obj5 = (f0)obj5.f();
        }
        if ((v.b)key.b()) {
            if (i(key) == null) {
                arrayList = new ArrayList();
            }
            obj5 = (List)obj5.iterator();
            for (Object next : obj5) {
                (List)arrayList.add(v.c(next));
            }
            this.a.s(key, arrayList);
        } else {
            if (key.g() == y1.c.MESSAGE) {
                Object obj3 = i(key);
                if (obj3 == null) {
                    this.a.s(key, v.c(obj5));
                } else {
                    this.a.s(key, key.l((t0)obj3.toBuilder(), (t0)obj5).build());
                }
            } else {
                this.a.s(key, v.c(obj5));
            }
        }
    }

    public static <T extends com.google.protobuf.v.b<T>> com.google.protobuf.v<T> w() {
        v vVar = new v();
        return vVar;
    }

    private void y(T t, Object object2) {
        if (!v.r(t.d(), object2)) {
        } else {
        }
        Object[] arr = new Object[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.getNumber()), t.d().getJavaType(), object2.getClass().getName()));
        throw illegalArgumentException;
    }

    static void z(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.y1.b y1$b2, int i3, Object object4) {
        com.google.protobuf.y1.b gROUP;
        if (b2 == y1.b.GROUP) {
            codedOutputStream.B0(i3, (t0)object4);
        } else {
            codedOutputStream.Y0(i3, v.m(b2, false));
            v.A(codedOutputStream, b2, object4);
        }
    }

    public void a(T t, Object object2) {
        Object arrayList;
        com.google.protobuf.o1 o1Var;
        if (!t.b()) {
        } else {
            y(t, object2);
            if (i(t) == null) {
                arrayList = new ArrayList();
                this.a.s(t, arrayList);
            } else {
            }
            arrayList.add(object2);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        throw obj3;
    }

    public com.google.protobuf.v<T> b() {
        int i;
        Object value2;
        int value;
        Object key;
        final com.google.protobuf.v vVar = v.w();
        i = 0;
        while (i < this.a.l()) {
            Map.Entry map = this.a.k(i);
            vVar.x((v.b)map.getKey(), map.getValue());
            i++;
        }
        Iterator iterator = this.a.n().iterator();
        for (Map.Entry next2 : iterator) {
            vVar.x((v.b)next2.getKey(), next2.getValue());
        }
        vVar.c = this.c;
        return vVar;
    }

    public Object clone() {
        return b();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof v) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    Iterator<Map.Entry<T, Object>> g() {
        if (this.c) {
            f0.c cVar = new f0.c(this.a.i().iterator());
            return cVar;
        }
        return this.a.i().iterator();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object i(T t) {
        Object obj2;
        obj2 = this.a.get(t);
        if (obj2 instanceof f0) {
            obj2 = (f0)obj2.f();
        }
        return obj2;
    }

    public int j() {
        int i3;
        int i4;
        int i2;
        int i;
        i4 = i3;
        while (i3 < this.a.l()) {
            i4 += i2;
            i3++;
        }
        Iterator iterator = this.a.n().iterator();
        for (Map.Entry next2 : iterator) {
            i4 += i;
        }
        return i4;
    }

    public int l() {
        int i;
        int i3;
        int i4;
        int i2;
        Object key;
        i3 = i;
        while (i < this.a.l()) {
            Map.Entry map = this.a.k(i);
            i3 += i4;
            i++;
        }
        Iterator iterator = this.a.n().iterator();
        for (Map.Entry next2 : iterator) {
            i3 += i2;
        }
        return i3;
    }

    boolean n() {
        return this.a.isEmpty();
    }

    public boolean o() {
        return this.b;
    }

    public boolean p() {
        int i;
        boolean z;
        int i2;
        int i3 = 0;
        i = i3;
        while (i < this.a.l()) {
            i++;
        }
        Iterator iterator = this.a.n().iterator();
        for (Map.Entry next2 : iterator) {
        }
        return 1;
    }

    public Iterator<Map.Entry<T, Object>> s() {
        if (this.c) {
            f0.c cVar = new f0.c(this.a.entrySet().iterator());
            return cVar;
        }
        return this.a.entrySet().iterator();
    }

    public void t() {
        if (this.b) {
        }
        this.a.q();
        this.b = true;
    }

    public void u(com.google.protobuf.v<T> v) {
        int next;
        Map.Entry map;
        next = 0;
        while (next < v.a.l()) {
            v(v.a.k(next));
            next++;
        }
        Iterator obj3 = v.a.n().iterator();
        for (Map.Entry next : obj3) {
            v(next);
        }
    }

    public void x(T t, Object object2) {
        boolean arrayList;
        boolean z;
        Object next;
        Object obj4;
        if (t.b()) {
            if (object2 instanceof List == null) {
            } else {
                arrayList = new ArrayList();
                arrayList.addAll((List)object2);
                obj4 = arrayList.iterator();
                for (Object next : obj4) {
                    y(t, next);
                }
                obj4 = arrayList;
                if (obj4 instanceof f0) {
                    this.c = true;
                }
                this.a.s(t, obj4);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            throw obj3;
        }
        y(t, object2);
    }
}
