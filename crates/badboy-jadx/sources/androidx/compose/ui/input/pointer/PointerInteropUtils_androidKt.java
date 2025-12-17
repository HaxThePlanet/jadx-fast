package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000\u001a2\u0010\u0007\u001a\u00020\u0001*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000c\u001a:\u0010\r\u001a\u00020\u0001*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"emptyCancelMotionEventScope", "", "nowMillis", "", "block", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "toCancelMotionEventScope", "Landroidx/compose/ui/input/pointer/PointerEvent;", "offset", "Landroidx/compose/ui/geometry/Offset;", "toCancelMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;)V", "toMotionEventScope", "toMotionEventScope-d-4ec7I", "cancel", "", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;Z)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long nowMillis, Function1<? super MotionEvent, Unit> block) {
        final MotionEvent obj8 = MotionEvent.obtain(nowMillis, obj1, nowMillis, obj3, 3, 0);
        obj8.setSource(0);
        obj10.invoke(obj8);
        obj8.recycle();
    }

    public static void emptyCancelMotionEventScope$default(long l, Function1 function12, int i3, Object object4) {
        long obj0;
        if (object4 &= 1 != 0) {
            obj0 = SystemClock.uptimeMillis();
        }
        PointerInteropUtils_androidKt.emptyCancelMotionEventScope(obj0, function12);
    }

    public static final void toCancelMotionEventScope-d-4ec7I(androidx.compose.ui.input.pointer.PointerEvent $this$toCancelMotionEventScope_u2dd_u2d4ec7I, long offset, Function1<? super MotionEvent, Unit> block) {
        PointerInteropUtils_androidKt.toMotionEventScope-ubNVwUQ($this$toCancelMotionEventScope_u2dd_u2d4ec7I, offset, block, obj4);
    }

    public static final void toMotionEventScope-d-4ec7I(androidx.compose.ui.input.pointer.PointerEvent $this$toMotionEventScope_u2dd_u2d4ec7I, long offset, Function1<? super MotionEvent, Unit> block) {
        PointerInteropUtils_androidKt.toMotionEventScope-ubNVwUQ($this$toMotionEventScope_u2dd_u2d4ec7I, offset, block, obj4);
    }

    private static final void toMotionEventScope-ubNVwUQ(androidx.compose.ui.input.pointer.PointerEvent $this$toMotionEventScope_u2dubNVwUQ, long offset, Function1<? super MotionEvent, Unit> block, boolean cancel) {
        int i;
        final MotionEvent motionEvent$ui_release = $this$toMotionEventScope_u2dubNVwUQ.getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
        } else {
            MotionEvent motionEvent = motionEvent$ui_release;
            int i3 = 0;
            if (obj10 != null) {
                motionEvent.setAction(3);
            }
            motionEvent.offsetLocation(-x-impl, -y-impl);
            cancel.invoke(motionEvent);
            motionEvent.offsetLocation(Offset.getX-impl(offset), Offset.getY-impl(offset));
            motionEvent.setAction(motionEvent.getAction());
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireNotNullPointerInteropUtils_androidKt$toMotionEventScope$1 = new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
        throw $i$a$RequireNotNullPointerInteropUtils_androidKt$toMotionEventScope$1;
    }
}
