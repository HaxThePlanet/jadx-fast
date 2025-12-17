package com.google.firebase.firestore;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FieldValue {

    private static final com.google.firebase.firestore.FieldValue.DeleteFieldValue DELETE_INSTANCE;
    private static final com.google.firebase.firestore.FieldValue.ServerTimestampFieldValue SERVER_TIMESTAMP_INSTANCE;

    static class ArrayRemoveFieldValue extends com.google.firebase.firestore.FieldValue {

        private final List<Object> elements;
        ArrayRemoveFieldValue(List<Object> list) {
            super();
            this.elements = list;
        }

        List<Object> getElements() {
            return this.elements;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String getMethodName() {
            return "FieldValue.arrayRemove";
        }
    }

    static class ArrayUnionFieldValue extends com.google.firebase.firestore.FieldValue {

        private final List<Object> elements;
        ArrayUnionFieldValue(List<Object> list) {
            super();
            this.elements = list;
        }

        List<Object> getElements() {
            return this.elements;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String getMethodName() {
            return "FieldValue.arrayUnion";
        }
    }

    static class DeleteFieldValue extends com.google.firebase.firestore.FieldValue {
        @Override // com.google.firebase.firestore.FieldValue
        String getMethodName() {
            return "FieldValue.delete";
        }
    }

    static class NumericIncrementFieldValue extends com.google.firebase.firestore.FieldValue {

        private final Number operand;
        NumericIncrementFieldValue(Number number) {
            super();
            this.operand = number;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String getMethodName() {
            return "FieldValue.increment";
        }

        @Override // com.google.firebase.firestore.FieldValue
        Number getOperand() {
            return this.operand;
        }
    }

    static class ServerTimestampFieldValue extends com.google.firebase.firestore.FieldValue {
        @Override // com.google.firebase.firestore.FieldValue
        String getMethodName() {
            return "FieldValue.serverTimestamp";
        }
    }
    static {
        FieldValue.DeleteFieldValue deleteFieldValue = new FieldValue.DeleteFieldValue();
        FieldValue.DELETE_INSTANCE = deleteFieldValue;
        FieldValue.ServerTimestampFieldValue serverTimestampFieldValue = new FieldValue.ServerTimestampFieldValue();
        FieldValue.SERVER_TIMESTAMP_INSTANCE = serverTimestampFieldValue;
    }

    public static com.google.firebase.firestore.FieldValue arrayRemove(Object... objectArr) {
        FieldValue.ArrayRemoveFieldValue arrayRemoveFieldValue = new FieldValue.ArrayRemoveFieldValue(Arrays.asList(objectArr));
        return arrayRemoveFieldValue;
    }

    public static com.google.firebase.firestore.FieldValue arrayUnion(Object... objectArr) {
        FieldValue.ArrayUnionFieldValue arrayUnionFieldValue = new FieldValue.ArrayUnionFieldValue(Arrays.asList(objectArr));
        return arrayUnionFieldValue;
    }

    public static com.google.firebase.firestore.FieldValue delete() {
        return FieldValue.DELETE_INSTANCE;
    }

    public static com.google.firebase.firestore.FieldValue increment(double d) {
        FieldValue.NumericIncrementFieldValue numericIncrementFieldValue = new FieldValue.NumericIncrementFieldValue(Double.valueOf(d));
        return numericIncrementFieldValue;
    }

    public static com.google.firebase.firestore.FieldValue increment(long l) {
        FieldValue.NumericIncrementFieldValue numericIncrementFieldValue = new FieldValue.NumericIncrementFieldValue(Long.valueOf(l));
        return numericIncrementFieldValue;
    }

    public static com.google.firebase.firestore.FieldValue serverTimestamp() {
        return FieldValue.SERVER_TIMESTAMP_INSTANCE;
    }

    abstract String getMethodName();
}
