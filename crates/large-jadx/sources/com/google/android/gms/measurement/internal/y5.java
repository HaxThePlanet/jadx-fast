package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class y5 {
    public static <T> T a(Bundle bundle, String string2, Class<T> class3, T t4) {
        Object obj2 = bundle.get(string2);
        if (obj2 == null) {
            return t4;
        }
        if (!class3.isAssignableFrom(obj2.getClass())) {
        } else {
            return obj2;
        }
        Object[] arr = new Object[3];
        IllegalStateException obj5 = new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", string2, class3.getCanonicalName(), obj2.getClass().getCanonicalName()));
        throw obj5;
    }

    public static void b(Bundle bundle, Object object2) {
        final String str = "value";
        if (object2 instanceof Double) {
            bundle.putDouble(str, (Double)object2.doubleValue());
        }
        if (object2 instanceof Long) {
            bundle.putLong(str, (Long)object2.longValue());
        }
        bundle.putString(str, object2.toString());
    }
}
