package com.airbnb.lottie.x;

import android.graphics.Path.FillType;
import com.airbnb.lottie.v.k.m;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.Collections;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
class e0 {

    private static final c.a a;
    static {
        e0.a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");
    }

    static m a(c cVar, com.airbnb.lottie.d dVar) {
        int i;
        int i2 = 0;
        String str;
        boolean z;
        int i5 = 2;
        com.airbnb.lottie.v.j.a aVar;
        com.airbnb.lottie.v.j.d cVar4;
        boolean z2;
        Path.FillType cVar3;
        i = 1;
        i2 = 0;
        while (cVar.j()) {
            int i3 = cVar.E(e0.a);
        }
        if (i2 == 0) {
        } else {
        }
        cVar = i == i ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
        m cVar2 = new m(str, z, (i == i ? Path.FillType.WINDING : Path.FillType.EVEN_ODD), aVar, cVar4, z2);
        return cVar;
    }
}
