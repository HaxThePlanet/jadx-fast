package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.a;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class h implements a<com.google.android.exoplayer2.source.hls.playlist.h> {

    public final String a;
    public final List<String> b;
    public final boolean c;
    protected h(String string, List<String> list2, boolean z3) {
        super();
        this.a = string;
        this.b = Collections.unmodifiableList(list2);
        this.c = z3;
    }
}
