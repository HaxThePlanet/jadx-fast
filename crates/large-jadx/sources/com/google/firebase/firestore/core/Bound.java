package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Bound {

    private final boolean inclusive;
    private final List<x> position;
    public Bound(List<x> list, boolean z2) {
        super();
        this.position = list;
        this.inclusive = z2;
    }

    private int compareToDocument(List<com.google.firebase.firestore.core.OrderBy> list, Document document2) {
        int i3;
        int i;
        int i2;
        String compareTo;
        com.google.firebase.firestore.core.OrderBy.Direction dESCENDING;
        Object field;
        Object[] arr;
        String str2;
        String str;
        final int i4 = 1;
        final int i5 = 0;
        i3 = this.position.size() <= list.size() ? i4 : i5;
        Assert.hardAssert(i3, "Bound has more components than query's orderBy", new Object[i5]);
        i2 = i;
        while (i < this.position.size()) {
            Object obj = list.get(i);
            Object obj2 = this.position.get(i);
            if (obj.field.equals(FieldPath.KEY_PATH)) {
            } else {
            }
            field = document2.getField((OrderBy)obj.getField());
            if (field != null) {
            } else {
            }
            arr = i5;
            Assert.hardAssert(arr, "Field should exist since document matched the orderBy already.", new Object[i5]);
            compareTo = Values.compare((x)obj2, field);
            if (obj.getDirection().equals(OrderBy.Direction.DESCENDING)) {
            }
            if (compareTo != 0) {
                break;
            } else {
            }
            i++;
            compareTo *= -1;
            arr = i4;
            arr = new Object[i4];
            arr[i5] = obj2;
            Assert.hardAssert(Values.isReferenceValue(obj2), "Bound has a non-key value where the key path is being used %s", arr);
            compareTo = DocumentKey.fromName(obj2.u()).compareTo(document2.getKey());
        }
        return i2;
    }

    public boolean equals(Object object) {
        int i;
        List inclusive;
        Class<com.google.firebase.firestore.core.Bound> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (Bound.class != object.getClass()) {
            } else {
                if (this.inclusive == object.inclusive && this.position.equals(object.position)) {
                    if (this.position.equals(object.position)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public List<x> getPosition() {
        return this.position;
    }

    public int hashCode() {
        return i += i3;
    }

    public boolean isInclusive() {
        return this.inclusive;
    }

    public String positionString() {
        int str;
        String canonicalId;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.position.iterator();
        str = 1;
        while (iterator.hasNext()) {
            if (str == null) {
            }
            str = 0;
            stringBuilder.append(Values.canonicalId((x)iterator.next()));
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public boolean sortsAfterDocument(List<com.google.firebase.firestore.core.OrderBy> list, Document document2) {
        int i;
        final int obj3 = compareToDocument(list, document2);
        i = 1;
        if (this.inclusive) {
            if (obj3 >= 0) {
            } else {
                i = i2;
            }
        } else {
            if (obj3 > 0) {
            } else {
            }
        }
        return i;
    }

    public boolean sortsBeforeDocument(List<com.google.firebase.firestore.core.OrderBy> list, Document document2) {
        int i;
        final int obj3 = compareToDocument(list, document2);
        i = 1;
        if (this.inclusive) {
            if (obj3 <= 0) {
            } else {
                i = i2;
            }
        } else {
            if (obj3 < 0) {
            } else {
            }
        }
        return i;
    }

    public String toString() {
        int i;
        String canonicalId;
        int size;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bound(inclusive=");
        stringBuilder.append(this.inclusive);
        stringBuilder.append(", position=");
        i = 0;
        while (i < this.position.size()) {
            if (i > 0) {
            }
            stringBuilder.append(Values.canonicalId((x)this.position.get(i)));
            i++;
            stringBuilder.append(" and ");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
