package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.m;

/* loaded from: classes2.dex */
public final class b implements m {

    public final Exception a;
    public b(Exception exception) {
        super();
        this.a = exception;
    }

    @Override // com.google.android.exoplayer2.util.m
    public final void accept(Object object) {
        DefaultDrmSession.p(this.a, (u.a)object);
    }
}
