package com.google.firebase.firestore;

import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public class CollectionReference extends com.google.firebase.firestore.Query {
    CollectionReference(ResourcePath resourcePath, com.google.firebase.firestore.FirebaseFirestore firebaseFirestore2) {
        super(Query.atPath(resourcePath), firebaseFirestore2);
        if (obj4 %= 2 != 1) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid collection reference. Collection references must have an odd number of segments, but ");
        stringBuilder.append(resourcePath.canonicalString());
        stringBuilder.append(" has ");
        stringBuilder.append(resourcePath.length());
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    static com.google.firebase.firestore.DocumentReference f(com.google.firebase.firestore.DocumentReference documentReference, j j2) {
        j2.getResult();
        return documentReference;
    }

    public j<com.google.firebase.firestore.DocumentReference> add(Object object) {
        Preconditions.checkNotNull(object, "Provided data must not be null.");
        com.google.firebase.firestore.DocumentReference document = document();
        a aVar = new a(document);
        return document.set(object).continueWith(Executors.DIRECT_EXECUTOR, aVar);
    }

    @Override // com.google.firebase.firestore.Query
    public com.google.firebase.firestore.DocumentReference document() {
        return document(Util.autoId());
    }

    @Override // com.google.firebase.firestore.Query
    public com.google.firebase.firestore.DocumentReference document(String string) {
        Preconditions.checkNotNull(string, "Provided document path must not be null.");
        return DocumentReference.forPath((ResourcePath)this.query.getPath().append(ResourcePath.fromString(string)), this.firestore);
    }

    @Override // com.google.firebase.firestore.Query
    public String getId() {
        return this.query.getPath().getLastSegment();
    }

    @Override // com.google.firebase.firestore.Query
    public com.google.firebase.firestore.DocumentReference getParent() {
        BasePath popLast = this.query.getPath().popLast();
        if ((ResourcePath)popLast.isEmpty()) {
            return null;
        }
        DocumentReference documentReference = new DocumentReference(DocumentKey.fromPath(popLast), this.firestore);
        return documentReference;
    }

    @Override // com.google.firebase.firestore.Query
    public String getPath() {
        return this.query.getPath().canonicalString();
    }
}
