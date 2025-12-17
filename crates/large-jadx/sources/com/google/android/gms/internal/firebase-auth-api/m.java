package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
abstract class m {

    private static final com.google.android.gms.internal.firebase-auth-api.m a;
    private static final com.google.android.gms.internal.firebase-auth-api.m b;
    static {
        final int i = 0;
        k kVar = new k(i);
        m.a = kVar;
        l lVar = new l(i);
        m.b = lVar;
    }

    m(com.google.android.gms.internal.firebase-auth-api.j j) {
        super();
    }

    static com.google.android.gms.internal.firebase-auth-api.m d() {
        return m.a;
    }

    static com.google.android.gms.internal.firebase-auth-api.m e() {
        return m.b;
    }

    abstract <L> List<L> a(Object object, long l2);

    abstract void b(Object object, long l2);

    abstract <L> void c(Object object, Object object2, long l3);
}
