package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0002\u0008\u000f*\u0001\u0013\u0008\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\u0006\u0010\"\u001a\u00020\u000bJ\u001b\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001eH\u0086@ø\u0001\u0000¢\u0006\u0004\u0008&\u0010!J\u0018\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*JA\u0010(\u001a\u00020$2\u0008\u0008\u0002\u0010+\u001a\u00020,2'\u0010-\u001a#\u0008\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020$00\u0012\u0006\u0012\u0004\u0018\u00010\u00010.¢\u0006\u0002\u00081H\u0086@¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u000bJ8\u00104\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rJ&\u00105\u001a\u00020\u0019*\u00020\u00162\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u0014\u0010:\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008;\u0010*J\n\u0010:\u001a\u00020<*\u00020<J\u0014\u0010=\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008>\u0010*J\u0016\u0010?\u001a\u00020\u001e*\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008@\u0010*J\u0014\u0010A\u001a\u00020<*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ\u0016\u0010A\u001a\u00020<*\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008D\u0010CJ\u0017\u0010E\u001a\u00020\u0019*\u00020<ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GJ\u001e\u00104\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010H\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\u0008I\u0010JR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u00020\u0010X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006K", d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "update", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollingLogic {

    public static final int $stable = 8;
    private androidx.compose.foundation.gestures.FlingBehavior flingBehavior;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final androidx.compose.foundation.gestures.ScrollingLogic.nestedScrollScope.1 nestedScrollScope;
    private androidx.compose.foundation.gestures.Orientation orientation;
    private androidx.compose.foundation.gestures.ScrollScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1<Offset, Offset> performScrollForOverscroll;
    private boolean reverseDirection;
    private androidx.compose.foundation.gestures.ScrollableState scrollableState;
    static {
        final int i = 8;
    }

    public ScrollingLogic(androidx.compose.foundation.gestures.ScrollableState scrollableState, OverscrollEffect overscrollEffect, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, androidx.compose.foundation.gestures.Orientation orientation, boolean reverseDirection, NestedScrollDispatcher nestedScrollDispatcher) {
        super();
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.latestScrollSource = NestedScrollSource.Companion.getUserInput-WNlRxjI();
        this.outerStateScope = ScrollableKt.access$getNoOpScrollScope$p();
        ScrollingLogic.nestedScrollScope.1 anon = new ScrollingLogic.nestedScrollScope.1(this);
        this.nestedScrollScope = anon;
        ScrollingLogic.performScrollForOverscroll.1 anon2 = new ScrollingLogic.performScrollForOverscroll.1(this);
        this.performScrollForOverscroll = (Function1)anon2;
    }

    public static final androidx.compose.foundation.gestures.FlingBehavior access$getFlingBehavior$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.flingBehavior;
    }

    public static final int access$getLatestScrollSource$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.latestScrollSource;
    }

    public static final NestedScrollDispatcher access$getNestedScrollDispatcher$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.nestedScrollDispatcher;
    }

    public static final androidx.compose.foundation.gestures.ScrollingLogic.nestedScrollScope.1 access$getNestedScrollScope$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.nestedScrollScope;
    }

    public static final androidx.compose.foundation.gestures.ScrollScope access$getOuterStateScope$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.outerStateScope;
    }

    public static final OverscrollEffect access$getOverscrollEffect$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.overscrollEffect;
    }

    public static final Function1 access$getPerformScrollForOverscroll$p(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.performScrollForOverscroll;
    }

    public static final boolean access$getShouldDispatchOverscroll(androidx.compose.foundation.gestures.ScrollingLogic $this) {
        return $this.getShouldDispatchOverscroll();
    }

    public static final long access$performScroll-3eAAhYA(androidx.compose.foundation.gestures.ScrollingLogic $this, androidx.compose.foundation.gestures.ScrollScope $receiver, long delta, int source) {
        return $this.performScroll-3eAAhYA($receiver, delta, source);
    }

    public static final void access$setLatestScrollSource$p(androidx.compose.foundation.gestures.ScrollingLogic $this, int <set-?>) {
        $this.latestScrollSource = <set-?>;
    }

    public static final void access$setOuterStateScope$p(androidx.compose.foundation.gestures.ScrollingLogic $this, androidx.compose.foundation.gestures.ScrollScope <set-?>) {
        $this.outerStateScope = <set-?>;
    }

    public static final float access$toFloat-TH1AsA0(androidx.compose.foundation.gestures.ScrollingLogic $this, long $receiver) {
        return $this.toFloat-TH1AsA0($receiver);
    }

    public static final long access$update-QWom1Mo(androidx.compose.foundation.gestures.ScrollingLogic $this, long $receiver, float newValue) {
        return $this.update-QWom1Mo($receiver, newValue);
    }

    private final boolean getShouldDispatchOverscroll() {
        int i;
        boolean canScrollBackward;
        if (!this.scrollableState.getCanScrollForward()) {
            if (this.scrollableState.getCanScrollBackward()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final long performScroll-3eAAhYA(androidx.compose.foundation.gestures.ScrollScope $this$performScroll_u2d3eAAhYA, long delta, int source) {
        final long l = delta;
        final Object obj = obj19;
        final long l2 = dispatchPreScroll-OzD1aCk;
        final long minus-MK-Hz9U2 = Offset.minus-MK-Hz9U(l, obj2);
        float float-k-4lQ0M = toFloat-k-4lQ0M(reverseIfNeeded-MK-Hz9U(singleAxisOffset-MK-Hz9U(minus-MK-Hz9U2)));
        final long reverseIfNeeded-MK-Hz9U2 = reverseIfNeeded-MK-Hz9U(toOffset-tuRUvjQ($this$performScroll_u2d3eAAhYA.scrollBy(float-k-4lQ0M)));
        float f = float-k-4lQ0M;
        return Offset.plus-MK-Hz9U(Offset.plus-MK-Hz9U(l2, obj11), float-k-4lQ0M);
    }

    public static Object scroll$default(androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic, MutatePriority mutatePriority2, Function2 function23, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (i5 &= 1 != 0) {
            obj1 = MutatePriority.Default;
        }
        return scrollingLogic.scroll(obj1, function23, continuation4);
    }

    private final long singleAxisVelocity-AH228Gc(long $this$singleAxisVelocity_u2dAH228Gc) {
        int $this$singleAxisVelocity_u2dAH228Gc2;
        int i;
        long l;
        int i4;
        int i5;
        int i2;
        int i3;
        long obj9;
        final androidx.compose.foundation.gestures.Orientation horizontal = Orientation.Horizontal;
        if (this.orientation == horizontal) {
            i = $this$singleAxisVelocity_u2dAH228Gc;
            obj9 = Velocity.copy-OhffZ5M$default(i, obj3, 0, 0, 1);
            $this$singleAxisVelocity_u2dAH228Gc2 = i;
        } else {
            obj9 = Velocity.copy-OhffZ5M$default($this$singleAxisVelocity_u2dAH228Gc, horizontal, 0, 0, 2);
        }
        return obj9;
    }

    private final float toFloat-TH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        float x-impl;
        if (this.orientation == Orientation.Horizontal) {
            x-impl = Velocity.getX-impl($this$toFloat_u2dTH1AsA0);
        } else {
            x-impl = Velocity.getY-impl($this$toFloat_u2dTH1AsA0);
        }
        return x-impl;
    }

    private final long update-QWom1Mo(long $this$update_u2dQWom1Mo, float newValue) {
        int $this$update_u2dQWom1Mo2;
        int i2;
        float f2;
        float f;
        int i4;
        int i;
        int i3;
        long obj9;
        final androidx.compose.foundation.gestures.Orientation horizontal = Orientation.Horizontal;
        if (this.orientation == horizontal) {
            i2 = $this$update_u2dQWom1Mo;
            f = obj11;
            obj9 = Velocity.copy-OhffZ5M$default(i2, obj3, f, 0, 2);
            $this$update_u2dQWom1Mo2 = i2;
            f2 = f;
        } else {
            obj9 = Velocity.copy-OhffZ5M$default($this$update_u2dQWom1Mo, horizontal, 0, obj11, 1);
        }
        return obj9;
    }

    public final Object doFlingAnimation-QWom1Mo(long l, Continuation<? super Velocity> continuation2) {
        boolean anon;
        int i3;
        int i2;
        androidx.compose.foundation.gestures.ScrollingLogic.doFlingAnimation.2 label;
        androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic;
        Ref.LongRef longRef;
        long l2;
        int i;
        Object obj9;
        int obj10;
        Object obj11;
        anon = obj11;
        i2 = Integer.MIN_VALUE;
        if (obj11 instanceof ScrollingLogic.doFlingAnimation.1 && label2 &= i2 != 0) {
            anon = obj11;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj11 -= i2;
            } else {
                anon = new ScrollingLogic.doFlingAnimation.1(this, obj11);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                scrollingLogic = this;
                l2 = l;
                longRef = new Ref.LongRef();
                longRef.element = l2;
                label = new ScrollingLogic.doFlingAnimation.2(scrollingLogic, longRef, l2, obj6, 0);
                anon.L$0 = longRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj9 = longRef;
                break;
            case 1:
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        return Velocity.box-impl(obj9.element);
    }

    public final boolean isVertical() {
        int i;
        i = this.orientation == Orientation.Vertical ? 1 : 0;
        return i;
    }

    public final Object onDragStopped-sF-c-tU(long initialVelocity, Continuation<? super Unit> $completion) {
        boolean shouldDispatchOverscroll;
        Unit iNSTANCE;
        Object cOROUTINE_SUSPENDED;
        final long singleAxisVelocity-AH228Gc = singleAxisVelocity-AH228Gc(initialVelocity);
        ScrollingLogic.onDragStopped.performFling.1 anon = new ScrollingLogic.onDragStopped.performFling.1(this, 0);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            if (getShouldDispatchOverscroll()) {
                Object toFling-BMRW4eQ = overscrollEffect.applyToFling-BMRW4eQ(singleAxisVelocity-AH228Gc, obj1, (Function2)anon);
                if (toFling-BMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return toFling-BMRW4eQ;
                }
                iNSTANCE = Unit.INSTANCE;
            } else {
                Object invoke = anon.invoke(Velocity.box-impl(singleAxisVelocity-AH228Gc), obj9);
                if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return invoke;
                } else {
                    iNSTANCE = Unit.INSTANCE;
                }
            }
        } else {
        }
        return iNSTANCE;
    }

    public final long performRawScroll-MK-Hz9U(long scroll) {
        long offset-tuRUvjQ;
        float reverseIfNeeded;
        if (this.scrollableState.isScrollInProgress()) {
            offset-tuRUvjQ = Offset.Companion.getZero-F1C5BW0();
        } else {
            offset-tuRUvjQ = toOffset-tuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(toFloat-k-4lQ0M(scroll)))));
        }
        return offset-tuRUvjQ;
    }

    public final float reverseIfNeeded(float $this$reverseIfNeeded) {
        int i;
        if (this.reverseDirection) {
            f *= $this$reverseIfNeeded;
        } else {
            i = $this$reverseIfNeeded;
        }
        return i;
    }

    public final long reverseIfNeeded-MK-Hz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        long times-tuRUvjQ;
        if (this.reverseDirection) {
            times-tuRUvjQ = Offset.times-tuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, obj4);
        } else {
            times-tuRUvjQ = $this$reverseIfNeeded_u2dMK_u2dHz9U;
        }
        return times-tuRUvjQ;
    }

    public final Object scroll(MutatePriority scrollPriority, Function2<? super androidx.compose.foundation.gestures.NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        ScrollingLogic.scroll.2 anon = new ScrollingLogic.scroll.2(this, block, 0);
        Object scroll = this.scrollableState.scroll(scrollPriority, (Function2)anon, $completion);
        if (scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    public final boolean shouldScrollImmediately() {
        int scrollInProgress;
        int i;
        if (!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (overscrollEffect != null) {
                scrollInProgress = overscrollEffect.isInProgress();
            } else {
                scrollInProgress = i;
            }
            if (scrollInProgress != 0) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public final long singleAxisOffset-MK-Hz9U(long $this$singleAxisOffset_u2dMK_u2dHz9U) {
        int $this$singleAxisOffset_u2dMK_u2dHz9U2;
        int i5;
        long l;
        int i2;
        int i3;
        int i4;
        int i;
        long obj9;
        final androidx.compose.foundation.gestures.Orientation horizontal = Orientation.Horizontal;
        if (this.orientation == horizontal) {
            i5 = $this$singleAxisOffset_u2dMK_u2dHz9U;
            obj9 = Offset.copy-dBAh8RU$default(i5, obj3, 0, 0, 1);
            $this$singleAxisOffset_u2dMK_u2dHz9U2 = i5;
        } else {
            obj9 = Offset.copy-dBAh8RU$default($this$singleAxisOffset_u2dMK_u2dHz9U, horizontal, 0, 0, 2);
        }
        return obj9;
    }

    public final float toFloat-k-4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        float x-impl;
        if (this.orientation == Orientation.Horizontal) {
            x-impl = Offset.getX-impl($this$toFloat_u2dk_u2d4lQ0M);
        } else {
            x-impl = Offset.getY-impl($this$toFloat_u2dk_u2d4lQ0M);
        }
        return x-impl;
    }

    public final long toOffset-tuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        long zero-F1C5BW0;
        int orientation;
        androidx.compose.foundation.gestures.Orientation horizontal;
        int i = 0;
        orientation = Float.compare($this$toOffset_u2dtuRUvjQ, i) == 0 ? 1 : 0;
        if (orientation != 0) {
            zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
        } else {
            if (this.orientation == Orientation.Horizontal) {
                zero-F1C5BW0 = OffsetKt.Offset($this$toOffset_u2dtuRUvjQ, i);
            } else {
                zero-F1C5BW0 = OffsetKt.Offset(i, $this$toOffset_u2dtuRUvjQ);
            }
        }
        return zero-F1C5BW0;
    }

    public final boolean update(androidx.compose.foundation.gestures.ScrollableState scrollableState, androidx.compose.foundation.gestures.Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        int resetPointerInputHandling;
        resetPointerInputHandling = 0;
        if (!Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            this.scrollableState = scrollableState;
            resetPointerInputHandling = 1;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            resetPointerInputHandling = 1;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
            resetPointerInputHandling = 1;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return resetPointerInputHandling;
    }
}
