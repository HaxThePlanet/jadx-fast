package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.a;
import com.google.protobuf.j;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class SQLiteTargetCache implements com.google.firebase.firestore.local.TargetCache {

    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private int highestTargetId;
    private long lastListenSequenceNumber;
    private SnapshotVersion lastRemoteSnapshotVersion;
    private final com.google.firebase.firestore.local.LocalSerializer localSerializer;
    private long targetCount;

    private static class DocumentKeysHolder {

        ImmutableSortedSet<DocumentKey> keys;
        private DocumentKeysHolder() {
            super();
            this.keys = DocumentKey.emptyKeySet();
        }

        DocumentKeysHolder(com.google.firebase.firestore.local.SQLiteTargetCache.1 sQLiteTargetCache$1) {
            super();
        }
    }

    private static class TargetDataHolder {

        com.google.firebase.firestore.local.TargetData targetData;
        TargetDataHolder(com.google.firebase.firestore.local.SQLiteTargetCache.1 sQLiteTargetCache$1) {
            super();
        }
    }
    SQLiteTargetCache(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LocalSerializer localSerializer2) {
        super();
        this.lastRemoteSnapshotVersion = SnapshotVersion.NONE;
        this.db = sQLitePersistence;
        this.localSerializer = localSerializer2;
    }

    private void a(Consumer consumer, Cursor cursor2) {
        consumer.accept(decodeTargetData(cursor2.getBlob(0)));
    }

    static void c(com.google.firebase.firestore.local.SQLiteTargetCache.DocumentKeysHolder sQLiteTargetCache$DocumentKeysHolder, Cursor cursor2) {
        documentKeysHolder.keys = documentKeysHolder.keys.insert(DocumentKey.fromPath(EncodedPath.decodeResourcePath(cursor2.getString(0))));
    }

    private void d(Target target, com.google.firebase.firestore.local.SQLiteTargetCache.TargetDataHolder sQLiteTargetCache$TargetDataHolder2, Cursor cursor3) {
        com.google.firebase.firestore.local.TargetData obj4 = decodeTargetData(cursor3.getBlob(0));
        if (target.equals(obj4.getTarget())) {
            targetDataHolder2.targetData = obj4;
        }
    }

    private com.google.firebase.firestore.local.TargetData decodeTargetData(byte[] bArr) {
        try {
            return this.localSerializer.decodeTargetData(Target.parseFrom(bArr));
            int arr = 1;
            arr = new Object[arr];
            arr[0] = bArr;
            bArr = "TargetData failed to parse: %s";
            bArr = Assert.fail(bArr, arr);
            throw bArr;
        }
    }

    private void f(SparseArray sparseArray, int[] i2Arr2, Cursor cursor3) {
        Object obj2;
        final int i = 0;
        final int obj4 = cursor3.getInt(i);
        if (sparseArray.get(obj4) == null) {
            removeTarget(obj4);
            i2Arr2[i] = obj2++;
        }
    }

    private void h(Cursor cursor) {
        this.highestTargetId = cursor.getInt(0);
        this.lastListenSequenceNumber = (long)int2;
        Timestamp timestamp = new Timestamp(cursor.getLong(2), obj3, cursor.getInt(3));
        SnapshotVersion snapshotVersion = new SnapshotVersion(timestamp);
        this.lastRemoteSnapshotVersion = snapshotVersion;
        this.targetCount = cursor.getLong(4);
    }

    private void removeTarget(int i) {
        removeMatchingKeysForTargetId(i);
        Object[] arr = new Object[1];
        this.db.execute("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i));
        this.targetCount = targetCount -= i5;
    }

    private void saveTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        String canonicalId = targetData.getTarget().getCanonicalId();
        Timestamp timestamp = targetData.getSnapshotVersion().getTimestamp();
        Object[] arr = new Object[7];
        int i6 = 4;
        arr[i6] = targetData.getResumeToken().O();
        arr[5] = Long.valueOf(targetData.getSequenceNumber());
        arr[6] = this.localSerializer.encodeTargetData(targetData).toByteArray();
        this.db.execute("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", arr);
    }

    private boolean updateMetadata(com.google.firebase.firestore.local.TargetData targetData) {
        int sequenceNumber;
        int i;
        if (targetData.getTargetId() > this.highestTargetId) {
            this.highestTargetId = targetData.getTargetId();
            sequenceNumber = i;
        } else {
            sequenceNumber = 0;
        }
        if (Long.compare(sequenceNumber2, lastListenSequenceNumber) > 0) {
            this.lastListenSequenceNumber = targetData.getSequenceNumber();
        } else {
            i = sequenceNumber;
        }
        return i;
    }

    private void writeMetadata() {
        Object[] arr = new Object[5];
        int i2 = 0;
        arr[i2] = Integer.valueOf(this.highestTargetId);
        int i3 = 1;
        arr[i3] = Long.valueOf(this.lastListenSequenceNumber);
        arr[2] = Long.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getSeconds());
        int i5 = 3;
        arr[i5] = Integer.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getNanoseconds());
        arr[4] = Long.valueOf(this.targetCount);
        this.db.execute("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", arr);
    }

    public void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2) {
        Object next;
        String encode;
        com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence;
        Object[] arr;
        int i;
        Integer valueOf;
        final Iterator obj9 = immutableSortedSet.iterator();
        for (DocumentKey next : obj9) {
            arr = new Object[2];
            this.db.execute(this.db.prepare("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)"), Integer.valueOf(i2), EncodedPath.encode(next.getPath()));
            this.db.getReferenceDelegate().addReference(next);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void addTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        saveTargetData(targetData);
        updateMetadata(targetData);
        this.targetCount = targetCount += i2;
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void b(Consumer consumer, Cursor cursor2) {
        a(consumer, cursor2);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public boolean containsKey(DocumentKey documentKey) {
        int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = EncodedPath.encode(documentKey.getPath());
        return obj5 ^= i;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void e(Target target, com.google.firebase.firestore.local.SQLiteTargetCache.TargetDataHolder sQLiteTargetCache$TargetDataHolder2, Cursor cursor3) {
        d(target, targetDataHolder2, cursor3);
    }

    public void forEachTarget(Consumer<com.google.firebase.firestore.local.TargetData> consumer) {
        x1 x1Var = new x1(this, consumer);
        this.db.query("SELECT target_proto FROM targets").forEach(x1Var);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void g(SparseArray sparseArray, int[] i2Arr2, Cursor cursor3) {
        f(sparseArray, i2Arr2, cursor3);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public long getHighestListenSequenceNumber() {
        return this.lastListenSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public int getHighestTargetId() {
        return this.highestTargetId;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion;
    }

    public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i) {
        SQLiteTargetCache.DocumentKeysHolder documentKeysHolder = new SQLiteTargetCache.DocumentKeysHolder(0);
        Object[] arr = new Object[1];
        v1 v1Var = new v1(documentKeysHolder);
        this.db.query("SELECT path FROM target_documents WHERE target_id = ?").binding(Integer.valueOf(i)).forEach(v1Var);
        return documentKeysHolder.keys;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public long getTargetCount() {
        return this.targetCount;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public com.google.firebase.firestore.local.TargetData getTargetData(Target target) {
        SQLiteTargetCache.TargetDataHolder targetDataHolder = new SQLiteTargetCache.TargetDataHolder(0);
        Object[] arr = new Object[1];
        w1 w1Var = new w1(this, target, targetDataHolder);
        this.db.query("SELECT target_proto FROM targets WHERE canonical_id = ?").binding(target.getCanonicalId()).forEach(w1Var);
        return targetDataHolder.targetData;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void i(Cursor cursor) {
        h(cursor);
    }

    public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2) {
        Object next;
        String encode;
        com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence;
        Object[] arr;
        int i;
        Integer valueOf;
        final Iterator obj9 = immutableSortedSet.iterator();
        for (DocumentKey next : obj9) {
            arr = new Object[2];
            this.db.execute(this.db.prepare("DELETE FROM target_documents WHERE target_id = ? AND path = ?"), Integer.valueOf(i2), EncodedPath.encode(next.getPath()));
            this.db.getReferenceDelegate().removeReference(next);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeMatchingKeysForTargetId(int i) {
        Object[] arr = new Object[1];
        this.db.execute("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i));
    }

    int removeQueries(long l, SparseArray<?> sparseArray2) {
        int i = 1;
        final int[] iArr = new int[i];
        Object[] arr = new Object[i];
        final int obj6 = 0;
        arr[obj6] = Long.valueOf(l);
        y1 y1Var = new y1(this, obj7, iArr);
        this.db.query("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").binding(arr).forEach(y1Var);
        writeMetadata();
        return iArr[obj6];
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        removeTarget(targetData.getTargetId());
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion) {
        this.lastRemoteSnapshotVersion = snapshotVersion;
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    void start() {
        int i;
        z1 z1Var = new z1(this);
        int i2 = 0;
        if (this.db.query("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").first(z1Var) == 1) {
        } else {
            i = i2;
        }
        Assert.hardAssert(i, "Missing target_globals entry", new Object[i2]);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void updateTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        saveTargetData(targetData);
        if (updateMetadata(targetData)) {
            writeMetadata();
        }
    }
}
