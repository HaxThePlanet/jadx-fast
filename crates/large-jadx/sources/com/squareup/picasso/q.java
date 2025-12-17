package com.squareup.picasso;

/* loaded from: classes2.dex */
public enum q {

    NO_CACHE(true),
    NO_STORE(2),
    OFFLINE(4);

    final int index;
    public static boolean isOfflineOnly(int i) {
        int obj1;
        obj1 = i &= index != 0 ? 1 : 0;
        return obj1;
    }

    public static boolean shouldReadFromDiskCache(int i) {
        int obj1;
        obj1 = i &= index == 0 ? 1 : 0;
        return obj1;
    }

    public static boolean shouldWriteToDiskCache(int i) {
        int obj1;
        obj1 = i &= index == 0 ? 1 : 0;
        return obj1;
    }
}
