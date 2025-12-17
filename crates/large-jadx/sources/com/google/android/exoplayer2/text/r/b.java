package com.google.android.exoplayer2.text.r;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class b implements f {

    private final c[] a;
    private final long[] b;
    public b(c[] cArr, long[] l2Arr2) {
        super();
        this.a = cArr;
        this.b = l2Arr2;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long l) {
        int obj3;
        final int i = 0;
        if (p0.d(this.b, l, obj4, i) < obj4.length) {
        } else {
            obj3 = -1;
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        int i2;
        int i3;
        int i4 = 0;
        i3 = i >= 0 ? i2 : i4;
        g.a(i3);
        if (i < lArr2.length) {
        } else {
            i2 = i4;
        }
        g.a(i2);
        return this.b[i];
    }

    public List<c> e(long l) {
        long[] lArr;
        int i;
        int obj5;
        int obj4 = p0.h(this.b, l, obj5, true);
        obj5 = this.a;
        if (obj4 != -1 && obj5[obj4] == c.r) {
            obj5 = this.a;
            if (obj5[obj4] == c.r) {
            }
            return Collections.singletonList(obj5[obj4]);
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.f
    public int f() {
        return lArr.length;
    }
}
