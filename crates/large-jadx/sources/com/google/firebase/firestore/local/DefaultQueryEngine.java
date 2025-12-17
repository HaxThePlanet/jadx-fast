package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Query.LimitType;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class DefaultQueryEngine implements com.google.firebase.firestore.local.QueryEngine {

    private static final String LOG_TAG = "DefaultQueryEngine";
    private com.google.firebase.firestore.local.LocalDocumentsView localDocumentsView;
    private ImmutableSortedSet<Document> applyQuery(Query query, ImmutableSortedMap<DocumentKey, Document> immutableSortedMap2) {
        ImmutableSortedSet immutableSortedSet;
        java.util.List emptyList;
        java.util.Comparator comparator;
        immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), query.comparator());
        final Iterator obj5 = immutableSortedMap2.iterator();
        while (obj5.hasNext()) {
            emptyList = (Map.Entry)obj5.next().getValue();
            if (query.matches((Document)emptyList) != null) {
            }
            immutableSortedSet = immutableSortedSet.insert(emptyList);
        }
        return immutableSortedSet;
    }

    private ImmutableSortedMap<DocumentKey, Document> executeFullCollectionScan(Query query) {
        boolean debugEnabled;
        String str2;
        String str;
        if (Logger.isDebugEnabled()) {
            debugEnabled = new Object[1];
            Logger.debug("DefaultQueryEngine", "Using full collection scan to execute query: %s", query.toString());
        }
        return this.localDocumentsView.getDocumentsMatchingQuery(query, SnapshotVersion.NONE);
    }

    private boolean needsRefill(Query.LimitType query$LimitType, ImmutableSortedSet<Document> immutableSortedSet2, ImmutableSortedSet<DocumentKey> immutableSortedSet3, SnapshotVersion snapshotVersion4) {
        int i;
        Object obj3;
        if (immutableSortedSet3.size() != immutableSortedSet2.size()) {
            return 1;
        }
        if (limitType == Query.LimitType.LIMIT_TO_FIRST) {
            obj3 = immutableSortedSet2.getMaxEntry();
        } else {
            obj3 = immutableSortedSet2.getMinEntry();
        }
        final int obj4 = 0;
        if (obj3 == null) {
            return obj4;
        }
        if (!obj3.hasPendingWrites()) {
            if (obj3.getVersion().compareTo(snapshotVersion4) > 0) {
            } else {
                i = obj4;
            }
        }
        return i;
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2, ImmutableSortedSet<DocumentKey> immutableSortedSet3) {
        int i;
        ImmutableSortedSet query2;
        int str2;
        int str;
        Query.LimitType limitToFirst;
        ImmutableSortedMap obj6;
        boolean obj8;
        str2 = 1;
        str = 0;
        i = this.localDocumentsView != null ? str2 : str;
        Assert.hardAssert(i, "setLocalDocumentsView() not called", new Object[str]);
        if (query.matchesAllDocuments()) {
            return executeFullCollectionScan(query);
        }
        if (snapshotVersion2.equals(SnapshotVersion.NONE)) {
            return executeFullCollectionScan(query);
        }
        query2 = applyQuery(query, this.localDocumentsView.getDocuments(immutableSortedSet3));
        if (!query.hasLimitToFirst()) {
            if (query.hasLimitToLast() && needsRefill(query.getLimitType(), query2, immutableSortedSet3, snapshotVersion2)) {
                if (needsRefill(query.getLimitType(), query2, immutableSortedSet3, snapshotVersion2)) {
                    return executeFullCollectionScan(query);
                }
            }
        } else {
        }
        if (Logger.isDebugEnabled()) {
            obj8 = new Object[2];
            obj8[str] = snapshotVersion2.toString();
            obj8[str2] = query.toString();
            Logger.debug("DefaultQueryEngine", "Re-using previous result from %s to execute query: %s", obj8);
        }
        obj6 = this.localDocumentsView.getDocumentsMatchingQuery(query, snapshotVersion2);
        final Iterator obj7 = query2.iterator();
        for (Document obj8 : obj7) {
            obj6 = obj6.insert(obj8.getKey(), obj8);
        }
        return obj6;
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void handleDocumentChange(MutableDocument mutableDocument, MutableDocument mutableDocument2) {
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void setLocalDocumentsView(com.google.firebase.firestore.local.LocalDocumentsView localDocumentsView) {
        this.localDocumentsView = localDocumentsView;
    }
}
