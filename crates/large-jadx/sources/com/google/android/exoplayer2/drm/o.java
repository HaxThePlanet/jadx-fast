package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.OnEventListener;

/* loaded from: classes2.dex */
public final class o implements MediaDrm.OnEventListener {

    public final com.google.android.exoplayer2.drm.d0 a;
    public final com.google.android.exoplayer2.drm.b0.b b;
    public o(com.google.android.exoplayer2.drm.d0 d0, com.google.android.exoplayer2.drm.b0.b b0$b2) {
        super();
        this.a = d0;
        this.b = b2;
    }

    @Override // android.media.MediaDrm$OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] b2Arr2, int i3, int i4, byte[] b5Arr5) {
        this.a.w(this.b, mediaDrm, b2Arr2, i3, i4, b5Arr5);
    }
}
