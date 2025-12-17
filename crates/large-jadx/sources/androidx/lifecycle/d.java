package androidx.lifecycle;

import java.io.Closeable;
import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
public final class d implements Closeable, m0 {

    private final g a;
    public d(g g) {
        n.f(g, "context");
        super();
        this.a = g;
    }

    @Override // java.io.Closeable
    public void close() {
        final int i = 0;
        b2.d(r(), i, 1, i);
    }

    @Override // java.io.Closeable
    public g r() {
        return this.a;
    }
}
