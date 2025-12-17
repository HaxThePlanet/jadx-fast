package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class u implements com.google.android.exoplayer2.upstream.l {

    public static final com.google.android.exoplayer2.upstream.u a;
    static {
        u uVar = new u();
        u.a = uVar;
        com.google.android.exoplayer2.upstream.c cVar = c.a;
    }

    public static com.google.android.exoplayer2.upstream.u n() {
        u uVar = new u();
        return uVar;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long c(com.google.android.exoplayer2.upstream.n n) {
        IOException obj2 = new IOException("DummyDataSource cannot be opened");
        throw obj2;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void d(com.google.android.exoplayer2.upstream.b0 b0) {
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public Uri l() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public int read(byte[] bArr, int i2, int i3) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }
}
