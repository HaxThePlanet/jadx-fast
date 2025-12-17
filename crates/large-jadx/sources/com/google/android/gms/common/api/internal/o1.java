package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class o1 implements Runnable {

    private final com.google.android.gms.common.api.internal.m1 a;
    final com.google.android.gms.common.api.internal.p1 b;
    o1(com.google.android.gms.common.api.internal.p1 p1, com.google.android.gms.common.api.internal.m1 m12) {
        this.b = p1;
        super();
        this.a = m12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!p1Var.a) {
        }
        b bVar = this.a.b();
        if (bVar.m2()) {
            com.google.android.gms.common.api.internal.p1 p1Var3 = this.b;
            android.app.PendingIntent intent = bVar.l2();
            r.j(intent);
            p1Var3.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(p1Var3.getActivity(), (PendingIntent)intent, this.a.a(), false), 1);
        }
        com.google.android.gms.common.api.internal.p1 p1Var4 = this.b;
        if (p1Var4.v.b(p1Var4.getActivity(), bVar.j2(), 0) != null) {
            com.google.android.gms.common.api.internal.p1 p1Var7 = this.b;
            p1Var7.v.r(p1Var7.getActivity(), p1Var8.mLifecycleFragment, bVar.j2(), 2, this.b);
        }
        if (bVar.j2() == 18) {
            com.google.android.gms.common.api.internal.p1 p1Var2 = this.b;
            com.google.android.gms.common.api.internal.p1 p1Var5 = this.b;
            n1 n1Var = new n1(this, p1Var2.v.u(p1Var2.getActivity(), this.b));
            p1Var5.v.v(p1Var5.getActivity().getApplicationContext(), n1Var);
        }
        p1.h(this.b, bVar, this.a.a());
    }
}
