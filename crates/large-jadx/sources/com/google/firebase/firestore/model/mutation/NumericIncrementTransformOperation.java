package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.z.a;
import f.c.e.c.x;
import f.c.e.c.x.b;

/* loaded from: classes2.dex */
public class NumericIncrementTransformOperation implements com.google.firebase.firestore.model.mutation.TransformOperation {

    private x operand;
    public NumericIncrementTransformOperation(x x) {
        super();
        Assert.hardAssert(Values.isNumber(x), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.operand = x;
    }

    private double operandAsDouble() {
        if (Values.isDouble(this.operand)) {
            return this.operand.getDoubleValue();
        }
        if (!Values.isInteger(this.operand)) {
        } else {
            return (double)l;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected 'operand' to be of Number type, but was ");
        stringBuilder.append(this.operand.getClass().getCanonicalName());
        throw Assert.fail(stringBuilder.toString(), new Object[0]);
    }

    private long operandAsLong() {
        if (Values.isDouble(this.operand)) {
            return (long)doubleValue;
        }
        if (!Values.isInteger(this.operand)) {
        } else {
            return this.operand.s();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected 'operand' to be of Number type, but was ");
        stringBuilder.append(this.operand.getClass().getCanonicalName());
        throw Assert.fail(stringBuilder.toString(), new Object[0]);
    }

    private long safeIncrement(long l, long l2) {
        final int i = l + obj5;
        int obj5 = 0;
        if (Long.compare(obj3, obj5) >= 0) {
            return i;
        }
        if (Long.compare(i, obj5) >= 0) {
            return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x applyToLocalView(x x, Timestamp timestamp2) {
        boolean integer;
        final x obj5 = computeBaseValue(x);
        if (Values.isInteger(obj5) && Values.isInteger(this.operand)) {
            if (Values.isInteger(this.operand)) {
                x.b bVar3 = x.x();
                bVar3.j(safeIncrement(obj5.s(), obj5));
                return (x)bVar3.build();
            }
        }
        if (Values.isInteger(obj5)) {
            x.b bVar2 = x.x();
            bVar2.g(obj4 += operandAsDouble2);
            return (x)bVar2.build();
        }
        Object[] arr = new Object[1];
        Assert.hardAssert(Values.isDouble(obj5), "Expected NumberValue to be of type DoubleValue, but was ", x.getClass().getCanonicalName());
        x.b bVar = x.x();
        bVar.g(obj4 += operandAsDouble);
        return (x)bVar.build();
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x applyToRemoteDocument(x x, x x2) {
        return x2;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x computeBaseValue(x x) {
        boolean number;
        com.google.protobuf.z obj3;
        if (Values.isNumber(x)) {
        } else {
            obj3 = x.x();
            obj3.j(0);
            obj3 = obj3.build();
        }
        return obj3;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x getOperand() {
        return this.operand;
    }
}
