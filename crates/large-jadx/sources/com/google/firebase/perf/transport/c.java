package com.google.firebase.perf.transport;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.perf.transport.TransportManager a;
    public c(com.google.firebase.perf.transport.TransportManager transportManager) {
        super();
        this.a = transportManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TransportManager.a(this.a);
    }
}
