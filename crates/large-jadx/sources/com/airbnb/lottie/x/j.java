package com.airbnb.lottie.x;

import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
class j {

    private static final c.a a;
    private static final c.a b;
    static {
        j.a = c.a.a("ch", "size", "w", "style", "fFamily", "data");
        j.b = c.a.a("shapes");
    }

    static com.airbnb.lottie.v.d a(c cVar, com.airbnb.lottie.d dVar) {
        char charAt;
        int i3 = 2;
        int i4;
        int i;
        final ArrayList arrayList = new ArrayList();
        cVar.e();
        i = 0;
        final int i2 = 0;
        while (cVar.j()) {
            i = cVar.E(j.a);
        }
        cVar.i();
        d cVar2 = new d(arrayList, charAt, i4, i2, i4, str3, i, i);
        return cVar2;
    }
}
