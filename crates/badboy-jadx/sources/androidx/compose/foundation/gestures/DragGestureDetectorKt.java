package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.PointerType.Companion;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a!\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a5\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0082Hø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u000c\u001aa\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001aY\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001a!\u0010%\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008&\u0010\u000c\u001aM\u0010'\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010(\u001a\u0004\u0018\u00010)2\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u0019H\u0082Hø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\u001aY\u0010-\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110*¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008.\u0010$\u001a!\u0010/\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\u00080\u0010\u000c\u001aa\u00101\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\u00082\u0010 \u001aY\u00103\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\u00084\u0010$\u001a\u0080\u0001\u00105\u001a\u00020\u001e*\u0002062\u0014\u0008\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\u0008\u0002\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001e092\u000e\u0008\u0002\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110*¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001aË\u0001\u00105\u001a\u00020\u001e*\u00020626\u00107\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110*¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(>\u0012\u0004\u0012\u00020\u001e0\u00192!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u001e0\u000f2\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u001e092\u000c\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\u0010092\u0008\u0010@\u001a\u0004\u0018\u00010)26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110*¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@¢\u0006\u0002\u0010A\u001a\u0080\u0001\u0010B\u001a\u00020\u001e*\u0002062\u0014\u0008\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\u0008\u0002\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001e092\u000e\u0008\u0002\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110*¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a\u0080\u0001\u0010C\u001a\u00020\u001e*\u0002062\u0014\u0008\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\u0008\u0002\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001e092\u000e\u0008\u0002\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u001e0926\u0010D\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a\u0080\u0001\u0010E\u001a\u00020\u001e*\u0002062\u0014\u0008\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\u0008\u0002\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001e092\u000e\u0008\u0002\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u001e0926\u0010F\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a3\u0010G\u001a\u00020\u0010*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008H\u0010\u0012\u001aS\u0010G\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000f2\u0008\u0010(\u001a\u0004\u0018\u00010)2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0080Hø\u0001\u0000¢\u0006\u0004\u0008J\u0010K\u001a3\u0010L\u001a\u00020\u0010*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008M\u0010\u0012\u001a\u001e\u0010N\u001a\u00020\u0010*\u00020O2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008P\u0010Q\u001a\u001e\u0010R\u001a\u00020\u0005*\u00020S2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\u0008T\u0010U\u001a3\u0010V\u001a\u00020\u0010*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008W\u0010\u0012\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006X", d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialDelta", "shouldAwaitTouchSlop", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragGestureDetectorKt {

    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;
    static {
        int i3 = 0;
        DragGestureDetectorKt.mouseSlop = Dp.constructor-impl((float)l);
        int i2 = 0;
        DragGestureDetectorKt.defaultTouchSlop = Dp.constructor-impl((float)i);
        int i4 = 0;
        DragGestureDetectorKt.mouseToTouchSlopRatio = mouseSlop /= defaultTouchSlop;
    }

    public static final boolean access$isPointerUp-DmW0f2w(PointerEvent $receiver, long pointerId) {
        return DragGestureDetectorKt.isPointerUp-DmW0f2w($receiver, pointerId);
    }

    public static final Object awaitDragOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj5;
        Object $result;
        boolean anon2;
        Object $continuation2;
        int i3;
        Object $continuation;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitDragOrCancellation.1 anon3;
        int i6;
        int $this$awaitDragOrUp_u2djO51t88$iv;
        Object $i$f$awaitDragOrUpJO51t88;
        int id-J3iCeTQ;
        int i;
        int index$iv$iv$iv2;
        int i5;
        Ref.LongRef pointerId;
        int pointer$iv2;
        Object pointer$iv;
        Object $this$awaitDragOrUp_u2djO51t88$iv2;
        int obj4;
        Ref.LongRef longRef;
        int i7;
        int i4;
        int index$iv$iv$iv;
        int it$iv;
        Object obj2;
        Object obj;
        int i8;
        Object obj3;
        int i2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitDragOrCancellation.1 anon;
        Object obj20;
        Object obj21;
        obj5 = obj23;
        anon2 = obj5;
        i6 = Integer.MIN_VALUE;
        if (obj5 instanceof DragGestureDetectorKt.awaitDragOrCancellation.1 && label2 &= i6 != 0) {
            anon2 = obj5;
            i6 = Integer.MIN_VALUE;
            if (label2 &= i6 != 0) {
                anon2.label = label -= i6;
            } else {
                anon2 = new DragGestureDetectorKt.awaitDragOrCancellation.1(obj5);
            }
        } else {
        }
        $result = anon2.result;
        id-J3iCeTQ = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object obj8 = awaitPointerEventScope;
                PointerEvent pointerEvent = l2;
                return null;
                longRef = new Ref.LongRef();
                longRef.element = pointerEvent;
                pointer$iv = obj8;
                $this$awaitDragOrUp_u2djO51t88$iv = obj4;
                pointerId = longRef;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj4 = l$0;
                $this$awaitDragOrUp_u2djO51t88$iv2 = l$1;
                pointer$iv2 = i10;
                $i$f$awaitDragOrUpJO51t88 = $continuation;
                anon3 = anon2;
                $continuation2 = $result;
                longRef = (PointerEvent)$result.getChanges();
                i7 = 0;
                i4 = 0;
                index$iv$iv$iv = 0;
                i8 = 0;
                i2 = 0;
                index$iv$iv$iv++;
                $result = obj21;
                id-J3iCeTQ = 1;
                index$iv$iv$iv2 = 0;
                $continuation2 = obj20;
                obj21 = $result;
                obj20 = $continuation2;
                obj = 0;
                obj = 0;
                List changes = obj21.getChanges();
                $continuation2 = 0;
                id-J3iCeTQ = 0;
                index$iv$iv$iv2 = 0;
                index$iv$iv$iv = 0;
                obj2 = null;
                index$iv$iv$iv2++;
                i4 = 0;
                $result = i4;
                $this$awaitDragOrUp_u2djO51t88$iv2.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation2 = 0;
                i = 1;
                i = i9;
                i5 = obj;
                i5 = 0;
                return i5;
                $result = obj20;
                anon2 = anon3;
                $continuation = $i$f$awaitDragOrUpJO51t88;
                $this$awaitDragOrUp_u2djO51t88$iv = pointer$iv2;
                pointerId = $this$awaitDragOrUp_u2djO51t88$iv2;
                pointer$iv = obj4;
                id-J3iCeTQ = 1;
                index$iv$iv$iv2 = 0;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        anon2.L$0 = pointer$iv;
        anon2.L$1 = pointerId;
        anon2.label = id-J3iCeTQ;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv, index$iv$iv$iv2, anon2, id-J3iCeTQ, index$iv$iv$iv2);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            obj4 = pointer$iv;
            $this$awaitDragOrUp_u2djO51t88$iv2 = pointerId;
            pointer$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
            $i$f$awaitDragOrUpJO51t88 = $continuation;
            anon3 = anon;
        }
        return $continuation;
    }

    private static final Object awaitDragOrUp-jO51t88(AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Boolean> hasDragged, Continuation<? super PointerInputChange> $completion) {
        long booleanValue2;
        Object otherDown;
        long booleanValue;
        int $this$fastForEach$iv$iv;
        int awaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope;
        Continuation continuation;
        int index$iv$iv;
        int size;
        List list;
        int i3;
        int index$iv$iv2;
        int booleanValue3;
        Object obj2;
        Object obj4;
        int pressed;
        Object obj3;
        int i;
        int i2;
        Object obj;
        final int i4 = 0;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = pointerId;
        while (/* condition */) {
            while (index$iv$iv2 < booleanValue3) {
                pressed = 0;
                i = 0;
                Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv2).getId-J3iCeTQ(), awaitPointerEvent$default));
                booleanValue = valueOf;
                index$iv$iv2++;
                booleanValue2 = pointerId;
                $this$fastForEach$iv$iv = i2;
                awaitPointerEvent$default = obj;
            }
            obj = awaitPointerEvent$default;
            obj4 = i2;
            booleanValue2 = pointerId;
            $this$fastForEach$iv$iv = 0;
            size = 0;
            list = index$iv$iv;
            i3 = 0;
            index$iv$iv2 = 0;
            int i5 = 0;
            List list2 = changes;
            awaitPointerEvent$default = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list2.size()) {
                i3 = list;
                index$iv$iv2 = 0;
                int i8 = 0;
                Boolean valueOf2 = Boolean.valueOf((PointerInputChange)i3.getPressed());
                obj2 = valueOf2;
                index$iv$iv++;
            }
            $this$fastForEach$iv$iv = i2;
            int $this$fastFirstOrNull$iv = $this$fastForEach$iv$iv;
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv.getId-J3iCeTQ();
            otherDown = $completion;
            i3 = list;
            index$iv$iv2 = 0;
            i8 = 0;
            valueOf2 = Boolean.valueOf((PointerInputChange)i3.getPressed());
            obj2 = valueOf2;
            if (valueOf2.booleanValue() != 0) {
            } else {
            }
            index$iv$iv++;
            $this$fastForEach$iv$iv = i3;
            pressed = 0;
            i = 0;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv2).getId-J3iCeTQ(), awaitPointerEvent$default));
            booleanValue = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            index$iv$iv2++;
            booleanValue2 = pointerId;
            $this$fastForEach$iv$iv = i2;
            awaitPointerEvent$default = obj;
        }
        Object obj5 = $completion;
        return i2;
    }

    public static final Object awaitHorizontalDragOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj3;
        Object $result;
        boolean anon2;
        Object $continuation;
        int i;
        Object $continuation2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1 anon3;
        int i4;
        int $this$awaitDragOrUp_u2djO51t88$iv2;
        Object $i$f$awaitDragOrUpJO51t88;
        int id-J3iCeTQ;
        int i7;
        int cmp;
        int i3;
        Ref.LongRef pointerId;
        int pointer$iv;
        Object pointer$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv;
        int obj2;
        Ref.LongRef index$iv$iv$iv2;
        int size;
        int i6;
        int index$iv$iv$iv;
        int size2;
        Object it$iv;
        Object obj4;
        int i2;
        Object obj;
        int i5;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1 anon;
        Object obj20;
        Object obj21;
        obj3 = obj23;
        anon2 = obj3;
        i4 = Integer.MIN_VALUE;
        if (obj3 instanceof DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1 && label2 &= i4 != 0) {
            anon2 = obj3;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                anon2.label = label -= i4;
            } else {
                anon2 = new DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1(obj3);
            }
        } else {
        }
        $result = anon2.result;
        id-J3iCeTQ = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object obj7 = awaitPointerEventScope;
                PointerEvent pointerEvent = l2;
                return null;
                index$iv$iv$iv2 = new Ref.LongRef();
                index$iv$iv$iv2.element = pointerEvent;
                pointer$iv2 = obj7;
                $this$awaitDragOrUp_u2djO51t88$iv2 = obj2;
                pointerId = index$iv$iv$iv2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj2 = l$0;
                $this$awaitDragOrUp_u2djO51t88$iv = l$1;
                pointer$iv = i9;
                $i$f$awaitDragOrUpJO51t88 = $continuation2;
                anon3 = anon2;
                $continuation = $result;
                index$iv$iv$iv2 = (PointerEvent)$result.getChanges();
                i6 = 0;
                index$iv$iv$iv = 0;
                i2 = 0;
                i5 = 0;
                index$iv$iv$iv++;
                $result = obj21;
                id-J3iCeTQ = 1;
                cmp = 0;
                $continuation = obj20;
                obj21 = $result;
                obj20 = $continuation;
                obj4 = 0;
                int i8 = 0;
                obj4 = 0;
                List changes = obj21.getChanges();
                id-J3iCeTQ = 0;
                cmp = 0;
                index$iv$iv$iv2 = 0;
                size2 = 0;
                i2 = 0;
                index$iv$iv$iv2++;
                index$iv$iv$iv = 0;
                $continuation = index$iv$iv$iv;
                $this$awaitDragOrUp_u2djO51t88$iv.element = (PointerInputChange)$continuation.getId-J3iCeTQ();
                id-J3iCeTQ = 0;
                $continuation = 1;
                $continuation = i8;
                i7 = 1;
                i7 = i8;
                i3 = obj4;
                i3 = 0;
                return i3;
                $result = obj20;
                anon2 = anon3;
                $continuation2 = $i$f$awaitDragOrUpJO51t88;
                $this$awaitDragOrUp_u2djO51t88$iv2 = pointer$iv;
                pointerId = $this$awaitDragOrUp_u2djO51t88$iv;
                pointer$iv2 = obj2;
                id-J3iCeTQ = 1;
                cmp = 0;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        anon2.L$0 = pointer$iv2;
        anon2.L$1 = pointerId;
        anon2.label = id-J3iCeTQ;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv2, cmp, anon2, id-J3iCeTQ, cmp);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            obj2 = pointer$iv2;
            $this$awaitDragOrUp_u2djO51t88$iv = pointerId;
            pointer$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
            $i$f$awaitDragOrUpJO51t88 = $continuation2;
            anon3 = anon;
        }
        return $continuation2;
    }

    public static final Object awaitHorizontalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Function2<? super PointerInputChange, ? super Float, Unit> function24, Continuation<? super PointerInputChange> continuation5) {
        Object obj2;
        Object $result;
        int obj5;
        boolean anon2;
        Object $continuation;
        int consumed;
        int i5;
        Object $continuation2;
        int i;
        Object $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        int id-J3iCeTQ2;
        long id-J3iCeTQ;
        int touchSlop$iv2;
        Object pointerId;
        long touchSlop$iv;
        int pointer$iv;
        androidx.compose.foundation.gestures.Orientation horizontal;
        int onPointerSlopReached;
        boolean longRef;
        int boxFloat;
        int onPointerSlopReached2;
        int index$iv$iv$iv;
        int it$iv;
        Object obj;
        Object obj3;
        int i2;
        Object obj4;
        int i4;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalPointerSlopOrCancellation.1 anon;
        Object obj22;
        Object obj23;
        Object obj24;
        obj2 = obj27;
        anon2 = obj2;
        i = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.awaitHorizontalPointerSlopOrCancellation.1 && label2 &= i != 0) {
            anon2 = obj2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon2.label = label -= i;
            } else {
                anon2 = new DragGestureDetectorKt.awaitHorizontalPointerSlopOrCancellation.1(obj2);
            }
        } else {
        }
        $result = anon2.result;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = awaitPointerEventScope;
                touchSlop$iv2 = continuation5;
                pointerId = l2;
                onPointerSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($i$f$awaitPointerSlopOrCancellationPn7EDYM.getViewConfiguration(), function24);
                longRef = new Ref.LongRef();
                longRef.element = pointerId;
                pointerId = new TouchSlopDetector(Orientation.Horizontal);
                return id-J3iCeTQ2;
            case 1:
                pointerId = anon2.L$3;
                pointer$iv = anon2.L$1;
                ResultKt.throwOnFailure($result);
                onPointerSlopReached = $i$f$awaitPointerSlopOrCancellationPn7EDYM2;
                longRef = l$2;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
                touchSlop$iv = f$02;
                touchSlop$iv2 = horizontal;
                $continuation2 = anon2;
                $continuation = $result;
                horizontal = (PointerEvent)$result.getChanges();
                boxFloat = 0;
                onPointerSlopReached2 = 0;
                index$iv$iv$iv = 0;
                i2 = 0;
                i4 = 0;
                index$iv$iv$iv++;
                touchSlop$iv2 = obj22;
                $continuation = obj23;
                $result = obj24;
                id-J3iCeTQ2 = 0;
                obj24 = $result;
                obj23 = $continuation;
                obj22 = touchSlop$iv2;
                obj3 = 0;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ2 = 0;
                obj5 = obj3;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ2 = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i7 = 0;
                touchSlop$iv2 = 0;
                index$iv$iv$iv = 0;
                obj = null;
                touchSlop$iv2++;
                onPointerSlopReached2 = 0;
                obj5 = onPointerSlopReached2;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ2 = 0;
                longRef.element = (PointerInputChange)obj5.getId-J3iCeTQ();
                onPointerSlopReached2 = obj22;
                Offset pointerInputChange-GcwITfU = pointerId.addPointerInputChange-GcwITfU(obj5, touchSlop$iv);
                horizontal = 0;
                obj22.invoke(obj5, Boxing.boxFloat(Offset.getX-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ2 = obj5;
                anon2 = $continuation2;
                $result = obj23;
                pointerId.reset();
                $result = obj23;
                anon2 = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                touchSlop$iv2 = onPointerSlopReached2;
                id-J3iCeTQ2 = 0;
                pointer$iv = touchSlop$iv;
                onPointerSlopReached2 = obj22;
                $continuation2.L$0 = onPointerSlopReached2;
                $continuation2.L$1 = pointer$iv;
                $continuation2.L$2 = longRef;
                $continuation2.L$3 = pointerId;
                $continuation2.L$4 = obj5;
                $continuation2.F$0 = touchSlop$iv;
                $continuation2.label = 2;
                return $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                anon2 = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                touchSlop$iv2 = onPointerSlopReached2;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = pointerId;
                pointerId = obj5;
                $result = obj23;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                pointerId = touchSlop$iv;
                id-J3iCeTQ2 = 0;
                break;
            case 2:
                pointerId = anon2.L$4;
                touchSlop$iv = anon2.L$3;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv2 = l$0;
                onPointerSlopReached = i6;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = horizontal;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                pointerId = touchSlop$iv;
                id-J3iCeTQ2 = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon2.L$0 = touchSlop$iv2;
        anon2.L$1 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        anon2.L$2 = longRef;
        anon2.L$3 = pointerId;
        anon2.L$4 = id-J3iCeTQ2;
        anon2.F$0 = pointer$iv;
        int i8 = 1;
        anon2.label = i8;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($i$f$awaitPointerSlopOrCancellationPn7EDYM, id-J3iCeTQ2, anon2, i8, id-J3iCeTQ2);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
            $continuation2 = anon;
        }
        return $continuation2;
    }

    public static final Object awaitHorizontalTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function2<? super PointerInputChange, ? super Float, Unit> function23, Continuation<? super PointerInputChange> continuation4) {
        Object obj;
        Object $result;
        int obj2;
        boolean anon;
        Object $continuation;
        int consumed;
        int i4;
        Object $continuation2;
        int i3;
        Object $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        int id-J3iCeTQ2;
        long id-J3iCeTQ;
        PointerEvent touchSlop$iv;
        long touchSlop$iv2;
        Object touchSlopDetector$iv;
        int pointer$iv;
        androidx.compose.foundation.gestures.Orientation boxFloat;
        int onTouchSlopReached;
        boolean longRef;
        int unbox-impl;
        int i5;
        int index$iv$iv$iv;
        int it$iv;
        Object obj5;
        Object obj3;
        int i;
        Object obj4;
        int i2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalTouchSlopOrCancellation.1 anon2;
        androidx.compose.foundation.gestures.TouchSlopDetector obj22;
        Object obj23;
        Object obj24;
        obj = obj26;
        anon = obj;
        i3 = Integer.MIN_VALUE;
        if (obj instanceof DragGestureDetectorKt.awaitHorizontalTouchSlopOrCancellation.1 && label2 &= i3 != 0) {
            anon = obj;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = label -= i3;
            } else {
                anon = new DragGestureDetectorKt.awaitHorizontalTouchSlopOrCancellation.1(obj);
            }
        } else {
        }
        $result = anon.result;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = awaitPointerEventScope;
                touchSlop$iv = l2;
                touchSlopDetector$iv = continuation4;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($i$f$awaitPointerSlopOrCancellationPn7EDYM.getViewConfiguration(), PointerType.Companion.getTouch-T8wyACA());
                longRef = new Ref.LongRef();
                longRef.element = touchSlop$iv;
                touchSlop$iv = new TouchSlopDetector(Orientation.Horizontal);
                return id-J3iCeTQ2;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                touchSlop$iv2 = f$02;
                touchSlop$iv = obj7;
                onTouchSlopReached = $i$f$awaitPointerSlopOrCancellationPn7EDYM2;
                longRef = l$2;
                touchSlopDetector$iv = boxFloat;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
                $continuation2 = anon;
                $continuation = $result;
                boxFloat = (PointerEvent)$result.getChanges();
                unbox-impl = 0;
                index$iv$iv$iv = 0;
                i = 0;
                i2 = 0;
                index$iv$iv$iv++;
                touchSlop$iv = obj22;
                $continuation = obj23;
                $result = obj24;
                id-J3iCeTQ2 = 0;
                obj24 = $result;
                obj23 = $continuation;
                obj22 = touchSlop$iv;
                obj3 = 0;
                $result = obj23;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                obj2 = obj3;
                $result = obj23;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i7 = 0;
                touchSlop$iv = 0;
                index$iv$iv$iv = 0;
                obj5 = null;
                touchSlop$iv++;
                i5 = 0;
                obj2 = i5;
                $result = obj23;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                longRef.element = (PointerInputChange)obj2.getId-J3iCeTQ();
                touchSlop$iv = obj22;
                touchSlop$iv = obj22;
                Offset pointerInputChange-GcwITfU = touchSlop$iv.addPointerInputChange-GcwITfU(obj2, touchSlop$iv2);
                id-J3iCeTQ = 0;
                touchSlopDetector$iv.invoke(obj2, Boxing.boxFloat(Offset.getX-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ2 = obj2;
                anon = $continuation2;
                $result = obj23;
                touchSlop$iv.reset();
                $result = obj23;
                anon = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                id-J3iCeTQ2 = 0;
                pointer$iv = touchSlop$iv2;
                $continuation2.L$0 = touchSlopDetector$iv;
                $continuation2.L$1 = pointer$iv;
                $continuation2.L$2 = longRef;
                $continuation2.L$3 = touchSlop$iv;
                $continuation2.L$4 = obj2;
                $continuation2.F$0 = touchSlop$iv2;
                $continuation2.label = 2;
                return $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                anon = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                pointer$iv = touchSlop$iv2;
                touchSlop$iv2 = obj2;
                $result = obj23;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                id-J3iCeTQ2 = 0;
                break;
            case 2:
                touchSlop$iv2 = anon.L$4;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv = l$32;
                touchSlopDetector$iv = l$0;
                onTouchSlopReached = i6;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = boxFloat;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                id-J3iCeTQ2 = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon.L$0 = touchSlopDetector$iv;
        anon.L$1 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        anon.L$2 = longRef;
        anon.L$3 = touchSlop$iv;
        anon.L$4 = id-J3iCeTQ2;
        anon.F$0 = pointer$iv;
        int i8 = 1;
        anon.label = i8;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($i$f$awaitPointerSlopOrCancellationPn7EDYM, id-J3iCeTQ2, anon, i8, id-J3iCeTQ2);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv2 = pointer$iv;
            pointer$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
            $continuation2 = anon2;
        }
        return $continuation2;
    }

    public static final Object awaitLongPressOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj4;
        Object cOROUTINE_SUSPENDED;
        boolean anon;
        int i5;
        long l;
        Object obj5;
        int i3;
        Object obj6;
        long objectRef2;
        Ref.ObjectRef objectRef;
        List changes;
        long longPressTimeoutMillis;
        int i;
        int i4;
        Object timeout;
        int index$iv$iv;
        int i7;
        Object obj3;
        Object obj2;
        int i6;
        Object obj;
        int i2;
        int obj17;
        Object obj18;
        obj4 = obj20;
        anon = obj4;
        l = Integer.MIN_VALUE;
        if (obj4 instanceof DragGestureDetectorKt.awaitLongPressOrCancellation.1 && label2 &= l != 0) {
            anon = obj4;
            l = Integer.MIN_VALUE;
            if (label2 &= l != 0) {
                anon.label = label -= l;
            } else {
                anon = new DragGestureDetectorKt.awaitLongPressOrCancellation.1(obj4);
            }
        } else {
        }
        Object result = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                int i8 = awaitPointerEventScope;
                PointerEvent pointerEvent = l2;
                return i3;
                i = 0;
                index$iv$iv = 0;
                i6 = 0;
                i2 = 0;
                index$iv$iv++;
                i = obj17;
                changes = obj18;
                obj18 = changes;
                obj17 = i;
                obj2 = i3;
                return i3;
                obj6 = obj2;
                objectRef2 = new Ref.ObjectRef();
                objectRef = new Ref.ObjectRef();
                objectRef.element = obj6;
                DragGestureDetectorKt.awaitLongPressOrCancellation.2 anon2 = new DragGestureDetectorKt.awaitLongPressOrCancellation.2(objectRef, objectRef2, i3);
                anon.L$0 = obj6;
                anon.L$1 = objectRef2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = objectRef2;
                break;
            case 1:
                obj5 = l$1;
                obj6 = cOROUTINE_SUSPENDED;
                ResultKt.throwOnFailure(result);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        return i3;
    }

    private static final Object awaitPointerSlopOrCancellation-pn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, androidx.compose.foundation.gestures.Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> onPointerSlopReached, Continuation<? super PointerInputChange> $completion) {
        PointerEvent dragEvent;
        int booleanValue;
        long $this$fastFirstOrNull$iv;
        int i7;
        int element;
        Object obj4;
        int i;
        boolean consumed;
        Object awaitPointerEvent$default;
        List changes;
        int index$iv$iv;
        List size;
        int i5;
        int i8;
        int i6;
        int i4;
        int booleanValue2;
        int i3;
        int pressed;
        Object obj;
        int i2;
        final AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
        dragEvent = pointerId;
        final Continuation continuation = obj30;
        final int i10 = 0;
        if (DragGestureDetectorKt.access$isPointerUp-DmW0f2w(awaitPointerEventScope.getCurrentEvent(), dragEvent)) {
            return null;
        }
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = dragEvent;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(onPointerSlopReached);
        while (/* condition */) {
            while (booleanValue < element) {
                Object obj2 = size.get(booleanValue);
                i4 = 0;
                i3 = 0;
                obj = obj2;
                Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)obj2.getId-J3iCeTQ(), obj2));
                $this$fastFirstOrNull$iv = valueOf;
                booleanValue = pressed + 1;
                i = orientation;
                element = i2;
            }
            pressed = booleanValue;
            i8 = i6;
            int i9 = i8;
            $this$fastFirstOrNull$iv = touchSlopDetector.addPointerInputChange-GcwITfU(i9, DragGestureDetectorKt.pointerSlop-E8SPZFQ(awaitPointerEventScope.getViewConfiguration(), orientation));
            obj4 = $completion;
            awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
            dragEvent = pointerId;
            i = orientation;
            i7 = i6;
            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, i7, continuation, 1, i7);
            index$iv$iv = 0;
            size = changes;
            i5 = 0;
            i6 = i7;
            element = size.size();
            booleanValue = i8;
            $completion.invoke(i9, $this$fastFirstOrNull$iv);
            touchSlopDetector.reset();
            int i11 = 0;
            consumed = changes2;
            changes = 0;
            index$iv$iv = 0;
            while (index$iv$iv < consumed.size()) {
                i4 = 0;
                int i14 = 0;
                Boolean valueOf2 = Boolean.valueOf((PointerInputChange)consumed.get(index$iv$iv).getPressed());
                i3 = valueOf2;
                index$iv$iv++;
            }
            i8 = i6;
            $this$fastFirstOrNull$iv = i8;
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv.getId-J3iCeTQ();
            obj4 = $completion;
            i4 = 0;
            i14 = 0;
            valueOf2 = Boolean.valueOf((PointerInputChange)consumed.get(index$iv$iv).getPressed());
            i3 = valueOf2;
            if (valueOf2.booleanValue() != 0) {
            } else {
            }
            index$iv$iv++;
            obj2 = size.get(booleanValue);
            i4 = 0;
            i3 = 0;
            obj = obj2;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)obj2.getId-J3iCeTQ(), obj2));
            $this$fastFirstOrNull$iv = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            booleanValue = pressed + 1;
            i = orientation;
            element = i2;
        }
        Object obj3 = $completion;
        return i6;
    }

    public static final Object awaitTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function2<? super PointerInputChange, ? super Offset, Unit> function23, Continuation<? super PointerInputChange> continuation4) {
        Object obj2;
        Object $result;
        int obj3;
        boolean anon;
        Object $continuation2;
        int consumed;
        int i4;
        Object $continuation;
        int i3;
        Object $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        int id-J3iCeTQ;
        PointerEvent touchSlop$iv;
        long touchSlop$iv2;
        Object touchSlopDetector$iv;
        int pointer$iv;
        int changes;
        int onTouchSlopReached;
        boolean longRef;
        int i;
        int i5;
        int index$iv$iv$iv;
        int it$iv;
        Object obj4;
        Object obj;
        int i2;
        Object obj5;
        int i6;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitTouchSlopOrCancellation.1 anon2;
        androidx.compose.foundation.gestures.TouchSlopDetector obj22;
        Object obj23;
        Object obj24;
        obj2 = obj26;
        anon = obj2;
        i3 = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.awaitTouchSlopOrCancellation.1 && label2 &= i3 != 0) {
            anon = obj2;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = label -= i3;
            } else {
                anon = new DragGestureDetectorKt.awaitTouchSlopOrCancellation.1(obj2);
            }
        } else {
        }
        $result = anon.result;
        id-J3iCeTQ = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = awaitPointerEventScope;
                touchSlop$iv = l2;
                touchSlopDetector$iv = continuation4;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($i$f$awaitPointerSlopOrCancellationPn7EDYM.getViewConfiguration(), PointerType.Companion.getTouch-T8wyACA());
                longRef = new Ref.LongRef();
                longRef.element = touchSlop$iv;
                touchSlop$iv = new TouchSlopDetector(0);
                return id-J3iCeTQ;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                touchSlop$iv2 = f$02;
                touchSlop$iv = obj6;
                onTouchSlopReached = $i$f$awaitPointerSlopOrCancellationPn7EDYM2;
                longRef = l$2;
                touchSlopDetector$iv = changes;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation;
                $continuation = anon;
                $continuation2 = $result;
                changes = (PointerEvent)$result.getChanges();
                i = 0;
                i5 = 0;
                index$iv$iv$iv = 0;
                i2 = 0;
                i6 = 0;
                index$iv$iv$iv++;
                touchSlop$iv = obj22;
                $continuation2 = obj23;
                $result = obj24;
                id-J3iCeTQ = 0;
                obj24 = $result;
                obj23 = $continuation2;
                obj22 = touchSlop$iv;
                obj = 0;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                obj3 = obj;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                List changes2 = obj24.getChanges();
                consumed = 0;
                int i8 = 0;
                touchSlop$iv = 0;
                index$iv$iv$iv = 0;
                obj4 = null;
                touchSlop$iv++;
                i5 = 0;
                obj3 = i5;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                longRef.element = (PointerInputChange)obj3.getId-J3iCeTQ();
                touchSlop$iv = obj22;
                touchSlop$iv = obj22;
                Offset pointerInputChange-GcwITfU = touchSlop$iv.addPointerInputChange-GcwITfU(obj3, touchSlop$iv2);
                touchSlopDetector$iv.invoke(obj3, pointerInputChange-GcwITfU);
                id-J3iCeTQ = obj3;
                anon = $continuation;
                $result = obj23;
                touchSlop$iv.reset();
                $result = obj23;
                anon = $continuation;
                $continuation = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                id-J3iCeTQ = 0;
                pointer$iv = touchSlop$iv2;
                $continuation.L$0 = touchSlopDetector$iv;
                $continuation.L$1 = pointer$iv;
                $continuation.L$2 = longRef;
                $continuation.L$3 = touchSlop$iv;
                $continuation.L$4 = obj3;
                $continuation.F$0 = touchSlop$iv2;
                $continuation.label = 2;
                return $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                anon = $continuation;
                $continuation = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                pointer$iv = touchSlop$iv2;
                touchSlop$iv2 = obj3;
                $result = obj23;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                id-J3iCeTQ = 0;
                break;
            case 2:
                touchSlop$iv2 = anon.L$4;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv = l$32;
                touchSlopDetector$iv = l$0;
                onTouchSlopReached = i7;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = changes;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                id-J3iCeTQ = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon.L$0 = touchSlopDetector$iv;
        anon.L$1 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        anon.L$2 = longRef;
        anon.L$3 = touchSlop$iv;
        anon.L$4 = id-J3iCeTQ;
        anon.F$0 = pointer$iv;
        int i9 = 1;
        anon.label = i9;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($i$f$awaitPointerSlopOrCancellationPn7EDYM, id-J3iCeTQ, anon, i9, id-J3iCeTQ);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv2 = pointer$iv;
            pointer$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation;
            $continuation = anon2;
        }
        return $continuation;
    }

    public static final Object awaitVerticalDragOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj4;
        Object $result;
        boolean anon3;
        Object $continuation;
        int i7;
        Object $continuation2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalDragOrCancellation.1 anon;
        int i3;
        int $this$awaitDragOrUp_u2djO51t88$iv2;
        Object $i$f$awaitDragOrUpJO51t88;
        int id-J3iCeTQ;
        int i4;
        int cmp;
        int i6;
        Ref.LongRef pointerId;
        int pointer$iv;
        Object pointer$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv;
        int obj2;
        Ref.LongRef index$iv$iv$iv;
        int size;
        int i5;
        int index$iv$iv$iv2;
        int size2;
        Object it$iv;
        Object obj3;
        int i;
        Object obj;
        int i2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalDragOrCancellation.1 anon2;
        Object obj20;
        Object obj21;
        obj4 = obj23;
        anon3 = obj4;
        i3 = Integer.MIN_VALUE;
        if (obj4 instanceof DragGestureDetectorKt.awaitVerticalDragOrCancellation.1 && label2 &= i3 != 0) {
            anon3 = obj4;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon3.label = label -= i3;
            } else {
                anon3 = new DragGestureDetectorKt.awaitVerticalDragOrCancellation.1(obj4);
            }
        } else {
        }
        $result = anon3.result;
        id-J3iCeTQ = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object obj7 = awaitPointerEventScope;
                PointerEvent pointerEvent = l2;
                return null;
                index$iv$iv$iv = new Ref.LongRef();
                index$iv$iv$iv.element = pointerEvent;
                pointer$iv2 = obj7;
                $this$awaitDragOrUp_u2djO51t88$iv2 = obj2;
                pointerId = index$iv$iv$iv;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj2 = l$0;
                $this$awaitDragOrUp_u2djO51t88$iv = l$1;
                pointer$iv = i9;
                $i$f$awaitDragOrUpJO51t88 = $continuation2;
                anon = anon3;
                $continuation = $result;
                index$iv$iv$iv = (PointerEvent)$result.getChanges();
                i5 = 0;
                index$iv$iv$iv2 = 0;
                i = 0;
                i2 = 0;
                index$iv$iv$iv2++;
                $result = obj21;
                id-J3iCeTQ = 1;
                cmp = 0;
                $continuation = obj20;
                obj21 = $result;
                obj20 = $continuation;
                obj3 = 0;
                int i8 = 0;
                obj3 = 0;
                List changes = obj21.getChanges();
                id-J3iCeTQ = 0;
                cmp = 0;
                index$iv$iv$iv = 0;
                size2 = 0;
                i = 0;
                index$iv$iv$iv++;
                index$iv$iv$iv2 = 0;
                $continuation = index$iv$iv$iv2;
                $this$awaitDragOrUp_u2djO51t88$iv.element = (PointerInputChange)$continuation.getId-J3iCeTQ();
                id-J3iCeTQ = 0;
                $continuation = 1;
                $continuation = i8;
                i4 = 1;
                i4 = i8;
                i6 = obj3;
                i6 = 0;
                return i6;
                $result = obj20;
                anon3 = anon;
                $continuation2 = $i$f$awaitDragOrUpJO51t88;
                $this$awaitDragOrUp_u2djO51t88$iv2 = pointer$iv;
                pointerId = $this$awaitDragOrUp_u2djO51t88$iv;
                pointer$iv2 = obj2;
                id-J3iCeTQ = 1;
                cmp = 0;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        anon3.L$0 = pointer$iv2;
        anon3.L$1 = pointerId;
        anon3.label = id-J3iCeTQ;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv2, cmp, anon3, id-J3iCeTQ, cmp);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            obj2 = pointer$iv2;
            $this$awaitDragOrUp_u2djO51t88$iv = pointerId;
            pointer$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
            $i$f$awaitDragOrUpJO51t88 = $continuation2;
            anon = anon2;
        }
        return $continuation2;
    }

    public static final Object awaitVerticalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Function2<? super PointerInputChange, ? super Float, Unit> function24, Continuation<? super PointerInputChange> continuation5) {
        Object obj5;
        Object $result;
        int obj;
        boolean anon2;
        Object $continuation;
        int consumed;
        int i2;
        Object $continuation2;
        int i5;
        Object $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        int id-J3iCeTQ;
        long id-J3iCeTQ2;
        int touchSlop$iv;
        Object pointerId;
        long touchSlop$iv2;
        int pointer$iv;
        androidx.compose.foundation.gestures.Orientation vertical;
        int onTouchSlopReached;
        boolean longRef;
        int boxFloat;
        int onTouchSlopReached2;
        int index$iv$iv$iv;
        int it$iv;
        Object obj4;
        Object obj3;
        int i4;
        Object obj2;
        int i;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalPointerSlopOrCancellation.1 anon;
        Object obj22;
        Object obj23;
        Object obj24;
        obj5 = obj27;
        anon2 = obj5;
        i5 = Integer.MIN_VALUE;
        if (obj5 instanceof DragGestureDetectorKt.awaitVerticalPointerSlopOrCancellation.1 && label2 &= i5 != 0) {
            anon2 = obj5;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                anon2.label = label -= i5;
            } else {
                anon2 = new DragGestureDetectorKt.awaitVerticalPointerSlopOrCancellation.1(obj5);
            }
        } else {
        }
        $result = anon2.result;
        id-J3iCeTQ = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = awaitPointerEventScope;
                touchSlop$iv = continuation5;
                pointerId = l2;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($i$f$awaitPointerSlopOrCancellationPn7EDYM.getViewConfiguration(), function24);
                longRef = new Ref.LongRef();
                longRef.element = pointerId;
                pointerId = new TouchSlopDetector(Orientation.Vertical);
                return id-J3iCeTQ;
            case 1:
                pointerId = anon2.L$3;
                pointer$iv = anon2.L$1;
                ResultKt.throwOnFailure($result);
                onTouchSlopReached = $i$f$awaitPointerSlopOrCancellationPn7EDYM2;
                longRef = l$2;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
                touchSlop$iv2 = f$02;
                touchSlop$iv = vertical;
                $continuation2 = anon2;
                $continuation = $result;
                vertical = (PointerEvent)$result.getChanges();
                boxFloat = 0;
                onTouchSlopReached2 = 0;
                index$iv$iv$iv = 0;
                i4 = 0;
                i = 0;
                index$iv$iv$iv++;
                touchSlop$iv = obj22;
                $continuation = obj23;
                $result = obj24;
                id-J3iCeTQ = 0;
                obj24 = $result;
                obj23 = $continuation;
                obj22 = touchSlop$iv;
                obj3 = 0;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ = 0;
                obj = obj3;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i7 = 0;
                touchSlop$iv = 0;
                index$iv$iv$iv = 0;
                obj4 = null;
                touchSlop$iv++;
                onTouchSlopReached2 = 0;
                obj = onTouchSlopReached2;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ = 0;
                longRef.element = (PointerInputChange)obj.getId-J3iCeTQ();
                onTouchSlopReached2 = obj22;
                Offset pointerInputChange-GcwITfU = pointerId.addPointerInputChange-GcwITfU(obj, touchSlop$iv2);
                vertical = 0;
                obj22.invoke(obj, Boxing.boxFloat(Offset.getY-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ = obj;
                anon2 = $continuation2;
                $result = obj23;
                pointerId.reset();
                $result = obj23;
                anon2 = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                touchSlop$iv = onTouchSlopReached2;
                id-J3iCeTQ = 0;
                pointer$iv = touchSlop$iv2;
                onTouchSlopReached2 = obj22;
                $continuation2.L$0 = onTouchSlopReached2;
                $continuation2.L$1 = pointer$iv;
                $continuation2.L$2 = longRef;
                $continuation2.L$3 = pointerId;
                $continuation2.L$4 = obj;
                $continuation2.F$0 = touchSlop$iv2;
                $continuation2.label = 2;
                return $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                anon2 = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                touchSlop$iv = onTouchSlopReached2;
                pointer$iv = touchSlop$iv2;
                touchSlop$iv2 = pointerId;
                pointerId = obj;
                $result = obj23;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                pointerId = touchSlop$iv2;
                id-J3iCeTQ = 0;
                break;
            case 2:
                pointerId = anon2.L$4;
                touchSlop$iv2 = anon2.L$3;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv = l$0;
                onTouchSlopReached = i6;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = vertical;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                pointerId = touchSlop$iv2;
                id-J3iCeTQ = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon2.L$0 = touchSlop$iv;
        anon2.L$1 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        anon2.L$2 = longRef;
        anon2.L$3 = pointerId;
        anon2.L$4 = id-J3iCeTQ;
        anon2.F$0 = pointer$iv;
        int i8 = 1;
        anon2.label = i8;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($i$f$awaitPointerSlopOrCancellationPn7EDYM, id-J3iCeTQ, anon2, i8, id-J3iCeTQ);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv2 = pointer$iv;
            pointer$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
            $continuation2 = anon;
        }
        return $continuation2;
    }

    public static final Object awaitVerticalTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function2<? super PointerInputChange, ? super Float, Unit> function23, Continuation<? super PointerInputChange> continuation4) {
        Object obj4;
        Object $result;
        int obj2;
        boolean anon;
        Object $continuation2;
        int consumed;
        int i3;
        Object $continuation;
        int i;
        Object $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        int id-J3iCeTQ2;
        long id-J3iCeTQ;
        PointerEvent touchSlop$iv2;
        long touchSlop$iv;
        Object touchSlopDetector$iv;
        int pointer$iv;
        androidx.compose.foundation.gestures.Orientation boxFloat;
        int onTouchSlopReached;
        boolean longRef;
        int unbox-impl;
        int i5;
        int index$iv$iv$iv;
        int it$iv;
        Object obj5;
        Object obj;
        int i2;
        Object obj3;
        int i4;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalTouchSlopOrCancellation.1 anon2;
        androidx.compose.foundation.gestures.TouchSlopDetector obj22;
        Object obj23;
        Object obj24;
        obj4 = obj26;
        anon = obj4;
        i = Integer.MIN_VALUE;
        if (obj4 instanceof DragGestureDetectorKt.awaitVerticalTouchSlopOrCancellation.1 && label2 &= i != 0) {
            anon = obj4;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = label -= i;
            } else {
                anon = new DragGestureDetectorKt.awaitVerticalTouchSlopOrCancellation.1(obj4);
            }
        } else {
        }
        $result = anon.result;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = awaitPointerEventScope;
                touchSlop$iv2 = l2;
                touchSlopDetector$iv = continuation4;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($i$f$awaitPointerSlopOrCancellationPn7EDYM.getViewConfiguration(), PointerType.Companion.getTouch-T8wyACA());
                longRef = new Ref.LongRef();
                longRef.element = touchSlop$iv2;
                touchSlop$iv2 = new TouchSlopDetector(Orientation.Vertical);
                return id-J3iCeTQ2;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                touchSlop$iv = f$02;
                touchSlop$iv2 = obj7;
                onTouchSlopReached = $i$f$awaitPointerSlopOrCancellationPn7EDYM2;
                longRef = l$2;
                touchSlopDetector$iv = boxFloat;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation;
                $continuation = anon;
                $continuation2 = $result;
                boxFloat = (PointerEvent)$result.getChanges();
                unbox-impl = 0;
                index$iv$iv$iv = 0;
                i2 = 0;
                i4 = 0;
                index$iv$iv$iv++;
                touchSlop$iv2 = obj22;
                $continuation2 = obj23;
                $result = obj24;
                id-J3iCeTQ2 = 0;
                obj24 = $result;
                obj23 = $continuation2;
                obj22 = touchSlop$iv2;
                obj = 0;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ2 = 0;
                obj2 = obj;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ2 = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i7 = 0;
                touchSlop$iv2 = 0;
                index$iv$iv$iv = 0;
                obj5 = null;
                touchSlop$iv2++;
                i5 = 0;
                obj2 = i5;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ2 = 0;
                longRef.element = (PointerInputChange)obj2.getId-J3iCeTQ();
                touchSlop$iv2 = obj22;
                touchSlop$iv2 = obj22;
                Offset pointerInputChange-GcwITfU = touchSlop$iv2.addPointerInputChange-GcwITfU(obj2, touchSlop$iv);
                id-J3iCeTQ = 0;
                touchSlopDetector$iv.invoke(obj2, Boxing.boxFloat(Offset.getY-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ2 = obj2;
                anon = $continuation;
                $result = obj23;
                touchSlop$iv2.reset();
                $result = obj23;
                anon = $continuation;
                $continuation = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                id-J3iCeTQ2 = 0;
                pointer$iv = touchSlop$iv;
                $continuation.L$0 = touchSlopDetector$iv;
                $continuation.L$1 = pointer$iv;
                $continuation.L$2 = longRef;
                $continuation.L$3 = touchSlop$iv2;
                $continuation.L$4 = obj2;
                $continuation.F$0 = touchSlop$iv;
                $continuation.label = 2;
                return $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                anon = $continuation;
                $continuation = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = obj2;
                $result = obj23;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                id-J3iCeTQ2 = 0;
                break;
            case 2:
                touchSlop$iv = anon.L$4;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv2 = l$32;
                touchSlopDetector$iv = l$0;
                onTouchSlopReached = i6;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = boxFloat;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                id-J3iCeTQ2 = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon.L$0 = touchSlopDetector$iv;
        anon.L$1 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        anon.L$2 = longRef;
        anon.L$3 = touchSlop$iv2;
        anon.L$4 = id-J3iCeTQ2;
        anon.F$0 = pointer$iv;
        int i8 = 1;
        anon.label = i8;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($i$f$awaitPointerSlopOrCancellationPn7EDYM, id-J3iCeTQ2, anon, i8, id-J3iCeTQ2);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation;
            $continuation = anon2;
        }
        return $continuation;
    }

    public static final Object detectDragGestures(PointerInputScope $this$detectDragGestures, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Offset, Unit> onDrag, Continuation<? super Unit> $completion) {
        DragGestureDetectorKt.detectDragGestures.5 anon = new DragGestureDetectorKt.detectDragGestures.5(onDragStart);
        DragGestureDetectorKt.detectDragGestures.6 anon2 = new DragGestureDetectorKt.detectDragGestures.6(onDragEnd);
        Object obj9 = DragGestureDetectorKt.detectDragGestures($this$detectDragGestures, (Function2)anon, (Function1)anon2, onDragCancel, (Function0)DragGestureDetectorKt.detectDragGestures.7.INSTANCE, 0, onDrag, $completion);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope $this$detectDragGestures, Function2<? super PointerInputChange, ? super Offset, Unit> onDragStart, Function1<? super PointerInputChange, Unit> onDragEnd, Function0<Unit> onDragCancel, Function0<Boolean> shouldAwaitTouchSlop, androidx.compose.foundation.gestures.Orientation orientationLock, Function2<? super PointerInputChange, ? super Offset, Unit> onDrag, Continuation<? super Unit> $completion) {
        DragGestureDetectorKt.detectDragGestures.9 anon = new DragGestureDetectorKt.detectDragGestures.9(shouldAwaitTouchSlop, orientationLock, onDragStart, onDrag, onDragCancel, onDragEnd, 0);
        Object obj9 = ForEachGestureKt.awaitEachGesture($this$detectDragGestures, (Function2)anon, $completion);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function12, Function0 function03, Function0 function04, Function2 function25, Continuation continuation6, int i7, Object object8) {
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.2 obj1;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.3 obj2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.4 obj3;
        if (i7 & 1 != 0) {
            obj1 = DragGestureDetectorKt.detectDragGestures.2.INSTANCE;
        }
        if (i7 & 2 != 0) {
            obj2 = DragGestureDetectorKt.detectDragGestures.3.INSTANCE;
        }
        if (i7 &= 4 != 0) {
            obj3 = DragGestureDetectorKt.detectDragGestures.4.INSTANCE;
        }
        return DragGestureDetectorKt.detectDragGestures(pointerInputScope, obj1, obj2, obj3, function25, continuation6);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope $this$detectDragGesturesAfterLongPress, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Offset, Unit> onDrag, Continuation<? super Unit> $completion) {
        DragGestureDetectorKt.detectDragGesturesAfterLongPress.5 anon = new DragGestureDetectorKt.detectDragGesturesAfterLongPress.5(onDragStart, onDragEnd, onDragCancel, onDrag, 0);
        Object obj7 = ForEachGestureKt.awaitEachGesture($this$detectDragGesturesAfterLongPress, (Function2)anon, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public static Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function12, Function0 function03, Function0 function04, Function2 function25, Continuation continuation6, int i7, Object object8) {
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.2 obj1;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.3 obj2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.4 obj3;
        if (i7 & 1 != 0) {
            obj1 = DragGestureDetectorKt.detectDragGesturesAfterLongPress.2.INSTANCE;
        }
        if (i7 & 2 != 0) {
            obj2 = DragGestureDetectorKt.detectDragGesturesAfterLongPress.3.INSTANCE;
        }
        if (i7 &= 4 != 0) {
            obj3 = DragGestureDetectorKt.detectDragGesturesAfterLongPress.4.INSTANCE;
        }
        return DragGestureDetectorKt.detectDragGesturesAfterLongPress(pointerInputScope, obj1, obj2, obj3, function25, continuation6);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope $this$detectHorizontalDragGestures, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Float, Unit> onHorizontalDrag, Continuation<? super Unit> $completion) {
        DragGestureDetectorKt.detectHorizontalDragGestures.5 anon = new DragGestureDetectorKt.detectHorizontalDragGestures.5(onDragStart, onHorizontalDrag, onDragEnd, onDragCancel, 0);
        Object obj7 = ForEachGestureKt.awaitEachGesture($this$detectHorizontalDragGestures, (Function2)anon, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public static Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function12, Function0 function03, Function0 function04, Function2 function25, Continuation continuation6, int i7, Object object8) {
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.2 obj1;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.3 obj2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.4 obj3;
        if (i7 & 1 != 0) {
            obj1 = DragGestureDetectorKt.detectHorizontalDragGestures.2.INSTANCE;
        }
        if (i7 & 2 != 0) {
            obj2 = DragGestureDetectorKt.detectHorizontalDragGestures.3.INSTANCE;
        }
        if (i7 &= 4 != 0) {
            obj3 = DragGestureDetectorKt.detectHorizontalDragGestures.4.INSTANCE;
        }
        return DragGestureDetectorKt.detectHorizontalDragGestures(pointerInputScope, obj1, obj2, obj3, function25, continuation6);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope $this$detectVerticalDragGestures, Function1<? super Offset, Unit> onDragStart, Function0<Unit> onDragEnd, Function0<Unit> onDragCancel, Function2<? super PointerInputChange, ? super Float, Unit> onVerticalDrag, Continuation<? super Unit> $completion) {
        DragGestureDetectorKt.detectVerticalDragGestures.5 anon = new DragGestureDetectorKt.detectVerticalDragGestures.5(onDragStart, onVerticalDrag, onDragEnd, onDragCancel, 0);
        Object obj7 = ForEachGestureKt.awaitEachGesture($this$detectVerticalDragGestures, (Function2)anon, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public static Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function12, Function0 function03, Function0 function04, Function2 function25, Continuation continuation6, int i7, Object object8) {
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.2 obj1;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.3 obj2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.4 obj3;
        if (i7 & 1 != 0) {
            obj1 = DragGestureDetectorKt.detectVerticalDragGestures.2.INSTANCE;
        }
        if (i7 & 2 != 0) {
            obj2 = DragGestureDetectorKt.detectVerticalDragGestures.3.INSTANCE;
        }
        if (i7 &= 4 != 0) {
            obj3 = DragGestureDetectorKt.detectVerticalDragGestures.4.INSTANCE;
        }
        return DragGestureDetectorKt.detectVerticalDragGestures(pointerInputScope, obj1, obj2, obj3, function25, continuation6);
    }

    public static final Object drag-VnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long l2, Function1<? super PointerInputChange, Unit> function13, androidx.compose.foundation.gestures.Orientation orientation4, Function1<? super PointerInputChange, Boolean> function15, Continuation<? super PointerInputChange> continuation6) {
        Object obj;
        Object $result;
        float distance-impl;
        boolean anon;
        Object $continuation2;
        int i7;
        Object cOROUTINE_SUSPENDED;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.drag.2 $continuation;
        int i6;
        int $this$drag_u2dVnAYq1g2;
        Object $i$f$dragVnAYq1g;
        Object obj4;
        int i5;
        int size;
        int i11;
        int index$iv$iv$iv;
        int $i$f$dragVnAYq1g3;
        int $i$f$awaitDragOrUpJO51t882;
        Object $i$f$dragVnAYq1g2;
        Object $i$f$awaitDragOrUpJO51t88;
        int pointer$iv2;
        Object pointer$iv;
        Object $this$awaitDragOrUp_u2djO51t88$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv;
        Object motionConsumed;
        Object obj3;
        Object motionConsumed2;
        Object orientation;
        Object orientation3;
        Object onDrag;
        int orientation2;
        Object onDrag2;
        Object $this$drag_u2dVnAYq1g;
        PointerEvent onDrag3;
        Object obj2;
        Object longRef;
        int i8;
        int it$iv;
        int i;
        int i2;
        int i10;
        int i9;
        int i3;
        int i4;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.drag.2 anon2;
        Object obj24;
        Object obj25;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.drag.2 obj26;
        Object obj27;
        obj = obj30;
        anon = obj;
        i6 = Integer.MIN_VALUE;
        if (obj instanceof DragGestureDetectorKt.drag.2 && label2 &= i6 != 0) {
            anon = obj;
            i6 = Integer.MIN_VALUE;
            if (label2 &= i6 != 0) {
                anon.label = label -= i6;
            } else {
                anon = new DragGestureDetectorKt.drag.2(obj);
            }
        } else {
        }
        $result = anon.result;
        i5 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$dragVnAYq1g2 = function15;
                pointer$iv2 = l2;
                obj3 = orientation4;
                orientation = continuation6;
                orientation2 = 0;
                return null;
                onDrag3 = pointer$iv2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj2 = l$0;
                $this$drag_u2dVnAYq1g = l$1;
                onDrag = l$2;
                orientation = l$3;
                motionConsumed = l$4;
                $this$awaitDragOrUp_u2djO51t88$iv2 = l$5;
                pointer$iv2 = i16;
                $i$f$awaitDragOrUpJO51t882 = i15;
                $i$f$dragVnAYq1g = cOROUTINE_SUSPENDED;
                $continuation = anon;
                $continuation2 = $result;
                anon.L$0 = onDrag2;
                anon.L$1 = orientation3;
                anon.L$2 = motionConsumed2;
                anon.L$3 = $this$awaitDragOrUp_u2djO51t88$iv;
                anon.L$4 = pointer$iv;
                anon.L$5 = $i$f$awaitDragOrUpJO51t88;
                anon.label = i5;
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv, i11, anon, i5, i11);
                return cOROUTINE_SUSPENDED;
                $continuation2 = $result;
                $result = awaitPointerEvent$default;
                obj2 = onDrag2;
                $this$drag_u2dVnAYq1g = orientation3;
                onDrag = motionConsumed2;
                orientation = $this$awaitDragOrUp_u2djO51t88$iv;
                motionConsumed = pointer$iv;
                $this$awaitDragOrUp_u2djO51t88$iv2 = $i$f$awaitDragOrUpJO51t88;
                pointer$iv2 = $i$f$dragVnAYq1g3;
                $i$f$awaitDragOrUpJO51t882 = $this$drag_u2dVnAYq1g2;
                $i$f$dragVnAYq1g = cOROUTINE_SUSPENDED;
                $continuation = anon2;
                longRef = (PointerEvent)$result.getChanges();
                i8 = 0;
                it$iv = 0;
                i2 = i11;
                index$iv$iv$iv = i;
                i9 = 0;
                i4 = 0;
                index$iv$iv$iv++;
                $continuation2 = obj24;
                $result = obj25;
                $continuation = obj26;
                $i$f$dragVnAYq1g = obj27;
                obj25 = $result;
                obj24 = $continuation2;
                obj26 = $continuation;
                obj27 = $i$f$dragVnAYq1g;
                i10 = i2;
                i10 = i2;
                List changes = obj25.getChanges();
                $continuation2 = 0;
                $continuation = 0;
                $i$f$dragVnAYq1g = 0;
                i8 = 0;
                i = 0;
                $i$f$dragVnAYq1g++;
                longRef = i2;
                $result = longRef;
                $this$awaitDragOrUp_u2djO51t88$iv2.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation2 = 0;
                long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(i10);
                distance-impl = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getY-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getX-impl(positionChangeIgnoreConsumed);
                $result = 1;
                $result = 0;
                return i2;
                int i13 = i10;
                return i2;
                return i13;
                $this$drag_u2dVnAYq1g.invoke(i13);
                orientation2 = $i$f$awaitDragOrUpJO51t882;
                $i$f$dragVnAYq1g2 = obj6;
                cOROUTINE_SUSPENDED = obj27;
                obj3 = $this$drag_u2dVnAYq1g;
                obj4 = obj2;
                i11 = i2;
                i5 = 1;
                onDrag3 = change;
                $result = obj24;
                anon = obj26;
                $result = obj24;
                anon = obj26;
                cOROUTINE_SUSPENDED = obj27;
                $this$drag_u2dVnAYq1g2 = $i$f$awaitDragOrUpJO51t882;
                $i$f$dragVnAYq1g3 = pointer$iv2;
                $i$f$awaitDragOrUpJO51t88 = $this$awaitDragOrUp_u2djO51t88$iv2;
                pointer$iv = motionConsumed;
                $this$awaitDragOrUp_u2djO51t88$iv = orientation;
                motionConsumed2 = onDrag;
                orientation3 = $this$drag_u2dVnAYq1g;
                onDrag2 = obj2;
                i11 = i2;
                i5 = 1;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        longRef = new Ref.LongRef();
        longRef.element = onDrag3;
        onDrag2 = obj4;
        $this$drag_u2dVnAYq1g2 = orientation2;
        orientation3 = obj3;
        $this$awaitDragOrUp_u2djO51t88$iv = orientation;
        motionConsumed2 = $i$f$dragVnAYq1g2;
        $i$f$dragVnAYq1g3 = i17;
        pointer$iv = obj7;
        $i$f$awaitDragOrUpJO51t88 = longRef;
    }

    private static final Object drag-VnAYq1g$$forInline(AwaitPointerEventScope $this$drag_u2dVnAYq1g, long pointerId, Function1<? super PointerInputChange, Unit> onDrag, androidx.compose.foundation.gestures.Orientation orientation, Function1<? super PointerInputChange, Boolean> motionConsumed, Continuation<? super PointerInputChange> $completion) {
        int $this$fastFirstOrNull$iv$iv;
        boolean z;
        AwaitPointerEventScope id-J3iCeTQ;
        PointerEvent positionChangeIgnoreConsumed;
        long l;
        int i7;
        int index$iv$iv$iv2;
        long pointer;
        int i8;
        Ref.LongRef longRef;
        int index$iv$iv$iv;
        int i2;
        Continuation continuation;
        Object awaitPointerEvent$default;
        List changes;
        int i5;
        List list;
        int booleanValue;
        int i9;
        int i3;
        int pressed;
        int i;
        int i4;
        int i6;
        int i10;
        int $i$f$dragVnAYq1g;
        AwaitPointerEventScope awaitPointerEventScope;
        final androidx.compose.foundation.gestures.Orientation orientation2 = motionConsumed;
        $this$fastFirstOrNull$iv$iv = 0;
        if (DragGestureDetectorKt.access$isPointerUp-DmW0f2w($this$drag_u2dVnAYq1g.getCurrentEvent(), pointerId)) {
            return null;
        }
        pointer = pointerId;
        while (/* condition */) {
            while (/* condition */) {
                while (index$iv$iv$iv < index$iv$iv$iv2) {
                    i4 = 0;
                    i10 = 0;
                    Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
                    id-J3iCeTQ = valueOf;
                    index$iv$iv$iv++;
                    positionChangeIgnoreConsumed = pointerId;
                    $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
                    id-J3iCeTQ = awaitPointerEventScope;
                }
                $i$f$dragVnAYq1g = $this$fastFirstOrNull$iv$iv;
                awaitPointerEventScope = id-J3iCeTQ;
                i = i3;
                if (!PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange)i)) {
                    break loop_4;
                } else {
                }
                int i14 = 0;
                positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed((PointerInputChange)i);
                if (orientation2 == null) {
                } else {
                }
                if (orientation2 == Orientation.Vertical) {
                } else {
                }
                index$iv$iv$iv2 = Offset.getX-impl(positionChangeIgnoreConsumed);
                if (Float.compare(index$iv$iv$iv2, i16) == 0) {
                } else {
                }
                i2 = 0;
                Boolean valueOf2 = Boolean.valueOf(i2 ^= 1);
                id-J3iCeTQ = valueOf2;
                if (valueOf2.booleanValue()) {
                    break loop_4;
                } else {
                }
                positionChangeIgnoreConsumed = pointerId;
                i7 = i3;
                $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
                id-J3iCeTQ = awaitPointerEventScope;
                int i15 = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(id-J3iCeTQ, i7, obj32, i15, i7);
                i5 = 0;
                list = changes;
                booleanValue = 0;
                i3 = i7;
                index$iv$iv$iv = i9;
                i2 = pressed;
                index$iv$iv$iv2 = Offset.getY-impl(positionChangeIgnoreConsumed);
                index$iv$iv$iv2 = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                id-J3iCeTQ = 0;
                positionChangeIgnoreConsumed = changes2;
                l = 0;
                index$iv$iv$iv2 = 0;
                while (index$iv$iv$iv2 < positionChangeIgnoreConsumed.size()) {
                    list = null;
                    int i18 = 0;
                    Boolean valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
                    i9 = valueOf3;
                    index$iv$iv$iv2++;
                }
                i5 = i3;
                $this$fastFirstOrNull$iv$iv = i5;
                if ((PointerInputChange)$this$fastFirstOrNull$iv$iv == 0) {
                    break loop_4;
                } else {
                }
                longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv$iv.getId-J3iCeTQ();
                list = null;
                i18 = 0;
                valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
                i9 = valueOf3;
                if (valueOf3.booleanValue() != 0) {
                } else {
                }
                index$iv$iv$iv2++;
                i4 = 0;
                i10 = 0;
                valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
                id-J3iCeTQ = valueOf;
                if (valueOf.booleanValue()) {
                } else {
                }
                index$iv$iv$iv++;
                positionChangeIgnoreConsumed = pointerId;
                $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
                id-J3iCeTQ = awaitPointerEventScope;
            }
            while (index$iv$iv$iv < list.size()) {
                i4 = 0;
                i10 = 0;
                valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
                id-J3iCeTQ = valueOf;
                index$iv$iv$iv++;
                positionChangeIgnoreConsumed = pointerId;
                $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
                id-J3iCeTQ = awaitPointerEventScope;
            }
            $i$f$dragVnAYq1g = $this$fastFirstOrNull$iv$iv;
            awaitPointerEventScope = id-J3iCeTQ;
            i = i3;
            if ((PointerInputChange)i != 0) {
            } else {
            }
            i = i3;
            int i12 = i;
            int i13 = i;
            orientation.invoke(i13);
            pointer = i13.getId-J3iCeTQ();
            positionChangeIgnoreConsumed = pointerId;
            i7 = i3;
            $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
            id-J3iCeTQ = $this$drag_u2dVnAYq1g;
            i8 = 0;
            longRef = new Ref.LongRef();
            longRef.element = pointer;
            if (PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange)i)) {
            } else {
            }
            i14 = 0;
            positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed((PointerInputChange)i);
            if (orientation2 == null) {
            } else {
            }
            if (orientation2 == Orientation.Vertical) {
            } else {
            }
            index$iv$iv$iv2 = Offset.getX-impl(positionChangeIgnoreConsumed);
            if (Float.compare(index$iv$iv$iv2, i16) == 0) {
            } else {
            }
            i2 = 0;
            valueOf2 = Boolean.valueOf(i2 ^= 1);
            id-J3iCeTQ = valueOf2;
            if (valueOf2.booleanValue()) {
            } else {
            }
            positionChangeIgnoreConsumed = pointerId;
            i7 = i3;
            $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
            id-J3iCeTQ = awaitPointerEventScope;
            i2 = pressed;
            index$iv$iv$iv2 = Offset.getY-impl(positionChangeIgnoreConsumed);
            index$iv$iv$iv2 = Offset.getDistance-impl(positionChangeIgnoreConsumed);
            id-J3iCeTQ = 0;
            positionChangeIgnoreConsumed = changes2;
            l = 0;
            index$iv$iv$iv2 = 0;
            while (index$iv$iv$iv2 < positionChangeIgnoreConsumed.size()) {
                list = null;
                i18 = 0;
                valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
                i9 = valueOf3;
                index$iv$iv$iv2++;
            }
            i5 = i3;
            $this$fastFirstOrNull$iv$iv = i5;
            if ((PointerInputChange)$this$fastFirstOrNull$iv$iv == 0) {
            } else {
            }
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv$iv.getId-J3iCeTQ();
            list = null;
            i18 = 0;
            valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
            i9 = valueOf3;
            if (valueOf3.booleanValue() != 0) {
            } else {
            }
            index$iv$iv$iv2++;
            i4 = 0;
            i10 = 0;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
            id-J3iCeTQ = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            index$iv$iv$iv++;
            positionChangeIgnoreConsumed = pointerId;
            $this$fastFirstOrNull$iv$iv = $i$f$dragVnAYq1g;
            id-J3iCeTQ = awaitPointerEventScope;
        }
        Object obj2 = orientation;
        boolean z2 = $completion;
        return i3;
    }

    public static final Object drag-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function1<? super PointerInputChange, Unit> function13, Continuation<? super Boolean> continuation4) {
        boolean anon;
        int i2;
        int i;
        AwaitPointerEventScope id-J3iCeTQ;
        Object obj;
        Object obj7;
        Object obj8;
        Object obj9;
        boolean obj10;
        Object obj11;
        anon = obj11;
        i = Integer.MIN_VALUE;
        if (obj11 instanceof DragGestureDetectorKt.drag.1 && label &= i != 0) {
            anon = obj11;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj11 -= i;
            } else {
                anon = new DragGestureDetectorKt.drag.1(obj11);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i3 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                id-J3iCeTQ = l2;
                obj8 = awaitPointerEventScope;
                obj7 = continuation4;
                break;
            case 1:
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                obj9 = obj11;
                return Boxing.boxBoolean(false);
                return Boxing.boxBoolean(i3);
                obj7.invoke(obj11);
                id-J3iCeTQ = obj11.getId-J3iCeTQ();
                obj11 = obj9;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        anon.L$0 = obj8;
        anon.L$1 = obj7;
        anon.label = i3;
        obj9 = DragGestureDetectorKt.awaitDragOrCancellation-rnUCldI(obj8, id-J3iCeTQ, obj5);
        if (obj9 != cOROUTINE_SUSPENDED) {
            obj11 = obj9;
            obj9 = obj;
        }
        return cOROUTINE_SUSPENDED;
    }

    public static final Object horizontalDrag-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function1<? super PointerInputChange, Unit> function13, Continuation<? super Boolean> continuation4) {
        Object obj2;
        Object $result;
        float distance-impl;
        boolean anon;
        Object $continuation;
        int i2;
        Object $continuation2;
        int i;
        int $this$drag_u2dVnAYq1g$iv2;
        Object $i$f$dragVnAYq1g;
        long id-J3iCeTQ;
        int i9;
        int index$iv$iv$iv$iv;
        int id-J3iCeTQ2;
        int $this$awaitDragOrUp_u2djO51t88$iv$iv;
        int $i$f$awaitDragOrUpJO51t88;
        Object $i$f$awaitDragOrUpJO51t882;
        int pointer$iv$iv2;
        Object pointer$iv$iv;
        Object $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        androidx.compose.foundation.gestures.Orientation orientation$iv2;
        Object orientation$iv;
        Object $this$drag_u2dVnAYq1g$iv3;
        Object $this$drag_u2dVnAYq1g$iv;
        Object onDrag;
        PointerEvent $this$drag_u2dVnAYq1g$iv4;
        Object obj;
        Object longRef;
        int i5;
        int it$iv$iv;
        int i8;
        int i7;
        int i3;
        int i4;
        int i6;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.horizontalDrag.1 anon2;
        int obj24;
        Object obj25;
        Object obj26;
        obj2 = obj28;
        anon = obj2;
        i = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.horizontalDrag.1 && label2 &= i != 0) {
            anon = obj2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = label -= i;
            } else {
                anon = new DragGestureDetectorKt.horizontalDrag.1(obj2);
            }
        } else {
        }
        $result = anon.result;
        index$iv$iv$iv$iv = 1;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitDragOrUpJO51t88 = l2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = continuation4;
                orientation$iv2 = Orientation.Horizontal;
                $this$drag_u2dVnAYq1g$iv3 = 0;
                $this$drag_u2dVnAYq1g$iv4 = $i$f$awaitDragOrUpJO51t88;
                i9 = 1;
                i9 = 0;
                return Boxing.boxBoolean(i9);
            case 1:
                ResultKt.throwOnFailure($result);
                obj = l$0;
                onDrag = l$1;
                $this$drag_u2dVnAYq1g$iv3 = l$2;
                orientation$iv2 = l$3;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = l$4;
                pointer$iv$iv2 = i15;
                $i$f$awaitDragOrUpJO51t88 = i13;
                $i$f$dragVnAYq1g = $continuation2;
                $continuation2 = anon;
                $continuation = $result;
                anon.L$0 = $this$drag_u2dVnAYq1g$iv;
                anon.L$1 = orientation$iv;
                anon.L$2 = orientation$iv2;
                anon.L$3 = pointer$iv$iv;
                anon.L$4 = $i$f$awaitDragOrUpJO51t882;
                anon.label = index$iv$iv$iv$iv;
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv$iv, id-J3iCeTQ2, anon, index$iv$iv$iv$iv, id-J3iCeTQ2);
                return $continuation2;
                $continuation = $result;
                $result = awaitPointerEvent$default;
                obj = $this$drag_u2dVnAYq1g$iv;
                onDrag = orientation$iv;
                $this$drag_u2dVnAYq1g$iv3 = orientation$iv2;
                orientation$iv2 = pointer$iv$iv;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $i$f$awaitDragOrUpJO51t882;
                pointer$iv$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                $i$f$awaitDragOrUpJO51t88 = $this$drag_u2dVnAYq1g$iv2;
                $i$f$dragVnAYq1g = $continuation2;
                $continuation2 = anon2;
                longRef = (PointerEvent)$result.getChanges();
                i5 = 0;
                it$iv$iv = 0;
                index$iv$iv$iv$iv = i8;
                i3 = 0;
                i6 = 0;
                index$iv$iv$iv$iv++;
                $i$f$awaitDragOrUpJO51t88 = obj24;
                $continuation = obj25;
                $result = obj26;
                id-J3iCeTQ2 = 0;
                obj26 = $result;
                obj25 = $continuation;
                obj24 = $i$f$awaitDragOrUpJO51t88;
                i7 = 0;
                i7 = 0;
                List changes = obj26.getChanges();
                $continuation = 0;
                id-J3iCeTQ = 0;
                index$iv$iv$iv$iv = 0;
                i5 = 0;
                i8 = 0;
                index$iv$iv$iv$iv++;
                longRef = 0;
                $result = longRef;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation = 0;
                long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(i7);
                distance-impl = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getY-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getX-impl(positionChangeIgnoreConsumed);
                $result = 1;
                $result = 0;
                $result = obj25;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                int i11 = i7;
                id-J3iCeTQ = 0;
                $result = obj25;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                id-J3iCeTQ2 = i11;
                anon = $continuation2;
                $result = obj25;
                i9 = 1;
                i9 = 0;
                return Boxing.boxBoolean(i9);
                obj.invoke(i11);
                orientation$iv2 = $this$drag_u2dVnAYq1g$iv3;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = obj;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ2 = 0;
                $this$drag_u2dVnAYq1g$iv3 = obj24;
                $result = obj25;
                anon = $continuation2;
                $continuation2 = $i$f$dragVnAYq1g;
                $i$f$dragVnAYq1g = onDrag;
                $this$drag_u2dVnAYq1g$iv4 = anon2;
                $result = obj25;
                anon = $continuation2;
                $continuation2 = $i$f$dragVnAYq1g;
                $this$awaitDragOrUp_u2djO51t88$iv$iv = pointer$iv$iv2;
                $i$f$awaitDragOrUpJO51t882 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                pointer$iv$iv = orientation$iv2;
                orientation$iv2 = $this$drag_u2dVnAYq1g$iv3;
                orientation$iv = onDrag;
                $this$drag_u2dVnAYq1g$iv = obj;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ2 = 0;
                $this$drag_u2dVnAYq1g$iv2 = obj24;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        longRef = new Ref.LongRef();
        longRef.element = $this$drag_u2dVnAYq1g$iv4;
        orientation$iv = $i$f$dragVnAYq1g;
        $this$drag_u2dVnAYq1g$iv2 = pointer$iv;
        $this$drag_u2dVnAYq1g$iv = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        pointer$iv$iv = obj3;
        $this$awaitDragOrUp_u2djO51t88$iv$iv = i16;
        $i$f$awaitDragOrUpJO51t882 = longRef;
    }

    private static final boolean isPointerUp-DmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        int i3;
        List pressed;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i;
        boolean it;
        int i2;
        long id-J3iCeTQ;
        int i5 = 0;
        pressed = changes;
        final int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < pressed.size()) {
            i = 0;
            i2 = 0;
            index$iv$iv++;
        }
        obj2 = 0;
        i3 = 0;
        int i6 = 1;
        if (obj2 != null && (PointerInputChange)obj2.getPressed() == i6) {
            if (obj2.getPressed() == i6) {
                i3 = i6;
            }
        }
        return i3 ^= i6;
    }

    public static final float pointerSlop-E8SPZFQ(ViewConfiguration $this$pointerSlop_u2dE8SPZFQ, int pointerType) {
        int touchSlop;
        float mouseToTouchSlopRatio;
        if (PointerType.equals-impl0(pointerType, PointerType.Companion.getMouse-T8wyACA())) {
            touchSlop2 *= mouseToTouchSlopRatio;
        } else {
            touchSlop = $this$pointerSlop_u2dE8SPZFQ.getTouchSlop();
        }
        return touchSlop;
    }

    public static final Object verticalDrag-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function1<? super PointerInputChange, Unit> function13, Continuation<? super Boolean> continuation4) {
        Object obj2;
        Object $result;
        float distance-impl;
        boolean anon;
        Object $continuation2;
        int i4;
        Object $continuation;
        int i;
        int $this$drag_u2dVnAYq1g$iv2;
        Object $i$f$dragVnAYq1g;
        long id-J3iCeTQ2;
        int i5;
        int index$iv$iv$iv$iv;
        int id-J3iCeTQ;
        int $this$awaitDragOrUp_u2djO51t88$iv$iv;
        int $i$f$awaitDragOrUpJO51t88;
        Object $i$f$awaitDragOrUpJO51t882;
        int pointer$iv$iv;
        Object pointer$iv$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        androidx.compose.foundation.gestures.Orientation orientation$iv;
        Object orientation$iv2;
        Object $this$drag_u2dVnAYq1g$iv;
        Object $this$drag_u2dVnAYq1g$iv4;
        Object onDrag;
        PointerEvent $this$drag_u2dVnAYq1g$iv3;
        Object obj;
        Object longRef;
        int i2;
        int it$iv$iv;
        int i3;
        int i8;
        int i9;
        int i6;
        int i7;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.verticalDrag.1 anon2;
        int obj24;
        Object obj25;
        Object obj26;
        obj2 = obj28;
        anon = obj2;
        i = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.verticalDrag.1 && label2 &= i != 0) {
            anon = obj2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = label -= i;
            } else {
                anon = new DragGestureDetectorKt.verticalDrag.1(obj2);
            }
        } else {
        }
        $result = anon.result;
        index$iv$iv$iv$iv = 1;
        id-J3iCeTQ = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitDragOrUpJO51t88 = l2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = continuation4;
                orientation$iv = Orientation.Vertical;
                $this$drag_u2dVnAYq1g$iv = 0;
                $this$drag_u2dVnAYq1g$iv3 = $i$f$awaitDragOrUpJO51t88;
                i5 = 1;
                i5 = 0;
                return Boxing.boxBoolean(i5);
            case 1:
                ResultKt.throwOnFailure($result);
                obj = l$0;
                onDrag = l$1;
                $this$drag_u2dVnAYq1g$iv = l$2;
                orientation$iv = l$3;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = l$4;
                pointer$iv$iv = i15;
                $i$f$awaitDragOrUpJO51t88 = i13;
                $i$f$dragVnAYq1g = $continuation;
                $continuation = anon;
                $continuation2 = $result;
                anon.L$0 = $this$drag_u2dVnAYq1g$iv4;
                anon.L$1 = orientation$iv2;
                anon.L$2 = orientation$iv;
                anon.L$3 = pointer$iv$iv2;
                anon.L$4 = $i$f$awaitDragOrUpJO51t882;
                anon.label = index$iv$iv$iv$iv;
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv$iv2, id-J3iCeTQ, anon, index$iv$iv$iv$iv, id-J3iCeTQ);
                return $continuation;
                $continuation2 = $result;
                $result = awaitPointerEvent$default;
                obj = $this$drag_u2dVnAYq1g$iv4;
                onDrag = orientation$iv2;
                $this$drag_u2dVnAYq1g$iv = orientation$iv;
                orientation$iv = pointer$iv$iv2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = $i$f$awaitDragOrUpJO51t882;
                pointer$iv$iv = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                $i$f$awaitDragOrUpJO51t88 = $this$drag_u2dVnAYq1g$iv2;
                $i$f$dragVnAYq1g = $continuation;
                $continuation = anon2;
                longRef = (PointerEvent)$result.getChanges();
                i2 = 0;
                it$iv$iv = 0;
                index$iv$iv$iv$iv = i3;
                i9 = 0;
                i7 = 0;
                index$iv$iv$iv$iv++;
                $i$f$awaitDragOrUpJO51t88 = obj24;
                $continuation2 = obj25;
                $result = obj26;
                id-J3iCeTQ = 0;
                obj26 = $result;
                obj25 = $continuation2;
                obj24 = $i$f$awaitDragOrUpJO51t88;
                i8 = 0;
                i8 = 0;
                List changes = obj26.getChanges();
                $continuation2 = 0;
                id-J3iCeTQ2 = 0;
                index$iv$iv$iv$iv = 0;
                i2 = 0;
                i3 = 0;
                index$iv$iv$iv$iv++;
                longRef = 0;
                $result = longRef;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation2 = 0;
                long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(i8);
                distance-impl = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getY-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getX-impl(positionChangeIgnoreConsumed);
                $result = 1;
                $result = 0;
                $result = obj25;
                anon = $continuation;
                id-J3iCeTQ = 0;
                int i11 = i8;
                id-J3iCeTQ2 = 0;
                $result = obj25;
                anon = $continuation;
                id-J3iCeTQ = 0;
                id-J3iCeTQ = i11;
                anon = $continuation;
                $result = obj25;
                i5 = 1;
                i5 = 0;
                return Boxing.boxBoolean(i5);
                obj.invoke(i11);
                orientation$iv = $this$drag_u2dVnAYq1g$iv;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = obj;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ = 0;
                $this$drag_u2dVnAYq1g$iv = obj24;
                $result = obj25;
                anon = $continuation;
                $continuation = $i$f$dragVnAYq1g;
                $i$f$dragVnAYq1g = onDrag;
                $this$drag_u2dVnAYq1g$iv3 = anon2;
                $result = obj25;
                anon = $continuation;
                $continuation = $i$f$dragVnAYq1g;
                $this$awaitDragOrUp_u2djO51t88$iv$iv = pointer$iv$iv;
                $i$f$awaitDragOrUpJO51t882 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                pointer$iv$iv2 = orientation$iv;
                orientation$iv = $this$drag_u2dVnAYq1g$iv;
                orientation$iv2 = onDrag;
                $this$drag_u2dVnAYq1g$iv4 = obj;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ = 0;
                $this$drag_u2dVnAYq1g$iv2 = obj24;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        longRef = new Ref.LongRef();
        longRef.element = $this$drag_u2dVnAYq1g$iv3;
        orientation$iv2 = $i$f$dragVnAYq1g;
        $this$drag_u2dVnAYq1g$iv2 = pointer$iv;
        $this$drag_u2dVnAYq1g$iv4 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        pointer$iv$iv2 = obj3;
        $this$awaitDragOrUp_u2djO51t88$iv$iv = i16;
        $i$f$awaitDragOrUpJO51t882 = longRef;
    }
}
