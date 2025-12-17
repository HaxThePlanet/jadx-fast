package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0008\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0007", d2 = {"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/PreconditionsKt")
class PreconditionsKt__AssertionsJVMKt {
    private static final void assert(boolean value) {
        if (value == null) {
        } else {
        }
        int i = 0;
        AssertionError $i$a$AssertPreconditionsKt__AssertionsJVMKt$assert$1 = new AssertionError("Assertion failed");
        throw $i$a$AssertPreconditionsKt__AssertionsJVMKt$assert$1;
    }

    private static final void assert(boolean value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (value == null) {
        } else {
        }
        AssertionError assertionError = new AssertionError(lazyMessage.invoke());
        throw assertionError;
    }
}
