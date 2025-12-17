package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class j9 extends com.google.android.gms.internal.measurement.l9 {

    private static final Class<?> c;
    static {
        j9.c = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    j9(com.google.android.gms.internal.measurement.i9 i9) {
        super(0);
    }

    @Override // com.google.android.gms.internal.measurement.l9
    final void a(Object object, long l2) {
        List unmodifiableList;
        boolean z;
        Class class;
        Object obj = hb.k(object, l2);
        if (obj instanceof h9) {
            unmodifiableList = (h9)(List)obj.a();
        } else {
            if (j9.c.isAssignableFrom(obj.getClass())) {
            }
            if (obj instanceof fa && obj instanceof c9 && (c9)obj.zzc()) {
                if (obj instanceof c9) {
                    if ((c9)obj.zzc()) {
                        obj.zzb();
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(obj);
        }
        hb.x(object, l2, obj6);
    }

    final <E> void b(Object object, Object object2, long l3) {
        int size;
        Object arrayList;
        boolean arrayList2;
        Class class;
        Object obj6;
        obj6 = hb.k(object2, l3);
        size = (List)obj6.size();
        arrayList = hb.k(object, l3);
        if ((List)arrayList.isEmpty()) {
            if (arrayList instanceof h9) {
                arrayList = new g9(size);
            } else {
                if (arrayList instanceof fa && arrayList instanceof c9) {
                    if (arrayList instanceof c9) {
                        arrayList = size;
                    } else {
                        arrayList = new ArrayList(size);
                    }
                } else {
                }
            }
            hb.x(object, l3, obj8);
        } else {
            if (j9.c.isAssignableFrom(arrayList.getClass())) {
                arrayList2 = new ArrayList(size6 += size);
                arrayList2.addAll(arrayList);
                hb.x(object, l3, obj8);
                arrayList = arrayList2;
            } else {
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0 && obj6.size() > 0) {
            if (obj6.size() > 0) {
                arrayList.addAll(obj6);
            }
        }
        if (size2 <= 0) {
        } else {
            obj6 = arrayList;
        }
        hb.x(object, l3, obj8);
    }
}
