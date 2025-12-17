package com.google.firebase.firestore;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.core.UserData.ParsedSetData;
import com.google.firebase.firestore.core.UserData.ParsedUpdateData;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class WriteBatch {

    private boolean committed = false;
    private final com.google.firebase.firestore.FirebaseFirestore firestore;
    private final ArrayList<Mutation> mutations;

    public interface Function {
        public abstract void apply(com.google.firebase.firestore.WriteBatch writeBatch);
    }
    WriteBatch(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore) {
        super();
        ArrayList arrayList = new ArrayList();
        this.mutations = arrayList;
        int i = 0;
        this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(firebaseFirestore);
    }

    private com.google.firebase.firestore.WriteBatch update(com.google.firebase.firestore.DocumentReference documentReference, UserData.ParsedUpdateData userData$ParsedUpdateData2) {
        this.firestore.validateReference(documentReference);
        verifyNotCommitted();
        this.mutations.add(parsedUpdateData2.toMutation(documentReference.getKey(), Precondition.exists(true)));
        return this;
    }

    private void verifyNotCommitted() {
        if (this.committed) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("A write batch can no longer be used after commit() has been called.");
        throw illegalStateException;
    }

    public j<Void> commit() {
        verifyNotCommitted();
        this.committed = true;
        if (this.mutations.size() > 0) {
            return this.firestore.getClient().write(this.mutations);
        }
        return m.e(0);
    }

    public com.google.firebase.firestore.WriteBatch delete(com.google.firebase.firestore.DocumentReference documentReference) {
        this.firestore.validateReference(documentReference);
        verifyNotCommitted();
        DeleteMutation deleteMutation = new DeleteMutation(documentReference.getKey(), Precondition.NONE);
        this.mutations.add(deleteMutation);
        return this;
    }

    public com.google.firebase.firestore.WriteBatch set(com.google.firebase.firestore.DocumentReference documentReference, Object object2) {
        return set(documentReference, object2, SetOptions.OVERWRITE);
    }

    public com.google.firebase.firestore.WriteBatch set(com.google.firebase.firestore.DocumentReference documentReference, Object object2, com.google.firebase.firestore.SetOptions setOptions3) {
        com.google.firebase.firestore.UserDataReader userDataReader;
        UserData.ParsedSetData obj3;
        Object obj4;
        this.firestore.validateReference(documentReference);
        Preconditions.checkNotNull(object2, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions3, "Provided options must not be null.");
        verifyNotCommitted();
        if (setOptions3.isMerge()) {
            obj3 = this.firestore.getUserDataReader().parseMergeData(object2, setOptions3.getFieldMask());
        } else {
            obj3 = this.firestore.getUserDataReader().parseSetData(object2);
        }
        this.mutations.add(obj3.toMutation(documentReference.getKey(), Precondition.NONE));
        return this;
    }

    public com.google.firebase.firestore.WriteBatch update(com.google.firebase.firestore.DocumentReference documentReference, com.google.firebase.firestore.FieldPath fieldPath2, Object object3, Object... object4Arr4) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, fieldPath2, object3, object4Arr4)));
    }

    public com.google.firebase.firestore.WriteBatch update(com.google.firebase.firestore.DocumentReference documentReference, String string2, Object object3, Object... object4Arr4) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(Util.collectUpdateArguments(1, string2, object3, object4Arr4)));
    }

    public com.google.firebase.firestore.WriteBatch update(com.google.firebase.firestore.DocumentReference documentReference, Map<String, Object> map2) {
        return update(documentReference, this.firestore.getUserDataReader().parseUpdateData(map2));
    }
}
