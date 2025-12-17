package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.Set;

/* loaded from: classes2.dex */
public final class h0 implements Consumer {

    public final Set a;
    public h0(Set set) {
        super();
        this.a = set;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteIndexManager.e(this.a, (Cursor)object);
    }
}
