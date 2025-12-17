package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
public final class o3 {

    private final int a;
    private final boolean b;
    private final boolean c;
    final com.google.android.gms.measurement.internal.q3 d;
    o3(com.google.android.gms.measurement.internal.q3 q3, int i2, boolean z3, boolean z4) {
        this.d = q3;
        super();
        this.a = i2;
        this.b = z3;
        this.c = z4;
    }

    public final void a(String string) {
        this.d.F(this.a, this.b, this.c, string, 0, 0, 0);
    }

    public final void b(String string, Object object2) {
        this.d.F(this.a, this.b, this.c, string, object2, 0, 0);
    }

    public final void c(String string, Object object2, Object object3) {
        this.d.F(this.a, this.b, this.c, string, object2, object3, 0);
    }

    public final void d(String string, Object object2, Object object3, Object object4) {
        this.d.F(this.a, this.b, this.c, string, object2, object3, object4);
    }
}
