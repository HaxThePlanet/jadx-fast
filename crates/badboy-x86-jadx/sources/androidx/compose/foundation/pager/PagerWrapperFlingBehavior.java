package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000cH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0010", d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PagerWrapperFlingBehavior implements FlingBehavior {

    private final TargetedFlingBehavior originalFlingBehavior;
    private final androidx.compose.foundation.pager.PagerState pagerState;
    public PagerWrapperFlingBehavior(TargetedFlingBehavior originalFlingBehavior, androidx.compose.foundation.pager.PagerState pagerState) {
        super();
        this.originalFlingBehavior = originalFlingBehavior;
        this.pagerState = pagerState;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final TargetedFlingBehavior getOriginalFlingBehavior() {
        return this.originalFlingBehavior;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final androidx.compose.foundation.pager.PagerState getPagerState() {
        return this.pagerState;
    }

    public Object performFling(ScrollScope scrollScope, float f2, Continuation<? super Float> continuation3) {
        boolean anon;
        int i3;
        int i;
        androidx.compose.foundation.pager.PagerWrapperFlingBehavior label;
        ScrollScope scrollScope2;
        TargetedFlingBehavior originalFlingBehavior;
        int i4;
        androidx.compose.foundation.pager.PagerWrapperFlingBehavior.performFling.2.1 anon2;
        int i2;
        Object obj9;
        Object obj11;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof PagerWrapperFlingBehavior.performFling.1 && label2 &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj11 -= i;
            } else {
                anon = new PagerWrapperFlingBehavior.performFling.1(this, continuation3);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                label = this;
                i4 = 0;
                anon2 = new PagerWrapperFlingBehavior.performFling.2.1(label, scrollScope);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj11);
                i4 = obj9;
                obj9 = obj11;
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        return Boxing.boxFloat((Number)obj9.floatValue());
    }
}
