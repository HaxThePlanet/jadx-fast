package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class z implements com.google.android.exoplayer2.upstream.l {

    private final com.google.android.exoplayer2.upstream.l a;
    private long b;
    private Uri c;
    private Map<String, List<String>> d;
    public z(com.google.android.exoplayer2.upstream.l l) {
        super();
        g.e(l);
        this.a = (l)l;
        this.c = Uri.EMPTY;
        this.d = Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long c(com.google.android.exoplayer2.upstream.n n) {
        this.c = n.a;
        this.d = Collections.emptyMap();
        Uri obj3 = l();
        g.e(obj3);
        this.c = (Uri)obj3;
        this.d = h();
        return this.a.c(n);
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        this.a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void d(com.google.android.exoplayer2.upstream.b0 b0) {
        g.e(b0);
        this.a.d(b0);
    }

    public Map<String, List<String>> h() {
        return this.a.h();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public Uri l() {
        return this.a.l();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long n() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public Uri o() {
        return this.c;
    }

    public Map<String, List<String>> p() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void q() {
        this.b = 0;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public int read(byte[] bArr, int i2, int i3) {
        com.google.android.exoplayer2.upstream.l lVar;
        int obj4;
        final int obj3 = this.a.read(bArr, i2, i3);
        if (obj3 != -1) {
            this.b = obj4 += lVar;
        }
        return obj3;
    }
}
