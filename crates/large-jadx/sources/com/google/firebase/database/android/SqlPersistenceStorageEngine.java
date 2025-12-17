package com.google.firebase.database.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.persistence.TrackedQuery;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.util.JsonMapper;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class SqlPersistenceStorageEngine implements PersistenceStorageEngine {

    private static final int CHILDREN_NODE_SPLIT_SIZE_THRESHOLD = 16384;
    private static final String CREATE_SERVER_CACHE = "CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);";
    private static final String CREATE_TRACKED_KEYS = "CREATE TABLE trackedKeys (id INTEGER, key TEXT);";
    private static final String CREATE_TRACKED_QUERIES = "CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);";
    private static final String CREATE_WRITES = "CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));";
    private static final String FIRST_PART_KEY = ".part-0000";
    private static final String LOGGER_COMPONENT = "Persistence";
    private static final String PART_KEY_FORMAT = ".part-%04d";
    private static final String PART_KEY_PREFIX = ".part-";
    private static final String PATH_COLUMN_NAME = "path";
    private static final String ROW_ID_COLUMN_NAME = "rowid";
    private static final int ROW_SPLIT_SIZE = 262144;
    private static final String SERVER_CACHE_TABLE = "serverCache";
    private static final String TRACKED_KEYS_ID_COLUMN_NAME = "id";
    private static final String TRACKED_KEYS_KEY_COLUMN_NAME = "key";
    private static final String TRACKED_KEYS_TABLE = "trackedKeys";
    private static final String TRACKED_QUERY_ACTIVE_COLUMN_NAME = "active";
    private static final String TRACKED_QUERY_COMPLETE_COLUMN_NAME = "complete";
    private static final String TRACKED_QUERY_ID_COLUMN_NAME = "id";
    private static final String TRACKED_QUERY_LAST_USE_COLUMN_NAME = "lastUse";
    private static final String TRACKED_QUERY_PARAMS_COLUMN_NAME = "queryParams";
    private static final String TRACKED_QUERY_PATH_COLUMN_NAME = "path";
    private static final String TRACKED_QUERY_TABLE = "trackedQueries";
    private static final Charset UTF8_CHARSET = null;
    private static final String VALUE_COLUMN_NAME = "value";
    private static final String WRITES_TABLE = "writes";
    private static final String WRITE_ID_COLUMN_NAME = "id";
    private static final String WRITE_NODE_COLUMN_NAME = "node";
    private static final String WRITE_PART_COLUMN_NAME = "part";
    private static final String WRITE_TYPE_COLUMN_NAME = "type";
    private static final String WRITE_TYPE_MERGE = "m";
    private static final String WRITE_TYPE_OVERWRITE = "o";
    private final SQLiteDatabase database;
    private boolean insideTransaction;
    private final LogWrapper logger;
    private long transactionStart = 0;

    private static class PersistentCacheOpenHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 2;
        public PersistentCacheOpenHelper(Context context, String string2) {
            super(context, string2, 0, 2);
        }

        private void dropTable(SQLiteDatabase sQLiteDatabase, String string2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TABLE IF EXISTS ");
            stringBuilder.append(string2);
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            int i;
            int i4 = 1;
            i = i3 == 2 ? i4 : 0;
            Utilities.hardAssert(i, "Why is onUpgrade() called with a different version?");
            if (i2 > i4) {
            } else {
                dropTable(sQLiteDatabase, "serverCache");
                sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
                dropTable(sQLiteDatabase, "complete");
                sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            }
            StringBuilder obj5 = new StringBuilder();
            obj5.append("We don't handle upgrading to ");
            obj5.append(i3);
            AssertionError obj4 = new AssertionError(obj5.toString());
            throw obj4;
        }
    }
    static {
        SqlPersistenceStorageEngine.UTF8_CHARSET = Charset.forName("UTF-8");
    }

    public SqlPersistenceStorageEngine(Context context, Context context2, String string3) {
        super();
        int i = 0;
        this.logger = context2.getLogger("Persistence");
        this.database = openDatabase(context, URLEncoder.encode(string3, "utf-8"));
    }

    private static String buildAncestorWhereClause(Path path, String[] string2Arr2) {
        String pathToKey;
        int str;
        int i;
        Path obj4;
        if (string2Arr2.length >= size += str) {
        } else {
            str = i;
        }
        Utilities.hardAssert(str);
        StringBuilder stringBuilder = new StringBuilder("(");
        str = "path";
        while (!obj4.isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append(" = ? OR ");
            string2Arr2[i] = SqlPersistenceStorageEngine.pathToKey(obj4);
            obj4 = obj4.getParent();
            i++;
            str = "path";
        }
        stringBuilder.append(str);
        stringBuilder.append(" = ?)");
        string2Arr2[i] = SqlPersistenceStorageEngine.pathToKey(Path.getEmptyPath());
        return stringBuilder.toString();
    }

    private String commaSeparatedList(Collection<Long> collection) {
        int str;
        long longValue;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator obj5 = collection.iterator();
        str = 1;
        while (obj5.hasNext()) {
            if (str == null) {
            }
            str = 0;
            stringBuilder.append((Long)obj5.next().longValue());
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    private Node deserializeNode(byte[] bArr) {
        try {
            String string = new String(bArr, SqlPersistenceStorageEngine.UTF8_CHARSET);
            return NodeUtilities.NodeFromJSON(JsonMapper.parseJsonValue(string));
            Charset stringBuilder = SqlPersistenceStorageEngine.UTF8_CHARSET;
            String string2 = new String(bArr, stringBuilder);
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not deserialize node: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            bArr = new RuntimeException(string2, th);
            throw bArr;
        }
    }

    private byte[] joinBytes(List<byte[]> list) {
        int i;
        int i2;
        int length2;
        boolean length3;
        int length;
        Iterator iterator = list.iterator();
        final int i3 = 0;
        i = i3;
        for (byte[] next3 : iterator) {
            i += length2;
        }
        byte[] bArr = new byte[i];
        final Iterator obj6 = list.iterator();
        i2 = i3;
        for (byte[] next2 : obj6) {
            System.arraycopy(next2, i3, bArr, i2, next2.length);
            i2 += length3;
        }
        return bArr;
    }

    private Node loadNested(Path path) {
        Object format;
        boolean logsDebug2;
        ArrayList arrayList;
        long currentTimeMillis;
        Object[] arr;
        EmptyNode child;
        int value;
        int i8;
        boolean priorityChildName;
        int i4;
        Node deserializeNode;
        LogWrapper logsDebug;
        byte[] blob;
        HashMap hashMap;
        int i;
        int i2;
        int endsWith;
        int i5;
        Path path3;
        Object[] path2;
        int i3;
        int i6;
        Path path4;
        int i7;
        final Object obj = this;
        format = path;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        currentTimeMillis = System.currentTimeMillis();
        Cursor nestedQuery = obj.loadNestedQuery(format, /* result */);
        currentTimeMillis2 -= currentTimeMillis;
        endsWith = 0;
        while (nestedQuery.moveToNext()) {
            arrayList2.add(nestedQuery.getString(endsWith));
            arrayList.add(nestedQuery.getBlob(1));
            endsWith = 0;
        }
        nestedQuery.close();
        currentTimeMillis7 -= currentTimeMillis4;
        child = EmptyNode.Empty();
        hashMap = new HashMap();
        i3 = i2;
        i6 = i5;
        while (i2 < arrayList.size()) {
            if ((String)arrayList2.get(i2).endsWith(".part-0000")) {
            } else {
            }
            i7 = value;
            deserializeNode = obj.deserializeNode((byte[])arrayList.get(i2));
            path3 = new Path((String)arrayList2.get(i2));
            child = child.updateChild(Path.getRelative(format, path3), deserializeNode);
            i4 = 1;
            i3 = 1;
            i2 += i4;
            i5 = i6;
            value = i7;
            i6 = i5;
            Utilities.hardAssert(i3 ^ 1, "Descendants of path must come after ancestors.");
            child = deserializeNode.getChild(Path.getRelative(path3, format));
            i4 = 1;
            hashMap.put(path3, deserializeNode);
            endsWith = arrayList2.get(i2);
            i7 = value;
            path2 = new Path(endsWith.substring(0, length + -10));
            int splitNodeRunLength = obj.splitNodeRunLength(path2, arrayList2, i2);
            if (obj.logger.logsDebug()) {
            } else {
            }
            path4 = path2;
            splitNodeRunLength += i2;
            deserializeNode = obj.deserializeNode(obj.joinBytes(arrayList.subList(i2, i22)));
            i2 = i8;
            path3 = path4;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading split node with ");
            stringBuilder.append(splitNodeRunLength);
            stringBuilder.append(" parts.");
            path4 = path2;
            obj.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        Iterator iterator = hashMap.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            child = child.updateChild(Path.getRelative(format, (Path)next2.getKey()), (Node)next2.getValue());
        }
        if (obj.logger.logsDebug()) {
            arr = new Object[7];
            obj.logger.debug(String.format(Locale.US, "Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", Integer.valueOf(arrayList.size()), Integer.valueOf(NodeSizeEstimator.nodeCount(child)), format, Long.valueOf(currentTimeMillis6 -= currentTimeMillis), Long.valueOf(value), Long.valueOf(i6), Long.valueOf(currentTimeMillis3 -= currentTimeMillis5)), new Object[0]);
        }
        return child;
    }

    private Cursor loadNestedQuery(Path path, String[] string2Arr2) {
        final String pathToKey = SqlPersistenceStorageEngine.pathToKey(path);
        final String[] strArr2 = new String[size += 3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SqlPersistenceStorageEngine.buildAncestorWhereClause(path, strArr2));
        stringBuilder.append(" OR (path > ? AND path < ?)");
        strArr2[size2++] = pathToKey;
        strArr2[obj12 += 2] = SqlPersistenceStorageEngine.pathPrefixStartToPrefixEnd(pathToKey);
        return this.database.query("serverCache", string2Arr2, stringBuilder.toString(), strArr2, 0, 0, "path");
    }

    private SQLiteDatabase openDatabase(Context context, String string2) {
        SqlPersistenceStorageEngine.PersistentCacheOpenHelper persistentCacheOpenHelper = new SqlPersistenceStorageEngine.PersistentCacheOpenHelper(context, string2);
        final SQLiteDatabase obj2 = persistentCacheOpenHelper.getWritableDatabase();
        obj2.rawQuery("PRAGMA locking_mode = EXCLUSIVE", 0).close();
        obj2.beginTransaction();
        obj2.endTransaction();
        return obj2;
    }

    private String partKey(Path path, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SqlPersistenceStorageEngine.pathToKey(path));
        Object[] arr = new Object[1];
        stringBuilder.append(String.format(Locale.US, ".part-%04d", Integer.valueOf(i2)));
        return stringBuilder.toString();
    }

    private static String pathPrefixStartToPrefixEnd(String string) {
        Utilities.hardAssert(string.endsWith("/"), "Path keys must end with a '/'");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, length--));
        stringBuilder.append('0');
        return stringBuilder.toString();
    }

    private static String pathToKey(Path path) {
        final String str = "/";
        if (path.isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path.toString());
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private void pruneTreeRecursive(Path path, Path path2, ImmutableTree<Long> immutableTree3, ImmutableTree<Long> immutableTree4, PruneForest pruneForest5, List<Pair<Path, Node>> list6) {
        ImmutableSortedMap children;
        int next;
        Path intValue;
        Path child2;
        Object obj;
        boolean logsDebug;
        Object child;
        Object[] nested;
        List list;
        Object iterator;
        Path path3;
        final Object obj2 = this;
        final ImmutableTree immutableTree = immutableTree4;
        final Object obj3 = pruneForest5;
        if (immutableTree3.getValue() != null) {
            next = 0;
            child2 = new SqlPersistenceStorageEngine.1(this, immutableTree);
            intValue = (Integer)obj3.foldKeptNodes(Integer.valueOf(next), child2).intValue();
            Path child3 = path.child(path2);
            if (intValue > 0 && obj2.logger.logsDebug()) {
                child3 = path.child(path2);
                if (obj2.logger.logsDebug()) {
                    nested = new Object[2];
                    nested[next] = Integer.valueOf(intValue);
                    nested[1] = child3;
                    obj2.logger.debug(String.format(Locale.US, "Need to rewrite %d nodes below path %s", nested), new Object[next]);
                }
                super(this, immutableTree4, list6, path2, loadNested(child3));
                obj3.foldKeptNodes(0, iterator);
            }
        } else {
            iterator = immutableTree3.getChildren().iterator();
            for (Map.Entry next2 : iterator) {
                Object key = next2.getKey();
                path3 = path2;
                this.pruneTreeRecursive(path, path2.child((ChildKey)key), (ImmutableTree)next2.getValue(), immutableTree.getChild(key), obj3.child((ChildKey)next2.getKey()), list6);
            }
        }
    }

    private int removeNested(String string, Path path2) {
        String obj6 = SqlPersistenceStorageEngine.pathToKey(path2);
        String[] strArr = new String[2];
        return this.database.delete(string, "path >= ? AND path < ?", obj6, SqlPersistenceStorageEngine.pathPrefixStartToPrefixEnd(obj6));
    }

    private int saveNested(Path path, Node node2) {
        long estimateSerializedNodeSize;
        boolean empty;
        long nested;
        boolean cmp;
        boolean logsDebug;
        int i;
        int i2;
        Locale locale;
        Object[] arr;
        Node obj9;
        estimateSerializedNodeSize = NodeSizeEstimator.estimateSerializedNodeSize(node2);
        final int i5 = 1;
        i2 = 0;
        if (node2 instanceof ChildrenNode && Long.compare(estimateSerializedNodeSize, i) > 0 && this.logger.logsDebug()) {
            if (Long.compare(estimateSerializedNodeSize, i) > 0) {
                i2 = 0;
                if (this.logger.logsDebug()) {
                    arr = new Object[3];
                    arr[i2] = path;
                    arr[i5] = Long.valueOf(estimateSerializedNodeSize);
                    arr[2] = 16384;
                    this.logger.debug(String.format(Locale.US, "Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", arr), new Object[i2]);
                }
                Iterator iterator = node2.iterator();
                for (NamedNode next2 : iterator) {
                    i2 += nested;
                }
                if (!node2.getPriority().isEmpty()) {
                    saveNode(path.child(ChildKey.getPriorityKey()), node2.getPriority());
                    i2++;
                }
                saveNode(path, EmptyNode.Empty());
                return i2 += i5;
            }
        }
        saveNode(path, node2);
        return i5;
    }

    private void saveNode(Path path, Node node2) {
        boolean contentValues2;
        ContentValues contentValues;
        int i;
        Object database;
        Object[] arr;
        Object obj10;
        byte[] obj11;
        obj11 = serializeObject(node2.getValue(true));
        final int i3 = 5;
        final int i4 = 0;
        final String str = "serverCache";
        final String str2 = "value";
        final String str3 = "path";
        i = 262144;
        if (obj11.length >= i) {
            obj11 = SqlPersistenceStorageEngine.splitBytes(obj11, i);
            if (this.logger.logsDebug()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Saving huge leaf node with ");
                stringBuilder.append(obj11.size());
                stringBuilder.append(" parts.");
                this.logger.debug(stringBuilder.toString(), new Object[0]);
            }
            while (i < obj11.size()) {
                contentValues2 = new ContentValues();
                contentValues2.put(str3, partKey(path, i));
                contentValues2.put(str2, (byte[])obj11.get(i));
                this.database.insertWithOnConflict(str, i4, contentValues2, i3);
                i++;
            }
        } else {
            contentValues = new ContentValues();
            contentValues.put(str3, SqlPersistenceStorageEngine.pathToKey(path));
            contentValues.put(str2, obj11);
            this.database.insertWithOnConflict(str, i4, contentValues, i3);
        }
    }

    private void saveWrite(Path path, long l2, String string3, byte[] b4Arr4) {
        Object database;
        List splitBytes;
        int contentValues2;
        int contentValues;
        int pathToKey;
        int database2;
        final Object obj = this;
        database = b4Arr4;
        splitBytes = obj19;
        verifyInsideTransaction();
        String[] strArr = new String[1];
        String str = "writes";
        obj.database.delete(str, "id = ?", String.valueOf(l2));
        int i2 = 5;
        String str3 = "node";
        final String str4 = "part";
        final String str5 = "type";
        final String str6 = "path";
        final String str7 = "id";
        database2 = 262144;
        final int i3 = 0;
        if (splitBytes.length >= database2) {
            splitBytes = SqlPersistenceStorageEngine.splitBytes(splitBytes, database2);
            while (pathToKey < splitBytes.size()) {
                contentValues = new ContentValues();
                contentValues.put(str7, Long.valueOf(l2));
                contentValues.put(str6, SqlPersistenceStorageEngine.pathToKey(path));
                contentValues.put(str5, database);
                contentValues.put(str4, Integer.valueOf(pathToKey));
                contentValues.put(str3, (byte[])splitBytes.get(pathToKey));
                obj.database.insertWithOnConflict(str, i3, contentValues, i2);
                pathToKey++;
            }
        } else {
            contentValues2 = new ContentValues();
            contentValues2.put(str7, Long.valueOf(l2));
            contentValues2.put(str6, SqlPersistenceStorageEngine.pathToKey(path));
            contentValues2.put(str5, database);
            contentValues2.put(str4, i3);
            contentValues2.put(str3, splitBytes);
            obj.database.insertWithOnConflict(str, i3, contentValues2, i2);
        }
    }

    private byte[] serializeObject(Object object) {
        try {
            return JsonMapper.serializeJsonValue(object).getBytes(SqlPersistenceStorageEngine.UTF8_CHARSET);
            RuntimeException runtimeException = new RuntimeException("Could not serialize leaf node", object);
            throw runtimeException;
        }
    }

    private static List<byte[]> splitBytes(byte[] bArr, int i2) {
        int i;
        int i3;
        int i4;
        byte[] bArr2;
        i6++;
        ArrayList arrayList = new ArrayList(i7);
        final int i8 = 0;
        i = i8;
        while (i < i7) {
            i4 = i * i2;
            i3 = Math.min(i2, length2 -= i4);
            bArr2 = new byte[i3];
            System.arraycopy(bArr, i4, bArr2, i8, i3);
            arrayList.add(bArr2);
            i++;
        }
        return arrayList;
    }

    private int splitNodeRunLength(Path path, List<String> list2, int i3) {
        int i;
        String pathToKey;
        boolean startsWith;
        String partKey;
        int obj5;
        String obj6;
        i = i3 + 1;
        pathToKey = SqlPersistenceStorageEngine.pathToKey(path);
        if (!(String)list2.get(i3).startsWith(pathToKey)) {
        }
        obj5 = new IllegalStateException("Extracting split nodes needs to start with path prefix");
        throw obj5;
    }

    private void updateServerCache(Path path, Node node2, boolean z3) {
        boolean logsDebug;
        Locale locale;
        String str;
        int i;
        boolean nested;
        Path child;
        Object obj8;
        int obj9;
        int obj10;
        str = "serverCache";
        final int i3 = 0;
        if (!z3) {
            obj10 = removeNested(str, path);
            obj9 = saveNested(path, node2);
        } else {
            obj9 = node2.iterator();
            i = obj10;
            for (NamedNode next : obj9) {
                i += nested2;
                obj10 += nested;
            }
            obj9 = obj10;
            obj10 = i;
        }
        if (this.logger.logsDebug()) {
            str = new Object[4];
            str[i3] = Integer.valueOf(obj9);
            str[1] = Integer.valueOf(obj10);
            str[2] = path.toString();
            str[3] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", str), new Object[i3]);
        }
    }

    private void verifyInsideTransaction() {
        Utilities.hardAssert(this.insideTransaction, "Transaction expected to already be in progress.");
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void beginTransaction() {
        boolean logsDebug;
        String str2;
        String str;
        final int i2 = 1;
        Utilities.hardAssert(insideTransaction ^= i2, "runInTransaction called when an existing transaction is already in progress.");
        if (this.logger.logsDebug()) {
            this.logger.debug("Starting transaction.", new Object[0]);
        }
        this.database.beginTransaction();
        this.insideTransaction = i2;
        this.transactionStart = System.currentTimeMillis();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void close() {
        this.database.close();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void deleteTrackedQuery(long l) {
        verifyInsideTransaction();
        String obj6 = String.valueOf(l);
        int i = 1;
        final String[] strArr2 = new String[i];
        final int i2 = 0;
        strArr2[i2] = obj6;
        final String str2 = "id = ?";
        this.database.delete("trackedQueries", str2, strArr2);
        String[] strArr = new String[i];
        strArr[i2] = obj6;
        this.database.delete("trackedKeys", str2, strArr);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void endTransaction() {
        int arr2;
        int format;
        boolean logsDebug;
        Locale locale;
        Object[] arr;
        this.database.endTransaction();
        arr2 = 0;
        this.insideTransaction = arr2;
        if (this.logger.logsDebug()) {
            arr = new Object[1];
            arr[arr2] = Long.valueOf(currentTimeMillis -= transactionStart);
            this.logger.debug(String.format(Locale.US, "Transaction completed. Elapsed: %dms", arr), new Object[arr2]);
        }
    }

    public List<TrackedQuery> loadTrackedQueries() {
        boolean logsDebug;
        String format;
        String trackedQuery;
        boolean moveToNext;
        String json;
        int arr;
        String str;
        SQLiteDatabase database;
        String str3;
        int valueOf2;
        String[] strArr;
        int valueOf;
        int pathAndQueryObject;
        int long;
        String str2;
        SQLiteDatabase sQLiteDatabase;
        final Object obj = this;
        valueOf = 0;
        final int i4 = 0;
        Cursor query = obj.database.query("trackedQueries", /* result */, valueOf, 0, 0, i4, "id");
        ArrayList arrayList = new ArrayList();
        arr = 2;
        str = 1;
        database = null;
        while (query.moveToNext()) {
            Path path = new Path(query.getString(str));
            if (query.getInt(4) != 0) {
            } else {
            }
            str2 = database;
            if (query.getInt(5) != 0) {
            } else {
            }
            sQLiteDatabase = database;
            super(query.getLong(database), valueOf, QuerySpec.fromPathAndQueryObject(path, JsonMapper.parseJson(query.getString(arr))), query.getLong(3), i4, str2, sQLiteDatabase);
            arrayList.add(trackedQuery);
            arr = 2;
            str = 1;
            database = null;
            sQLiteDatabase = str;
            str2 = str;
        }
        if (obj.logger.logsDebug()) {
            arr = new Object[arr];
            arr[database] = Integer.valueOf(arrayList.size());
            arr[str] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            obj.logger.debug(String.format(Locale.US, "Loaded %d tracked queries in %dms", arr), new Object[database]);
        }
        query.close();
        return arrayList;
    }

    public Set<ChildKey> loadTrackedQueryKeys(long l) {
        return loadTrackedQueryKeys(Collections.singleton(Long.valueOf(l)));
    }

    public Set<ChildKey> loadTrackedQueryKeys(Set<Long> set) {
        int string;
        boolean logsDebug;
        String str2;
        int valueOf;
        int i;
        int str;
        int arr;
        int i2;
        Object obj14;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id IN (");
        stringBuilder.append(commaSeparatedList(set));
        stringBuilder.append(")");
        final String string3 = stringBuilder.toString();
        Cursor query = this.database.query(true, "trackedKeys", /* result */, string3, 0, 0, 0, 0, 0);
        HashSet hashSet = new HashSet();
        str2 = null;
        while (query.moveToNext()) {
            hashSet.add(ChildKey.fromString(query.getString(str2)));
            str2 = null;
        }
        if (this.logger.logsDebug()) {
            arr = new Object[3];
            arr[str2] = Integer.valueOf(hashSet.size());
            arr[1] = set.toString();
            arr[2] = Long.valueOf(currentTimeMillis -= currentTimeMillis2);
            this.logger.debug(String.format(Locale.US, "Loaded %d tracked queries keys for tracked queries %s in %dms", arr), new Object[str2]);
        }
        query.close();
        return hashSet;
    }

    public List<UserWriteRecord> loadUserWrites() {
        boolean logsDebug;
        String format;
        String userWriteRecord2;
        boolean moveToNext;
        SQLiteDatabase userWriteRecord;
        int arr;
        byte[] joinBytes;
        String equals;
        String[] uTF8_CHARSET;
        int moveToNext2;
        int valueOf;
        int long2;
        int valueOf2;
        int path;
        String long;
        int i;
        valueOf2 = 0;
        Cursor query = this.database.query("writes", /* result */, 0, 0, valueOf2, 0, "id, part");
        ArrayList arrayList = new ArrayList();
        arr = 2;
        int i3 = 1;
        int i5 = 0;
        while (query.moveToNext()) {
            long2 = query.getLong(i5);
            path = new Path(query.getString(i3));
            String string3 = query.getString(arr);
            int i4 = 4;
            if (query.isNull(3)) {
            } else {
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(query.getBlob(i4));
            while (query.moveToNext()) {
                if (Long.compare(long, long2) == 0) {
                }
                arrayList2.add(query.getBlob(i4));
            }
            query.moveToPrevious();
            joinBytes = joinBytes(arrayList2);
            String string4 = new String(joinBytes, SqlPersistenceStorageEngine.UTF8_CHARSET);
            userWriteRecord = JsonMapper.parseJsonValue(string4);
            userWriteRecord = new UserWriteRecord(long2, valueOf2, path, CompoundWrite.fromValue((Map)userWriteRecord));
            userWriteRecord2 = userWriteRecord;
            arrayList.add(userWriteRecord2);
            arr = 2;
            i3 = 1;
            i5 = 0;
            super(long2, valueOf2, path, NodeUtilities.NodeFromJSON(userWriteRecord), 1);
            if (Long.compare(long, long2) == 0) {
            }
            joinBytes = query.getBlob(i4);
        }
        if (this.logger.logsDebug()) {
            arr = new Object[arr];
            arr[i5] = Integer.valueOf(arrayList.size());
            arr[i3] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Loaded %d writes in %dms", arr), new Object[i5]);
        }
        query.close();
        return arrayList;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void mergeIntoServerCache(Path path, CompoundWrite compoundWrite2) {
        long currentTimeMillis;
        Object[] arr;
        int valueOf;
        int i;
        int nested;
        long child;
        String str;
        String obj9;
        boolean obj10;
        verifyInsideTransaction();
        obj10 = compoundWrite2.iterator();
        final int i3 = 0;
        i = valueOf;
        for (Map.Entry next2 : obj10) {
            valueOf += nested2;
            i += nested;
        }
        if (this.logger.logsDebug()) {
            arr = new Object[4];
            arr[i3] = Integer.valueOf(i);
            arr[1] = Integer.valueOf(valueOf);
            arr[2] = path.toString();
            arr[3] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", arr), new Object[i3]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void mergeIntoServerCache(Path path, Node node2) {
        verifyInsideTransaction();
        updateServerCache(path, node2, true);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void overwriteServerCache(Path path, Node node2) {
        verifyInsideTransaction();
        updateServerCache(path, node2, false);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void pruneCache(Path path, PruneForest pruneForest2) {
        int format;
        ImmutableTree immutableTree4;
        int size;
        ImmutableTree immutableTree2;
        SQLiteDatabase database;
        Object child;
        ImmutableTree immutableTree;
        boolean logsDebug;
        PruneForest pruneForest;
        Object relative;
        ImmutableTree immutableTree3;
        String str;
        boolean pruneUnkeptDescendants;
        ArrayList arrayList;
        final Object obj2 = this;
        final Path path3 = path;
        pruneForest = pruneForest2;
        if (!pruneForest2.prunesAnything()) {
        }
        verifyInsideTransaction();
        Cursor nestedQuery = obj2.loadNestedQuery(path3, /* result */);
        final int i4 = 0;
        immutableTree4 = new ImmutableTree(i4);
        immutableTree2 = new ImmutableTree(i4);
        immutableTree3 = immutableTree4;
        immutableTree = immutableTree2;
        int i5 = 1;
        pruneUnkeptDescendants = 0;
        while (nestedQuery.moveToNext()) {
            long long = nestedQuery.getLong(pruneUnkeptDescendants);
            child = new Path(nestedQuery.getString(i5));
            str = "We are pruning at ";
            if (!path3.contains(child)) {
            } else {
            }
            relative = Path.getRelative(path3, child);
            if (pruneForest.shouldPruneUnkeptDescendants(relative)) {
            } else {
            }
            if (pruneForest.shouldKeep(relative)) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(path3);
            stringBuilder2.append(" and have data at ");
            stringBuilder2.append(child);
            stringBuilder2.append(" that isn't marked for pruning or keeping. Ignoring.");
            obj2.logger.warn(stringBuilder2.toString());
            i5 = 1;
            pruneUnkeptDescendants = 0;
            immutableTree = immutableTree.set(relative, Long.valueOf(long));
            immutableTree3 = immutableTree4;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append(path3);
            stringBuilder3.append(" but we have data stored higher up at ");
            stringBuilder3.append(child);
            stringBuilder3.append(". Ignoring.");
            obj2.logger.warn(stringBuilder3.toString());
        }
        if (!immutableTree3.isEmpty()) {
            arrayList = new ArrayList();
            this.pruneTreeRecursive(path, Path.getEmptyPath(), immutableTree3, immutableTree, pruneForest2, arrayList);
            Collection values = immutableTree3.values();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("rowid IN (");
            stringBuilder.append(obj2.commaSeparatedList(values));
            stringBuilder.append(")");
            obj2.database.delete("serverCache", stringBuilder.toString(), i4);
            Iterator iterator = arrayList.iterator();
            for (Pair next : iterator) {
                obj2.saveNested(path3.child((Path)next.getFirst()), (Node)next.getSecond());
            }
            format = values.size();
            size = arrayList.size();
        } else {
            size = format;
        }
        if (obj2.logger.logsDebug()) {
            relative = new Object[3];
            relative[pruneUnkeptDescendants] = Integer.valueOf(format);
            relative[i5] = Integer.valueOf(size);
            relative[2] = Long.valueOf(currentTimeMillis -= currentTimeMillis2);
            obj2.logger.debug(String.format(Locale.US, "Pruned %d rows with %d nodes resaved in %dms", relative), new Object[pruneUnkeptDescendants]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void purgeCache() {
        verifyInsideTransaction();
        final int i = 0;
        this.database.delete("serverCache", i, i);
        this.database.delete("writes", i, i);
        this.database.delete("trackedQueries", i, i);
        this.database.delete("trackedKeys", i, i);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void removeAllUserWrites() {
        boolean logsDebug;
        String format;
        int delete;
        int valueOf;
        Object[] arr;
        int i;
        verifyInsideTransaction();
        final int i3 = 0;
        if (this.logger.logsDebug()) {
            arr = new Object[2];
            i = 0;
            arr[i] = Integer.valueOf(this.database.delete("writes", i3, i3));
            arr[1] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Deleted %d (all) write(s) in %dms", arr), new Object[i]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void removeUserWrite(long l) {
        boolean logsDebug;
        Locale locale;
        int valueOf;
        String str;
        String obj9;
        long obj10;
        verifyInsideTransaction();
        final int i = 1;
        String[] strArr = new String[i];
        final int i3 = 0;
        strArr[i3] = String.valueOf(l);
        String str2 = "writes";
        if (this.logger.logsDebug()) {
            str = new Object[3];
            str[i3] = Integer.valueOf(this.database.delete(str2, "id = ?", strArr));
            str[i] = Long.valueOf(l);
            str[2] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Deleted %d write(s) with writeId %d in %dms", str), new Object[i3]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void resetPreviouslyActiveTrackedQueries(long l) {
        long currentTimeMillis;
        Object[] arr;
        int str;
        int obj9;
        boolean obj10;
        verifyInsideTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.FALSE);
        contentValues.put("lastUse", Long.valueOf(l));
        obj9 = 0;
        String str3 = "trackedQueries";
        this.database.updateWithOnConflict(str3, contentValues, "active = 1", new String[obj9], 5);
        if (this.logger.logsDebug()) {
            arr = new Object[1];
            arr[obj9] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Reset active tracked queries in %dms", arr), new Object[obj9]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveTrackedQuery(TrackedQuery trackedQuery) {
        long currentTimeMillis;
        Object[] arr;
        int str;
        String str2;
        boolean obj7;
        verifyInsideTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(trackedQuery.id));
        contentValues.put("path", SqlPersistenceStorageEngine.pathToKey(trackedQuery.querySpec.getPath()));
        String str6 = "queryParams";
        contentValues.put(str6, trackedQuery.querySpec.getParams().toJSON());
        contentValues.put("lastUse", Long.valueOf(trackedQuery.lastUse));
        contentValues.put("complete", Boolean.valueOf(trackedQuery.complete));
        contentValues.put("active", Boolean.valueOf(trackedQuery.active));
        str2 = "trackedQueries";
        this.database.insertWithOnConflict(str2, 0, contentValues, 5);
        if (this.logger.logsDebug()) {
            Object[] arr2 = new Object[1];
            str2 = 0;
            arr2[str2] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Saved new tracked query in %dms", arr2), new Object[str2]);
        }
    }

    public void saveTrackedQueryKeys(long l, Set<ChildKey> set2) {
        boolean logsDebug;
        Locale locale;
        String[] strArr;
        boolean next;
        String contentValues;
        int i;
        int i2;
        String obj11;
        long obj12;
        Integer obj13;
        verifyInsideTransaction();
        final int i4 = 1;
        strArr = new String[i4];
        final int i6 = 0;
        strArr[i6] = String.valueOf(l);
        String str = "trackedKeys";
        this.database.delete(str, "id = ?", strArr);
        Iterator iterator = obj13.iterator();
        for (ChildKey next2 : iterator) {
            contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(l));
            contentValues.put("key", next2.asString());
            this.database.insertWithOnConflict(str, 0, contentValues, 5);
        }
        if (this.logger.logsDebug()) {
            next = new Object[3];
            next[i6] = Integer.valueOf(obj13.size());
            next[i4] = Long.valueOf(l);
            next[2] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Set %d tracked query keys for tracked query %d in %dms", next), new Object[i6]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveUserMerge(Path path, CompoundWrite compoundWrite2, long l3) {
        long currentTimeMillis;
        int obj10;
        Map obj11;
        boolean obj12;
        Locale obj13;
        verifyInsideTransaction();
        final int i = 1;
        obj11 = compoundWrite2.getValue(i);
        this.saveWrite(path, l3, obj6, "m");
        if (this.logger.logsDebug()) {
            currentTimeMillis = new Object[i];
            obj11 = 0;
            currentTimeMillis[obj11] = Long.valueOf(obj10 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Persisted user merge in %dms", currentTimeMillis), new Object[obj11]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveUserOverwrite(Path path, Node node2, long l3) {
        long currentTimeMillis;
        int obj10;
        Object obj11;
        boolean obj12;
        Locale obj13;
        verifyInsideTransaction();
        final int i = 1;
        obj11 = node2.getValue(i);
        this.saveWrite(path, l3, obj6, "o");
        if (this.logger.logsDebug()) {
            currentTimeMillis = new Object[i];
            obj11 = 0;
            currentTimeMillis[obj11] = Long.valueOf(obj10 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Persisted user overwrite in %dms", currentTimeMillis), new Object[obj11]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Node serverCache(Path path) {
        return loadNested(path);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public long serverCacheEstimatedSizeInBytes() {
        Object[] arr = new Object[3];
        int i4 = 0;
        arr[i4] = "value";
        arr[1] = "path";
        arr[2] = "serverCache";
        Cursor rawQuery = this.database.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", arr), 0);
        if (!rawQuery.moveToFirst()) {
        } else {
            rawQuery.close();
            return rawQuery.getLong(i4);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Couldn't read database result!");
        throw illegalStateException;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    public void updateTrackedQueryKeys(long l, Set<ChildKey> set2, Set<ChildKey> set3) {
        boolean logsDebug;
        Locale locale;
        Iterator iterator;
        String str2;
        boolean contentValues;
        int i3;
        String[] strArr;
        String str;
        int i2;
        SQLiteDatabase database;
        int i;
        String obj12;
        long obj13;
        Integer obj14;
        verifyInsideTransaction();
        iterator = obj15.iterator();
        i3 = 1;
        int i6 = 2;
        str = "trackedKeys";
        i2 = 0;
        for (ChildKey next3 : iterator) {
            strArr = new String[i6];
            strArr[i2] = String.valueOf(l);
            strArr[i3] = next3.asString();
            this.database.delete(str, "id = ? AND key = ?", strArr);
            i3 = 1;
            i6 = 2;
            str = "trackedKeys";
            i2 = 0;
        }
        Iterator iterator2 = set3.iterator();
        boolean next = iterator2.hasNext();
        for (ChildKey next2 : iterator2) {
            contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(l));
            contentValues.put("key", next2.asString());
            this.database.insertWithOnConflict(str, 0, contentValues, 5);
            next = iterator2.hasNext();
        }
        if (this.logger.logsDebug()) {
            contentValues = new Object[4];
            contentValues[i2] = Integer.valueOf(set3.size());
            contentValues[i3] = Integer.valueOf(obj15.size());
            contentValues[i6] = Long.valueOf(l);
            contentValues[3] = Long.valueOf(currentTimeMillis2 -= currentTimeMillis);
            this.logger.debug(String.format(Locale.US, "Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", contentValues), new Object[i2]);
        }
    }
}
