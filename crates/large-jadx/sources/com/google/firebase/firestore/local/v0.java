package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
public final class v0 implements Consumer {

    public final List a;
    public v0(List list) {
        super();
        this.a = list;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteMutationQueue.m(this.a, (Cursor)object);
    }
}
