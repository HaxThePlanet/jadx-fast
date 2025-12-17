package kotlin.i0.z.e.m0.d.a;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.z.e.m0.d.a.j0.h;
import kotlin.i0.z.e.m0.d.a.j0.i;
import kotlin.i0.z.e.m0.f.b;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class b {

    private static final b a;
    private static final b b;
    private static final b c;
    private static final b d;
    private static final List<kotlin.i0.z.e.m0.d.a.a> e;
    private static final Map<b, kotlin.i0.z.e.m0.d.a.s> f;
    private static final Map<b, kotlin.i0.z.e.m0.d.a.s> g;
    private static final Set<b> h;
    static {
        b bVar = new b("javax.annotation.meta.TypeQualifierNickname");
        b.a = bVar;
        b bVar2 = new b("javax.annotation.meta.TypeQualifier");
        b.b = bVar2;
        b bVar3 = new b("javax.annotation.meta.TypeQualifierDefault");
        b.c = bVar3;
        b bVar4 = new b("kotlin.annotations.jvm.UnderMigration");
        b.d = bVar4;
        kotlin.i0.z.e.m0.d.a.a[] arr = new a[5];
        final int i2 = 0;
        arr[i2] = a.FIELD;
        final int i3 = 1;
        arr[i3] = a.METHOD_RETURN_TYPE;
        kotlin.i0.z.e.m0.d.a.a vALUE_PARAMETER = a.VALUE_PARAMETER;
        final int i4 = 2;
        arr[i4] = vALUE_PARAMETER;
        arr[3] = a.TYPE_PARAMETER_BOUNDS;
        arr[4] = a.TYPE_USE;
        List list = p.j(arr);
        b.e = list;
        final h nOT_NULL = h.NOT_NULL;
        final int i7 = 0;
        i iVar = new i(nOT_NULL, i2, i4, i7);
        s sVar = new s(iVar, list, i2);
        Map map = j0.e(u.a(z.g(), sVar));
        b.f = map;
        kotlin.o[] arr3 = new o[i4];
        b bVar8 = new b("javax.annotation.ParametersAreNullableByDefault");
        i iVar2 = new i(h.NULLABLE, i2, i4, i7);
        final int i8 = 0;
        final int i9 = 4;
        final int i10 = 0;
        super(iVar2, p.b(vALUE_PARAMETER), i8, i9, i10);
        arr3[i2] = u.a(bVar8, sVar2);
        b bVar9 = new b("javax.annotation.ParametersAreNonnullByDefault");
        i iVar3 = new i(nOT_NULL, i2, i4, i7);
        super(iVar3, p.b(vALUE_PARAMETER), i8, i9, i10);
        arr3[i3] = u.a(bVar9, sVar3);
        b.g = j0.o(j0.k(arr3), map);
        b[] arr2 = new b[i4];
        arr2[i2] = z.f();
        arr2[i3] = z.e();
        b.h = q0.g(arr2);
    }

    public static final Map<b, kotlin.i0.z.e.m0.d.a.s> a() {
        return b.g;
    }

    public static final Set<b> b() {
        return b.h;
    }

    public static final Map<b, kotlin.i0.z.e.m0.d.a.s> c() {
        return b.f;
    }

    public static final b d() {
        return b.d;
    }

    public static final b e() {
        return b.c;
    }

    public static final b f() {
        return b.b;
    }

    public static final b g() {
        return b.a;
    }
}
