package com.google.android.exoplayer2.mediacodec;

import java.util.List;

/* loaded from: classes2.dex */
public final class k implements com.google.android.exoplayer2.mediacodec.s {

    public static final com.google.android.exoplayer2.mediacodec.k b;
    static {
        k kVar = new k();
        k.b = kVar;
    }

    @Override // com.google.android.exoplayer2.mediacodec.s
    public final List a(String string, boolean z2, boolean z3) {
        return MediaCodecUtil.n(string, z2, z3);
    }
}
