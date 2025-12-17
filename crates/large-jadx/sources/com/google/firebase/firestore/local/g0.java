package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class g0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteIndexManager a;
    public final String b;
    public final Document c;
    public final DocumentKey d;
    public g0(com.google.firebase.firestore.local.SQLiteIndexManager sQLiteIndexManager, String string2, Document document3, DocumentKey documentKey4) {
        super();
        this.a = sQLiteIndexManager;
        this.b = string2;
        this.c = document3;
        this.d = documentKey4;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.c(this.b, this.c, this.d, (Cursor)object);
    }
}
