package com.google.android.exoplayer2.source.m0;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
public abstract class d extends com.google.android.exoplayer2.source.m0.b {

    public final long j;
    public d(l l, n n2, i1 i13, int i4, Object object5, long l6, long l7, long l8) {
        final Object obj = this;
        super(l, n2, 1, i13, i4, object5, l6, obj8, l8, obj10);
        g.e(i13);
        obj.j = obj21;
    }

    @Override // com.google.android.exoplayer2.source.m0.b
    public long g() {
        int i;
        final long l = this.j;
        if (Long.compare(l, i) != 0) {
            i2 += l;
        }
        return i;
    }
}
