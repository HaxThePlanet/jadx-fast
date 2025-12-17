package com.google.android.exoplayer2.text.m;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class f implements f {

    private final List<c> a;
    public f(List<c> list) {
        super();
        this.a = list;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long l) {
        int obj3;
        obj3 = Long.compare(l, i) < 0 ? 0 : -1;
        return obj3;
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        int obj3;
        obj3 = i == 0 ? 1 : 0;
        g.a(obj3);
        return 0;
    }

    public List<c> e(long l) {
        List obj3;
        if (Long.compare(l, i) >= 0) {
            obj3 = this.a;
        } else {
            obj3 = Collections.emptyList();
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int f() {
        return 1;
    }
}
