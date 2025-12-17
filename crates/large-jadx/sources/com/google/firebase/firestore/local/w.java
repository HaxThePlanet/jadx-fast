package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class w implements Comparator {

    public static final com.google.firebase.firestore.local.w a;
    static {
        w wVar = new w();
        w.a = wVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return LruGarbageCollector.RollingSequenceNumberBuffer.a((Long)object, (Long)object2);
    }
}
