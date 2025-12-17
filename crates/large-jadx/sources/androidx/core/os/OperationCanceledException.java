package androidx.core.os;

import d.h.k.c;

/* loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        super(0);
    }

    public OperationCanceledException(String string) {
        super(c.c(string, "The operation has been canceled."));
    }
}
