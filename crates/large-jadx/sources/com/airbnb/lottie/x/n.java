package com.airbnb.lottie.x;

import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.k.e;
import com.airbnb.lottie.v.k.f;
import com.airbnb.lottie.v.k.p.b;
import com.airbnb.lottie.v.k.p.c;
import com.airbnb.lottie.x.k0.c;
import com.airbnb.lottie.x.k0.c.a;
import com.airbnb.lottie.z.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class n {

    private static c.a a;
    private static final c.a b;
    private static final c.a c;
    static {
        n.a = c.a.a(/* result */);
        n.b = c.a.a(/* result */);
        n.c = c.a.a(/* result */);
    }

    static e a(c c, d d2) {
        Object dVar;
        Object singletonList;
        p.c[] valueOf;
        boolean equals;
        int values;
        int i12;
        int i6;
        int i10;
        int i15;
        int i5;
        int i4;
        int i13;
        int i2;
        int i7;
        int i8;
        int i14;
        int i11;
        int i;
        boolean z2;
        int i3;
        boolean z;
        int i9;
        dVar = c;
        singletonList = d2;
        ArrayList arrayList = new ArrayList();
        i8 = i23;
        i12 = 0;
        i6 = 0;
        i10 = 0;
        i5 = 0;
        i4 = 0;
        i13 = 0;
        i2 = 0;
        i7 = 0;
        i14 = 0;
        i11 = 0;
        i = 0;
        while (c.j()) {
            c.F();
            c.H();
            c.c();
            while (c.j()) {
                c.e();
                values = 0;
                i3 = 0;
                while (c.j()) {
                    valueOf = dVar.E(n.c);
                    if (valueOf != 0) {
                    } else {
                    }
                    i9 = i14;
                    values = c.q();
                    if (valueOf != 1) {
                    } else {
                    }
                    i3 = d.e(c, d2);
                    i14 = i9;
                    c.F();
                    c.H();
                }
                c.i();
                if (values.equals("o")) {
                } else {
                }
                if (!values.equals("d")) {
                } else {
                }
                singletonList.t(true);
                arrayList.add(i3);
                i14 = i9;
                if (values.equals("g")) {
                } else {
                }
                valueOf = 1;
                i14 = i3;
                valueOf = 1;
                valueOf = dVar.E(n.c);
                if (valueOf != 0) {
                } else {
                }
                i9 = i14;
                values = c.q();
                if (valueOf != 1) {
                } else {
                }
                i3 = d.e(c, d2);
                i14 = i9;
                c.F();
                c.H();
            }
            c.f();
            if (arrayList.size() == 1) {
            } else {
            }
            valueOf = 0;
            i14 = i9;
            arrayList.add(arrayList.get(0));
            c.e();
            values = 0;
            i3 = 0;
            while (c.j()) {
                valueOf = dVar.E(n.c);
                if (valueOf != 0) {
                } else {
                }
                i9 = i14;
                values = c.q();
                if (valueOf != 1) {
                } else {
                }
                i3 = d.e(c, d2);
                i14 = i9;
                c.F();
                c.H();
            }
            c.i();
            if (values.equals("o")) {
            } else {
            }
            if (!values.equals("d")) {
            } else {
            }
            singletonList.t(true);
            arrayList.add(i3);
            i14 = i9;
            if (values.equals("g")) {
            } else {
            }
            valueOf = 1;
            i14 = i3;
            valueOf = 1;
            valueOf = dVar.E(n.c);
            if (valueOf != 0) {
            } else {
            }
            i9 = i14;
            values = c.q();
            if (valueOf != 1) {
            } else {
            }
            i3 = d.e(c, d2);
            i14 = i9;
            c.F();
            c.H();
            valueOf = 0;
            i11 = c.k();
            i8 = (float)valueOf;
            i7 = p.c.values()[i21 -= i33];
            i2 = p.b.values()[i30 -= valueOf];
            i13 = d.e(c, d2);
            i4 = d.i(c, d2);
            i5 = d.i(c, d2);
            if (c.n() == 1) {
            } else {
            }
            valueOf = f.RADIAL;
            i6 = valueOf;
            valueOf = f.LINEAR;
            i = d.h(c, d2);
            valueOf = -1;
            c.e();
            while (c.j()) {
                values = dVar.E(n.b);
                if (values != 0) {
                } else {
                }
                i3 = i10;
                i15 = 1;
                valueOf = c.n();
                i10 = i3;
                i3 = i10;
                if (values != 1) {
                } else {
                }
                i10 = values;
                c.F();
                c.H();
            }
            i3 = i10;
            c.i();
            values = dVar.E(n.b);
            if (values != 0) {
            } else {
            }
            i3 = i10;
            i15 = 1;
            valueOf = c.n();
            i10 = i3;
            i3 = i10;
            if (values != 1) {
            } else {
            }
            i10 = values;
            c.F();
            c.H();
            i12 = c.q();
        }
        if (i == 0) {
            a aVar = new a(100);
            dVar = new d(Collections.singletonList(aVar));
            i = dVar;
        }
        super(i12, i6, i10, i, i5, i4, i13, i2, i7, i8, arrayList, i14, i11);
        return eVar2;
    }
}
