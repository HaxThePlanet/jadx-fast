package com.google.firebase.firestore.local;

import android.database.sqlite.SQLiteStatement;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class i1 implements Consumer {

    public final com.google.firebase.firestore.local.MemoryIndexManager.MemoryCollectionParentIndex a;
    public final SQLiteStatement b;
    public i1(com.google.firebase.firestore.local.MemoryIndexManager.MemoryCollectionParentIndex memoryIndexManager$MemoryCollectionParentIndex, SQLiteStatement sQLiteStatement2) {
        super();
        this.a = memoryCollectionParentIndex;
        this.b = sQLiteStatement2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteSchema.m(this.a, this.b, (ResourcePath)object);
    }
}
