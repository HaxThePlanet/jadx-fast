package com.airbnb.lottie.x;

import com.airbnb.lottie.v.b;
import com.airbnb.lottie.v.b.a;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;

/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements j0<b> {

    public static final h a = new h();
    private static final c.a b;
    static {
        h.b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");
    }

    private h() {
        super();
    }

    public b b(c cVar, float f) {
        int ordinal = 0;
        String str;
        String str2;
        int i;
        b.a cENTER2;
        boolean z;
        cVar.e();
        int cVar2 = 0;
        ordinal = 0;
        int i6 = 1;
        while (cVar.j()) {
            cVar.F();
            cVar.H();
            z = cVar.k();
            i = (float)cVar.m();
            ordinal = p.d(cVar);
            ordinal = p.d(cVar);
            i = (float)cVar.m();
            i = (float)cVar.m();
            ordinal = cVar.n();
            int i3 = cVar.n();
            i = (float)cVar.m();
            str2 = cVar.q();
            str = cVar.q();
        }
        cVar.i();
        b bVar = new b(str, str2, i, cENTER2, ordinal, i, i, ordinal, ordinal, i, z);
        return bVar;
    }
}
