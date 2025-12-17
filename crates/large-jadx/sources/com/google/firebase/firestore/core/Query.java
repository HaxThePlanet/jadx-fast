package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Query {

    private static final com.google.firebase.firestore.core.OrderBy KEY_ORDERING_ASC;
    private static final com.google.firebase.firestore.core.OrderBy KEY_ORDERING_DESC;
    private final String collectionGroup;
    private final com.google.firebase.firestore.core.Bound endAt;
    private final List<com.google.firebase.firestore.core.OrderBy> explicitSortOrder;
    private final List<com.google.firebase.firestore.core.Filter> filters;
    private final long limit;
    private final com.google.firebase.firestore.core.Query.LimitType limitType;
    private List<com.google.firebase.firestore.core.OrderBy> memoizedOrderBy;
    private com.google.firebase.firestore.core.Target memoizedTarget;
    private final ResourcePath path;
    private final com.google.firebase.firestore.core.Bound startAt;

    public static enum LimitType {

        LIMIT_TO_FIRST,
        LIMIT_TO_LAST;
    }

    private static class QueryComparator implements Comparator<Document> {

        private final List<com.google.firebase.firestore.core.OrderBy> sortOrder;
        QueryComparator(List<com.google.firebase.firestore.core.OrderBy> list) {
            boolean equals;
            FieldPath kEY_PATH;
            super();
            Iterator iterator = list.iterator();
            while (/* condition */) {
                while (iterator.hasNext()) {
                    if (equals == 0) {
                        break loop_2;
                    } else {
                    }
                    equals = 1;
                    if (!(OrderBy)iterator.next().getField().equals(FieldPath.KEY_PATH)) {
                        break loop_2;
                    } else {
                    }
                }
                if (equals == 0) {
                } else {
                }
                equals = 1;
                if ((OrderBy)iterator.next().getField().equals(FieldPath.KEY_PATH)) {
                } else {
                }
                equals = i;
            }
            if (equals == 0) {
            } else {
                this.sortOrder = list;
            }
            IllegalArgumentException obj5 = new IllegalArgumentException("QueryComparator needs to have a key ordering");
            throw obj5;
        }

        @Override // java.util.Comparator
        public int compare(Document document, Document document2) {
            int compare;
            Iterator iterator = this.sortOrder.iterator();
            for (OrderBy next2 : iterator) {
                compare = next2.compare(document, document2);
            }
            return 0;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return compare((Document)object, (Document)object2);
        }
    }
    static {
        final FieldPath kEY_PATH = FieldPath.KEY_PATH;
        Query.KEY_ORDERING_ASC = OrderBy.getInstance(OrderBy.Direction.ASCENDING, kEY_PATH);
        Query.KEY_ORDERING_DESC = OrderBy.getInstance(OrderBy.Direction.DESCENDING, kEY_PATH);
    }

    public Query(ResourcePath resourcePath, String string2) {
        super(resourcePath, string2, Collections.emptyList(), Collections.emptyList(), -1, obj6, Query.LimitType.LIMIT_TO_FIRST, 0, 0);
    }

    public Query(ResourcePath resourcePath, String string2, List<com.google.firebase.firestore.core.Filter> list3, List<com.google.firebase.firestore.core.OrderBy> list4, long l5, com.google.firebase.firestore.core.Query.LimitType query$LimitType6, com.google.firebase.firestore.core.Bound bound7, com.google.firebase.firestore.core.Bound bound8) {
        super();
        this.path = resourcePath;
        this.collectionGroup = string2;
        this.explicitSortOrder = list4;
        this.filters = list3;
        this.limit = l5;
        this.limitType = bound7;
        this.startAt = bound8;
        this.endAt = obj9;
    }

    public static com.google.firebase.firestore.core.Query atPath(ResourcePath resourcePath) {
        Query query = new Query(resourcePath, 0);
        return query;
    }

    private boolean matchesBounds(Document document) {
        com.google.firebase.firestore.core.Bound sortsBeforeDocument;
        List orderBy;
        Document obj4;
        sortsBeforeDocument = this.startAt;
        final int i = 0;
        if (sortsBeforeDocument != null && !sortsBeforeDocument.sortsBeforeDocument(getOrderBy(), document)) {
            if (!sortsBeforeDocument.sortsBeforeDocument(getOrderBy(), document)) {
                return i;
            }
        }
        com.google.firebase.firestore.core.Bound endAt = this.endAt;
        if (endAt != null && !endAt.sortsAfterDocument(getOrderBy(), document)) {
            if (!endAt.sortsAfterDocument(getOrderBy(), document)) {
                return i;
            }
        }
        return 1;
    }

    private boolean matchesFilters(Document document) {
        boolean matches;
        Iterator iterator = this.filters.iterator();
        for (Filter next2 : iterator) {
        }
        return 1;
    }

    private boolean matchesOrderBy(Document document) {
        Object field;
        boolean equals;
        FieldPath kEY_PATH;
        Iterator iterator = this.explicitSortOrder.iterator();
        for (OrderBy field : iterator) {
        }
        return 1;
    }

    private boolean matchesPathAndCollectionGroup(Document document) {
        ResourcePath path;
        int i;
        boolean obj5;
        path = document.getKey().getPath();
        i = 0;
        final int i2 = 1;
        if (this.collectionGroup != null && document.getKey().hasCollectionId(this.collectionGroup) && this.path.isPrefixOf(path)) {
            if (document.getKey().hasCollectionId(this.collectionGroup)) {
                if (this.path.isPrefixOf(path)) {
                    i = i2;
                }
            }
            return i;
        }
        if (DocumentKey.isDocumentKey(this.path)) {
            return this.path.equals(path);
        }
        if (this.path.isPrefixOf(path) && this.path.length() == length -= i2) {
            if (this.path.length() == length -= i2) {
                i = i2;
            }
        }
        return i;
    }

    public com.google.firebase.firestore.core.Query asCollectionQueryAtPath(ResourcePath resourcePath) {
        super(resourcePath, 0, this.filters, this.explicitSortOrder, this.limit, obj6, this.limitType, this.startAt, this.endAt);
        return query2;
    }

    public Comparator<Document> comparator() {
        Query.QueryComparator queryComparator = new Query.QueryComparator(getOrderBy());
        return queryComparator;
    }

    public com.google.firebase.firestore.core.Query endAt(com.google.firebase.firestore.core.Bound bound) {
        super(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, obj6, this.limitType, this.startAt, bound);
        return query2;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.core.Query> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (Query.class != object.getClass()) {
            } else {
                if (this.limitType != object.limitType) {
                    return i;
                }
            }
            return toTarget().equals((Query)object.toTarget());
        }
        return i;
    }

    public com.google.firebase.firestore.core.Query filter(com.google.firebase.firestore.core.Filter filter) {
        int equals;
        int i;
        boolean inequality;
        int i2;
        boolean empty;
        FieldPath inequalityField;
        i = 1;
        int i4 = 0;
        Assert.hardAssert(documentQuery ^= i, "No filter is allowed for document query", new Object[i4]);
        equals = 0;
        if (filter instanceof FieldFilter && (FieldFilter)filter.isInequality()) {
            if ((FieldFilter)filter.isInequality()) {
                equals = filter.getField();
            }
        }
        inequalityField = inequalityField();
        if (inequalityField != null && equals != 0) {
            if (equals != 0) {
                if (inequalityField.equals(equals)) {
                    i2 = i;
                } else {
                    i2 = i4;
                }
            } else {
            }
        } else {
        }
        Assert.hardAssert(i2, "Query must only have one inequality field", new Object[i4]);
        if (!this.explicitSortOrder.isEmpty() && equals != 0) {
            if (equals != 0) {
                if (obj.field.equals(equals)) {
                } else {
                    i = i4;
                }
            }
        }
        Assert.hardAssert(i, "First orderBy must match inequality field", new Object[i4]);
        ArrayList arrayList = new ArrayList(this.filters);
        arrayList.add(filter);
        super(this.path, this.collectionGroup, arrayList, this.explicitSortOrder, this.limit, obj9, this.limitType, this.startAt, this.endAt);
        return obj14;
    }

    public com.google.firebase.firestore.core.Filter.Operator findFilterOperator(List<com.google.firebase.firestore.core.Filter.Operator> list) {
        Object operator;
        boolean contains;
        Iterator iterator = this.filters.iterator();
        for (Filter operator : iterator) {
            operator = (FieldFilter)operator.getOperator();
        }
        return null;
    }

    public String getCanonicalId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toTarget().getCanonicalId());
        stringBuilder.append("|lt:");
        stringBuilder.append(this.limitType);
        return stringBuilder.toString();
    }

    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    public com.google.firebase.firestore.core.Bound getEndAt() {
        return this.endAt;
    }

    public List<com.google.firebase.firestore.core.OrderBy> getExplicitOrderBy() {
        return this.explicitSortOrder;
    }

    public List<com.google.firebase.firestore.core.Filter> getFilters() {
        return this.filters;
    }

    public FieldPath getFirstOrderByField() {
        if (this.explicitSortOrder.isEmpty()) {
            return null;
        }
        return (OrderBy)this.explicitSortOrder.get(0).getField();
    }

    public long getLimitToFirst() {
        Assert.hardAssert(hasLimitToFirst(), "Called getLimitToFirst when no limit was set", new Object[0]);
        return this.limit;
    }

    public long getLimitToLast() {
        Assert.hardAssert(hasLimitToLast(), "Called getLimitToLast when no limit was set", new Object[0]);
        return this.limit;
    }

    public com.google.firebase.firestore.core.Query.LimitType getLimitType() {
        int i;
        boolean limitToFirst;
        int i2 = 0;
        if (!hasLimitToLast()) {
            if (hasLimitToFirst()) {
                i = 1;
            } else {
                i = i2;
            }
        } else {
        }
        Assert.hardAssert(i, "Called getLimitType when no limit was set", new Object[i2]);
        return this.limitType;
    }

    public List<com.google.firebase.firestore.core.OrderBy> getOrderBy() {
        Object memoizedOrderBy;
        com.google.firebase.firestore.core.OrderBy.Direction aSCENDING3;
        com.google.firebase.firestore.core.OrderBy kEY_ORDERING_DESC;
        int aSCENDING;
        int i;
        boolean aSCENDING2;
        FieldPath kEY_PATH;
        if (this.memoizedOrderBy == null) {
            FieldPath inequalityField = inequalityField();
            i = 1;
            if (inequalityField != null && getFirstOrderByField() == null) {
                if (getFirstOrderByField() == null) {
                    if (inequalityField.isKeyField()) {
                        this.memoizedOrderBy = Collections.singletonList(Query.KEY_ORDERING_ASC);
                    } else {
                        kEY_ORDERING_DESC = new OrderBy[2];
                        kEY_ORDERING_DESC[i] = Query.KEY_ORDERING_ASC;
                        this.memoizedOrderBy = Arrays.asList(kEY_ORDERING_DESC);
                    }
                } else {
                    memoizedOrderBy = new ArrayList();
                    kEY_ORDERING_DESC = this.explicitSortOrder.iterator();
                    while (kEY_ORDERING_DESC.hasNext()) {
                        Object next = kEY_ORDERING_DESC.next();
                        memoizedOrderBy.add((OrderBy)next);
                        if (next.getField().equals(FieldPath.KEY_PATH)) {
                        }
                        aSCENDING = i;
                    }
                    if (aSCENDING == 0) {
                        if (this.explicitSortOrder.size() > 0) {
                            List explicitSortOrder3 = this.explicitSortOrder;
                            aSCENDING3 = (OrderBy)explicitSortOrder3.get(size2 -= i).getDirection();
                        } else {
                            aSCENDING3 = OrderBy.Direction.ASCENDING;
                        }
                        kEY_ORDERING_DESC = aSCENDING3.equals(OrderBy.Direction.ASCENDING) ? Query.KEY_ORDERING_ASC : Query.KEY_ORDERING_DESC;
                        memoizedOrderBy.add(kEY_ORDERING_DESC);
                    }
                    this.memoizedOrderBy = memoizedOrderBy;
                }
            } else {
            }
        }
        return this.memoizedOrderBy;
    }

    public ResourcePath getPath() {
        return this.path;
    }

    public com.google.firebase.firestore.core.Bound getStartAt() {
        return this.startAt;
    }

    public boolean hasLimitToFirst() {
        com.google.firebase.firestore.core.Query.LimitType limitType;
        int i;
        int i2;
        if (this.limitType == Query.LimitType.LIMIT_TO_FIRST && Long.compare(limit, i2) != 0) {
            i = Long.compare(limit, i2) != 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean hasLimitToLast() {
        com.google.firebase.firestore.core.Query.LimitType limitType;
        int i;
        int i2;
        if (this.limitType == Query.LimitType.LIMIT_TO_LAST && Long.compare(limit, i2) != 0) {
            i = Long.compare(limit, i2) != 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public FieldPath inequalityField() {
        Object next;
        boolean inequality;
        Iterator iterator = this.filters.iterator();
        for (Filter next : iterator) {
        }
        return null;
    }

    public boolean isCollectionGroupQuery() {
        int i;
        i = this.collectionGroup != null ? 1 : 0;
        return i;
    }

    public boolean isDocumentQuery() {
        int i;
        boolean collectionGroup;
        if (DocumentKey.isDocumentKey(this.path) && this.collectionGroup == null && this.filters.isEmpty()) {
            if (this.collectionGroup == null) {
                i = this.filters.isEmpty() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public com.google.firebase.firestore.core.Query limitToFirst(long l) {
        super(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, l, obj6, Query.LimitType.LIMIT_TO_FIRST, this.startAt, this.endAt);
        return query2;
    }

    public com.google.firebase.firestore.core.Query limitToLast(long l) {
        super(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, l, obj6, Query.LimitType.LIMIT_TO_LAST, this.startAt, this.endAt);
        return query2;
    }

    public boolean matches(Document document) {
        boolean matchesPathAndCollectionGroup;
        int obj2;
        if (document.isFoundDocument() && matchesPathAndCollectionGroup(document) && matchesOrderBy(document) && matchesFilters(document) && matchesBounds(document)) {
            if (matchesPathAndCollectionGroup(document)) {
                if (matchesOrderBy(document)) {
                    if (matchesFilters(document)) {
                        obj2 = matchesBounds(document) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public boolean matchesAllDocuments() {
        boolean keyField;
        int i;
        long limit;
        int i2;
        if (this.filters.isEmpty() && Long.compare(limit, i2) == 0 && this.startAt == null && this.endAt == null) {
            if (Long.compare(limit, i2) == 0) {
                if (this.startAt == null) {
                    if (this.endAt == null) {
                        if (!getExplicitOrderBy().isEmpty()) {
                            if (getExplicitOrderBy().size() == 1 && getFirstOrderByField().isKeyField()) {
                                if (getFirstOrderByField().isKeyField()) {
                                } else {
                                    i = 0;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public com.google.firebase.firestore.core.Query orderBy(com.google.firebase.firestore.core.OrderBy orderBy) {
        boolean inequalityField;
        Object[] field;
        int i2 = 0;
        Assert.hardAssert(documentQuery ^= 1, "No ordering is allowed for document query", new Object[i2]);
        inequalityField = inequalityField();
        if (this.explicitSortOrder.isEmpty() && inequalityField != null) {
            inequalityField = inequalityField();
            if (inequalityField != null) {
                if (!inequalityField.equals(orderBy.field)) {
                } else {
                }
                throw Assert.fail("First orderBy must match inequality field", new Object[i2]);
            }
        }
        ArrayList arrayList = new ArrayList(this.explicitSortOrder);
        arrayList.add(orderBy);
        super(this.path, this.collectionGroup, this.filters, arrayList, this.limit, obj6, this.limitType, this.startAt, this.endAt);
        return obj11;
    }

    public com.google.firebase.firestore.core.Query startAt(com.google.firebase.firestore.core.Bound bound) {
        super(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, obj6, this.limitType, bound, this.endAt);
        return query2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Query(target=");
        stringBuilder.append(toTarget().toString());
        stringBuilder.append(";limitType=");
        stringBuilder.append(this.limitType.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public com.google.firebase.firestore.core.Target toTarget() {
        Object memoizedTarget;
        Object lIMIT_TO_FIRST;
        Object endAt;
        Object startAt2;
        long instance;
        int bound2;
        Object direction;
        int collectionGroup2;
        List filters2;
        List orderBy;
        long limit;
        com.google.firebase.firestore.core.Bound startAt;
        com.google.firebase.firestore.core.Bound endAt2;
        com.google.firebase.firestore.core.Target target;
        ResourcePath path;
        String collectionGroup;
        List filters;
        ArrayList list;
        long l;
        com.google.firebase.firestore.core.Bound bound;
        int i;
        final Object obj = this;
        if (obj.memoizedTarget == null) {
            if (obj.limitType == Query.LimitType.LIMIT_TO_FIRST) {
                super(getPath(), getCollectionGroup(), getFilters(), getOrderBy(), obj.limit, obj9, getStartAt(), getEndAt());
                obj.memoizedTarget = memoizedTarget;
            } else {
                memoizedTarget = new ArrayList();
                Iterator iterator = getOrderBy().iterator();
                while (iterator.hasNext()) {
                    Object next2 = iterator.next();
                    if ((OrderBy)next2.getDirection() == OrderBy.Direction.DESCENDING) {
                    }
                    memoizedTarget.add(OrderBy.getInstance(collectionGroup2, next2.getField()));
                    collectionGroup2 = OrderBy.Direction.ASCENDING;
                }
                endAt = obj.endAt;
                if (endAt != null) {
                    direction = new Bound(endAt.getPosition(), inclusive2 ^= 1);
                    bound = direction;
                } else {
                    bound = bound2;
                }
                startAt2 = obj.startAt;
                if (startAt2 != null) {
                    bound2 = new Bound(startAt2.getPosition(), inclusive ^= 1);
                }
                super(getPath(), getCollectionGroup(), getFilters(), memoizedTarget, obj.limit, obj18, bound, bound2);
                obj.memoizedTarget = lIMIT_TO_FIRST;
            }
        }
        return obj.memoizedTarget;
    }
}
