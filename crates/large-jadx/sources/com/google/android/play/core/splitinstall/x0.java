package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.h;
import f.c.a.f.a.c.a;
import f.c.a.f.a.c.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class x0 extends d<com.google.android.play.core.splitinstall.d> {

    private static com.google.android.play.core.splitinstall.x0 j;
    private final Handler g;
    private final com.google.android.play.core.splitinstall.g0 h;
    private final Set<com.google.android.play.core.splitinstall.e> i;
    static {
    }

    public x0(Context context, com.google.android.play.core.splitinstall.g0 g02) {
        h hVar = new h("SplitInstallListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService");
        super(hVar, intentFilter, context);
        Handler obj4 = new Handler(Looper.getMainLooper());
        this.g = obj4;
        obj4 = new LinkedHashSet();
        this.i = obj4;
        this.h = g02;
    }

    static h h(com.google.android.play.core.splitinstall.x0 x0) {
        return x0.a;
    }

    public static com.google.android.play.core.splitinstall.x0 i(Context context) {
        com.google.android.play.core.splitinstall.x0 x0Var;
        com.google.android.play.core.splitinstall.o0 zza;
        final Class<com.google.android.play.core.splitinstall.x0> obj = x0.class;
        synchronized (obj) {
            x0Var = new x0(context, o0.zza);
            x0.j = x0Var;
            return x0.j;
        }
    }

    static void j(com.google.android.play.core.splitinstall.x0 x0, com.google.android.play.core.splitinstall.d d2, int i3, int i4) {
        w0 w0Var = new w0(x0, d2, i3, i4);
        x0.g.post(w0Var);
    }

    @Override // f.c.a.f.a.c.d
    protected final void a(Context context, Intent intent2) {
        android.os.Bundle bundleExtra = intent2.getBundleExtra("session_state");
        if (bundleExtra == null) {
        }
        com.google.android.play.core.splitinstall.d dVar = d.n(bundleExtra);
        Object[] arr = new Object[1];
        this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", dVar);
        com.google.android.play.core.splitinstall.h0 h0Var = this.h.zza();
        if (dVar.i() == 3 && h0Var != null) {
            if (h0Var != null) {
                v0 v0Var = new v0(this, dVar, intent2, context);
                h0Var.a(dVar.m(), v0Var);
            }
        }
        k(dVar);
    }

    @Override // f.c.a.f.a.c.d
    public final void k(com.google.android.play.core.splitinstall.d d) {
        Set next;
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.i);
        Iterator iterator = linkedHashSet.iterator();
        synchronized (this) {
            try {
                for (e next : iterator) {
                    next.a(d);
                }
                (e)iterator.next().a(d);
                super.f(d);
                throw d;
            }
        }
    }
}
