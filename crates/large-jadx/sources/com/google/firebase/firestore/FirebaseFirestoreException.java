package com.google.firebase.firestore;

import android.util.SparseArray;
import com.google.firebase.FirebaseException;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;

/* loaded from: classes2.dex */
public class FirebaseFirestoreException extends FirebaseException {

    private final com.google.firebase.firestore.FirebaseFirestoreException.Code code;

    public static enum Code {

        OK(false),
        CANCELLED(true),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(6),
        RESOURCE_EXHAUSTED(5),
        FAILED_PRECONDITION(4),
        ABORTED(3),
        OUT_OF_RANGE(2),
        UNIMPLEMENTED(true),
        INTERNAL(false),
        UNAVAILABLE(2),
        DATA_LOSS(true),
        UNAUTHENTICATED(false);

        private final int value;
        private static SparseArray<com.google.firebase.firestore.FirebaseFirestoreException.Code> buildStatusList() {
            int i;
            com.google.firebase.firestore.FirebaseFirestoreException.Code exc;
            int value;
            SparseArray sparseArray = new SparseArray();
            com.google.firebase.firestore.FirebaseFirestoreException.Code[] values = FirebaseFirestoreException.Code.values();
            i = 0;
            while (i < values.length) {
                exc = values[i];
                Object obj = sparseArray.get(exc.value());
                sparseArray.put(exc.value(), exc);
                i++;
            }
            return sparseArray;
        }

        public static com.google.firebase.firestore.FirebaseFirestoreException.Code fromValue(int i) {
            return (FirebaseFirestoreException.Code)FirebaseFirestoreException.Code.STATUS_LIST.get(i, FirebaseFirestoreException.Code.UNKNOWN);
        }

        @Override // java.lang.Enum
        public int value() {
            return this.value;
        }
    }
    public FirebaseFirestoreException(String string, com.google.firebase.firestore.FirebaseFirestoreException.Code firebaseFirestoreException$Code2) {
        int obj3;
        super(string);
        Preconditions.checkNotNull(string, "Provided message must not be null.");
        int i = 0;
        obj3 = code2 != FirebaseFirestoreException.Code.OK ? 1 : i;
        Assert.hardAssert(obj3, "A FirebaseFirestoreException should never be thrown for OK", new Object[i]);
        this.code = (FirebaseFirestoreException.Code)Preconditions.checkNotNull(code2, "Provided code must not be null.");
    }

    public FirebaseFirestoreException(String string, com.google.firebase.firestore.FirebaseFirestoreException.Code firebaseFirestoreException$Code2, Throwable throwable3) {
        int obj2;
        super(string, throwable3);
        Preconditions.checkNotNull(string, "Provided message must not be null.");
        int obj4 = 0;
        obj2 = code2 != FirebaseFirestoreException.Code.OK ? 1 : obj4;
        Assert.hardAssert(obj2, "A FirebaseFirestoreException should never be thrown for OK", new Object[obj4]);
        this.code = (FirebaseFirestoreException.Code)Preconditions.checkNotNull(code2, "Provided code must not be null.");
    }

    @Override // com.google.firebase.FirebaseException
    public com.google.firebase.firestore.FirebaseFirestoreException.Code getCode() {
        return this.code;
    }
}
