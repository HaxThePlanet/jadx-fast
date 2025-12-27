package io.grpc.j1;

/* compiled from: ForwardingDeframerListener.java */
/* loaded from: classes3.dex */
abstract class l0 implements l1.b {
    l0() {
        super();
    }

    public void a(k2.a aVar) {
        e().a(aVar);
    }

    public void b(boolean z) {
        e().b(z);
    }

    public void c(int i) {
        e().c(i);
    }

    public void d(Throwable th) {
        e().d(th);
    }

    protected abstract l1.b e();
}
