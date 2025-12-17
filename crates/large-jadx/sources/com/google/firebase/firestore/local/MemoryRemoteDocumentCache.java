package com.google.firebase.firestore.local;

import android.util.Pair;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class MemoryRemoteDocumentCache implements com.google.firebase.firestore.local.RemoteDocumentCache {

    private ImmutableSortedMap<DocumentKey, Pair<MutableDocument, SnapshotVersion>> docs;
    private final com.google.firebase.firestore.local.MemoryPersistence persistence;

    private class DocumentIterable implements Iterable<MutableDocument> {

        final com.google.firebase.firestore.local.MemoryRemoteDocumentCache this$0;
        private DocumentIterable(com.google.firebase.firestore.local.MemoryRemoteDocumentCache memoryRemoteDocumentCache) {
            this.this$0 = memoryRemoteDocumentCache;
            super();
        }

        DocumentIterable(com.google.firebase.firestore.local.MemoryRemoteDocumentCache memoryRemoteDocumentCache, com.google.firebase.firestore.local.MemoryRemoteDocumentCache.1 memoryRemoteDocumentCache$12) {
            super(memoryRemoteDocumentCache);
        }

        public Iterator<MutableDocument> iterator() {
            MemoryRemoteDocumentCache.DocumentIterable.1 anon = new MemoryRemoteDocumentCache.DocumentIterable.1(this, MemoryRemoteDocumentCache.access$100(this.this$0).iterator());
            return anon;
        }
    }
    MemoryRemoteDocumentCache(com.google.firebase.firestore.local.MemoryPersistence memoryPersistence) {
        super();
        this.docs = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());
        this.persistence = memoryPersistence;
    }

    static ImmutableSortedMap access$100(com.google.firebase.firestore.local.MemoryRemoteDocumentCache memoryRemoteDocumentCache) {
        return memoryRemoteDocumentCache.docs;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void add(MutableDocument mutableDocument, SnapshotVersion snapshotVersion2) {
        Assert.hardAssert(equals ^= 1, "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        Pair pair = new Pair(mutableDocument.clone(), snapshotVersion2);
        this.docs = this.docs.insert(mutableDocument.getKey(), pair);
        this.persistence.getIndexManager().addToCollectionParentIndex((ResourcePath)mutableDocument.getKey().getPath().popLast());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public MutableDocument get(DocumentKey documentKey) {
        MutableDocument obj2;
        Object obj = this.docs.get(documentKey);
        if ((Pair)obj != null) {
            obj2 = (MutableDocument)obj.first.clone();
        } else {
            obj2 = MutableDocument.newInvalidDocument(documentKey);
        }
        return obj2;
    }

    public Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable) {
        Object next;
        MutableDocument mutableDocument;
        HashMap hashMap = new HashMap();
        final Iterator obj4 = iterable.iterator();
        for (DocumentKey next : obj4) {
            hashMap.put(next, get(next));
        }
        return hashMap;
    }

    public ImmutableSortedMap<DocumentKey, MutableDocument> getAllDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2) {
        ImmutableSortedMap emptyMutableDocumentMap;
        ImmutableSortedMap compareTo;
        Object prefixOf;
        boolean foundDocument;
        Assert.hardAssert(collectionGroupQuery ^= 1, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        emptyMutableDocumentMap = DocumentCollections.emptyMutableDocumentMap();
        com.google.firebase.firestore.model.ResourcePath path = query.getPath();
        Iterator iteratorFrom = this.docs.iteratorFrom(DocumentKey.fromPath((ResourcePath)path.append("")));
        while (iteratorFrom.hasNext()) {
            compareTo = iteratorFrom.next();
            if (!path.isPrefixOf((DocumentKey)(Map.Entry)compareTo.getKey().getPath())) {
                break;
            } else {
            }
            prefixOf = value2.first;
            if (!(MutableDocument)prefixOf.isFoundDocument()) {
            } else {
            }
            if ((SnapshotVersion)value.second.compareTo(snapshotVersion2) <= 0) {
            } else {
            }
            if (query.matches(prefixOf) == null) {
            } else {
            }
            emptyMutableDocumentMap = emptyMutableDocumentMap.insert(prefixOf.getKey(), prefixOf.clone());
        }
        return emptyMutableDocumentMap;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    long getByteSize(com.google.firebase.firestore.local.LocalSerializer localSerializer) {
        int i;
        long l;
        MemoryRemoteDocumentCache.DocumentIterable documentIterable = new MemoryRemoteDocumentCache.DocumentIterable(this, 0);
        Iterator iterator = documentIterable.iterator();
        i = 0;
        for (MutableDocument next2 : iterator) {
            i += l;
        }
        return i;
    }

    Iterable<MutableDocument> getDocuments() {
        MemoryRemoteDocumentCache.DocumentIterable documentIterable = new MemoryRemoteDocumentCache.DocumentIterable(this, 0);
        return documentIterable;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void remove(DocumentKey documentKey) {
        this.docs = this.docs.remove(documentKey);
    }
}
