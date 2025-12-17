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
        Object obj;
        Object $result;
        boolean anon2;
        Object $continuation;
        int i5;
        Object $continuation2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitDragOrCancellation.1 anon;
        int i8;
        int $this$awaitDragOrUp_u2djO51t88$iv2;
        Object obj4;
        int id-J3iCeTQ;
        int i4;
        int index$iv$iv$iv2;
        int i3;
        Ref.LongRef pointerId;
        int pointer$iv;
        Object pointer$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv;
        int obj2;
        Ref.LongRef longRef;
        int i6;
        int i2;
        int index$iv$iv$iv;
        int it$iv;
        Object obj3;
        Object obj6;
        int i;
        Object obj5;
        int i7;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitDragOrCancellation.1 anon3;
        Object obj20;
        Object obj21;
        obj = obj23;
        anon2 = obj;
        i8 = Integer.MIN_VALUE;
        if (obj instanceof DragGestureDetectorKt.awaitDragOrCancellation.1 && label2 &= i8 != 0) {
            anon2 = obj;
            i8 = Integer.MIN_VALUE;
            if (label2 &= i8 != 0) {
                anon2.label = label -= i8;
            } else {
                anon2 = new DragGestureDetectorKt.awaitDragOrCancellation.1(obj);
            }
        } else {
        }
        $result = anon2.result;
        id-J3iCeTQ = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object obj9 = awaitPointerEventScope;
                PointerEvent pointerEvent = l2;
                return null;
                longRef = new Ref.LongRef();
                longRef.element = pointerEvent;
                pointer$iv2 = obj9;
                $this$awaitDragOrUp_u2djO51t88$iv2 = obj2;
                pointerId = longRef;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj2 = l$0;
                $this$awaitDragOrUp_u2djO51t88$iv = l$1;
                pointer$iv = i10;
                obj4 = $continuation2;
                anon = anon2;
                $continuation = $result;
                longRef = (PointerEvent)$result.getChanges();
                i6 = 0;
                i2 = 0;
                index$iv$iv$iv = 0;
                i = 0;
                i7 = 0;
                index$iv$iv$iv++;
                $result = obj21;
                id-J3iCeTQ = 1;
                index$iv$iv$iv2 = 0;
                $continuation = obj20;
                obj21 = $result;
                obj20 = $continuation;
                obj6 = 0;
                obj6 = 0;
                List changes = obj21.getChanges();
                $continuation = 0;
                id-J3iCeTQ = 0;
                index$iv$iv$iv2 = 0;
                index$iv$iv$iv = 0;
                obj3 = null;
                index$iv$iv$iv2++;
                i2 = 0;
                $result = i2;
                $this$awaitDragOrUp_u2djO51t88$iv.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation = 0;
                i4 = 1;
                i4 = i9;
                i3 = obj6;
                i3 = 0;
                return i3;
                $result = obj20;
                anon2 = anon;
                $continuation2 = obj4;
                $this$awaitDragOrUp_u2djO51t88$iv2 = pointer$iv;
                pointerId = $this$awaitDragOrUp_u2djO51t88$iv;
                pointer$iv2 = obj2;
                id-J3iCeTQ = 1;
                index$iv$iv$iv2 = 0;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        anon2.L$0 = pointer$iv2;
        anon2.L$1 = pointerId;
        anon2.label = id-J3iCeTQ;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv2, index$iv$iv$iv2, anon2, id-J3iCeTQ, index$iv$iv$iv2);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            obj2 = pointer$iv2;
            $this$awaitDragOrUp_u2djO51t88$iv = pointerId;
            pointer$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
            obj4 = $continuation2;
            anon = anon3;
        }
        return $continuation2;
    }

    private static final Object awaitDragOrUp-jO51t88(AwaitPointerEventScope $this$awaitDragOrUp_u2djO51t88, long pointerId, Function1<? super PointerInputChange, Boolean> hasDragged, Continuation<? super PointerInputChange> $completion) {
        long booleanValue2;
        Object otherDown;
        long booleanValue3;
        int $this$fastForEach$iv$iv;
        int awaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope;
        Continuation continuation;
        int index$iv$iv;
        int size;
        List list;
        int i;
        int index$iv$iv2;
        int booleanValue;
        Object obj;
        Object obj2;
        int pressed;
        Object obj4;
        int i2;
        int i3;
        Object obj3;
        final int i4 = 0;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = pointerId;
        while (/* condition */) {
            while (index$iv$iv2 < booleanValue) {
                pressed = 0;
                i2 = 0;
                Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv2).getId-J3iCeTQ(), awaitPointerEvent$default));
                booleanValue3 = valueOf;
                index$iv$iv2++;
                booleanValue2 = pointerId;
                $this$fastForEach$iv$iv = i3;
                awaitPointerEvent$default = obj3;
            }
            obj3 = awaitPointerEvent$default;
            obj2 = i3;
            booleanValue2 = pointerId;
            $this$fastForEach$iv$iv = 0;
            size = 0;
            list = index$iv$iv;
            i = 0;
            index$iv$iv2 = 0;
            int i5 = 0;
            List list2 = changes;
            awaitPointerEvent$default = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list2.size()) {
                i = list;
                index$iv$iv2 = 0;
                int i8 = 0;
                Boolean valueOf2 = Boolean.valueOf((PointerInputChange)i.getPressed());
                obj = valueOf2;
                index$iv$iv++;
            }
            $this$fastForEach$iv$iv = i3;
            int $this$fastFirstOrNull$iv = $this$fastForEach$iv$iv;
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv.getId-J3iCeTQ();
            otherDown = $completion;
            i = list;
            index$iv$iv2 = 0;
            i8 = 0;
            valueOf2 = Boolean.valueOf((PointerInputChange)i.getPressed());
            obj = valueOf2;
            if (valueOf2.booleanValue() != 0) {
            } else {
            }
            index$iv$iv++;
            $this$fastForEach$iv$iv = i;
            pressed = 0;
            i2 = 0;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv2).getId-J3iCeTQ(), awaitPointerEvent$default));
            booleanValue3 = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            index$iv$iv2++;
            booleanValue2 = pointerId;
            $this$fastForEach$iv$iv = i3;
            awaitPointerEvent$default = obj3;
        }
        Object obj5 = $completion;
        return i3;
    }

    public static final Object awaitHorizontalDragOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj2;
        Object $result;
        boolean anon2;
        Object $continuation;
        int i6;
        Object $continuation2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1 anon;
        int i;
        int $this$awaitDragOrUp_u2djO51t88$iv2;
        Object obj;
        int id-J3iCeTQ;
        int i3;
        int cmp;
        int i7;
        Ref.LongRef pointerId;
        int pointer$iv;
        Object pointer$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv;
        int obj5;
        Ref.LongRef index$iv$iv$iv2;
        int size;
        int i4;
        int index$iv$iv$iv;
        int size2;
        Object it$iv;
        Object obj4;
        int i2;
        Object obj3;
        int i5;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1 anon3;
        Object obj20;
        Object obj21;
        obj2 = obj23;
        anon2 = obj2;
        i = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1 && label2 &= i != 0) {
            anon2 = obj2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon2.label = label -= i;
            } else {
                anon2 = new DragGestureDetectorKt.awaitHorizontalDragOrCancellation.1(obj2);
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
                index$iv$iv$iv2 = new Ref.LongRef();
                index$iv$iv$iv2.element = pointerEvent;
                pointer$iv2 = obj8;
                $this$awaitDragOrUp_u2djO51t88$iv2 = obj5;
                pointerId = index$iv$iv$iv2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj5 = l$0;
                $this$awaitDragOrUp_u2djO51t88$iv = l$1;
                pointer$iv = i9;
                obj = $continuation2;
                anon = anon2;
                $continuation = $result;
                index$iv$iv$iv2 = (PointerEvent)$result.getChanges();
                i4 = 0;
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
                i3 = 1;
                i3 = i8;
                i7 = obj4;
                i7 = 0;
                return i7;
                $result = obj20;
                anon2 = anon;
                $continuation2 = obj;
                $this$awaitDragOrUp_u2djO51t88$iv2 = pointer$iv;
                pointerId = $this$awaitDragOrUp_u2djO51t88$iv;
                pointer$iv2 = obj5;
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
            obj5 = pointer$iv2;
            $this$awaitDragOrUp_u2djO51t88$iv = pointerId;
            pointer$iv = $this$awaitDragOrUp_u2djO51t88$iv2;
            obj = $continuation2;
            anon = anon3;
        }
        return $continuation2;
    }

    public static final Object awaitHorizontalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Function2<? super PointerInputChange, ? super Float, Unit> function24, Continuation<? super PointerInputChange> continuation5) {
        Object obj2;
        Object $result;
        int obj3;
        boolean anon2;
        Object $continuation2;
        int consumed;
        int i;
        Object $continuation;
        int i5;
        Object $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
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
        Object obj5;
        Object obj;
        int i2;
        Object obj4;
        int i4;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalPointerSlopOrCancellation.1 anon;
        Object obj22;
        Object obj23;
        Object obj24;
        obj2 = obj27;
        anon2 = obj2;
        i5 = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.awaitHorizontalPointerSlopOrCancellation.1 && label2 &= i5 != 0) {
            anon2 = obj2;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                anon2.label = label -= i5;
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
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = awaitPointerEventScope;
                touchSlop$iv2 = continuation5;
                pointerId = l2;
                onPointerSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getViewConfiguration(), function24);
                longRef = new Ref.LongRef();
                longRef.element = pointerId;
                pointerId = new TouchSlopDetector(Orientation.Horizontal);
                return id-J3iCeTQ2;
            case 1:
                pointerId = anon2.L$3;
                pointer$iv = anon2.L$1;
                ResultKt.throwOnFailure($result);
                onPointerSlopReached = i7;
                longRef = l$2;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation;
                touchSlop$iv = f$02;
                touchSlop$iv2 = horizontal;
                $continuation = anon2;
                $continuation2 = $result;
                horizontal = (PointerEvent)$result.getChanges();
                boxFloat = 0;
                onPointerSlopReached2 = 0;
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
                anon2 = $continuation;
                id-J3iCeTQ2 = 0;
                obj3 = obj;
                $result = obj23;
                anon2 = $continuation;
                id-J3iCeTQ2 = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i8 = 0;
                touchSlop$iv2 = 0;
                index$iv$iv$iv = 0;
                obj5 = null;
                touchSlop$iv2++;
                onPointerSlopReached2 = 0;
                obj3 = onPointerSlopReached2;
                $result = obj23;
                anon2 = $continuation;
                id-J3iCeTQ2 = 0;
                longRef.element = (PointerInputChange)obj3.getId-J3iCeTQ();
                onPointerSlopReached2 = obj22;
                Offset pointerInputChange-GcwITfU = pointerId.addPointerInputChange-GcwITfU(obj3, touchSlop$iv);
                horizontal = 0;
                obj22.invoke(obj3, Boxing.boxFloat(Offset.getX-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ2 = obj3;
                anon2 = $continuation;
                $result = obj23;
                pointerId.reset();
                $result = obj23;
                anon2 = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                touchSlop$iv2 = onPointerSlopReached2;
                id-J3iCeTQ2 = 0;
                pointer$iv = touchSlop$iv;
                onPointerSlopReached2 = obj22;
                $continuation.L$0 = onPointerSlopReached2;
                $continuation.L$1 = pointer$iv;
                $continuation.L$2 = longRef;
                $continuation.L$3 = pointerId;
                $continuation.L$4 = obj3;
                $continuation.F$0 = touchSlop$iv;
                $continuation.label = 2;
                return $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                anon2 = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                touchSlop$iv2 = onPointerSlopReached2;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = pointerId;
                pointerId = obj3;
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
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = horizontal;
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
        anon2.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        anon2.L$2 = longRef;
        anon2.L$3 = pointerId;
        anon2.L$4 = id-J3iCeTQ2;
        anon2.F$0 = pointer$iv;
        int i9 = 1;
        anon2.label = i9;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, id-J3iCeTQ2, anon2, i9, id-J3iCeTQ2);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation;
            $continuation = anon;
        }
        return $continuation;
    }

    public static final Object awaitHorizontalTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function2<? super PointerInputChange, ? super Float, Unit> function23, Continuation<? super PointerInputChange> continuation4) {
        Object obj2;
        Object $result;
        int obj5;
        boolean anon2;
        Object $continuation;
        int consumed;
        int i5;
        Object $continuation2;
        int i4;
        Object $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
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
        int i;
        int index$iv$iv$iv;
        int it$iv;
        Object obj;
        Object obj4;
        int i3;
        Object obj3;
        int i2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitHorizontalTouchSlopOrCancellation.1 anon;
        androidx.compose.foundation.gestures.TouchSlopDetector obj22;
        Object obj23;
        Object obj24;
        obj2 = obj26;
        anon2 = obj2;
        i4 = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.awaitHorizontalTouchSlopOrCancellation.1 && label2 &= i4 != 0) {
            anon2 = obj2;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                anon2.label = label -= i4;
            } else {
                anon2 = new DragGestureDetectorKt.awaitHorizontalTouchSlopOrCancellation.1(obj2);
            }
        } else {
        }
        $result = anon2.result;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = awaitPointerEventScope;
                touchSlop$iv2 = l2;
                touchSlopDetector$iv = continuation4;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getViewConfiguration(), PointerType.Companion.getTouch-T8wyACA());
                longRef = new Ref.LongRef();
                longRef.element = touchSlop$iv2;
                touchSlop$iv2 = new TouchSlopDetector(Orientation.Horizontal);
                return id-J3iCeTQ2;
            case 1:
                pointer$iv = anon2.L$1;
                ResultKt.throwOnFailure($result);
                touchSlop$iv = f$02;
                touchSlop$iv2 = obj7;
                onTouchSlopReached = i7;
                longRef = l$2;
                touchSlopDetector$iv = boxFloat;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation2;
                $continuation2 = anon2;
                $continuation = $result;
                boxFloat = (PointerEvent)$result.getChanges();
                unbox-impl = 0;
                index$iv$iv$iv = 0;
                i3 = 0;
                i2 = 0;
                index$iv$iv$iv++;
                touchSlop$iv2 = obj22;
                $continuation = obj23;
                $result = obj24;
                id-J3iCeTQ2 = 0;
                obj24 = $result;
                obj23 = $continuation;
                obj22 = touchSlop$iv2;
                obj4 = 0;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ2 = 0;
                obj5 = obj4;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ2 = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i8 = 0;
                touchSlop$iv2 = 0;
                index$iv$iv$iv = 0;
                obj = null;
                touchSlop$iv2++;
                i = 0;
                obj5 = i;
                $result = obj23;
                anon2 = $continuation2;
                id-J3iCeTQ2 = 0;
                longRef.element = (PointerInputChange)obj5.getId-J3iCeTQ();
                touchSlop$iv2 = obj22;
                touchSlop$iv2 = obj22;
                Offset pointerInputChange-GcwITfU = touchSlop$iv2.addPointerInputChange-GcwITfU(obj5, touchSlop$iv);
                id-J3iCeTQ = 0;
                touchSlopDetector$iv.invoke(obj5, Boxing.boxFloat(Offset.getX-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ2 = obj5;
                anon2 = $continuation2;
                $result = obj23;
                touchSlop$iv2.reset();
                $result = obj23;
                anon2 = $continuation2;
                $continuation2 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                id-J3iCeTQ2 = 0;
                pointer$iv = touchSlop$iv;
                $continuation2.L$0 = touchSlopDetector$iv;
                $continuation2.L$1 = pointer$iv;
                $continuation2.L$2 = longRef;
                $continuation2.L$3 = touchSlop$iv2;
                $continuation2.L$4 = obj5;
                $continuation2.F$0 = touchSlop$iv;
                $continuation2.label = 2;
                return $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                anon2 = $continuation2;
                $continuation2 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = obj5;
                $result = obj23;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                id-J3iCeTQ2 = 0;
                break;
            case 2:
                touchSlop$iv = anon2.L$4;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv2 = l$32;
                touchSlopDetector$iv = l$0;
                onTouchSlopReached = i6;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = boxFloat;
                id-J3iCeTQ2 = 0;
                return id-J3iCeTQ2;
                id-J3iCeTQ2 = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon2.L$0 = touchSlopDetector$iv;
        anon2.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        anon2.L$2 = longRef;
        anon2.L$3 = touchSlop$iv2;
        anon2.L$4 = id-J3iCeTQ2;
        anon2.F$0 = pointer$iv;
        int i9 = 1;
        anon2.label = i9;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, id-J3iCeTQ2, anon2, i9, id-J3iCeTQ2);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation2;
            $continuation2 = anon;
        }
        return $continuation2;
    }

    public static final Object awaitLongPressOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj6;
        Object cOROUTINE_SUSPENDED;
        boolean anon;
        int i5;
        long l;
        Object obj2;
        int i;
        Object obj;
        long objectRef2;
        Ref.ObjectRef objectRef;
        List changes;
        long longPressTimeoutMillis;
        int i2;
        int i3;
        Object timeout;
        int index$iv$iv;
        int i4;
        Object obj4;
        Object obj5;
        int i7;
        Object obj3;
        int i6;
        int obj17;
        Object obj18;
        obj6 = obj20;
        anon = obj6;
        l = Integer.MIN_VALUE;
        if (obj6 instanceof DragGestureDetectorKt.awaitLongPressOrCancellation.1 && label2 &= l != 0) {
            anon = obj6;
            l = Integer.MIN_VALUE;
            if (label2 &= l != 0) {
                anon.label = label -= l;
            } else {
                anon = new DragGestureDetectorKt.awaitLongPressOrCancellation.1(obj6);
            }
        } else {
        }
        Object result = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                int i8 = awaitPointerEventScope;
                PointerEvent pointerEvent = l2;
                return i;
                i2 = 0;
                index$iv$iv = 0;
                i7 = 0;
                i6 = 0;
                index$iv$iv++;
                i2 = obj17;
                changes = obj18;
                obj18 = changes;
                obj17 = i2;
                obj5 = i;
                return i;
                obj = obj5;
                objectRef2 = new Ref.ObjectRef();
                objectRef = new Ref.ObjectRef();
                objectRef.element = obj;
                DragGestureDetectorKt.awaitLongPressOrCancellation.2 anon2 = new DragGestureDetectorKt.awaitLongPressOrCancellation.2(objectRef, objectRef2, i);
                anon.L$0 = obj;
                anon.L$1 = objectRef2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj2 = objectRef2;
                break;
            case 1:
                obj2 = l$1;
                obj = cOROUTINE_SUSPENDED;
                ResultKt.throwOnFailure(result);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        return i;
    }

    private static final Object awaitPointerSlopOrCancellation-pn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, androidx.compose.foundation.gestures.Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> onPointerSlopReached, Continuation<? super PointerInputChange> $completion) {
        PointerEvent dragEvent;
        int booleanValue;
        long $this$fastFirstOrNull$iv;
        int i5;
        int element;
        Object obj4;
        int i6;
        boolean consumed;
        Object awaitPointerEvent$default;
        List changes;
        int index$iv$iv;
        List size;
        int i2;
        int i7;
        int i4;
        int i3;
        int booleanValue2;
        int i8;
        int pressed;
        Object obj;
        int i;
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
                i3 = 0;
                i8 = 0;
                obj = obj2;
                Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)obj2.getId-J3iCeTQ(), obj2));
                $this$fastFirstOrNull$iv = valueOf;
                booleanValue = pressed + 1;
                i6 = orientation;
                element = i;
            }
            pressed = booleanValue;
            i7 = i4;
            int i9 = i7;
            $this$fastFirstOrNull$iv = touchSlopDetector.addPointerInputChange-GcwITfU(i9, DragGestureDetectorKt.pointerSlop-E8SPZFQ(awaitPointerEventScope.getViewConfiguration(), orientation));
            obj4 = $completion;
            awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
            dragEvent = pointerId;
            i6 = orientation;
            i5 = i4;
            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, i5, continuation, 1, i5);
            index$iv$iv = 0;
            size = changes;
            i2 = 0;
            i4 = i5;
            element = size.size();
            booleanValue = i7;
            $completion.invoke(i9, $this$fastFirstOrNull$iv);
            touchSlopDetector.reset();
            int i11 = 0;
            consumed = changes2;
            changes = 0;
            index$iv$iv = 0;
            while (index$iv$iv < consumed.size()) {
                i3 = 0;
                int i14 = 0;
                Boolean valueOf2 = Boolean.valueOf((PointerInputChange)consumed.get(index$iv$iv).getPressed());
                i8 = valueOf2;
                index$iv$iv++;
            }
            i7 = i4;
            $this$fastFirstOrNull$iv = i7;
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv.getId-J3iCeTQ();
            obj4 = $completion;
            i3 = 0;
            i14 = 0;
            valueOf2 = Boolean.valueOf((PointerInputChange)consumed.get(index$iv$iv).getPressed());
            i8 = valueOf2;
            if (valueOf2.booleanValue() != 0) {
            } else {
            }
            index$iv$iv++;
            obj2 = size.get(booleanValue);
            i3 = 0;
            i8 = 0;
            obj = obj2;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)obj2.getId-J3iCeTQ(), obj2));
            $this$fastFirstOrNull$iv = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            booleanValue = pressed + 1;
            i6 = orientation;
            element = i;
        }
        Object obj3 = $completion;
        return i4;
    }

    public static final Object awaitTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function2<? super PointerInputChange, ? super Offset, Unit> function23, Continuation<? super PointerInputChange> continuation4) {
        Object obj2;
        Object $result;
        int obj4;
        boolean anon;
        Object $continuation;
        int consumed;
        int i2;
        Object $continuation2;
        int i3;
        Object $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        int id-J3iCeTQ;
        PointerEvent touchSlop$iv;
        long touchSlop$iv2;
        Object touchSlopDetector$iv;
        int pointer$iv;
        int changes;
        int onTouchSlopReached;
        boolean longRef;
        int i4;
        int i;
        int index$iv$iv$iv;
        int it$iv;
        Object obj;
        Object obj3;
        int i5;
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
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = awaitPointerEventScope;
                touchSlop$iv = l2;
                touchSlopDetector$iv = continuation4;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getViewConfiguration(), PointerType.Companion.getTouch-T8wyACA());
                longRef = new Ref.LongRef();
                longRef.element = touchSlop$iv;
                touchSlop$iv = new TouchSlopDetector(0);
                return id-J3iCeTQ;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                touchSlop$iv2 = f$02;
                touchSlop$iv = obj6;
                onTouchSlopReached = i8;
                longRef = l$2;
                touchSlopDetector$iv = changes;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation2;
                $continuation2 = anon;
                $continuation = $result;
                changes = (PointerEvent)$result.getChanges();
                i4 = 0;
                i = 0;
                index$iv$iv$iv = 0;
                i5 = 0;
                i6 = 0;
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
                anon = $continuation2;
                id-J3iCeTQ = 0;
                obj4 = obj3;
                $result = obj23;
                anon = $continuation2;
                id-J3iCeTQ = 0;
                List changes2 = obj24.getChanges();
                consumed = 0;
                int i9 = 0;
                touchSlop$iv = 0;
                index$iv$iv$iv = 0;
                obj = null;
                touchSlop$iv++;
                i = 0;
                obj4 = i;
                $result = obj23;
                anon = $continuation2;
                id-J3iCeTQ = 0;
                longRef.element = (PointerInputChange)obj4.getId-J3iCeTQ();
                touchSlop$iv = obj22;
                touchSlop$iv = obj22;
                Offset pointerInputChange-GcwITfU = touchSlop$iv.addPointerInputChange-GcwITfU(obj4, touchSlop$iv2);
                touchSlopDetector$iv.invoke(obj4, pointerInputChange-GcwITfU);
                id-J3iCeTQ = obj4;
                anon = $continuation2;
                $result = obj23;
                touchSlop$iv.reset();
                $result = obj23;
                anon = $continuation2;
                $continuation2 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                id-J3iCeTQ = 0;
                pointer$iv = touchSlop$iv2;
                $continuation2.L$0 = touchSlopDetector$iv;
                $continuation2.L$1 = pointer$iv;
                $continuation2.L$2 = longRef;
                $continuation2.L$3 = touchSlop$iv;
                $continuation2.L$4 = obj4;
                $continuation2.F$0 = touchSlop$iv2;
                $continuation2.label = 2;
                return $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                anon = $continuation2;
                $continuation2 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                pointer$iv = touchSlop$iv2;
                touchSlop$iv2 = obj4;
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
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = changes;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                id-J3iCeTQ = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon.L$0 = touchSlopDetector$iv;
        anon.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        anon.L$2 = longRef;
        anon.L$3 = touchSlop$iv;
        anon.L$4 = id-J3iCeTQ;
        anon.F$0 = pointer$iv;
        int i10 = 1;
        anon.label = i10;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, id-J3iCeTQ, anon, i10, id-J3iCeTQ);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv2 = pointer$iv;
            pointer$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation2;
            $continuation2 = anon2;
        }
        return $continuation2;
    }

    public static final Object awaitVerticalDragOrCancellation-rnUCldI(AwaitPointerEventScope awaitPointerEventScope, long l2, Continuation<? super PointerInputChange> continuation3) {
        Object obj2;
        Object $result;
        boolean anon2;
        Object $continuation;
        int i5;
        Object $continuation2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalDragOrCancellation.1 anon;
        int i3;
        int $this$awaitDragOrUp_u2djO51t88$iv;
        Object obj3;
        int id-J3iCeTQ;
        int i;
        int cmp;
        int i2;
        Ref.LongRef pointerId;
        int pointer$iv2;
        Object pointer$iv;
        Object $this$awaitDragOrUp_u2djO51t88$iv2;
        int obj;
        Ref.LongRef index$iv$iv$iv2;
        int size;
        int i7;
        int index$iv$iv$iv;
        int size2;
        Object it$iv;
        Object obj4;
        int i4;
        Object obj5;
        int i6;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalDragOrCancellation.1 anon3;
        Object obj20;
        Object obj21;
        obj2 = obj23;
        anon2 = obj2;
        i3 = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.awaitVerticalDragOrCancellation.1 && label2 &= i3 != 0) {
            anon2 = obj2;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon2.label = label -= i3;
            } else {
                anon2 = new DragGestureDetectorKt.awaitVerticalDragOrCancellation.1(obj2);
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
                index$iv$iv$iv2 = new Ref.LongRef();
                index$iv$iv$iv2.element = pointerEvent;
                pointer$iv = obj8;
                $this$awaitDragOrUp_u2djO51t88$iv = obj;
                pointerId = index$iv$iv$iv2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = l$0;
                $this$awaitDragOrUp_u2djO51t88$iv2 = l$1;
                pointer$iv2 = i9;
                obj3 = $continuation2;
                anon = anon2;
                $continuation = $result;
                index$iv$iv$iv2 = (PointerEvent)$result.getChanges();
                i7 = 0;
                index$iv$iv$iv = 0;
                i4 = 0;
                i6 = 0;
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
                i4 = 0;
                index$iv$iv$iv2++;
                index$iv$iv$iv = 0;
                $continuation = index$iv$iv$iv;
                $this$awaitDragOrUp_u2djO51t88$iv2.element = (PointerInputChange)$continuation.getId-J3iCeTQ();
                id-J3iCeTQ = 0;
                $continuation = 1;
                $continuation = i8;
                i = 1;
                i = i8;
                i2 = obj4;
                i2 = 0;
                return i2;
                $result = obj20;
                anon2 = anon;
                $continuation2 = obj3;
                $this$awaitDragOrUp_u2djO51t88$iv = pointer$iv2;
                pointerId = $this$awaitDragOrUp_u2djO51t88$iv2;
                pointer$iv = obj;
                id-J3iCeTQ = 1;
                cmp = 0;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        anon2.L$0 = pointer$iv;
        anon2.L$1 = pointerId;
        anon2.label = id-J3iCeTQ;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv, cmp, anon2, id-J3iCeTQ, cmp);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            obj = pointer$iv;
            $this$awaitDragOrUp_u2djO51t88$iv2 = pointerId;
            pointer$iv2 = $this$awaitDragOrUp_u2djO51t88$iv;
            obj3 = $continuation2;
            anon = anon3;
        }
        return $continuation2;
    }

    public static final Object awaitVerticalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Function2<? super PointerInputChange, ? super Float, Unit> function24, Continuation<? super PointerInputChange> continuation5) {
        Object obj3;
        Object $result;
        int obj5;
        boolean anon;
        Object $continuation2;
        int consumed;
        int i2;
        Object $continuation;
        int i5;
        Object $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        int id-J3iCeTQ;
        long id-J3iCeTQ2;
        int touchSlop$iv2;
        Object pointerId;
        long touchSlop$iv;
        int pointer$iv;
        androidx.compose.foundation.gestures.Orientation vertical;
        int onTouchSlopReached;
        boolean longRef;
        int boxFloat;
        int onTouchSlopReached2;
        int index$iv$iv$iv;
        int it$iv;
        Object obj4;
        Object obj2;
        int i;
        Object obj;
        int i4;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalPointerSlopOrCancellation.1 anon2;
        Object obj22;
        Object obj23;
        Object obj24;
        obj3 = obj27;
        anon = obj3;
        i5 = Integer.MIN_VALUE;
        if (obj3 instanceof DragGestureDetectorKt.awaitVerticalPointerSlopOrCancellation.1 && label2 &= i5 != 0) {
            anon = obj3;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                anon.label = label -= i5;
            } else {
                anon = new DragGestureDetectorKt.awaitVerticalPointerSlopOrCancellation.1(obj3);
            }
        } else {
        }
        $result = anon.result;
        id-J3iCeTQ = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = awaitPointerEventScope;
                touchSlop$iv2 = continuation5;
                pointerId = l2;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getViewConfiguration(), function24);
                longRef = new Ref.LongRef();
                longRef.element = pointerId;
                pointerId = new TouchSlopDetector(Orientation.Vertical);
                return id-J3iCeTQ;
            case 1:
                pointerId = anon.L$3;
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                onTouchSlopReached = i7;
                longRef = l$2;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation;
                touchSlop$iv = f$02;
                touchSlop$iv2 = vertical;
                $continuation = anon;
                $continuation2 = $result;
                vertical = (PointerEvent)$result.getChanges();
                boxFloat = 0;
                onTouchSlopReached2 = 0;
                index$iv$iv$iv = 0;
                i = 0;
                i4 = 0;
                index$iv$iv$iv++;
                touchSlop$iv2 = obj22;
                $continuation2 = obj23;
                $result = obj24;
                id-J3iCeTQ = 0;
                obj24 = $result;
                obj23 = $continuation2;
                obj22 = touchSlop$iv2;
                obj2 = 0;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                obj5 = obj2;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i8 = 0;
                touchSlop$iv2 = 0;
                index$iv$iv$iv = 0;
                obj4 = null;
                touchSlop$iv2++;
                onTouchSlopReached2 = 0;
                obj5 = onTouchSlopReached2;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                longRef.element = (PointerInputChange)obj5.getId-J3iCeTQ();
                onTouchSlopReached2 = obj22;
                Offset pointerInputChange-GcwITfU = pointerId.addPointerInputChange-GcwITfU(obj5, touchSlop$iv);
                vertical = 0;
                obj22.invoke(obj5, Boxing.boxFloat(Offset.getY-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ = obj5;
                anon = $continuation;
                $result = obj23;
                pointerId.reset();
                $result = obj23;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                touchSlop$iv2 = onTouchSlopReached2;
                id-J3iCeTQ = 0;
                pointer$iv = touchSlop$iv;
                onTouchSlopReached2 = obj22;
                $continuation.L$0 = onTouchSlopReached2;
                $continuation.L$1 = pointer$iv;
                $continuation.L$2 = longRef;
                $continuation.L$3 = pointerId;
                $continuation.L$4 = obj5;
                $continuation.F$0 = touchSlop$iv;
                $continuation.label = 2;
                return $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                touchSlop$iv2 = onTouchSlopReached2;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = pointerId;
                pointerId = obj5;
                $result = obj23;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                pointerId = touchSlop$iv;
                id-J3iCeTQ = 0;
                break;
            case 2:
                pointerId = anon.L$4;
                touchSlop$iv = anon.L$3;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv2 = l$0;
                onTouchSlopReached = i6;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = vertical;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                pointerId = touchSlop$iv;
                id-J3iCeTQ = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon.L$0 = touchSlop$iv2;
        anon.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        anon.L$2 = longRef;
        anon.L$3 = pointerId;
        anon.L$4 = id-J3iCeTQ;
        anon.F$0 = pointer$iv;
        int i9 = 1;
        anon.label = i9;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, id-J3iCeTQ, anon, i9, id-J3iCeTQ);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation;
            $continuation = anon2;
        }
        return $continuation;
    }

    public static final Object awaitVerticalTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope awaitPointerEventScope, long l2, Function2<? super PointerInputChange, ? super Float, Unit> function23, Continuation<? super PointerInputChange> continuation4) {
        Object obj4;
        Object $result;
        int obj3;
        boolean anon;
        Object $continuation2;
        int consumed;
        int i4;
        Object $continuation;
        int i3;
        Object $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        int id-J3iCeTQ;
        long id-J3iCeTQ2;
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
        Object obj;
        Object obj2;
        int i;
        Object obj5;
        int i2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitVerticalTouchSlopOrCancellation.1 anon2;
        androidx.compose.foundation.gestures.TouchSlopDetector obj22;
        Object obj23;
        Object obj24;
        obj4 = obj26;
        anon = obj4;
        i3 = Integer.MIN_VALUE;
        if (obj4 instanceof DragGestureDetectorKt.awaitVerticalTouchSlopOrCancellation.1 && label2 &= i3 != 0) {
            anon = obj4;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = label -= i3;
            } else {
                anon = new DragGestureDetectorKt.awaitVerticalTouchSlopOrCancellation.1(obj4);
            }
        } else {
        }
        $result = anon.result;
        id-J3iCeTQ = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = awaitPointerEventScope;
                touchSlop$iv2 = l2;
                touchSlopDetector$iv = continuation4;
                onTouchSlopReached = 0;
                pointer$iv = DragGestureDetectorKt.pointerSlop-E8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv.getViewConfiguration(), PointerType.Companion.getTouch-T8wyACA());
                longRef = new Ref.LongRef();
                longRef.element = touchSlop$iv2;
                touchSlop$iv2 = new TouchSlopDetector(Orientation.Vertical);
                return id-J3iCeTQ;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                touchSlop$iv = f$02;
                touchSlop$iv2 = obj7;
                onTouchSlopReached = i7;
                longRef = l$2;
                touchSlopDetector$iv = boxFloat;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation;
                $continuation = anon;
                $continuation2 = $result;
                boxFloat = (PointerEvent)$result.getChanges();
                unbox-impl = 0;
                index$iv$iv$iv = 0;
                i = 0;
                i2 = 0;
                index$iv$iv$iv++;
                touchSlop$iv2 = obj22;
                $continuation2 = obj23;
                $result = obj24;
                id-J3iCeTQ = 0;
                obj24 = $result;
                obj23 = $continuation2;
                obj22 = touchSlop$iv2;
                obj2 = 0;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                obj3 = obj2;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                List changes = obj24.getChanges();
                consumed = 0;
                int i8 = 0;
                touchSlop$iv2 = 0;
                index$iv$iv$iv = 0;
                obj = null;
                touchSlop$iv2++;
                i5 = 0;
                obj3 = i5;
                $result = obj23;
                anon = $continuation;
                id-J3iCeTQ = 0;
                longRef.element = (PointerInputChange)obj3.getId-J3iCeTQ();
                touchSlop$iv2 = obj22;
                touchSlop$iv2 = obj22;
                Offset pointerInputChange-GcwITfU = touchSlop$iv2.addPointerInputChange-GcwITfU(obj3, touchSlop$iv);
                id-J3iCeTQ2 = 0;
                touchSlopDetector$iv.invoke(obj3, Boxing.boxFloat(Offset.getY-impl(pointerInputChange-GcwITfU.unbox-impl())));
                id-J3iCeTQ = obj3;
                anon = $continuation;
                $result = obj23;
                touchSlop$iv2.reset();
                $result = obj23;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                id-J3iCeTQ = 0;
                pointer$iv = touchSlop$iv;
                $continuation.L$0 = touchSlopDetector$iv;
                $continuation.L$1 = pointer$iv;
                $continuation.L$2 = longRef;
                $continuation.L$3 = touchSlop$iv2;
                $continuation.L$4 = obj3;
                $continuation.F$0 = touchSlop$iv;
                $continuation.label = 2;
                return $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = pointer$iv;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = obj3;
                $result = obj23;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                id-J3iCeTQ = 0;
                break;
            case 2:
                touchSlop$iv = anon.L$4;
                ResultKt.throwOnFailure($result);
                longRef = l$22;
                pointer$iv = f$0;
                touchSlop$iv2 = l$32;
                touchSlopDetector$iv = l$0;
                onTouchSlopReached = i6;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = boxFloat;
                id-J3iCeTQ = 0;
                return id-J3iCeTQ;
                id-J3iCeTQ = 0;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        anon.L$0 = touchSlopDetector$iv;
        anon.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        anon.L$2 = longRef;
        anon.L$3 = touchSlop$iv2;
        anon.L$4 = id-J3iCeTQ;
        anon.F$0 = pointer$iv;
        int i9 = 1;
        anon.label = i9;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv, id-J3iCeTQ, anon, i9, id-J3iCeTQ);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $continuation;
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
        Object obj2;
        Object $result;
        float distance-impl;
        boolean anon;
        Object $continuation2;
        int i2;
        Object cOROUTINE_SUSPENDED;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.drag.2 $continuation;
        int i10;
        int $this$drag_u2dVnAYq1g;
        Object index$iv$iv$iv2;
        Object obj;
        int i8;
        int size;
        int i5;
        int index$iv$iv$iv;
        int orientation2;
        int i4;
        Object obj5;
        Object $this$awaitDragOrUp_u2djO51t88$iv2;
        int pointer$iv;
        Object pointer$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv3;
        Object $this$awaitDragOrUp_u2djO51t88$iv;
        Object motionConsumed;
        Object obj3;
        Object motionConsumed2;
        Object orientation3;
        Object orientation5;
        Object onDrag;
        int orientation;
        Object onDrag2;
        Object $this$drag_u2dVnAYq1g2;
        PointerEvent onDrag3;
        Object obj4;
        Object longRef;
        int i11;
        int it$iv;
        int i6;
        int i3;
        int i7;
        int i;
        int i9;
        int i12;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.drag.2 anon2;
        Object obj24;
        Object obj25;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.drag.2 obj26;
        Object obj27;
        obj2 = obj30;
        anon = obj2;
        i10 = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorKt.drag.2 && label2 &= i10 != 0) {
            anon = obj2;
            i10 = Integer.MIN_VALUE;
            if (label2 &= i10 != 0) {
                anon.label = label -= i10;
            } else {
                anon = new DragGestureDetectorKt.drag.2(obj2);
            }
        } else {
        }
        $result = anon.result;
        i8 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                obj5 = function15;
                pointer$iv = l2;
                obj3 = orientation4;
                orientation3 = continuation6;
                orientation = 0;
                return null;
                onDrag3 = pointer$iv;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj4 = l$0;
                $this$drag_u2dVnAYq1g2 = l$1;
                onDrag = l$2;
                orientation3 = l$3;
                motionConsumed = l$4;
                $this$awaitDragOrUp_u2djO51t88$iv3 = l$5;
                pointer$iv = i17;
                i4 = i16;
                index$iv$iv$iv2 = cOROUTINE_SUSPENDED;
                $continuation = anon;
                $continuation2 = $result;
                anon.L$0 = onDrag2;
                anon.L$1 = orientation5;
                anon.L$2 = motionConsumed2;
                anon.L$3 = $this$awaitDragOrUp_u2djO51t88$iv;
                anon.L$4 = pointer$iv2;
                anon.L$5 = $this$awaitDragOrUp_u2djO51t88$iv2;
                anon.label = i8;
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv2, i5, anon, i8, i5);
                return cOROUTINE_SUSPENDED;
                $continuation2 = $result;
                $result = awaitPointerEvent$default;
                obj4 = onDrag2;
                $this$drag_u2dVnAYq1g2 = orientation5;
                onDrag = motionConsumed2;
                orientation3 = $this$awaitDragOrUp_u2djO51t88$iv;
                motionConsumed = pointer$iv2;
                $this$awaitDragOrUp_u2djO51t88$iv3 = $this$awaitDragOrUp_u2djO51t88$iv2;
                pointer$iv = orientation2;
                i4 = $this$drag_u2dVnAYq1g;
                index$iv$iv$iv2 = cOROUTINE_SUSPENDED;
                $continuation = anon2;
                longRef = (PointerEvent)$result.getChanges();
                i11 = 0;
                it$iv = 0;
                i3 = i5;
                index$iv$iv$iv = i6;
                i = 0;
                i12 = 0;
                index$iv$iv$iv++;
                $continuation2 = obj24;
                $result = obj25;
                $continuation = obj26;
                index$iv$iv$iv2 = obj27;
                obj25 = $result;
                obj24 = $continuation2;
                obj26 = $continuation;
                obj27 = index$iv$iv$iv2;
                i7 = i3;
                i7 = i3;
                List changes = obj25.getChanges();
                $continuation2 = 0;
                $continuation = 0;
                index$iv$iv$iv2 = 0;
                i11 = 0;
                i6 = 0;
                index$iv$iv$iv2++;
                longRef = i3;
                $result = longRef;
                $this$awaitDragOrUp_u2djO51t88$iv3.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation2 = 0;
                long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(i7);
                distance-impl = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getY-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getX-impl(positionChangeIgnoreConsumed);
                $result = 1;
                $result = 0;
                return i3;
                int i14 = i7;
                return i3;
                return i14;
                $this$drag_u2dVnAYq1g2.invoke(i14);
                orientation = i4;
                obj5 = obj7;
                cOROUTINE_SUSPENDED = obj27;
                obj3 = $this$drag_u2dVnAYq1g2;
                obj = obj4;
                i5 = i3;
                i8 = 1;
                onDrag3 = change;
                $result = obj24;
                anon = obj26;
                $result = obj24;
                anon = obj26;
                cOROUTINE_SUSPENDED = obj27;
                $this$drag_u2dVnAYq1g = i4;
                orientation2 = pointer$iv;
                $this$awaitDragOrUp_u2djO51t88$iv2 = $this$awaitDragOrUp_u2djO51t88$iv3;
                pointer$iv2 = motionConsumed;
                $this$awaitDragOrUp_u2djO51t88$iv = orientation3;
                motionConsumed2 = onDrag;
                orientation5 = $this$drag_u2dVnAYq1g2;
                onDrag2 = obj4;
                i5 = i3;
                i8 = 1;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        longRef = new Ref.LongRef();
        longRef.element = onDrag3;
        onDrag2 = obj;
        $this$drag_u2dVnAYq1g = orientation;
        orientation5 = obj3;
        $this$awaitDragOrUp_u2djO51t88$iv = orientation3;
        motionConsumed2 = obj5;
        orientation2 = i18;
        pointer$iv2 = obj8;
        $this$awaitDragOrUp_u2djO51t88$iv2 = longRef;
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
        int i4;
        Ref.LongRef longRef;
        int index$iv$iv$iv;
        int i5;
        Continuation continuation;
        Object awaitPointerEvent$default;
        List changes;
        int i6;
        List list;
        int booleanValue;
        int i10;
        int i3;
        int pressed;
        int i;
        int i8;
        int i9;
        int i2;
        int i11;
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
                    i8 = 0;
                    i2 = 0;
                    Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
                    id-J3iCeTQ = valueOf;
                    index$iv$iv$iv++;
                    positionChangeIgnoreConsumed = pointerId;
                    $this$fastFirstOrNull$iv$iv = i11;
                    id-J3iCeTQ = awaitPointerEventScope;
                }
                i11 = $this$fastFirstOrNull$iv$iv;
                awaitPointerEventScope = id-J3iCeTQ;
                i = i3;
                if (!PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange)i)) {
                    break loop_4;
                } else {
                }
                int i15 = 0;
                positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed((PointerInputChange)i);
                if (orientation2 == null) {
                } else {
                }
                if (orientation2 == Orientation.Vertical) {
                } else {
                }
                index$iv$iv$iv2 = Offset.getX-impl(positionChangeIgnoreConsumed);
                if (Float.compare(index$iv$iv$iv2, i17) == 0) {
                } else {
                }
                i5 = 0;
                Boolean valueOf2 = Boolean.valueOf(i5 ^= 1);
                id-J3iCeTQ = valueOf2;
                if (valueOf2.booleanValue()) {
                    break loop_4;
                } else {
                }
                positionChangeIgnoreConsumed = pointerId;
                i7 = i3;
                $this$fastFirstOrNull$iv$iv = i11;
                id-J3iCeTQ = awaitPointerEventScope;
                int i16 = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(id-J3iCeTQ, i7, obj32, i16, i7);
                i6 = 0;
                list = changes;
                booleanValue = 0;
                i3 = i7;
                index$iv$iv$iv = i10;
                i5 = pressed;
                index$iv$iv$iv2 = Offset.getY-impl(positionChangeIgnoreConsumed);
                index$iv$iv$iv2 = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                id-J3iCeTQ = 0;
                positionChangeIgnoreConsumed = changes2;
                l = 0;
                index$iv$iv$iv2 = 0;
                while (index$iv$iv$iv2 < positionChangeIgnoreConsumed.size()) {
                    list = null;
                    int i19 = 0;
                    Boolean valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
                    i10 = valueOf3;
                    index$iv$iv$iv2++;
                }
                i6 = i3;
                $this$fastFirstOrNull$iv$iv = i6;
                if ((PointerInputChange)$this$fastFirstOrNull$iv$iv == 0) {
                    break loop_4;
                } else {
                }
                longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv$iv.getId-J3iCeTQ();
                list = null;
                i19 = 0;
                valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
                i10 = valueOf3;
                if (valueOf3.booleanValue() != 0) {
                } else {
                }
                index$iv$iv$iv2++;
                i8 = 0;
                i2 = 0;
                valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
                id-J3iCeTQ = valueOf;
                if (valueOf.booleanValue()) {
                } else {
                }
                index$iv$iv$iv++;
                positionChangeIgnoreConsumed = pointerId;
                $this$fastFirstOrNull$iv$iv = i11;
                id-J3iCeTQ = awaitPointerEventScope;
            }
            while (index$iv$iv$iv < list.size()) {
                i8 = 0;
                i2 = 0;
                valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
                id-J3iCeTQ = valueOf;
                index$iv$iv$iv++;
                positionChangeIgnoreConsumed = pointerId;
                $this$fastFirstOrNull$iv$iv = i11;
                id-J3iCeTQ = awaitPointerEventScope;
            }
            i11 = $this$fastFirstOrNull$iv$iv;
            awaitPointerEventScope = id-J3iCeTQ;
            i = i3;
            if ((PointerInputChange)i != 0) {
            } else {
            }
            i = i3;
            int i13 = i;
            int i14 = i;
            orientation.invoke(i14);
            pointer = i14.getId-J3iCeTQ();
            positionChangeIgnoreConsumed = pointerId;
            i7 = i3;
            $this$fastFirstOrNull$iv$iv = i11;
            id-J3iCeTQ = $this$drag_u2dVnAYq1g;
            i4 = 0;
            longRef = new Ref.LongRef();
            longRef.element = pointer;
            if (PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange)i)) {
            } else {
            }
            i15 = 0;
            positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed((PointerInputChange)i);
            if (orientation2 == null) {
            } else {
            }
            if (orientation2 == Orientation.Vertical) {
            } else {
            }
            index$iv$iv$iv2 = Offset.getX-impl(positionChangeIgnoreConsumed);
            if (Float.compare(index$iv$iv$iv2, i17) == 0) {
            } else {
            }
            i5 = 0;
            valueOf2 = Boolean.valueOf(i5 ^= 1);
            id-J3iCeTQ = valueOf2;
            if (valueOf2.booleanValue()) {
            } else {
            }
            positionChangeIgnoreConsumed = pointerId;
            i7 = i3;
            $this$fastFirstOrNull$iv$iv = i11;
            id-J3iCeTQ = awaitPointerEventScope;
            i5 = pressed;
            index$iv$iv$iv2 = Offset.getY-impl(positionChangeIgnoreConsumed);
            index$iv$iv$iv2 = Offset.getDistance-impl(positionChangeIgnoreConsumed);
            id-J3iCeTQ = 0;
            positionChangeIgnoreConsumed = changes2;
            l = 0;
            index$iv$iv$iv2 = 0;
            while (index$iv$iv$iv2 < positionChangeIgnoreConsumed.size()) {
                list = null;
                i19 = 0;
                valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
                i10 = valueOf3;
                index$iv$iv$iv2++;
            }
            i6 = i3;
            $this$fastFirstOrNull$iv$iv = i6;
            if ((PointerInputChange)$this$fastFirstOrNull$iv$iv == 0) {
            } else {
            }
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv$iv.getId-J3iCeTQ();
            list = null;
            i19 = 0;
            valueOf3 = Boolean.valueOf((PointerInputChange)positionChangeIgnoreConsumed.get(index$iv$iv$iv2).getPressed());
            i10 = valueOf3;
            if (valueOf3.booleanValue() != 0) {
            } else {
            }
            index$iv$iv$iv2++;
            i8 = 0;
            i2 = 0;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)list.get(index$iv$iv$iv).getId-J3iCeTQ(), id-J3iCeTQ));
            id-J3iCeTQ = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            index$iv$iv$iv++;
            positionChangeIgnoreConsumed = pointerId;
            $this$fastFirstOrNull$iv$iv = i11;
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
        Object obj;
        Object $result;
        float distance-impl;
        boolean anon2;
        Object $continuation2;
        int i6;
        Object $continuation;
        int i5;
        int $this$drag_u2dVnAYq1g$iv;
        Object obj2;
        long id-J3iCeTQ;
        int i2;
        int index$iv$iv$iv$iv;
        int id-J3iCeTQ2;
        int $this$awaitDragOrUp_u2djO51t88$iv$iv;
        int i8;
        Object obj4;
        int pointer$iv$iv;
        Object pointer$iv$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        androidx.compose.foundation.gestures.Orientation orientation$iv;
        Object orientation$iv2;
        Object $this$drag_u2dVnAYq1g$iv4;
        Object $this$drag_u2dVnAYq1g$iv2;
        Object onDrag;
        PointerEvent $this$drag_u2dVnAYq1g$iv3;
        Object obj3;
        Object longRef;
        int i4;
        int it$iv$iv;
        int i9;
        int i7;
        int i;
        int i10;
        int i3;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.horizontalDrag.1 anon;
        int obj24;
        Object obj25;
        Object obj26;
        obj = obj28;
        anon2 = obj;
        i5 = Integer.MIN_VALUE;
        if (obj instanceof DragGestureDetectorKt.horizontalDrag.1 && label2 &= i5 != 0) {
            anon2 = obj;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                anon2.label = label -= i5;
            } else {
                anon2 = new DragGestureDetectorKt.horizontalDrag.1(obj);
            }
        } else {
        }
        $result = anon2.result;
        index$iv$iv$iv$iv = 1;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                i8 = l2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = continuation4;
                orientation$iv = Orientation.Horizontal;
                $this$drag_u2dVnAYq1g$iv4 = 0;
                $this$drag_u2dVnAYq1g$iv3 = i8;
                i2 = 1;
                i2 = 0;
                return Boxing.boxBoolean(i2);
            case 1:
                ResultKt.throwOnFailure($result);
                obj3 = l$0;
                onDrag = l$1;
                $this$drag_u2dVnAYq1g$iv4 = l$2;
                orientation$iv = l$3;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = l$4;
                pointer$iv$iv = i16;
                i8 = i14;
                obj2 = $continuation;
                $continuation = anon2;
                $continuation2 = $result;
                anon2.L$0 = $this$drag_u2dVnAYq1g$iv2;
                anon2.L$1 = orientation$iv2;
                anon2.L$2 = orientation$iv;
                anon2.L$3 = pointer$iv$iv2;
                anon2.L$4 = obj4;
                anon2.label = index$iv$iv$iv$iv;
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv$iv2, id-J3iCeTQ2, anon2, index$iv$iv$iv$iv, id-J3iCeTQ2);
                return $continuation;
                $continuation2 = $result;
                $result = awaitPointerEvent$default;
                obj3 = $this$drag_u2dVnAYq1g$iv2;
                onDrag = orientation$iv2;
                $this$drag_u2dVnAYq1g$iv4 = orientation$iv;
                orientation$iv = pointer$iv$iv2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = obj4;
                pointer$iv$iv = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                i8 = $this$drag_u2dVnAYq1g$iv;
                obj2 = $continuation;
                $continuation = anon;
                longRef = (PointerEvent)$result.getChanges();
                i4 = 0;
                it$iv$iv = 0;
                index$iv$iv$iv$iv = i9;
                i = 0;
                i3 = 0;
                index$iv$iv$iv$iv++;
                i8 = obj24;
                $continuation2 = obj25;
                $result = obj26;
                id-J3iCeTQ2 = 0;
                obj26 = $result;
                obj25 = $continuation2;
                obj24 = i8;
                i7 = 0;
                i7 = 0;
                List changes = obj26.getChanges();
                $continuation2 = 0;
                id-J3iCeTQ = 0;
                index$iv$iv$iv$iv = 0;
                i4 = 0;
                i9 = 0;
                index$iv$iv$iv$iv++;
                longRef = 0;
                $result = longRef;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation2 = 0;
                long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(i7);
                distance-impl = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getY-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getX-impl(positionChangeIgnoreConsumed);
                $result = 1;
                $result = 0;
                $result = obj25;
                anon2 = $continuation;
                id-J3iCeTQ2 = 0;
                int i12 = i7;
                id-J3iCeTQ = 0;
                $result = obj25;
                anon2 = $continuation;
                id-J3iCeTQ2 = 0;
                id-J3iCeTQ2 = i12;
                anon2 = $continuation;
                $result = obj25;
                i2 = 1;
                i2 = 0;
                return Boxing.boxBoolean(i2);
                obj3.invoke(i12);
                orientation$iv = $this$drag_u2dVnAYq1g$iv4;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = obj3;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ2 = 0;
                $this$drag_u2dVnAYq1g$iv4 = obj24;
                $result = obj25;
                anon2 = $continuation;
                $continuation = obj2;
                obj2 = onDrag;
                $this$drag_u2dVnAYq1g$iv3 = anon;
                $result = obj25;
                anon2 = $continuation;
                $continuation = obj2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv = pointer$iv$iv;
                obj4 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                pointer$iv$iv2 = orientation$iv;
                orientation$iv = $this$drag_u2dVnAYq1g$iv4;
                orientation$iv2 = onDrag;
                $this$drag_u2dVnAYq1g$iv2 = obj3;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ2 = 0;
                $this$drag_u2dVnAYq1g$iv = obj24;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        longRef = new Ref.LongRef();
        longRef.element = $this$drag_u2dVnAYq1g$iv3;
        orientation$iv2 = obj2;
        $this$drag_u2dVnAYq1g$iv = pointer$iv;
        $this$drag_u2dVnAYq1g$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        pointer$iv$iv2 = obj5;
        $this$awaitDragOrUp_u2djO51t88$iv$iv = i17;
        obj4 = longRef;
    }

    private static final boolean isPointerUp-DmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        int i;
        List pressed;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i3;
        boolean it;
        int i2;
        long id-J3iCeTQ;
        int i5 = 0;
        pressed = changes;
        final int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < pressed.size()) {
            i3 = 0;
            i2 = 0;
            index$iv$iv++;
        }
        obj2 = 0;
        i = 0;
        int i6 = 1;
        if (obj2 != null && (PointerInputChange)obj2.getPressed() == i6) {
            if (obj2.getPressed() == i6) {
                i = i6;
            }
        }
        return i ^= i6;
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
        Object obj;
        Object $result;
        float distance-impl;
        boolean anon;
        Object $continuation;
        int i;
        Object $continuation2;
        int i8;
        int $this$drag_u2dVnAYq1g$iv;
        Object obj3;
        long id-J3iCeTQ;
        int i10;
        int index$iv$iv$iv$iv;
        int id-J3iCeTQ2;
        int $this$awaitDragOrUp_u2djO51t88$iv$iv;
        int i6;
        Object obj2;
        int pointer$iv$iv;
        Object pointer$iv$iv2;
        Object $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        androidx.compose.foundation.gestures.Orientation orientation$iv2;
        Object orientation$iv;
        Object $this$drag_u2dVnAYq1g$iv4;
        Object $this$drag_u2dVnAYq1g$iv2;
        Object onDrag;
        PointerEvent $this$drag_u2dVnAYq1g$iv3;
        Object obj4;
        Object longRef;
        int i7;
        int it$iv$iv;
        int i3;
        int i5;
        int i9;
        int i4;
        int i2;
        androidx.compose.foundation.gestures.DragGestureDetectorKt.verticalDrag.1 anon2;
        int obj24;
        Object obj25;
        Object obj26;
        obj = obj28;
        anon = obj;
        i8 = Integer.MIN_VALUE;
        if (obj instanceof DragGestureDetectorKt.verticalDrag.1 && label2 &= i8 != 0) {
            anon = obj;
            i8 = Integer.MIN_VALUE;
            if (label2 &= i8 != 0) {
                anon.label = label -= i8;
            } else {
                anon = new DragGestureDetectorKt.verticalDrag.1(obj);
            }
        } else {
        }
        $result = anon.result;
        index$iv$iv$iv$iv = 1;
        id-J3iCeTQ2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                i6 = l2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = continuation4;
                orientation$iv2 = Orientation.Vertical;
                $this$drag_u2dVnAYq1g$iv4 = 0;
                $this$drag_u2dVnAYq1g$iv3 = i6;
                i10 = 1;
                i10 = 0;
                return Boxing.boxBoolean(i10);
            case 1:
                ResultKt.throwOnFailure($result);
                obj4 = l$0;
                onDrag = l$1;
                $this$drag_u2dVnAYq1g$iv4 = l$2;
                orientation$iv2 = l$3;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = l$4;
                pointer$iv$iv = i16;
                i6 = i14;
                obj3 = $continuation2;
                $continuation2 = anon;
                $continuation = $result;
                anon.L$0 = $this$drag_u2dVnAYq1g$iv2;
                anon.L$1 = orientation$iv;
                anon.L$2 = orientation$iv2;
                anon.L$3 = pointer$iv$iv2;
                anon.L$4 = obj2;
                anon.label = index$iv$iv$iv$iv;
                Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(pointer$iv$iv2, id-J3iCeTQ2, anon, index$iv$iv$iv$iv, id-J3iCeTQ2);
                return $continuation2;
                $continuation = $result;
                $result = awaitPointerEvent$default;
                obj4 = $this$drag_u2dVnAYq1g$iv2;
                onDrag = orientation$iv;
                $this$drag_u2dVnAYq1g$iv4 = orientation$iv2;
                orientation$iv2 = pointer$iv$iv2;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = obj2;
                pointer$iv$iv = $this$awaitDragOrUp_u2djO51t88$iv$iv;
                i6 = $this$drag_u2dVnAYq1g$iv;
                obj3 = $continuation2;
                $continuation2 = anon2;
                longRef = (PointerEvent)$result.getChanges();
                i7 = 0;
                it$iv$iv = 0;
                index$iv$iv$iv$iv = i3;
                i9 = 0;
                i2 = 0;
                index$iv$iv$iv$iv++;
                i6 = obj24;
                $continuation = obj25;
                $result = obj26;
                id-J3iCeTQ2 = 0;
                obj26 = $result;
                obj25 = $continuation;
                obj24 = i6;
                i5 = 0;
                i5 = 0;
                List changes = obj26.getChanges();
                $continuation = 0;
                id-J3iCeTQ = 0;
                index$iv$iv$iv$iv = 0;
                i7 = 0;
                i3 = 0;
                index$iv$iv$iv$iv++;
                longRef = 0;
                $result = longRef;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2.element = (PointerInputChange)$result.getId-J3iCeTQ();
                $continuation = 0;
                long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(i5);
                distance-impl = Offset.getDistance-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getY-impl(positionChangeIgnoreConsumed);
                distance-impl = Offset.getX-impl(positionChangeIgnoreConsumed);
                $result = 1;
                $result = 0;
                $result = obj25;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                int i12 = i5;
                id-J3iCeTQ = 0;
                $result = obj25;
                anon = $continuation2;
                id-J3iCeTQ2 = 0;
                id-J3iCeTQ2 = i12;
                anon = $continuation2;
                $result = obj25;
                i10 = 1;
                i10 = 0;
                return Boxing.boxBoolean(i10);
                obj4.invoke(i12);
                orientation$iv2 = $this$drag_u2dVnAYq1g$iv4;
                $this$awaitDragOrUp_u2djO51t88$iv$iv2 = obj4;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ2 = 0;
                $this$drag_u2dVnAYq1g$iv4 = obj24;
                $result = obj25;
                anon = $continuation2;
                $continuation2 = obj3;
                obj3 = onDrag;
                $this$drag_u2dVnAYq1g$iv3 = anon2;
                $result = obj25;
                anon = $continuation2;
                $continuation2 = obj3;
                $this$awaitDragOrUp_u2djO51t88$iv$iv = pointer$iv$iv;
                obj2 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
                pointer$iv$iv2 = orientation$iv2;
                orientation$iv2 = $this$drag_u2dVnAYq1g$iv4;
                orientation$iv = onDrag;
                $this$drag_u2dVnAYq1g$iv2 = obj4;
                index$iv$iv$iv$iv = 1;
                id-J3iCeTQ2 = 0;
                $this$drag_u2dVnAYq1g$iv = obj24;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        longRef = new Ref.LongRef();
        longRef.element = $this$drag_u2dVnAYq1g$iv3;
        orientation$iv = obj3;
        $this$drag_u2dVnAYq1g$iv = pointer$iv;
        $this$drag_u2dVnAYq1g$iv2 = $this$awaitDragOrUp_u2djO51t88$iv$iv2;
        pointer$iv$iv2 = obj5;
        $this$awaitDragOrUp_u2djO51t88$iv$iv = i17;
        obj2 = longRef;
    }
}
