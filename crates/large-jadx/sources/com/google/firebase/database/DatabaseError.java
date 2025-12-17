package com.google.firebase.database;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class DatabaseError {

    public static final int DATA_STALE = -1;
    public static final int DISCONNECTED = -4;
    public static final int EXPIRED_TOKEN = -6;
    public static final int INVALID_TOKEN = -7;
    public static final int MAX_RETRIES = -8;
    public static final int NETWORK_ERROR = -24;
    public static final int OPERATION_FAILED = -2;
    public static final int OVERRIDDEN_BY_SET = -9;
    public static final int PERMISSION_DENIED = -3;
    public static final int UNAVAILABLE = -10;
    public static final int UNKNOWN_ERROR = -999;
    public static final int USER_CODE_EXCEPTION = -11;
    public static final int WRITE_CANCELED = -25;
    private static final Map<String, Integer> errorCodes;
    private static final Map<Integer, String> errorReasons;
    private final int code;
    private final String details;
    private final String message;
    static {
        HashMap hashMap = new HashMap();
        DatabaseError.errorReasons = hashMap;
        Integer valueOf = -1;
        hashMap.put(valueOf, "The transaction needs to be run again with current data");
        Integer valueOf2 = -2;
        hashMap.put(valueOf2, "The server indicated that this operation failed");
        Integer valueOf3 = -3;
        hashMap.put(valueOf3, "This client does not have permission to perform this operation");
        Integer valueOf4 = -4;
        hashMap.put(valueOf4, "The operation had to be aborted due to a network disconnect");
        Integer valueOf5 = -6;
        hashMap.put(valueOf5, "The supplied auth token has expired");
        Integer valueOf6 = -7;
        hashMap.put(valueOf6, "The supplied auth token was invalid");
        Integer valueOf7 = -8;
        hashMap.put(valueOf7, "The transaction had too many retries");
        Integer valueOf8 = -9;
        hashMap.put(valueOf8, "The transaction was overridden by a subsequent set");
        Integer valueOf9 = -10;
        hashMap.put(valueOf9, "The service is unavailable");
        hashMap.put(-11, "User code called from the Firebase Database runloop threw an exception:\n");
        Integer valueOf11 = -24;
        hashMap.put(valueOf11, "The operation could not be performed due to a network error");
        Integer valueOf12 = -25;
        hashMap.put(valueOf12, "The write was canceled by the user.");
        hashMap.put(-999, "An unknown error occurred");
        HashMap hashMap2 = new HashMap();
        DatabaseError.errorCodes = hashMap2;
        hashMap2.put("datastale", valueOf);
        hashMap2.put("failure", valueOf2);
        hashMap2.put("permission_denied", valueOf3);
        hashMap2.put("disconnected", valueOf4);
        hashMap2.put("expired_token", valueOf5);
        hashMap2.put("invalid_token", valueOf6);
        hashMap2.put("maxretries", valueOf7);
        hashMap2.put("overriddenbyset", valueOf8);
        hashMap2.put("unavailable", valueOf9);
        hashMap2.put("network_error", valueOf11);
        hashMap2.put("write_canceled", valueOf12);
    }

    private DatabaseError(int i, String string2) {
        super(i, string2, 0);
    }

    private DatabaseError(int i, String string2, String string3) {
        String obj3;
        super();
        this.code = i;
        this.message = string2;
        obj3 = string3 == null ? "" : obj3;
        this.details = obj3;
    }

    public static com.google.firebase.database.DatabaseError fromCode(int i) {
        Map errorReasons = DatabaseError.errorReasons;
        if (!errorReasons.containsKey(Integer.valueOf(i))) {
        } else {
            DatabaseError databaseError = new DatabaseError(i, (String)errorReasons.get(Integer.valueOf(i)), 0);
            return databaseError;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid Firebase Database error code: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static com.google.firebase.database.DatabaseError fromException(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        StringBuilder obj4 = new StringBuilder();
        final int i = -11;
        obj4.append((String)DatabaseError.errorReasons.get(Integer.valueOf(i)));
        obj4.append(stringWriter.toString());
        DatabaseError databaseError = new DatabaseError(i, obj4.toString());
        return databaseError;
    }

    public static com.google.firebase.database.DatabaseError fromStatus(String string) {
        return DatabaseError.fromStatus(string, 0);
    }

    public static com.google.firebase.database.DatabaseError fromStatus(String string, String string2) {
        return DatabaseError.fromStatus(string, string2, 0);
    }

    public static com.google.firebase.database.DatabaseError fromStatus(String string, String string2, String string3) {
        Object obj2;
        Object obj3;
        if ((Integer)DatabaseError.errorCodes.get(string.toLowerCase(Locale.US)) == null) {
            obj2 = -999;
        }
        if (string2 == null) {
            obj3 = DatabaseError.errorReasons.get(obj2);
        }
        DatabaseError databaseError = new DatabaseError(obj2.intValue(), obj3, string3);
        return databaseError;
    }

    public int getCode() {
        return this.code;
    }

    public String getDetails() {
        return this.details;
    }

    public String getMessage() {
        return this.message;
    }

    public com.google.firebase.database.DatabaseException toException() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firebase Database error: ");
        stringBuilder.append(this.message);
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        return databaseException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DatabaseError: ");
        stringBuilder.append(this.message);
        return stringBuilder.toString();
    }
}
