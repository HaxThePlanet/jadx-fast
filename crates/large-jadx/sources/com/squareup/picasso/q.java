package com.squareup.picasso;

/* compiled from: NetworkPolicy.java */
/* loaded from: classes2.dex */
public enum q {

    NO_CACHE,
    NO_STORE,
    OFFLINE;

    final int index;
    public static boolean isOfflineOnly(int i) {
        boolean z = true;
        i = i & q.OFFLINE.index != 0 ? 1 : 0;
        return (i & q.OFFLINE.index != 0 ? 1 : 0);
    }

    public static boolean shouldReadFromDiskCache(int i) {
        boolean z = true;
        i = i & q.NO_CACHE.index == 0 ? 1 : 0;
        return (i & q.NO_CACHE.index == 0 ? 1 : 0);
    }

    public static boolean shouldWriteToDiskCache(int i) {
        boolean z = true;
        i = i & q.NO_STORE.index == 0 ? 1 : 0;
        return (i & q.NO_STORE.index == 0 ? 1 : 0);
    }
}
