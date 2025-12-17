package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class Mutation {

    private final List<com.google.firebase.firestore.model.mutation.FieldTransform> fieldTransforms;
    private final DocumentKey key;
    private final com.google.firebase.firestore.model.mutation.Precondition precondition;
    Mutation(DocumentKey documentKey, com.google.firebase.firestore.model.mutation.Precondition precondition2) {
        ArrayList arrayList = new ArrayList();
        super(documentKey, precondition2, arrayList);
    }

    Mutation(DocumentKey documentKey, com.google.firebase.firestore.model.mutation.Precondition precondition2, List<com.google.firebase.firestore.model.mutation.FieldTransform> list3) {
        super();
        this.key = documentKey;
        this.precondition = precondition2;
        this.fieldTransforms = list3;
    }

    public abstract com.google.firebase.firestore.model.mutation.FieldMask applyToLocalView(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.FieldMask fieldMask2, Timestamp timestamp3);

    public abstract void applyToRemoteDocument(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.MutationResult mutationResult2);

    public ObjectValue extractTransformBaseValue(Document document) {
        int objectValue;
        Object fieldPath;
        x baseValue;
        com.google.firebase.firestore.model.mutation.TransformOperation operation;
        Iterator iterator = this.fieldTransforms.iterator();
        objectValue = 0;
        while (iterator.hasNext()) {
            fieldPath = iterator.next();
            baseValue = fieldPath.getOperation().computeBaseValue(document.getField((FieldTransform)fieldPath.getFieldPath()));
            if (baseValue != null && objectValue == 0) {
            }
            if (objectValue == 0) {
            }
            objectValue.set(fieldPath.getFieldPath(), baseValue);
            objectValue = new ObjectValue();
        }
        return objectValue;
    }

    public List<com.google.firebase.firestore.model.mutation.FieldTransform> getFieldTransforms() {
        return this.fieldTransforms;
    }

    public DocumentKey getKey() {
        return this.key;
    }

    public com.google.firebase.firestore.model.mutation.Precondition getPrecondition() {
        return this.precondition;
    }

    boolean hasSameKeyAndPrecondition(com.google.firebase.firestore.model.mutation.Mutation mutation) {
        boolean precondition;
        Object obj3;
        if (this.key.equals(mutation.key) && this.precondition.equals(mutation.precondition)) {
            obj3 = this.precondition.equals(mutation.precondition) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    int keyAndPreconditionHashCode() {
        return i2 += i4;
    }

    String keyAndPreconditionToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", precondition=");
        stringBuilder.append(this.precondition);
        return stringBuilder.toString();
    }

    protected Map<FieldPath, x> localTransformResults(Timestamp timestamp, MutableDocument mutableDocument2) {
        FieldPath fieldPath;
        x toLocalView;
        x field;
        HashMap hashMap = new HashMap(this.fieldTransforms.size());
        Iterator iterator = this.fieldTransforms.iterator();
        for (FieldTransform next2 : iterator) {
            hashMap.put(next2.getFieldPath(), next2.getOperation().applyToLocalView(mutableDocument2.getField(next2.getFieldPath()), timestamp));
        }
        return hashMap;
    }

    protected Map<FieldPath, x> serverTransformResults(MutableDocument mutableDocument, List<x> list2) {
        int fieldPath;
        Object[] toRemoteDocument;
        String field;
        int i;
        Integer valueOf;
        HashMap hashMap = new HashMap(this.fieldTransforms.size());
        int i3 = 1;
        i = 0;
        fieldPath = this.fieldTransforms.size() == list2.size() ? i3 : i;
        toRemoteDocument = new Object[2];
        toRemoteDocument[i] = Integer.valueOf(list2.size());
        toRemoteDocument[i3] = Integer.valueOf(this.fieldTransforms.size());
        Assert.hardAssert(fieldPath, "server transform count (%d) should match field transform count (%d)", toRemoteDocument);
        while (i < list2.size()) {
            Object obj = this.fieldTransforms.get(i);
            hashMap.put(obj.getFieldPath(), (FieldTransform)obj.getOperation().applyToRemoteDocument(mutableDocument.getField(obj.getFieldPath()), (x)list2.get(i)));
            i++;
        }
        return hashMap;
    }

    void verifyKeyMatches(MutableDocument mutableDocument) {
        Assert.hardAssert(mutableDocument.getKey().equals(getKey()), "Can only apply a mutation to a document with the same key", new Object[0]);
    }
}
