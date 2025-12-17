package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.util.g;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class j extends f implements com.google.android.exoplayer2.text.f {

    private com.google.android.exoplayer2.text.f v;
    private long w;
    @Override // com.google.android.exoplayer2.decoder.f
    public int a(long l) {
        final com.google.android.exoplayer2.text.f fVar = this.v;
        g.e(fVar);
        return (f)fVar.a(l -= l2);
    }

    @Override // com.google.android.exoplayer2.decoder.f
    public long c(int i) {
        com.google.android.exoplayer2.text.f fVar = this.v;
        g.e(fVar);
        return l += l2;
    }

    public List<com.google.android.exoplayer2.text.c> e(long l) {
        final com.google.android.exoplayer2.text.f fVar = this.v;
        g.e(fVar);
        return (f)fVar.e(l -= l2);
    }

    @Override // com.google.android.exoplayer2.decoder.f
    public int f() {
        com.google.android.exoplayer2.text.f fVar = this.v;
        g.e(fVar);
        return (f)fVar.f();
    }

    @Override // com.google.android.exoplayer2.decoder.f
    public void j() {
        super.j();
        this.v = 0;
    }

    @Override // com.google.android.exoplayer2.decoder.f
    public void t(long l, com.google.android.exoplayer2.text.f f2, long l3) {
        long obj3;
        this.b = l;
        this.v = l3;
        if (Long.compare(obj6, l2) == 0) {
        } else {
            obj3 = obj6;
        }
        this.w = obj3;
    }
}
