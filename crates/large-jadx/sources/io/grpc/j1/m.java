package io.grpc.j1;

/* compiled from: CallTracer.java */
/* loaded from: classes3.dex */
final class m {

    private final l2 a;
    private final e1 b;
    private final e1 c;
    private final e1 d;

    public interface a {
        m a();
    }
    m(l2 l2Var) {
        super();
        this.b = f1.a();
        this.c = f1.a();
        this.d = f1.a();
        this.a = l2Var;
    }

    public void a(boolean z) {
        final long l = 1L;
        if (z) {
            this.c.add(l);
        } else {
            this.d.add(l);
        }
    }

    public void b() {
        this.b.add(1L);
        this.a.a();
    }

}
