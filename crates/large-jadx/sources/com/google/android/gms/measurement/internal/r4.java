package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.cf;
import java.util.List;

/* loaded from: classes2.dex */
final class r4 implements cf {

    final com.google.android.gms.measurement.internal.t4 a;
    r4(com.google.android.gms.measurement.internal.t4 t4) {
        this.a = t4;
        super();
    }

    public final void a(int i, String string2, List<String> list3, boolean z4, boolean z5) {
        int i2;
        com.google.android.gms.measurement.internal.o3 obj4;
        i--;
        final int i3 = 3;
        final int i4 = 1;
        if (obj4 != null) {
            if (obj4 != i4) {
                if (obj4 != i3) {
                    if (obj4 != 4) {
                        obj4 = obj4.a.b().u();
                    } else {
                        if (z4) {
                            obj4 = obj4.a.b().y();
                        } else {
                            if (!z5) {
                                obj4 = obj4.a.b().x();
                            } else {
                                obj4 = obj4.a.b().w();
                            }
                        }
                    }
                } else {
                    obj4 = obj4.a.b().v();
                }
            } else {
                if (z4) {
                    obj4 = obj4.a.b().t();
                } else {
                    if (!z5) {
                        obj4 = obj4.a.b().s();
                    } else {
                        obj4 = obj4.a.b().r();
                    }
                }
            }
        } else {
            obj4 = obj4.a.b().q();
        }
        int obj7 = list3.size();
        int obj8 = 0;
        int i5 = 2;
        if (obj7 != i4 && obj7 != i5 && obj7 != i3) {
            i5 = 2;
            if (obj7 != i5) {
                if (obj7 != i3) {
                    obj4.a(string2);
                }
                obj4.d(string2, list3.get(obj8), list3.get(i4), list3.get(i5));
            }
            obj4.c(string2, list3.get(obj8), list3.get(i4));
        }
        obj4.b(string2, list3.get(obj8));
    }
}
