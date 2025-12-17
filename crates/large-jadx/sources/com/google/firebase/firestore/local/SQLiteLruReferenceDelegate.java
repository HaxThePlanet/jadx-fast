package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
class SQLiteLruReferenceDelegate implements com.google.firebase.firestore.local.ReferenceDelegate, com.google.firebase.firestore.local.LruDelegate {

    static final int REMOVE_ORPHANED_DOCUMENTS_BATCH_SIZE = 100;
    private long currentSequenceNumber = -1;
    private final com.google.firebase.firestore.local.LruGarbageCollector garbageCollector;
    private com.google.firebase.firestore.local.ReferenceSet inMemoryPins;
    private ListenSequence listenSequence;
    private final com.google.firebase.firestore.local.SQLitePersistence persistence;
    SQLiteLruReferenceDelegate(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LruGarbageCollector.Params lruGarbageCollector$Params2) {
        super();
        final int i = -1;
        this.persistence = sQLitePersistence;
        LruGarbageCollector obj3 = new LruGarbageCollector(this, params2);
        this.garbageCollector = obj3;
    }

    static void a(Consumer consumer, Cursor cursor2) {
        consumer.accept(Long.valueOf(cursor2.getLong(0)));
    }

    static Long b(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    private void c(int[] iArr, Cursor cursor2) {
        boolean pinned;
        int[] obj3;
        final int i = 0;
        DocumentKey obj4 = DocumentKey.fromPath(EncodedPath.decodeResourcePath(cursor2.getString(i)));
        if (!isPinned(obj4)) {
            iArr[i] = i2++;
            this.persistence.getRemoteDocumentCache().remove(obj4);
            removeSentinel(obj4);
        }
    }

    private boolean isPinned(DocumentKey documentKey) {
        if (this.inMemoryPins.containsKey(documentKey)) {
            return 1;
        }
        return mutationQueuesContainKey(documentKey);
    }

    private boolean mutationQueuesContainKey(DocumentKey documentKey) {
        int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = EncodedPath.encode(documentKey.getPath());
        return obj5 ^= i;
    }

    private void removeSentinel(DocumentKey documentKey) {
        Object[] arr = new Object[1];
        this.persistence.execute("DELETE FROM target_documents WHERE path = ? AND target_id = 0", EncodedPath.encode(documentKey.getPath()));
    }

    private void writeSentinel(DocumentKey documentKey) {
        Object[] arr = new Object[2];
        this.persistence.execute("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", EncodedPath.encode(documentKey.getPath()), Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void addReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void d(int[] iArr, Cursor cursor2) {
        c(iArr, cursor2);
    }

    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        k0 k0Var = new k0(consumer);
        this.persistence.query("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0").forEach(k0Var);
    }

    public void forEachTarget(Consumer<com.google.firebase.firestore.local.TargetData> consumer) {
        this.persistence.getTargetCache().forEachTarget(consumer);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getByteSize() {
        return this.persistence.getByteSize();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getCurrentSequenceNumber() {
        int i;
        int i2 = 0;
        i = Long.compare(currentSequenceNumber, i3) != 0 ? 1 : i2;
        Assert.hardAssert(i, "Attempting to get a sequence number outside of a transaction", new Object[i2]);
        return this.currentSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public com.google.firebase.firestore.local.LruGarbageCollector getGarbageCollector() {
        return this.garbageCollector;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getSequenceNumberCount() {
        return targetCount += longValue;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionCommitted() {
        int i;
        final int i3 = -1;
        int i2 = 0;
        i = Long.compare(currentSequenceNumber, i3) != 0 ? 1 : i2;
        Assert.hardAssert(i, "Committing a transaction without having started one", new Object[i2]);
        this.currentSequenceNumber = i3;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionStarted() {
        int i;
        int i2 = 0;
        i = Long.compare(currentSequenceNumber, i3) == 0 ? 1 : i2;
        Assert.hardAssert(i, "Starting a transaction without committing the previous one", new Object[i2]);
        this.currentSequenceNumber = this.listenSequence.next();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeMutationReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public int removeOrphanedDocuments(long l) {
        int forEach;
        int i2;
        int i3;
        com.google.firebase.firestore.local.l0 l0Var;
        int i;
        Integer valueOf;
        final int i4 = 1;
        final int[] iArr = new int[i4];
        while (/* condition */) {
            i3 = 0;
            while (i2 != 0) {
                Object[] arr = new Object[2];
                arr[i3] = Long.valueOf(l);
                i = 100;
                arr[i4] = Integer.valueOf(i);
                l0Var = new l0(this, iArr);
                if (this.persistence.query("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?").binding(arr).forEach(l0Var) == i) {
                    break loop_2;
                } else {
                }
                i2 = i3;
                i3 = 0;
            }
            arr = new Object[2];
            arr[i3] = Long.valueOf(l);
            i = 100;
            arr[i4] = Integer.valueOf(i);
            l0Var = new l0(this, iArr);
            if (this.persistence.query("select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?").binding(arr).forEach(l0Var) == i) {
            } else {
            }
            i2 = i3;
            i2 = i4;
        }
        return iArr[i3];
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeTarget(com.google.firebase.firestore.local.TargetData targetData) {
        this.persistence.getTargetCache().updateTargetData(targetData.withSequenceNumber(getCurrentSequenceNumber()));
    }

    public int removeTargets(long l, SparseArray<?> sparseArray2) {
        return this.persistence.getTargetCache().removeQueries(l, sparseArray2);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void setInMemoryPins(com.google.firebase.firestore.local.ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    void start(long l) {
        ListenSequence listenSequence = new ListenSequence(l, obj3);
        this.listenSequence = listenSequence;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void updateLimboDocument(DocumentKey documentKey) {
        writeSentinel(documentKey);
    }
}
