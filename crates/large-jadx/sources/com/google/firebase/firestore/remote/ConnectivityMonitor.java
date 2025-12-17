package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public interface ConnectivityMonitor {

    public static enum NetworkStatus {

        UNREACHABLE,
        REACHABLE;
    }
    public abstract void addCallback(Consumer<com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus> consumer);

    public abstract void shutdown();
}
