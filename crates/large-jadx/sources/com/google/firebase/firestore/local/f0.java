package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class f0 implements Consumer {

    public final ArrayList a;
    public f0(ArrayList arrayList) {
        super();
        this.a = arrayList;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteIndexManager.d(this.a, (Cursor)object);
    }
}
