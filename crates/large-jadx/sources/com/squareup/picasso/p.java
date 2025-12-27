package com.squareup.picasso;

/* compiled from: MemoryPolicy.java */
/* loaded from: classes2.dex */
public enum p {

    NO_CACHE,
    NO_STORE;

    final int index;
    static boolean shouldReadFromMemoryCache(int i) {
        boolean z = true;
        i = i & p.NO_CACHE.index == 0 ? 1 : 0;
        return (i & p.NO_CACHE.index == 0 ? 1 : 0);
    }

    static boolean shouldWriteToMemoryCache(int i) {
        boolean z = true;
        i = i & p.NO_STORE.index == 0 ? 1 : 0;
        return (i & p.NO_STORE.index == 0 ? 1 : 0);
    }
}
