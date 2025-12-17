package com.airbnb.lottie.x;

import android.graphics.Rect;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g;
import com.airbnb.lottie.v.c;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.h;
import com.airbnb.lottie.v.l.d;
import com.airbnb.lottie.v.l.d.a;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.h;
import d.e.d;
import d.e.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class t {

    private static final c.a a;
    static c.a b;
    private static final c.a c;
    private static final c.a d;
    static {
        t.a = c.a.a(/* result */);
        t.b = c.a.a(/* result */);
        t.c = c.a.a(/* result */);
        t.d = c.a.a(/* result */);
    }

    public static d a(c c) {
        c str;
        HashMap map;
        int i2;
        int i7;
        int i;
        int i3;
        int i5;
        HashMap hashMap;
        ArrayList arrayList;
        int i4;
        boolean z;
        Object obj;
        int int3;
        int int;
        int int2;
        int i6;
        int i9;
        int i8;
        str = c;
        float f = h.e();
        d dVar2 = new d();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap = new HashMap();
        arrayList = new ArrayList();
        h hVar = new h();
        d dVar3 = new d();
        c.e();
        i5 = i3;
        i2 = 0;
        i4 = 0;
        while (c.j()) {
            map = hashMap;
            obj = arrayList;
            c.F();
            c.H();
            hashMap = map;
            arrayList = obj;
            str = c;
            t.f(str, dVar3, arrayList);
            map = hashMap;
            obj = arrayList;
            t.c(str, dVar3, hVar);
            t.d(str, hashMap);
            t.b(str, dVar3, hashMap2, hashMap3);
            t.e(str, dVar3, arrayList2, dVar2);
            String[] split = c.q().split("\\.");
            if (!h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
            }
            dVar3.a("Lottie only supports bodymovin >= 4.4.0");
            map = hashMap;
            obj = arrayList;
            i5 = (float)hashMap;
            map = hashMap;
            obj = arrayList;
            i3 = i7 - i17;
            map = hashMap;
            obj = arrayList;
            i = (float)i7;
            map = hashMap;
            obj = arrayList;
            i4 = c.n();
            map = hashMap;
            obj = arrayList;
            i2 = c.n();
        }
        ArrayList list = arrayList;
        int i18 = 0;
        Rect rect = new Rect(i18, i18, (int)i12, (int)i16);
        dVar3.r(rect, i, i3, i5, arrayList2, dVar2, hashMap2, hashMap3, hVar, hashMap, arrayList);
        return dVar3;
    }

    private static void b(c c, d d2, Map<String, List<d>> map3, Map<String, g> map4) {
        Object arrayList;
        Object dVar;
        boolean z;
        int i7;
        int i;
        Object obj;
        int i6;
        int i4;
        int i2;
        int i5;
        int i3;
        c.c();
        while (c.j()) {
            arrayList = new ArrayList();
            dVar = new d();
            c.e();
            i4 = i6;
            i3 = i5;
            while (c.j()) {
                i7 = c.E(t.b);
                if (i7 != 0) {
                } else {
                }
                i2 = c.q();
                if (i7 != 1) {
                } else {
                }
                c.c();
                while (c.j() != 0) {
                    i7 = s.b(c, d2);
                    dVar.k(i7.b(), obj);
                    arrayList.add(i7);
                }
                c.f();
                i7 = s.b(c, d2);
                dVar.k(i7.b(), obj);
                arrayList.add(i7);
                if (i7 != 2) {
                } else {
                }
                i6 = c.n();
                if (i7 != 3) {
                } else {
                }
                i4 = c.n();
                if (i7 != 4) {
                } else {
                }
                i5 = c.q();
                if (i7 != 5) {
                } else {
                }
                i3 = c.q();
                c.F();
                c.H();
            }
            c.i();
            if (i5 != 0) {
            } else {
            }
            map3.put(i2, arrayList);
            super(i6, i4, i2, i5, i3);
            map4.put(arrayList.d(), arrayList);
            i7 = c.E(t.b);
            if (i7 != 0) {
            } else {
            }
            i2 = c.q();
            if (i7 != 1) {
            } else {
            }
            c.c();
            while (c.j() != 0) {
                i7 = s.b(c, d2);
                dVar.k(i7.b(), obj);
                arrayList.add(i7);
            }
            c.f();
            i7 = s.b(c, d2);
            dVar.k(i7.b(), obj);
            arrayList.add(i7);
            if (i7 != 2) {
            } else {
            }
            i6 = c.n();
            if (i7 != 3) {
            } else {
            }
            i4 = c.n();
            if (i7 != 4) {
            } else {
            }
            i5 = c.q();
            if (i7 != 5) {
            } else {
            }
            i3 = c.q();
            c.F();
            c.H();
        }
        c.f();
    }

    private static void c(c c, d d2, h<d> h3) {
        d dVar;
        int i;
        c.c();
        while (c.j()) {
            dVar = j.a(c, d2);
            h3.j(dVar.hashCode(), dVar);
        }
        c.f();
    }

    private static void d(c c, Map<String, c> map2) {
        int i;
        String str;
        c.e();
        while (c.j()) {
            if (c.E(t.c) != 0) {
            } else {
            }
            c.c();
            while (c.j()) {
                i = k.a(c);
                map2.put(i.b(), i);
            }
            c.f();
            i = k.a(c);
            map2.put(i.b(), i);
            c.F();
            c.H();
        }
        c.i();
    }

    private static void e(c c, d d2, List<d> list3, d<d> d4) {
        int i;
        int string;
        long str;
        d.a iMAGE;
        c.c();
        i = 0;
        while (c.j()) {
            d dVar = s.b(c, d2);
            iMAGE = d.a.IMAGE;
            if (dVar.d() == iMAGE) {
            }
            list3.add(dVar);
            d4.k(dVar.b(), iMAGE);
            if (i > 4) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("You have ");
            stringBuilder.append(i);
            stringBuilder.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            d.c(stringBuilder.toString());
            i++;
        }
        c.f();
    }

    private static void f(c c, d d2, List<h> list3) {
        int i;
        int i2;
        h hVar;
        int i3;
        int obj5;
        c.c();
        while (c.j()) {
            obj5 = 0;
            c.e();
            i2 = i;
            while (c.j()) {
                hVar = c.E(t.d);
                if (hVar != 0) {
                } else {
                }
                obj5 = c.q();
                if (hVar != 1) {
                } else {
                }
                i = (float)hVar;
                if (hVar != 2) {
                } else {
                }
                i2 = (float)d;
                c.F();
                c.H();
            }
            c.i();
            hVar = new h(obj5, i, i2);
            list3.add(hVar);
            hVar = c.E(t.d);
            if (hVar != 0) {
            } else {
            }
            obj5 = c.q();
            if (hVar != 1) {
            } else {
            }
            i = (float)hVar;
            if (hVar != 2) {
            } else {
            }
            i2 = (float)d;
            c.F();
            c.H();
        }
        c.f();
    }
}
