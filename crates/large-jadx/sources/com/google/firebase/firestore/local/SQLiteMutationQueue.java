package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.j;
import com.google.protobuf.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
final class SQLiteMutationQueue implements com.google.firebase.firestore.local.MutationQueue {

    private static final int BLOB_MAX_INLINE_LENGTH = 1000000;
    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private j lastStreamToken;
    private int nextBatchId;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    private final String uid;

    private static class BlobAccumulator implements Consumer<Cursor> {

        private final ArrayList<j> chunks;
        private boolean more = true;
        BlobAccumulator(byte[] bArr) {
            super();
            ArrayList arrayList = new ArrayList();
            this.chunks = arrayList;
            int i = 1;
            addChunk(bArr);
        }

        static boolean access$000(com.google.firebase.firestore.local.SQLiteMutationQueue.BlobAccumulator sQLiteMutationQueue$BlobAccumulator) {
            return blobAccumulator.more;
        }

        private void addChunk(byte[] bArr) {
            this.chunks.add(j.s(bArr));
        }

        @Override // com.google.firebase.firestore.util.Consumer
        public void accept(Cursor cursor) {
            final int i = 0;
            byte[] obj3 = cursor.getBlob(i);
            addChunk(obj3);
            if (obj3.length < 1000000) {
                this.more = i;
            }
        }

        @Override // com.google.firebase.firestore.util.Consumer
        public void accept(Object object) {
            accept((Cursor)object);
        }

        @Override // com.google.firebase.firestore.util.Consumer
        int numChunks() {
            return this.chunks.size();
        }

        @Override // com.google.firebase.firestore.util.Consumer
        j result() {
            return j.m(this.chunks);
        }
    }
    SQLiteMutationQueue(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LocalSerializer localSerializer2, User user3) {
        String obj1;
        super();
        this.db = sQLitePersistence;
        this.serializer = localSerializer2;
        if (user3.isAuthenticated()) {
            obj1 = user3.getUid();
        } else {
            obj1 = "";
        }
        this.uid = obj1;
        this.lastStreamToken = WriteStream.EMPTY_STREAM_TOKEN;
    }

    private void a(List list, Cursor cursor2) {
        list.add(decodeInlineMutationBatch(cursor2.getInt(0), cursor2.getBlob(1)));
    }

    private void c(List list, Cursor cursor2) {
        list.add(decodeInlineMutationBatch(cursor2.getInt(0), cursor2.getBlob(1)));
    }

    private MutationBatch decodeInlineMutationBatch(int i, byte[] b2Arr2) {
        com.google.firebase.firestore.local.SQLitePersistence.Query query;
        Object[] arr;
        Integer valueOf;
        byte[] obj9;
        final int i3 = 1;
        final int i4 = 1000000;
        if (b2Arr2.length < i4) {
            return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(b2Arr2));
        }
        try {
            SQLiteMutationQueue.BlobAccumulator blobAccumulator = new SQLiteMutationQueue.BlobAccumulator(b2Arr2);
            while (SQLiteMutationQueue.BlobAccumulator.access$000(blobAccumulator)) {
                arr = new Object[4];
                arr[i3] = Integer.valueOf(i4);
                arr[2] = this.uid;
                arr[3] = Integer.valueOf(i);
                this.db.query("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(arr).first(blobAccumulator);
            }
            arr = new Object[4];
            arr[i3] = Integer.valueOf(i4);
            arr[2] = this.uid;
            arr[3] = Integer.valueOf(i);
            this.db.query("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(arr).first(blobAccumulator);
            return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(blobAccumulator.result()));
            b2Arr2 = new Object[obj1];
            b2Arr2[obj0] = i;
            i = "MutationBatch failed to parse: %s";
            i = Assert.fail(i, b2Arr2);
            throw i;
        }
    }

    private void e(Set set, List list2, Cursor cursor3) {
        boolean valueOf;
        MutationBatch obj3;
        int int = cursor3.getInt(0);
        if (!set.contains(Integer.valueOf(int))) {
            set.add(Integer.valueOf(int));
            list2.add(decodeInlineMutationBatch(int, cursor3.getBlob(1)));
        }
    }

    static int g(MutationBatch mutationBatch, MutationBatch mutationBatch2) {
        return Util.compareIntegers(mutationBatch.getBatchId(), mutationBatch2.getBatchId());
    }

    private void h(List list, int i2, Cursor cursor3) {
        int batchId;
        int int = cursor3.getInt(0);
        batchId = list.size();
        final int i4 = 1;
        if (batchId > 0 && int == (MutationBatch)list.get(batchId -= i4).getBatchId()) {
            if (int == (MutationBatch)list.get(batchId -= i4).getBatchId()) {
            }
        }
        if (EncodedPath.decodeResourcePath(cursor3.getString(i4)).length() != i2) {
        }
        list.add(decodeInlineMutationBatch(int, cursor3.getBlob(2)));
    }

    static Integer j(Cursor cursor) {
        return Integer.valueOf(cursor.getInt(0));
    }

    private MutationBatch k(Cursor cursor) {
        return decodeInlineMutationBatch(cursor.getInt(0), cursor.getBlob(1));
    }

    private void loadNextBatchIdAcrossAllUsers() {
        com.google.firebase.firestore.local.v0 v0Var;
        com.google.firebase.firestore.local.n0 n0Var;
        com.google.firebase.firestore.local.SQLitePersistence.Query query;
        String str;
        ArrayList arrayList = new ArrayList();
        v0Var = new v0(arrayList);
        this.db.query("SELECT uid FROM mutation_queues").forEach(v0Var);
        int i2 = 0;
        this.nextBatchId = i2;
        Iterator iterator = arrayList.iterator();
        int i3 = 1;
        for (String next2 : iterator) {
            Object[] arr = new Object[i3];
            arr[i2] = next2;
            n0Var = new n0(this);
            this.db.query("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").binding(arr).forEach(n0Var);
            i3 = 1;
        }
        this.nextBatchId = nextBatchId += i3;
    }

    static void m(List list, Cursor cursor2) {
        list.add(cursor2.getString(0));
    }

    private void n(Cursor cursor) {
        this.nextBatchId = Math.max(this.nextBatchId, cursor.getInt(0));
    }

    private MutationBatch p(int i, Cursor cursor2) {
        return decodeInlineMutationBatch(i, cursor2.getBlob(0));
    }

    static void r(List list, Cursor cursor2) {
        list.add(EncodedPath.decodeResourcePath(cursor2.getString(0)));
    }

    private void s(Cursor cursor) {
        this.lastStreamToken = j.s(cursor.getBlob(0));
    }

    private void writeMutationQueueMetadata() {
        Object[] arr = new Object[3];
        this.db.execute("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.uid, -1, this.lastStreamToken.O());
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void acknowledgeBatch(MutationBatch mutationBatch, j j2) {
        this.lastStreamToken = (j)Preconditions.checkNotNull(j2);
        writeMutationQueueMetadata();
    }

    public MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list2, List<Mutation> list3) {
        String popLast;
        boolean indexManager;
        com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence;
        Object[] arr;
        String uid;
        final int nextBatchId = this.nextBatchId;
        this.nextBatchId = nextBatchId + 1;
        MutationBatch mutationBatch = new MutationBatch(nextBatchId, timestamp, list2, list3);
        final int i2 = 3;
        Object[] arr2 = new Object[i2];
        final int i4 = 0;
        arr2[i4] = this.uid;
        final int i5 = 1;
        arr2[i5] = Integer.valueOf(nextBatchId);
        int i3 = 2;
        arr2[i3] = this.serializer.encodeMutationBatch(mutationBatch).toByteArray();
        this.db.execute("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", arr2);
        HashSet obj12 = new HashSet();
        final Iterator obj14 = list3.iterator();
        while (obj14.hasNext()) {
            popLast = (Mutation)obj14.next().getKey();
            if (!obj12.add(popLast)) {
            } else {
            }
            arr = new Object[i2];
            arr[i4] = this.uid;
            arr[i5] = EncodedPath.encode(popLast.getPath());
            arr[i3] = Integer.valueOf(nextBatchId);
            this.db.execute(this.db.prepare("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)"), arr);
            this.db.getIndexManager().addToCollectionParentIndex((ResourcePath)popLast.getPath().popLast());
        }
        return mutationBatch;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void b(List list, Cursor cursor2) {
        a(list, cursor2);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void d(List list, Cursor cursor2) {
        c(list, cursor2);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void f(Set set, List list2, Cursor cursor3) {
        e(set, list2, cursor3);
    }

    public List<MutationBatch> getAllMutationBatches() {
        ArrayList arrayList = new ArrayList();
        Object[] arr = new Object[2];
        p0 p0Var = new p0(this, arrayList);
        this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").binding(1000000, this.uid).forEach(p0Var);
        return arrayList;
    }

    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey) {
        ArrayList arrayList = new ArrayList();
        Object[] arr = new Object[3];
        o0 o0Var = new o0(this, arrayList);
        this.db.query("SELECT m.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path = ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(1000000, this.uid, EncodedPath.encode(documentKey.getPath())).forEach(o0Var);
        return arrayList;
    }

    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable) {
        String encode;
        String nextSubquery;
        List s0Var;
        int obj8;
        ArrayList arrayList2 = new ArrayList();
        obj8 = iterable.iterator();
        for (DocumentKey next2 : obj8) {
            arrayList2.add(EncodedPath.encode(next2.getPath()));
        }
        Object[] arr = new Object[2];
        final int i4 = 1;
        arr[i4] = this.uid;
        super(this.db, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(arr), arrayList2, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        while (obj8.hasMoreSubqueries()) {
            s0Var = new s0(this, hashSet, arrayList);
            obj8.performNextSubquery().forEach(s0Var);
        }
        if (obj8.getSubqueriesPerformed() > i4) {
            Collections.sort(arrayList, w0.a);
        }
        return arrayList;
    }

    public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query) {
        int i3 = 1;
        int i5 = 0;
        Assert.hardAssert(collectionGroupQuery ^= i3, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[i5]);
        com.google.firebase.firestore.model.ResourcePath obj9 = query.getPath();
        obj9 = EncodedPath.encode(obj9);
        ArrayList arrayList = new ArrayList();
        Object[] arr2 = new Object[4];
        arr2[i5] = 1000000;
        arr2[i3] = this.uid;
        arr2[2] = obj9;
        arr2[3] = EncodedPath.prefixSuccessor(obj9);
        r0 r0Var = new r0(this, arrayList, length += i3);
        this.db.query("SELECT dm.batch_id, dm.path, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path >= ? AND dm.path < ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(arr2).forEach(r0Var);
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public int getHighestUnacknowledgedBatchId() {
        Object[] arr = new Object[2];
        return (Integer)this.db.query("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").binding(-1, this.uid).firstValue(u0.a).intValue();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public j getLastStreamToken() {
        return this.lastStreamToken;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch getNextMutationBatchAfterBatchId(int i) {
        int i2 = 1;
        Object[] arr = new Object[3];
        arr[i2] = this.uid;
        arr[2] = Integer.valueOf(i += i2);
        m0 m0Var = new m0(this);
        return (MutationBatch)this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").binding(arr).firstValue(m0Var);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void i(List list, int i2, Cursor cursor3) {
        h(list, i2, cursor3);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public boolean isEmpty() {
        Object[] arr = new Object[1];
        return this.db.query("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").binding(this.uid).isEmpty();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch l(Cursor cursor) {
        return k(cursor);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch lookupMutationBatch(int i) {
        Object[] arr = new Object[3];
        x0 x0Var = new x0(this, i);
        return (MutationBatch)this.db.query("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(1000000, this.uid, Integer.valueOf(i)).firstValue(x0Var);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void o(Cursor cursor) {
        n(cursor);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void performConsistencyCheck() {
        if (!isEmpty()) {
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        Object[] arr2 = new Object[i];
        final int i2 = 0;
        arr2[i2] = this.uid;
        t0 t0Var = new t0(arrayList);
        this.db.query("SELECT path FROM document_mutations WHERE uid = ?").binding(arr2).forEach(t0Var);
        Object[] arr = new Object[i];
        arr[i2] = arrayList;
        Assert.hardAssert(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arr);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch q(int i, Cursor cursor2) {
        return p(i, cursor2);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void removeMutationBatch(MutationBatch mutationBatch) {
        int key;
        Object[] referenceDelegate;
        String str;
        Integer valueOf;
        String uid;
        int batchId = mutationBatch.getBatchId();
        final int i = 2;
        Object[] arr = new Object[i];
        final int i3 = 0;
        arr[i3] = this.uid;
        final int i4 = 1;
        arr[i4] = Integer.valueOf(batchId);
        key = this.db.execute(this.db.prepare("DELETE FROM mutations WHERE uid = ? AND batch_id = ?"), arr) != 0 ? i4 : i3;
        referenceDelegate = new Object[i];
        referenceDelegate[i3] = this.uid;
        referenceDelegate[i4] = Integer.valueOf(mutationBatch.getBatchId());
        Assert.hardAssert(key, "Mutation batch (%s, %d) did not exist", referenceDelegate);
        Iterator obj11 = mutationBatch.getMutations().iterator();
        for (Mutation next2 : obj11) {
            key = next2.getKey();
            valueOf = new Object[3];
            valueOf[i3] = this.uid;
            valueOf[i4] = EncodedPath.encode(key.getPath());
            valueOf[i] = Integer.valueOf(batchId);
            this.db.execute(this.db.prepare("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?"), valueOf);
            this.db.getReferenceDelegate().removeMutationReference(key);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void setLastStreamToken(j j) {
        this.lastStreamToken = (j)Preconditions.checkNotNull(j);
        writeMutationQueueMetadata();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void start() {
        loadNextBatchIdAcrossAllUsers();
        Object[] arr = new Object[1];
        q0 q0Var = new q0(this);
        if (this.db.query("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").binding(this.uid).first(q0Var) == 0) {
            writeMutationQueueMetadata();
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void t(Cursor cursor) {
        s(cursor);
    }
}
