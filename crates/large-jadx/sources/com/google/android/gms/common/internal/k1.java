package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.b;

/* loaded from: classes2.dex */
public final class k1 extends com.google.android.gms.common.internal.u0 {

    final com.google.android.gms.common.internal.c g;
    public k1(com.google.android.gms.common.internal.c c, int i2, Bundle bundle3) {
        this.g = c;
        super(c, i2, 0);
    }

    @Override // com.google.android.gms.common.internal.u0
    protected final boolean f() {
        cVar.zzc.a(b.w);
        return 1;
    }

    @Override // com.google.android.gms.common.internal.u0
    protected final void g(b b) {
        boolean enableLocalFallback;
        if (this.g.enableLocalFallback() && c.zzg(this.g)) {
            if (c.zzg(this.g)) {
                c.zzc(this.g, 16);
            }
        }
        cVar2.zzc.a(b);
        this.g.onConnectionFailed(b);
    }
}
