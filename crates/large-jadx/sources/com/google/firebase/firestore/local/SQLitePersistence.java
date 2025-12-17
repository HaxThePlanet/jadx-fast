package com.google.firebase.firestore.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.FileUtil;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class SQLitePersistence extends com.google.firebase.firestore.local.Persistence {

    private final com.google.firebase.firestore.local.SQLiteBundleCache bundleCache;
    private SQLiteDatabase db;
    private final com.google.firebase.firestore.local.IndexBackfiller indexBackfiller;
    private final com.google.firebase.firestore.local.SQLiteIndexManager indexManager;
    private final SQLiteOpenHelper opener;
    private final com.google.firebase.firestore.local.SQLiteLruReferenceDelegate referenceDelegate;
    private final com.google.firebase.firestore.local.SQLiteRemoteDocumentCache remoteDocumentCache;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    private boolean started;
    private final com.google.firebase.firestore.local.SQLiteTargetCache targetCache;
    private final SQLiteTransactionListener transactionListener;

    static class LongQuery {

        private static final int LIMIT = 900;
        private final List<Object> argsHead;
        private final Iterator<Object> argsIter;
        private final com.google.firebase.firestore.local.SQLitePersistence db;
        private final String head;
        private int subqueriesPerformed = 0;
        private final String tail;
        LongQuery(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, String string2, List<Object> list3, String string4) {
            super();
            final int i = 0;
            this.db = sQLitePersistence;
            this.head = string2;
            this.argsHead = Collections.emptyList();
            this.tail = string4;
            this.argsIter = list3.iterator();
        }

        LongQuery(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, String string2, List<Object> list3, List<Object> list4, String string5) {
            super();
            final int i = 0;
            this.db = sQLitePersistence;
            this.head = string2;
            this.argsHead = list3;
            this.tail = string5;
            this.argsIter = list4.iterator();
        }

        int getSubqueriesPerformed() {
            return this.subqueriesPerformed;
        }

        boolean hasMoreSubqueries() {
            return this.argsIter.hasNext();
        }

        com.google.firebase.firestore.local.SQLitePersistence.Query performNextSubquery() {
            int i;
            Object next;
            boolean next2;
            this.subqueriesPerformed = subqueriesPerformed++;
            ArrayList arrayList = new ArrayList(this.argsHead);
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            while (this.argsIter.hasNext()) {
                if (i < size - 900) {
                }
                if (i > 0) {
                }
                stringBuilder.append("?");
                arrayList.add(this.argsIter.next());
                i++;
                stringBuilder.append(", ");
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.head);
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append(this.tail);
            return this.db.query(stringBuilder2.toString()).binding(arrayList.toArray());
        }
    }

    private static class OpenHelper extends SQLiteOpenHelper {

        private boolean configured;
        private final com.google.firebase.firestore.local.LocalSerializer serializer;
        OpenHelper(Context context, com.google.firebase.firestore.local.LocalSerializer localSerializer2, String string3) {
            super(context, string3, 0, 12);
            this.serializer = localSerializer2;
        }

        private void ensureConfigured(SQLiteDatabase sQLiteDatabase) {
            if (!this.configured) {
                onConfigure(sQLiteDatabase);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.configured = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            ensureConfigured(sQLiteDatabase);
            SQLiteSchema sQLiteSchema = new SQLiteSchema(sQLiteDatabase, this.serializer);
            sQLiteSchema.runMigrations(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            ensureConfigured(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            ensureConfigured(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            ensureConfigured(sQLiteDatabase);
            SQLiteSchema obj4 = new SQLiteSchema(sQLiteDatabase, this.serializer);
            obj4.runMigrations(i2);
        }
    }

    static class Query {

        private SQLiteDatabase.CursorFactory cursorFactory;
        private final SQLiteDatabase db;
        private final String sql;
        Query(SQLiteDatabase sQLiteDatabase, String string2) {
            super();
            this.db = sQLiteDatabase;
            this.sql = string2;
        }

        static Cursor a(Object[] objectArr, SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver3, String string4, SQLiteQuery sQLiteQuery5) {
            SQLitePersistence.access$100(sQLiteQuery5, objectArr);
            SQLiteCursor obj0 = new SQLiteCursor(sQLiteCursorDriver3, string4, sQLiteQuery5);
            return obj0;
        }

        private Cursor startQuery() {
            SQLiteDatabase.CursorFactory cursorFactory = this.cursorFactory;
            final int i = 0;
            if (cursorFactory != null) {
                return this.db.rawQueryWithFactory(cursorFactory, this.sql, i, i);
            }
            return this.db.rawQuery(this.sql, i);
        }

        com.google.firebase.firestore.local.SQLitePersistence.Query binding(Object... objectArr) {
            z0 z0Var = new z0(objectArr);
            this.cursorFactory = z0Var;
            return this;
        }

        int first(Consumer<Cursor> consumer) {
            try {
                final Cursor query = startQuery();
                consumer.accept(query);
                if (query.moveToFirst() && query != null) {
                }
                consumer.accept(query);
                if (query != null) {
                }
                query.close();
                return 1;
            } catch (Throwable th) {
            }
            try {
                if (query != null) {
                }
                query.close();
                return 0;
                int i = 0;
                if (i == 0) {
                } else {
                }
                i.close();
                throw consumer;
            }
        }

        <T> T firstValue(Function<Cursor, T> function) {
            final Cursor query = startQuery();
            if (query.moveToFirst() && query != null) {
                try {
                    if (query != null) {
                    }
                    query.close();
                    return function.apply(query);
                } catch (Throwable th) {
                }
                try {
                    query.close();
                    return 0;
                    Object obj = obj1;
                    if (obj == null) {
                    } else {
                    }
                    obj.close();
                    throw function;
                }
            }
        }

        int forEach(Consumer<Cursor> consumer) {
            int i;
            boolean moveToNext;
            final Cursor query = startQuery();
            i = 0;
            while (query.moveToNext()) {
                i++;
                consumer.accept(query);
            }
            if (query != null) {
                query.close();
            }
            try {
                return i;
                if (th == null) {
                } else {
                }
                th.close();
                consumer.addSuppressed(th);
                throw consumer;
            } catch (Throwable th) {
            }
        }

        boolean isEmpty() {
            Throwable th;
            try {
                final Cursor query = startQuery();
                if (query != null) {
                }
                query.close();
                return moveToFirst ^= 1;
            } catch (Throwable th) {
            }
            if (i == 0) {
            } else {
                i.close();
            }
            throw th;
        }
    }
    public SQLitePersistence(Context context, String string2, DatabaseId databaseId3, com.google.firebase.firestore.local.LocalSerializer localSerializer4, com.google.firebase.firestore.local.LruGarbageCollector.Params lruGarbageCollector$Params5) {
        SQLitePersistence.OpenHelper openHelper = new SQLitePersistence.OpenHelper(context, localSerializer4, SQLitePersistence.databaseName(string2, databaseId3));
        super(localSerializer4, params5, openHelper);
    }

    public SQLitePersistence(com.google.firebase.firestore.local.LocalSerializer localSerializer, com.google.firebase.firestore.local.LruGarbageCollector.Params lruGarbageCollector$Params2, SQLiteOpenHelper sQLiteOpenHelper3) {
        super();
        SQLitePersistence.1 anon = new SQLitePersistence.1(this);
        this.transactionListener = anon;
        this.opener = sQLiteOpenHelper3;
        this.serializer = localSerializer;
        SQLiteTargetCache obj4 = new SQLiteTargetCache(this, localSerializer);
        this.targetCache = obj4;
        obj4 = new SQLiteIndexManager(this, localSerializer);
        this.indexManager = obj4;
        obj4 = new SQLiteBundleCache(this, localSerializer);
        this.bundleCache = obj4;
        obj4 = new SQLiteRemoteDocumentCache(this, localSerializer);
        this.remoteDocumentCache = obj4;
        SQLiteLruReferenceDelegate obj2 = new SQLiteLruReferenceDelegate(this, params2);
        this.referenceDelegate = obj2;
        obj2 = new IndexBackfiller(this);
        this.indexBackfiller = obj2;
    }

    static Long a(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    static com.google.firebase.firestore.local.SQLiteLruReferenceDelegate access$000(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence) {
        return sQLitePersistence.referenceDelegate;
    }

    static void access$100(SQLiteProgram sQLiteProgram, Object[] object2Arr2) {
        SQLitePersistence.bind(sQLiteProgram, object2Arr2);
    }

    static Long b(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    private static void bind(SQLiteProgram sQLiteProgram, Object[] object2Arr2) {
        int i;
        int intValue;
        int i2;
        long doubleValue;
        int i3 = 0;
        i = i3;
        for (Object intValue : object2Arr2) {
            sQLiteProgram.bindBlob(i + 1, (byte[])intValue);
            sQLiteProgram.bindDouble(i + 1, (Double)intValue.doubleValue());
            sQLiteProgram.bindLong(i + 1, (Long)intValue.longValue());
            sQLiteProgram.bindLong(i + 1, (long)intValue);
            sQLiteProgram.bindString(i + 1, (String)intValue);
            sQLiteProgram.bindNull(i + 1);
        }
    }

    public static void clearPersistence(Context context, DatabaseId databaseId2, String string3) {
        String obj1 = context.getDatabasePath(SQLitePersistence.databaseName(string3, databaseId2)).getPath();
        StringBuilder obj2 = new StringBuilder();
        obj2.append(obj1);
        obj2.append("-journal");
        StringBuilder obj3 = new StringBuilder();
        obj3.append(obj1);
        obj3.append("-wal");
        File file = new File(obj1);
        obj1 = new File(obj2.toString());
        obj2 = new File(obj3.toString());
        FileUtil.delete(file);
        FileUtil.delete(obj1);
        FileUtil.delete(obj2);
    }

    public static String databaseName(String string, DatabaseId databaseId2) {
        final String str = ".";
        final String str2 = "utf-8";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("firestore.");
        stringBuilder.append(URLEncoder.encode(string, str2));
        stringBuilder.append(str);
        stringBuilder.append(URLEncoder.encode(databaseId2.getProjectId(), str2));
        stringBuilder.append(str);
        stringBuilder.append(URLEncoder.encode(databaseId2.getDatabaseId(), str2));
        return stringBuilder.toString();
    }

    private long getPageCount() {
        return (Long)query("PRAGMA page_count").firstValue(a1.a).longValue();
    }

    private long getPageSize() {
        return (Long)query("PRAGMA page_size").firstValue(y0.a).longValue();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    int execute(SQLiteStatement sQLiteStatement, Object... object2Arr2) {
        sQLiteStatement.clearBindings();
        SQLitePersistence.bind(sQLiteStatement, object2Arr2);
        return sQLiteStatement.executeUpdateDelete();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    void execute(String string, Object... object2Arr2) {
        this.db.execSQL(string, object2Arr2);
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.BundleCache getBundleCache() {
        return this.bundleCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    long getByteSize() {
        return pageCount *= pageSize;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.DocumentOverlay getDocumentOverlay(User user) {
        SQLiteDocumentOverlay sQLiteDocumentOverlay = new SQLiteDocumentOverlay(this, this.serializer, user);
        return sQLiteDocumentOverlay;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public com.google.firebase.firestore.local.IndexBackfiller getIndexBackfiller() {
        return this.indexBackfiller;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.IndexManager getIndexManager() {
        return this.indexManager;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.MutationQueue getMutationQueue(User user) {
        SQLiteMutationQueue sQLiteMutationQueue = new SQLiteMutationQueue(this, this.serializer, user);
        return sQLiteMutationQueue;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public com.google.firebase.firestore.local.ReferenceDelegate getReferenceDelegate() {
        return getReferenceDelegate();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public com.google.firebase.firestore.local.SQLiteLruReferenceDelegate getReferenceDelegate() {
        return this.referenceDelegate;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.RemoteDocumentCache getRemoteDocumentCache() {
        return this.remoteDocumentCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.SQLiteTargetCache getTargetCache() {
        return this.targetCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.TargetCache getTargetCache() {
        return getTargetCache();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public boolean isStarted() {
        return this.started;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    SQLiteStatement prepare(String string) {
        return this.db.compileStatement(string);
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.SQLitePersistence.Query query(String string) {
        SQLitePersistence.Query query = new SQLitePersistence.Query(this.db, string);
        return query;
    }

    <T> T runTransaction(String string, Supplier<T> supplier2) {
        Object[] arr = new Object[1];
        Logger.debug(Persistence.TAG, "Starting transaction: %s", string);
        this.db.beginTransactionWithListener(this.transactionListener);
        this.db.setTransactionSuccessful();
        this.db.endTransaction();
        return supplier2.get();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    void runTransaction(String string, Runnable runnable2) {
        Object[] arr = new Object[1];
        Logger.debug(Persistence.TAG, "Starting transaction: %s", string);
        this.db.beginTransactionWithListener(this.transactionListener);
        runnable2.run();
        this.db.setTransactionSuccessful();
        this.db.endTransaction();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void shutdown() {
        final int i2 = 0;
        Assert.hardAssert(this.started, "SQLitePersistence shutdown without start!", new Object[i2]);
        this.started = i2;
        this.db.close();
        this.db = 0;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void start() {
        int i2 = 1;
        Object[] arr = new Object[0];
        Assert.hardAssert(started ^= i2, "SQLitePersistence double-started!", arr);
        this.started = i2;
        this.db = this.opener.getWritableDatabase();
        this.targetCache.start();
        this.referenceDelegate.start(this.targetCache.getHighestListenSequenceNumber());
    }
}
