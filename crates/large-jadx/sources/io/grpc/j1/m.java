package io.grpc.j1;

/* loaded from: classes3.dex */
final class m {

    private final io.grpc.j1.l2 a;
    private final io.grpc.j1.e1 b;
    private final io.grpc.j1.e1 c;
    private final io.grpc.j1.e1 d;

    public interface a {
        public abstract io.grpc.j1.m a();
    }
    static {
    }

    m(io.grpc.j1.l2 l2) {
        super();
        this.b = f1.a();
        this.c = f1.a();
        this.d = f1.a();
        this.a = l2;
    }

    public void a(boolean z) {
        io.grpc.j1.e1 obj3;
        final int i = 1;
        if (z) {
            this.c.add(i);
        } else {
            this.d.add(i);
        }
    }

    public void b() {
        this.b.add(1);
        this.a.a();
    }
}
