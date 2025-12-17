package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class t {
    public static final int a(int i, Object object2, Object object3) {
        boolean obj0;
        boolean obj1;
        if ((s)object2.isEmpty()) {
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

    public static final boolean b(Object object) {
        if (!(s)object.f()) {
            return 1;
        }
        return 0;
    }

    public static final Object c(Object object, Object object2) {
        boolean empty;
        com.google.android.gms.internal.firebase-auth-api.s obj1;
        if (!(s)object2.isEmpty() && !(s)object.f()) {
            if (!object.f()) {
                obj1 = object.c();
            }
            obj1.e(object2);
        }
        return obj1;
    }
}
