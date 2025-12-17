package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class t5 implements Runnable {

    final String a;
    final String b;
    final String c;
    final long v;
    final com.google.android.gms.measurement.internal.u5 w;
    t5(com.google.android.gms.measurement.internal.u5 u5, String string2, String string3, String string4, long l5) {
        this.w = u5;
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.v = l5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.a;
        if (str == null) {
            u5.q2(this.w).a0().K().G(this.b, 0);
        }
        p7 p7Var = new p7(this.c, str, this.v, obj4);
        u5.q2(this.w).a0().K().G(this.b, p7Var);
    }
}
