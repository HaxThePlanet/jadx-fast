package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&JA\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015¢\u0006\u0002\u0008\u0018H¦@¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0012\u0010\u0008\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u001aÀ\u0006\u0003", d2 = {"Landroidx/compose/foundation/gestures/ScrollableState;", "", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollForward", "getCanScrollForward", "isScrollInProgress", "lastScrolledBackward", "getLastScrolledBackward", "lastScrolledForward", "getLastScrolledForward", "dispatchRawDelta", "", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScrollableState {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getCanScrollBackward(androidx.compose.foundation.gestures.ScrollableState $this) {
            return ScrollableState.access$getCanScrollBackward$jd($this);
        }

        @Deprecated
        public static boolean getCanScrollForward(androidx.compose.foundation.gestures.ScrollableState $this) {
            return ScrollableState.access$getCanScrollForward$jd($this);
        }

        @Deprecated
        public static boolean getLastScrolledBackward(androidx.compose.foundation.gestures.ScrollableState $this) {
            return ScrollableState.access$getLastScrolledBackward$jd($this);
        }

        @Deprecated
        public static boolean getLastScrolledForward(androidx.compose.foundation.gestures.ScrollableState $this) {
            return ScrollableState.access$getLastScrolledForward$jd($this);
        }

        public static Object scroll$default(androidx.compose.foundation.gestures.ScrollableState scrollableState, MutatePriority mutatePriority2, Function2 function23, Continuation continuation4, int i5, Object object6) {
            return ScrollableState.scroll$default(scrollableState, mutatePriority2, function23, continuation4, i5, object6);
        }
    }
    public static boolean access$getCanScrollBackward$jd(androidx.compose.foundation.gestures.ScrollableState $this) {
        return super.getCanScrollBackward();
    }

    public static boolean access$getCanScrollForward$jd(androidx.compose.foundation.gestures.ScrollableState $this) {
        return super.getCanScrollForward();
    }

    public static boolean access$getLastScrolledBackward$jd(androidx.compose.foundation.gestures.ScrollableState $this) {
        return super.getLastScrolledBackward();
    }

    public static boolean access$getLastScrolledForward$jd(androidx.compose.foundation.gestures.ScrollableState $this) {
        return super.getLastScrolledForward();
    }

    public static Object scroll$default(androidx.compose.foundation.gestures.ScrollableState scrollableState, MutatePriority mutatePriority2, Function2 function23, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (object6 != null) {
        } else {
            if (i5 &= 1 != 0) {
                obj1 = MutatePriority.Default;
            }
            return scrollableState.scroll(obj1, function23, continuation4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
        throw obj0;
    }

    public abstract float dispatchRawDelta(float f);

    public boolean getCanScrollBackward() {
        return 1;
    }

    public boolean getCanScrollForward() {
        return 1;
    }

    public boolean getLastScrolledBackward() {
        return 0;
    }

    public boolean getLastScrolledForward() {
        return 0;
    }

    public abstract boolean isScrollInProgress();

    public abstract Object scroll(MutatePriority mutatePriority, Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3);
}
