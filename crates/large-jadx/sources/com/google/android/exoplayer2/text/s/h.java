package com.google.android.exoplayer2.text.s;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class h implements f {

    private final com.google.android.exoplayer2.text.s.d a;
    private final long[] b;
    private final Map<String, com.google.android.exoplayer2.text.s.g> c;
    private final Map<String, com.google.android.exoplayer2.text.s.e> v;
    private final Map<String, String> w;
    public h(com.google.android.exoplayer2.text.s.d d, Map<String, com.google.android.exoplayer2.text.s.g> map2, Map<String, com.google.android.exoplayer2.text.s.e> map3, Map<String, String> map4) {
        Map obj2;
        super();
        this.a = d;
        this.v = map3;
        this.w = map4;
        if (map2 != null) {
            obj2 = Collections.unmodifiableMap(map2);
        } else {
            obj2 = Collections.emptyMap();
        }
        this.c = obj2;
        this.b = d.j();
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
        return this.b[i];
    }

    public List<c> e(long l) {
        return this.a.h(l, obj2, this.c, this.v);
    }

    @Override // com.google.android.exoplayer2.text.f
    public int f() {
        return lArr.length;
    }
}
