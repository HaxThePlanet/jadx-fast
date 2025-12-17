package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class p {

    final String a;
    final String b;
    final String c = null;
    final long d;
    final long e;
    final com.google.android.gms.measurement.internal.s f;
    p(com.google.android.gms.measurement.internal.b5 b5, String string2, String string3, String string4, long l5, long l6, Bundle bundle7) {
        com.google.android.gms.measurement.internal.s obj3;
        int obj4;
        Object obj5;
        boolean obj6;
        long obj7;
        Object obj8;
        super();
        r.f(string3);
        r.f(string4);
        this.a = string3;
        this.b = string4;
        obj4 = 0;
        this.d = l5;
        this.e = bundle7;
        if (Long.compare(bundle7, i2) != 0 && Long.compare(bundle7, l5) > 0) {
            if (Long.compare(bundle7, l5) > 0) {
                b5.b().w().b("Event created with reverse previous/current timestamps. appId", q3.z(string3));
            }
        }
        if (obj11 != null && !obj11.isEmpty()) {
            if (!obj11.isEmpty()) {
                obj4 = new Bundle(obj11);
                obj5 = obj4.keySet().iterator();
                while (obj5.hasNext()) {
                    obj6 = obj5.next();
                    if (!(String)obj6) {
                    } else {
                    }
                    obj7 = b5.N().o(obj6, obj4.get((String)obj6));
                    if (obj7 == 0) {
                    } else {
                    }
                    b5.N().B(obj4, obj6, obj7);
                    b5.b().w().b("Param value can't be null", b5.D().e(obj6));
                    obj5.remove();
                    b5.b().r().a("Param name can't be null");
                    obj5.remove();
                }
                obj3 = new s(obj4);
            } else {
                obj4 = new Bundle();
                obj3 = new s(obj4);
            }
        } else {
        }
        this.f = obj3;
    }

    private p(com.google.android.gms.measurement.internal.b5 b5, String string2, String string3, String string4, long l5, long l6, com.google.android.gms.measurement.internal.s s7) {
        com.google.android.gms.measurement.internal.o3 obj3;
        int obj4;
        Object obj5;
        String obj6;
        super();
        r.f(string3);
        r.f(string4);
        r.j(obj11);
        this.a = string3;
        this.b = string4;
        obj4 = 0;
        this.d = l5;
        this.e = s7;
        if (Long.compare(s7, i) != 0 && Long.compare(s7, l5) > 0) {
            if (Long.compare(s7, l5) > 0) {
                b5.b().w().c("Event created with reverse previous/current timestamps. appId, name", q3.z(string3), q3.z(string4));
            }
        }
        this.f = obj11;
    }

    final com.google.android.gms.measurement.internal.p a(com.google.android.gms.measurement.internal.b5 b5, long l2) {
        super(b5, this.c, this.a, this.b, this.d, obj6, l2, obj8, this.f);
        return pVar2;
    }

    public final String toString() {
        String str = this.a;
        final String str4 = this.b;
        String string2 = this.f.toString();
        StringBuilder stringBuilder = new StringBuilder(i3 += length3);
        stringBuilder.append("Event{appId='");
        stringBuilder.append(str);
        stringBuilder.append("', name='");
        stringBuilder.append(str4);
        stringBuilder.append("', params=");
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
