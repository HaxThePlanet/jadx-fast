package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public class OrderBy {

    private final com.google.firebase.firestore.core.OrderBy.Direction direction;
    final FieldPath field;

    public static enum Direction {

        ASCENDING(true, "asc"),
        DESCENDING(-1, "desc");

        private final int comparisonModifier;
        private final String shorthand;
        @Override // java.lang.Enum
        public String canonicalString() {
            return this.shorthand;
        }

        @Override // java.lang.Enum
        int getComparisonModifier() {
            return this.comparisonModifier;
        }
    }
    private OrderBy(com.google.firebase.firestore.core.OrderBy.Direction orderBy$Direction, FieldPath fieldPath2) {
        super();
        this.direction = direction;
        this.field = fieldPath2;
    }

    public static com.google.firebase.firestore.core.OrderBy getInstance(com.google.firebase.firestore.core.OrderBy.Direction orderBy$Direction, FieldPath fieldPath2) {
        OrderBy orderBy = new OrderBy(direction, fieldPath2);
        return orderBy;
    }

    int compare(Document document, Document document2) {
        int comparisonModifier;
        int kEY_PATH;
        String str;
        int obj4;
        Object obj5;
        if (this.field.equals(FieldPath.KEY_PATH)) {
            comparisonModifier = this.direction.getComparisonModifier();
            obj4 = document.getKey().compareTo(document2.getKey());
        } else {
            obj4 = document.getField(this.field);
            obj5 = document2.getField(this.field);
            int i = 0;
            if (obj4 != null && obj5 != null) {
                kEY_PATH = obj5 != null ? 1 : i;
            } else {
            }
            Assert.hardAssert(kEY_PATH, "Trying to compare documents on fields that don't exist.", new Object[i]);
            comparisonModifier = this.direction.getComparisonModifier();
            obj4 = Values.compare(obj4, obj5);
        }
        return comparisonModifier *= obj4;
    }

    public boolean equals(Object object) {
        int i;
        com.google.firebase.firestore.core.OrderBy.Direction direction2;
        com.google.firebase.firestore.core.OrderBy.Direction direction;
        Object obj4;
        i = 0;
        if (object != null) {
            if (!object instanceof OrderBy) {
            } else {
                if (this.direction == object.direction && this.field.equals(object.field)) {
                    if (this.field.equals(object.field)) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public com.google.firebase.firestore.core.OrderBy.Direction getDirection() {
        return this.direction;
    }

    public FieldPath getField() {
        return this.field;
    }

    public int hashCode() {
        return i5 += i2;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        str = this.direction == OrderBy.Direction.ASCENDING ? "" : "-";
        stringBuilder.append(str);
        stringBuilder.append(this.field.canonicalString());
        return stringBuilder.toString();
    }
}
