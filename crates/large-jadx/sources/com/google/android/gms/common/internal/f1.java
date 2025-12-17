package com.google.android.gms.common.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.b;
import f.c.a.d.b.g.h;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class f1 extends h {

    final com.google.android.gms.common.internal.c a;
    public f1(com.google.android.gms.common.internal.c c, Looper looper2) {
        this.a = c;
        super(looper2);
    }

    private static final void a(Message message) {
        final Object obj0 = message.obj;
        (g1)obj0.a();
        obj0.d();
    }

    private static final boolean b(Message message) {
        int i;
        int obj2 = message.what;
        final int i2 = 1;
        if (obj2 != 2 && obj2 != i2 && obj2 == 7) {
            if (obj2 != i2) {
                if (obj2 == 7) {
                }
                return 0;
            }
        }
        return i2;
    }

    @Override // f.c.a.d.b.g.h
    public final void handleMessage(Message message) {
        int enableLocalFallback;
        com.google.android.gms.common.internal.c.a aVar;
        int connected;
        int arg2;
        int i2;
        int i;
        boolean obj8;
        if (cVar.zzd.get() != message.arg1 && f1.b(message)) {
            if (f1.b(message)) {
                f1.a(message);
            }
        }
        enableLocalFallback = message.what;
        int i4 = 4;
        final int i7 = 1;
        final int i8 = 5;
        if (enableLocalFallback != i7 && enableLocalFallback != 7) {
            if (enableLocalFallback != 7) {
                if (enableLocalFallback == i4) {
                    if (this.a.enableLocalFallback()) {
                        if (message.what == i8) {
                            connected = message.what;
                            int i9 = 8;
                            final int i10 = 3;
                            i = 0;
                            b bVar2 = new b(message.arg2);
                            c.zzf(this.a, bVar2);
                            if (this.a.isConnecting() && connected == i4 && c.zzg(this.a) && c.zzh(this.a)) {
                                connected = message.what;
                                i9 = 8;
                                i10 = 3;
                                i = 0;
                                if (connected == i4) {
                                    bVar2 = new b(message.arg2);
                                    c.zzf(this.a, bVar2);
                                    if (c.zzg(this.a)) {
                                        if (c.zzh(this.a)) {
                                        }
                                        c.zzi(this.a, i10, i);
                                    }
                                    if (c.zzj(this.a) != null) {
                                        obj8 = c.zzj(this.a);
                                    } else {
                                        obj8 = new b(i9);
                                    }
                                    cVar5.zzc.a(obj8);
                                    this.a.onConnectionFailed(obj8);
                                }
                                if (connected == i8) {
                                    if (c.zzj(this.a) != null) {
                                        obj8 = c.zzj(this.a);
                                    } else {
                                        obj8 = new b(i9);
                                    }
                                    cVar12.zzc.a(obj8);
                                    this.a.onConnectionFailed(obj8);
                                }
                                Object obj = message.obj;
                                if (connected == i10 && obj instanceof PendingIntent != null) {
                                    obj = message.obj;
                                    if (obj instanceof PendingIntent != null) {
                                        i = obj;
                                    }
                                    b bVar = new b(message.arg2, i);
                                    obj8.zzc.a(bVar);
                                    this.a.onConnectionFailed(bVar);
                                }
                                c.zzi(this.a, i8, i);
                                if (connected == 6 && c.zzk(this.a) != null) {
                                    c.zzi(this.a, i8, i);
                                    if (c.zzk(this.a) != null) {
                                        c.zzk(this.a).j(message.arg2);
                                    }
                                    this.a.onConnectionSuspended(message.arg2);
                                    c.zzl(this.a, i8, i7, i);
                                }
                                if (connected == 2 && this.a.isConnected()) {
                                    if (this.a.isConnected()) {
                                    }
                                    f1.a(message);
                                }
                                if (f1.b(message)) {
                                    (g1)message.obj.c();
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Don't know how to handle message: ");
                stringBuilder.append(message.what);
                Exception exception = new Exception();
                Log.wtf("GmsClient", stringBuilder.toString(), exception);
            } else {
            }
        } else {
        }
        f1.a(message);
    }
}
