package zendesk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import f.g.c.a;
import f.g.e.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
class ZendeskNetworkInfoProvider implements zendesk.core.NetworkInfoProvider, zendesk.core.NetworkAware {

    private static final String LOG_TAG = "ZendeskNetworkInfoProvider";
    private final BroadcastReceiver broadcastReceiver;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private zendesk.core.ZendeskNetworkInfoProvider.CurrentState currentState = null;
    private boolean isBroadcastReceiverRegistered = false;
    private final Map<Integer, WeakReference<zendesk.core.NetworkAware>> listeners;
    private ConnectivityManager.NetworkCallback networkCallback;
    private final Map<Integer, WeakReference<zendesk.core.RetryAction>> retryActions;

    private static enum CurrentState {

        CONNECTED,
        DISCONNECTED;
    }

    class NetworkAvailabilityBroadcastReceiver extends BroadcastReceiver {

        private static final String LOG_TAG = "NetAvailabilityReceiver";
        final zendesk.core.ZendeskNetworkInfoProvider this$0;
        NetworkAvailabilityBroadcastReceiver(zendesk.core.ZendeskNetworkInfoProvider zendeskNetworkInfoProvider) {
            this.this$0 = zendeskNetworkInfoProvider;
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            boolean equals;
            String str;
            zendesk.core.ZendeskNetworkInfoProvider obj3;
            obj3 = 0;
            if (intent2 != null) {
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent2.getAction())) {
                } else {
                    if (intent2.getBooleanExtra("noConnectivity", obj3)) {
                        this.this$0.onNetworkUnavailable();
                    } else {
                        this.this$0.onNetworkAvailable();
                    }
                }
            }
            a.k("NetAvailabilityReceiver", "onReceive: intent was null or getAction() was mismatched", new Object[obj3]);
        }
    }
    ZendeskNetworkInfoProvider(Context context, ConnectivityManager connectivityManager2) {
        super();
        ZendeskNetworkInfoProvider.NetworkAvailabilityBroadcastReceiver networkAvailabilityBroadcastReceiver = new ZendeskNetworkInfoProvider.NetworkAvailabilityBroadcastReceiver(this);
        this.broadcastReceiver = networkAvailabilityBroadcastReceiver;
        HashMap hashMap = new HashMap();
        this.listeners = hashMap;
        HashMap hashMap2 = new HashMap();
        this.retryActions = hashMap2;
        int i = 0;
        int i2 = 0;
        this.context = context;
        this.connectivityManager = connectivityManager2;
    }

    private static boolean isConnectedOrConnecting(ConnectivityManager connectivityManager) {
        NetworkInfo obj0;
        obj0 = connectivityManager.getActiveNetworkInfo();
        if (obj0 != null && obj0.isConnectedOrConnecting()) {
            obj0 = obj0.isConnectedOrConnecting() ? 1 : 0;
        } else {
        }
        return obj0;
    }

    private void registerForNetworkCallbacks() {
        ConnectivityManager isBroadcastReceiverRegistered;
        Object broadcastReceiver;
        Object networkCallback;
        int str;
        int i = 0;
        networkCallback = "ZendeskNetworkInfoProvider";
        if (Build.VERSION.SDK_INT < 21) {
            a.b(networkCallback, "Adding pre-Lollipop network callbacks...", new Object[i]);
            if (!this.isBroadcastReceiverRegistered) {
                networkCallback = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                this.context.registerReceiver(this.broadcastReceiver, networkCallback);
                this.isBroadcastReceiverRegistered = true;
            }
        } else {
            a.b(networkCallback, "Adding Lollipop network callbacks...", new Object[i]);
            Handler handler = new Handler(Looper.getMainLooper());
            ZendeskNetworkInfoProvider.1 anon = new ZendeskNetworkInfoProvider.1(this, handler);
            this.networkCallback = anon;
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            this.connectivityManager.registerNetworkCallback(builder.build(), this.networkCallback);
        }
    }

    private void unregisterForNetworkCallbacks() {
        boolean isBroadcastReceiverRegistered;
        int networkCallback;
        BroadcastReceiver broadcastReceiver;
        int connectivityManager;
        if (this.isBroadcastReceiverRegistered) {
            this.context.unregisterReceiver(this.broadcastReceiver);
            this.isBroadcastReceiverRegistered = false;
        }
        networkCallback = this.networkCallback;
        if (Build.VERSION.SDK_INT >= 21 && networkCallback != null) {
            networkCallback = this.networkCallback;
            if (networkCallback != null) {
                this.connectivityManager.unregisterNetworkCallback(networkCallback);
                this.networkCallback = 0;
            }
        }
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void addNetworkAwareListener(Integer integer, zendesk.core.NetworkAware networkAware2) {
        Map listeners;
        WeakReference weakReference;
        if (integer != null && networkAware2 != null) {
            if (networkAware2 != null) {
                weakReference = new WeakReference(networkAware2);
                this.listeners.put(integer, weakReference);
            }
        }
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void addRetryAction(Integer integer, zendesk.core.RetryAction retryAction2) {
        Map retryActions;
        WeakReference weakReference;
        if (integer != null && retryAction2 != null) {
            if (retryAction2 != null) {
                weakReference = new WeakReference(retryAction2);
                this.retryActions.put(integer, weakReference);
            }
        }
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void clearNetworkAwareListeners() {
        this.listeners.clear();
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void clearRetryActions() {
        this.retryActions.clear();
    }

    @Override // zendesk.core.NetworkInfoProvider
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo;
        int i;
        activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            i = activeNetworkInfo.isConnected() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void onNetworkAvailable() {
        Object retryActions;
        Map next;
        zendesk.core.ZendeskNetworkInfoProvider.CurrentState connectedOrConnecting;
        boolean next2;
        Object obj;
        retryActions = ZendeskNetworkInfoProvider.CurrentState.CONNECTED;
        if (retryActions != this.currentState) {
            if (!ZendeskNetworkInfoProvider.isConnectedOrConnecting(this.connectivityManager)) {
            } else {
                this.currentState = retryActions;
                Iterator iterator = a.d(this.listeners).values().iterator();
                while (iterator.hasNext()) {
                    next2 = iterator.next();
                    if ((WeakReference)next2.get() != null) {
                    }
                    (NetworkAware)next2.get().onNetworkAvailable();
                }
                Iterator iterator2 = a.d(this.retryActions).values().iterator();
                while (iterator2.hasNext()) {
                    next = iterator2.next();
                    if ((WeakReference)next.get()) {
                    }
                    (RetryAction)next.get().onRetry();
                }
                this.retryActions.clear();
            }
        }
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void onNetworkUnavailable() {
        Object dISCONNECTED;
        zendesk.core.ZendeskNetworkInfoProvider.CurrentState connectedOrConnecting;
        Object obj;
        dISCONNECTED = ZendeskNetworkInfoProvider.CurrentState.DISCONNECTED;
        if (dISCONNECTED != this.currentState) {
            if (ZendeskNetworkInfoProvider.isConnectedOrConnecting(this.connectivityManager)) {
            } else {
                this.currentState = dISCONNECTED;
                dISCONNECTED = a.d(this.listeners).values().iterator();
                while (dISCONNECTED.hasNext()) {
                    connectedOrConnecting = dISCONNECTED.next();
                    if ((WeakReference)connectedOrConnecting.get() != null) {
                    }
                    (NetworkAware)connectedOrConnecting.get().onNetworkUnavailable();
                }
            }
        }
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void register() {
        registerForNetworkCallbacks();
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void removeNetworkAwareListener(Integer integer) {
        this.listeners.remove(integer);
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void removeRetryAction(Integer integer) {
        this.retryActions.remove(integer);
    }

    @Override // zendesk.core.NetworkInfoProvider
    public void unregister() {
        unregisterForNetworkCallbacks();
    }
}
