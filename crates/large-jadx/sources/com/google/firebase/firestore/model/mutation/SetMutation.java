package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class SetMutation extends com.google.firebase.firestore.model.mutation.Mutation {

    private final ObjectValue value;
    public SetMutation(DocumentKey documentKey, ObjectValue objectValue2, com.google.firebase.firestore.model.mutation.Precondition precondition3) {
        ArrayList arrayList = new ArrayList();
        super(documentKey, objectValue2, precondition3, arrayList);
    }

    public SetMutation(DocumentKey documentKey, ObjectValue objectValue2, com.google.firebase.firestore.model.mutation.Precondition precondition3, List<com.google.firebase.firestore.model.mutation.FieldTransform> list4) {
        super(documentKey, precondition3, list4);
        this.value = objectValue2;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public com.google.firebase.firestore.model.mutation.FieldMask applyToLocalView(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.FieldMask fieldMask2, Timestamp timestamp3) {
        verifyKeyMatches(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            return fieldMask2;
        }
        ObjectValue obj4 = this.value.clone();
        obj4.setAll(localTransformResults(timestamp3, mutableDocument));
        mutableDocument.convertToFoundDocument(mutableDocument.getVersion(), obj4).setHasLocalMutations();
        return null;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.MutationResult mutationResult2) {
        verifyKeyMatches(mutableDocument);
        ObjectValue clone = this.value.clone();
        clone.setAll(serverTransformResults(mutableDocument, mutationResult2.getTransformResults()));
        mutableDocument.convertToFoundDocument(mutationResult2.getVersion(), clone).setHasCommittedMutations();
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public boolean equals(Object object) {
        int i;
        List sameKeyAndPrecondition;
        Class<com.google.firebase.firestore.model.mutation.SetMutation> obj;
        Object class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (SetMutation.class != object.getClass()) {
            } else {
                if (hasSameKeyAndPrecondition((SetMutation)object) && this.value.equals(object.value) && getFieldTransforms().equals(object.getFieldTransforms())) {
                    if (this.value.equals(object.value)) {
                        if (getFieldTransforms().equals(object.getFieldTransforms())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public ObjectValue getValue() {
        return this.value;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public int hashCode() {
        return i += i3;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SetMutation{");
        stringBuilder.append(keyAndPreconditionToString());
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
