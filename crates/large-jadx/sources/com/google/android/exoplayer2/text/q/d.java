package com.google.android.exoplayer2.text.q;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class d implements f {

    private final List<List<c>> a;
    private final List<Long> b;
    public d(List<List<c>> list, List<Long> list2) {
        super();
        this.a = list;
        this.b = list2;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long l) {
        int obj2;
        int obj3 = 0;
        if (p0.c(this.b, Long.valueOf(l), obj3, obj3) < this.b.size()) {
        } else {
            obj2 = -1;
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        int i3;
        int i2;
        final int i4 = 0;
        i2 = i >= 0 ? i3 : i4;
        g.a(i2);
        if (i < this.b.size()) {
        } else {
            i3 = i4;
        }
        g.a(i3);
        return (Long)this.b.get(i).longValue();
    }

    public List<c> e(long l) {
        int obj3 = p0.f(this.b, Long.valueOf(l), true, false);
        if (obj3 == -1) {
            return Collections.emptyList();
        }
        return (List)this.a.get(obj3);
    }

    @Override // com.google.android.exoplayer2.text.f
    public int f() {
        return this.b.size();
    }
}
