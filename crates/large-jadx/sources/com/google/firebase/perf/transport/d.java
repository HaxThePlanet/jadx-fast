package com.google.firebase.perf.transport;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.firebase.perf.transport.TransportManager a;
    public final com.google.firebase.perf.transport.PendingPerfEvent b;
    public d(com.google.firebase.perf.transport.TransportManager transportManager, com.google.firebase.perf.transport.PendingPerfEvent pendingPerfEvent2) {
        super();
        this.a = transportManager;
        this.b = pendingPerfEvent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c(this.b);
    }
}
