package l;

import kotlin.d0.d.n;

/* compiled from: Okio.kt */
/* loaded from: classes3.dex */
final class e implements b0 {
    public e0 timeout() {
        return e0.NONE;
    }

    public void write(f fVar, long j) {
        n.f(fVar, "source");
        fVar.skip(j);
    }

    public void close() {
    }

    public void flush() {
    }
}
