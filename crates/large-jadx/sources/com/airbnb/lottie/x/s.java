package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.l.d.a;
import com.airbnb.lottie.v.l.d.b;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {

    private static final c.a a;
    private static final c.a b;
    private static final c.a c;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[d.b.values().length];
            s.a.a = iArr;
            try {
                iArr[d.b.LUMA.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s.a.a[d.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        s.a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");
        s.b = c.a.a("d", "a");
        s.c = c.a.a("nm");
    }

    public static com.airbnb.lottie.v.l.d a(com.airbnb.lottie.d dVar) {
        Rect rect = dVar.b();
        d dVar2 = new d(Collections.emptyList(), dVar, "__container", -1L, aVar, d.a.PRE_COMP, -1, list, null, Collections.emptyList(), lVar, 0, 0.0f, 0.0f, 0, 0, rect.width(), rect.height(), null, null, Collections.emptyList(), d.b.NONE, 0, 0);
        return dVar2;
    }

    public static com.airbnb.lottie.v.l.d b(c cVar, com.airbnb.lottie.d dVar) {
        int i = 0;
        int i6;
        float f2;
        int color;
        String str2;
        String str3;
        ArrayList arrayList2;
        Object obj;
        float f3;
        d.b nONE2;
        float f;
        ArrayList arrayList3;
        c cVar2 = cVar;
        com.airbnb.lottie.d dVar22 = dVar;
        arrayList3 = new ArrayList();
        final ArrayList arrayList = new ArrayList();
        cVar.e();
        f3 = 1f;
        Float num2 = Float.valueOf(f3);
        boolean z3 = false;
        color = 0;
        f2 = 0.0f;
        Float num = Float.valueOf(f2);
        str2 = "UNSET";
        color = -1;
        color = 0;
        while (cVar.j()) {
            int i3 = 1;
            cVar.F();
            cVar.H();
            boolean z10 = cVar.k();
            String str13 = cVar.q();
            com.airbnb.lottie.v.j.b bVar3 = d.f(cVar2, dVar22, z3);
            f2 = (float)cVar.m();
            f2 = (float)cVar.m();
            color = (int)(float)cVar.n() * h.e();
            color = (int)(float)cVar.n() * h.e();
            color = (float)cVar.m();
            f2 = color;
            color = (float)cVar.m();
            f3 = color;
            cVar.c();
            ArrayList arrayList4 = new ArrayList();
            while (cVar.j()) {
                cVar.e();
                while (cVar.j()) {
                }
                cVar.i();
            }
            cVar.f();
            Object stringBuilder2 = new StringBuilder();
            str3 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ";
            str10 = str3 + arrayList4;
            dVar22.a(str10);
            cVar.e();
            while (cVar.j()) {
            }
            cVar.i();
            cVar.e();
            while (cVar.j()) {
                color = cVar2.E(s.b);
            }
            cVar.i();
            color = cVar2.E(s.b);
            cVar.c();
            while (cVar.j()) {
                com.airbnb.lottie.v.k.b bVar = g.a(cVar, dVar);
            }
            cVar.f();
            bVar = g.a(cVar, dVar);
            cVar.c();
            while (cVar.j()) {
                arrayList3.add(u.a(cVar, dVar));
            }
            dVar22.q(arrayList3.size());
            cVar.f();
            arrayList3.add(u.a(cVar, dVar));
            int i7 = cVar.n();
            l lVar2 = c.g(cVar, dVar);
            color = Color.parseColor(cVar.q());
            color = (int)(float)cVar.n() * h.e();
            color = (int)(float)cVar.n() * h.e();
            color = (long)cVar.n();
            color = cVar.n();
            String str14 = cVar.q();
            color = (long)cVar.n();
            str2 = cVar.q();
        }
        cVar.i();
        float f4 = f2 / f3;
        f = f2 / f3;
        arrayList2 = new ArrayList();
        if (f4 > f2) {
            android.view.animation.Interpolator interpolator = null;
            a aVar = new a(dVar, num, num, interpolator, 0.0f, num3);
            arrayList2.add(aVar);
            i = 0;
        } else {
        }
        if (f <= i) {
        }
        android.view.animation.Interpolator interpolator2 = null;
        dVar22 = dVar;
        a aVar2 = new a(dVar22, num2, num2, interpolator2, f4, Float.valueOf(f));
        arrayList2.add(aVar2);
        a aVar3 = new a(dVar22, num, num, interpolator2, f, 340282350000000000000000000000000000000f);
        arrayList2.add(aVar3);
        if (!str2.endsWith(".ai")) {
            if ("ai".equals(obj)) {
                str = "Convert your Illustrator layers to shape layers.";
                dVar22.a(str);
            }
        }
        dVar = new d(arrayList, dVar, str2, color, f, color, color, arrayList, color, arrayList3, color, color, color, color, f3, f2, color, color, color, color, arrayList2, nONE2, color, color);
        return dVar;
    }
}
