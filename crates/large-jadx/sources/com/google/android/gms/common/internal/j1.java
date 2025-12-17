package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.b;

/* loaded from: classes2.dex */
public final class j1 extends com.google.android.gms.common.internal.u0 {

    public final IBinder g;
    final com.google.android.gms.common.internal.c h;
    public j1(com.google.android.gms.common.internal.c c, int i2, IBinder iBinder3, Bundle bundle4) {
        this.h = c;
        super(c, i2, bundle4);
        this.g = iBinder3;
    }

    @Override // com.google.android.gms.common.internal.u0
    protected final boolean f() {
        android.os.IInterface serviceInterface;
        com.google.android.gms.common.internal.c.a aVar;
        boolean iBinder;
        int equals;
        int i;
        int i3 = 0;
        IBinder iBinder2 = this.g;
        r.j(iBinder2);
        String interfaceDescriptor = iBinder2.getInterfaceDescriptor();
        if (!this.h.getServiceDescriptor().equals(interfaceDescriptor)) {
            String serviceDescriptor2 = this.h.getServiceDescriptor();
            StringBuilder stringBuilder = new StringBuilder(i5 += length2);
            stringBuilder.append("service descriptor mismatch: ");
            stringBuilder.append(serviceDescriptor2);
            stringBuilder.append(" vs. ");
            stringBuilder.append(interfaceDescriptor);
            Log.e("GmsClient", stringBuilder.toString());
            return i3;
        }
        serviceInterface = this.h.createServiceInterface(this.g);
        if (serviceInterface != null) {
            try {
                i = 4;
                if (!c.zzl(this.h, 2, i, serviceInterface)) {
                } else {
                }
                c.zzf(this.h, 0);
                if (c.zzl(this.h, 3, i, serviceInterface) && c.zzk(this.h) != null) {
                }
                c.zzf(this.h, 0);
                if (c.zzk(this.h) != null) {
                }
                c.zzk(this.h).n(this.h.getConnectionHint());
                return 1;
                return i3;
                Log.w(obj0, "service probably died");
                return obj1;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.u0
    protected final void g(b b) {
        com.google.android.gms.common.internal.c.b bVar;
        if (c.zzn(this.h) != null) {
            c.zzn(this.h).m(b);
        }
        this.h.onConnectionFailed(b);
    }
}
