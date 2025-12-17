package com.google.firebase.inappmessaging.internal;

/* loaded from: classes2.dex */
public final class y implements Runnable {

    public final com.google.firebase.inappmessaging.internal.ForegroundNotifier a;
    public y(com.google.firebase.inappmessaging.internal.ForegroundNotifier foregroundNotifier) {
        super();
        this.a = foregroundNotifier;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
