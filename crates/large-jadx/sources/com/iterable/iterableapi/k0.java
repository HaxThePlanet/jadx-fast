package com.iterable.iterableapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: IterableNetworkConnectivityManager.java */
/* loaded from: classes2.dex */
class k0 {

    private static k0 c;
    private boolean a;
    private ArrayList<k0.b> b = new ArrayList<>();

    class a extends ConnectivityManager.NetworkCallback {

        final /* synthetic */ k0 a;
        a() {
            this.a = k0Var;
            super();
        }

        @Override // android.net.ConnectivityManager$NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            j0.h("NetworkConnectivityManager", "Network Connected");
            this.a.a = 1;
            Iterator it = new ArrayList(this.a.b).iterator();
            while (it.hasNext()) {
                (k0.b)it.next().e();
            }
        }

        @Override // android.net.ConnectivityManager$NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            j0.h("NetworkConnectivityManager", "Network Disconnected");
            this.a.a = 0;
            Iterator it = new ArrayList(this.a.b).iterator();
            while (it.hasNext()) {
                (k0.b)it.next().c();
            }
        }
    }

    public interface b {
        void c();

        void e();
    }
    private k0(Context context) {
        super();
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            f(context);
        }
    }

    static /* synthetic */ boolean a(k0 k0Var, boolean z) {
        k0Var.a = z;
        return z;
    }

    static /* synthetic */ ArrayList b(k0 k0Var) {
        return k0Var.b;
    }

    static k0 e(Context context) {
        if (k0.c == null) {
            k0.c = new k0(context);
        }
        return k0.c;
    }

    private void f(Context context) {
        final Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            systemService.registerNetworkCallback(new NetworkRequest.Builder().build(), new k0.a(this));
        }
    }

    synchronized void c(k0.b bVar) {
        this.b.add(bVar);
    }

    boolean d() {
        return this.a;
    }
}
