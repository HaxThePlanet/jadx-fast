package com.squareup.picasso;

/* loaded from: classes2.dex */
public enum p {

    NO_CACHE(true),
    NO_STORE(2);

    final int index;
    static boolean shouldReadFromMemoryCache(int i) {
        int obj1;
        obj1 = i &= index == 0 ? 1 : 0;
        return obj1;
    }

    static boolean shouldWriteToMemoryCache(int i) {
        int obj1;
        obj1 = i &= index == 0 ? 1 : 0;
        return obj1;
    }
}
