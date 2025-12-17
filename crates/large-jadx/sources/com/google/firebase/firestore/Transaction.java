package com.google.firebase.firestore;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.core.UserData.ParsedUpdateData;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class Transaction {

    private final com.google.firebase.firestore.FirebaseFirestore firestore;
    private final Transaction transaction;

    public interface Function {
        public abstract TResult apply(com.google.firebase.firestore.Transaction transaction);
    }
    Transaction(Transaction transaction, com.google.firebase.firestore.FirebaseFirestore firebaseFirestore2) {
        super();
        this.transaction = (Transaction)Preconditions.checkNotNull(transaction);
        this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(firebaseFirestore2);
    }

    private com.google.firebase.firestore.DocumentSnapshot a(j j) {
        if (!j.isSuccessful()) {
        } else {
            Object obj4 = j.getResult();
            final int i2 = 0;
            if ((List)obj4.size() != 1) {
            } else {
                obj4 = obj4.get(i2);
                if ((MutableDocument)obj4.isFoundDocument()) {
                    return DocumentSnapshot.fromDocument(this.firestore, obj4, i2, i2);
                }
                if (!obj4.isNoDocument()) {
                } else {
                    return DocumentSnapshot.fromNoDocument(this.firestore, obj4.getKey(), i2);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("BatchGetDocumentsRequest returned unexpected document type: ");
                stringBuilder.append(obj4.getClass().getCanonicalName());
                throw Assert.fail(stringBuilder.toString(), new Object[i2]);
            }
            throw Assert.fail("Mismatch in docs returned from document lookup.", new Object[i2]);
        }
        throw j.getException();
    }

    private j<com.google.firebase.firestore.DocumentSnapshot> getAsync(com.google.firebase.firestore.DocumentReference documentReference) {
        q qVar = new q(this);
        return this.transaction.lookup(Collections.singletonList(documentReference.getKey())).continueWith(Executors.DIRECT_EXECUTOR, qVar);
    }

    private com.google.firebase.firestore.Transaction update(com.google.firebase.firestore.DocumentReference documentReference, UserData.ParsedUpdateData userData$ParsedUpdateData2) {
        this.firestore.validateReference(documentReference);
        this.transaction.update(documentReference.getKey(), parsedUpdateData2);
        return this;
    }

    public com.google.firebase.firestore.DocumentSnapshot b(j j) {
        return a(j);
    }

    public com.google.firebase.firestore.Transaction delete(com.google.firebase.firestore.DocumentReference documentReference) {
        this.firestore.validateReference(documentReference);
        this.transaction.delete(documentReference.getKey());
        return this;
    }

    public com.google.firebase.firestore.DocumentSnapshot get(com.google.firebase.firestore.DocumentReference documentReference) {
        this.firestore.validateReference(documentReference);
        return (DocumentSnapshot)m.a(getAsync(documentReference));
    }

    public com.google.firebase.firestore.Transaction set(com.google.firebase.firestore.DocumentReference documentReference, Object object2) {
        return set(documentReference, object2, SetOptions.OVERWRITE);
    }

    public com.google.firebase.firestore.Transaction set(com.google.firebase.firestore.DocumentReference documentReference, Object object2, com.google.firebase.firestore.SetOptions setOptions3) {
        com.google.firebase.firestore.UserDataReader userDataReader;
        com.google.firebase.firestore.core.UserData.ParsedSetData obj3;
        Object obj4;
        this.firestore.validateReference(documentReference);
        Preconditions.checkNotNull(object2, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions3, "Provided options must not be null.");
        if (setOptions3.isMerge()) {
            obj3 = this.firestore.getUserDataReader().parseMergeData(object2, setOptions3.getFieldMask());
        } else {
            obj3 = this.firestore.getUserDataReader().parseSetData(object2);
        }
        this.transaction.set(documentReference.getKey(), obj3);
        return this;
    }

    public com.google.firebase.firestore.Transaction update(com.google.firebase.firestore.DocumentReference documentReference, com.google.firebase.firestore.FieldPath fieldPath2, Object object3, Object... object4Arr4) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, fieldPath2, object3, object4Arr4)));
    }

    public com.google.firebase.firestore.Transaction update(com.google.firebase.firestore.DocumentReference documentReference, String string2, Object object3, Object... object4Arr4) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, string2, object3, object4Arr4)));
    }

    public com.google.firebase.firestore.Transaction update(com.google.firebase.firestore.DocumentReference documentReference, Map<String, Object> map2) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(map2));
    }
}
