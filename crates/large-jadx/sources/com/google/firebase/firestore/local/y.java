package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class y implements Consumer {

    public final long[] a;
    public y(long[] lArr) {
        super();
        this.a = lArr;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        MemoryLruReferenceDelegate.a(this.a, (Long)object);
    }
}
