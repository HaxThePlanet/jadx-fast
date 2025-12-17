package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
interface TargetCache {
    public abstract void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2);

    public abstract void addTargetData(com.google.firebase.firestore.local.TargetData targetData);

    public abstract boolean containsKey(DocumentKey documentKey);

    public abstract void forEachTarget(Consumer<com.google.firebase.firestore.local.TargetData> consumer);

    public abstract long getHighestListenSequenceNumber();

    public abstract int getHighestTargetId();

    public abstract SnapshotVersion getLastRemoteSnapshotVersion();

    public abstract ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i);

    public abstract long getTargetCount();

    public abstract com.google.firebase.firestore.local.TargetData getTargetData(Target target);

    public abstract void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2);

    public abstract void removeMatchingKeysForTargetId(int i);

    public abstract void removeTargetData(com.google.firebase.firestore.local.TargetData targetData);

    public abstract void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion);

    public abstract void updateTargetData(com.google.firebase.firestore.local.TargetData targetData);
}
