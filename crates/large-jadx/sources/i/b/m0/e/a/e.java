package i.b.m0.e.a;

import i.b.b;

/* compiled from: CompletableError.java */
/* loaded from: classes3.dex */
public final class e extends b {

    final Throwable a;
    public e(Throwable th) {
        super();
        this.a = th;
    }

    @Override // i.b.b
    protected void x(i.b.d dVar) {
        d.error(this.a, dVar);
    }
}
