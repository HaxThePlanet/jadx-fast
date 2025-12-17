package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.n1;
import f.c.a.f.a.c.d;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class z extends d<com.google.android.play.core.assetpacks.AssetPackState> {

    private final com.google.android.play.core.assetpacks.z1 g;
    private final com.google.android.play.core.assetpacks.h1 h;
    private final n1<com.google.android.play.core.assetpacks.d4> i;
    private final com.google.android.play.core.assetpacks.s0 j;
    private final com.google.android.play.core.assetpacks.k1 k;
    private final n1<Executor> l;
    private final n1<Executor> m;
    private final com.google.android.play.core.assetpacks.u2 n;
    private final Handler o;
    z(Context context, com.google.android.play.core.assetpacks.z1 z12, com.google.android.play.core.assetpacks.h1 h13, n1<com.google.android.play.core.assetpacks.d4> n14, com.google.android.play.core.assetpacks.k1 k15, com.google.android.play.core.assetpacks.s0 s06, n1<Executor> n17, n1<Executor> n18, com.google.android.play.core.assetpacks.u2 u29) {
        h hVar = new h("AssetPackServiceListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE");
        super(hVar, intentFilter, context);
        Handler obj4 = new Handler(Looper.getMainLooper());
        this.o = obj4;
        this.g = z12;
        this.h = h13;
        this.i = n14;
        this.k = k15;
        this.j = s06;
        this.l = n17;
        this.m = n18;
        this.n = u29;
    }

    @Override // f.c.a.f.a.c.d
    protected final void a(Context context, Intent intent2) {
        int size;
        Object hVar;
        int i;
        Bundle obj6 = intent2.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        int obj7 = 0;
        java.util.ArrayList stringArrayList = obj6.getStringArrayList("pack_names");
        if (obj6 != null && stringArrayList != null) {
            stringArrayList = obj6.getStringArrayList("pack_names");
            if (stringArrayList != null) {
                i = 1;
                if (stringArrayList.size() != i) {
                } else {
                    com.google.android.play.core.assetpacks.AssetPackState assetPackState = AssetPackState.i(obj6, (String)stringArrayList.get(obj7), this.k, this.n, b0.a);
                    Object[] arr = new Object[i];
                    arr[obj7] = assetPackState;
                    this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", arr);
                    obj7 = obj6.getParcelable("confirmation_intent");
                    if ((PendingIntent)obj7 != null) {
                        this.j.a((PendingIntent)obj7);
                    }
                }
                w wVar = new w(this, obj6, assetPackState);
                (Executor)this.m.zza().execute(wVar);
                v vVar = new v(this, obj6);
                (Executor)this.l.zza().execute(vVar);
            }
            this.a.b("Corrupt bundle received from broadcast.", new Object[obj7]);
        }
        this.a.b("Empty bundle received from broadcast.", new Object[obj7]);
    }

    @Override // f.c.a.f.a.c.d
    final void h(Bundle bundle) {
        boolean obj2;
        if (this.g.n(bundle)) {
            this.h.a();
        }
    }

    @Override // f.c.a.f.a.c.d
    final void i(Bundle bundle, com.google.android.play.core.assetpacks.AssetPackState assetPackState2) {
        boolean obj2;
        if (this.g.m(bundle)) {
            j(assetPackState2);
            (d4)this.i.zza().c();
        }
    }

    @Override // f.c.a.f.a.c.d
    final void j(com.google.android.play.core.assetpacks.AssetPackState assetPackState) {
        y yVar = new y(this, assetPackState);
        this.o.post(yVar);
    }
}
