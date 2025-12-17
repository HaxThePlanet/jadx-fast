package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class r extends com.google.android.play.core.assetpacks.l<Void> {

    final int c;
    final String d;
    final int e;
    final com.google.android.play.core.assetpacks.t f;
    r(com.google.android.play.core.assetpacks.t t, o o2, int i3, String string4, int i5) {
        this.f = t;
        super(t, o2);
        this.c = i3;
        this.d = string4;
        this.e = i5;
    }

    @Override // com.google.android.play.core.assetpacks.l
    public final void c(Bundle bundle) {
        Object hVar;
        Object[] arr;
        int i;
        int obj4;
        t.r(this.f).s(this.a);
        arr = new Object[1];
        t.q().b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(bundle.getInt("error_code")));
        obj4 = this.e;
        if (obj4 > 0) {
            t.x(this.f, this.c, this.d, obj4--);
        }
    }
}
