package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
final class k9 extends com.google.android.gms.internal.measurement.l9 {
    k9(com.google.android.gms.internal.measurement.i9 i9) {
        super(0);
    }

    @Override // com.google.android.gms.internal.measurement.l9
    final void a(Object object, long l2) {
        (c9)hb.k(object, l2).zzb();
    }

    final <E> void b(Object object, Object object2, long l3) {
        Object obj;
        int size;
        boolean z;
        Object obj6;
        obj = hb.k(object, l3);
        obj6 = hb.k(object2, l3);
        final int size2 = (c9)obj.size();
        size = (c9)obj6.size();
        if (size2 > 0 && size > 0 && !obj.zzc()) {
            if (size > 0) {
                if (!obj.zzc()) {
                    obj = obj.f(size += size2);
                }
                obj.addAll(obj6);
            }
        }
        if (size2 <= 0) {
        } else {
            obj6 = obj;
        }
        hb.x(object, l3, obj8);
    }
}
