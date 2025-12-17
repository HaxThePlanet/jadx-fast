package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import java.io.EOFException;

/* loaded from: classes2.dex */
public final class h implements com.google.android.exoplayer2.l2.s {

    private final byte[] a;
    public h() {
        super();
        this.a = new byte[4096];
    }

    @Override // com.google.android.exoplayer2.l2.s
    public int a(i i, int i2, boolean z3, int i4) {
        int obj2 = i.read(this.a, 0, Math.min(obj5.length, i2));
        int obj3 = -1;
        if (obj2 == obj3) {
            if (!z3) {
            } else {
                return obj3;
            }
            obj2 = new EOFException();
            throw obj2;
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void d(long l, int i2, int i3, int i4, com.google.android.exoplayer2.l2.s.a s$a5) {
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void e(i1 i1) {
    }

    @Override // com.google.android.exoplayer2.l2.s
    public void f(d0 d0, int i2, int i3) {
        d0.J(i2);
    }
}
