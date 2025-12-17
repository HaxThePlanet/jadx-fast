package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u001a*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a*\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0008H\u0000\u001a\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0008H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"DualFloatSignBit", "", "checkPrecondition", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "requirePrecondition", "throwIllegalArgumentException", "message", "throwIllegalStateException", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InlineClassHelperKt {

    public static final long DualFloatSignBit = -9223372034707292160L;
    public static final void checkPrecondition(boolean value, Function0<String> lazyMessage) {
        Object invoke;
        final int i = 0;
        if (value == null) {
            InlineClassHelperKt.throwIllegalStateException((String)lazyMessage.invoke());
        }
    }

    public static final void requirePrecondition(boolean value, Function0<String> lazyMessage) {
        Object invoke;
        final int i = 0;
        if (value == null) {
            InlineClassHelperKt.throwIllegalArgumentException((String)lazyMessage.invoke());
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
