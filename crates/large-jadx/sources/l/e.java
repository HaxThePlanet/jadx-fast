package l;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class e implements l.b0 {
    @Override // l.b0
    public void close() {
    }

    @Override // l.b0
    public void flush() {
    }

    @Override // l.b0
    public l.e0 timeout() {
        return e0.NONE;
    }

    @Override // l.b0
    public void write(l.f f, long l2) {
        n.f(f, "source");
        f.skip(l2);
    }
}
