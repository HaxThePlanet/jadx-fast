package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.Filter.Operator;
import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.core.IndexRange.Builder;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;
import f.c.e.c.x.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class IndexedQueryEngine implements com.google.firebase.firestore.local.QueryEngine {

    private static final double HIGH_SELECTIVITY = 1d;
    private static final double LOW_SELECTIVITY = 0.5d;
    private static final List<x.c> lowCardinalityTypes;
    private final com.google.firebase.firestore.local.SQLiteCollectionIndex collectionIndex;
    private com.google.firebase.firestore.local.LocalDocumentsView localDocuments;
    static {
        x.c[] arr = new x.c[3];
        IndexedQueryEngine.lowCardinalityTypes = Arrays.asList(x.c.BOOLEAN_VALUE, x.c.ARRAY_VALUE, x.c.MAP_VALUE);
    }

    public IndexedQueryEngine(com.google.firebase.firestore.local.SQLiteCollectionIndex sQLiteCollectionIndex) {
        super();
        this.collectionIndex = sQLiteCollectionIndex;
    }

    private static IndexRange convertFilterToIndexRange(Filter filter) {
        boolean value;
        int i;
        Object obj3;
        IndexRange.Builder fieldPath = IndexRange.builder().setFieldPath(filter.getField());
        if (filter instanceof FieldFilter) {
            value = (FieldFilter)filter.getValue();
            obj3 = IndexedQueryEngine.1.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[filter.getOperator().ordinal()];
            if (obj3 != 1) {
                if (obj3 != 2 && obj3 != 3) {
                    if (obj3 != 3) {
                        if (obj3 != 4) {
                            if (obj3 != 5) {
                            } else {
                            }
                            throw Assert.fail("Unexpected operator in query filter", new Object[0]);
                        }
                        fieldPath.setStart(value);
                    } else {
                        fieldPath.setEnd(value);
                    }
                } else {
                }
            } else {
                fieldPath.setStart(value).setEnd(value);
            }
        }
        return fieldPath.build();
    }

    private static double estimateFilterSelectivity(Filter filter) {
        x nanValue;
        boolean nullValue;
        long l2;
        long l;
        List lowCardinalityTypes;
        Object obj7;
        Assert.hardAssert(filter instanceof FieldFilter, "Filter type expected to be FieldFilter", new Object[0]);
        nanValue = (FieldFilter)filter.getValue();
        if (!Values.isNullValue(nanValue)) {
            if (Values.isNanValue(nanValue)) {
            } else {
                l = 4602678819172646912L;
                nanValue = filter.getOperator().equals(Filter.Operator.EQUAL) ? l2 : l;
                if (IndexedQueryEngine.lowCardinalityTypes.contains(filter.getValue().w())) {
                    l2 = l;
                }
                l2 *= nanValue;
            }
        }
        return l2;
    }

    static IndexRange extractBestIndexRange(Query query) {
        boolean empty;
        int i;
        long l;
        double estimateFilterSelectivity;
        int cmp;
        int obj8;
        int i2 = 0;
        if (!query.getFilters().isEmpty()) {
            obj8 = query.getFilters().iterator();
            l = -4616189618054758400L;
            while (obj8.hasNext()) {
                empty = obj8.next();
                estimateFilterSelectivity = IndexedQueryEngine.estimateFilterSelectivity((Filter)empty);
                if (Double.compare(estimateFilterSelectivity, l) > 0) {
                }
                i = empty;
                l = estimateFilterSelectivity;
            }
            obj8 = i != 0 ? 1 : i2;
            Assert.hardAssert(obj8, "Filter should be defined", new Object[i2]);
            return IndexedQueryEngine.convertFilterToIndexRange(i);
        }
        if (!(OrderBy)query.getOrderBy().get(i2).getField().equals(FieldPath.KEY_PATH)) {
            return IndexRange.builder().setFieldPath((OrderBy)query.getOrderBy().get(i2).getField()).build();
        }
        return null;
    }

    private ImmutableSortedMap<DocumentKey, Document> performCollectionQuery(Query query) {
        Object bestIndexRange;
        int nONE;
        Object[] arr;
        ImmutableSortedMap obj5;
        nONE = 0;
        Assert.hardAssert(documentQuery ^= 1, "matchesCollectionQuery() called with document query.", new Object[nONE]);
        bestIndexRange = IndexedQueryEngine.extractBestIndexRange(query);
        if (bestIndexRange != null) {
            obj5 = performQueryUsingIndex(query, bestIndexRange);
        } else {
            Assert.hardAssert(query.getFilters().isEmpty(), "If there are any filters, we should be able to use an index.", new Object[nONE]);
            obj5 = this.localDocuments.getDocumentsMatchingQuery(query, SnapshotVersion.NONE);
        }
        return obj5;
    }

    private ImmutableSortedMap<DocumentKey, Document> performQueryUsingIndex(Query query, IndexRange indexRange2) {
        ImmutableSortedMap emptyDocumentMap;
        com.google.firebase.firestore.local.SQLiteCollectionIndex collectionIndex;
        com.google.firebase.firestore.model.ResourcePath documentKey;
        emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        final com.google.firebase.firestore.local.IndexCursor obj5 = this.collectionIndex.getCursor(query.getPath(), indexRange2);
        while (obj5.next()) {
            collectionIndex = this.localDocuments.getDocument(obj5.getDocumentKey());
            if (query.matches(collectionIndex) != null) {
            }
            emptyDocumentMap = emptyDocumentMap.insert(obj5.getDocumentKey(), collectionIndex);
        }
        obj5.close();
        return emptyDocumentMap;
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2, ImmutableSortedSet<DocumentKey> immutableSortedSet3) {
        ImmutableSortedMap obj2;
        int obj3;
        Object[] obj4;
        obj4 = 0;
        obj3 = this.localDocuments != null ? 1 : obj4;
        Assert.hardAssert(obj3, "setLocalDocumentsView() not called", new Object[obj4]);
        if (query.isDocumentQuery()) {
            obj2 = this.localDocuments.getDocumentsMatchingQuery(query, SnapshotVersion.NONE);
        } else {
            obj2 = performCollectionQuery(query);
        }
        return obj2;
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void handleDocumentChange(MutableDocument mutableDocument, MutableDocument mutableDocument2) {
        RuntimeException obj1 = new RuntimeException("Not yet implemented.");
        throw obj1;
    }

    @Override // com.google.firebase.firestore.local.QueryEngine
    public void setLocalDocumentsView(com.google.firebase.firestore.local.LocalDocumentsView localDocumentsView) {
        this.localDocuments = localDocumentsView;
    }
}
