package androidx.core.os;

import androidx.core.util.ObjectsCompat;

/* loaded from: classes5.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        super(0);
    }

    public OperationCanceledException(String message) {
        super(ObjectsCompat.toString(message, "The operation has been canceled."));
    }
}
