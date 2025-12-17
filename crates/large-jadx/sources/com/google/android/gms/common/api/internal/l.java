package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.c.c;
import com.google.android.gms.common.internal.c.e;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l implements a.f, ServiceConnection {

    private boolean A;
    private String B;
    private final String a;
    private final String b;
    private final ComponentName c;
    private final Context v;
    private final com.google.android.gms.common.api.internal.f w;
    private final Handler x;
    private final com.google.android.gms.common.api.internal.m y;
    private IBinder z;
    static {
        final Class<com.google.android.gms.common.api.internal.l> obj = l.class;
    }

    private final void a() {
        if (Thread.currentThread() != this.x.getLooper().getThread()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        throw illegalStateException;
    }

    private final void f(String string) {
        string.length();
        String.valueOf(String.valueOf(this.z)).length();
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void c(String string) {
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void connect(c.c c$c) {
        boolean bindService;
        Object package;
        Context context;
        String str;
        boolean obj4;
        a();
        f("Connect started.");
        if (isConnected()) {
            disconnect("connect() called when already connected");
        }
        Intent intent = new Intent();
        package = this.c;
        if (package != null) {
            intent.setComponent(package);
        } else {
            intent.setPackage(this.a).setAction(this.b);
        }
        bindService = this.v.bindService(intent, this, i.a());
        this.A = bindService;
        if (bindService == null) {
            this.z = 0;
            bindService = new b(16);
            this.y.m(bindService);
        }
        f("Finished connect.");
    }

    @Override // com.google.android.gms.common.api.a$f
    final void d() {
        this.A = false;
        this.z = 0;
        f("Disconnected.");
        this.w.j(1);
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void disconnect() {
        a();
        f("Disconnect called.");
        this.v.unbindService(this);
        this.A = false;
        this.z = 0;
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void disconnect(String string) {
        a();
        this.B = string;
        disconnect();
    }

    @Override // com.google.android.gms.common.api.a$f
    final void e(IBinder iBinder) {
        this.A = false;
        this.z = iBinder;
        f("Connected.");
        Bundle bundle = new Bundle();
        this.w.n(bundle);
    }

    public final d[] getAvailableFeatures() {
        return new d[0];
    }

    public final String getEndpointPackageName() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        r.j(this.c);
        return this.c.getPackageName();
    }

    public final String getLastDisconnectMessage() {
        return this.B;
    }

    @Override // com.google.android.gms.common.api.a$f
    public final int getMinApkVersion() {
        return 0;
    }

    public final void getRemoteService(k k, Set<Scope> set2) {
    }

    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.a$f
    public final boolean isConnected() {
        a();
        if (this.z != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.api.a$f
    public final boolean isConnecting() {
        a();
        return this.A;
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        s0 s0Var = new s0(this, iBinder2);
        this.x.post(s0Var);
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void onServiceDisconnected(ComponentName componentName) {
        u0 u0Var = new u0(this);
        this.x.post(u0Var);
    }

    @Override // com.google.android.gms.common.api.a$f
    public final void onUserSignOut(c.e c$e) {
    }

    @Override // com.google.android.gms.common.api.a$f
    public final boolean requiresGooglePlayServices() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.a$f
    public final boolean requiresSignIn() {
        return 0;
    }
}
