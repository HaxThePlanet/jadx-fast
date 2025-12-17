package com.google.android.exoplayer2.n2;

import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.source.m0.e;
import java.util.List;

/* loaded from: classes2.dex */
public final class h extends com.google.android.exoplayer2.n2.e {

    private final int g;
    private final Object h;
    public h(k0 k0, int i2, int i3) {
        super(k0, i2, i3, 0, 0);
    }

    public h(k0 k0, int i2, int i3, int i4, Object object5) {
        int[] iArr = new int[1];
        super(k0, iArr, i3);
        this.g = i4;
        this.h = object5;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public int b() {
        return 0;
    }

    public void l(long l, long l2, long l3, List<? extends d> list4, e[] e5Arr5) {
    }

    @Override // com.google.android.exoplayer2.n2.e
    public int o() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.n2.e
    public Object q() {
        return this.h;
    }
}
