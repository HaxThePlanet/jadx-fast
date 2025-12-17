package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
abstract class l9 {

    private static final com.google.android.gms.internal.measurement.l9 a;
    private static final com.google.android.gms.internal.measurement.l9 b;
    static {
        final int i = 0;
        j9 j9Var = new j9(i);
        l9.a = j9Var;
        k9 k9Var = new k9(i);
        l9.b = k9Var;
    }

    l9(com.google.android.gms.internal.measurement.i9 i9) {
        super();
    }

    static com.google.android.gms.internal.measurement.l9 c() {
        return l9.a;
    }

    static com.google.android.gms.internal.measurement.l9 d() {
        return l9.b;
    }

    abstract void a(Object object, long l2);

    abstract <L> void b(Object object, Object object2, long l3);
}
