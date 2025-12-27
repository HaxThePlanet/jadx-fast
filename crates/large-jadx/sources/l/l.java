package l;

import kotlin.d0.d.n;

/* compiled from: ForwardingSource.kt */
/* loaded from: classes3.dex */
public abstract class l implements d0 {

    private final d0 delegate;
    public l(d0 d0Var) {
        n.f(d0Var, "delegate");
        super();
        this.delegate = d0Var;
    }

    public final d0 _deprecated_delegate() {
        return this.delegate;
    }

    public void close() {
        this.delegate.close();
    }

    public final d0 delegate() {
        return this.delegate;
    }

    public long read(f fVar, long j) {
        n.f(fVar, "sink");
        return this.delegate.read(fVar, j);
    }

    public e0 timeout() {
        return this.delegate.timeout();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String simpleName = getClass().getSimpleName();
        str = simpleName + 40 + this.delegate + 41;
        return str;
    }
}
