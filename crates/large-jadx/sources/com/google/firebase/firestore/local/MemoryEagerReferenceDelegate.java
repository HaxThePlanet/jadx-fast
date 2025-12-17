package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
class MemoryEagerReferenceDelegate implements com.google.firebase.firestore.local.ReferenceDelegate {

    private com.google.firebase.firestore.local.ReferenceSet inMemoryPins;
    private Set<DocumentKey> orphanedDocuments;
    private final com.google.firebase.firestore.local.MemoryPersistence persistence;
    MemoryEagerReferenceDelegate(com.google.firebase.firestore.local.MemoryPersistence memoryPersistence) {
        super();
        this.persistence = memoryPersistence;
    }

    private boolean isReferenced(DocumentKey documentKey) {
        DocumentKey obj3;
        final int i = 1;
        if (this.persistence.getTargetCache().containsKey(documentKey)) {
            return i;
        }
        if (mutationQueuesContainKey(documentKey)) {
            return i;
        }
        com.google.firebase.firestore.local.ReferenceSet inMemoryPins = this.inMemoryPins;
        if (inMemoryPins != null && inMemoryPins.containsKey(documentKey)) {
            if (inMemoryPins.containsKey(documentKey)) {
                return i;
            }
        }
        return 0;
    }

    private boolean mutationQueuesContainKey(DocumentKey documentKey) {
        boolean key;
        Iterator iterator = this.persistence.getMutationQueues().iterator();
        for (MemoryMutationQueue next2 : iterator) {
        }
        return 0;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void addReference(DocumentKey documentKey) {
        this.orphanedDocuments.remove(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getCurrentSequenceNumber() {
        return -1;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionCommitted() {
        Object next;
        boolean referenced;
        Iterator iterator = this.orphanedDocuments.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!isReferenced((DocumentKey)next)) {
            }
            this.persistence.getRemoteDocumentCache().remove(next);
        }
        this.orphanedDocuments = 0;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionStarted() {
        HashSet hashSet = new HashSet();
        this.orphanedDocuments = hashSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeMutationReference(DocumentKey documentKey) {
        this.orphanedDocuments.add(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        this.orphanedDocuments.add(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeTarget(com.google.firebase.firestore.local.TargetData targetData) {
        Object next;
        Set orphanedDocuments;
        com.google.firebase.firestore.local.MemoryTargetCache targetCache = this.persistence.getTargetCache();
        Iterator iterator = targetCache.getMatchingKeysForTargetId(targetData.getTargetId()).iterator();
        for (DocumentKey next : iterator) {
            this.orphanedDocuments.add(next);
        }
        targetCache.removeTargetData(targetData);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void setInMemoryPins(com.google.firebase.firestore.local.ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void updateLimboDocument(DocumentKey documentKey) {
        Set orphanedDocuments;
        if (isReferenced(documentKey)) {
            this.orphanedDocuments.remove(documentKey);
        } else {
            this.orphanedDocuments.add(documentKey);
        }
    }
}
