package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
final class p implements com.google.android.gms.internal.firebase-auth-api.w {

    private final com.google.android.gms.internal.firebase-auth-api.w[] a;
    p(com.google.android.gms.internal.firebase-auth-api.w... wArr) {
        super();
        this.a = wArr;
    }

    public final com.google.android.gms.internal.firebase-auth-api.v a(Class<?> class) {
        int i;
        com.google.android.gms.internal.firebase-auth-api.w wVar;
        boolean z;
        String obj5;
        i = 0;
        while (i < 2) {
            wVar = this.a[i];
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
