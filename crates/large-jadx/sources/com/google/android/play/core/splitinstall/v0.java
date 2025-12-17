package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.h;

/* loaded from: classes2.dex */
final class v0 implements com.google.android.play.core.splitinstall.f0 {

    final com.google.android.play.core.splitinstall.d a;
    final Intent b;
    final Context c;
    final com.google.android.play.core.splitinstall.x0 d;
    v0(com.google.android.play.core.splitinstall.x0 x0, com.google.android.play.core.splitinstall.d d2, Intent intent3, Context context4) {
        this.d = x0;
        this.a = d2;
        this.b = intent3;
        this.c = context4;
        super();
    }

    @Override // com.google.android.play.core.splitinstall.f0
    public final void a(int i) {
        x0.j(this.d, this.a, 6, i);
    }

    @Override // com.google.android.play.core.splitinstall.f0
    public final void zza() {
        x0.j(this.d, this.a, 5, 0);
    }

    @Override // com.google.android.play.core.splitinstall.f0
    public final void zzc() {
        String str = "triggered_from_app_after_verification";
        int i = 0;
        if (!this.b.getBooleanExtra(str, i)) {
            this.b.putExtra(str, true);
            this.c.sendBroadcast(this.b);
        }
        x0.h(this.d).b("Splits copied and verified more than once.", new Object[i]);
    }
}
