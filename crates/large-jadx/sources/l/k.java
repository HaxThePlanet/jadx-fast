package l;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public abstract class k implements l.b0 {

    private final l.b0 delegate;
    public k(l.b0 b0) {
        n.f(b0, "delegate");
        super();
        this.delegate = b0;
    }

    @Override // l.b0
    public final l.b0 -deprecated_delegate() {
        return this.delegate;
    }

    @Override // l.b0
    public void close() {
        this.delegate.close();
    }

    @Override // l.b0
    public final l.b0 delegate() {
        return this.delegate;
    }

    @Override // l.b0
    public void flush() {
        this.delegate.flush();
    }

    @Override // l.b0
    public l.e0 timeout() {
        return this.delegate.timeout();
    }

    @Override // l.b0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('(');
        stringBuilder.append(this.delegate);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // l.b0
    public void write(l.f f, long l2) {
        n.f(f, "source");
        this.delegate.write(f, l2);
    }
}
