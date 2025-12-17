package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.i;

/* loaded from: classes2.dex */
final class f0 extends com.google.android.gms.common.internal.g0 {

    final Intent a;
    final i b;
    f0(Intent intent, i i2, int i3) {
        this.a = intent;
        this.b = i2;
        super();
    }

    @Override // com.google.android.gms.common.internal.g0
    public final void a() {
        i iVar;
        int i;
        final Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, 2);
        }
    }
}
