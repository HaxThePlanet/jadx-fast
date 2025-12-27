package io.grpc.j1;

/* compiled from: SquelchLateMessagesAvailableDeframerListener.java */
/* loaded from: classes3.dex */
final class h2 extends l0 {

    private final l1.b a;
    private boolean b;
    public h2(l1.b bVar) {
        super();
        this.a = bVar;
    }

    @Override // io.grpc.j1.l0
    public void a(k2.a aVar) {
        if (this.b) {
            if (aVar instanceof Closeable) {
                r0.e(aVar);
            }
            return;
        }
        super.a(aVar);
    }

    @Override // io.grpc.j1.l0
    public void b(boolean z) {
        this.b = true;
        super.b(z);
    }

    @Override // io.grpc.j1.l0
    public void d(Throwable th) {
        this.b = true;
        super.d(th);
    }

    @Override // io.grpc.j1.l0
    protected l1.b e() {
        return this.a;
    }
}
