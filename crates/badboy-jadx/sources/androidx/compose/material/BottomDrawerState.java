package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0013\u0008\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000cJ\"\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\u0008\u0008\u0002\u0010-\u001a\u00020\u000bH\u0080@¢\u0006\u0004\u0008.\u0010/J\u000e\u00100\u001a\u00020+H\u0086@¢\u0006\u0002\u00101J\u0015\u0010\u0006\u001a\u00020\u00082\u0006\u00102\u001a\u00020\u0003H\u0000¢\u0006\u0002\u00083J\u000e\u00104\u001a\u00020+H\u0086@¢\u0006\u0002\u00101J\u000e\u00105\u001a\u00020+H\u0086@¢\u0006\u0002\u00101J\u0018\u0010$\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0003H\u0007J\r\u00108\u001a\u00020\u000bH\u0000¢\u0006\u0002\u00089J\u0018\u0010:\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003H\u0080@¢\u0006\u0004\u0008;\u0010<R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008%\u0010&\u001a\u0004\u0008'\u0010#R\u0011\u0010(\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008)\u0010\u0013¨\u0006>", d2 = {"Landroidx/compose/material/BottomDrawerState;", "", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material/BottomDrawerValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomDrawerValue;", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "isClosed", "()Z", "isExpanded", "isOpen", "isOpenEnabled", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "offset", "getOffset", "()F", "progress", "getProgress$annotations", "()V", "getProgress", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/BottomDrawerValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "confirmStateChange$material_release", "expand", "open", "from", "to", "requireOffset", "requireOffset$material_release", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomDrawerState {

    public static final int $stable = 8;
    public static final androidx.compose.material.BottomDrawerState.Companion Companion;
    private final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.BottomDrawerValue> anchoredDraggableState;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r¨\u0006\u000f", d2 = {"Landroidx/compose/material/BottomDrawerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material.BottomDrawerState, androidx.compose.material.BottomDrawerValue> Saver(Density density, Function1<? super androidx.compose.material.BottomDrawerValue, Boolean> confirmStateChange, AnimationSpec<Float> animationSpec) {
            BottomDrawerState.Companion.Saver.2 anon = new BottomDrawerState.Companion.Saver.2(density, confirmStateChange, animationSpec);
            return SaverKt.Saver((Function2)BottomDrawerState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        BottomDrawerState.Companion companion = new BottomDrawerState.Companion(0);
        BottomDrawerState.Companion = companion;
        int i = 8;
    }

    public BottomDrawerState(androidx.compose.material.BottomDrawerValue initialValue, Density density, Function1<? super androidx.compose.material.BottomDrawerValue, Boolean> confirmStateChange, AnimationSpec<Float> animationSpec) {
        super();
        BottomDrawerState.anchoredDraggableState.1 anon = new BottomDrawerState.anchoredDraggableState.1(density);
        BottomDrawerState.anchoredDraggableState.2 anon2 = new BottomDrawerState.anchoredDraggableState.2(density);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, (Function1)anon, (Function0)anon2, animationSpec, confirmStateChange);
        this.anchoredDraggableState = anchoredDraggableState;
        this.nestedScrollConnection = DrawerKt.access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(this.anchoredDraggableState);
    }

    public BottomDrawerState(androidx.compose.material.BottomDrawerValue bottomDrawerValue, Density density2, Function1 function13, AnimationSpec animationSpec4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.compose.material.BottomDrawerState.1 obj3;
        androidx.compose.animation.core.TweenSpec obj4;
        if (i5 & 4 != 0) {
            obj3 = BottomDrawerState.1.INSTANCE;
        }
        if (i5 &= 8 != 0) {
            obj4 = DrawerDefaults.INSTANCE.getAnimationSpec();
        }
        super(bottomDrawerValue, density2, obj3, obj4);
    }

    public static Object animateTo$material_release$default(androidx.compose.material.BottomDrawerState bottomDrawerState, androidx.compose.material.BottomDrawerValue bottomDrawerValue2, float f3, Continuation continuation4, int i5, Object object6) {
        float obj2;
        if (i5 &= 2 != 0) {
            obj2 = bottomDrawerState.anchoredDraggableState.getLastVelocity();
        }
        return bottomDrawerState.animateTo$material_release(bottomDrawerValue2, obj2, continuation4);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(...))
    public static void getProgress$annotations() {
    }

    private final boolean isOpenEnabled() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(BottomDrawerValue.Open);
    }

    public final Object animateTo$material_release(androidx.compose.material.BottomDrawerValue target, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, target, velocity, $completion);
        if (animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo;
        }
        return Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Closed, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final boolean confirmStateChange$material_release(androidx.compose.material.BottomDrawerValue value) {
        return (Boolean)this.anchoredDraggableState.getConfirmValueChange$material_release().invoke(value).booleanValue();
    }

    public final Object expand(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Expanded, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.BottomDrawerValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final androidx.compose.material.BottomDrawerValue getCurrentValue() {
        return (BottomDrawerValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material_release() {
        return this.density;
    }

    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final androidx.compose.material.BottomDrawerValue getTargetValue() {
        return (BottomDrawerValue)this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isClosed() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Closed ? 1 : 0;
        return i;
    }

    public final boolean isExpanded() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Expanded ? 1 : 0;
        return i;
    }

    public final boolean isOpen() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Closed ? 1 : 0;
        return i;
    }

    public final Object open(Continuation<? super Unit> $completion) {
        androidx.compose.material.BottomDrawerValue expanded;
        expanded = isOpenEnabled() ? BottomDrawerValue.Open : BottomDrawerValue.Expanded;
        Object obj8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, expanded, 0, $completion, 2, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final float progress(androidx.compose.material.BottomDrawerValue from, androidx.compose.material.BottomDrawerValue to) {
        int i;
        float positionOf = this.anchoredDraggableState.getAnchors().positionOf(from);
        float positionOf2 = this.anchoredDraggableState.getAnchors().positionOf(to);
        i2 /= i4;
        if (Float.isNaN(i3)) {
            i = 1065353216;
        } else {
            i = Math.abs(i3);
        }
        return i;
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material_release(Density <set-?>) {
        this.density = <set-?>;
    }

    public final Object snapTo$material_release(androidx.compose.material.BottomDrawerValue target, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, target, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
