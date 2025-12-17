package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.util.Assert;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
class LocalDocumentsView {

    private final com.google.firebase.firestore.local.IndexManager indexManager;
    private final com.google.firebase.firestore.local.MutationQueue mutationQueue;
    private final com.google.firebase.firestore.local.RemoteDocumentCache remoteDocumentCache;
    LocalDocumentsView(com.google.firebase.firestore.local.RemoteDocumentCache remoteDocumentCache, com.google.firebase.firestore.local.MutationQueue mutationQueue2, com.google.firebase.firestore.local.IndexManager indexManager3) {
        super();
        this.remoteDocumentCache = remoteDocumentCache;
        this.mutationQueue = mutationQueue2;
        this.indexManager = indexManager3;
    }

    private ImmutableSortedMap<DocumentKey, MutableDocument> addMissingBaseDocuments(List<MutationBatch> list, ImmutableSortedMap<DocumentKey, MutableDocument> immutableSortedMap2) {
        HashSet hashSet;
        Iterator iterator;
        boolean foundDocument;
        boolean next;
        boolean key;
        ImmutableSortedMap obj6;
        hashSet = new HashSet();
        Iterator obj5 = list.iterator();
        for (MutationBatch next3 : obj5) {
            iterator = next3.getMutations().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (next instanceof PatchMutation && !immutableSortedMap2.containsKey((Mutation)next.getKey())) {
                }
                if (!immutableSortedMap2.containsKey(next.getKey())) {
                }
                hashSet.add(next.getKey());
            }
            next = iterator.next();
            if (next instanceof PatchMutation && !immutableSortedMap2.containsKey((Mutation)next.getKey())) {
            }
            if (!immutableSortedMap2.containsKey(next.getKey())) {
            }
            hashSet.add(next.getKey());
        }
        obj5 = this.remoteDocumentCache.getAll(hashSet).entrySet().iterator();
        while (obj5.hasNext()) {
            hashSet = obj5.next();
            if ((MutableDocument)(Map.Entry)hashSet.getValue().isFoundDocument()) {
            }
            obj6 = obj6.insert((DocumentKey)hashSet.getKey(), (MutableDocument)hashSet.getValue());
        }
        return obj6;
    }

    private void applyLocalMutationsToDocuments(Map<DocumentKey, MutableDocument> map, List<MutationBatch> list2) {
        Object next2;
        Iterator iterator;
        boolean next;
        Object value;
        Iterator obj5 = map.entrySet().iterator();
        for (Map.Entry next2 : obj5) {
            iterator = list2.iterator();
            for (MutationBatch next : iterator) {
                next.applyToLocalView((MutableDocument)next2.getValue());
            }
            (MutationBatch)iterator.next().applyToLocalView((MutableDocument)next2.getValue());
        }
    }

    private Document getDocument(DocumentKey documentKey, List<MutationBatch> list2) {
        com.google.firebase.firestore.local.RemoteDocumentCache remoteDocumentCache;
        final MutableDocument obj2 = this.remoteDocumentCache.get(documentKey);
        final Iterator obj3 = list2.iterator();
        for (MutationBatch remoteDocumentCache : obj3) {
            remoteDocumentCache.applyToLocalView(obj2);
        }
        return obj2;
    }

    private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingCollectionGroupQuery(Query query, SnapshotVersion snapshotVersion2) {
        ImmutableSortedMap emptyDocumentMap;
        Iterator iterator;
        boolean value;
        Object key;
        Assert.hardAssert(query.getPath().isEmpty(), "Currently we only support collection group queries at the root.", new Object[0]);
        String collectionGroup = query.getCollectionGroup();
        emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        Iterator iterator2 = this.indexManager.getCollectionParents(collectionGroup).iterator();
        for (ResourcePath next2 : iterator2) {
            iterator = getDocumentsMatchingCollectionQuery(query.asCollectionQueryAtPath((ResourcePath)next2.append(collectionGroup)), snapshotVersion2).iterator();
            for (Map.Entry next3 : iterator) {
                emptyDocumentMap = emptyDocumentMap.insert((DocumentKey)next3.getKey(), (Document)next3.getValue());
            }
            Object next3 = iterator.next();
            emptyDocumentMap = emptyDocumentMap.insert((DocumentKey)(Map.Entry)next3.getKey(), (Document)next3.getValue());
        }
        return emptyDocumentMap;
    }

    private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingCollectionQuery(Query query, SnapshotVersion snapshotVersion2) {
        ImmutableSortedMap emptyDocumentMap;
        Object next;
        boolean value;
        Iterator iterator;
        boolean foundDocument;
        DocumentKey immediateParentOf;
        Object invalidDocument;
        FieldMask set;
        com.google.firebase.Timestamp localWriteTime;
        ImmutableSortedMap obj10;
        List allMutationBatchesAffectingQuery = this.mutationQueue.getAllMutationBatchesAffectingQuery(query);
        obj10 = addMissingBaseDocuments(allMutationBatchesAffectingQuery, this.remoteDocumentCache.getAllDocumentsMatchingQuery(query, snapshotVersion2));
        Iterator iterator2 = allMutationBatchesAffectingQuery.iterator();
        for (MutationBatch next : iterator2) {
            iterator = next.getMutations().iterator();
            while (iterator.hasNext()) {
                foundDocument = iterator.next();
                if (!query.getPath().isImmediateParentOf((Mutation)foundDocument.getKey().getPath())) {
                } else {
                }
                immediateParentOf = foundDocument.getKey();
                if ((MutableDocument)obj10.get(immediateParentOf) == null) {
                }
                HashSet hashSet = new HashSet();
                foundDocument.applyToLocalView(invalidDocument, FieldMask.fromSet(hashSet), next.getLocalWriteTime());
                if (!invalidDocument.isFoundDocument()) {
                }
                obj10 = obj10.remove(immediateParentOf);
                obj10 = obj10.insert(immediateParentOf, MutableDocument.newInvalidDocument(immediateParentOf));
            }
            foundDocument = iterator.next();
            if (!query.getPath().isImmediateParentOf((Mutation)foundDocument.getKey().getPath())) {
            } else {
            }
            immediateParentOf = foundDocument.getKey();
            if ((MutableDocument)obj10.get(immediateParentOf) == null) {
            }
            hashSet = new HashSet();
            foundDocument.applyToLocalView(invalidDocument, FieldMask.fromSet(hashSet), next.getLocalWriteTime());
            if (!invalidDocument.isFoundDocument()) {
            }
            obj10 = obj10.remove(immediateParentOf);
            obj10 = obj10.insert(immediateParentOf, MutableDocument.newInvalidDocument(immediateParentOf));
        }
        emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        obj10 = obj10.iterator();
        while (obj10.hasNext()) {
            value = obj10.next();
            if (query.matches((Document)(Map.Entry)value.getValue())) {
            }
            emptyDocumentMap = emptyDocumentMap.insert((DocumentKey)value.getKey(), (Document)value.getValue());
        }
        return emptyDocumentMap;
    }

    private ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingDocumentQuery(ResourcePath resourcePath) {
        ImmutableSortedMap emptyDocumentMap;
        boolean foundDocument;
        Document obj3 = getDocument(DocumentKey.fromPath(resourcePath));
        if (obj3.isFoundDocument()) {
            emptyDocumentMap = DocumentCollections.emptyDocumentMap().insert(obj3.getKey(), obj3);
        }
        return emptyDocumentMap;
    }

    Document getDocument(DocumentKey documentKey) {
        return getDocument(documentKey, this.mutationQueue.getAllMutationBatchesAffectingDocumentKey(documentKey));
    }

    ImmutableSortedMap<DocumentKey, Document> getDocuments(Iterable<DocumentKey> iterable) {
        return getLocalViewOfDocuments(this.remoteDocumentCache.getAll(iterable));
    }

    ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2) {
        if (query.isDocumentQuery()) {
            return getDocumentsMatchingDocumentQuery(query.getPath());
        }
        if (query.isCollectionGroupQuery()) {
            return getDocumentsMatchingCollectionGroupQuery(query, snapshotVersion2);
        }
        return getDocumentsMatchingCollectionQuery(query, snapshotVersion2);
    }

    com.google.firebase.firestore.local.IndexManager getIndexManager() {
        return this.indexManager;
    }

    ImmutableSortedMap<DocumentKey, Document> getLocalViewOfDocuments(Map<DocumentKey, MutableDocument> map) {
        ImmutableSortedMap emptyDocumentMap;
        List allMutationBatchesAffectingDocumentKeys;
        Set keySet;
        emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        applyLocalMutationsToDocuments(map, this.mutationQueue.getAllMutationBatchesAffectingDocumentKeys(map.keySet()));
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            emptyDocumentMap = emptyDocumentMap.insert((DocumentKey)next2.getKey(), (Document)next2.getValue());
        }
        return emptyDocumentMap;
    }

    com.google.firebase.firestore.local.MutationQueue getMutationQueue() {
        return this.mutationQueue;
    }

    com.google.firebase.firestore.local.RemoteDocumentCache getRemoteDocumentCache() {
        return this.remoteDocumentCache;
    }
}
