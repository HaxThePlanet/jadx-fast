package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.ServerTimestamps;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class ServerTimestampOperation implements com.google.firebase.firestore.model.mutation.TransformOperation {

    private static final com.google.firebase.firestore.model.mutation.ServerTimestampOperation SHARED_INSTANCE;
    static {
        ServerTimestampOperation serverTimestampOperation = new ServerTimestampOperation();
        ServerTimestampOperation.SHARED_INSTANCE = serverTimestampOperation;
    }

    public static com.google.firebase.firestore.model.mutation.ServerTimestampOperation getInstance() {
        return ServerTimestampOperation.SHARED_INSTANCE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x applyToLocalView(x x, Timestamp timestamp2) {
        return ServerTimestamps.valueOf(timestamp2, x);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x applyToRemoteDocument(x x, x x2) {
        return x2;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x computeBaseValue(x x) {
        return null;
    }
}
