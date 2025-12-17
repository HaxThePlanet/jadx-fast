package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class VerifyMutation extends com.google.firebase.firestore.model.mutation.Mutation {
    public VerifyMutation(DocumentKey documentKey, com.google.firebase.firestore.model.mutation.Precondition precondition2) {
        super(documentKey, precondition2);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public com.google.firebase.firestore.model.mutation.FieldMask applyToLocalView(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.FieldMask fieldMask2, Timestamp timestamp3) {
        throw Assert.fail("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.MutationResult mutationResult2) {
        throw Assert.fail("VerifyMutation should only be used in Transactions.", new Object[0]);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.mutation.VerifyMutation> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && VerifyMutation.class != object.getClass()) {
            if (VerifyMutation.class != object.getClass()) {
            }
            return hasSameKeyAndPrecondition((VerifyMutation)object);
        }
        return 0;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public int hashCode() {
        return keyAndPreconditionHashCode();
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerifyMutation{");
        stringBuilder.append(keyAndPreconditionToString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
