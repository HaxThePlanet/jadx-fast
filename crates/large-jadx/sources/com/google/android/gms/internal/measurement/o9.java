package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class o9 implements com.google.android.gms.internal.measurement.w9 {

    private final com.google.android.gms.internal.measurement.w9[] a;
    o9(com.google.android.gms.internal.measurement.w9... w9Arr) {
        super();
        this.a = w9Arr;
    }

    public final com.google.android.gms.internal.measurement.u9 a(Class<?> class) {
        int i;
        com.google.android.gms.internal.measurement.w9 w9Var;
        boolean z;
        String obj5;
        i = 0;
        while (i < 2) {
            w9Var = this.a[i];
            i++;
        }
        obj5 = String.valueOf(class.getName());
        String str = "No factory is available for message type: ";
        if (obj5.length() != 0) {
            obj5 = str.concat(obj5);
        } else {
            obj5 = new String(str);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(obj5);
        throw unsupportedOperationException;
    }

    public final boolean b(Class<?> class) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < 2) {
            i++;
        }
        return i2;
    }
}
