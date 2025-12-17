package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Path.FillType;
import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.d;
import com.airbnb.lottie.v.k.f;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.Collections;

/* loaded from: classes.dex */
class m {

    private static final c.a a;
    private static final c.a b;
    static {
        m.a = c.a.a(/* result */);
        m.b = c.a.a(/* result */);
    }

    static d a(c c, d d2) {
        Path.FillType eVEN_ODD;
        boolean valueOf;
        int i7;
        int i5;
        boolean z;
        int i6;
        int i8;
        Path.FillType fillType;
        int i10;
        int i;
        int i2;
        int i4;
        int i9;
        Object obj14;
        Object obj15;
        fillType = eVEN_ODD;
        i4 = i2;
        i9 = i5;
        while (c.j()) {
            i5 = 1;
            c.F();
            c.H();
            i9 = c.k();
            if (c.n() == i5) {
            } else {
            }
            eVEN_ODD = Path.FillType.EVEN_ODD;
            fillType = eVEN_ODD;
            eVEN_ODD = Path.FillType.WINDING;
            i4 = d.i(c, d2);
            i2 = d.i(c, d2);
            if (c.n() == i5) {
            } else {
            }
            eVEN_ODD = f.RADIAL;
            i8 = eVEN_ODD;
            eVEN_ODD = f.LINEAR;
            i7 = d.h(c, d2);
            eVEN_ODD = -1;
            c.e();
            while (c.j()) {
                z = c.E(m.b);
                if (z != 0) {
                } else {
                }
                eVEN_ODD = c.n();
                if (z != i5) {
                } else {
                }
                i10 = d.g(c, d2, eVEN_ODD);
                c.F();
                c.H();
            }
            c.i();
            z = c.E(m.b);
            if (z != 0) {
            } else {
            }
            eVEN_ODD = c.n();
            if (z != i5) {
            } else {
            }
            i10 = d.g(c, d2, eVEN_ODD);
            c.F();
            c.H();
            i6 = c.q();
        }
        if (i7 == 0) {
            obj15 = new a(100);
            obj14 = new d(Collections.singletonList(obj15));
            i = obj14;
        } else {
            i = i7;
        }
        super(i6, i8, fillType, i10, i, i2, i4, 0, 0, i9);
        return obj14;
    }
}
