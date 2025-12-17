package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.m;

/* loaded from: classes2.dex */
public final class c implements m {

    public final int a;
    public c(int i) {
        super();
        this.a = i;
    }

    @Override // com.google.android.exoplayer2.util.m
    public final void accept(Object object) {
        DefaultDrmSession.q(this.a, (u.a)object);
    }
}
