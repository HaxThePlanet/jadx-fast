package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class k1 implements Consumer {

    public final Consumer a;
    public k1(Consumer consumer) {
        super();
        this.a = consumer;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteSchema.n(this.a, (Cursor)object);
    }
}
