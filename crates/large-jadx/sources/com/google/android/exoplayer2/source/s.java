package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class s {

    private static final AtomicLong b;
    public final Map<String, List<String>> a;
    static {
        AtomicLong atomicLong = new AtomicLong();
        s.b = atomicLong;
    }

    public s(long l, n n2, long l3) {
        final Object obj2 = l3;
        super(l, obj2, obj2, obj2.a, Collections.emptyMap(), obj16, obj7, 0, obj9, 0, obj11);
    }

    public s(long l, n n2, Uri uri3, Map<String, List<String>> map4, long l5, long l6, long l7) {
        super();
        this.a = l5;
    }

    public static long a() {
        return s.b.getAndIncrement();
    }
}
