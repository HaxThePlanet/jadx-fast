package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.upstream.i;

/* loaded from: classes2.dex */
public interface j extends i {
    @Override // com.google.android.exoplayer2.upstream.i
    public abstract boolean a(byte[] bArr, int i2, int i3, boolean z4);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract boolean e(byte[] bArr, int i2, int i3, boolean z4);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract long f();

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void g(int i);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract long getLength();

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract long getPosition();

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void i();

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void j(int i);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract boolean k(int i, boolean z2);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void m(byte[] bArr, int i2, int i3);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract int read(byte[] bArr, int i2, int i3);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void readFully(byte[] bArr, int i2, int i3);
}
