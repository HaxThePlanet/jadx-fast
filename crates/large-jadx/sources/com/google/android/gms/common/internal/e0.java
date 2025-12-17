package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes2.dex */
final class e0 extends com.google.android.gms.common.internal.g0 {

    final Intent a;
    final Activity b;
    final int c;
    e0(Intent intent, Activity activity2, int i3) {
        this.a = intent;
        this.b = activity2;
        this.c = i3;
        super();
    }

    @Override // com.google.android.gms.common.internal.g0
    public final void a() {
        Activity activity;
        int i;
        final Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
