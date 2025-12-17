package com.google.firebase.firestore.remote;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class AndroidConnectivityMonitor implements com.google.firebase.firestore.remote.ConnectivityMonitor {

    private static final String LOG_TAG = "AndroidConnectivityMonitor";
    private final List<Consumer<com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus>> callbacks;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private Runnable unregisterRunnable;

    private class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {

        final com.google.firebase.firestore.remote.AndroidConnectivityMonitor this$0;
        private DefaultNetworkCallback(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor) {
            this.this$0 = androidConnectivityMonitor;
            super();
        }

        DefaultNetworkCallback(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor, com.google.firebase.firestore.remote.AndroidConnectivityMonitor.1 androidConnectivityMonitor$12) {
            super(androidConnectivityMonitor);
        }

        @Override // android.net.ConnectivityManager$NetworkCallback
        public void onAvailable(Network network) {
            AndroidConnectivityMonitor.access$200(this.this$0, true);
        }

        @Override // android.net.ConnectivityManager$NetworkCallback
        public void onLost(Network network) {
            AndroidConnectivityMonitor.access$200(this.this$0, false);
        }
    }

    private class NetworkReceiver extends BroadcastReceiver {

        final com.google.firebase.firestore.remote.AndroidConnectivityMonitor this$0;
        private boolean wasConnected;
        private NetworkReceiver(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor) {
            this.this$0 = androidConnectivityMonitor;
            super();
            this.wasConnected = false;
        }

        NetworkReceiver(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor, com.google.firebase.firestore.remote.AndroidConnectivityMonitor.1 androidConnectivityMonitor$12) {
            super(androidConnectivityMonitor);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            int i;
            boolean obj3;
            boolean obj2 = AndroidConnectivityMonitor.access$300(this.this$0);
            if (AndroidConnectivityMonitor.access$300(this.this$0) && !this.wasConnected) {
                if (!this.wasConnected) {
                    AndroidConnectivityMonitor.access$200(this.this$0, true);
                } else {
                    if (obj2 == null && this.wasConnected) {
                        if (this.wasConnected) {
                            AndroidConnectivityMonitor.access$200(this.this$0, false);
                        }
                    }
                }
            } else {
            }
            this.wasConnected = obj2;
        }
    }
    public AndroidConnectivityMonitor(Context context) {
        int i;
        super();
        ArrayList arrayList = new ArrayList();
        this.callbacks = arrayList;
        int i2 = 0;
        i = context != null ? 1 : i2;
        Assert.hardAssert(i, "Context must be non-null", new Object[i2]);
        this.context = context;
        this.connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        configureBackgroundStateListener();
        configureNetworkMonitoring();
    }

    private void a(com.google.firebase.firestore.remote.AndroidConnectivityMonitor.DefaultNetworkCallback androidConnectivityMonitor$DefaultNetworkCallback) {
        this.connectivityManager.unregisterNetworkCallback(defaultNetworkCallback);
    }

    static void access$200(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor, boolean z2) {
        androidConnectivityMonitor.raiseCallbacks(z2);
    }

    static boolean access$300(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor) {
        return androidConnectivityMonitor.isConnected();
    }

    private void c(com.google.firebase.firestore.remote.AndroidConnectivityMonitor.NetworkReceiver androidConnectivityMonitor$NetworkReceiver) {
        this.context.unregisterReceiver(networkReceiver);
    }

    private void configureBackgroundStateListener() {
        Context applicationContext = this.context.getApplicationContext();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        AndroidConnectivityMonitor.1 anon = new AndroidConnectivityMonitor.1(this, atomicBoolean);
        (Application)applicationContext.registerActivityLifecycleCallbacks(anon);
        AndroidConnectivityMonitor.2 anon2 = new AndroidConnectivityMonitor.2(this, atomicBoolean);
        applicationContext.registerComponentCallbacks(anon2);
    }

    private void configureNetworkMonitoring() {
        int connectivityManager;
        Object defaultNetworkCallback;
        Object gVar;
        Context context;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 24 && this.connectivityManager != null) {
            if (this.connectivityManager != null) {
                defaultNetworkCallback = new AndroidConnectivityMonitor.DefaultNetworkCallback(this, i);
                this.connectivityManager.registerDefaultNetworkCallback(defaultNetworkCallback);
                gVar = new h(this, defaultNetworkCallback);
                this.unregisterRunnable = gVar;
            } else {
                defaultNetworkCallback = new AndroidConnectivityMonitor.NetworkReceiver(this, i);
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                this.context.registerReceiver(defaultNetworkCallback, intentFilter);
                gVar = new g(this, defaultNetworkCallback);
                this.unregisterRunnable = gVar;
            }
        } else {
        }
    }

    private boolean isConnected() {
        NetworkInfo activeNetworkInfo;
        int i;
        activeNetworkInfo = (ConnectivityManager)this.context.getSystemService("connectivity").getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            i = activeNetworkInfo.isConnected() ? 1 : 0;
        } else {
        }
        return i;
    }

    private void raiseCallbacks(boolean z) {
        Object next;
        com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus uNREACHABLE;
        final List callbacks = this.callbacks;
        Iterator iterator = this.callbacks.iterator();
        synchronized (callbacks) {
            while (iterator.hasNext()) {
                if (z != null) {
                } else {
                }
                uNREACHABLE = ConnectivityMonitor.NetworkStatus.UNREACHABLE;
                (Consumer)iterator.next().accept(uNREACHABLE);
                uNREACHABLE = ConnectivityMonitor.NetworkStatus.REACHABLE;
            }
        }
    }

    public void addCallback(Consumer<com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus> consumer) {
        final List callbacks = this.callbacks;
        this.callbacks.add(consumer);
        return;
        synchronized (callbacks) {
            callbacks = this.callbacks;
            this.callbacks.add(consumer);
        }
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void b(com.google.firebase.firestore.remote.AndroidConnectivityMonitor.DefaultNetworkCallback androidConnectivityMonitor$DefaultNetworkCallback) {
        a(defaultNetworkCallback);
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void d(com.google.firebase.firestore.remote.AndroidConnectivityMonitor.NetworkReceiver androidConnectivityMonitor$NetworkReceiver) {
        c(networkReceiver);
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void raiseForegroundNotification() {
        boolean connected;
        Logger.debug("AndroidConnectivityMonitor", "App has entered the foreground.", new Object[0]);
        if (isConnected()) {
            raiseCallbacks(true);
        }
    }

    @Override // com.google.firebase.firestore.remote.ConnectivityMonitor
    public void shutdown() {
        Runnable unregisterRunnable;
        unregisterRunnable = this.unregisterRunnable;
        if (unregisterRunnable != null) {
            unregisterRunnable.run();
            this.unregisterRunnable = 0;
        }
    }
}
