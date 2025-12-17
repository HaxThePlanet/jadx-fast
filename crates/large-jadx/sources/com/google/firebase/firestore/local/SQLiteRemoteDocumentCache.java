package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.protobuf.t0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class SQLiteRemoteDocumentCache implements com.google.firebase.firestore.local.RemoteDocumentCache {

    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    SQLiteRemoteDocumentCache(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LocalSerializer localSerializer2) {
        super();
        this.db = sQLitePersistence;
        this.serializer = localSerializer2;
    }

    private MutableDocument a(Cursor cursor) {
        return decodeMaybeDocument(cursor.getBlob(0));
    }

    private void c(Map map, Cursor cursor2) {
        MutableDocument obj3 = decodeMaybeDocument(cursor2.getBlob(0));
        map.put(obj3.getKey(), obj3);
    }

    private MutableDocument decodeMaybeDocument(byte[] bArr) {
        try {
            return this.serializer.decodeMaybeDocument(MaybeDocument.parseFrom(bArr));
            int arr = 1;
            arr = new Object[arr];
            arr[0] = bArr;
            bArr = "MaybeDocument failed to parse: %s";
            bArr = Assert.fail(bArr, arr);
            throw bArr;
        }
    }

    private void e(byte[] bArr, Query query2, ImmutableSortedMap[] immutableSortedMap3Arr3) {
        boolean foundDocument;
        DocumentKey key;
        Object obj3;
        boolean obj4;
        obj3 = decodeMaybeDocument(bArr);
        if (obj3.isFoundDocument() && query2.matches(obj3)) {
            if (query2.matches(obj3)) {
                obj4 = 0;
                immutableSortedMap3Arr3[obj4] = immutableSortedMap3Arr3[obj4].insert(obj3.getKey(), obj3);
                synchronized (this) {
                    obj4 = 0;
                    immutableSortedMap3Arr3[obj4] = immutableSortedMap3Arr3[obj4].insert(obj3.getKey(), obj3);
                }
            }
        }
    }

    private void g(int i, BackgroundQueue backgroundQueue2, Query query3, ImmutableSortedMap[] immutableSortedMap4Arr4, Cursor cursor5) {
        Executor obj3;
        if (EncodedPath.decodeResourcePath(cursor5.getString(0)).length() != i) {
        }
        if (cursor5.isLast()) {
            obj3 = Executors.DIRECT_EXECUTOR;
        }
        d1 obj6 = new d1(this, cursor5.getBlob(1), query3, immutableSortedMap4Arr4);
        obj3.execute(obj6);
    }

    private String pathForKey(DocumentKey documentKey) {
        return EncodedPath.encode(documentKey.getPath());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void add(MutableDocument mutableDocument, SnapshotVersion snapshotVersion2) {
        final int i3 = 1;
        final int i4 = 0;
        Assert.hardAssert(equals ^= i3, "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[i4]);
        Timestamp obj10 = snapshotVersion2.getTimestamp();
        Object[] arr2 = new Object[4];
        arr2[i4] = pathForKey(mutableDocument.getKey());
        arr2[i3] = Long.valueOf(obj10.getSeconds());
        arr2[2] = Integer.valueOf(obj10.getNanoseconds());
        arr2[3] = this.serializer.encodeMaybeDocument(mutableDocument).toByteArray();
        this.db.execute("INSERT OR REPLACE INTO remote_documents (path, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?)", arr2);
        this.db.getIndexManager().addToCollectionParentIndex((ResourcePath)mutableDocument.getKey().getPath().popLast());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public MutableDocument b(Cursor cursor) {
        return a(cursor);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void d(Map map, Cursor cursor2) {
        c(map, cursor2);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void f(byte[] bArr, Query query2, ImmutableSortedMap[] immutableSortedMap3Arr3) {
        e(bArr, query2, immutableSortedMap3Arr3);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public MutableDocument get(DocumentKey documentKey) {
        Object invalidDocument;
        Object[] arr = new Object[1];
        b1 b1Var = new b1(this);
        if ((MutableDocument)this.db.query("SELECT contents FROM remote_documents WHERE path = ?").binding(pathForKey(documentKey)).firstValue(b1Var) != null) {
        } else {
            invalidDocument = MutableDocument.newInvalidDocument(documentKey);
        }
        return invalidDocument;
    }

    public Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable) {
        ArrayList nextSubquery;
        String encode;
        boolean next;
        com.google.firebase.firestore.local.SQLitePersistence c1Var;
        MutableDocument invalidDocument;
        nextSubquery = new ArrayList();
        Iterator iterator = iterable.iterator();
        for (DocumentKey next3 : iterator) {
            nextSubquery.add(EncodedPath.encode(next3.getPath()));
        }
        HashMap hashMap = new HashMap();
        Iterator obj6 = iterable.iterator();
        for (DocumentKey next : obj6) {
            hashMap.put(next, MutableDocument.newInvalidDocument(next));
        }
        obj6 = new SQLitePersistence.LongQuery(this.db, "SELECT contents FROM remote_documents WHERE path IN (", nextSubquery, ") ORDER BY path");
        while (obj6.hasMoreSubqueries()) {
            c1Var = new c1(this, hashMap);
            obj6.performNextSubquery().forEach(c1Var);
        }
        return hashMap;
    }

    public ImmutableSortedMap<DocumentKey, MutableDocument> getAllDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2) {
        String encode;
        Object prefixSuccessor;
        Object[] timestamp;
        Object[] arr;
        long seconds;
        Throwable obj13;
        com.google.firebase.firestore.local.SQLitePersistence.Query obj14;
        final int i3 = 1;
        final int i4 = 0;
        Assert.hardAssert(collectionGroupQuery ^= i3, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[i4]);
        com.google.firebase.firestore.model.ResourcePath path = query.getPath();
        encode = EncodedPath.encode(path);
        prefixSuccessor = EncodedPath.prefixSuccessor(encode);
        timestamp = snapshotVersion2.getTimestamp();
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        final ImmutableSortedMap[] arr3 = new ImmutableSortedMap[i3];
        arr3[i4] = DocumentCollections.emptyMutableDocumentMap();
        int i5 = 2;
        if (snapshotVersion2.equals(SnapshotVersion.NONE)) {
            timestamp = new Object[i5];
            timestamp[i4] = encode;
            timestamp[i3] = prefixSuccessor;
            obj14 = this.db.query("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?").binding(timestamp);
        } else {
            arr = new Object[5];
            arr[i4] = encode;
            arr[i3] = prefixSuccessor;
            arr[i5] = Long.valueOf(timestamp.getSeconds());
            arr[3] = Long.valueOf(timestamp.getSeconds());
            arr[4] = Integer.valueOf(timestamp.getNanoseconds());
            obj14 = this.db.query("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?AND (read_time_seconds > ? OR (read_time_seconds = ? AND read_time_nanos > ?))").binding(arr);
        }
        super(this, length + 1, backgroundQueue, query, arr3);
        obj14.forEach(e1Var);
        backgroundQueue.drain();
        return arr3[i4];
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void h(int i, BackgroundQueue backgroundQueue2, Query query3, ImmutableSortedMap[] immutableSortedMap4Arr4, Cursor cursor5) {
        g(i, backgroundQueue2, query3, immutableSortedMap4Arr4, cursor5);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void remove(DocumentKey documentKey) {
        Object[] arr = new Object[1];
        this.db.execute("DELETE FROM remote_documents WHERE path = ?", pathForKey(documentKey));
    }
}
