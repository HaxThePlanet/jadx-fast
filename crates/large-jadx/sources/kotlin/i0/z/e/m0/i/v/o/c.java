package kotlin.i0.z.e.m0.i.v.o;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public class c implements kotlin.i0.z.e.m0.i.v.o.d, kotlin.i0.z.e.m0.i.v.o.f {

    private final e a;
    private final e b;
    public c(e e, kotlin.i0.z.e.m0.i.v.o.c c2) {
        n.f(e, "classDescriptor");
        super();
        this.a = e;
        this.b = e;
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public i0 b() {
        i0 i0Var = this.a.q();
        n.e(i0Var, "classDescriptor.defaultType");
        return i0Var;
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public boolean equals(Object object) {
        e i;
        Object obj4;
        if (object instanceof c) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            i = obj4.a;
        }
        return n.b(this.a, i);
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public b0 getType() {
        return b();
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public final e p() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class{");
        stringBuilder.append(b());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
