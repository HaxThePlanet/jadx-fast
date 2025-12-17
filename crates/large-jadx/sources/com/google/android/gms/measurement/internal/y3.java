package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class y3 extends BroadcastReceiver {

    private final com.google.android.gms.measurement.internal.ba a;
    private boolean b;
    private boolean c;
    static {
        final Class<com.google.android.gms.measurement.internal.y3> obj = y3.class;
    }

    y3(com.google.android.gms.measurement.internal.ba ba) {
        super();
        r.j(ba);
        this.a = ba;
    }

    static com.google.android.gms.measurement.internal.ba a(com.google.android.gms.measurement.internal.y3 y3) {
        return y3.a;
    }

    @Override // android.content.BroadcastReceiver
    public final void b() {
        this.a.g();
        this.a.a().h();
        if (this.b) {
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.a.f().registerReceiver(this, intentFilter);
        this.c = this.a.W().m();
        this.a.b().v().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.c));
        this.b = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void c() {
        boolean z;
        com.google.android.gms.measurement.internal.ba baVar;
        String str;
        this.a.g();
        this.a.a().h();
        this.a.a().h();
        if (this.b) {
            this.a.b().v().a("Unregistering connectivity change receiver");
            int i = 0;
            this.b = i;
            this.c = i;
            this.a.f().unregisterReceiver(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        Object x3Var;
        boolean obj3;
        this.a.g();
        String obj2 = intent2.getAction();
        this.a.b().v().b("NetworkBroadcastReceiver received action", obj2);
        obj2 = this.a.W().m();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(obj2) && this.c != obj2) {
            obj2 = this.a.W().m();
            if (this.c != obj2) {
                this.c = obj2;
                x3Var = new x3(this, obj2);
                this.a.a().z(x3Var);
            }
        }
        this.a.b().w().b("NetworkBroadcastReceiver received unknown action", obj2);
    }
}
