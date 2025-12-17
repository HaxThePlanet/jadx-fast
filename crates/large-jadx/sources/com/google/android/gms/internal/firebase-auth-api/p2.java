package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class p2 {

    private static final CopyOnWriteArrayList<com.google.android.gms.internal.firebase-auth-api.n2> a;
    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        p2.a = copyOnWriteArrayList;
    }

    public static com.google.android.gms.internal.firebase-auth-api.n2 a(String string) {
        Object next;
        boolean z;
        String obj3;
        Iterator iterator = p2.a.iterator();
        for (n2 next : iterator) {
        }
        obj3 = String.valueOf(string);
        String str = "No KMS client does support: ";
        if (obj3.length() != 0) {
            obj3 = str.concat(obj3);
        } else {
            obj3 = new String(str);
        }
        GeneralSecurityException generalSecurityException = new GeneralSecurityException(obj3);
        throw generalSecurityException;
    }
}
