package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.a;
import f.c.e.c.y;

/* loaded from: classes2.dex */
public class SQLiteDocumentOverlay implements com.google.firebase.firestore.local.DocumentOverlay {

    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    private final String uid;
    public SQLiteDocumentOverlay(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LocalSerializer localSerializer2, User user3) {
        String obj1;
        super();
        this.db = sQLitePersistence;
        this.serializer = localSerializer2;
        if (user3.isAuthenticated()) {
            obj1 = user3.getUid();
        } else {
            obj1 = "";
        }
        this.uid = obj1;
    }

    private Mutation a(Cursor cursor) {
        if (cursor != null) {
            return this.serializer.decodeMutation(y.y(cursor.getBlob(0)));
        }
        try {
            return null;
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public Mutation b(Cursor cursor) {
        return a(cursor);
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public Mutation getOverlay(DocumentKey documentKey) {
        Object[] arr = new Object[2];
        b0 b0Var = new b0(this);
        return (Mutation)this.db.query("SELECT overlay_mutation FROM document_overlays WHERE uid = ? AND path = ?").binding(this.uid, EncodedPath.encode(documentKey.getPath())).firstValue(b0Var);
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public void removeOverlay(DocumentKey documentKey) {
        Object[] arr = new Object[2];
        this.db.execute("DELETE FROM document_overlays WHERE uid = ? AND path = ?", this.uid, EncodedPath.encode(documentKey.getPath()));
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public void saveOverlay(DocumentKey documentKey, Mutation mutation2) {
        Object[] arr = new Object[3];
        this.db.execute("INSERT OR REPLACE INTO document_overlays (uid, path, overlay_mutation) VALUES (?, ?, ?)", this.uid, EncodedPath.encode(documentKey.getPath()), this.serializer.encodeMutation(mutation2).toByteArray());
    }
}
