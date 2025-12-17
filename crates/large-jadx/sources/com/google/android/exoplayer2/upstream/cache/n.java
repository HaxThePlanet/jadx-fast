package com.google.android.exoplayer2.upstream.cache;

import java.util.TreeSet;

/* loaded from: classes2.dex */
public final class n implements com.google.android.exoplayer2.upstream.cache.d {

    private final long a;
    private final TreeSet<com.google.android.exoplayer2.upstream.cache.h> b;
    private long c;
    public n(long l) {
        super();
        this.a = l;
        TreeSet obj1 = new TreeSet(b.a);
        this.b = obj1;
    }

    private static int g(com.google.android.exoplayer2.upstream.cache.h h, com.google.android.exoplayer2.upstream.cache.h h2) {
        int obj8;
        final long l = h.x;
        final long l2 = h2.x;
        if (Long.compare(i, i2) == 0) {
            return h.a(h2);
        }
        obj8 = Long.compare(l, l2) < 0 ? -1 : 1;
        return obj8;
    }

    private void h(com.google.android.exoplayer2.upstream.cache.Cache cache, long l2) {
        int empty;
        while (Long.compare(i, l3) > 0) {
            if (!this.b.isEmpty()) {
            }
            cache.d((h)this.b.first());
        }
    }

    public static int i(com.google.android.exoplayer2.upstream.cache.h h, com.google.android.exoplayer2.upstream.cache.h h2) {
        return n.g(h, h2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.d
    public void a(com.google.android.exoplayer2.upstream.cache.Cache cache, String string2, long l3, long l4) {
        if (Long.compare(obj5, obj2) != 0) {
            h(cache, obj5);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.d
    public void b(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.h h2) {
        this.b.remove(h2);
        this.c = l -= obj3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.d
    public void c(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.h h2, com.google.android.exoplayer2.upstream.cache.h h3) {
        b(cache, h2);
        d(cache, h3);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.d
    public void d(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.h h2) {
        this.b.add(h2);
        this.c = l += l2;
        h(cache, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.d
    public void e() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.d
    public boolean f() {
        return 1;
    }
}
