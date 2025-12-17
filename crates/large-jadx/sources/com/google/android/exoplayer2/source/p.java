package com.google.android.exoplayer2.source;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.exoplayer2.l2.m;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.r;
import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
public final class p implements com.google.android.exoplayer2.source.a0 {

    private final l.a a;
    private final SparseArray<com.google.android.exoplayer2.source.a0> b;
    private final int[] c;
    public p(Context context, m m2) {
        r rVar = new r(context);
        super(rVar, m2);
    }

    public p(l.a l$a, m m2) {
        int keyAt;
        int obj2;
        m obj3;
        super();
        this.a = a;
        obj2 = p.a(a, m2);
        this.b = obj2;
        this.c = new int[obj2.size()];
        obj2 = 0;
        while (obj2 < this.b.size()) {
            this.c[obj2] = this.b.keyAt(obj2);
            obj2++;
        }
    }

    private static SparseArray<com.google.android.exoplayer2.source.a0> a(l.a l$a, m m2) {
        Class<l.a> obj = l.a.class;
        Class<com.google.android.exoplayer2.source.a0> obj2 = a0.class;
        SparseArray sparseArray = new SparseArray();
        int i3 = 1;
        final int i4 = 0;
        Class[] arr4 = new Class[i3];
        arr4[i4] = obj;
        Object[] arr5 = new Object[i3];
        arr5[i4] = a;
        sparseArray.put(i4, (a0)Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(obj2).getConstructor(arr4).newInstance(arr5));
        Class[] arr6 = new Class[i3];
        arr6[i4] = obj;
        Object[] arr7 = new Object[i3];
        arr7[i4] = a;
        sparseArray.put(i3, (a0)Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(obj2).getConstructor(arr6).newInstance(arr7));
        final Class[] arr8 = new Class[i3];
        arr8[i4] = obj;
        Object[] arr = new Object[i3];
        arr[i4] = a;
        sparseArray.put(2, (a0)Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(obj2).getConstructor(arr8).newInstance(arr));
        sparseArray.put(3, (a0)Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(obj2).getConstructor(new Class[i4]).newInstance(new Object[i4]));
        c0 c0Var = new c0(a, m2);
        sparseArray.put(4, c0Var);
        return sparseArray;
    }
}
