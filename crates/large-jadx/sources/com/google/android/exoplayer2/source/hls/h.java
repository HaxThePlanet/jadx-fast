package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class h {

    private final LinkedHashMap<Uri, byte[]> a;

    class a extends LinkedHashMap<Uri, byte[]> {

        final int val$maxSize;
        a(com.google.android.exoplayer2.source.hls.h h, int i2, float f3, boolean z4, int i5) {
            this.val$maxSize = i5;
            super(i2, f3, z4);
        }

        protected boolean removeEldestEntry(Map.Entry<Uri, byte[]> map$Entry) {
            int obj2;
            obj2 = size() > this.val$maxSize ? 1 : 0;
            return obj2;
        }
    }
    public h(int i) {
        super();
        super(this, i + 1, 1065353216, 0, i);
        this.a = aVar2;
    }

    public byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (byte[])this.a.get(uri);
    }

    public byte[] b(Uri uri, byte[] b2Arr2) {
        g.e(uri);
        g.e(b2Arr2);
        return (byte[])this.a.put((Uri)uri, (byte[])b2Arr2);
    }

    public byte[] c(Uri uri) {
        g.e(uri);
        return (byte[])this.a.remove(uri);
    }
}
