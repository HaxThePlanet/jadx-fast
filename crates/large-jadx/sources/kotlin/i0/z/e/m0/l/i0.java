package kotlin.i0.z.e.m0.l;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.j;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class i0 extends kotlin.i0.z.e.m0.l.g1 implements i, j {
    public i0() {
        super(0);
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public kotlin.i0.z.e.m0.l.g1 P0(boolean z) {
        return S0(z);
    }

    @Override // kotlin.i0.z.e.m0.l.g1
    public abstract kotlin.i0.z.e.m0.l.i0 S0(boolean z);

    @Override // kotlin.i0.z.e.m0.l.g1
    public abstract kotlin.i0.z.e.m0.l.i0 T0(g g);

    @Override // kotlin.i0.z.e.m0.l.g1
    public String toString() {
        int i3;
        boolean str4;
        String str;
        boolean next;
        int str3;
        String[] strArr;
        c str2;
        int i;
        int i2;
        int i6;
        int i4;
        int i5;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = getAnnotations().iterator();
        str3 = 1;
        for (c next2 : iterator) {
            strArr = new String[3];
            i = 0;
            i2 = 2;
            strArr[str3] = c.t(c.c, next2, i, i2, i);
            strArr[i2] = "] ";
            l.i(stringBuilder, strArr);
            str3 = 1;
        }
        stringBuilder.append(L0());
        if (empty ^= str3 != 0) {
            p.f0(K0(), stringBuilder, ", ", "<", ">", 0, 0, 0, 112, 0);
        }
        if (M0()) {
            stringBuilder.append("?");
        }
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
