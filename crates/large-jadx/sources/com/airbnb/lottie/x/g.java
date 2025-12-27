package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import com.airbnb.lottie.v.k.b;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;

/* compiled from: ContentModelParser.java */
/* loaded from: classes.dex */
class g {

    private static c.a a;
    static {
        g.a = c.a.a("ty", "d");
    }

    static b a(c cVar, com.airbnb.lottie.d dVar) {
        int i = 12;
        String str;
        com.airbnb.lottie.v.k.o oVar = null;
        cVar.e();
        i = 2;
        i = 1;
        int i3 = 0;
        while (cVar.j()) {
            int i2 = cVar.E(g.a);
            if (i2 == 0) {
                break;
            }
        }
        if (g.a == null) {
            return null;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 3239:
                i = -1;
                i = 0;
                break;
            case 3270:
                i = -1;
                break;
            case 3295:
                i = -1;
                break;
            case 3307:
                i = -1;
                i = 3;
                break;
            case 3308:
                i = -1;
                i = 4;
                break;
            case 3488:
                i = -1;
                i = 5;
                break;
            case 3633:
                i = -1;
                i = 6;
                break;
            case 3646:
                i = -1;
                i = 7;
                break;
            case 3669:
                i = -1;
                i = 8;
                break;
            case 3679:
                i = -1;
                i = 9;
                break;
            case 3681:
                i = -1;
                i = 10;
                break;
            case 3705:
                i = -1;
                i = 11;
                break;
            case 3710:
                i = -1;
                i = 12;
                break;
            default:
                i = -1;
        }
        switch (i) {
            case 0:
                com.airbnb.lottie.v.k.a aVar2 = e.a(cVar, dVar, i);
                break;
            case 1:
                com.airbnb.lottie.v.k.m mVar = e0.a(cVar, dVar);
                break;
            case 2:
                com.airbnb.lottie.v.k.d dVar2 = m.a(cVar, dVar);
                break;
            case 3:
                com.airbnb.lottie.v.k.n nVar = f0.a(cVar, dVar);
                break;
            case 4:
                com.airbnb.lottie.v.k.e eVar = n.a(cVar, dVar);
                break;
            case 5:
                com.airbnb.lottie.v.k.h hVar = v.a(cVar);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                com.airbnb.lottie.v.k.j jVar = a0.a(cVar, dVar);
                break;
            case 7:
                com.airbnb.lottie.v.k.k kVar = b0.a(cVar, dVar);
                break;
            case 8:
                oVar = g0.a(cVar, dVar);
                break;
            case 9:
                com.airbnb.lottie.v.k.i iVar = z.a(cVar, dVar);
                break;
            case 10:
                com.airbnb.lottie.v.k.p pVar = h0.a(cVar, dVar);
                break;
            case 11:
                com.airbnb.lottie.v.k.q qVar = i0.a(cVar, dVar);
                break;
            case 12:
                com.airbnb.lottie.v.j.l lVar = c.g(cVar, dVar);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Unknown shape type ";
                str17 = str4 + str;
                d.c(str4 + str);
        }
        while (cVar.j()) {
            cVar.H();
        }
        cVar.i();
        return oVar;
    }
}
