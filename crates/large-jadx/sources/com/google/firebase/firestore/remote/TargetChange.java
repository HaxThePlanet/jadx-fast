package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.protobuf.j;

/* loaded from: classes2.dex */
public final class TargetChange {

    private final ImmutableSortedSet<DocumentKey> addedDocuments;
    private final boolean current;
    private final ImmutableSortedSet<DocumentKey> modifiedDocuments;
    private final ImmutableSortedSet<DocumentKey> removedDocuments;
    private final j resumeToken;
    public TargetChange(j j, boolean z2, ImmutableSortedSet<DocumentKey> immutableSortedSet3, ImmutableSortedSet<DocumentKey> immutableSortedSet4, ImmutableSortedSet<DocumentKey> immutableSortedSet5) {
        super();
        this.resumeToken = j;
        this.current = z2;
        this.addedDocuments = immutableSortedSet3;
        this.modifiedDocuments = immutableSortedSet4;
        this.removedDocuments = immutableSortedSet5;
    }

    public static com.google.firebase.firestore.remote.TargetChange createSynthesizedTargetChangeForCurrentChange(boolean z) {
        super(j.a, z, DocumentKey.emptyKeySet(), DocumentKey.emptyKeySet(), DocumentKey.emptyKeySet());
        return targetChange2;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.remote.TargetChange> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (TargetChange.class != object.getClass()) {
            } else {
                if (this.current != object.current) {
                    return i;
                }
                if (!this.resumeToken.equals(object.resumeToken)) {
                    return i;
                }
                if (!this.addedDocuments.equals(object.addedDocuments)) {
                    return i;
                }
                if (!this.modifiedDocuments.equals(object.modifiedDocuments)) {
                    return i;
                }
            }
            return this.removedDocuments.equals(object.removedDocuments);
        }
        return i;
    }

    public ImmutableSortedSet<DocumentKey> getAddedDocuments() {
        return this.addedDocuments;
    }

    public ImmutableSortedSet<DocumentKey> getModifiedDocuments() {
        return this.modifiedDocuments;
    }

    public ImmutableSortedSet<DocumentKey> getRemovedDocuments() {
        return this.removedDocuments;
    }

    public j getResumeToken() {
        return this.resumeToken;
    }

    public int hashCode() {
        return i8 += i12;
    }

    public boolean isCurrent() {
        return this.current;
    }
}
