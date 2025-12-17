package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.a;
import f.c.e.b.a;

/* loaded from: classes2.dex */
class SQLiteBundleCache implements com.google.firebase.firestore.local.BundleCache {

    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    SQLiteBundleCache(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LocalSerializer localSerializer2) {
        super();
        this.db = sQLitePersistence;
        this.serializer = localSerializer2;
    }

    static BundleMetadata a(String string, Cursor cursor2) {
        BundleMetadata bundle;
        String str;
        int int;
        SnapshotVersion snapshotVersion;
        int int2;
        int long;
        BundleMetadata bundleMetadata;
        int obj8;
        if (cursor2 == null) {
            obj8 = 0;
        } else {
            Timestamp timestamp = new Timestamp(cursor2.getLong(1), obj5, cursor2.getInt(2));
            snapshotVersion = new SnapshotVersion(timestamp);
            super(string, cursor2.getInt(0), snapshotVersion, cursor2.getInt(3), cursor2.getLong(4), obj6);
            obj8 = bundleMetadata;
        }
        return obj8;
    }

    private NamedQuery b(String string, Cursor cursor2) {
        if (cursor2 != null) {
            Timestamp timestamp = new Timestamp(cursor2.getLong(0), obj7, cursor2.getInt(1));
            SnapshotVersion snapshotVersion = new SnapshotVersion(timestamp);
            NamedQuery namedQuery = new NamedQuery(string, this.serializer.decodeBundledQuery(a.j(cursor2.getBlob(2))), snapshotVersion);
            return namedQuery;
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public NamedQuery c(String string, Cursor cursor2) {
        return b(string, cursor2);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public BundleMetadata getBundleMetadata(String string) {
        Object[] arr = new Object[1];
        z zVar = new z(string);
        return (BundleMetadata)this.db.query("SELECT schema_version, create_time_seconds, create_time_nanos, total_documents,  total_bytes FROM bundles WHERE bundle_id = ?").binding(string).firstValue(zVar);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public NamedQuery getNamedQuery(String string) {
        Object[] arr = new Object[1];
        a0 a0Var = new a0(this, string);
        return (NamedQuery)this.db.query("SELECT read_time_seconds, read_time_nanos, bundled_query_proto FROM named_queries WHERE name = ?").binding(string).firstValue(a0Var);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveBundleMetadata(BundleMetadata bundleMetadata) {
        Object[] arr = new Object[6];
        int i4 = 1;
        arr[i4] = Integer.valueOf(bundleMetadata.getSchemaVersion());
        arr[2] = Long.valueOf(bundleMetadata.getCreateTime().getTimestamp().getSeconds());
        arr[3] = Integer.valueOf(bundleMetadata.getCreateTime().getTimestamp().getNanoseconds());
        int i7 = 4;
        arr[i7] = Integer.valueOf(bundleMetadata.getTotalDocuments());
        arr[5] = Long.valueOf(bundleMetadata.getTotalBytes());
        this.db.execute("INSERT OR REPLACE INTO bundles (bundle_id, schema_version, create_time_seconds, create_time_nanos, total_documents, total_bytes) VALUES (?, ?, ?, ?, ?, ?)", arr);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveNamedQuery(NamedQuery namedQuery) {
        Object[] arr = new Object[4];
        int i4 = 0;
        arr[i4] = namedQuery.getName();
        arr[1] = Long.valueOf(namedQuery.getReadTime().getTimestamp().getSeconds());
        arr[2] = Integer.valueOf(namedQuery.getReadTime().getTimestamp().getNanoseconds());
        arr[3] = this.serializer.encodeBundledQuery(namedQuery.getBundledQuery()).toByteArray();
        this.db.execute("INSERT OR REPLACE INTO named_queries (name, read_time_seconds, read_time_nanos, bundled_query_proto) VALUES (?, ?, ?, ?)", arr);
    }
}
