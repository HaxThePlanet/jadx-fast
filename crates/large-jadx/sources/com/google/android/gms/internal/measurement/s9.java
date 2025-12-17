package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class s9 {
    public static final int a(int i, Object object2, Object object3) {
        boolean obj0;
        boolean obj1;
        if ((r9)object2.isEmpty()) {
            return 0;
        } else {
            obj0 = object2.entrySet().iterator();
            if (obj0.hasNext()) {
            } else {
            }
        }
        obj0 = obj0.next();
        (Map.Entry)obj0.getKey();
        obj0.getValue();
        throw 0;
    }

    public static final Object b(Object object, Object object2) {
        boolean empty;
        com.google.android.gms.internal.measurement.r9 obj1;
        if (!(r9)object2.isEmpty() && !(r9)object.f()) {
            if (!object.f()) {
                obj1 = object.c();
            }
            obj1.e(object2);
        }
        return obj1;
    }
}
