package l;

import java.io.Closeable;

/* loaded from: classes3.dex */
public interface d0 extends Closeable {
    @Override // java.io.Closeable
    public abstract void close();

    @Override // java.io.Closeable
    public abstract long read(l.f f, long l2);

    @Override // java.io.Closeable
    public abstract l.e0 timeout();
}
