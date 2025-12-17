package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.Filter.Operator;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.OrderBy.Direction;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.firebase.firestore.index.IndexByteEncoder;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldIndex.Segment;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.TargetIndexMatcher;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.a;
import f.c.e.a.a.a;
import f.c.e.c.a;
import f.c.e.c.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
final class SQLiteIndexManager implements com.google.firebase.firestore.local.IndexManager {

    private static final String TAG = "SQLiteIndexManager";
    private final com.google.firebase.firestore.local.MemoryIndexManager.MemoryCollectionParentIndex collectionParentsCache;
    private final com.google.firebase.firestore.local.SQLitePersistence db;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    static {
    }

    SQLiteIndexManager(com.google.firebase.firestore.local.SQLitePersistence sQLitePersistence, com.google.firebase.firestore.local.LocalSerializer localSerializer2) {
        super();
        MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex = new MemoryIndexManager.MemoryCollectionParentIndex();
        this.collectionParentsCache = memoryCollectionParentIndex;
        this.db = sQLitePersistence;
        this.serializer = localSerializer2;
    }

    static Integer a(Cursor cursor) {
        int int;
        int = 0;
        if (cursor.isNull(int)) {
        } else {
            int = cursor.getInt(int);
        }
        return Integer.valueOf(int);
    }

    private void addSingleEntry(DocumentKey documentKey, int i2, Object object3, Object object4) {
        Object[] arr = new Object[4];
        this.db.execute("INSERT INTO index_entries (index_id, array_value, directional_value, document_name) VALUES(?, ?, ?, ?)", Integer.valueOf(i2), object3, object4, documentKey.toString());
    }

    private void b(String string, Document document2, DocumentKey documentKey3, Cursor cursor4) {
        String str;
        Object iterator;
        int array;
        boolean next;
        int obj11;
        boolean obj12;
        final int i = 0;
        final int i3 = 1;
        final int i4 = 2;
        obj11 = this.serializer.decodeFieldIndex(string, cursor4.getInt(i), a.i(cursor4.getBlob(i3)), cursor4.getInt(i4), cursor4.getInt(3));
        ArrayList obj14 = new ArrayList();
        Iterator iterator2 = obj11.getArraySegments().iterator();
        try {
            for (FieldIndex.Segment next3 : iterator2) {
                x field = document2.getField(next3.getFieldPath());
                obj14.addAll(field.n().a());
            }
            field = document2.getField((FieldIndex.Segment)iterator2.next().getFieldPath());
            if (Values.isArray(field) == 0) {
            } else {
            }
            obj14.addAll(field.n().a());
            ArrayList arrayList = new ArrayList();
            iterator = obj11.getDirectionalSegments().iterator();
            for (FieldIndex.Segment next4 : iterator) {
                array = document2.getField(next4.getFieldPath());
                arrayList.add(array);
            }
            array = document2.getField((FieldIndex.Segment)iterator.next().getFieldPath());
            if (array == null) {
            } else {
            }
            arrayList.add(array);
            if (Logger.isDebugEnabled()) {
            }
            next = new Object[i4];
            next[i] = documentKey3;
            next[i3] = obj11;
            Logger.debug(SQLiteIndexManager.TAG, "Adding index values for document '%s' to index '%s'", next);
            obj11 = i;
            while (obj11 < Math.max(obj14.size(), i3)) {
                if (obj11 < obj14.size()) {
                } else {
                }
                obj12 = 0;
                addSingleEntry(documentKey3, cursor4.getInt(i), encode(obj12), encode(arrayList));
                obj11++;
                obj12 = obj14.get(obj11);
            }
            if (obj11 < obj14.size()) {
            } else {
            }
            obj12 = obj14.get(obj11);
            obj12 = 0;
            addSingleEntry(documentKey3, int, encode(obj12), encode(arrayList));
            obj11++;
            document2 = new StringBuilder();
            documentKey3 = "Invalid index: ";
            document2.append(documentKey3);
            document2.append(string);
            string = document2.toString();
            document2 = new Object[obj0];
            string = Assert.fail(string, document2);
            throw string;
        }
    }

    static void d(ArrayList arrayList, Cursor cursor2) {
        arrayList.add(EncodedPath.decodeResourcePath(cursor2.getString(0)));
    }

    static void e(Set set, Cursor cursor2) {
        set.add(DocumentKey.fromPath(ResourcePath.fromString(cursor2.getString(0))));
    }

    private Object encode(x x) {
        Object obj1;
        if (x != null) {
            obj1 = encode(Collections.singletonList(x));
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    private Object encode(List<x> list) {
        Object next;
        FirestoreIndexValueWriter iNSTANCE;
        IndexByteEncoder indexByteEncoder = new IndexByteEncoder();
        Iterator obj4 = list.iterator();
        for (x next : obj4) {
            FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, indexByteEncoder);
        }
        return indexByteEncoder.getEncodedBytes();
    }

    private Object[] encodeBound(FieldIndex fieldIndex, Target target2, Bound bound3) {
        ArrayList expandIndexValues;
        IndexByteEncoder indexByteEncoder;
        Object next;
        Iterator iterator;
        boolean next2;
        boolean inFilter;
        if (bound3 == null) {
            return null;
        }
        expandIndexValues = new ArrayList();
        indexByteEncoder = new IndexByteEncoder();
        expandIndexValues.add(indexByteEncoder);
        Iterator obj7 = fieldIndex.getDirectionalSegments().iterator();
        for (FieldIndex.Segment indexByteEncoder : obj7) {
            next = bound3.getPosition().iterator().next();
            iterator = expandIndexValues.iterator();
            while (iterator.hasNext()) {
                if (isInFilter(target2, indexByteEncoder.getFieldPath()) && Values.isArray((x)next)) {
                } else {
                }
                FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, (IndexByteEncoder)iterator.next());
                if (Values.isArray(next)) {
                } else {
                }
                expandIndexValues = expandIndexValues(expandIndexValues, next);
            }
            if (isInFilter(target2, indexByteEncoder.getFieldPath()) && Values.isArray(next)) {
            } else {
            }
            FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, (IndexByteEncoder)iterator.next());
            if (Values.isArray(next)) {
            } else {
            }
            expandIndexValues = expandIndexValues(expandIndexValues, next);
        }
        return getEncodedBytes(expandIndexValues);
    }

    private byte[] encodeFieldIndex(FieldIndex fieldIndex) {
        return this.serializer.encodeFieldIndex(fieldIndex).toByteArray();
    }

    private List<IndexByteEncoder> expandIndexValues(List<IndexByteEncoder> list, x x2) {
        Object next;
        Iterator iterator;
        boolean iNSTANCE;
        IndexByteEncoder indexByteEncoder;
        ArrayList arrayList = new ArrayList(list);
        ArrayList obj6 = new ArrayList();
        Iterator obj7 = x2.n().a().iterator();
        for (x next : obj7) {
            iterator = arrayList.iterator();
            for (IndexByteEncoder next3 : iterator) {
                indexByteEncoder = new IndexByteEncoder();
                indexByteEncoder.seed(next3.getEncodedBytes());
                FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, indexByteEncoder);
                obj6.add(indexByteEncoder);
            }
            indexByteEncoder = new IndexByteEncoder();
            indexByteEncoder.seed((IndexByteEncoder)iterator.next().getEncodedBytes());
            FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, indexByteEncoder);
            obj6.add(indexByteEncoder);
        }
        return obj6;
    }

    private void f(List list, Cursor cursor2) {
        list.add(this.serializer.decodeFieldIndex(cursor2.getString(1), cursor2.getInt(0), a.i(cursor2.getBlob(2)), cursor2.getInt(3), cursor2.getInt(4)));
    }

    private int fillBounds(Object[] objectArr, int i2, int i3, Object object4, Object[] object5Arr5, Object[] object6Arr6) {
        int i4;
        int i;
        int length2;
        int length;
        Object[] arr;
        int obj6;
        i4 = 0;
        if (object6Arr6 != null) {
            if (object6Arr6.length == object5Arr5.length) {
                i = 1;
            } else {
                i = i4;
            }
        } else {
        }
        Assert.hardAssert(i, "Length of upper and lower bound should match", new Object[i4]);
        while (i4 < object5Arr5.length) {
            i = obj6 + 1;
            objectArr[obj6] = Integer.valueOf(i3);
            if (object4 != null) {
            }
            obj6 = i + 1;
            objectArr[i] = object5Arr5[i4];
            if (object6Arr6 != null) {
            }
            i4++;
            objectArr[obj6] = object6Arr6[i4];
            obj6 = i;
            objectArr[i] = object4;
            i = obj6;
        }
        return obj6;
    }

    private com.google.firebase.firestore.local.SQLitePersistence.Query generateQuery(Target target, int i2, List<x> list3, Object[] object4Arr4, String string5, Object[] object6Arr6, String string7) {
        String repeatSequence;
        Object next;
        int i;
        int cmp;
        boolean empty;
        String str;
        Object stringBuilder;
        int fillBounds;
        int i3;
        int encode;
        Object[] objArr;
        Object[] objArr2;
        i = 1;
        i4 *= length;
        i3 = 0;
        if (object6Arr6 != null) {
        } else {
            i = i3;
        }
        final int i9 = i5 * i8;
        final Object[] arr = new Object[i9];
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("SELECT document_name, directional_value FROM index_entries WHERE index_id = ? ");
        if (!list3.isEmpty()) {
            stringBuilder2.append("AND array_value = ? ");
        }
        str = "AND directional_value ";
        stringBuilder2.append(str);
        stringBuilder2.append(string5);
        String str7 = " ? ";
        stringBuilder2.append(str7);
        if (object6Arr6 != null) {
            stringBuilder2.append(str);
            stringBuilder2.append(string7);
            stringBuilder2.append(str7);
        }
        if (Long.compare(limit, encode) != 0) {
            String canonicalString = target.getFirstOrderBy().getDirection().canonicalString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(Util.repeatSequence(stringBuilder2, i5, " UNION "));
            stringBuilder3.append("ORDER BY directional_value ");
            stringBuilder3.append(canonicalString);
            stringBuilder3.append(", document_name ");
            stringBuilder3.append(canonicalString);
            String str4 = " ";
            stringBuilder3.append(str4);
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3.toString());
            stringBuilder.append("LIMIT ");
            stringBuilder.append(target.getLimit());
            stringBuilder.append(str4);
            repeatSequence = stringBuilder.toString();
        }
        final Iterator iterator = list3.iterator();
        fillBounds = i3;
        while (fillBounds < i9) {
            if (iterator.hasNext()) {
            } else {
            }
            next = 0;
            fillBounds = this.fillBounds(arr, fillBounds, i2, encode(next), object4Arr4, object6Arr6);
            next = iterator.next();
        }
        return obj.db.query(repeatSequence).binding(arr);
    }

    private Object[] getEncodedBytes(List<IndexByteEncoder> list) {
        int i;
        byte[] encodedBytes;
        Object[] arr = new Object[list.size()];
        i = 0;
        while (i < list.size()) {
            arr[i] = (IndexByteEncoder)list.get(i).getEncodedBytes();
            i++;
        }
        return arr;
    }

    private FieldIndex getMatchingIndex(Target target) {
        String obj6;
        TargetIndexMatcher targetIndexMatcher = new TargetIndexMatcher(target);
        if (target.getCollectionGroup() != null) {
            obj6 = target.getCollectionGroup();
        } else {
            obj6 = target.getPath().getLastSegment();
        }
        ArrayList arrayList = new ArrayList();
        Object[] arr = new Object[1];
        c0 c0Var = new c0(this, obj6, targetIndexMatcher, arrayList);
        this.db.query("SELECT index_id, index_proto, update_time_seconds, update_time_nanos FROM index_configuration WHERE collection_group = ? AND active = 1").binding(obj6).forEach(c0Var);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (FieldIndex)Collections.max(arrayList, i0.a);
    }

    private void h(String string, TargetIndexMatcher targetIndexMatcher2, List list3, Cursor cursor4) {
        final FieldIndex obj8 = this.serializer.decodeFieldIndex(string, cursor4.getInt(0), a.i(cursor4.getBlob(1)), cursor4.getInt(2), cursor4.getInt(3));
        if (targetIndexMatcher2.servedByIndex(obj8)) {
            try {
                list3.add(obj8);
                targetIndexMatcher2 = new StringBuilder();
                list3 = "Failed to decode index: ";
                targetIndexMatcher2.append(list3);
                targetIndexMatcher2.append(string);
                string = targetIndexMatcher2.toString();
                targetIndexMatcher2 = new Object[obj0];
                string = Assert.fail(string, targetIndexMatcher2);
                throw string;
            }
        }
    }

    private boolean isInFilter(Target target, FieldPath fieldPath2) {
        Object next;
        int i;
        boolean equals;
        Iterator obj4;
        Object obj5;
        obj4 = target.getFilters().iterator();
        i = 0;
        while (obj4.hasNext()) {
            next = obj4.next();
            if ((Filter)next.getField().equals(fieldPath2)) {
                break;
            } else {
            }
            i = 0;
        }
        return i;
    }

    static int j(FieldIndex fieldIndex, FieldIndex fieldIndex2) {
        return Integer.compare(fieldIndex.segmentCount(), fieldIndex2.segmentCount());
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addFieldIndex(FieldIndex fieldIndex) {
        Object[] arr = new Object[6];
        int i4 = 1;
        final int i8 = 0;
        arr[i8] = Integer.valueOf(intValue += i4);
        arr[i4] = fieldIndex.getCollectionGroup();
        arr[2] = encodeFieldIndex(fieldIndex);
        arr[3] = Boolean.TRUE;
        arr[4] = Long.valueOf(fieldIndex.getVersion().getTimestamp().getSeconds());
        arr[5] = Integer.valueOf(fieldIndex.getVersion().getTimestamp().getNanoseconds());
        this.db.execute("INSERT INTO index_configuration (index_id, collection_group, index_proto, active, update_time_seconds, update_time_nanos) VALUES(?, ?, ?, ?, ?, ?)", arr);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addIndexEntries(Document document) {
        final DocumentKey key = document.getKey();
        final String collectionGroup = key.getCollectionGroup();
        Object[] arr = new Object[1];
        g0 g0Var = new g0(this, collectionGroup, document, key);
        this.db.query("SELECT index_id, index_proto, update_time_seconds, update_time_nanos FROM index_configuration WHERE collection_group = ? AND active = 1").binding(collectionGroup).forEach(g0Var);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addToCollectionParentIndex(ResourcePath resourcePath) {
        int i;
        boolean lastSegment;
        int arr;
        Object[] arr2;
        Object obj7;
        arr = 2;
        final int i3 = 0;
        final int i4 = 1;
        i = length %= arr == i4 ? i4 : i3;
        Assert.hardAssert(i, "Expected a collection path.", new Object[i3]);
        if (this.collectionParentsCache.add(resourcePath)) {
            arr = new Object[arr];
            arr[i3] = resourcePath.getLastSegment();
            arr[i4] = EncodedPath.encode((ResourcePath)resourcePath.popLast());
            this.db.execute("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", arr);
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void c(String string, Document document2, DocumentKey documentKey3, Cursor cursor4) {
        b(string, document2, documentKey3, cursor4);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void g(List list, Cursor cursor2) {
        f(list, cursor2);
    }

    public List<ResourcePath> getCollectionParents(String string) {
        ArrayList arrayList = new ArrayList();
        Object[] arr = new Object[1];
        f0 f0Var = new f0(arrayList);
        this.db.query("SELECT parent FROM collection_parents WHERE collection_id = ?").binding(string).forEach(f0Var);
        return arrayList;
    }

    public Set<DocumentKey> getDocumentsMatchingTarget(Target target) {
        String inclusive;
        String str;
        boolean debugEnabled;
        Object[] arr;
        String str2;
        FieldIndex matchingIndex = getMatchingIndex(target);
        if (matchingIndex == null) {
            return 0;
        }
        final List arrayValues = target.getArrayValues(matchingIndex);
        Bound lowerBound = target.getLowerBound(matchingIndex);
        Bound upperBound = target.getUpperBound(matchingIndex);
        final int i5 = 1;
        final int i6 = 0;
        if (Logger.isDebugEnabled()) {
            arr = new Object[5];
            arr[i6] = matchingIndex;
            arr[i5] = target;
            arr[2] = arrayValues;
            arr[3] = lowerBound;
            arr[4] = upperBound;
            Logger.debug(SQLiteIndexManager.TAG, "Using index '%s' to execute '%s' (Arrays: %s, Lower bound: %s, Upper bound: %s)", arr);
        }
        inclusive = lowerBound.isInclusive() ? ">=" : ">";
        if (upperBound != null && upperBound.isInclusive()) {
            str = upperBound.isInclusive() ? "<=" : "<";
        } else {
        }
        HashSet hashSet = new HashSet();
        h0 h0Var = new h0(hashSet);
        this.generateQuery(target, matchingIndex.getIndexId(), arrayValues, encodeBound(matchingIndex, target, lowerBound), inclusive, encodeBound(matchingIndex, target, upperBound), str).forEach(h0Var);
        Object[] arr2 = new Object[i5];
        arr2[i6] = Integer.valueOf(hashSet.size());
        Logger.debug(SQLiteIndexManager.TAG, "Index scan returned %s documents", arr2);
        return hashSet;
    }

    public List<FieldIndex> getFieldIndexes() {
        ArrayList arrayList = new ArrayList();
        e0 e0Var = new e0(this, arrayList);
        this.db.query("SELECT index_id, collection_group, index_proto, update_time_seconds, update_time_nanos FROM index_configuration WHERE active = 1").forEach(e0Var);
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void i(String string, TargetIndexMatcher targetIndexMatcher2, List list3, Cursor cursor4) {
        h(string, targetIndexMatcher2, list3, cursor4);
    }
}
