package l;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes3.dex */
public interface b0 extends Closeable, Flushable {
    @Override // java.io.Closeable
    public abstract void close();

    @Override // java.io.Closeable
    public abstract void flush();

    @Override // java.io.Closeable
    public abstract l.e0 timeout();

    @Override // java.io.Closeable
    public abstract void write(l.f f, long l2);
}
