package com.iterable.iterableapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
class k0 {

    private static com.iterable.iterableapi.k0 c;
    private boolean a;
    private ArrayList<com.iterable.iterableapi.k0.b> b;

    class a extends ConnectivityManager.NetworkCallback {

        final com.iterable.iterableapi.k0 a;
        a(com.iterable.iterableapi.k0 k0) {
            this.a = k0;
            super();
        }

        @Override // android.net.ConnectivityManager$NetworkCallback
        public void onAvailable(Network network) {
            ArrayList next;
            super.onAvailable(network);
            j0.h("NetworkConnectivityManager", "Network Connected");
            k0.a(this.a, true);
            ArrayList obj2 = new ArrayList(k0.b(this.a));
            obj2 = obj2.iterator();
            for (k0.b next : obj2) {
                next.e();
            }
        }

        @Override // android.net.ConnectivityManager$NetworkCallback
        public void onLost(Network network) {
            ArrayList next;
            super.onLost(network);
            j0.h("NetworkConnectivityManager", "Network Disconnected");
            k0.a(this.a, false);
            ArrayList obj2 = new ArrayList(k0.b(this.a));
            obj2 = obj2.iterator();
            for (k0.b next : obj2) {
                next.c();
            }
        }
    }

    public interface b {
        public abstract void c();

        public abstract void e();
    }
    private k0(Context context) {
        super();
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (context == null) {
        }
        if (Build.VERSION.SDK_INT >= 21) {
            f(context);
        }
    }

    static boolean a(com.iterable.iterableapi.k0 k0, boolean z2) {
        k0.a = z2;
        return z2;
    }

    static ArrayList b(com.iterable.iterableapi.k0 k0) {
        return k0.b;
    }

    static com.iterable.iterableapi.k0 e(Context context) {
        com.iterable.iterableapi.k0 k0Var;
        if (k0.c == null) {
            k0Var = new k0(context);
            k0.c = k0Var;
        }
        return k0.c;
    }

    private void f(Context context) {
        Object builder;
        com.iterable.iterableapi.k0.a aVar;
        final Object obj3 = context.getSystemService("connectivity");
        builder = new NetworkRequest.Builder();
        if ((ConnectivityManager)obj3 != null) {
            aVar = new k0.a(this);
            (ConnectivityManager)obj3.registerNetworkCallback(builder.build(), aVar);
        }
    }

    void c(com.iterable.iterableapi.k0.b k0$b) {
        this.b.add(b);
        return;
        synchronized (this) {
            this.b.add(b);
        }
    }

    boolean d() {
        return this.a;
    }
}
