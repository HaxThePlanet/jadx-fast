package io.grpc.j1;

import io.grpc.s;

/* compiled from: ContextRunnable.java */
/* loaded from: classes3.dex */
abstract class x implements Runnable {

    private final s a;
    protected x(s sVar) {
        super();
        this.a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } finally {
            this.a.j(sVar);
            throw th;
        }
        this.a.j(this.a.c());
    }

    public abstract void a();
}
