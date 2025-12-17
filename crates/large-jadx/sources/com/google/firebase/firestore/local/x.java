package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class x implements Consumer {

    public final com.google.firebase.firestore.local.LruGarbageCollector.RollingSequenceNumberBuffer a;
    public x(com.google.firebase.firestore.local.LruGarbageCollector.RollingSequenceNumberBuffer lruGarbageCollector$RollingSequenceNumberBuffer) {
        super();
        this.a = rollingSequenceNumberBuffer;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        LruGarbageCollector.a(this.a, (TargetData)object);
    }
}
