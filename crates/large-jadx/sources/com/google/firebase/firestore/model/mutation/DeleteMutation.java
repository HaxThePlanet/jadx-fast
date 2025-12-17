package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import java.util.List;

/* loaded from: classes2.dex */
public final class DeleteMutation extends com.google.firebase.firestore.model.mutation.Mutation {
    public DeleteMutation(DocumentKey documentKey, com.google.firebase.firestore.model.mutation.Precondition precondition2) {
        super(documentKey, precondition2);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public com.google.firebase.firestore.model.mutation.FieldMask applyToLocalView(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.FieldMask fieldMask2, Timestamp timestamp3) {
        verifyKeyMatches(mutableDocument);
        if (getPrecondition().isValidFor(mutableDocument)) {
            mutableDocument.convertToNoDocument(mutableDocument.getVersion()).setHasLocalMutations();
            return null;
        }
        return fieldMask2;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.MutationResult mutationResult2) {
        verifyKeyMatches(mutableDocument);
        Assert.hardAssert(mutationResult2.getTransformResults().isEmpty(), "Transform results received by DeleteMutation.", new Object[0]);
        mutableDocument.convertToNoDocument(mutationResult2.getVersion()).setHasCommittedMutations();
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.mutation.DeleteMutation> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && DeleteMutation.class != object.getClass()) {
            if (DeleteMutation.class != object.getClass()) {
            }
            return hasSameKeyAndPrecondition((DeleteMutation)object);
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
        stringBuilder.append("DeleteMutation{");
        stringBuilder.append(keyAndPreconditionToString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
