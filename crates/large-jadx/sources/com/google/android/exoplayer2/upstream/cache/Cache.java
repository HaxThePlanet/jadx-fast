package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String string) {
            super(string);
        }

        public CacheException(String string, Throwable throwable2) {
            super(string, throwable2);
        }

        public CacheException(Throwable throwable) {
            super(throwable);
        }
    }

    public interface a {
        public abstract void b(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.h h2);

        public abstract void c(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.h h2, com.google.android.exoplayer2.upstream.cache.h h3);

        public abstract void d(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.h h2);
    }
    public abstract File a(String string, long l2, long l3);

    public abstract com.google.android.exoplayer2.upstream.cache.k b(String string);

    public abstract void c(String string, com.google.android.exoplayer2.upstream.cache.l l2);

    public abstract void d(com.google.android.exoplayer2.upstream.cache.h h);

    public abstract com.google.android.exoplayer2.upstream.cache.h e(String string, long l2, long l3);

    public abstract com.google.android.exoplayer2.upstream.cache.h f(String string, long l2, long l3);

    public abstract void g(File file, long l2);

    public abstract long h();

    public abstract void i(com.google.android.exoplayer2.upstream.cache.h h);
}
