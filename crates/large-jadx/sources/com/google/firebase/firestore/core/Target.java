package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldIndex.Segment;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.Values;
import f.c.e.c.a;
import f.c.e.c.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Target {

    public static final long NO_LIMIT = -1L;
    private final String collectionGroup;
    private final com.google.firebase.firestore.core.Bound endAt;
    private final List<com.google.firebase.firestore.core.Filter> filters;
    private final long limit;
    private String memoizedCannonicalId;
    private final List<com.google.firebase.firestore.core.OrderBy> orderBys;
    private final ResourcePath path;
    private final com.google.firebase.firestore.core.Bound startAt;
    public Target(ResourcePath resourcePath, String string2, List<com.google.firebase.firestore.core.Filter> list3, List<com.google.firebase.firestore.core.OrderBy> list4, long l5, com.google.firebase.firestore.core.Bound bound6, com.google.firebase.firestore.core.Bound bound7) {
        super();
        this.path = resourcePath;
        this.collectionGroup = string2;
        this.orderBys = list4;
        this.filters = list3;
        this.limit = l5;
        this.startAt = bound7;
        this.endAt = obj8;
    }

    public boolean equals(Object object) {
        int equals;
        boolean collectionGroup;
        com.google.firebase.firestore.core.Bound startAt;
        Class<com.google.firebase.firestore.core.Target> obj;
        Object collectionGroup2;
        Object startAt2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (Target.class != object.getClass()) {
            } else {
                String collectionGroup3 = this.collectionGroup;
                if (collectionGroup3 != null) {
                    if (!collectionGroup3.equals(object.collectionGroup)) {
                        return i;
                    }
                } else {
                    if (object.collectionGroup != null) {
                    }
                }
                if (Long.compare(limit, limit2) != 0) {
                    return i;
                }
                if (!this.orderBys.equals(object.orderBys)) {
                    return i;
                }
                if (!this.filters.equals(object.filters)) {
                    return i;
                }
                if (!this.path.equals(object.path)) {
                    return i;
                }
                com.google.firebase.firestore.core.Bound startAt3 = this.startAt;
                if (startAt3 != null) {
                    if (!startAt3.equals(object.startAt)) {
                        return i;
                    }
                } else {
                    if (object.startAt != null) {
                    }
                }
                com.google.firebase.firestore.core.Bound endAt = this.endAt;
                final com.google.firebase.firestore.core.Bound obj7 = object.endAt;
                if (endAt != null) {
                    equals = endAt.equals(obj7);
                } else {
                    if (obj7 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public List<x> getArrayValues(FieldIndex fieldIndex) {
        Object next;
        Iterator iterator;
        boolean next2;
        boolean equals;
        FieldPath fieldPath;
        Iterator obj6 = fieldIndex.getArraySegments().iterator();
        for (FieldIndex.Segment next : obj6) {
            iterator = this.filters.iterator();
            for (Filter next2 : iterator) {
                equals = Target.1.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[(FieldFilter)next2.getOperator().ordinal()];
            }
            next2 = iterator.next();
            equals = Target.1.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[(FieldFilter)next2.getOperator().ordinal()];
        }
        return Collections.emptyList();
    }

    public String getCanonicalId() {
        String collectionGroup;
        boolean limit;
        Object positionString2;
        Object positionString;
        String str2;
        String canonicalId;
        boolean canonicalString;
        String str;
        String canonicalString2;
        String memoizedCannonicalId = this.memoizedCannonicalId;
        if (memoizedCannonicalId != null) {
            return memoizedCannonicalId;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPath().canonicalString());
        if (this.collectionGroup != null) {
            stringBuilder.append("|cg:");
            stringBuilder.append(this.collectionGroup);
        }
        stringBuilder.append("|f:");
        Iterator iterator = getFilters().iterator();
        for (Filter next : iterator) {
            stringBuilder.append(next.getCanonicalId());
        }
        stringBuilder.append("|ob:");
        Iterator iterator2 = getOrderBy().iterator();
        boolean next2 = iterator2.hasNext();
        for (OrderBy next3 : iterator2) {
            stringBuilder.append(next3.getField().canonicalString());
            stringBuilder.append(next3.getDirection().canonicalString());
            next2 = iterator2.hasNext();
        }
        if (hasLimit()) {
            stringBuilder.append("|l:");
            stringBuilder.append(getLimit());
        }
        String str9 = "a:";
        if (this.startAt != null) {
            stringBuilder.append("|lb:");
            str2 = this.startAt.isInclusive() ? str : str9;
            stringBuilder.append(str2);
            stringBuilder.append(this.startAt.positionString());
        }
        stringBuilder.append("|ub:");
        if (this.endAt != null && this.endAt.isInclusive()) {
            stringBuilder.append("|ub:");
            if (this.endAt.isInclusive()) {
                str = str9;
            }
            stringBuilder.append(str);
            stringBuilder.append(this.endAt.positionString());
        }
        String string = stringBuilder.toString();
        this.memoizedCannonicalId = string;
        return string;
    }

    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    public com.google.firebase.firestore.core.Bound getEndAt() {
        return this.endAt;
    }

    public List<com.google.firebase.firestore.core.Filter> getFilters() {
        return this.filters;
    }

    public com.google.firebase.firestore.core.OrderBy getFirstOrderBy() {
        return (OrderBy)this.orderBys.get(0);
    }

    public long getLimit() {
        return this.limit;
    }

    public com.google.firebase.firestore.core.Bound getLowerBound(FieldIndex fieldIndex) {
        int i;
        Object next;
        x nULL_VALUE;
        com.google.firebase.firestore.core.Bound startAt;
        int inclusive;
        boolean fieldPath2;
        int i2;
        boolean lowerBound;
        FieldPath fieldPath;
        int ordinal;
        ArrayList arrayList = new ArrayList();
        Iterator obj13 = fieldIndex.getDirectionalSegments().iterator();
        final int i3 = 1;
        i = i3;
        for (FieldIndex.Segment next : obj13) {
            nULL_VALUE = Values.NULL_VALUE;
            Iterator iterator = this.filters.iterator();
            inclusive = i3;
            i2 = 0;
            while (iterator.hasNext()) {
                fieldPath2 = iterator.next();
                if ((Filter)fieldPath2.getField().equals(next.getFieldPath())) {
                }
                i2 = 0;
                lowerBound = 0;
                i2 = i3;
                if (Values.max(nULL_VALUE, lowerBound) == lowerBound) {
                }
                inclusive = i2;
                nULL_VALUE = lowerBound;
                lowerBound = fieldPath2.getValue();
                lowerBound = fieldPath2.getValue();
                lowerBound = Values.getLowerBound(fieldPath2.getValue().w());
            }
            if (this.startAt != null) {
            }
            arrayList.add(nULL_VALUE);
            i &= inclusive;
            while (i2 < this.orderBys.size()) {
                if ((OrderBy)this.orderBys.get(i2).getField().equals(next.getFieldPath()) != null) {
                    break loop_13;
                } else {
                }
                i2++;
            }
            if ((OrderBy)this.orderBys.get(i2).getField().equals(next.getFieldPath()) != null) {
            } else {
            }
            i2++;
            next = this.startAt.getPosition().get(i2);
            if (Values.max(nULL_VALUE, (x)next) == next) {
            }
            inclusive = this.startAt.isInclusive();
            nULL_VALUE = next;
            fieldPath2 = iterator.next();
            if ((Filter)fieldPath2.getField().equals(next.getFieldPath())) {
            }
            lowerBound = 0;
            i2 = i3;
            if (Values.max(nULL_VALUE, lowerBound) == lowerBound) {
            }
            inclusive = i2;
            nULL_VALUE = lowerBound;
            lowerBound = fieldPath2.getValue();
            lowerBound = fieldPath2.getValue();
            lowerBound = Values.getLowerBound(fieldPath2.getValue().w());
        }
        obj13 = new Bound(arrayList, i);
        return obj13;
    }

    public List<com.google.firebase.firestore.core.OrderBy> getOrderBy() {
        return this.orderBys;
    }

    public ResourcePath getPath() {
        return this.path;
    }

    public com.google.firebase.firestore.core.Bound getStartAt() {
        return this.startAt;
    }

    public com.google.firebase.firestore.core.Bound getUpperBound(FieldIndex fieldIndex) {
        int i3;
        Object next;
        int i2;
        com.google.firebase.firestore.core.Bound endAt;
        int i;
        int inclusive;
        boolean upperBound;
        int i4;
        boolean equals;
        FieldPath fieldPath;
        ArrayList arrayList = new ArrayList();
        Iterator obj13 = fieldIndex.getDirectionalSegments().iterator();
        final int i6 = 1;
        i3 = i6;
        i2 = 0;
        for (FieldIndex.Segment next : obj13) {
            Iterator iterator = this.filters.iterator();
            inclusive = i6;
            i = i2;
            i4 = 0;
            while (iterator.hasNext()) {
                upperBound = iterator.next();
                if ((Filter)upperBound.getField().equals(next.getFieldPath())) {
                }
                i4 = 0;
                i4 = i6;
                upperBound = i2;
                if (Values.min(i, upperBound) == upperBound) {
                }
                i = upperBound;
                inclusive = i4;
                upperBound = Values.getUpperBound(upperBound.getValue().w());
                upperBound = upperBound.getValue();
                i4 = i6;
                upperBound = upperBound.getValue();
            }
            if (this.endAt != null) {
            }
            arrayList.add(i);
            i3 &= inclusive;
            i2 = 0;
            while (i4 < this.orderBys.size()) {
                if ((OrderBy)this.orderBys.get(i4).getField().equals(next.getFieldPath()) != null) {
                    break loop_13;
                } else {
                }
                i4++;
            }
            if ((OrderBy)this.orderBys.get(i4).getField().equals(next.getFieldPath()) != null) {
            } else {
            }
            i4++;
            next = this.endAt.getPosition().get(i4);
            if (Values.min(i, (x)next) == next) {
            }
            inclusive = this.endAt.isInclusive();
            i = next;
            upperBound = iterator.next();
            if ((Filter)upperBound.getField().equals(next.getFieldPath())) {
            }
            i4 = i6;
            upperBound = i2;
            if (Values.min(i, upperBound) == upperBound) {
            }
            i = upperBound;
            inclusive = i4;
            upperBound = Values.getUpperBound(upperBound.getValue().w());
            upperBound = upperBound.getValue();
            i4 = i6;
            upperBound = upperBound.getValue();
        }
        if (arrayList.isEmpty()) {
            return i2;
        }
        obj13 = new Bound(arrayList, i3);
        return obj13;
    }

    public boolean hasLimit() {
        int i;
        i = Long.compare(limit, i2) != 0 ? 1 : 0;
        return i;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i;
        String collectionGroup = this.collectionGroup;
        i = 0;
        if (collectionGroup != null) {
            i2 = collectionGroup.hashCode();
        } else {
            i2 = i;
        }
        long limit = this.limit;
        com.google.firebase.firestore.core.Bound startAt = this.startAt;
        if (startAt != null) {
            i3 = startAt.hashCode();
        } else {
            i3 = i;
        }
        com.google.firebase.firestore.core.Bound endAt = this.endAt;
        if (endAt != null) {
            i = endAt.hashCode();
        }
        return i15 += i;
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

    public String toString() {
        String collectionGroup;
        int empty2;
        boolean empty;
        String str;
        int i;
        Object size;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Query(");
        stringBuilder.append(this.path.canonicalString());
        if (this.collectionGroup != null) {
            stringBuilder.append(" collectionGroup=");
            stringBuilder.append(this.collectionGroup);
        }
        if (!this.filters.isEmpty()) {
            stringBuilder.append(" where ");
            empty2 = i;
            while (empty2 < this.filters.size()) {
                if (empty2 > 0) {
                }
                stringBuilder.append(this.filters.get(empty2));
                empty2++;
                stringBuilder.append(" and ");
            }
        }
        if (!this.orderBys.isEmpty()) {
            stringBuilder.append(" order by ");
            while (i < this.orderBys.size()) {
                if (i > 0) {
                }
                stringBuilder.append(this.orderBys.get(i));
                i++;
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
