package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.t;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.u;

/* loaded from: classes3.dex */
public final class j extends kotlin.i0.z.e.m0.i.q.g<kotlin.o<? extends a, ? extends e>> {

    private final a b;
    private final e c;
    public j(a a, e e2) {
        n.f(a, "enumClassId");
        n.f(e2, "enumEntryName");
        super(u.a(a, e2));
        this.b = a;
        this.c = e2;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public b0 a(c0 c0) {
        kotlin.i0.z.e.m0.l.i0 i;
        boolean z;
        e obj3;
        n.f(c0, "module");
        obj3 = w.a(c0, this.b);
        if (obj3 == null) {
        } else {
            if (d.A(obj3)) {
            } else {
                obj3 = i;
            }
            if (obj3 == null) {
            } else {
                i = obj3.q();
            }
        }
        if (i == null) {
            obj3 = new StringBuilder();
            obj3.append("Containing class for error-class based enum entry ");
            obj3.append(this.b);
            obj3.append('.');
            obj3.append(this.c);
            n.e(t.j(obj3.toString()), "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public final e c() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.i.q.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.j());
        stringBuilder.append('.');
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
