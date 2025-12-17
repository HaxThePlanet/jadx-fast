package androidx.compose.animation.core;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0001\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a=\u0010\u0007\u001a\u0002H\u0008\"\u0008\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0010\u0002\u001a\u0004\u0018\u0001H\u00082\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\u0008\u0082\u0002\n\n\u0008\u0008\u0000\u001a\u0004\u0008\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a*\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a\u0010\u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0000¨\u0006\u0011", d2 = {"checkPrecondition", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkPreconditionNotNull", "T", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requirePrecondition", "throwIllegalArgumentException", "message", "throwIllegalStateException", "throwIllegalStateExceptionForNullCheck", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PreconditionsKt {
    public static final void checkPrecondition(boolean value, Function0<String> lazyMessage) {
        Object invoke;
        final int i = 0;
        if (value == null) {
            PreconditionsKt.throwIllegalStateException((String)lazyMessage.invoke());
        }
    }

    public static final <T> T checkPreconditionNotNull(T value, Function0<String> lazyMessage) {
        final int i = 0;
        if (value == 0) {
        } else {
            return value;
        }
        PreconditionsKt.throwIllegalStateExceptionForNullCheck((String)lazyMessage.invoke());
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
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

    public static final Void throwIllegalStateExceptionForNullCheck(String message) {
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw illegalStateException;
    }
}
