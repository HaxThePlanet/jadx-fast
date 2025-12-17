package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aa\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH\u0080@ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aW\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018H\u0082Hø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u001e\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragGestureDetectorCopyKt {

    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;
    static {
        int i3 = 0;
        DragGestureDetectorCopyKt.mouseSlop = Dp.constructor-impl((float)l);
        int i2 = 0;
        DragGestureDetectorCopyKt.defaultTouchSlop = Dp.constructor-impl((float)i);
        int i4 = 0;
        DragGestureDetectorCopyKt.mouseToTouchSlopRatio = mouseSlop /= defaultTouchSlop;
    }

    public static final Object awaitHorizontalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Function2<? super PointerInputChange, ? super Float, Unit> function24, Continuation<? super PointerInputChange> continuation5) {
        Object obj4;
        Object $result;
        boolean anon;
        Object $continuation2;
        int i5;
        Object $continuation;
        int i2;
        Object $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
        int onPointerSlopReached2;
        Object totalPositionChange$iv;
        int touchSlop$iv2;
        long touchSlop$iv;
        float pointer$iv;
        int $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        Ref.LongRef onPointerSlopReached;
        int changes;
        int i6;
        int i7;
        int index$iv$iv$iv;
        int it$iv;
        Object obj2;
        Object obj3;
        int i;
        Object obj;
        int i4;
        androidx.compose.material3.internal.DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation.1 f;
        Object obj22;
        Object obj23;
        Object obj24;
        obj4 = obj27;
        anon = obj4;
        i2 = Integer.MIN_VALUE;
        if (obj4 instanceof DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation.1 && label2 &= i2 != 0) {
            anon = obj4;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = label -= i2;
            } else {
                anon = new DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation.1(obj4);
            }
        } else {
        }
        $result = anon.result;
        onPointerSlopReached2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = awaitPointerEventScope;
                totalPositionChange$iv = continuation5;
                touchSlop$iv2 = l2;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = 0;
                pointer$iv = DragGestureDetectorCopyKt.pointerSlop-E8SPZFQ($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2.getViewConfiguration(), function24);
                onPointerSlopReached = new Ref.LongRef();
                onPointerSlopReached.element = touchSlop$iv2;
                touchSlop$iv2 = 0;
                return onPointerSlopReached2;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                onPointerSlopReached = l$2;
                touchSlop$iv = f$02;
                touchSlop$iv2 = f$12;
                totalPositionChange$iv = l$0;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = i14;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = $continuation;
                $continuation = anon;
                $continuation2 = $result;
                changes = (PointerEvent)$result.getChanges();
                i7 = 0;
                index$iv$iv$iv = 0;
                i = 0;
                i4 = 0;
                index$iv$iv$iv++;
                onPointerSlopReached2 = 0;
                totalPositionChange$iv = obj22;
                $continuation2 = obj23;
                $result = obj24;
                obj24 = $result;
                obj23 = $continuation2;
                obj22 = totalPositionChange$iv;
                obj3 = 0;
                Intrinsics.checkNotNull(obj3);
                Object obj5 = obj3;
                $result = obj23;
                anon = $continuation;
                onPointerSlopReached2 = 0;
                List changes2 = obj24.getChanges();
                int i9 = 0;
                int i15 = 0;
                totalPositionChange$iv = 0;
                index$iv$iv$iv = 0;
                obj2 = null;
                totalPositionChange$iv++;
                i7 = 0;
                int i8 = i7;
                $result = obj23;
                anon = $continuation;
                onPointerSlopReached2 = 0;
                onPointerSlopReached.element = (PointerInputChange)i8.getId-J3iCeTQ();
                totalPositionChange$iv = obj22;
                $result = obj23;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = pointer$iv;
                onPointerSlopReached2 = 0;
                pointer$iv = touchSlop$iv;
                int i10 = 0;
                int i16 = 0;
                int i17 = touchSlop$iv2 + i11;
                onPointerSlopReached2 = obj22;
                $continuation.L$0 = onPointerSlopReached2;
                $continuation.L$1 = pointer$iv;
                $continuation.L$2 = onPointerSlopReached;
                $continuation.L$3 = obj5;
                $continuation.F$0 = touchSlop$iv;
                $continuation.F$1 = i17;
                $continuation.label = 2;
                return $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                touchSlop$iv2 = i17;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = pointer$iv;
                totalPositionChange$iv = onPointerSlopReached2;
                pointer$iv = touchSlop$iv;
                touchSlop$iv = obj5;
                $result = obj23;
                onPointerSlopReached2 = 0;
                onPointerSlopReached2 = 0;
                Object obj6 = obj22;
                obj6.invoke(obj5, Boxing.boxFloat(i17 -= i12));
                onPointerSlopReached2 = obj5;
                anon = $continuation;
                $result = obj23;
                return onPointerSlopReached2;
                touchSlop$iv2 = 0;
                $result = obj23;
                anon = $continuation;
                $continuation = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
                totalPositionChange$iv = obj6;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = pointer$iv;
                onPointerSlopReached2 = 0;
                pointer$iv = touchSlop$iv;
                break;
            case 2:
                touchSlop$iv = anon.L$3;
                ResultKt.throwOnFailure($result);
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = i13;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = obj7;
                touchSlop$iv2 = f$1;
                totalPositionChange$iv = l$02;
                onPointerSlopReached = l$22;
                pointer$iv = f;
                onPointerSlopReached2 = 0;
                onPointerSlopReached2 = 0;
                return onPointerSlopReached2;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        anon.L$0 = totalPositionChange$iv;
        anon.L$1 = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
        anon.L$2 = onPointerSlopReached;
        anon.L$3 = onPointerSlopReached2;
        anon.F$0 = pointer$iv;
        anon.F$1 = touchSlop$iv2;
        int i19 = 1;
        anon.label = i19;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2, onPointerSlopReached2, anon, i19, onPointerSlopReached2);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv = pointer$iv;
            pointer$iv = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2;
            $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv2 = $continuation;
            $continuation = f;
        }
        return $continuation;
    }

    private static final Object awaitPointerSlopOrCancellation-pn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> onPointerSlopReached, Function1<? super Offset, Float> getDragDirectionValue, Continuation<? super PointerInputChange> $completion) {
        PointerEvent dragEvent;
        int booleanValue;
        long $this$fastFirstOrNull$iv;
        int element;
        long id-J3iCeTQ;
        float pointerSlop-E8SPZFQ;
        int i6;
        int i2;
        int totalPositionChange;
        Object awaitPointerEvent$default;
        int index$iv$iv;
        int size;
        List consumed;
        Object obj4;
        int i8;
        int i7;
        int i;
        int booleanValue2;
        int i3;
        int pressed;
        int i4;
        Object obj;
        int i5;
        float f;
        final AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
        dragEvent = pointerId;
        final Object obj3 = $completion;
        final Continuation continuation = obj31;
        element = 0;
        if (DragGestureDetectorCopyKt.isPointerUp-DmW0f2w(awaitPointerEventScope.getCurrentEvent(), dragEvent)) {
            return null;
        }
        pointerSlop-E8SPZFQ = DragGestureDetectorCopyKt.pointerSlop-E8SPZFQ(awaitPointerEventScope.getViewConfiguration(), onPointerSlopReached);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = dragEvent;
        totalPositionChange = 0;
        while (/* condition */) {
            while (booleanValue < size2) {
                Object obj2 = consumed.get(booleanValue);
                booleanValue2 = 0;
                pressed = 0;
                obj = obj2;
                Boolean valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)obj2.getId-J3iCeTQ(), obj2));
                $this$fastFirstOrNull$iv = valueOf;
                booleanValue = i4 + 1;
                element = i5;
                pointerSlop-E8SPZFQ = f;
            }
            i4 = booleanValue;
            i5 = element;
            f = pointerSlop-E8SPZFQ;
            i7 = i;
            Intrinsics.checkNotNull(i7);
            int i9 = i7;
            totalPositionChange += $this$fastFirstOrNull$iv;
            getDragDirectionValue.invoke(i9, Float.valueOf(totalPositionChange - i13));
            totalPositionChange = 0;
            dragEvent = pointerId;
            i6 = i;
            element = i5;
            pointerSlop-E8SPZFQ = f;
            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, i6, continuation, 1, i6);
            consumed = changes2;
            i8 = 0;
            i = i6;
            booleanValue = i7;
            awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
            obj4 = getDragDirectionValue;
            int i10 = 0;
            pointerSlop-E8SPZFQ = changes;
            i2 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < pointerSlop-E8SPZFQ.size()) {
                i7 = 0;
                int i16 = 0;
                Boolean valueOf3 = Boolean.valueOf((PointerInputChange)pointerSlop-E8SPZFQ.get(index$iv$iv).getPressed());
                i3 = valueOf3;
                index$iv$iv++;
            }
            i8 = i;
            $this$fastFirstOrNull$iv = i8;
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv.getId-J3iCeTQ();
            obj4 = getDragDirectionValue;
            i7 = 0;
            i16 = 0;
            valueOf3 = Boolean.valueOf((PointerInputChange)pointerSlop-E8SPZFQ.get(index$iv$iv).getPressed());
            i3 = valueOf3;
            if (valueOf3.booleanValue() != 0) {
            } else {
            }
            index$iv$iv++;
            obj2 = consumed.get(booleanValue);
            booleanValue2 = 0;
            pressed = 0;
            obj = obj2;
            valueOf = Boolean.valueOf(PointerId.equals-impl0((PointerInputChange)obj2.getId-J3iCeTQ(), obj2));
            $this$fastFirstOrNull$iv = valueOf;
            if (valueOf.booleanValue()) {
            } else {
            }
            booleanValue = i4 + 1;
            element = i5;
            pointerSlop-E8SPZFQ = f;
        }
        return i;
    }

    private static final boolean isPointerUp-DmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        int i2;
        List pressed;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i;
        boolean it;
        int i3;
        long id-J3iCeTQ;
        int i5 = 0;
        pressed = changes;
        final int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < pressed.size()) {
            i = 0;
            i3 = 0;
            index$iv$iv++;
        }
        obj2 = 0;
        i2 = 0;
        int i6 = 1;
        if (obj2 != null && (PointerInputChange)obj2.getPressed() == i6) {
            if (obj2.getPressed() == i6) {
                i2 = i6;
            }
        }
        return i2 ^= i6;
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
}
