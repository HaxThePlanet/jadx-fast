package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u0007\u001a;\u0010\u0008\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\n¢\u0006\u0002\u0008\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a;\u0010\u000f\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\n¢\u0006\u0002\u0008\rH\u0087@¢\u0006\u0002\u0010\u000e¨\u0006\u0010", d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ForEachGestureKt {
    public static final boolean allPointersUp(AwaitPointerEventScope $this$allPointersUp) {
        int $this$fastForEach$iv$iv;
        int index$iv$iv;
        int i;
        Object obj2;
        Object obj;
        int i2;
        boolean it;
        int i3;
        final int i5 = 0;
        List list = changes;
        final int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i3 = 0;
            index$iv$iv++;
        }
        $this$fastForEach$iv$iv = 0;
        return $this$fastForEach$iv$iv ^ 1;
    }

    public static final Object awaitAllPointersUp(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation2) {
        boolean $result;
        Object $continuation;
        int i5;
        androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp.3 $continuation2;
        int i;
        Object allPointersUp;
        int i3;
        int i2;
        int index$iv$iv;
        int size;
        Object obj;
        Object obj2;
        int i4;
        boolean it;
        int i6;
        androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp.3 anon;
        Object obj14;
        Object obj15;
        $result = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof ForEachGestureKt.awaitAllPointersUp.3 && label &= i != 0) {
            $result = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj15 -= i;
            } else {
                $result = new ForEachGestureKt.awaitAllPointersUp.3(continuation2);
            }
        } else {
        }
        obj15 = $result.result;
        final int i7 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                return Unit.INSTANCE;
            case 1:
                obj14 = $result.L$0;
                ResultKt.throwOnFailure(obj15);
                allPointersUp = $continuation2;
                $continuation2 = $result;
                $continuation = obj15;
                obj15 = (PointerEvent)obj15.getChanges();
                i3 = 0;
                i2 = 0;
                index$iv$iv = 0;
                i4 = 0;
                i6 = 0;
                obj15 = i7;
                index$iv$iv++;
                obj15 = 0;
                obj15 = $continuation;
                $result = $continuation2;
                obj15 = $continuation;
                $result = $continuation2;
                $continuation2 = allPointersUp;
                return Unit.INSTANCE;
            default:
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
        }
        $result.L$0 = obj14;
        $result.label = i7;
        Object awaitPointerEvent = obj14.awaitPointerEvent(PointerEventPass.Final, $result);
        if (awaitPointerEvent != $continuation2) {
            $continuation = obj15;
            obj15 = awaitPointerEvent;
            allPointersUp = $continuation2;
            $continuation2 = anon;
        }
        return $continuation2;
    }

    public static final Object awaitAllPointersUp(PointerInputScope $this$awaitAllPointersUp, Continuation<? super Unit> $completion) {
        ForEachGestureKt.awaitAllPointersUp.2 anon = new ForEachGestureKt.awaitAllPointersUp.2(0);
        Object awaitPointerEventScope = $this$awaitAllPointersUp.awaitPointerEventScope((Function2)anon, $completion);
        if (awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitPointerEventScope;
        }
        return Unit.INSTANCE;
    }

    public static final Object awaitEachGesture(PointerInputScope $this$awaitEachGesture, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        int i = 0;
        ForEachGestureKt.awaitEachGesture.2 anon = new ForEachGestureKt.awaitEachGesture.2($completion.getContext(), block, 0);
        Object awaitPointerEventScope = $this$awaitEachGesture.awaitPointerEventScope((Function2)anon, $completion);
        if (awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitPointerEventScope;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @ReplaceWith(...))
    public static final Object forEachGesture(PointerInputScope pointerInputScope, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i;
        Throwable th2;
        Object l$0;
        Throwable context;
        Throwable th;
        Object obj6;
        Object obj7;
        Object obj8;
        anon = continuation3;
        th2 = Integer.MIN_VALUE;
        if (continuation3 instanceof ForEachGestureKt.forEachGesture.1 && label &= th2 != 0) {
            anon = continuation3;
            th2 = Integer.MIN_VALUE;
            if (label &= th2 != 0) {
                anon.label = obj8 -= th2;
            } else {
                anon = new ForEachGestureKt.forEachGesture.1(continuation3);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                l$0 = 0;
                context = anon.getContext();
                break;
            case 1:
                obj6 = anon.L$2;
                obj7 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                anon.L$0 = l$0;
                anon.L$1 = obj7;
                anon.L$2 = obj6;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                context = obj6;
                obj6 = l$0;
                break;
            case 2:
                obj7 = anon.L$1;
                ResultKt.throwOnFailure(obj8);
                context = obj6;
                obj6 = l$0;
                break;
            case 3:
                obj7 = anon.L$1;
                ResultKt.throwOnFailure(obj8);
                context = obj6;
                obj6 = l$0;
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        if (JobKt.isActive(context)) {
            anon.L$0 = obj6;
            anon.L$1 = obj7;
            anon.L$2 = context;
            anon.label = 1;
            if (obj7.invoke(obj6, anon) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            } else {
            }
        }
        return Unit.INSTANCE;
    }
}
