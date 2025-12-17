package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class b implements Comparator {

    public static final com.google.android.exoplayer2.upstream.cache.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return n.i((h)object, (h)object2);
    }
}
