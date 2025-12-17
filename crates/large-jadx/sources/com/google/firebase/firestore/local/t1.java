package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class t1 implements Consumer {

    public final Consumer a;
    public t1(Consumer consumer) {
        super();
        this.a = consumer;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteSchema.o(this.a, (Cursor)object);
    }
}
