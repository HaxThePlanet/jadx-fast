package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a0 implements com.google.android.exoplayer2.upstream.l {

    private final com.google.android.exoplayer2.upstream.l a;
    private final com.google.android.exoplayer2.upstream.k b;
    private boolean c;
    private long d;
    public a0(com.google.android.exoplayer2.upstream.l l, com.google.android.exoplayer2.upstream.k k2) {
        super();
        g.e(l);
        this.a = (l)l;
        g.e(k2);
        this.b = (k)k2;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long c(com.google.android.exoplayer2.upstream.n n) {
        int cmp;
        com.google.android.exoplayer2.upstream.n obj9;
        long l = this.a.c(n);
        this.d = l;
        final int i2 = 0;
        if (Long.compare(l, i2) == 0) {
            return i2;
        }
        final int i3 = -1;
        if (Long.compare(l3, i3) == 0 && Long.compare(l, i3) != 0) {
            if (Long.compare(l, i3) != 0) {
                obj9 = n.f(i2, obj3);
            }
        }
        this.c = true;
        this.b.c(obj9);
        return this.d;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        int i;
        Throwable th;
        boolean z;
        this.a.close();
        if (this.c) {
            try {
                this.c = false;
                this.b.close();
                if (!this.c) {
                } else {
                }
                this.c = z2;
                boolean z2 = this.b;
                z2.close();
                throw th;
            }
        }
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
        com.google.android.exoplayer2.upstream.l cmp;
        byte[] obj5;
        if (Long.compare(l, i4) == 0) {
            return -1;
        }
        final int obj7 = this.a.read(bArr, i2, i3);
        this.b.b(bArr, i2, obj7);
        obj5 = this.d;
        if (obj7 > 0 && Long.compare(obj5, i) != 0) {
            this.b.b(bArr, i2, obj7);
            obj5 = this.d;
            if (Long.compare(obj5, i) != 0) {
                this.d = obj5 -= cmp;
            }
        }
        return obj7;
    }
}
