package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.z;
import f.c.e.c.x;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class FieldFilter extends com.google.firebase.firestore.core.Filter {

    private final FieldPath field;
    private final com.google.firebase.firestore.core.Filter.Operator operator;
    private final x value;
    protected FieldFilter(FieldPath fieldPath, com.google.firebase.firestore.core.Filter.Operator filter$Operator2, x x3) {
        super();
        this.field = fieldPath;
        this.operator = operator2;
        this.value = x3;
    }

    public static com.google.firebase.firestore.core.FieldFilter create(FieldPath fieldPath, com.google.firebase.firestore.core.Filter.Operator filter$Operator2, x x3) {
        int i;
        com.google.firebase.firestore.core.Filter.Operator aRRAY_CONTAINS_ANY;
        if (fieldPath.isKeyField() && operator2 == Filter.Operator.IN) {
            if (operator2 == Filter.Operator.IN) {
                KeyFieldInFilter obj5 = new KeyFieldInFilter(fieldPath, x3);
                return obj5;
            }
            if (operator2 == Filter.Operator.NOT_IN) {
                obj5 = new KeyFieldNotInFilter(fieldPath, x3);
                return obj5;
            }
            int i2 = 0;
            if (operator2 != Filter.Operator.ARRAY_CONTAINS && operator2 != Filter.Operator.ARRAY_CONTAINS_ANY) {
                i = operator2 != Filter.Operator.ARRAY_CONTAINS_ANY ? 1 : i2;
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(operator2.toString());
            stringBuilder.append("queries don't make sense on document keys");
            Assert.hardAssert(i, stringBuilder.toString(), new Object[i2]);
            KeyFieldFilter keyFieldFilter = new KeyFieldFilter(fieldPath, operator2, x3);
            return keyFieldFilter;
        }
        if (operator2 == Filter.Operator.ARRAY_CONTAINS) {
            obj5 = new ArrayContainsFilter(fieldPath, x3);
            return obj5;
        }
        if (operator2 == Filter.Operator.IN) {
            obj5 = new InFilter(fieldPath, x3);
            return obj5;
        }
        if (operator2 == Filter.Operator.ARRAY_CONTAINS_ANY) {
            obj5 = new ArrayContainsAnyFilter(fieldPath, x3);
            return obj5;
        }
        if (operator2 == Filter.Operator.NOT_IN) {
            obj5 = new NotInFilter(fieldPath, x3);
            return obj5;
        }
        FieldFilter fieldFilter = new FieldFilter(fieldPath, operator2, x3);
        return fieldFilter;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean equals(Object object) {
        int i;
        com.google.firebase.firestore.core.Filter.Operator operator2;
        Object operator;
        Object obj4;
        i = 0;
        if (object != null) {
            if (!object instanceof FieldFilter) {
            } else {
                if (this.operator == object.operator && this.field.equals(object.field) && this.value.equals(object.value)) {
                    if (this.field.equals(object.field)) {
                        if (this.value.equals(object.value)) {
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public String getCanonicalId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getField().canonicalString());
        stringBuilder.append(getOperator().toString());
        stringBuilder.append(Values.canonicalId(getValue()));
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.firestore.core.Filter
    public FieldPath getField() {
        return this.field;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public com.google.firebase.firestore.core.Filter.Operator getOperator() {
        return this.operator;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public x getValue() {
        return this.value;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public int hashCode() {
        return i8 += i3;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean isInequality() {
        com.google.firebase.firestore.core.Filter.Operator[] arr = new Filter.Operator[6];
        return Arrays.asList(Filter.Operator.LESS_THAN, Filter.Operator.LESS_THAN_OR_EQUAL, Filter.Operator.GREATER_THAN, Filter.Operator.GREATER_THAN_OR_EQUAL, Filter.Operator.NOT_EQUAL, Filter.Operator.NOT_IN).contains(this.operator);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        Object typeOrder;
        int nOT_EQUAL;
        int i;
        boolean obj5;
        obj5 = document.getField(this.field);
        i = 1;
        final int i2 = 0;
        if (this.operator == Filter.Operator.NOT_EQUAL) {
            if (obj5 != null && matchesComparison(Values.compare(obj5, this.value))) {
                if (matchesComparison(Values.compare(obj5, this.value))) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        if (obj5 != null && Values.typeOrder(obj5) == Values.typeOrder(this.value) && matchesComparison(Values.compare(obj5, this.value))) {
            if (Values.typeOrder(obj5) == Values.typeOrder(this.value)) {
                if (matchesComparison(Values.compare(obj5, this.value))) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.firestore.core.Filter
    protected boolean matchesComparison(int i) {
        int i2;
        final int i4 = 1;
        switch (i3) {
            case 1:
                i2 = i4;
                return i2;
            case 2:
                i2 = i4;
                return i2;
            case 3:
                i2 = i4;
                return i2;
            case 4:
                i2 = i4;
                return i2;
            case 5:
                i2 = i4;
                return i2;
            case 6:
                i2 = i4;
                return i2;
            default:
                Object[] obj4 = new Object[i4];
                obj4[0] = this.operator;
                throw Assert.fail("Unknown FieldFilter operator: %s", obj4);
        }
    }

    @Override // com.google.firebase.firestore.core.Filter
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.field.canonicalString());
        String str = " ";
        stringBuilder.append(str);
        stringBuilder.append(this.operator);
        stringBuilder.append(str);
        stringBuilder.append(Values.canonicalId(this.value));
        return stringBuilder.toString();
    }
}
