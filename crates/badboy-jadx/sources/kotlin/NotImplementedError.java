package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        final int i = 0;
        super(i, 1, i);
    }

    public NotImplementedError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        super(message);
    }

    public NotImplementedError(String string, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        String obj1;
        obj1 = i2 &= 1 != 0 ? "An operation is not implemented." : obj1;
        super(obj1);
    }
}
