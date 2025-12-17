package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.i1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class x7 implements Runnable {

    final String a;
    final String b;
    final com.google.android.gms.measurement.internal.na c;
    final boolean v;
    final i1 w;
    final com.google.android.gms.measurement.internal.w8 x;
    x7(com.google.android.gms.measurement.internal.w8 w8, String string2, String string3, com.google.android.gms.measurement.internal.na na4, boolean z5, i1 i16) {
        this.x = w8;
        this.a = string2;
        this.b = string3;
        this.c = na4;
        this.v = z5;
        this.w = i16;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th3;
        Object iterator;
        Throwable th;
        String next;
        boolean doubleValue;
        Bundle bundle = new Bundle();
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.x);
        if (g3Var == null) {
            w8Var4.a.b().r().c("Failed to get user properties; not connected to service", this.a, this.b);
            w8Var5.a.N().E(this.w, bundle);
        }
        r.j(this.c);
        final com.google.android.gms.measurement.internal.na naVar2 = this.c;
        iterator = g3Var.Z0(this.a, this.b, this.v, naVar2);
        Bundle bundle2 = new Bundle();
        if (iterator == null) {
        } else {
            iterator = iterator.iterator();
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    doubleValue = next.w;
                    if (doubleValue) {
                    } else {
                    }
                    Long num = next.v;
                    if (num != null) {
                    } else {
                    }
                    doubleValue = next.y;
                    if (doubleValue) {
                    }
                    bundle2.putDouble(next.b, doubleValue.doubleValue());
                    bundle2.putLong(next.b, num.longValue());
                    bundle2.putString(next.b, doubleValue);
                }
                next = iterator.next();
                doubleValue = next.w;
                if (doubleValue) {
                } else {
                }
                bundle2.putString(next.b, doubleValue);
                num = next.v;
                if (num != null) {
                } else {
                }
                bundle2.putLong(next.b, num.longValue());
                doubleValue = next.y;
                if (doubleValue) {
                }
                bundle2.putDouble(next.b, doubleValue.doubleValue());
                w8.N(this.x);
                w8Var2.a.N().E(this.w, bundle2);
                th = th2;
                Throwable th2 = th3;
                th3 = this.x;
                th3 = th3.a;
                th3 = th3.b();
                th3 = th3.r();
                String str3 = "Failed to get user properties; remote exception";
                th3.c(str3, this.a, th2);
                th2 = this.x;
                th2 = th2.a;
                th2 = th2.N();
                th3 = this.w;
                th2.E(th3, th);
                th3 = th2;
                th2 = th;
                th = this.x;
                th = th.a;
                th = th.N();
                str3 = this.w;
                th.E(str3, th2);
                throw th3;
            } catch (android.os.RemoteException remote) {
            } catch (Throwable th1) {
            }
        }
    }
}
