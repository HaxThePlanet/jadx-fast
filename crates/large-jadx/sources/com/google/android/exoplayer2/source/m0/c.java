package com.google.android.exoplayer2.source.m0;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class c extends com.google.android.exoplayer2.source.m0.b {

    private byte[] j;
    private volatile boolean k;
    public c(l l, n n2, int i3, i1 i14, int i5, Object object6, byte[] b7Arr7) {
        byte[] bArr;
        Object obj;
        super(l, n2, i3, i14, i5, object6, -9223372036854775807L, obj8, -9223372036854775807L, obj10);
        if (b7Arr7 == null) {
            bArr = p0.f;
            obj = this;
        } else {
            obj = this;
            bArr = b7Arr7;
        }
        obj.j = bArr;
    }

    private void i(int i) {
        int obj3;
        final byte[] bArr = this.j;
        if (bArr.length < i += 16384) {
            this.j = Arrays.copyOf(bArr, obj3 += 16384);
        }
    }

    @Override // com.google.android.exoplayer2.source.m0.b
    public final void a() {
        int read;
        boolean z;
        int i2;
        int i;
        byte[] bArr;
        int i3;
        try {
            this.i.c(this.b);
            i2 = read;
            i = -1;
            while (read != i) {
                if (!this.k) {
                }
                i(i2);
                read = this.i.read(this.j, i2, 16384);
                if (read != i) {
                }
                i = -1;
                i2 += read;
            }
            if (!this.k) {
            }
            i(i2);
            read = this.i.read(this.j, i2, 16384);
            if (read != i) {
            }
            i2 += read;
            if (!this.k) {
            }
            g(this.j, i2);
            p0.l(this.i);
            p0.l(this.i);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.m0.b
    public final void b() {
        this.k = true;
    }

    @Override // com.google.android.exoplayer2.source.m0.b
    protected abstract void g(byte[] bArr, int i2);

    @Override // com.google.android.exoplayer2.source.m0.b
    public byte[] h() {
        return this.j;
    }
}
