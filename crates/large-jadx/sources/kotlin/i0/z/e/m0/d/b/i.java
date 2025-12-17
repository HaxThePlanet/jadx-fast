package kotlin.i0.z.e.m0.d.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.e.a0.a;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.i0.z.e.m0.e.l;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.e;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.j.b.d0.e;
import kotlin.i0.z.e.m0.j.b.d0.f;
import kotlin.i0.z.e.m0.j.b.r;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;

/* loaded from: classes3.dex */
public final class i implements f {

    private final c b;
    private final c c;
    private final kotlin.i0.z.e.m0.d.b.o d;
    public i(kotlin.i0.z.e.m0.d.b.o o, l l2, c c3, r<f> r4, boolean z5, e e6) {
        int i;
        int i2;
        Object obj7 = o;
        n.f(o, "kotlinClass");
        Object obj2 = l2;
        n.f(l2, "packageProto");
        Object obj4 = c3;
        n.f(c3, "nameResolver");
        n.f(e6, "abiStability");
        final c cVar = c.b(o.e());
        n.e(cVar, "byClassId(kotlinClass.classId)");
        String str6 = o.a().e();
        i = 0;
        if (str6 != null) {
            i2 = str6.length() > 0 ? 1 : 0;
            if (i2 != 0) {
                i = c.d(str6);
            }
        }
        super(cVar, i, l2, c3, r4, z5, e6, o);
    }

    public i(c c, c c2, l l3, c c4, r<f> r5, boolean z6, e e7, kotlin.i0.z.e.m0.d.b.o o8) {
        Object obj1;
        n.f(c, "className");
        n.f(l3, "packageProto");
        n.f(c4, "nameResolver");
        n.f(e7, "abiStability");
        super();
        this.b = c;
        this.c = c2;
        this.d = o8;
        obj1 = a.m;
        n.e(obj1, "packageModuleName");
        obj1 = e.a(l3, obj1);
        if ((Integer)obj1 == null) {
        } else {
            obj1 = c4.getString((Integer)obj1.intValue());
        }
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public v0 a() {
        final v0 v0Var = v0.a;
        n.e(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class '");
        stringBuilder.append(d().b().b());
        stringBuilder.append('\'');
        return stringBuilder.toString();
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public final a d() {
        a aVar = new a(this.b.g(), g());
        return aVar;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public final c e() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public final kotlin.i0.z.e.m0.d.b.o f() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public final e g() {
        String str = this.b.f();
        n.e(str, "className.internalName");
        final int i2 = 0;
        e eVar = e.j(l.S0(str, '/', i2, 2, i2));
        n.e(eVar, "identifier(className.internalName.substringAfterLast('/'))");
        return eVar;
    }

    @Override // kotlin.i0.z.e.m0.j.b.d0.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.class.getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
