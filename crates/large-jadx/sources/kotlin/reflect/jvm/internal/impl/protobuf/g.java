package kotlin.reflect.jvm.internal.impl.protobuf;

import android.app.ActivityManager.MemoryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
final class g<FieldDescriptorType extends kotlin.reflect.jvm.internal.impl.protobuf.g.b<FieldDescriptorType>>  {

    private static final kotlin.reflect.jvm.internal.impl.protobuf.g d;
    private final kotlin.reflect.jvm.internal.impl.protobuf.t<FieldDescriptorType, Object> a;
    private boolean b;
    private boolean c = false;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            g.a.b = iArr;
            int i2 = 1;
            iArr[w.b.DOUBLE.ordinal()] = i2;
            int i = 2;
            g.a.b[w.b.FLOAT.ordinal()] = i;
            int i3 = 3;
            g.a.b[w.b.INT64.ordinal()] = i3;
            int i4 = 4;
            g.a.b[w.b.UINT64.ordinal()] = i4;
            int i5 = 5;
            g.a.b[w.b.INT32.ordinal()] = i5;
            int i6 = 6;
            g.a.b[w.b.FIXED64.ordinal()] = i6;
            int i7 = 7;
            g.a.b[w.b.FIXED32.ordinal()] = i7;
            int i8 = 8;
            g.a.b[w.b.BOOL.ordinal()] = i8;
            int i9 = 9;
            g.a.b[w.b.STRING.ordinal()] = i9;
            g.a.b[w.b.BYTES.ordinal()] = 10;
            g.a.b[w.b.UINT32.ordinal()] = 11;
            g.a.b[w.b.SFIXED32.ordinal()] = 12;
            g.a.b[w.b.SFIXED64.ordinal()] = 13;
            g.a.b[w.b.SINT32.ordinal()] = 14;
            g.a.b[w.b.SINT64.ordinal()] = 15;
            g.a.b[w.b.GROUP.ordinal()] = 16;
            g.a.b[w.b.MESSAGE.ordinal()] = 17;
            g.a.b[w.b.ENUM.ordinal()] = 18;
            int[] iArr27 = new int[values2.length];
            g.a.a = iArr27;
            iArr27[w.c.INT.ordinal()] = i2;
            g.a.a[w.c.LONG.ordinal()] = i;
            g.a.a[w.c.FLOAT.ordinal()] = i3;
            g.a.a[w.c.DOUBLE.ordinal()] = i4;
            g.a.a[w.c.BOOLEAN.ordinal()] = i5;
            g.a.a[w.c.STRING.ordinal()] = i6;
            g.a.a[w.c.BYTE_STRING.ordinal()] = i7;
            g.a.a[w.c.ENUM.ordinal()] = i8;
            g.a.a[w.c.MESSAGE.ordinal()] = i9;
        }
    }

    public interface b extends Comparable<T> {
        @Override // java.lang.Comparable
        public abstract boolean b();

        @Override // java.lang.Comparable
        public abstract kotlin.reflect.jvm.internal.impl.protobuf.w.b d();

        @Override // java.lang.Comparable
        public abstract kotlin.reflect.jvm.internal.impl.protobuf.w.c g();

        @Override // java.lang.Comparable
        public abstract int getNumber();

        @Override // java.lang.Comparable
        public abstract kotlin.reflect.jvm.internal.impl.protobuf.o.a h(kotlin.reflect.jvm.internal.impl.protobuf.o.a o$a, kotlin.reflect.jvm.internal.impl.protobuf.o o2);

        @Override // java.lang.Comparable
        public abstract boolean isPacked();
    }
    static {
        g gVar = new g(1);
        g.d = gVar;
    }

    private g() {
        super();
        int i = 0;
        this.a = t.o(16);
    }

    private g(boolean z) {
        super();
        this.a = t.o(0);
        q();
    }

    private Object c(Object object) {
        if (object instanceof byte[]) {
            byte[] bArr = new byte[object.length];
            final int i = 0;
            System.arraycopy((byte[])object, i, bArr, i, object.length);
            return bArr;
        }
        return object;
    }

    private static int d(kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b, int i2, Object object3) {
        int obj2;
        if (b == w.b.GROUP) {
            obj2 *= 2;
        }
        return obj2 += obj1;
    }

    private static int e(kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b, Object object2) {
        switch (obj1) {
            case 1:
                return CodedOutputStream.g((Double)object2.doubleValue());
            case 2:
                return CodedOutputStream.m((Float)object2.floatValue());
            case 3:
                return CodedOutputStream.q((Long)object2.longValue());
            case 4:
                return CodedOutputStream.F((Long)object2.longValue());
            case 5:
                return CodedOutputStream.p((Integer)object2.intValue());
            case 6:
                return CodedOutputStream.k((Long)object2.longValue());
            case 7:
                return CodedOutputStream.j((Integer)object2.intValue());
            case 8:
                return CodedOutputStream.b((Boolean)object2.booleanValue());
            case 9:
                return CodedOutputStream.C((String)object2);
            case 10:
                return CodedOutputStream.e((d)object2);
                return CodedOutputStream.c((byte[])object2);
            case 11:
                return CodedOutputStream.E((Integer)object2.intValue());
            case 12:
                return CodedOutputStream.x((Integer)object2.intValue());
            case 13:
                return CodedOutputStream.y((Long)object2.longValue());
            case 14:
                return CodedOutputStream.z((Integer)object2.intValue());
            case 15:
                return CodedOutputStream.B((Long)object2.longValue());
            case 16:
                return CodedOutputStream.n((o)object2);
            case 17:
                return CodedOutputStream.r((j)object2);
                return CodedOutputStream.t((o)object2);
            case 18:
                return CodedOutputStream.i((i.a)object2.getNumber());
                return CodedOutputStream.i((Integer)object2.intValue());
            default:
                RuntimeException obj1 = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw obj1;
        }
    }

    public static int f(kotlin.reflect.jvm.internal.impl.protobuf.g.b<?> g$b, Object object2) {
        int i;
        Object obj4;
        final kotlin.reflect.jvm.internal.impl.protobuf.w.b bVar = b.d();
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
        return g.d(bVar, number, object2);
    }

    public static <T extends kotlin.reflect.jvm.internal.impl.protobuf.g.b<T>> kotlin.reflect.jvm.internal.impl.protobuf.g<T> g() {
        return g.d;
    }

    static int l(kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b, boolean z2) {
        if (z2) {
            return 2;
        }
        return b.getWireType();
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> map$Entry) {
        boolean initialized;
        Object next;
        kotlin.reflect.jvm.internal.impl.protobuf.w.c cVar;
        boolean obj5;
        next = entry.getKey();
        final int i = 1;
        if ((g.b)next.g() == w.c.MESSAGE) {
            cVar = 0;
            if (next.b()) {
                obj5 = (List)entry.getValue().iterator();
                for (o next2 : obj5) {
                }
            } else {
                obj5 = entry.getValue();
                if (obj5 instanceof o) {
                    if (!(o)obj5.isInitialized()) {
                        return cVar;
                    }
                } else {
                    if (!obj5 instanceof j) {
                    } else {
                        return i;
                    }
                }
            }
            obj5 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            throw obj5;
        }
        return i;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> map$Entry) {
        Object arrayList;
        Object obj2;
        boolean mESSAGE;
        Object obj;
        Object obj5;
        final Object key = entry.getKey();
        obj5 = entry.getValue();
        if (obj5 instanceof j) {
            obj5 = (j)obj5.e();
        }
        if ((g.b)key.b()) {
            if (h(key) == null) {
                arrayList = new ArrayList();
            }
            obj5 = (List)obj5.iterator();
            for (Object next : obj5) {
                (List)arrayList.add(c(next));
            }
            this.a.p(key, arrayList);
        } else {
            if (key.g() == w.c.MESSAGE) {
                Object obj3 = h(key);
                if (obj3 == null) {
                    this.a.p(key, c(obj5));
                } else {
                    this.a.p(key, key.h((o)obj3.toBuilder(), (o)obj5).build());
                }
            } else {
                this.a.p(key, c(obj5));
            }
        }
    }

    public static <T extends kotlin.reflect.jvm.internal.impl.protobuf.g.b<T>> kotlin.reflect.jvm.internal.impl.protobuf.g<T> t() {
        g gVar = new g();
        return gVar;
    }

    public static Object u(kotlin.reflect.jvm.internal.impl.protobuf.e e, kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b2, boolean z3) {
        int obj2 = g.a.b[b2.ordinal()];
        switch (obj2) {
            case 1:
                return Double.valueOf(e.m());
            case 2:
                return Float.valueOf(e.q());
            case 3:
                return Long.valueOf(e.t());
            case 4:
                return Long.valueOf(e.M());
            case 5:
                return Integer.valueOf(e.s());
            case 6:
                return Long.valueOf(e.p());
            case 7:
                return Integer.valueOf(e.o());
            case 8:
                return Boolean.valueOf(e.k());
            case 9:
                return e.J();
                return e.I();
            case 10:
                return e.l();
            case 11:
                return Integer.valueOf(e.L());
            case 12:
                return Integer.valueOf(e.E());
            case 13:
                return Long.valueOf(e.F());
            case 14:
                return Integer.valueOf(e.G());
            case 15:
                return Long.valueOf(e.H());
            case 16:
                IllegalArgumentException obj1 = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                throw obj1;
            case 17:
                obj1 = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                throw obj1;
            case 18:
                obj1 = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                throw obj1;
            default:
                obj1 = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw obj1;
        }
    }

    private static void w(kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b, Object object2) {
        int i;
        boolean i2;
        boolean obj2;
        Objects.requireNonNull(object2);
        i = 1;
        switch (obj2) {
            case 1:
                i2 = object2 instanceof Integer;
                break;
            case 2:
                i2 = object2 instanceof Long;
                break;
            case 3:
                i2 = object2 instanceof Float;
                break;
            case 4:
                i2 = object2 instanceof Double;
                break;
            case 5:
                i2 = object2 instanceof Boolean;
                break;
            case 6:
                i2 = object2 instanceof String;
                break;
            case 7:
                i = i2;
                i2 = i;
                break;
            case 8:
                i = i2;
                i2 = i;
                break;
            case 9:
                i = i2;
                i2 = i;
                break;
            default:
        }
        if (!i2) {
        } else {
        }
        obj2 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        throw obj2;
    }

    private static void x(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b2, int i3, Object object4) {
        kotlin.reflect.jvm.internal.impl.protobuf.w.b gROUP;
        if (b2 == w.b.GROUP) {
            codedOutputStream.Y(i3, (o)object4);
        } else {
            codedOutputStream.w0(i3, g.l(b2, false));
            g.y(codedOutputStream, b2, object4);
        }
    }

    private static void y(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b2, Object object3) {
        int obj2;
        switch (obj2) {
            case 1:
                codedOutputStream.R((Double)object3.doubleValue());
                break;
            case 2:
                codedOutputStream.X((Float)object3.floatValue());
                break;
            case 3:
                codedOutputStream.c0((Long)object3.longValue());
                break;
            case 4:
                codedOutputStream.z0((Long)object3.longValue());
                break;
            case 5:
                codedOutputStream.b0((Integer)object3.intValue());
                break;
            case 6:
                codedOutputStream.V((Long)object3.longValue());
                break;
            case 7:
                codedOutputStream.U((Integer)object3.intValue());
                break;
            case 8:
                codedOutputStream.M((Boolean)object3.booleanValue());
                break;
            case 9:
                codedOutputStream.v0((String)object3);
                break;
            case 10:
                codedOutputStream.P((d)object3);
                codedOutputStream.N((byte[])object3);
                break;
            case 11:
                codedOutputStream.y0((Integer)object3.intValue());
                break;
            case 12:
                codedOutputStream.q0((Integer)object3.intValue());
                break;
            case 13:
                codedOutputStream.r0((Long)object3.longValue());
                break;
            case 14:
                codedOutputStream.s0((Integer)object3.intValue());
                break;
            case 15:
                codedOutputStream.u0((Long)object3.longValue());
                break;
            case 16:
                codedOutputStream.Z((o)object3);
                break;
            case 17:
                codedOutputStream.e0((o)object3);
                break;
            case 18:
                codedOutputStream.T((i.a)object3.getNumber());
                codedOutputStream.T((Integer)object3.intValue());
                break;
            default:
        }
    }

    public static void z(kotlin.reflect.jvm.internal.impl.protobuf.g.b<?> g$b, Object object2, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream3) {
        int iterator;
        boolean next;
        kotlin.reflect.jvm.internal.impl.protobuf.o obj3;
        Object obj4;
        final kotlin.reflect.jvm.internal.impl.protobuf.w.b bVar = b.d();
        iterator = b.getNumber();
        if (b.b()) {
            if (b.isPacked()) {
                codedOutputStream3.w0(iterator, 2);
                obj3 = 0;
                iterator = (List)object2.iterator();
                for (Object next2 : iterator) {
                    obj3 += next;
                }
                codedOutputStream3.o0(obj3);
                obj3 = object2.iterator();
                for (Object obj4 : obj3) {
                    g.y(codedOutputStream3, bVar, obj4);
                }
            } else {
                obj3 = object2.iterator();
                for (Object obj4 : obj3) {
                    g.x(codedOutputStream3, bVar, iterator, obj4);
                }
            }
        } else {
            if (object2 instanceof j) {
                g.x(codedOutputStream3, bVar, iterator, (j)object2.e());
            } else {
                g.x(codedOutputStream3, bVar, iterator, object2);
            }
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object object2) {
        Object arrayList;
        kotlin.reflect.jvm.internal.impl.protobuf.t tVar;
        if (!fielddescriptortype.b()) {
        } else {
            g.w(fielddescriptortype.d(), object2);
            if (h(fielddescriptortype) == null) {
                arrayList = new ArrayList();
                this.a.p(fielddescriptortype, arrayList);
            } else {
            }
            arrayList.add(object2);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        throw obj3;
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.g<FieldDescriptorType> b() {
        int i;
        Object value;
        int value2;
        Object key;
        final kotlin.reflect.jvm.internal.impl.protobuf.g gVar = g.t();
        i = 0;
        while (i < this.a.j()) {
            Map.Entry map = this.a.i(i);
            gVar.v((g.b)map.getKey(), map.getValue());
            i++;
        }
        Iterator iterator = this.a.k().iterator();
        for (Map.Entry next2 : iterator) {
            gVar.v((g.b)next2.getKey(), next2.getValue());
        }
        gVar.c = this.c;
        return gVar;
    }

    public Object clone() {
        return b();
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj2;
        obj2 = this.a.get(fielddescriptortype);
        if (obj2 instanceof j) {
            obj2 = (j)obj2.e();
        }
        return obj2;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i2) {
        if (!fielddescriptortype.b()) {
        } else {
            Object obj2 = h(fielddescriptortype);
            if (obj2 == null) {
            } else {
                return (List)obj2.get(i2);
            }
            obj2 = new IndexOutOfBoundsException();
            throw obj2;
        }
        obj2 = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        throw obj2;
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.b()) {
        } else {
            Object obj2 = h(fielddescriptortype);
            if (obj2 == null) {
                return 0;
            }
            return (List)obj2.size();
        }
        obj2 = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        throw obj2;
    }

    public int k() {
        int i3;
        int i;
        int i2;
        int i4;
        Object key;
        i = i3;
        while (i3 < this.a.j()) {
            Map.Entry map = this.a.i(i3);
            i += i2;
            i3++;
        }
        Iterator iterator = this.a.k().iterator();
        for (Map.Entry next2 : iterator) {
            i += i4;
        }
        return i;
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        int obj2;
        if (fielddescriptortype.b()) {
        } else {
            obj2 = this.a.get(fielddescriptortype) != null ? 1 : 0;
            return obj2;
        }
        obj2 = new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        throw obj2;
    }

    public boolean n() {
        int i;
        boolean z;
        int i2;
        int i3 = 0;
        i = i3;
        while (i < this.a.j()) {
            i++;
        }
        Iterator iterator = this.a.k().iterator();
        for (Map.Entry next2 : iterator) {
        }
        return 1;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        if (this.c) {
            j.c cVar = new j.c(this.a.entrySet().iterator());
            return cVar;
        }
        return this.a.entrySet().iterator();
    }

    public void q() {
        if (this.b) {
        }
        this.a.n();
        this.b = true;
    }

    public void r(kotlin.reflect.jvm.internal.impl.protobuf.g<FieldDescriptorType> g) {
        int next;
        Map.Entry map;
        next = 0;
        while (next < g.a.j()) {
            s(g.a.i(next));
            next++;
        }
        Iterator obj3 = g.a.k().iterator();
        for (Map.Entry next : obj3) {
            s(next);
        }
    }

    public void v(FieldDescriptorType fielddescriptortype, Object object2) {
        Object arrayList;
        boolean z;
        Object next;
        kotlin.reflect.jvm.internal.impl.protobuf.w.b bVar;
        Object obj5;
        if (fielddescriptortype.b()) {
            if (object2 instanceof List == null) {
            } else {
                arrayList = new ArrayList();
                arrayList.addAll((List)object2);
                obj5 = arrayList.iterator();
                for (Object next : obj5) {
                    g.w(fielddescriptortype.d(), next);
                }
                obj5 = arrayList;
                if (obj5 instanceof j) {
                    this.c = true;
                }
                this.a.p(fielddescriptortype, obj5);
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            throw obj4;
        }
        g.w(fielddescriptortype.d(), object2);
    }
}
