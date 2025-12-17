package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class b0 implements Function {

    public final com.google.firebase.firestore.local.SQLiteDocumentOverlay a;
    public b0(com.google.firebase.firestore.local.SQLiteDocumentOverlay sQLiteDocumentOverlay) {
        super();
        this.a = sQLiteDocumentOverlay;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return this.a.b((Cursor)object);
    }
}
