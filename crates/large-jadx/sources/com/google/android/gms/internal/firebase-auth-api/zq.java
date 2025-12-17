package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public abstract class zq {

    int a;
    com.google.android.gms.internal.firebase-auth-api.ar b;
    zq(com.google.android.gms.internal.firebase-auth-api.xq xq) {
        super();
    }

    public static int l(int i) {
        return obj1 ^= i2;
    }

    public static long m(long l) {
        return obj4 ^= i2;
    }

    static com.google.android.gms.internal.firebase-auth-api.zq n(byte[] bArr, int i2, int i3, boolean z4) {
        super(bArr, 0, i3, z4, 0);
        obj7.b(i3);
        return obj7;
    }

    public abstract int a();

    public abstract int b(int i);

    public abstract int c();

    public abstract com.google.android.gms.internal.firebase-auth-api.wq d();

    public abstract String e();

    public abstract String f();

    public abstract void g(int i);

    public abstract void h(int i);

    public abstract boolean i();

    public abstract boolean j();

    public abstract boolean k(int i);
}
