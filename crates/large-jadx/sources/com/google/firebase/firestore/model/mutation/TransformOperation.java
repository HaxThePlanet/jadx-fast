package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public interface TransformOperation {
    public abstract x applyToLocalView(x x, Timestamp timestamp2);

    public abstract x applyToRemoteDocument(x x, x x2);

    public abstract x computeBaseValue(x x);
}
