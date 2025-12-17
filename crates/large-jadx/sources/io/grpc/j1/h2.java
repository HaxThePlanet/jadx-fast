package io.grpc.j1;

/* loaded from: classes3.dex */
final class h2 extends io.grpc.j1.l0 {

    private final io.grpc.j1.l1.b a;
    private boolean b;
    public h2(io.grpc.j1.l1.b l1$b) {
        super();
        this.a = b;
    }

    @Override // io.grpc.j1.l0
    public void a(io.grpc.j1.k2.a k2$a) {
        if (this.b && a instanceof Closeable) {
            if (a instanceof Closeable) {
                r0.e((Closeable)a);
            }
        }
        super.a(a);
    }

    @Override // io.grpc.j1.l0
    public void b(boolean z) {
        this.b = true;
        super.b(z);
    }

    @Override // io.grpc.j1.l0
    public void d(Throwable throwable) {
        this.b = true;
        super.d(throwable);
    }

    @Override // io.grpc.j1.l0
    protected io.grpc.j1.l1.b e() {
        return this.a;
    }
}
