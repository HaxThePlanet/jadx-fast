package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class SQLiteCollectionIndex {

    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private final String uid;
    SQLiteCollectionIndex(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, User user2) {
        String obj1;
        super();
        this.db = sQLitePersistence;
        if (user2.isAuthenticated()) {
            obj1 = user2.getUid();
        } else {
            obj1 = "";
        }
        this.uid = obj1;
    }

    public void addEntry(FieldPath fieldPath, x x2, DocumentKey documentKey3) {
        RuntimeException obj1 = new RuntimeException("Not yet implemented.");
        throw obj1;
    }

    public com.google.firebase.firestore.local.IndexCursor getCursor(ResourcePath resourcePath, IndexRange indexRange2) {
        RuntimeException obj1 = new RuntimeException("Not yet implemented.");
        throw obj1;
    }

    public void removeEntry(FieldPath fieldPath, x x2, DocumentKey documentKey3) {
        RuntimeException obj1 = new RuntimeException("Not yet implemented.");
        throw obj1;
    }
}
