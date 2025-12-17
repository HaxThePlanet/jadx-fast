package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
final class p implements f0 {

    private final int a;
    private final com.google.android.exoplayer2.source.hls.q b;
    private int c = -1;
    public p(com.google.android.exoplayer2.source.hls.q q, int i2) {
        super();
        this.b = q;
        this.a = i2;
        final int obj1 = -1;
    }

    private boolean f() {
        int i;
        int i2;
        int i3 = this.c;
        if (i3 != -1 && i3 != -3 && i3 != -2) {
            if (i3 != -3) {
                i = i3 != -2 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.f0
    public boolean a() {
        boolean i2;
        int i;
        int i3;
        if (this.c != -3) {
            if (f() && this.b.O(this.c)) {
                if (this.b.O(this.c)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.f0
    public int b(j1 j1, DecoderInputBuffer decoderInputBuffer2, int i3) {
        boolean z;
        int i;
        if (this.c == -3) {
            decoderInputBuffer2.i(4);
            return -4;
        }
        if (f()) {
            i = this.b.d0(this.c, j1, decoderInputBuffer2, i3);
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.f0
    public void c() {
        int i;
        int i2;
        i = this.c;
        if (i == -2) {
        } else {
            if (i == -1) {
                this.b.T();
            } else {
                if (i != -3) {
                    this.b.U(i);
                }
            }
        }
        SampleQueueMappingException sampleQueueMappingException = new SampleQueueMappingException(i1Var.D);
        throw sampleQueueMappingException;
    }

    @Override // com.google.android.exoplayer2.source.f0
    public int d(long l) {
        com.google.android.exoplayer2.source.hls.q z;
        int i;
        int obj3;
        if (f()) {
            obj3 = this.b.n0(this.c, l);
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.source.f0
    public void e() {
        int i;
        i = this.c == -1 ? 1 : 0;
        g.a(i);
        this.c = this.b.w(this.a);
    }

    @Override // com.google.android.exoplayer2.source.f0
    public void g() {
        int i;
        int i2;
        final int i3 = -1;
        if (this.c != i3) {
            this.b.o0(this.a);
            this.c = i3;
        }
    }
}
