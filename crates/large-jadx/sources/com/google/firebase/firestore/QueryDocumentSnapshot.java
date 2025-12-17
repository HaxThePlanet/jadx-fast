package com.google.firebase.firestore;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Map;

/* loaded from: classes2.dex */
public class QueryDocumentSnapshot extends com.google.firebase.firestore.DocumentSnapshot {
    private QueryDocumentSnapshot(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, DocumentKey documentKey2, Document document3, boolean z4, boolean z5) {
        super(firebaseFirestore, documentKey2, document3, z4, z5);
    }

    static com.google.firebase.firestore.QueryDocumentSnapshot fromDocument(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, Document document2, boolean z3, boolean z4) {
        super(firebaseFirestore, document2.getKey(), document2, z3, z4);
        return queryDocumentSnapshot2;
    }

    public Map<String, Object> getData() {
        int i;
        final Map data = super.getData();
        int i2 = 0;
        i = data != null ? 1 : i2;
        Assert.hardAssert(i, "Data in a QueryDocumentSnapshot should be non-null", new Object[i2]);
        return data;
    }

    public Map<String, Object> getData(com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior) {
        int i;
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        final Map obj4 = super.getData(serverTimestampBehavior);
        int i2 = 0;
        i = obj4 != null ? 1 : i2;
        Assert.hardAssert(i, "Data in a QueryDocumentSnapshot should be non-null", new Object[i2]);
        return obj4;
    }

    public <T> T toObject(Class<T> class) {
        int i;
        final Object obj4 = super.toObject(class);
        int i2 = 0;
        i = obj4 != null ? 1 : i2;
        Assert.hardAssert(i, "Object in a QueryDocumentSnapshot should be non-null", new Object[i2]);
        return obj4;
    }

    public <T> T toObject(Class<T> class, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        int i;
        Preconditions.checkNotNull(serverTimestampBehavior2, "Provided serverTimestampBehavior value must not be null.");
        final Object obj3 = super.toObject(class, serverTimestampBehavior2);
        int obj4 = 0;
        i = obj3 != null ? 1 : obj4;
        Assert.hardAssert(i, "Object in a QueryDocumentSnapshot should be non-null", new Object[obj4]);
        return obj3;
    }
}
