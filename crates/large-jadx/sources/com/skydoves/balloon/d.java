package com.skydoves.balloon;

import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    private final com.skydoves.balloon.Balloon a;
    public d(com.skydoves.balloon.Balloon balloon) {
        n.f(balloon, "balloon");
        super();
        this.a = balloon;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.J();
    }
}
