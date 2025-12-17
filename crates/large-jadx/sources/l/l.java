package l;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public abstract class l implements l.d0 {

    private final l.d0 delegate;
    public l(l.d0 d0) {
        n.f(d0, "delegate");
        super();
        this.delegate = d0;
    }

    @Override // l.d0
    public final l.d0 -deprecated_delegate() {
        return this.delegate;
    }

    @Override // l.d0
    public void close() {
        this.delegate.close();
    }

    @Override // l.d0
    public final l.d0 delegate() {
        return this.delegate;
    }

    @Override // l.d0
    public long read(l.f f, long l2) {
        n.f(f, "sink");
        return this.delegate.read(f, l2);
    }

    @Override // l.d0
    public l.e0 timeout() {
        return this.delegate.timeout();
    }

    @Override // l.d0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('(');
        stringBuilder.append(this.delegate);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
