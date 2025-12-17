package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0001\n\u0002\u0008\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u0007\u001a\u0002H\u0008\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00062\u0008\u0010\u0002\u001a\u0004\u0018\u0001H\u0008H\u0087\u0008\u0082\u0002\n\n\u0008\u0008\u0000\u001a\u0004\u0008\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u0007\u001a\u0002H\u0008\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00062\u0008\u0010\u0002\u001a\u0004\u0018\u0001H\u00082\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0000\u001a\u0004\u0008\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0006H\u0087\u0008\u001a\u001c\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0008\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a-\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0000\u001a\u0002\u0010\u0001\u001a/\u0010\u000f\u001a\u0002H\u0008\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00062\u0008\u0010\u0002\u001a\u0004\u0018\u0001H\u0008H\u0087\u0008\u0082\u0002\n\n\u0008\u0008\u0000\u001a\u0004\u0008\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u000f\u001a\u0002H\u0008\"\u0008\u0008\u0000\u0010\u0008*\u00020\u00062\u0008\u0010\u0002\u001a\u0004\u0018\u0001H\u00082\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0000\u001a\u0004\u0008\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0010", d2 = {"check", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "error", "", "message", "require", "requireNotNull", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/PreconditionsKt")
class PreconditionsKt__PreconditionsKt extends kotlin.PreconditionsKt__AssertionsJVMKt {
    private static final void check(boolean value) {
        if (value == null) {
        } else {
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    private static final void check(boolean value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (value == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException(lazyMessage.invoke().toString());
        throw illegalStateException;
    }

    private static final <T> T checkNotNull(T value) {
        if (value == 0) {
        } else {
            return value;
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
        throw illegalStateException;
    }

    private static final <T> T checkNotNull(T value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (value == 0) {
        } else {
            return value;
        }
        IllegalStateException illegalStateException = new IllegalStateException(lazyMessage.invoke().toString());
        throw illegalStateException;
    }

    private static final Void error(Object message) {
        Intrinsics.checkNotNullParameter(message, "message");
        IllegalStateException illegalStateException = new IllegalStateException(message.toString());
        throw illegalStateException;
    }

    private static final void require(boolean value) {
        if (value == null) {
        } else {
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    private static final void require(boolean value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (value == null) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(lazyMessage.invoke().toString());
        throw illegalArgumentException;
    }

    private static final <T> T requireNotNull(T value) {
        if (value == 0) {
        } else {
            return value;
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Required value was null.".toString());
        throw illegalArgumentException;
    }

    private static final <T> T requireNotNull(T value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (value == 0) {
        } else {
            return value;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(lazyMessage.invoke().toString());
        throw illegalArgumentException;
    }
}
