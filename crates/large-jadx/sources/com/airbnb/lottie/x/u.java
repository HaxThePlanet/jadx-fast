package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import com.airbnb.lottie.d;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.v.k.g.a;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.y.d;

/* loaded from: classes.dex */
class u {
    static g a(c c, d d2) {
        int mASK_MODE_INTERSECT;
        String equals;
        int i4;
        int i7;
        int i3;
        String str;
        int str2;
        int equals2;
        int i5;
        int i2;
        int i;
        int i6;
        c.e();
        final int i8 = 0;
        i3 = i8;
        i7 = i4;
        while (c.j()) {
            str = c.o();
            str.hashCode();
            i2 = 2;
            i = 1;
            i6 = -1;
            str2 = i6;
            c.H();
            equals = c.q();
            equals.hashCode();
            i5 = i6;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown mask mode ");
            stringBuilder.append(str);
            stringBuilder.append(". Defaulting to Add.");
            d.c(stringBuilder.toString());
            mASK_MODE_INTERSECT = g.a.MASK_MODE_ADD;
            mASK_MODE_INTERSECT = g.a.MASK_MODE_SUBTRACT;
            mASK_MODE_INTERSECT = g.a.MASK_MODE_NONE;
            d2.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
            mASK_MODE_INTERSECT = g.a.MASK_MODE_INTERSECT;
            mASK_MODE_INTERSECT = g.a.MASK_MODE_ADD;
            if (equals.equals("s") == null) {
            }
            if (equals.equals("n") == null) {
            } else {
            }
            i5 = i2;
            if (equals.equals("i") == null) {
            } else {
            }
            i5 = i;
            if (equals.equals("a") == null) {
            } else {
            }
            i5 = i8;
            i3 = c.k();
            i4 = d.k(c, d2);
            i7 = d.h(c, d2);
            if (str.equals("mode") == 0) {
            } else {
            }
            str2 = i5;
            if (str.equals("inv") == 0) {
            } else {
            }
            str2 = i2;
            if (str.equals("pt") == 0) {
            } else {
            }
            str2 = i;
            if (str.equals("o") == 0) {
            } else {
            }
            str2 = i8;
        }
        c.i();
        g obj11 = new g(mASK_MODE_INTERSECT, i4, i7, i3);
        return obj11;
    }
}
