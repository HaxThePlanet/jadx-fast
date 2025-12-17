package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.DelayedTask;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.Logger;
import io.grpc.d1;
import java.util.Locale;

/* loaded from: classes2.dex */
class OnlineStateTracker {

    private static final String LOG_TAG = "OnlineStateTracker";
    private static final int MAX_WATCH_STREAM_FAILURES = 1;
    private static final int ONLINE_STATE_TIMEOUT_MS = 10000;
    private final com.google.firebase.firestore.remote.OnlineStateTracker.OnlineStateCallback onlineStateCallback;
    private AsyncQueue.DelayedTask onlineStateTimer;
    private boolean shouldWarnClientIsOffline = true;
    private OnlineState state;
    private int watchStreamFailures;
    private final AsyncQueue workerQueue;

    interface OnlineStateCallback {
        public abstract void handleOnlineStateChange(OnlineState onlineState);
    }
    OnlineStateTracker(AsyncQueue asyncQueue, com.google.firebase.firestore.remote.OnlineStateTracker.OnlineStateCallback onlineStateTracker$OnlineStateCallback2) {
        super();
        this.workerQueue = asyncQueue;
        this.onlineStateCallback = onlineStateCallback2;
        this.state = OnlineState.UNKNOWN;
        int obj1 = 1;
    }

    private void a() {
        int i;
        this.onlineStateTimer = 0;
        int i3 = 1;
        final int i5 = 0;
        i = this.state == OnlineState.UNKNOWN ? i3 : i5;
        Assert.hardAssert(i, "Timer should be canceled if we transitioned to a different state.", new Object[i5]);
        Object[] arr2 = new Object[i3];
        arr2[i5] = 10;
        logClientOfflineWarningIfNecessary(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", arr2));
        setAndBroadcastState(OnlineState.OFFLINE);
    }

    private void clearOnlineStateTimer() {
        AsyncQueue.DelayedTask onlineStateTimer;
        onlineStateTimer = this.onlineStateTimer;
        if (onlineStateTimer != null) {
            onlineStateTimer.cancel();
            this.onlineStateTimer = 0;
        }
    }

    private void logClientOfflineWarningIfNecessary(String string) {
        Object[] arr;
        int i = 1;
        Object[] arr2 = new Object[i];
        final int i2 = 0;
        arr2[i2] = string;
        String obj6 = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", arr2);
        final String str = "%s";
        final String str2 = "OnlineStateTracker";
        if (this.shouldWarnClientIsOffline) {
            arr = new Object[i];
            arr[i2] = obj6;
            Logger.warn(str2, str, arr);
            this.shouldWarnClientIsOffline = i2;
        } else {
            arr = new Object[i];
            arr[i2] = obj6;
            Logger.debug(str2, str, arr);
        }
    }

    private void setAndBroadcastState(OnlineState onlineState) {
        Object onlineStateCallback;
        if (onlineState != this.state) {
            this.state = onlineState;
            this.onlineStateCallback.handleOnlineStateChange(onlineState);
        }
    }

    public void b() {
        a();
    }

    OnlineState getState() {
        return this.state;
    }

    void handleWatchStreamFailure(d1 d1) {
        String eNGLISH;
        Object oNLINE;
        int i;
        Integer valueOf;
        Object obj6;
        final int i3 = 0;
        i = 1;
        if (this.state == OnlineState.ONLINE) {
            setAndBroadcastState(OnlineState.UNKNOWN);
            obj6 = this.watchStreamFailures == 0 ? i : i3;
            Assert.hardAssert(obj6, "watchStreamFailures must be 0", new Object[i3]);
            if (this.onlineStateTimer == null) {
            } else {
                i = i3;
            }
            Assert.hardAssert(i, "onlineStateTimer must be null", new Object[i3]);
        } else {
            watchStreamFailures += i;
            this.watchStreamFailures = eNGLISH;
            if (eNGLISH >= i) {
                clearOnlineStateTimer();
                oNLINE = new Object[2];
                oNLINE[i3] = Integer.valueOf(i);
                oNLINE[i] = d1;
                logClientOfflineWarningIfNecessary(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", oNLINE));
                setAndBroadcastState(OnlineState.OFFLINE);
            }
        }
    }

    void handleWatchStreamStart() {
        int i;
        int watchStreamFailures;
        AsyncQueue.TimerId oNLINE_STATE_TIMEOUT;
        int i2;
        com.google.firebase.firestore.remote.v vVar;
        if (this.watchStreamFailures == 0) {
            setAndBroadcastState(OnlineState.UNKNOWN);
            int i3 = 0;
            i = this.onlineStateTimer == null ? 1 : i3;
            Assert.hardAssert(i, "onlineStateTimer shouldn't be started yet", new Object[i3]);
            vVar = new v(this);
            this.onlineStateTimer = this.workerQueue.enqueueAfterDelay(AsyncQueue.TimerId.ONLINE_STATE_TIMEOUT, 10000, obj3);
        }
    }

    void updateState(OnlineState onlineState) {
        clearOnlineStateTimer();
        final int i = 0;
        this.watchStreamFailures = i;
        if (onlineState == OnlineState.ONLINE) {
            this.shouldWarnClientIsOffline = i;
        }
        setAndBroadcastState(onlineState);
    }
}
