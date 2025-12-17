package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

/* loaded from: classes2.dex */
public interface k {
    public static Uri a(com.google.android.exoplayer2.upstream.cache.k k) {
        int parse;
        final String obj2 = k.b("exo_redir", 0);
        if (obj2 == null) {
        } else {
            parse = Uri.parse(obj2);
        }
        return parse;
    }

    public static long d(com.google.android.exoplayer2.upstream.cache.k k) {
        return k.c("exo_len", -1);
    }

    public abstract String b(String string, String string2);

    public abstract long c(String string, long l2);
}
