package kotlin.i0.z.e.m0.j.b.c0;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.y.b;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.j.a;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.w;

/* loaded from: classes3.dex */
public final class a extends a {

    public static final kotlin.i0.z.e.m0.j.b.c0.a m;
    static {
        a aVar = new a();
        a.m = aVar;
    }

    private a() {
        final f fVar = f.d();
        b.a(fVar);
        w wVar = w.a;
        n.e(fVar, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar2 = b.a;
        n.e(fVar2, "packageFqName");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar3 = b.c;
        n.e(fVar3, "constructorAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar4 = b.b;
        n.e(fVar4, "classAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar5 = b.d;
        n.e(fVar5, "functionAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar6 = b.e;
        n.e(fVar6, "propertyAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar7 = b.f;
        n.e(fVar7, "propertyGetterAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar8 = b.g;
        n.e(fVar8, "propertySetterAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar9 = b.i;
        n.e(fVar9, "enumEntryAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar10 = b.h;
        n.e(fVar10, "compileTimeValue");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar11 = b.j;
        n.e(fVar11, "parameterAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar12 = b.k;
        n.e(fVar12, "typeAnnotation");
        final kotlin.reflect.jvm.internal.impl.protobuf.h.f fVar13 = b.l;
        n.e(fVar13, "typeParameterAnnotation");
        super(fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13);
    }

    private final String o(b b) {
        boolean str;
        String obj2;
        if (b.d()) {
            obj2 = "default-package";
        } else {
            n.e(b.g().c(), "fqName.shortName().asString()");
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.j.a
    public final String m(b b) {
        n.f(b, "fqName");
        return n.o(o(b), ".kotlin_builtins");
    }

    @Override // kotlin.i0.z.e.m0.j.a
    public final String n(b b) {
        n.f(b, "fqName");
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = b.b();
        n.e(str2, "fqName.asString()");
        stringBuilder.append(l.F(str2, '.', '/', false, 4, 0));
        stringBuilder.append('/');
        stringBuilder.append(m(b));
        return stringBuilder.toString();
    }
}
