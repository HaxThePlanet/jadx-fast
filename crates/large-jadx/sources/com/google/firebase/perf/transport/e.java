package com.google.firebase.perf.transport;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.firebase.perf.transport.TransportManager a;
    public e(com.google.firebase.perf.transport.TransportManager transportManager) {
        super();
        this.a = transportManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k();
    }
}
