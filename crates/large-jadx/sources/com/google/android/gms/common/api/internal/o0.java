package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes2.dex */
public final class o0 extends BroadcastReceiver {

    Context a;
    private final com.google.android.gms.common.api.internal.n0 b;
    public o0(com.google.android.gms.common.api.internal.n0 n0) {
        super();
        this.b = n0;
    }

    @Override // android.content.BroadcastReceiver
    public final void a(Context context) {
        this.a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void b() {
        Context context = this.a;
        synchronized (this) {
            try {
                context.unregisterReceiver(this);
                this.a = 0;
                throw th;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        String obj1;
        obj1 = intent2.getData();
        if (obj1 != null) {
            obj1 = obj1.getSchemeSpecificPart();
        } else {
            obj1 = 0;
        }
        if ("com.google.android.gms".equals(obj1)) {
            this.b.a();
            b();
        }
    }
}
