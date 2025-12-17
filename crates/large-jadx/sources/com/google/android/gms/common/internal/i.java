package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public abstract class i {

    private static int a = 4225;
    private static final Object b;
    private static com.google.android.gms.common.internal.i c;
    static {
        Object object = new Object();
        i.b = object;
    }

    public static int a() {
        return i.a;
    }

    public static com.google.android.gms.common.internal.i b(Context context) {
        com.google.android.gms.common.internal.i t1Var;
        Object obj2;
        final Object obj = i.b;
        synchronized (obj) {
            t1Var = new t1(context.getApplicationContext());
            i.c = t1Var;
            return i.c;
        }
    }

    public final void c(String string, String string2, int i3, ServiceConnection serviceConnection4, String string5, boolean z6) {
        p1 p1Var = new p1(string, string2, i3, z6);
        e(p1Var, serviceConnection4, string5);
    }

    protected abstract boolean d(com.google.android.gms.common.internal.p1 p1, ServiceConnection serviceConnection2, String string3);

    protected abstract void e(com.google.android.gms.common.internal.p1 p1, ServiceConnection serviceConnection2, String string3);
}
