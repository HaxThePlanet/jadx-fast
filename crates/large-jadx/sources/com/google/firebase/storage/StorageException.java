package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class StorageException extends FirebaseException {

    static final boolean $assertionsDisabled = false;
    public static final int ERROR_BUCKET_NOT_FOUND = -13011;
    public static final int ERROR_CANCELED = -13040;
    public static final int ERROR_INVALID_CHECKSUM = -13031;
    public static final int ERROR_NOT_AUTHENTICATED = -13020;
    public static final int ERROR_NOT_AUTHORIZED = -13021;
    public static final int ERROR_OBJECT_NOT_FOUND = -13010;
    public static final int ERROR_PROJECT_NOT_FOUND = -13012;
    public static final int ERROR_QUOTA_EXCEEDED = -13013;
    public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;
    public static final int ERROR_UNKNOWN = -13000;
    private static final int NETWORK_UNAVAILABLE = -2;
    private static final String TAG = "StorageException";
    private Throwable cause;
    private final int errorCode;
    private final int httpResultCode;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }
    static {
        final Class<com.google.firebase.storage.StorageException> obj = StorageException.class;
    }

    StorageException(int i, Throwable throwable2, int i3) {
        Object obj2;
        int obj4;
        super(StorageException.getErrorMessageForCode(i));
        this.cause = throwable2;
        this.errorCode = i;
        this.httpResultCode = i3;
        StringBuilder obj3 = new StringBuilder();
        obj3.append("StorageException has occurred.\n");
        obj3.append(StorageException.getErrorMessageForCode(i));
        obj3.append("\n Code: ");
        obj3.append(i);
        obj3.append(" HttpResult: ");
        obj3.append(i3);
        obj3 = "StorageException";
        Log.e(obj3, obj3.toString());
        obj2 = this.cause;
        if (obj2 != null) {
            Log.e(obj3, obj2.getMessage(), this.cause);
        }
    }

    private static int calculateErrorCode(Status status) {
        if (status.isCanceled()) {
            return -13040;
        }
        if (status.equals(Status.A)) {
            return -13030;
        }
        return -13000;
    }

    private static int calculateErrorCode(Throwable throwable, int i2) {
        if (throwable instanceof CancelException != null) {
            return -13040;
        }
        if (i2 != -2 && i2 != 401 && i2 != 409 && i2 != 403 && i2 != 404) {
            if (i2 != 401) {
                if (i2 != 409) {
                    if (i2 != 403) {
                        if (i2 != 404) {
                            return -13000;
                        }
                        return -13010;
                    }
                    return -13021;
                }
                return -13031;
            }
            return -13020;
        }
        return -13030;
    }

    public static com.google.firebase.storage.StorageException fromErrorStatus(Status status) {
        r.j(status);
        r.a(z ^= 1);
        StorageException storageException = new StorageException(StorageException.calculateErrorCode(status), 0, 0);
        return storageException;
    }

    public static com.google.firebase.storage.StorageException fromException(Throwable throwable) {
        return StorageException.fromExceptionAndHttpCode(throwable, 0);
    }

    public static com.google.firebase.storage.StorageException fromExceptionAndHttpCode(Throwable throwable, int i2) {
        if (throwable instanceof StorageException != null) {
            return (StorageException)throwable;
        }
        if (StorageException.isResultSuccess(i2) != null && throwable == null) {
            if (throwable == null) {
                return null;
            }
        }
        StorageException storageException = new StorageException(StorageException.calculateErrorCode(throwable, i2), throwable, i2);
        return storageException;
    }

    static String getErrorMessageForCode(int i) {
        if (i != -13040 && i != -13031 && i != -13030 && i != -13021 && i != -13020) {
            if (i != -13031) {
                if (i != -13030) {
                    if (i != -13021) {
                        if (i != -13020) {
                            switch (i) {
                                case -13013:
                                    return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
                                case -13012:
                                    return "Project does not exist.";
                                case -13011:
                                    return "Bucket does not exist.";
                                case -13010:
                                    return "Object does not exist at location.";
                                default:
                                    return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
                            }
                        }
                        return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
                    }
                    return "User does not have permission to access this object.";
                }
                return "The operation retry limit has been exceeded.";
            }
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        return "The operation was cancelled.";
    }

    private static boolean isResultSuccess(int i) {
        int i2;
        int obj1;
        if (i != 0) {
            if (i >= 200 && i < 300) {
                if (i < 300) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    @Override // com.google.firebase.FirebaseException
    public Throwable getCause() {
        Throwable cause = this.cause;
        synchronized (this) {
            try {
                return null;
                return cause;
            }
        }
    }

    @Override // com.google.firebase.FirebaseException
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // com.google.firebase.FirebaseException
    public int getHttpResultCode() {
        return this.httpResultCode;
    }

    @Override // com.google.firebase.FirebaseException
    public boolean getIsRecoverableException() {
        int i;
        i = getErrorCode() == -13030 ? 1 : 0;
        return i;
    }
}
