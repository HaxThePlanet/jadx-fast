package com.airbnb.lottie.x;

import android.graphics.Path.FillType;
import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.m;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.Collections;

/* loaded from: classes.dex */
class e0 {

    private static final c.a a;
    static {
        e0.a = c.a.a(/* result */);
    }

    static m a(c c, d d2) {
        int i3;
        int valueOf;
        int i2;
        int i;
        int i5;
        int i4;
        int i7;
        int i6;
        int i8;
        Object obj10;
        Object obj11;
        final int i10 = 1;
        i8 = i5;
        i3 = i10;
        i7 = i;
        while (c.j()) {
            i2 = c.E(e0.a);
            if (i2 != 0) {
            } else {
            }
            i = c.q();
            if (i2 != i10) {
            } else {
            }
            i7 = d.c(c, d2);
            if (i2 != 2) {
            } else {
            }
            valueOf = d.h(c, d2);
            if (i2 != 3) {
            } else {
            }
            i5 = c.k();
            if (i2 != 4) {
            } else {
            }
            i3 = c.n();
            if (i2 != 5) {
            } else {
            }
            i8 = c.k();
            c.F();
            c.H();
        }
        if (valueOf == 0) {
            obj11 = new a(100);
            obj10 = new d(Collections.singletonList(obj11));
            i6 = obj10;
        } else {
            i6 = valueOf;
        }
        obj10 = i3 == i10 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
        super(i, i5, obj10, i7, i6, i8);
        return obj10;
    }
}
