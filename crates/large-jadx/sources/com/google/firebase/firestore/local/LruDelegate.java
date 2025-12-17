package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public interface LruDelegate {
    public abstract void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer);

    public abstract void forEachTarget(Consumer<com.google.firebase.firestore.local.TargetData> consumer);

    public abstract long getByteSize();

    public abstract com.google.firebase.firestore.local.LruGarbageCollector getGarbageCollector();

    public abstract long getSequenceNumberCount();

    public abstract int removeOrphanedDocuments(long l);

    public abstract int removeTargets(long l, SparseArray<?> sparseArray2);
}
