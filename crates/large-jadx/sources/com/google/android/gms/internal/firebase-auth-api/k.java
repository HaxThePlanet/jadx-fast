package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class k extends com.google.android.gms.internal.firebase-auth-api.m {

    private static final Class<?> c;
    static {
        k.c = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    k(com.google.android.gms.internal.firebase-auth-api.j j) {
        super(0);
    }

    private static <L> List<L> f(Object object, long l2, int i3) {
        Object arrayList;
        boolean arrayList2;
        Class class;
        int obj6;
        arrayList = j1.k(object, l2);
        if ((List)arrayList.isEmpty()) {
            if (arrayList instanceof i) {
                arrayList = new h(obj6);
            } else {
                if (arrayList instanceof g0 && arrayList instanceof d) {
                    if (arrayList instanceof d) {
                        arrayList = obj6;
                    } else {
                        arrayList = new ArrayList(obj6);
                    }
                } else {
                }
            }
            j1.x(object, l2, i3);
        } else {
            if (k.c.isAssignableFrom(arrayList.getClass())) {
                arrayList2 = new ArrayList(size3 += obj6);
                arrayList2.addAll(arrayList);
                j1.x(object, l2, i3);
                arrayList = arrayList2;
            } else {
            }
        }
        return arrayList;
    }

    final <L> List<L> a(Object object, long l2) {
        return k.f(object, l2, obj4);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.m
    final void b(Object object, long l2) {
        List unmodifiableList;
        boolean z;
        Class class;
        Object obj = j1.k(object, l2);
        if (obj instanceof i) {
            unmodifiableList = (i)(List)obj.a();
        } else {
            if (k.c.isAssignableFrom(obj.getClass())) {
            }
            if (obj instanceof g0 && obj instanceof d && (d)obj.zzc()) {
                if (obj instanceof d) {
                    if ((d)obj.zzc()) {
                        obj.zzb();
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(obj);
        }
        j1.x(object, l2, obj6);
    }

    final <E> void c(Object object, Object object2, long l3) {
        Object obj5;
        obj5 = j1.k(object2, l3);
        List list = k.f(object, l3, obj7);
        final int size2 = list.size();
        if (size2 > 0 && obj5.size() > 0) {
            if (obj5.size() > 0) {
                list.addAll(obj5);
            }
        }
        if (size2 > 0) {
            obj5 = list;
        }
        j1.x(object, l3, obj7);
    }
}
