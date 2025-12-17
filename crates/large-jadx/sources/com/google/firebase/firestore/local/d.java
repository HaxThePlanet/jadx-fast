package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class d implements Function {

    public final int a;
    public d(int i) {
        super();
        this.a = i;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return IndexBackfiller.a(this.a, (Cursor)object);
    }
}
