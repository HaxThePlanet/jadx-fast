package com.skydoves.balloon;

import kotlin.d0.d.n;

/* compiled from: AutoDismissRunnable.kt */
/* loaded from: classes2.dex */
public final class d implements Runnable {

    private final Balloon a;
    public d(Balloon balloon) {
        n.f(balloon, "balloon");
        super();
        this.a = balloon;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.J();
    }
}
