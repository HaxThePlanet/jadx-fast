package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class CacheDataSink implements k {

    private final com.google.android.exoplayer2.upstream.cache.Cache a;
    private final long b;
    private final int c;
    private n d;
    private long e;
    private File f;
    private OutputStream g;
    private long h;
    private long i;
    private g0 j;

    public static final class CacheDataSinkException extends com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }
    public CacheDataSink(com.google.android.exoplayer2.upstream.cache.Cache cache, long l2) {
        super(cache, l2, obj4, 20480);
    }

    public CacheDataSink(com.google.android.exoplayer2.upstream.cache.Cache cache, long l2, int i3) {
        int i;
        int cmp2;
        int cmp;
        String str;
        int obj6;
        super();
        cmp = -1;
        if (Long.compare(l2, i2) <= 0) {
            if (Long.compare(l2, cmp) == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.g(i, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int cmp3 = Long.compare(l2, cmp);
        if (cmp3 != 0 && Long.compare(l2, i4) < 0) {
            if (Long.compare(l2, i4) < 0) {
                v.h("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
            }
        }
        g.e(cache);
        this.a = (Cache)cache;
        obj6 = cmp3 == 0 ? 9223372036854775807L : obj6;
        this.b = obj6;
        this.c = obj8;
    }

    private void a() {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
        }
        int i = 0;
        outputStream.flush();
        p0.m(this.g);
        this.g = i;
        File file = this.f;
        p0.i(file);
        this.f = i;
        this.a.g((File)file, this.h);
    }

    private void d(n n) {
        int l2;
        int g0Var;
        long l;
        long i;
        Object obj11;
        l2 = n.g;
        if (Long.compare(l2, i) == 0) {
        } else {
            i = Math.min(l2 -= l5, obj1);
        }
        String str = n.h;
        p0.i(str);
        this.f = this.a.a((String)str, l3 + l4, obj7);
        obj11 = new FileOutputStream(this.f);
        if (this.c > 0) {
            g0Var = this.j;
            if (g0Var == null) {
                g0Var = new g0(obj11, this.c);
                this.j = g0Var;
            } else {
                g0Var.a(obj11);
            }
            this.g = this.j;
        } else {
            this.g = obj11;
        }
        this.h = 0;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void b(byte[] bArr, int i2, int i3) {
        int i5;
        int i4;
        long l3;
        int i;
        long l;
        long l2;
        final n nVar = this.d;
        if (nVar == null) {
        }
        i5 = 0;
        while (i5 < i3) {
            if (Long.compare(l4, l9) == 0) {
            }
            int i7 = (int)l6;
            OutputStream outputStream = this.g;
            p0.i(outputStream);
            (OutputStream)outputStream.write(bArr, i2 + i5, i7);
            i5 += i7;
            l = (long)i7;
            this.h = l8 += l;
            this.i = l7 += l;
            a();
            d(nVar);
        }
        try {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void c(n n) {
        int cmp;
        long l;
        g.e(n.h);
        if (Long.compare(l2, i4) == 0 && n.d(2)) {
            if (n.d(2)) {
                this.d = 0;
            }
        }
        this.d = n;
        l = n.d(4) ? this.b : 9223372036854775807L;
        this.e = l;
        this.i = 0;
        d(n);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        if (this.d == null) {
        }
        a();
    }
}
