package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ViewSnapshot {

    private final List<com.google.firebase.firestore.core.DocumentViewChange> changes;
    private final boolean didSyncStateChange;
    private final DocumentSet documents;
    private boolean excludesMetadataChanges;
    private final boolean isFromCache;
    private final ImmutableSortedSet<DocumentKey> mutatedKeys;
    private final DocumentSet oldDocuments;
    private final com.google.firebase.firestore.core.Query query;

    public static enum SyncState {

        NONE,
        LOCAL,
        SYNCED;
    }
    public ViewSnapshot(com.google.firebase.firestore.core.Query query, DocumentSet documentSet2, DocumentSet documentSet3, List<com.google.firebase.firestore.core.DocumentViewChange> list4, boolean z5, ImmutableSortedSet<DocumentKey> immutableSortedSet6, boolean z7, boolean z8) {
        super();
        this.query = query;
        this.documents = documentSet2;
        this.oldDocuments = documentSet3;
        this.changes = list4;
        this.isFromCache = z5;
        this.mutatedKeys = immutableSortedSet6;
        this.didSyncStateChange = z7;
        this.excludesMetadataChanges = z8;
    }

    public static com.google.firebase.firestore.core.ViewSnapshot fromInitialDocuments(com.google.firebase.firestore.core.Query query, DocumentSet documentSet2, ImmutableSortedSet<DocumentKey> immutableSortedSet3, boolean z4, boolean z5) {
        com.google.firebase.firestore.core.DocumentViewChange create;
        com.google.firebase.firestore.core.DocumentViewChange.Type aDDED;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = documentSet2.iterator();
        for (Document next2 : iterator) {
            arrayList.add(DocumentViewChange.create(DocumentViewChange.Type.ADDED, next2));
        }
        super(query, documentSet2, DocumentSet.emptySet(query.comparator()), arrayList, z4, immutableSortedSet3, 1, z5);
        return viewSnapshot;
    }

    public boolean didSyncStateChange() {
        return this.didSyncStateChange;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (!object instanceof ViewSnapshot) {
            return i;
        }
        if (this.isFromCache != object.isFromCache) {
            return i;
        }
        if (this.didSyncStateChange != object.didSyncStateChange) {
            return i;
        }
        if (this.excludesMetadataChanges != object.excludesMetadataChanges) {
            return i;
        }
        if (!this.query.equals(object.query)) {
            return i;
        }
        if (!this.mutatedKeys.equals(object.mutatedKeys)) {
            return i;
        }
        if (!this.documents.equals(object.documents)) {
            return i;
        }
        if (!this.oldDocuments.equals(object.oldDocuments)) {
            return i;
        }
        return this.changes.equals(object.changes);
    }

    public boolean excludesMetadataChanges() {
        return this.excludesMetadataChanges;
    }

    public List<com.google.firebase.firestore.core.DocumentViewChange> getChanges() {
        return this.changes;
    }

    public DocumentSet getDocuments() {
        return this.documents;
    }

    public ImmutableSortedSet<DocumentKey> getMutatedKeys() {
        return this.mutatedKeys;
    }

    public DocumentSet getOldDocuments() {
        return this.oldDocuments;
    }

    public com.google.firebase.firestore.core.Query getQuery() {
        return this.query;
    }

    public boolean hasPendingWrites() {
        return empty ^= 1;
    }

    public int hashCode() {
        return i14 += excludesMetadataChanges;
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewSnapshot(");
        stringBuilder.append(this.query);
        String str2 = ", ";
        stringBuilder.append(str2);
        stringBuilder.append(this.documents);
        stringBuilder.append(str2);
        stringBuilder.append(this.oldDocuments);
        stringBuilder.append(str2);
        stringBuilder.append(this.changes);
        stringBuilder.append(", isFromCache=");
        stringBuilder.append(this.isFromCache);
        stringBuilder.append(", mutatedKeys=");
        stringBuilder.append(this.mutatedKeys.size());
        stringBuilder.append(", didSyncStateChange=");
        stringBuilder.append(this.didSyncStateChange);
        stringBuilder.append(", excludesMetadataChanges=");
        stringBuilder.append(this.excludesMetadataChanges);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
