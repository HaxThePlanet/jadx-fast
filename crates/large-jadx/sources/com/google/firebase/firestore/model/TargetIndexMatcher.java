package com.google.firebase.firestore.model;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.Filter.Operator;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class TargetIndexMatcher {

    private final String collectionId;
    private final Map<com.google.firebase.firestore.model.FieldPath, List<FieldFilter>> fieldFilterFields;
    private final Set<com.google.firebase.firestore.model.FieldPath> orderByFields;
    public TargetIndexMatcher(Target target) {
        String collectionGroup;
        Iterator iterator;
        Object next;
        boolean orderByFields;
        Object arrayList;
        com.google.firebase.firestore.model.FieldPath fieldFilterFields;
        String field;
        super();
        HashMap hashMap = new HashMap();
        this.fieldFilterFields = hashMap;
        HashSet hashSet = new HashSet();
        this.orderByFields = hashSet;
        if (target.getCollectionGroup() != null) {
            collectionGroup = target.getCollectionGroup();
        } else {
            collectionGroup = target.getPath().getLastSegment();
        }
        this.collectionId = collectionGroup;
        iterator = target.getFilters().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            Assert.hardAssert(next instanceof FieldFilter, "Only FieldFilters are supported", new Object[0]);
            if ((List)this.fieldFilterFields.get((Filter)next.getField()) == null) {
            }
            arrayList.add((FieldFilter)next);
            arrayList = new ArrayList();
            this.fieldFilterFields.put(next.getField(), arrayList);
        }
        Iterator obj6 = target.getOrderBy().iterator();
        for (OrderBy next3 : obj6) {
            this.orderByFields.add(next3.getField());
        }
    }

    private boolean canUseSegment(com.google.firebase.firestore.model.FieldIndex.Segment fieldIndex$Segment) {
        Object iterator;
        com.google.firebase.firestore.model.FieldIndex.Segment.Kind oRDERED;
        int i;
        boolean equals;
        com.google.firebase.firestore.model.FieldIndex.Segment.Kind cONTAINS;
        int[] $SwitchMap$com$google$firebase$firestore$core$Filter$Operator;
        boolean obj5;
        iterator = this.fieldFilterFields.get(segment.getFieldPath());
        i = 1;
        if ((List)iterator != null) {
            iterator = (List)iterator.iterator();
            for (FieldFilter next : iterator) {
                int i2 = TargetIndexMatcher.1.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[next.getOperator().ordinal()];
            }
        }
        if (this.orderByFields.contains(segment.getFieldPath()) && segment.getKind().equals(FieldIndex.Segment.Kind.ORDERED)) {
            if (segment.getKind().equals(FieldIndex.Segment.Kind.ORDERED)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public boolean servedByIndex(com.google.firebase.firestore.model.FieldIndex fieldIndex) {
        int i;
        Object[] useSegment;
        int i2 = 0;
        Assert.hardAssert(fieldIndex.getCollectionGroup().equals(this.collectionId), "Collection IDs do not match", new Object[i2]);
        i = i2;
        while (i < fieldIndex.segmentCount()) {
            i++;
        }
        return 1;
    }
}
