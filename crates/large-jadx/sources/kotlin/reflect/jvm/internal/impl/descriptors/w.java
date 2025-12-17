package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.j;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.f;
import kotlin.i0.z.e.m0.c.b.d;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.m;
import kotlin.i0.z.e.m0.i.v.k;
import kotlin.j0.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class w {

    static final class b extends p implements l<a, Integer> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.w.b a;
        static {
            w.b bVar = new w.b();
            w.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final int a(a a) {
            n.f(a, "it");
            return 0;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Integer.valueOf(a((a)object));
        }
    }

    class a extends j implements l<a, a> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.w.a a;
        static {
            w.a aVar = new w.a();
            w.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.j
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.d0.d.j
        public final f getOwner() {
            return c0.b(a.class);
        }

        @Override // kotlin.d0.d.j
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.d0.d.j
        public Object invoke(Object object) {
            return l((a)object);
        }

        @Override // kotlin.d0.d.j
        public final a l(a a) {
            n.f(a, "p0");
            return a.g();
        }
    }
    public static final kotlin.reflect.jvm.internal.impl.descriptors.e a(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0, a a2) {
        kotlin.reflect.jvm.internal.impl.descriptors.h obj1;
        n.f(c0, "<this>");
        n.f(a2, "classId");
        if (obj1 instanceof e) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.h b(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0, a a2) {
        boolean size2;
        int fROM_DESERIALIZATION;
        d fROM_DESERIALIZATION3;
        kotlin.reflect.jvm.internal.impl.descriptors.h i;
        List iterator;
        boolean size;
        d fROM_DESERIALIZATION2;
        kotlin.reflect.jvm.internal.impl.descriptors.h obj10;
        Iterator obj11;
        n.f(c0, "<this>");
        n.f(a2, "classId");
        kotlin.reflect.jvm.internal.impl.descriptors.c0 c0Var = m.a(c0);
        final String str3 = "name";
        fROM_DESERIALIZATION = 1;
        fROM_DESERIALIZATION3 = "segments.first()";
        final String str4 = "classId.relativeClassName.pathSegments()";
        final String str5 = "classId.packageFqName";
        i = 0;
        if (c0Var == null) {
            b bVar = a2.h();
            n.e(bVar, str5);
            obj11 = a2.i().f();
            n.e(obj11, str4);
            size2 = p.X(obj11);
            n.e(size2, fROM_DESERIALIZATION3);
            if (c0.M(bVar).o().f((e)size2, d.FROM_DESERIALIZATION) == null) {
            } else {
                obj11 = obj11.subList(fROM_DESERIALIZATION, obj11.size()).iterator();
                for (e size2 : obj11) {
                    n.e(size2, str3);
                    if (obj10 instanceof e != 0) {
                    } else {
                    }
                    obj10 = i;
                }
                i = obj10;
            }
        } else {
            b bVar3 = a2.h();
            n.e(bVar3, str5);
            iterator = a2.i().f();
            n.e(iterator, str4);
            size = p.X(iterator);
            n.e(size, fROM_DESERIALIZATION3);
            if (c0Var.M(bVar3).o().f((e)size, d.FROM_DESERIALIZATION) == null) {
                size2 = i;
            } else {
                iterator = iterator.subList(fROM_DESERIALIZATION, iterator.size()).iterator();
                for (e size : iterator) {
                    n.e(size, str3);
                    if (size2 instanceof e != null) {
                    } else {
                    }
                    size2 = i;
                }
            }
            if (size2 == null) {
                b bVar2 = a2.h();
                n.e(bVar2, str5);
                obj11 = a2.i().f();
                n.e(obj11, str4);
                size2 = p.X(obj11);
                n.e(size2, fROM_DESERIALIZATION3);
                if (c0.M(bVar2).o().f((e)size2, d.FROM_DESERIALIZATION) == null) {
                } else {
                    obj11 = obj11.subList(fROM_DESERIALIZATION, obj11.size()).iterator();
                    for (e size2 : obj11) {
                        n.e(size2, str3);
                        if (obj10 instanceof e != 0) {
                        } else {
                        }
                        obj10 = i;
                    }
                }
            } else {
                i = size2;
            }
        }
        return i;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.e c(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0, a a2, kotlin.reflect.jvm.internal.impl.descriptors.e0 e03) {
        n.f(c0, "<this>");
        n.f(a2, "classId");
        n.f(e03, "notFoundClasses");
        kotlin.reflect.jvm.internal.impl.descriptors.e obj1 = w.a(c0, a2);
        if (obj1 != null) {
            return obj1;
        }
        return e03.d(a2, i.A(i.u(i.f(a2, w.a.a), w.b.a)));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.y0 d(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0, a a2) {
        kotlin.reflect.jvm.internal.impl.descriptors.h obj1;
        n.f(c0, "<this>");
        n.f(a2, "classId");
        if (obj1 instanceof y0) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }
}
