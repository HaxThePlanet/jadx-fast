package kotlin.i0.z.e.m0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.k.n;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public final class a implements b {

    private final n a;
    private final c0 b;
    public a(n n, c0 c02) {
        n.f(n, "storageManager");
        n.f(c02, "module");
        super();
        this.a = n;
        this.b = c02;
    }

    public Collection<e> a(b b) {
        n.f(b, "packageFqName");
        return q0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.b
    public boolean b(b b, e e2) {
        boolean companion;
        int i;
        Object obj5;
        n.f(b, "packageFqName");
        n.f(e2, "name");
        final String obj6 = e2.c();
        n.e(obj6, "name.asString()");
        i = 0;
        final int i2 = 2;
        final int i3 = 0;
        if (!l.M(obj6, "Function", i, i2, i3) && !l.M(obj6, "KFunction", i, i2, i3) && !l.M(obj6, "SuspendFunction", i, i2, i3)) {
            if (!l.M(obj6, "KFunction", i, i2, i3)) {
                if (!l.M(obj6, "SuspendFunction", i, i2, i3)) {
                    if (l.M(obj6, "KSuspendFunction", i, i2, i3) && c.Companion.c(obj6, b) != null) {
                        if (c.Companion.c(obj6, b) != null) {
                            i = 1;
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.b
    public e c(a a) {
        boolean z;
        int next;
        String next2;
        boolean z2;
        Object obj7;
        n.f(a, "classId");
        int i2 = 0;
        if (!a.k()) {
            if (a.l()) {
            } else {
                String str2 = a.i().b();
                n.e(str2, "classId.relativeClassName.asString()");
                if (!l.R(str2, "Function", false, 2, i2)) {
                    return i2;
                }
                obj7 = a.h();
                n.e(obj7, "classId.packageFqName");
                kotlin.i0.z.e.m0.b.p.c.a.a aVar = c.Companion.c(str2, obj7);
                if (aVar == null) {
                    return i2;
                }
                ArrayList arrayList = new ArrayList();
                obj7 = this.b.M(obj7).G().iterator();
                while (obj7.hasNext()) {
                    next = obj7.next();
                    if (next instanceof b != null) {
                    }
                    arrayList.add(next);
                }
                obj7 = new ArrayList();
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    next2 = iterator.next();
                    if (next2 instanceof f) {
                    }
                    obj7.add(next2);
                }
                if ((f)p.Z(obj7) == null) {
                    obj7 = p.X(arrayList);
                }
            }
            b bVar2 = new b(this.a, obj7, aVar.a(), aVar.b());
            return bVar2;
        }
        return i2;
    }
}
