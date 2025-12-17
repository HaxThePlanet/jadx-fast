package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class a4 {

    final com.google.android.gms.internal.measurement.y a;
    final com.google.android.gms.internal.measurement.b5 b;
    final com.google.android.gms.internal.measurement.b5 c;
    final com.google.android.gms.internal.measurement.a8 d;
    public a4() {
        super();
        y yVar = new y();
        this.a = yVar;
        b5 b5Var2 = new b5(0, yVar);
        this.c = b5Var2;
        this.b = b5Var2.a();
        a8 a8Var = new a8();
        this.d = a8Var;
        hf hfVar = new hf(a8Var);
        b5Var2.g("require", hfVar);
        String str3 = "internal.platform";
        a8Var.a(str3, b3.a);
        i iVar = new i(Double.valueOf(0));
        b5Var2.g("runtime.counter", iVar);
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, com.google.android.gms.internal.measurement.u5... u52Arr2) {
        com.google.android.gms.internal.measurement.q qVar;
        int i;
        boolean z;
        qVar = q.h;
        i = 0;
        while (i < u52Arr2.length) {
            qVar = c7.a(u52Arr2[i]);
            b6.c(this.c);
            if (!qVar instanceof r) {
            } else {
            }
            qVar = this.a.a(b5, qVar);
            i++;
            if (qVar instanceof p) {
            }
        }
        return qVar;
    }
}
