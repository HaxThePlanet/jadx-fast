package io.grpc.j1;

import io.grpc.s;

/* loaded from: classes3.dex */
abstract class x implements Runnable {

    private final s a;
    protected x(s s) {
        super();
        this.a = s;
    }

    @Override // java.lang.Runnable
    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a();
        this.a.j(this.a.c());
    }
}
