package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface l extends com.google.android.exoplayer2.upstream.i {

    public interface a {
        public abstract com.google.android.exoplayer2.upstream.l a();
    }
    @Override // com.google.android.exoplayer2.upstream.i
    public abstract long c(com.google.android.exoplayer2.upstream.n n);

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void close();

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract void d(com.google.android.exoplayer2.upstream.b0 b0);

    public Map<String, List<String>> h() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public abstract Uri l();
}
