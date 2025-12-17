package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref.FloatRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0008\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "value", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScrollExtensionsKt {
    public static final Object animateScrollBy(androidx.compose.foundation.gestures.ScrollableState scrollableState, float f2, AnimationSpec<Float> animationSpec3, Continuation<? super Float> continuation4) {
        boolean anon;
        int i;
        androidx.compose.foundation.gestures.ScrollableState label;
        int i3;
        androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy.2 anon2;
        int i4;
        int i2;
        Object obj7;
        Object obj8;
        Object obj10;
        anon = continuation4;
        i3 = Integer.MIN_VALUE;
        if (continuation4 instanceof ScrollExtensionsKt.animateScrollBy.1 && label2 &= i3 != 0) {
            anon = continuation4;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj10 -= i3;
            } else {
                anon = new ScrollExtensionsKt.animateScrollBy.1(continuation4);
            }
        } else {
        }
        final androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy.1 anon4 = anon;
        obj10 = anon4.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                obj7 = new Ref.FloatRef();
                ScrollExtensionsKt.animateScrollBy.2 anon3 = new ScrollExtensionsKt.animateScrollBy.2(f2, animationSpec3, obj7, 0);
                anon4.L$0 = obj7;
                anon4.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj7 = anon4.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        return Boxing.boxFloat(obj7.element);
    }

    public static Object animateScrollBy$default(androidx.compose.foundation.gestures.ScrollableState scrollableState, float f2, AnimationSpec animationSpec3, Continuation continuation4, int i5, Object object6) {
        androidx.compose.animation.core.SpringSpec obj2;
        int obj4;
        int obj5;
        if (i5 &= 2 != 0) {
            obj4 = 0;
            obj5 = 0;
            obj2 = AnimationSpecKt.spring$default(obj4, obj4, obj5, 7, obj5);
        }
        return ScrollExtensionsKt.animateScrollBy(scrollableState, f2, obj2, continuation4);
    }

    public static final Object scrollBy(androidx.compose.foundation.gestures.ScrollableState scrollableState, float f2, Continuation<? super Float> continuation3) {
        boolean anon;
        int i4;
        androidx.compose.foundation.gestures.ScrollableState label;
        int i2;
        androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy.2 anon2;
        int i3;
        int i;
        Object obj7;
        Object obj8;
        Object obj9;
        anon = continuation3;
        i2 = Integer.MIN_VALUE;
        if (continuation3 instanceof ScrollExtensionsKt.scrollBy.1 && label2 &= i2 != 0) {
            anon = continuation3;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj9 -= i2;
            } else {
                anon = new ScrollExtensionsKt.scrollBy.1(continuation3);
            }
        } else {
        }
        final androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy.1 anon4 = anon;
        obj9 = anon4.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                obj7 = new Ref.FloatRef();
                ScrollExtensionsKt.scrollBy.2 anon3 = new ScrollExtensionsKt.scrollBy.2(obj7, f2, 0);
                anon4.L$0 = obj7;
                anon4.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj7 = anon4.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        return Boxing.boxFloat(obj7.element);
    }

    public static final Object stopScroll(androidx.compose.foundation.gestures.ScrollableState $this$stopScroll, MutatePriority scrollPriority, Continuation<? super Unit> $completion) {
        ScrollExtensionsKt.stopScroll.2 anon = new ScrollExtensionsKt.stopScroll.2(0);
        Object scroll = $this$stopScroll.scroll(scrollPriority, (Function2)anon, $completion);
        if (scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    public static Object stopScroll$default(androidx.compose.foundation.gestures.ScrollableState scrollableState, MutatePriority mutatePriority2, Continuation continuation3, int i4, Object object5) {
        MutatePriority obj1;
        if (i4 &= 1 != 0) {
            obj1 = MutatePriority.Default;
        }
        return ScrollExtensionsKt.stopScroll(scrollableState, obj1, continuation3);
    }
}
