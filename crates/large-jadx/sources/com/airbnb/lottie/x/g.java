package com.airbnb.lottie.x;

import android.app.ActivityManager.ProcessErrorStateInfo;
import com.airbnb.lottie.d;
import com.airbnb.lottie.v.k.b;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.y.d;

/* loaded from: classes.dex */
class g {

    private static c.a a;
    static {
        g.a = c.a.a(/* result */);
    }

    static b a(c c, d d2) {
        int equals2;
        int i2;
        int i3;
        String str;
        int equals;
        int i;
        Object obj8;
        c.e();
        i2 = equals2;
        equals = 1;
        i = 0;
        while (c.j()) {
            i3 = c.E(g.a);
            if (i3 != equals) {
            } else {
            }
            i2 = c.n();
            equals = 1;
            i = 0;
            c.F();
            c.H();
        }
        str = i;
        if (str == null) {
            return i;
        }
        str.hashCode();
        switch (str) {
            case "el":
                equals2 = i4;
                equals2 = 0;
                break;
            case "fl":
                equals2 = i4;
                equals2 = equals;
                break;
            case "gf":
                equals2 = i4;
                break;
            case "gr":
                equals2 = i4;
                equals2 = 3;
                break;
            case "gs":
                equals2 = i4;
                equals2 = 4;
                break;
            case "mm":
                equals2 = i4;
                equals2 = 5;
                break;
            case "rc":
                equals2 = i4;
                equals2 = 6;
                break;
            case "rp":
                equals2 = i4;
                equals2 = 7;
                break;
            case "sh":
                equals2 = i4;
                equals2 = 8;
                break;
            case "sr":
                equals2 = i4;
                equals2 = 9;
                break;
            case "st":
                equals2 = i4;
                equals2 = 10;
                break;
            case "tm":
                equals2 = i4;
                equals2 = 11;
                break;
            case "tr":
                equals2 = i4;
                equals2 = 12;
                break;
            default:
                equals2 = i4;
        }
        switch (equals2) {
            case 0:
                i = e.a(c, d2, i2);
                break;
            case 1:
                i = e0.a(c, d2);
                break;
            case 2:
                i = m.a(c, d2);
                break;
            case 3:
                i = f0.a(c, d2);
                break;
            case 4:
                i = n.a(c, d2);
                break;
            case 5:
                i = v.a(c);
                d2.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                i = a0.a(c, d2);
                break;
            case 7:
                i = b0.a(c, d2);
                break;
            case 8:
                i = g0.a(c, d2);
                break;
            case 9:
                i = z.a(c, d2);
                break;
            case 10:
                i = h0.a(c, d2);
                break;
            case 11:
                i = i0.a(c, d2);
                break;
            case 12:
                i = c.g(c, d2);
                break;
            default:
                obj8 = new StringBuilder();
                obj8.append("Unknown shape type ");
                obj8.append(str);
                d.c(obj8.toString());
        }
        while (c.j() != null) {
            c.H();
        }
        c.i();
        return i;
    }
}
