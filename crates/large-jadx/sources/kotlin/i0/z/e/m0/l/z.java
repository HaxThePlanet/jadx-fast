package kotlin.i0.z.e.m0.l;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public final class z extends kotlin.i0.z.e.m0.l.y0 {

    private final z0[] b;
    private final kotlin.i0.z.e.m0.l.v0[] c;
    private final boolean d;
    public z(List<? extends z0> list, List<? extends kotlin.i0.z.e.m0.l.v0> list2) {
        n.f(list, "parameters");
        n.f(list2, "argumentsList");
        int i = 0;
        Object[] obj9 = list.toArray(new z0[i]);
        String str3 = "null cannot be cast to non-null type kotlin.Array<T>";
        Objects.requireNonNull(obj9, str3);
        obj9 = list2.toArray(new v0[i]);
        Objects.requireNonNull(obj9, str3);
        super((z0[])obj9, (v0[])obj9, 0, 4, 0);
    }

    public z(z0[] z0Arr, kotlin.i0.z.e.m0.l.v0[] v02Arr2, boolean z3) {
        n.f(z0Arr, "parameters");
        n.f(v02Arr2, "arguments");
        super();
        this.b = z0Arr;
        this.c = v02Arr2;
        this.d = z3;
        final int obj2 = z0Arr.length;
        final int obj3 = v02Arr2.length;
    }

    public z(z0[] z0Arr, kotlin.i0.z.e.m0.l.v0[] v02Arr2, boolean z3, int i4, g g5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(z0Arr, v02Arr2, obj3);
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public boolean b() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public kotlin.i0.z.e.m0.l.v0 e(kotlin.i0.z.e.m0.l.b0 b0) {
        z0[] objArr;
        int obj5;
        n.f(b0, "key");
        final int i = 0;
        if (obj5 instanceof z0) {
        } else {
            obj5 = i;
        }
        if (obj5 == null) {
            return i;
        }
        int index = obj5.getIndex();
        objArr = this.b;
        if (index < objArr.length && n.b(objArr[index].g(), obj5.g())) {
            if (n.b(objArr[index].g(), obj5.g())) {
                return this.c[index];
            }
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public boolean f() {
        int i;
        i = objArr.length == 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public final kotlin.i0.z.e.m0.l.v0[] h() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.m0.l.y0
    public final z0[] i() {
        return this.b;
    }
}
