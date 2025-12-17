package androidx.compose.foundation.gestures;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/gestures/GestureCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "message", "", "(Ljava/lang/String;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GestureCancellationException extends CancellationException {

    public static final int $stable;
    static {
    }

    public GestureCancellationException() {
        final int i = 0;
        super(i, 1, i);
    }

    public GestureCancellationException(String message) {
        super(message);
    }

    public GestureCancellationException(String string, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }
}
