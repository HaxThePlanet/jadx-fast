package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class l extends com.google.android.gms.internal.firebase-auth-api.m {
    l(com.google.android.gms.internal.firebase-auth-api.j j) {
        super(0);
    }

    final <L> List<L> a(Object object, long l2) {
        Object obj;
        int z;
        obj = j1.k(object, l2);
        if (!(d)obj.zzc()) {
            int size = obj.size();
            z = size == 0 ? 10 : size + size;
            j1.x(object, l2, obj5);
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.m
    final void b(Object object, long l2) {
        (d)j1.k(object, l2).zzb();
    }

    final <E> void c(Object object, Object object2, long l3) {
        Object obj;
        int size;
        boolean z;
        Object obj6;
        obj = j1.k(object, l3);
        obj6 = j1.k(object2, l3);
        final int size2 = (d)obj.size();
        size = (d)obj6.size();
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
        j1.x(object, l3, obj8);
    }
}
