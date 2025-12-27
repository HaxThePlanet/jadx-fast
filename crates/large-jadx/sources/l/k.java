package l;

import kotlin.d0.d.n;

/* compiled from: ForwardingSink.kt */
/* loaded from: classes3.dex */
public abstract class k implements b0 {

    private final b0 delegate;
    public k(b0 b0Var) {
        n.f(b0Var, "delegate");
        super();
        this.delegate = b0Var;
    }

    public final b0 _deprecated_delegate() {
        return this.delegate;
    }

    public void close() {
        this.delegate.close();
    }

    public final b0 delegate() {
        return this.delegate;
    }

    public void flush() {
        this.delegate.flush();
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

    public void write(f fVar, long j) {
        n.f(fVar, "source");
        this.delegate.write(fVar, j);
    }
}
