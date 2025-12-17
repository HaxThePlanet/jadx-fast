package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class w0 implements Comparator {

    public static final com.google.firebase.firestore.local.w0 a;
    static {
        w0 w0Var = new w0();
        w0.a = w0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return SQLiteMutationQueue.g((MutationBatch)object, (MutationBatch)object2);
    }
}
