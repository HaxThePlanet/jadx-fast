package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014JE\u0010\u0015\u001a\u0002H\u0016\"\u0004\u0008\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\u0008\u001dH\u0096@¢\u0006\u0002\u0010\u001eJG\u0010\u001f\u001a\u0004\u0018\u0001H\u0016\"\u0004\u0008\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\u0008\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\tR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006 À\u0006\u0003", d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AwaitPointerEventScope extends Density {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object awaitPointerEvent$default(androidx.compose.ui.input.pointer.AwaitPointerEventScope awaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass pointerEventPass2, Continuation continuation3, int i4, Object object5) {
            return AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass2, continuation3, i4, object5);
        }

        @Deprecated
        public static long getExtendedTouchPadding-NH-jbRc(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this) {
            return AwaitPointerEventScope.access$getExtendedTouchPadding-NH-jbRc$jd($this);
        }

        @Deprecated
        public static int roundToPx--R2X_6o(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
            return AwaitPointerEventScope.access$roundToPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static int roundToPx-0680j_4(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
            return AwaitPointerEventScope.access$roundToPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
            return AwaitPointerEventScope.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
            return AwaitPointerEventScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, int $receiver) {
            return AwaitPointerEventScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static long toDpSize-k-rfVVM(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
            return AwaitPointerEventScope.access$toDpSize-k-rfVVM$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx--R2X_6o(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
            return AwaitPointerEventScope.access$toPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx-0680j_4(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
            return AwaitPointerEventScope.access$toPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, DpRect $receiver) {
            return AwaitPointerEventScope.access$toRect$jd($this, $receiver);
        }

        @Deprecated
        public static long toSize-XkaWNTQ(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
            return AwaitPointerEventScope.access$toSize-XkaWNTQ$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
            return AwaitPointerEventScope.access$toSp-0xMU5do$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
            return AwaitPointerEventScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, int $receiver) {
            return AwaitPointerEventScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static <T> Object withTimeout(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long timeMillis, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
            return AwaitPointerEventScope.access$withTimeout$jd($this, timeMillis, block, $completion);
        }

        @Deprecated
        public static <T> Object withTimeoutOrNull(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long timeMillis, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
            return AwaitPointerEventScope.access$withTimeoutOrNull$jd($this, timeMillis, block, $completion);
        }
    }
    public static long access$getExtendedTouchPadding-NH-jbRc$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this) {
        return super.getExtendedTouchPadding-NH-jbRc();
    }

    public static int access$roundToPx--R2X_6o$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
        return super.roundToPx--R2X_6o($receiver);
    }

    public static int access$roundToPx-0680j_4$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
        return super.roundToPx-0680j_4($receiver);
    }

    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, int $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static long access$toDpSize-k-rfVVM$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
        return super.toDpSize-k-rfVVM($receiver);
    }

    public static float access$toPx--R2X_6o$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
        return super.toPx--R2X_6o($receiver);
    }

    public static float access$toPx-0680j_4$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
        return super.toPx-0680j_4($receiver);
    }

    public static Rect access$toRect$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, DpRect $receiver) {
        return super.toRect($receiver);
    }

    public static long access$toSize-XkaWNTQ$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long $receiver) {
        return super.toSize-XkaWNTQ($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, float $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, int $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static Object access$withTimeout$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long timeMillis, Function2 block, Continuation $completion) {
        return super.withTimeout(timeMillis, block, $completion);
    }

    public static Object access$withTimeoutOrNull$jd(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long timeMillis, Function2 block, Continuation $completion) {
        return super.withTimeoutOrNull(timeMillis, block, $completion);
    }

    public static Object awaitPointerEvent$default(androidx.compose.ui.input.pointer.AwaitPointerEventScope awaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass pointerEventPass2, Continuation continuation3, int i4, Object object5) {
        androidx.compose.ui.input.pointer.PointerEventPass obj1;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj1 = PointerEventPass.Main;
            }
            return awaitPointerEventScope.awaitPointerEvent(obj1, continuation3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        throw obj0;
    }

    public static <T> Object withTimeout$suspendImpl(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long timeMillis, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        return $completion.invoke($this, obj5);
    }

    public static <T> Object withTimeoutOrNull$suspendImpl(androidx.compose.ui.input.pointer.AwaitPointerEventScope $this, long timeMillis, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        return $completion.invoke($this, obj5);
    }

    public abstract Object awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass pointerEventPass, Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> continuation2);

    @Override // androidx.compose.ui.unit.Density
    public abstract androidx.compose.ui.input.pointer.PointerEvent getCurrentEvent();

    @Override // androidx.compose.ui.unit.Density
    public long getExtendedTouchPadding-NH-jbRc() {
        return Size.Companion.getZero-NH-jbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract long getSize-YbymL2g();

    @Override // androidx.compose.ui.unit.Density
    public abstract ViewConfiguration getViewConfiguration();

    public <T> Object withTimeout(long l, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function22, Continuation<? super T> continuation3) {
        return AwaitPointerEventScope.withTimeout$suspendImpl(this, l, function22, continuation3);
    }

    public <T> Object withTimeoutOrNull(long l, Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function22, Continuation<? super T> continuation3) {
        return AwaitPointerEventScope.withTimeoutOrNull$suspendImpl(this, l, function22, continuation3);
    }
}
