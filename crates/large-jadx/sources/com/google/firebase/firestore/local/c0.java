package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.TargetIndexMatcher;
import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
public final class c0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteIndexManager a;
    public final String b;
    public final TargetIndexMatcher c;
    public final List d;
    public c0(com.google.firebase.firestore.local.SQLiteIndexManager sQLiteIndexManager, String string2, TargetIndexMatcher targetIndexMatcher3, List list4) {
        super();
        this.a = sQLiteIndexManager;
        this.b = string2;
        this.c = targetIndexMatcher3;
        this.d = list4;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.i(this.b, this.c, this.d, (Cursor)object);
    }
}
