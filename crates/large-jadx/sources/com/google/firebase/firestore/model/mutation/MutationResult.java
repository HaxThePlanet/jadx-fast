package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Preconditions;
import f.c.e.c.x;
import java.util.List;

/* loaded from: classes2.dex */
public final class MutationResult {

    private final List<x> transformResults;
    private final SnapshotVersion version;
    public MutationResult(SnapshotVersion snapshotVersion, List<x> list2) {
        super();
        this.version = (SnapshotVersion)Preconditions.checkNotNull(snapshotVersion);
        this.transformResults = list2;
    }

    public List<x> getTransformResults() {
        return this.transformResults;
    }

    public SnapshotVersion getVersion() {
        return this.version;
    }
}
