package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import f.c.e.c.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class PatchMutation extends com.google.firebase.firestore.model.mutation.Mutation {

    private final com.google.firebase.firestore.model.mutation.FieldMask mask;
    private final ObjectValue value;
    public PatchMutation(DocumentKey documentKey, ObjectValue objectValue2, com.google.firebase.firestore.model.mutation.FieldMask fieldMask3, com.google.firebase.firestore.model.mutation.Precondition precondition4) {
        ArrayList arrayList = new ArrayList();
        super(documentKey, objectValue2, fieldMask3, precondition4, arrayList);
    }

    public PatchMutation(DocumentKey documentKey, ObjectValue objectValue2, com.google.firebase.firestore.model.mutation.FieldMask fieldMask3, com.google.firebase.firestore.model.mutation.Precondition precondition4, List<com.google.firebase.firestore.model.mutation.FieldTransform> list5) {
        super(documentKey, precondition4, list5);
        this.value = objectValue2;
        this.mask = fieldMask3;
    }

    private List<FieldPath> getFieldTransformPaths() {
        FieldPath fieldPath;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = getFieldTransforms().iterator();
        for (FieldTransform next2 : iterator) {
            arrayList.add(next2.getFieldPath());
        }
        return arrayList;
    }

    private Map<FieldPath, x> getPatch() {
        Object next;
        boolean empty;
        HashMap hashMap = new HashMap();
        Iterator iterator = this.mask.getMask().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!(FieldPath)next.isEmpty()) {
            }
            hashMap.put(next, this.value.get(next));
        }
        return hashMap;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public com.google.firebase.firestore.model.mutation.FieldMask applyToLocalView(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.FieldMask fieldMask2, Timestamp timestamp3) {
        verifyKeyMatches(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            return fieldMask2;
        }
        final ObjectValue data2 = mutableDocument.getData();
        data2.setAll(getPatch());
        data2.setAll(localTransformResults(timestamp3, mutableDocument));
        mutableDocument.convertToFoundDocument(mutableDocument.getVersion(), mutableDocument.getData()).setHasLocalMutations();
        if (fieldMask2 == null) {
            return null;
        }
        HashSet obj3 = new HashSet(fieldMask2.getMask());
        obj3.addAll(this.mask.getMask());
        obj3.addAll(getFieldTransformPaths());
        return FieldMask.fromSet(obj3);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public void applyToRemoteDocument(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.MutationResult mutationResult2) {
        verifyKeyMatches(mutableDocument);
        if (!getPrecondition().isValidFor(mutableDocument)) {
            mutableDocument.convertToUnknownDocument(mutationResult2.getVersion());
        }
        final ObjectValue data2 = mutableDocument.getData();
        data2.setAll(getPatch());
        data2.setAll(serverTransformResults(mutableDocument, mutationResult2.getTransformResults()));
        mutableDocument.convertToFoundDocument(mutationResult2.getVersion(), mutableDocument.getData()).setHasCommittedMutations();
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public boolean equals(Object object) {
        int i;
        List sameKeyAndPrecondition;
        Class<com.google.firebase.firestore.model.mutation.PatchMutation> obj;
        Object class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (PatchMutation.class != object.getClass()) {
            } else {
                if (hasSameKeyAndPrecondition((PatchMutation)object) && this.value.equals(object.value) && getFieldTransforms().equals(object.getFieldTransforms())) {
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
    public com.google.firebase.firestore.model.mutation.FieldMask getMask() {
        return this.mask;
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
        stringBuilder.append("PatchMutation{");
        stringBuilder.append(keyAndPreconditionToString());
        stringBuilder.append(", mask=");
        stringBuilder.append(this.mask);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
