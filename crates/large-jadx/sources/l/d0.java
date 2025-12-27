package l;

import java.io.Closeable;

/* compiled from: Source.kt */
/* loaded from: classes3.dex */
public interface d0 extends Closeable {
    @Override // java.io.Closeable
    void close();

    long read(f fVar, long j);

    e0 timeout();
}
