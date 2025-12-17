package com.google.firebase.firestore.util;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class d implements Comparator {

    public static final com.google.firebase.firestore.util.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return AsyncQueue.e((AsyncQueue.DelayedTask)object, (AsyncQueue.DelayedTask)object2);
    }
}
