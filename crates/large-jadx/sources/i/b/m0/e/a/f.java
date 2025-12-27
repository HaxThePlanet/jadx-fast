package i.b.m0.e.a;

import i.b.d;
import i.b.j0.c;

/* compiled from: CompletableFromAction.java */
/* loaded from: classes3.dex */
public final class f extends i.b.b {

    final i.b.l0.a a;
    public f(i.b.l0.a aVar) {
        super();
        this.a = aVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        i.b.j0.b bVar = c.b();
        dVar.onSubscribe(bVar);
        try {
            this.a.run();
        } catch (Throwable th) {
            a.b(th);
            boolean disposed = disposed.isDisposed();
        }
        if (!bVar.isDisposed()) {
            dVar.onComplete();
        }
    }
}
