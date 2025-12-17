package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.g;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class y implements com.google.android.exoplayer2.upstream.l {

    private final com.google.android.exoplayer2.upstream.l a;
    private final PriorityTaskManager b;
    private final int c;
    public y(com.google.android.exoplayer2.upstream.l l, PriorityTaskManager priorityTaskManager2, int i3) {
        super();
        g.e(l);
        this.a = (l)l;
        g.e(priorityTaskManager2);
        this.b = (PriorityTaskManager)priorityTaskManager2;
        this.c = i3;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long c(com.google.android.exoplayer2.upstream.n n) {
        this.b.b(this.c);
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
    public int read(byte[] bArr, int i2, int i3) {
        this.b.b(this.c);
        return this.a.read(bArr, i2, i3);
    }
}
