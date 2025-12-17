package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;

/* loaded from: classes2.dex */
interface ReferenceDelegate {
    public abstract void addReference(DocumentKey documentKey);

    public abstract long getCurrentSequenceNumber();

    public abstract void onTransactionCommitted();

    public abstract void onTransactionStarted();

    public abstract void removeMutationReference(DocumentKey documentKey);

    public abstract void removeReference(DocumentKey documentKey);

    public abstract void removeTarget(com.google.firebase.firestore.local.TargetData targetData);

    public abstract void setInMemoryPins(com.google.firebase.firestore.local.ReferenceSet referenceSet);

    public abstract void updateLimboDocument(DocumentKey documentKey);
}
