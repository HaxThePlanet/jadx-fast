package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.v.k.g.a;
import com.airbnb.lottie.x.k0.c;

/* compiled from: MaskParser.java */
/* loaded from: classes.dex */
class u {
    static g a(c cVar, com.airbnb.lottie.d dVar) {
        g.a mASK_MODE_NONE2 = null;
        String str;
        com.airbnb.lottie.v.j.h hVar;
        com.airbnb.lottie.v.j.d dVar2;
        boolean z;
        String str3;
        int i4;
        int i = 3;
        cVar.e();
        i = 0;
        while (cVar.j()) {
            String str2 = cVar.o();
            str2.hashCode();
            i = 3;
            i = 2;
            i = 1;
            i = -1;
            cVar.H();
            str = cVar.q();
            str.hashCode();
            StringBuilder stringBuilder = new StringBuilder();
            str3 = "Unknown mask mode ";
            str2 = ". Defaulting to Add.";
            str4 = str3 + str2 + str2;
            d.c(str4);
            mASK_MODE_NONE2 = g.a.MASK_MODE_ADD;
            mASK_MODE_NONE2 = g.a.MASK_MODE_SUBTRACT;
            mASK_MODE_NONE2 = g.a.MASK_MODE_NONE;
            dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
            mASK_MODE_NONE2 = g.a.MASK_MODE_INTERSECT;
            mASK_MODE_NONE2 = g.a.MASK_MODE_ADD;
            str3 = "s";
            str3 = "n";
            int r7 = i;
            str3 = "i";
            r7 = i;
            str3 = "a";
            r7 = i;
            z = cVar.k();
            hVar = d.k(cVar, dVar);
            dVar2 = d.h(cVar, dVar);
            int r6 = i;
            r6 = i;
            r6 = i;
            r6 = i;
        }
        cVar.i();
        return new g(mASK_MODE_NONE2, hVar, dVar2, z);
    }
}
