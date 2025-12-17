package androidx.compose.material;

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
@Metadata(d1 = "\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aa\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH\u0080@ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aW\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018H\u0082Hø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u001e\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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
        Object obj2;
        Object $result;
        boolean anon;
        Object $continuation;
        int i;
        Object $continuation2;
        int i2;
        Object $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        int onPointerSlopReached2;
        Object totalPositionChange$iv;
        int touchSlop$iv;
        long touchSlop$iv2;
        float pointer$iv;
        int $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv;
        Ref.LongRef onPointerSlopReached;
        int changes;
        int i5;
        int i7;
        int index$iv$iv$iv;
        int it$iv;
        Object obj3;
        Object obj;
        int i4;
        Object obj4;
        int i6;
        androidx.compose.material.DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation.1 f;
        Object obj22;
        Object obj23;
        Object obj24;
        obj2 = obj27;
        anon = obj2;
        i2 = Integer.MIN_VALUE;
        if (obj2 instanceof DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation.1 && label2 &= i2 != 0) {
            anon = obj2;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = label -= i2;
            } else {
                anon = new DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation.1(obj2);
            }
        } else {
        }
        $result = anon.result;
        onPointerSlopReached2 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = awaitPointerEventScope;
                totalPositionChange$iv = continuation5;
                touchSlop$iv = l2;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = 0;
                pointer$iv = DragGestureDetectorCopyKt.pointerSlop-E8SPZFQ($i$f$awaitPointerSlopOrCancellationPn7EDYM.getViewConfiguration(), function24);
                onPointerSlopReached = new Ref.LongRef();
                onPointerSlopReached.element = touchSlop$iv;
                touchSlop$iv = 0;
                return onPointerSlopReached2;
            case 1:
                pointer$iv = anon.L$1;
                ResultKt.throwOnFailure($result);
                onPointerSlopReached = l$2;
                touchSlop$iv2 = f$02;
                touchSlop$iv = f$12;
                totalPositionChange$iv = l$0;
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM2;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
                $continuation2 = anon;
                $continuation = $result;
                changes = (PointerEvent)$result.getChanges();
                i7 = 0;
                index$iv$iv$iv = 0;
                i4 = 0;
                i6 = 0;
                index$iv$iv$iv++;
                onPointerSlopReached2 = 0;
                totalPositionChange$iv = obj22;
                $continuation = obj23;
                $result = obj24;
                obj24 = $result;
                obj23 = $continuation;
                obj22 = totalPositionChange$iv;
                obj = 0;
                Intrinsics.checkNotNull(obj);
                Object obj5 = obj;
                $result = obj23;
                anon = $continuation2;
                onPointerSlopReached2 = 0;
                List changes2 = obj24.getChanges();
                int i9 = 0;
                int i14 = 0;
                totalPositionChange$iv = 0;
                index$iv$iv$iv = 0;
                obj3 = null;
                totalPositionChange$iv++;
                i7 = 0;
                int i8 = i7;
                $result = obj23;
                anon = $continuation2;
                onPointerSlopReached2 = 0;
                onPointerSlopReached.element = (PointerInputChange)i8.getId-J3iCeTQ();
                totalPositionChange$iv = obj22;
                $result = obj23;
                anon = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                onPointerSlopReached2 = 0;
                pointer$iv = touchSlop$iv2;
                int i10 = 0;
                int i15 = 0;
                int i16 = touchSlop$iv + i11;
                onPointerSlopReached2 = obj22;
                $continuation2.L$0 = onPointerSlopReached2;
                $continuation2.L$1 = pointer$iv;
                $continuation2.L$2 = onPointerSlopReached;
                $continuation2.L$3 = obj5;
                $continuation2.F$0 = touchSlop$iv2;
                $continuation2.F$1 = i16;
                $continuation2.label = 2;
                return $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                anon = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                touchSlop$iv = i16;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                totalPositionChange$iv = onPointerSlopReached2;
                pointer$iv = touchSlop$iv2;
                touchSlop$iv2 = obj5;
                $result = obj23;
                onPointerSlopReached2 = 0;
                onPointerSlopReached2 = 0;
                Object obj6 = obj22;
                obj6.invoke(obj5, Boxing.boxFloat(i16 -= i12));
                onPointerSlopReached2 = obj5;
                anon = $continuation2;
                $result = obj23;
                return onPointerSlopReached2;
                touchSlop$iv = 0;
                $result = obj23;
                anon = $continuation2;
                $continuation2 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
                totalPositionChange$iv = obj6;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = pointer$iv;
                onPointerSlopReached2 = 0;
                pointer$iv = touchSlop$iv2;
                break;
            case 2:
                touchSlop$iv2 = anon.L$3;
                ResultKt.throwOnFailure($result);
                $this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv = i13;
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = obj7;
                touchSlop$iv = f$1;
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
        anon.L$1 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        anon.L$2 = onPointerSlopReached;
        anon.L$3 = onPointerSlopReached2;
        anon.F$0 = pointer$iv;
        anon.F$1 = touchSlop$iv;
        int i18 = 1;
        anon.label = i18;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default($i$f$awaitPointerSlopOrCancellationPn7EDYM, onPointerSlopReached2, anon, i18, onPointerSlopReached2);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent$default;
            touchSlop$iv2 = pointer$iv;
            pointer$iv = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = $continuation2;
            $continuation2 = f;
        }
        return $continuation2;
    }

    private static final Object awaitPointerSlopOrCancellation-pn7EDYM(AwaitPointerEventScope $this$awaitPointerSlopOrCancellation_u2dpn7EDYM, long pointerId, int pointerType, Function2<? super PointerInputChange, ? super Float, Unit> onPointerSlopReached, Function1<? super Offset, Float> getDragDirectionValue, Continuation<? super PointerInputChange> $completion) {
        PointerEvent dragEvent;
        int booleanValue;
        long $this$fastFirstOrNull$iv;
        int $i$f$awaitPointerSlopOrCancellationPn7EDYM;
        long id-J3iCeTQ;
        float pointerSlop-E8SPZFQ;
        int i8;
        int i3;
        int totalPositionChange;
        Object awaitPointerEvent$default;
        int index$iv$iv;
        int size;
        List consumed;
        Object obj4;
        int i;
        int i6;
        int i5;
        int booleanValue2;
        int i2;
        int pressed;
        int i4;
        Object obj;
        int i7;
        float f;
        final AwaitPointerEventScope awaitPointerEventScope = $this$awaitPointerSlopOrCancellation_u2dpn7EDYM;
        dragEvent = pointerId;
        final Object obj3 = $completion;
        final Continuation continuation = obj31;
        $i$f$awaitPointerSlopOrCancellationPn7EDYM = 0;
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
                $i$f$awaitPointerSlopOrCancellationPn7EDYM = i7;
                pointerSlop-E8SPZFQ = f;
            }
            i4 = booleanValue;
            i7 = $i$f$awaitPointerSlopOrCancellationPn7EDYM;
            f = pointerSlop-E8SPZFQ;
            i6 = i5;
            Intrinsics.checkNotNull(i6);
            int i9 = i6;
            totalPositionChange += $this$fastFirstOrNull$iv;
            getDragDirectionValue.invoke(i9, Float.valueOf(totalPositionChange - i13));
            totalPositionChange = 0;
            dragEvent = pointerId;
            i8 = i5;
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = i7;
            pointerSlop-E8SPZFQ = f;
            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, i8, continuation, 1, i8);
            consumed = changes2;
            i = 0;
            i5 = i8;
            booleanValue = i6;
            awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
            obj4 = getDragDirectionValue;
            int i10 = 0;
            pointerSlop-E8SPZFQ = changes;
            i3 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < pointerSlop-E8SPZFQ.size()) {
                i6 = 0;
                int i16 = 0;
                Boolean valueOf3 = Boolean.valueOf((PointerInputChange)pointerSlop-E8SPZFQ.get(index$iv$iv).getPressed());
                i2 = valueOf3;
                index$iv$iv++;
            }
            i = i5;
            $this$fastFirstOrNull$iv = i;
            longRef.element = (PointerInputChange)$this$fastFirstOrNull$iv.getId-J3iCeTQ();
            obj4 = getDragDirectionValue;
            i6 = 0;
            i16 = 0;
            valueOf3 = Boolean.valueOf((PointerInputChange)pointerSlop-E8SPZFQ.get(index$iv$iv).getPressed());
            i2 = valueOf3;
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
            $i$f$awaitPointerSlopOrCancellationPn7EDYM = i7;
            pointerSlop-E8SPZFQ = f;
        }
        return i5;
    }

    private static final boolean isPointerUp-DmW0f2w(PointerEvent $this$isPointerUp_u2dDmW0f2w, long pointerId) {
        int i3;
        List pressed;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i2;
        boolean it;
        int i;
        long id-J3iCeTQ;
        int i5 = 0;
        pressed = changes;
        final int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < pressed.size()) {
            i2 = 0;
            i = 0;
            index$iv$iv++;
        }
        obj = 0;
        i3 = 0;
        int i6 = 1;
        if (obj != null && (PointerInputChange)obj.getPressed() == i6) {
            if (obj.getPressed() == i6) {
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
}
