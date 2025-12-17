package com.google.firebase.firestore.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.proto.Target.Builder;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Preconditions;
import com.google.protobuf.a;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class SQLiteSchema {

    static final int INDEXING_SUPPORT_VERSION = 14;
    static final int OVERLAY_SUPPORT_VERSION = 13;
    private static final int SEQUENCE_NUMBER_BATCH_SIZE = 100;
    static final int VERSION = 12;
    private final SQLiteDatabase db;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    SQLiteSchema(SQLiteDatabase sQLiteDatabase, com.google.firebase.firestore.local.LocalSerializer localSerializer2) {
        super();
        this.db = sQLiteDatabase;
        this.serializer = localSerializer2;
    }

    private void a() {
        this.db.execSQL("CREATE TABLE bundles (bundle_id TEXT PRIMARY KEY, create_time_seconds INTEGER, create_time_nanos INTEGER, schema_version INTEGER, total_documents INTEGER, total_bytes INTEGER)");
        this.db.execSQL("CREATE TABLE named_queries (name TEXT PRIMARY KEY, read_time_seconds INTEGER, read_time_nanos INTEGER, bundled_query_proto BLOB)");
    }

    private void addReadTime() {
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    private void addSequenceNumber() {
        boolean tableContainsColumn;
        String str;
        if (!tableContainsColumn("target_documents", "sequence_number")) {
            this.db.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
        }
    }

    private void addTargetCount() {
        boolean tableContainsColumn;
        String str;
        final String str2 = "target_globals";
        String str3 = "target_count";
        if (!tableContainsColumn(str2, str3)) {
            this.db.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        String str4 = "targets";
        ContentValues contentValues = new ContentValues();
        contentValues.put(str3, Long.valueOf(DatabaseUtils.queryNumEntries(this.db, str4)));
        int i = 0;
        this.db.update(str2, contentValues, i, i);
    }

    private void c() {
        this.db.execSQL("CREATE TABLE index_configuration (index_id INTEGER, collection_group TEXT, index_proto BLOB, active INTEGER, update_time_seconds INTEGER, update_time_nanos INTEGER, PRIMARY KEY (index_id))");
        this.db.execSQL("CREATE TABLE index_entries (index_id INTEGER, array_value BLOB, directional_value BLOB, uid TEXT, document_name TEXT, PRIMARY KEY (index_id, array_value, directional_value, uid, document_name))");
    }

    private void createBundleCache() {
        o1 o1Var = new o1(this);
        ifTablesDontExist(/* result */, o1Var);
    }

    private void createFieldIndex() {
        m1 m1Var = new m1(this);
        ifTablesDontExist(/* result */, m1Var);
    }

    private void createOverlays() {
        q1 q1Var = new q1(this);
        ifTablesDontExist(/* result */, q1Var);
    }

    private void createV1MutationQueue() {
        u1 u1Var = new u1(this);
        ifTablesDontExist(/* result */, u1Var);
    }

    private void createV1RemoteDocumentCache() {
        f1 f1Var = new f1(this);
        ifTablesDontExist(/* result */, f1Var);
    }

    private void createV1TargetCache() {
        g1 g1Var = new g1(this);
        ifTablesDontExist(/* result */, g1Var);
    }

    private void createV8CollectionParentsIndex() {
        j1 j1Var = new j1(this);
        ifTablesDontExist(/* result */, j1Var);
        MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex = new MemoryIndexManager.MemoryCollectionParentIndex();
        i1 i1Var = new i1(memoryCollectionParentIndex, this.db.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)"));
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT path FROM remote_documents");
        k1 k1Var = new k1(i1Var);
        query.forEach(k1Var);
        SQLitePersistence.Query query2 = new SQLitePersistence.Query(this.db, "SELECT path FROM document_mutations");
        t1 t1Var = new t1(i1Var);
        query2.forEach(t1Var);
    }

    private void dropLastLimboFreeSnapshotVersion() {
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT target_id, target_proto FROM targets");
        l1 l1Var = new l1(this);
        query.forEach(l1Var);
    }

    private void dropV1TargetCache() {
        boolean tableExists3;
        boolean tableExists;
        boolean tableExists2;
        String str;
        if (tableExists("targets")) {
            this.db.execSQL("DROP TABLE targets");
        }
        if (tableExists("target_globals")) {
            this.db.execSQL("DROP TABLE target_globals");
        }
        if (tableExists("target_documents")) {
            this.db.execSQL("DROP TABLE target_documents");
        }
    }

    private void e() {
        this.db.execSQL("CREATE TABLE document_overlays (uid TEXT, path TEXT, overlay_mutation BLOB, PRIMARY KEY (uid, path))");
    }

    private void ensureSequenceNumbers() {
        int i;
        Object[] arr;
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1");
        Object firstValue = query.firstValue(h1.a);
        int i2 = 1;
        int i3 = 0;
        i = (Long)firstValue != null ? i2 : i3;
        final Object[] arr2 = new Object[i3];
        Assert.hardAssert(i, "Missing highest sequence number", arr2);
        SQLitePersistence.Query query2 = new SQLitePersistence.Query(this.db, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?");
        arr = new Object[i2];
        arr[i3] = 100;
        boolean[] zArr = new boolean[i2];
        zArr[i3] = i3;
        r1 r1Var = new r1(zArr, this.db.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)"), (Long)firstValue.longValue(), arr2);
        query2.binding(arr).forEach(r1Var);
        while (zArr[i3] == null) {
            zArr[i3] = i3;
            r1Var = new r1(zArr, compileStatement, longValue, arr2);
            binding.forEach(r1Var);
        }
    }

    private void ensureTargetGlobal() {
        int i;
        String strArr;
        int str;
        i = Long.compare(numEntries, str) == 0 ? 1 : 0;
        if (i == 0) {
            String str2 = "0";
            this.db.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", /* result */);
        }
    }

    private void g() {
        this.db.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        this.db.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        this.db.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    private boolean hasReadTime() {
        int i2;
        int i;
        String str = "remote_documents";
        boolean tableContainsColumn2 = tableContainsColumn(str, "read_time_seconds");
        boolean tableContainsColumn = tableContainsColumn(str, "read_time_nanos");
        final int i3 = 0;
        i = tableContainsColumn2 == tableContainsColumn ? i2 : i3;
        Assert.hardAssert(i, "Table contained just one of read_time_seconds or read_time_nanos", new Object[i3]);
        if (tableContainsColumn2 && tableContainsColumn) {
            if (tableContainsColumn) {
            } else {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }

    private void i() {
        this.db.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
    }

    private void ifTablesDontExist(String[] stringArr, Runnable runnable2) {
        String string;
        StringBuilder stringBuilder;
        int i2;
        int i;
        Object obj;
        boolean tableExists;
        Object[] obj7;
        Object[] obj8;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[");
        stringBuilder2.append(TextUtils.join(", ", stringArr));
        stringBuilder2.append("]");
        string = stringBuilder2.toString();
        int i3 = 0;
        i = i2;
        for (Object obj : stringArr) {
            tableExists = tableExists(obj);
            i = tableExists;
        }
        if (i == 0) {
            runnable2.run();
        } else {
            obj7 = new StringBuilder();
            obj7.append("Skipping migration because all of ");
            obj7.append(string);
            obj7.append(" already exist");
            Logger.debug("SQLiteSchema", obj7.toString(), new Object[i3]);
        }
    }

    private void k() {
        this.db.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        this.db.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        this.db.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        this.db.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        this.db.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    static void m(com.google.firebase.firestore.local.MemoryIndexManager.MemoryCollectionParentIndex memoryIndexManager$MemoryCollectionParentIndex, SQLiteStatement sQLiteStatement2, ResourcePath resourcePath3) {
        int i;
        boolean obj1;
        Object obj3;
        if (memoryCollectionParentIndex.add(resourcePath3)) {
            sQLiteStatement2.clearBindings();
            sQLiteStatement2.bindString(1, resourcePath3.getLastSegment());
            sQLiteStatement2.bindString(2, EncodedPath.encode((ResourcePath)resourcePath3.popLast()));
            sQLiteStatement2.execute();
        }
    }

    static void n(Consumer consumer, Cursor cursor2) {
        consumer.accept((ResourcePath)EncodedPath.decodeResourcePath(cursor2.getString(0)).popLast());
    }

    static void o(Consumer consumer, Cursor cursor2) {
        consumer.accept((ResourcePath)EncodedPath.decodeResourcePath(cursor2.getString(0)).popLast());
    }

    private void p() {
        this.db.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }

    private void r(Cursor cursor) {
        final int i = 0;
        final int i2 = 1;
        Object[] arr = new Object[2];
        arr[i] = (Target)(Target.Builder)Target.parseFrom(cursor.getBlob(i2)).toBuilder().clearLastLimboFreeSnapshotVersion().build().toByteArray();
        arr[i2] = Integer.valueOf(cursor.getInt(i));
        this.db.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", arr);
    }

    private void removeAcknowledgedMutations() {
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues");
        p1 p1Var = new p1(this);
        query.forEach(p1Var);
    }

    private void removeMutationBatch(String string, int i2) {
        int i;
        SQLiteStatement compileStatement = this.db.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        int i3 = 1;
        compileStatement.bindString(i3, string);
        final int i5 = 2;
        compileStatement.bindLong(i5, (long)i2);
        int i4 = 0;
        i = compileStatement.executeUpdateDelete() != 0 ? i3 : i4;
        Object[] arr = new Object[i5];
        arr[i4] = string;
        arr[i3] = Integer.valueOf(i2);
        Assert.hardAssert(i, "Mutatiohn batch (%s, %d) did not exist", arr);
        Object[] arr2 = new Object[i5];
        arr2[i4] = string;
        arr2[i3] = Integer.valueOf(i2);
        this.db.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", arr2);
    }

    private void rewriteCanonicalIds() {
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT target_id, target_proto FROM targets");
        n1 n1Var = new n1(this);
        query.forEach(n1Var);
    }

    static Long t(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    private boolean tableContainsColumn(String string, String string2) {
        int obj1;
        obj1 = getTableColumns(string).indexOf(string2) != -1 ? 1 : 0;
        return obj1;
    }

    private boolean tableExists(String string) {
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?");
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = string;
        return obj5 ^= i;
    }

    static void u(boolean[] zArr, SQLiteStatement sQLiteStatement2, long l3, Cursor cursor4) {
        int i;
        final int i2 = 0;
        i = 1;
        zArr[i2] = i;
        sQLiteStatement2.clearBindings();
        sQLiteStatement2.bindString(i, obj6.getString(i2));
        sQLiteStatement2.bindLong(2, l3);
        if (Long.compare(obj2, obj4) != 0) {
        } else {
            i = i2;
        }
        Assert.hardAssert(i, "Failed to insert a sentinel row", new Object[i2]);
    }

    private void v(String string, Cursor cursor2) {
        removeMutationBatch(string, cursor2.getInt(0));
    }

    private void x(Cursor cursor) {
        int i = 0;
        final String string = cursor.getString(i);
        final int i2 = 1;
        SQLitePersistence.Query obj8 = new SQLitePersistence.Query(this.db, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?");
        Object[] arr = new Object[2];
        arr[i] = string;
        arr[i2] = Long.valueOf(cursor.getLong(i2));
        s1 s1Var = new s1(this, string);
        obj8.binding(arr).forEach(s1Var);
    }

    private void z(Cursor cursor) {
        final int i = 0;
        final int i2 = 1;
        Object[] arr = new Object[2];
        arr[i] = this.serializer.decodeTargetData(Target.parseFrom(cursor.getBlob(i2))).getTarget().getCanonicalId();
        arr[i2] = Integer.valueOf(cursor.getInt(i));
        this.db.execSQL("UPDATE targets SET canonical_id  = ? WHERE target_id = ?", arr);
    }

    public void A(Cursor cursor) {
        z(cursor);
    }

    public void b() {
        a();
    }

    public void d() {
        c();
    }

    public void f() {
        e();
    }

    List<String> getTableColumns(String string) {
        SQLiteDatabase string2;
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA table_info(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        Cursor rawQuery = this.db.rawQuery(stringBuilder.toString(), 0);
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("name")));
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return arrayList;
    }

    public void h() {
        g();
    }

    public void j() {
        i();
    }

    public void l() {
        k();
    }

    public void q() {
        p();
    }

    void runMigrations() {
        runMigrations(0, 12);
    }

    void runMigrations(int i) {
        int i2;
        i2 = Persistence.OVERLAY_SUPPORT_ENABLED ? 13 : 12;
        if (Persistence.INDEXING_SUPPORT_ENABLED) {
            i2 = 14;
        }
        runMigrations(i, i2);
    }

    void runMigrations(int i, int i2) {
        int i4;
        int i3;
        boolean oVERLAY_SUPPORT_ENABLED;
        boolean readTime;
        int obj4;
        i4 = 1;
        if (i < i4 && i2 >= i4) {
            if (i2 >= i4) {
                createV1MutationQueue();
                createV1TargetCache();
                createV1RemoteDocumentCache();
            }
        }
        int i6 = 3;
        if (i < i6 && i2 >= i6 && i != 0) {
            if (i2 >= i6) {
                if (i != 0) {
                    dropV1TargetCache();
                    createV1TargetCache();
                }
            }
        }
        int i7 = 4;
        if (i < i7 && i2 >= i7) {
            if (i2 >= i7) {
                ensureTargetGlobal();
                addTargetCount();
            }
        }
        int i8 = 5;
        if (i < i8 && i2 >= i8) {
            if (i2 >= i8) {
                addSequenceNumber();
            }
        }
        int i9 = 6;
        if (i < i9 && i2 >= i9) {
            if (i2 >= i9) {
                removeAcknowledgedMutations();
            }
        }
        int i10 = 7;
        if (i < i10 && i2 >= i10) {
            if (i2 >= i10) {
                ensureSequenceNumbers();
            }
        }
        int i11 = 8;
        if (i < i11 && i2 >= i11) {
            if (i2 >= i11) {
                createV8CollectionParentsIndex();
            }
        }
        i3 = 9;
        if (i < i3 && i2 >= i3) {
            if (i2 >= i3) {
                if (!hasReadTime()) {
                    addReadTime();
                } else {
                    dropLastLimboFreeSnapshotVersion();
                }
            }
        }
        if (i == i3 && i2 >= 10) {
            if (i2 >= 10) {
                dropLastLimboFreeSnapshotVersion();
            }
        }
        int i12 = 11;
        if (i < i12 && i2 >= i12) {
            if (i2 >= i12) {
                rewriteCanonicalIds();
            }
        }
        int i13 = 12;
        if (i < i13 && i2 >= i13) {
            if (i2 >= i13) {
                createBundleCache();
            }
        }
        oVERLAY_SUPPORT_ENABLED = 13;
        if (i < oVERLAY_SUPPORT_ENABLED && i2 >= oVERLAY_SUPPORT_ENABLED && !Persistence.OVERLAY_SUPPORT_ENABLED) {
            if (i2 >= oVERLAY_SUPPORT_ENABLED) {
                if (!Persistence.OVERLAY_SUPPORT_ENABLED) {
                    if (Persistence.INDEXING_SUPPORT_ENABLED) {
                    } else {
                        i4 = 0;
                    }
                }
                Preconditions.checkState(i4);
                createOverlays();
            }
        }
        int i5 = 14;
        if (i < i5 && i2 >= i5) {
            if (i2 >= i5) {
                Preconditions.checkState(Persistence.INDEXING_SUPPORT_ENABLED);
                createFieldIndex();
            }
        }
    }

    public void s(Cursor cursor) {
        r(cursor);
    }

    public void w(String string, Cursor cursor2) {
        v(string, cursor2);
    }

    public void y(Cursor cursor) {
        x(cursor);
    }
}
