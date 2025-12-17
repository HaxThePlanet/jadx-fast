package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;

/* loaded from: classes2.dex */
public interface DocumentOverlay {
    public abstract Mutation getOverlay(DocumentKey documentKey);

    public abstract void removeOverlay(DocumentKey documentKey);

    public abstract void saveOverlay(DocumentKey documentKey, Mutation mutation2);
}
