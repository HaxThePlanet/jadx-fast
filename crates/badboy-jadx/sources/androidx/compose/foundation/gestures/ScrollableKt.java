package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.FloatRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\r\u001a^\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001aH\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\u001f\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "DefaultScrollMotionDurationScaleFactor", "", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "UnityDensity", "androidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1", "Landroidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1;", "scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScrollableKt {

    private static final Function1<PointerInputChange, Boolean> CanDragCalculation = null;
    private static final MotionDurationScale DefaultScrollMotionDurationScale = null;
    private static final float DefaultScrollMotionDurationScaleFactor = 1f;
    private static final androidx.compose.foundation.gestures.ScrollScope NoOpScrollScope;
    private static final androidx.compose.foundation.gestures.ScrollableKt.UnityDensity.1 UnityDensity;
    static {
        ScrollableKt.CanDragCalculation = (Function1)ScrollableKt.CanDragCalculation.1.INSTANCE;
        ScrollableKt.NoOpScrollScope.1 anon = new ScrollableKt.NoOpScrollScope.1();
        ScrollableKt.NoOpScrollScope = (ScrollScope)anon;
        ScrollableKt.DefaultScrollMotionDurationScale.1 anon2 = new ScrollableKt.DefaultScrollMotionDurationScale.1();
        ScrollableKt.DefaultScrollMotionDurationScale = (MotionDurationScale)anon2;
        ScrollableKt.UnityDensity.1 anon3 = new ScrollableKt.UnityDensity.1();
        ScrollableKt.UnityDensity = anon3;
    }

    public static final Function1 access$getCanDragCalculation$p() {
        return ScrollableKt.CanDragCalculation;
    }

    public static final androidx.compose.foundation.gestures.ScrollScope access$getNoOpScrollScope$p() {
        return ScrollableKt.NoOpScrollScope;
    }

    public static final androidx.compose.foundation.gestures.ScrollableKt.UnityDensity.1 access$getUnityDensity$p() {
        return ScrollableKt.UnityDensity;
    }

    public static final Object access$semanticsScrollBy-d-4ec7I(androidx.compose.foundation.gestures.ScrollingLogic $receiver, long offset, Continuation $completion) {
        return ScrollableKt.semanticsScrollBy-d-4ec7I($receiver, offset, $completion);
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return ScrollableKt.DefaultScrollMotionDurationScale;
    }

    public static final Modifier scrollable(Modifier $this$scrollable, androidx.compose.foundation.gestures.ScrollableState state, androidx.compose.foundation.gestures.Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, MutableInteractionSource interactionSource, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        ScrollableElement scrollableElement = new ScrollableElement(state, orientation, overscrollEffect, enabled, reverseDirection, flingBehavior, interactionSource, bringIntoViewSpec);
        return $this$scrollable.then((Modifier)scrollableElement);
    }

    public static final Modifier scrollable(Modifier $this$scrollable, androidx.compose.foundation.gestures.ScrollableState state, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, boolean reverseDirection, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, MutableInteractionSource interactionSource) {
        return ScrollableKt.scrollable$default($this$scrollable, state, orientation, 0, enabled, reverseDirection, flingBehavior, interactionSource, 0, 128, 0);
    }

    public static Modifier scrollable$default(Modifier modifier, androidx.compose.foundation.gestures.ScrollableState scrollableState2, androidx.compose.foundation.gestures.Orientation orientation3, OverscrollEffect overscrollEffect4, boolean z5, boolean z6, androidx.compose.foundation.gestures.FlingBehavior flingBehavior7, MutableInteractionSource mutableInteractionSource8, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec9, int i10, Object object11) {
        int i2;
        int i;
        int i4;
        int i5;
        int i3;
        int obj13;
        int i6 = i10;
        i2 = i6 & 8 != 0 ? obj13 : z5;
        i = i6 & 16 != 0 ? obj13 : z6;
        int i8 = 0;
        i4 = i6 & 32 != 0 ? i8 : flingBehavior7;
        i5 = i6 & 64 != 0 ? i8 : mutableInteractionSource8;
        i3 = i6 & 128 != 0 ? i8 : bringIntoViewSpec9;
        return ScrollableKt.scrollable(modifier, scrollableState2, orientation3, overscrollEffect4, i2, i, i4, i5, i3);
    }

    public static Modifier scrollable$default(Modifier modifier, androidx.compose.foundation.gestures.ScrollableState scrollableState2, androidx.compose.foundation.gestures.Orientation orientation3, boolean z4, boolean z5, androidx.compose.foundation.gestures.FlingBehavior flingBehavior6, MutableInteractionSource mutableInteractionSource7, int i8, Object object9) {
        int i;
        int i2;
        int i3;
        int i4;
        int obj10;
        int obj11;
        i = i8 & 4 != 0 ? obj10 : z4;
        i2 = i8 & 8 != 0 ? obj11 : z5;
        obj11 = 0;
        i3 = i8 & 16 != 0 ? obj11 : flingBehavior6;
        i4 = i8 & 32 != 0 ? obj11 : mutableInteractionSource7;
        return ScrollableKt.scrollable(modifier, scrollableState2, orientation3, i, i2, i3, i4);
    }

    private static final Object semanticsScrollBy-d-4ec7I(androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic, long l2, Continuation<? super Offset> continuation3) {
        boolean anon;
        int i2;
        int i3;
        androidx.compose.foundation.gestures.ScrollableKt.semanticsScrollBy.2 label;
        androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic2;
        long l;
        Ref.FloatRef floatRef;
        int i;
        Object obj8;
        Object obj9;
        Object obj11;
        anon = obj11;
        i3 = Integer.MIN_VALUE;
        if (obj11 instanceof ScrollableKt.semanticsScrollBy.1 && label2 &= i3 != 0) {
            anon = obj11;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj11 -= i3;
            } else {
                anon = new ScrollableKt.semanticsScrollBy.1(obj11);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                scrollingLogic2 = scrollingLogic;
                floatRef = new Ref.FloatRef();
                label = new ScrollableKt.semanticsScrollBy.2(scrollingLogic2, l2, obj5, floatRef, 0);
                anon.L$0 = scrollingLogic2;
                anon.L$1 = floatRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj9 = scrollingLogic2;
                obj8 = floatRef;
                break;
            case 1:
                obj8 = anon.L$1;
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        return Offset.box-impl(obj9.toOffset-tuRUvjQ(obj8.element));
    }
}
