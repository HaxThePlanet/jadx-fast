package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class l1 implements Closeable {
    @Override // java.io.Closeable
    public abstract long a();

    @Override // java.io.Closeable
    protected abstract InputStream c(long l, long l2);

    @Override // java.io.Closeable
    public final InputStream e() {
        return c(0, obj1);
        synchronized (this) {
            return c(0, obj1);
        }
    }
}
