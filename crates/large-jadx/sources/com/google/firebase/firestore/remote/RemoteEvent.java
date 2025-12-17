package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RemoteEvent {

    private final Map<DocumentKey, MutableDocument> documentUpdates;
    private final Set<DocumentKey> resolvedLimboDocuments;
    private final SnapshotVersion snapshotVersion;
    private final Map<Integer, com.google.firebase.firestore.remote.TargetChange> targetChanges;
    private final Set<Integer> targetMismatches;
    public RemoteEvent(SnapshotVersion snapshotVersion, Map<Integer, com.google.firebase.firestore.remote.TargetChange> map2, Set<Integer> set3, Map<DocumentKey, MutableDocument> map4, Set<DocumentKey> set5) {
        super();
        this.snapshotVersion = snapshotVersion;
        this.targetChanges = map2;
        this.targetMismatches = set3;
        this.documentUpdates = map4;
        this.resolvedLimboDocuments = set5;
    }

    public Map<DocumentKey, MutableDocument> getDocumentUpdates() {
        return this.documentUpdates;
    }

    public Set<DocumentKey> getResolvedLimboDocuments() {
        return this.resolvedLimboDocuments;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.snapshotVersion;
    }

    public Map<Integer, com.google.firebase.firestore.remote.TargetChange> getTargetChanges() {
        return this.targetChanges;
    }

    public Set<Integer> getTargetMismatches() {
        return this.targetMismatches;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RemoteEvent{snapshotVersion=");
        stringBuilder.append(this.snapshotVersion);
        stringBuilder.append(", targetChanges=");
        stringBuilder.append(this.targetChanges);
        stringBuilder.append(", targetMismatches=");
        stringBuilder.append(this.targetMismatches);
        stringBuilder.append(", documentUpdates=");
        stringBuilder.append(this.documentUpdates);
        stringBuilder.append(", resolvedLimboDocuments=");
        stringBuilder.append(this.resolvedLimboDocuments);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
