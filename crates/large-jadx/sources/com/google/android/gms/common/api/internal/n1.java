package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes2.dex */
final class n1 extends com.google.android.gms.common.api.internal.n0 {

    final Dialog a;
    final com.google.android.gms.common.api.internal.o1 b;
    n1(com.google.android.gms.common.api.internal.o1 o1, Dialog dialog2) {
        this.b = o1;
        this.a = dialog2;
        super();
    }

    @Override // com.google.android.gms.common.api.internal.n0
    public final void a() {
        boolean showing;
        p1.g(o1Var.b);
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
