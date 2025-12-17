package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.index.IndexEntry;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.DelayedTask;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class IndexBackfiller {

    private static final long INITIAL_BACKFILL_DELAY_MS;
    private static final long REGULAR_BACKFILL_DELAY_MS;
    private final com.google.firebase.firestore.local.SQLitePersistence persistence;

    public static class Results {

        private final int entriesAdded;
        private final int entriesRemoved;
        private final boolean hasRun;
        Results(boolean z, int i2, int i3) {
            super();
            this.hasRun = z;
            this.entriesAdded = i2;
            this.entriesRemoved = i3;
        }

        static com.google.firebase.firestore.local.IndexBackfiller.Results DidNotRun() {
            final int i = 0;
            IndexBackfiller.Results results = new IndexBackfiller.Results(i, i, i);
            return results;
        }

        public int getEntriesAdded() {
            return this.entriesAdded;
        }

        public int getEntriesRemoved() {
            return this.entriesRemoved;
        }

        public boolean hasRun() {
            return this.hasRun;
        }
    }

    public class BackfillScheduler implements com.google.firebase.firestore.local.Scheduler {

        private final AsyncQueue asyncQueue;
        private AsyncQueue.DelayedTask backfillTask;
        private boolean hasRun = false;
        private final com.google.firebase.firestore.local.LocalStore localStore;
        final com.google.firebase.firestore.local.IndexBackfiller this$0;
        public BackfillScheduler(com.google.firebase.firestore.local.IndexBackfiller indexBackfiller, AsyncQueue asyncQueue2, com.google.firebase.firestore.local.LocalStore localStore3) {
            this.this$0 = indexBackfiller;
            super();
            final int obj1 = 0;
            this.asyncQueue = asyncQueue2;
            this.localStore = localStore3;
        }

        private void a() {
            this.localStore.backfillIndexes(this.this$0);
            this.hasRun = true;
            scheduleBackfill();
        }

        private void scheduleBackfill() {
            long l;
            if (this.hasRun) {
                l = IndexBackfiller.access$000();
            } else {
                l = IndexBackfiller.access$100();
            }
            c cVar = new c(this);
            this.backfillTask = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.INDEX_BACKFILL, l, obj1);
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void b() {
            a();
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void start() {
            scheduleBackfill();
        }

        @Override // com.google.firebase.firestore.local.Scheduler
        public void stop() {
            final AsyncQueue.DelayedTask backfillTask = this.backfillTask;
            if (backfillTask != null) {
                backfillTask.cancel();
            }
        }
    }
    static {
        IndexBackfiller.INITIAL_BACKFILL_DELAY_MS = TimeUnit.SECONDS.toMillis(15);
        IndexBackfiller.REGULAR_BACKFILL_DELAY_MS = TimeUnit.MINUTES.toMillis(1);
    }

    public IndexBackfiller(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence) {
        super();
        this.persistence = sQLitePersistence;
    }

    static IndexEntry a(int i, Cursor cursor2) {
        IndexEntry indexEntry2;
        int i2;
        byte[] blob;
        byte[] blob2;
        String string;
        String string2;
        IndexEntry indexEntry;
        int obj7;
        if (cursor2 == null) {
            obj7 = 0;
        } else {
            super(i, cursor2.getBlob(0), cursor2.getBlob(1), cursor2.getString(2), cursor2.getString(3));
            obj7 = indexEntry;
        }
        return obj7;
    }

    static long access$000() {
        return IndexBackfiller.REGULAR_BACKFILL_DELAY_MS;
    }

    static long access$100() {
        return IndexBackfiller.INITIAL_BACKFILL_DELAY_MS;
    }

    void addIndexEntry(IndexEntry indexEntry) {
        Object[] arr = new Object[5];
        this.persistence.execute("INSERT OR IGNORE INTO index_entries (index_id, array_value, directional_value, uid, document_name) VALUES(?, ?, ?, ?, ?)", Integer.valueOf(indexEntry.getIndexId()), indexEntry.getArrayValue(), indexEntry.getDirectionalValue(), indexEntry.getUid(), indexEntry.getDocumentName());
    }

    public com.google.firebase.firestore.local.IndexBackfiller.Results backfill() {
        final int i2 = 0;
        IndexBackfiller.Results results = new IndexBackfiller.Results(1, i2, i2);
        return results;
    }

    IndexEntry getIndexEntry(int i) {
        Object[] arr = new Object[1];
        d dVar = new d(i);
        return (IndexEntry)this.persistence.query("SELECT array_value, directional_value, uid, document_name FROM index_entries WHERE index_id = ?").binding(Integer.valueOf(i)).firstValue(dVar);
    }

    public com.google.firebase.firestore.local.IndexBackfiller.BackfillScheduler newScheduler(AsyncQueue asyncQueue, com.google.firebase.firestore.local.LocalStore localStore2) {
        IndexBackfiller.BackfillScheduler backfillScheduler = new IndexBackfiller.BackfillScheduler(this, asyncQueue, localStore2);
        return backfillScheduler;
    }

    void removeIndexEntry(int i, String string2, String string3) {
        Object[] arr = new Object[3];
        this.persistence.execute("DELETE FROM index_entries WHERE index_id = ? AND uid = ?AND document_name = ?", Integer.valueOf(i), string2, string3);
    }
}
