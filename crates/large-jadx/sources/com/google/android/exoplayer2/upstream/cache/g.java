package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;

/* loaded from: classes2.dex */
public interface g {

    public static final com.google.android.exoplayer2.upstream.cache.g a;
    static {
        g.a = a.b;
    }

    public static String b(n n) {
        String string;
        Object obj1;
        if (n.h != null) {
        } else {
            string = n.a.toString();
        }
        return string;
    }

    public abstract String a(n n);
}
