package kotlin.i0.z.e.m0.j.b;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.s;
import kotlin.i0.z.e.m0.e.z.a;
import kotlin.i0.z.e.m0.e.z.c;
import kotlin.i0.z.e.m0.e.z.g;
import kotlin.i0.z.e.m0.e.z.i;
import kotlin.i0.z.e.m0.e.z.j;
import kotlin.i0.z.e.m0.j.b.d0.f;
import kotlin.i0.z.e.m0.k.n;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public final class l {

    private final kotlin.i0.z.e.m0.j.b.j a;
    private final c b;
    private final m c;
    private final g d;
    private final i e;
    private final a f;
    private final f g;
    private final kotlin.i0.z.e.m0.j.b.b0 h;
    private final kotlin.i0.z.e.m0.j.b.u i;
    public l(kotlin.i0.z.e.m0.j.b.j j, c c2, m m3, g g4, i i5, a a6, f f7, kotlin.i0.z.e.m0.j.b.b0 b08, List<s> list9) {
        int i;
        String str;
        final Object obj5 = this;
        Object obj = g4;
        Object obj2 = i5;
        Object obj3 = a6;
        f fVar = f7;
        n.f(j, "components");
        n.f(c2, "nameResolver");
        n.f(m3, "containingDeclaration");
        n.f(obj, "typeTable");
        n.f(obj2, "versionRequirementTable");
        n.f(obj3, "metadataVersion");
        n.f(list9, "typeParameters");
        super();
        obj5.a = j;
        obj5.b = c2;
        obj5.c = m3;
        obj5.d = obj;
        obj5.e = obj2;
        obj5.f = obj3;
        obj5.g = fVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deserializer for \"");
        stringBuilder.append(m3.getName());
        stringBuilder.append('"');
        if (fVar == null) {
            str = str2;
        } else {
        }
        super(this, b08, list9, stringBuilder.toString(), str, 0, 32, 0);
        obj5.h = b0Var3;
        u uVar = new u(this);
        obj5.i = uVar;
    }

    public static kotlin.i0.z.e.m0.j.b.l b(kotlin.i0.z.e.m0.j.b.l l, m m2, List list3, c c4, g g5, i i6, a a7, int i8, Object object9) {
        c obj10;
        g obj11;
        i obj12;
        a obj13;
        if (i8 & 4 != 0) {
            obj10 = l.b;
        }
        if (i8 & 8 != 0) {
            obj11 = l.d;
        }
        if (i8 & 16 != 0) {
            obj12 = l.e;
        }
        if (i8 & 32 != 0) {
            obj13 = l.f;
        }
        return l.a(m2, list3, obj10, obj11, obj12, obj13);
    }

    public final kotlin.i0.z.e.m0.j.b.l a(m m, List<s> list2, c c3, g g4, i i5, a a6) {
        Object obj;
        final Object obj2 = this;
        Object obj5 = m;
        n.f(m, "descriptor");
        Object obj10 = list2;
        n.f(list2, "typeParameterProtos");
        Object obj3 = c3;
        n.f(c3, "nameResolver");
        n.f(g4, "typeTable");
        n.f(i5, "versionRequirementTable");
        n.f(a6, "metadataVersion");
        if (j.b(a6)) {
        } else {
            obj = obj2.e;
        }
        super(obj2.a, c3, m, g4, obj, a6, obj2.g, obj2.h, list2);
        return lVar;
    }

    public final kotlin.i0.z.e.m0.j.b.j c() {
        return this.a;
    }

    public final f d() {
        return this.g;
    }

    public final m e() {
        return this.c;
    }

    public final kotlin.i0.z.e.m0.j.b.u f() {
        return this.i;
    }

    public final c g() {
        return this.b;
    }

    public final n h() {
        return this.a.u();
    }

    public final kotlin.i0.z.e.m0.j.b.b0 i() {
        return this.h;
    }

    public final g j() {
        return this.d;
    }

    public final i k() {
        return this.e;
    }
}
