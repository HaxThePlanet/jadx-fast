package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ReferenceSet {

    private ImmutableSortedSet<com.google.firebase.firestore.local.DocumentReference> referencesByKey;
    private ImmutableSortedSet<com.google.firebase.firestore.local.DocumentReference> referencesByTarget;
    public ReferenceSet() {
        super();
        ImmutableSortedSet immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), DocumentReference.BY_KEY);
        this.referencesByKey = immutableSortedSet;
        ImmutableSortedSet immutableSortedSet2 = new ImmutableSortedSet(Collections.emptyList(), DocumentReference.BY_TARGET);
        this.referencesByTarget = immutableSortedSet2;
    }

    private void removeReference(com.google.firebase.firestore.local.DocumentReference documentReference) {
        this.referencesByKey = this.referencesByKey.remove(documentReference);
        this.referencesByTarget = this.referencesByTarget.remove(documentReference);
    }

    public void addReference(DocumentKey documentKey, int i2) {
        DocumentReference documentReference = new DocumentReference(documentKey, i2);
        this.referencesByKey = this.referencesByKey.insert(documentReference);
        this.referencesByTarget = this.referencesByTarget.insert(documentReference);
    }

    public void addReferences(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2) {
        Object next;
        final Iterator obj2 = immutableSortedSet.iterator();
        for (DocumentKey next : obj2) {
            addReference(next, i2);
        }
    }

    public boolean containsKey(DocumentKey documentKey) {
        final int i = 0;
        DocumentReference documentReference = new DocumentReference(documentKey, i);
        Iterator iteratorFrom = this.referencesByKey.iteratorFrom(documentReference);
        if (!iteratorFrom.hasNext()) {
            return i;
        }
        return (DocumentReference)iteratorFrom.next().getKey().equals(documentKey);
    }

    public boolean isEmpty() {
        return this.referencesByKey.isEmpty();
    }

    public ImmutableSortedSet<DocumentKey> referencesForId(int i) {
        ImmutableSortedSet emptyKeySet;
        DocumentKey key;
        boolean next;
        int i2;
        DocumentReference documentReference = new DocumentReference(DocumentKey.empty(), i);
        Iterator iteratorFrom = this.referencesByTarget.iteratorFrom(documentReference);
        emptyKeySet = DocumentKey.emptyKeySet();
        while (iteratorFrom.hasNext()) {
            next = iteratorFrom.next();
            if ((DocumentReference)next.getId() == i) {
            }
            emptyKeySet = emptyKeySet.insert(next.getKey());
        }
        return emptyKeySet;
    }

    public void removeAllReferences() {
        Object next;
        Iterator iterator = this.referencesByKey.iterator();
        for (DocumentReference next : iterator) {
            removeReference(next);
        }
    }

    public void removeReference(DocumentKey documentKey, int i2) {
        DocumentReference documentReference = new DocumentReference(documentKey, i2);
        removeReference(documentReference);
    }

    public void removeReferences(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2) {
        Object next;
        final Iterator obj2 = immutableSortedSet.iterator();
        for (DocumentKey next : obj2) {
            removeReference(next, i2);
        }
    }

    public ImmutableSortedSet<DocumentKey> removeReferencesForId(int i) {
        ImmutableSortedSet emptyKeySet;
        Object next;
        DocumentKey key;
        DocumentReference documentReference = new DocumentReference(DocumentKey.empty(), i);
        Iterator iteratorFrom = this.referencesByTarget.iteratorFrom(documentReference);
        emptyKeySet = DocumentKey.emptyKeySet();
        while (iteratorFrom.hasNext()) {
            next = iteratorFrom.next();
            if ((DocumentReference)next.getId() == i) {
            }
            emptyKeySet = emptyKeySet.insert(next.getKey());
            removeReference(next);
        }
        return emptyKeySet;
    }
}
