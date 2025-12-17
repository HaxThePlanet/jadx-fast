package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
public final class e0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteIndexManager a;
    public final List b;
    public e0(com.google.firebase.firestore.local.SQLiteIndexManager sQLiteIndexManager, List list2) {
        super();
        this.a = sQLiteIndexManager;
        this.b = list2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.g(this.b, (Cursor)object);
    }
}
