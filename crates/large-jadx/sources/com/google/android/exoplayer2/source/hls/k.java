package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.util.m0;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface k {

    public static final com.google.android.exoplayer2.source.hls.k a;
    static {
        g gVar = new g();
        k.a = gVar;
    }

    public abstract com.google.android.exoplayer2.source.hls.n a(Uri uri, i1 i12, List<i1> list3, m0 m04, Map<String, List<String>> map5, j j6);
}
