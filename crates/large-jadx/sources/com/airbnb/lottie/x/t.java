package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Rect;
import com.airbnb.lottie.g;
import com.airbnb.lottie.v.l.d.a;
import com.airbnb.lottie.x.k0.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t {

    private static final c.a a;
    static c.a b;
    private static final c.a c;
    private static final c.a d;
    static {
        t.a = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
        t.b = c.a.a("id", "layers", "w", "h", "p", "u");
        t.c = c.a.a("list");
        t.d = c.a.a("cm", "tm", "dr");
    }

    public static com.airbnb.lottie.d a(com.airbnb.lottie.x.k0.c cVar) {
        com.airbnb.lottie.x.k0.c cVar2;
        HashMap hashMap;
        int i = 0;
        int i2 = 2;
        int i3;
        ArrayList arrayList;
        int i4 = 0;
        String str;
        int parsed;
        int parsed2;
        int parsed3;
        int i5;
        int i6;
        int i7;
        cVar2 = cVar;
        float f = h.e();
        final d.e.d dVar2 = new d();
        final ArrayList arrayList2 = new ArrayList();
        final HashMap hashMap2 = new HashMap();
        final HashMap hashMap3 = new HashMap();
        hashMap = new HashMap();
        arrayList = new ArrayList();
        final d.e.h hVar = new h();
        final com.airbnb.lottie.d dVar = new d();
        cVar.e();
        i = 0;
        i4 = 0;
        while (cVar.j()) {
            cVar.F();
            cVar.H();
            cVar2 = cVar;
            t.f(cVar2, dVar, arrayList);
            t.c(cVar2, dVar, hVar);
            t.d(cVar2, hashMap);
            t.b(cVar2, dVar, hashMap2, hashMap3);
            t.e(cVar2, dVar, arrayList2, dVar2);
            String[] parts = cVar.q().split("\\.");
            i2 = 2;
            i5 = 4;
            i6 = 4;
            i7 = 0;
            float f9 = (float)cVar.m();
            float f8 = (float)cVar.m() - 0.01f;
            float f7 = (float)cVar.m();
            i4 = cVar.n();
            i = cVar.n();
        }
        int i14 = 0;
        dVar.r(new Rect(i14, i14, (int)(float)i * f, (int)(float)i4 * f), i3, i3, i3, arrayList2, dVar2, hashMap2, hashMap3, hVar, hashMap, arrayList);
        return dVar;
    }

    private static void b(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, Map<String, List<com.airbnb.lottie.v.l.d>> map, Map<String, g> map2) {
        int i2 = 0;
        Object gVar;
        int i;
        String str;
        String str2;
        String str3;
        cVar.c();
        while (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            cVar.e();
            i = 0;
            i2 = 0;
            while (cVar.j()) {
                i = cVar.E(t.b);
            }
            cVar.i();
            i = cVar.E(t.b);
        }
        cVar.f();
    }

    private static void c(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, d.e.h<com.airbnb.lottie.v.d> hVar) {
        cVar.c();
        while (cVar.j()) {
            com.airbnb.lottie.v.d dVar2 = j.a(cVar, dVar);
            hVar.j(dVar2.hashCode(), dVar2);
        }
        cVar.f();
    }

    private static void d(com.airbnb.lottie.x.k0.c cVar, Map<String, com.airbnb.lottie.v.c> map) {
        String str;
        cVar.e();
        while (cVar.j()) {
        }
        cVar.i();
    }

    private static void e(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, List<com.airbnb.lottie.v.l.d> list, d.e.d<com.airbnb.lottie.v.l.d> dVar2) {
        int i = 0;
        cVar.c();
        i = 0;
        while (cVar.j()) {
            com.airbnb.lottie.v.l.d dVar3 = s.b(cVar, dVar);
            iMAGE2 = d.a.IMAGE;
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "You have ";
            String str3 = " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.";
            str = str2 + i + str3;
            d.c(str);
        }
        cVar.f();
    }

    private static void f(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, List<com.airbnb.lottie.v.h> list) {
        int i = 0;
        com.airbnb.lottie.v.h hVar;
        int i2;
        String str = null;
        cVar.c();
        while (cVar.j()) {
            int i4 = 0;
            cVar.e();
            i = 0;
            while (cVar.j()) {
                int i3 = cVar.E(t.d);
            }
            cVar.i();
            list.add(new h(str, i, i));
            i3 = cVar.E(t.d);
        }
        cVar.f();
    }
}
