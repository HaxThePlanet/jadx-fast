package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class r0 {

    private static final AtomicReference<com.google.android.play.core.splitinstall.q0> a;
    static {
        AtomicReference atomicReference = new AtomicReference(0);
        r0.a = atomicReference;
    }

    static com.google.android.play.core.splitinstall.q0 a() {
        return (q0)r0.a.get();
    }

    public static void b(com.google.android.play.core.splitinstall.q0 q0) {
        r0.a.compareAndSet(0, q0);
    }
}
