package kotlin.i0.z.e.m0.e.a0.b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.a0.a.b;
import kotlin.i0.z.e.m0.e.a0.a.c;
import kotlin.i0.z.e.m0.e.a0.a.d;
import kotlin.i0.z.e.m0.e.a0.a.e;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.d;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.l;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.q;
import kotlin.i0.z.e.m0.e.z.b.b;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.e.z.f;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h.d;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h {

    public static final kotlin.i0.z.e.m0.e.a0.b.h a;
    private static final f b;
    static {
        h hVar = new h();
        h.a = hVar;
        f fVar = f.d();
        a.a(fVar);
        n.e(fVar, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        h.b = fVar;
    }

    public static kotlin.i0.z.e.m0.e.a0.b.e.a d(kotlin.i0.z.e.m0.e.a0.b.h h, n n2, c c3, g g4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 1;
        }
        return h.c(n2, c3, g4, obj4);
    }

    public static final boolean f(n n) {
        n.f(n, "proto");
        Object obj2 = n.o(a.e);
        n.e(obj2, "proto.getExtension(JvmProtoBuf.flags)");
        obj2 = d.a.a().g((Number)obj2.intValue());
        n.e(obj2, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return obj2.booleanValue();
    }

    private final String g(q q, c c2) {
        kotlin.i0.z.e.m0.e.a0.b.b z;
        String obj2;
        if (q.f0()) {
            z = b.a;
            obj2 = b.b(c2.a(q.Q()));
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static final o<kotlin.i0.z.e.m0.e.a0.b.g, c> h(byte[] bArr, String[] string2Arr2) {
        n.f(bArr, "bytes");
        n.f(string2Arr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        o obj2 = new o(h.a.k(byteArrayInputStream, string2Arr2), c.N0(byteArrayInputStream, h.b));
        return obj2;
    }

    public static final o<kotlin.i0.z.e.m0.e.a0.b.g, c> i(String[] stringArr, String[] string2Arr2) {
        n.f(stringArr, "data");
        n.f(string2Arr2, "strings");
        byte[] obj1 = a.e(stringArr);
        n.e(obj1, "decodeBytes(data)");
        return h.h(obj1, string2Arr2);
    }

    public static final o<kotlin.i0.z.e.m0.e.a0.b.g, i> j(String[] stringArr, String[] string2Arr2) {
        n.f(stringArr, "data");
        n.f(string2Arr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(stringArr));
        o obj2 = new o(h.a.k(byteArrayInputStream, string2Arr2), i.r0(byteArrayInputStream, h.b));
        return obj2;
    }

    private final kotlin.i0.z.e.m0.e.a0.b.g k(InputStream inputStream, String[] string2Arr2) {
        final a.e obj3 = a.e.x(inputStream, h.b);
        n.e(obj3, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        g gVar = new g(obj3, string2Arr2);
        return gVar;
    }

    public static final o<kotlin.i0.z.e.m0.e.a0.b.g, l> l(byte[] bArr, String[] string2Arr2) {
        n.f(bArr, "bytes");
        n.f(string2Arr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        o obj2 = new o(h.a.k(byteArrayInputStream, string2Arr2), l.X(byteArrayInputStream, h.b));
        return obj2;
    }

    public static final o<kotlin.i0.z.e.m0.e.a0.b.g, l> m(String[] stringArr, String[] string2Arr2) {
        n.f(stringArr, "data");
        n.f(string2Arr2, "strings");
        byte[] obj1 = a.e(stringArr);
        n.e(obj1, "decodeBytes(data)");
        return h.l(obj1, string2Arr2);
    }

    public final f a() {
        return h.b;
    }

    public final kotlin.i0.z.e.m0.e.a0.b.e.b b(d d, c c2, g g3) {
        int i4;
        boolean next;
        String str;
        String string;
        boolean arrayList;
        String str3;
        String str4;
        String str2;
        int i6;
        int i;
        int i2;
        int i3;
        int i5;
        String obj12;
        n.f(d, "proto");
        n.f(c2, "nameResolver");
        n.f(g3, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar = a.a;
        n.e(fVar, "constructorSignature");
        next = e.a(d, fVar);
        if (next != null && (a.c)next.t()) {
            if (next.t()) {
                string = c2.getString(next.r());
            } else {
                string = "<init>";
            }
        } else {
        }
        if (next != null && next.s()) {
            if (next.s()) {
                obj12 = c2.getString(next.q());
            } else {
                obj12 = d.G();
                n.e(obj12, "proto.valueParameterList");
                arrayList = new ArrayList(p.r(obj12, 10));
                obj12 = obj12.iterator();
                for (u next2 : obj12) {
                    n.e(next2, "it");
                    i4 = g(f.m(next2, g3), c2);
                    arrayList.add(i4);
                }
                obj12 = p.h0(arrayList, "", "(", ")V", 0, 0, 0, 56, 0);
            }
        } else {
        }
        e.b obj13 = new e.b(string, obj12);
        return obj13;
    }

    public final kotlin.i0.z.e.m0.e.a0.b.e.a c(n n, c c2, g g3, boolean z4) {
        a.b bVar;
        boolean z;
        String obj4;
        boolean obj7;
        n.f(n, "proto");
        n.f(c2, "nameResolver");
        n.f(g3, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar = a.d;
        n.e(fVar, "propertySignature");
        Object obj = e.a(n, fVar);
        int i = 0;
        if ((a.d)obj == null) {
            return i;
        }
        if ((a.d)obj.w()) {
            bVar = obj.s();
        } else {
            bVar = i;
        }
        if (bVar == null && z4) {
            if (z4) {
                return i;
            }
        }
        if (bVar != null && bVar.t()) {
            if (bVar.t()) {
                obj7 = bVar.r();
            } else {
                obj7 = n.O();
            }
        } else {
        }
        if (bVar != null && bVar.s()) {
            if (bVar.s()) {
                obj4 = c2.getString(bVar.q());
            } else {
                if (g(f.j(n, g3), c2) == null) {
                    return i;
                }
            }
        } else {
        }
        e.a obj6 = new e.a(c2.getString(obj7), obj4);
        return obj6;
    }

    public final kotlin.i0.z.e.m0.e.a0.b.e.b e(i i, c c2, g g3) {
        String string;
        Object obj;
        Object iterator;
        String str3;
        int i3;
        boolean next;
        int i9;
        ArrayList arrayList;
        int i4;
        int i6;
        ArrayList arrayList2;
        String str;
        String str4;
        String str2;
        int i8;
        int i5;
        int i7;
        int i2;
        int i10;
        final Object obj2 = this;
        Object obj3 = i;
        Object obj4 = c2;
        obj = g3;
        n.f(obj3, "proto");
        n.f(obj4, "nameResolver");
        n.f(obj, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar = a.b;
        n.e(fVar, "methodSignature");
        iterator = e.a(obj3, fVar);
        if (iterator != null && (a.c)iterator.t()) {
            if (iterator.t()) {
                i3 = iterator.r();
            } else {
                i3 = i.P();
            }
        } else {
        }
        if (iterator != null && iterator.s()) {
            if (iterator.s()) {
                string = obj4.getString(iterator.q());
            } else {
                java.util.List list3 = i.b0();
                n.e(list3, "proto.valueParameterList");
                i4 = 10;
                arrayList = new ArrayList(p.r(list3, i4));
                Iterator iterator2 = list3.iterator();
                for (u next4 : iterator2) {
                    n.e(next4, "it");
                    arrayList.add(f.m(next4, obj));
                }
                java.util.List list2 = p.t0(p.k(f.g(obj3, obj)), arrayList);
                arrayList2 = new ArrayList(p.r(list2, i4));
                iterator = list2.iterator();
                arrayList = null;
                for (q next2 : iterator) {
                    i9 = obj2.g(next2, obj4);
                    arrayList2.add(i9);
                    arrayList = null;
                }
                String str5 = obj2.g(f.i(obj3, obj), obj4);
                if (str5 == null) {
                    return arrayList;
                }
                string = n.o(p.h0(arrayList2, "", "(", ")", 0, 0, 0, 56, 0), str5);
            }
        } else {
        }
        e.b bVar = new e.b(obj4.getString(i3), string);
        return bVar;
    }
}
