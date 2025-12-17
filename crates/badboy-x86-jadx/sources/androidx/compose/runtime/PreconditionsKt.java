package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a*\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a\u0010\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0006H\u0000¨\u0006\u000b", d2 = {"checkPrecondition", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "requirePrecondition", "throwIllegalArgumentException", "message", "throwIllegalStateException", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PreconditionsKt {
    public static final void checkPrecondition(boolean value) {
        String str;
        final int i = 0;
        if (value == null) {
            PreconditionsKt.throwIllegalStateException("Check failed.");
        }
    }

    public static final void checkPrecondition(boolean value, Function0<String> lazyMessage) {
        Object invoke;
        final int i = 0;
        if (value == null) {
            PreconditionsKt.throwIllegalStateException((String)lazyMessage.invoke());
        }
    }

    public static final void requirePrecondition(boolean value, Function0<String> lazyMessage) {
        Object invoke;
        final int i = 0;
        if (value == null) {
            PreconditionsKt.throwIllegalArgumentException((String)lazyMessage.invoke());
        }
    }

    public static final void throwIllegalArgumentException(String message) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(message);
        throw illegalArgumentException;
    }

    public static final void throwIllegalStateException(String message) {
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw illegalStateException;
    }
}
