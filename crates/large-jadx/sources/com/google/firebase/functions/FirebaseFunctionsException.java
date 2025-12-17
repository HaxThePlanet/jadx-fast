package com.google.firebase.functions;

import android.util.SparseArray;
import com.google.firebase.FirebaseException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseFunctionsException extends FirebaseException {

    private final com.google.firebase.functions.FirebaseFunctionsException.Code code;
    private final Object details;

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
        private static SparseArray<com.google.firebase.functions.FirebaseFunctionsException.Code> buildStatusList() {
            int i;
            com.google.firebase.functions.FirebaseFunctionsException.Code exc;
            int ordinal;
            SparseArray sparseArray = new SparseArray();
            com.google.firebase.functions.FirebaseFunctionsException.Code[] values = FirebaseFunctionsException.Code.values();
            i = 0;
            while (i < values.length) {
                exc = values[i];
                Object obj = sparseArray.get(exc.ordinal());
                sparseArray.put(exc.ordinal(), exc);
                i++;
            }
            return sparseArray;
        }

        static com.google.firebase.functions.FirebaseFunctionsException.Code fromHttpStatus(int i) {
            if (i != 200 && i != 409 && i != 429 && i != 400 && i != 401 && i != 403 && i != 404 && i != 503 && i != 504) {
                if (i != 409) {
                    if (i != 429) {
                        if (i != 400) {
                            if (i != 401) {
                                if (i != 403) {
                                    if (i != 404) {
                                        if (i != 503) {
                                            if (i != 504) {
                                                switch (i) {
                                                    case 499:
                                                        return FirebaseFunctionsException.Code.CANCELLED;
                                                    case 500:
                                                        return FirebaseFunctionsException.Code.INTERNAL;
                                                    case 501:
                                                        return FirebaseFunctionsException.Code.UNIMPLEMENTED;
                                                    default:
                                                        return FirebaseFunctionsException.Code.UNKNOWN;
                                                }
                                            }
                                            return FirebaseFunctionsException.Code.DEADLINE_EXCEEDED;
                                        }
                                        return FirebaseFunctionsException.Code.UNAVAILABLE;
                                    }
                                    return FirebaseFunctionsException.Code.NOT_FOUND;
                                }
                                return FirebaseFunctionsException.Code.PERMISSION_DENIED;
                            }
                            return FirebaseFunctionsException.Code.UNAUTHENTICATED;
                        }
                        return FirebaseFunctionsException.Code.INVALID_ARGUMENT;
                    }
                    return FirebaseFunctionsException.Code.RESOURCE_EXHAUSTED;
                }
                return FirebaseFunctionsException.Code.ABORTED;
            }
            return FirebaseFunctionsException.Code.OK;
        }

        static com.google.firebase.functions.FirebaseFunctionsException.Code fromValue(int i) {
            return (FirebaseFunctionsException.Code)FirebaseFunctionsException.Code.STATUS_LIST.get(i, FirebaseFunctionsException.Code.UNKNOWN);
        }
    }
    FirebaseFunctionsException(String string, com.google.firebase.functions.FirebaseFunctionsException.Code firebaseFunctionsException$Code2, Object object3) {
        super(string);
        this.code = code2;
        this.details = object3;
    }

    FirebaseFunctionsException(String string, com.google.firebase.functions.FirebaseFunctionsException.Code firebaseFunctionsException$Code2, Object object3, Throwable throwable4) {
        super(string, throwable4);
        this.code = code2;
        this.details = object3;
    }

    static com.google.firebase.functions.FirebaseFunctionsException fromResponse(com.google.firebase.functions.FirebaseFunctionsException.Code firebaseFunctionsException$Code, String string2, com.google.firebase.functions.Serializer serializer3) {
        String string3;
        boolean string;
        String name;
        com.google.firebase.functions.FirebaseFunctionsException.Code obj5;
        Object obj6;
        string3 = "status";
        final String str2 = "message";
        name = code.name();
        JSONObject jSONObject = new JSONObject(string2);
        obj6 = jSONObject.getJSONObject("error");
        if (obj2 instanceof String != null) {
            name = FirebaseFunctionsException.Code.valueOf(obj6.getString(string3)).name();
        }
        if (obj instanceof String != null && !obj6.getString(str2).isEmpty()) {
            if (!obj6.getString(str2).isEmpty()) {
                name = string;
            }
        }
        obj6 = obj6.opt("details");
        if (obj6 != null) {
            obj6 = serializer3.decode(obj6);
        }
        try {
            if (obj5 == FirebaseFunctionsException.Code.OK) {
            }
            return null;
            FirebaseFunctionsException obj7 = new FirebaseFunctionsException(name, obj5, obj6);
            return obj7;
        } catch (java.lang.IllegalArgumentException iae) {
        } catch (org.json.JSONException jSON1) {
        }
    }

    @Override // com.google.firebase.FirebaseException
    public com.google.firebase.functions.FirebaseFunctionsException.Code getCode() {
        return this.code;
    }

    @Override // com.google.firebase.FirebaseException
    public Object getDetails() {
        return this.details;
    }
}
