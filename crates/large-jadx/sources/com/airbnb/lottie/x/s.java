package com.airbnb.lottie.x;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.l.d;
import com.airbnb.lottie.v.l.d.a;
import com.airbnb.lottie.v.l.d.b;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class s {

    private static final c.a a;
    private static final c.a b;
    private static final c.a c;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            s.a.a = iArr;
            iArr[d.b.LUMA.ordinal()] = 1;
            s.a.a[d.b.LUMA_INVERTED.ordinal()] = 2;
        }
    }
    static {
        s.a = c.a.a(/* result */);
        s.b = c.a.a(/* result */);
        s.c = c.a.a(/* result */);
    }

    public static d a(d d) {
        Rect rect = d.b();
        l lVar = new l();
        super(Collections.emptyList(), d, "__container", -1, obj5, d.a.PRE_COMP, -1, obj8, 0, Collections.emptyList(), lVar, 0, 0, 0, 0, 0, rect.width(), rect.height(), 0, 0, Collections.emptyList(), d.b.NONE, 0, 0);
        return dVar3;
    }

    public static d b(c c, d d2) {
        int i20;
        float cmp;
        boolean endsWith;
        int i6;
        int i13;
        int i21;
        Float i19;
        int string;
        int z2;
        String stringBuilder;
        boolean z;
        String ordinal;
        Object arrayList;
        ArrayList list;
        a i12;
        String str;
        int i8;
        int i15;
        int uNKNOWN;
        int i16;
        int i2;
        int i4;
        int i9;
        int i11;
        int color;
        int i3;
        int i5;
        int i17;
        int i10;
        int i;
        int i18;
        d.b bVar;
        int i23;
        int i7;
        float i22;
        ArrayList list2;
        Float valueOf;
        c cVar = c;
        d dVar4 = d2;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c.e();
        int i25 = 1065353216;
        Float valueOf4 = Float.valueOf(i25);
        i19 = 0;
        i12 = 0;
        Float valueOf5 = Float.valueOf(i12);
        bVar = nONE;
        i3 = i25;
        i7 = i10;
        i5 = i21;
        i16 = i48;
        i15 = i45;
        i8 = i23;
        str = stringBuilder;
        while (c.j()) {
            stringBuilder = 1;
            c.F();
            c.H();
            i7 = c.k();
            i8 = c.q();
            i23 = d.f(cVar, dVar4, i19);
            i21 = (float)string;
            i13 = (float)string;
            i10 = string;
            i17 = string;
            i5 = string;
            i3 = string;
            c.c();
            ArrayList arrayList2 = new ArrayList();
            while (c.j()) {
                c.e();
                while (c.j() != null) {
                    if (cVar.E(s.c)) {
                    } else {
                    }
                    arrayList2.add(c.q());
                    c.F();
                    c.H();
                }
                c.i();
                if (cVar.E(s.c)) {
                } else {
                }
                arrayList2.add(c.q());
                c.F();
                c.H();
            }
            c.f();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
            stringBuilder.append(arrayList2);
            dVar4.a(stringBuilder.toString());
            c.e();
            while (c.j() != null) {
                if (cVar.E(s.c)) {
                } else {
                }
                arrayList2.add(c.q());
                c.F();
                c.H();
            }
            c.i();
            if (cVar.E(s.c)) {
            } else {
            }
            arrayList2.add(c.q());
            c.F();
            c.H();
            c.e();
            while (c.j() != 0) {
                string = cVar.E(s.b);
                if (string != null) {
                } else {
                }
                i = d.d(c, d2);
                if (string != stringBuilder) {
                } else {
                }
                c.c();
                if (c.j()) {
                }
                while (c.j() != 0) {
                    c.H();
                }
                c.f();
                c.H();
                i18 = string;
                c.F();
                c.H();
            }
            c.i();
            string = cVar.E(s.b);
            if (string != null) {
            } else {
            }
            i = d.d(c, d2);
            if (string != stringBuilder) {
            } else {
            }
            c.c();
            if (c.j()) {
            }
            while (c.j() != 0) {
                c.H();
            }
            c.f();
            c.H();
            i18 = string;
            c.F();
            c.H();
            c.c();
            while (c.j() != 0) {
                string = g.a(c, d2);
                if (string != null) {
                }
                arrayList3.add(string);
            }
            c.f();
            string = g.a(c, d2);
            if (string != null) {
            }
            arrayList3.add(string);
            c.c();
            while (c.j()) {
                arrayList4.add(u.a(c, d2));
            }
            dVar4.q(arrayList4.size());
            c.f();
            arrayList4.add(u.a(c, d2));
            int i28 = c.n();
            if (i28 >= values.length) {
            } else {
            }
            string = s.a.a[d.b.values()[i28].ordinal()];
            if (string != stringBuilder) {
            } else {
            }
            dVar4.a("Unsupported matte type: Luma");
            dVar4.q(stringBuilder);
            if (string != 2) {
            } else {
            }
            dVar4.a("Unsupported matte type: Luma Inverted");
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported matte type: ");
            stringBuilder.append(i28);
            dVar4.a(stringBuilder.toString());
            i4 = c.g(c, d2);
            color = Color.parseColor(c.q());
            i11 = string;
            i9 = string;
            i16 = string;
            string = c.n();
            if (string < d.a.UNKNOWN.ordinal()) {
            }
            uNKNOWN = d.a.values()[string];
            i2 = c.q();
            i15 = string;
            str = c.q();
        }
        c.i();
        int i57 = i13 / i3;
        arrayList = new ArrayList();
        if (Float.compare(i57, i12) > 0) {
            list2 = arrayList4;
            super(d2, valueOf5, valueOf5, 0, 0, Float.valueOf(i57));
            arrayList.add(aVar6);
            i20 = 0;
        } else {
            list2 = arrayList4;
            list = arrayList;
            i20 = i12;
        }
        if (Float.compare(i22, i20) > 0) {
        } else {
            i22 = cmp;
        }
        int i26 = 0;
        d dVar2 = d2;
        super(dVar2, valueOf4, valueOf4, i26, i57, Float.valueOf(i22));
        list.add(aVar9);
        float f5 = i22;
        super(dVar2, valueOf5, valueOf5, i26, f5, 340282350000000000000000000000000000000f);
        list.add(aVar8);
        if (!str.endsWith(".ai")) {
            if ("ai".equals(i8)) {
                dVar4.a("Convert your Illustrator layers to shape layers.");
            }
        } else {
        }
        super(arrayList3, d2, str, i15, f5, uNKNOWN, i16, arrayList3, i2, list2, i4, i9, i11, color, i3, i5, i17, i10, i, i18, list, bVar, i23, i7);
        return dVar5;
    }
}
