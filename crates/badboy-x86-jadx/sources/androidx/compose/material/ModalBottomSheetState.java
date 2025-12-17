package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
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
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0002\n\u0002\u0008\u0014\u0008\u0007\u0018\u0000 72\u00020\u0001:\u00017BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0008¢\u0006\u0002\u0010\rJ\"\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0008\u0008\u0002\u0010&\u001a\u00020\u000bH\u0080@¢\u0006\u0004\u0008'\u0010(J\u0010\u0010)\u001a\u00020$H\u0080@¢\u0006\u0004\u0008*\u0010+J\u0010\u0010,\u001a\u00020$H\u0080@¢\u0006\u0004\u0008-\u0010+J\u000e\u0010.\u001a\u00020$H\u0086@¢\u0006\u0002\u0010+J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0007J\r\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0002\u00082J\u000e\u00103\u001a\u00020$H\u0086@¢\u0006\u0002\u0010+J\u0018\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0080@¢\u0006\u0004\u00085\u00106R\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u000c\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0016¨\u00068", d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "isSkipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Z)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "hasHalfExpandedState", "getHasHalfExpandedState$material_release", "()Z", "isSkipHalfExpanded$material_release", "isVisible", "progress", "getProgress$annotations", "()V", "getProgress", "()F", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "expand$material_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material_release", "hide", "from", "to", "requireOffset", "requireOffset$material_release", "show", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheetState {

    public static final int $stable = 8;
    public static final androidx.compose.material.ModalBottomSheetState.Companion Companion;
    private final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private final boolean isSkipHalfExpanded;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010", d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material.ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.ModalBottomSheetValue, Boolean> confirmValueChange, boolean skipHalfExpanded, Density density) {
            ModalBottomSheetState.Companion.Saver.2 anon = new ModalBottomSheetState.Companion.Saver.2(density, confirmValueChange, animationSpec, skipHalfExpanded);
            return SaverKt.Saver((Function2)ModalBottomSheetState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
            ModalBottomSheetState.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        ModalBottomSheetState.Companion companion = new ModalBottomSheetState.Companion(0);
        ModalBottomSheetState.Companion = companion;
        int i = 8;
    }

    public ModalBottomSheetState(androidx.compose.material.ModalBottomSheetValue initialValue, Density density, Function1<? super androidx.compose.material.ModalBottomSheetValue, Boolean> confirmValueChange, AnimationSpec<Float> animationSpec, boolean isSkipHalfExpanded) {
        boolean obj7;
        super();
        this.animationSpec = animationSpec;
        this.isSkipHalfExpanded = isSkipHalfExpanded;
        ModalBottomSheetState.anchoredDraggableState.1 anon = new ModalBottomSheetState.anchoredDraggableState.1(density);
        ModalBottomSheetState.anchoredDraggableState.2 anon2 = new ModalBottomSheetState.anchoredDraggableState.2(density);
        Object obj = initialValue;
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(obj, (Function1)anon, (Function0)anon2, this.animationSpec, confirmValueChange);
        this.anchoredDraggableState = anchoredDraggableState;
        if (this.isSkipHalfExpanded) {
            obj7 = obj != ModalBottomSheetValue.HalfExpanded ? 1 : 0;
            if (obj7 == null) {
            } else {
            }
            obj7 = 0;
            obj7 = new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
            throw obj7;
        }
    }

    public ModalBottomSheetState(androidx.compose.material.ModalBottomSheetValue modalBottomSheetValue, Density density2, Function1 function13, AnimationSpec animationSpec4, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        androidx.compose.material.ModalBottomSheetState.1 anon;
        AnimationSpec animationSpec;
        int i;
        androidx.compose.material.ModalBottomSheetState.1 obj9;
        AnimationSpec obj10;
        int obj11;
        if (i6 & 4 != 0) {
            anon = obj9;
        } else {
            anon = function13;
        }
        if (i6 & 8 != 0) {
            animationSpec = obj10;
        } else {
            animationSpec = animationSpec4;
        }
        i = i6 & 16 != 0 ? obj11 : z5;
        super(modalBottomSheetValue, density2, anon, animationSpec, i);
    }

    public static Object animateTo$material_release$default(androidx.compose.material.ModalBottomSheetState modalBottomSheetState, androidx.compose.material.ModalBottomSheetValue modalBottomSheetValue2, float f3, Continuation continuation4, int i5, Object object6) {
        float obj2;
        if (i5 &= 2 != 0) {
            obj2 = modalBottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return modalBottomSheetState.animateTo$material_release(modalBottomSheetValue2, obj2, continuation4);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(...))
    public static void getProgress$annotations() {
    }

    public final Object animateTo$material_release(androidx.compose.material.ModalBottomSheetValue target, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, target, velocity, $completion);
        if (animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo;
        }
        return Unit.INSTANCE;
    }

    public final Object expand$material_release(Continuation<? super Unit> $completion) {
        if (!this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.Expanded)) {
            return Unit.INSTANCE;
        }
        Object obj8 = ModalBottomSheetState.animateTo$material_release$default(this, ModalBottomSheetValue.Expanded, 0, $completion, 2, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.ModalBottomSheetValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final androidx.compose.material.ModalBottomSheetValue getCurrentValue() {
        return (ModalBottomSheetValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final androidx.compose.material.ModalBottomSheetValue getTargetValue() {
        return (ModalBottomSheetValue)this.anchoredDraggableState.getTargetValue();
    }

    public final Object halfExpand$material_release(Continuation<? super Unit> $completion) {
        if (!getHasHalfExpandedState$material_release()) {
            return Unit.INSTANCE;
        }
        Object obj8 = ModalBottomSheetState.animateTo$material_release$default(this, ModalBottomSheetValue.HalfExpanded, 0, $completion, 2, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> $completion) {
        Object obj7 = ModalBottomSheetState.animateTo$material_release$default(this, ModalBottomSheetValue.Hidden, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final boolean isSkipHalfExpanded$material_release() {
        return this.isSkipHalfExpanded;
    }

    public final boolean isVisible() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() != ModalBottomSheetValue.Hidden ? 1 : 0;
        return i;
    }

    public final float progress(androidx.compose.material.ModalBottomSheetValue from, androidx.compose.material.ModalBottomSheetValue to) {
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

    public final Object show(Continuation<? super Unit> $completion) {
        androidx.compose.material.ModalBottomSheetValue halfExpanded;
        if (ModalBottomSheetState.WhenMappings.$EnumSwitchMapping$0[getCurrentValue().ordinal()] == 1) {
            halfExpanded = getHasHalfExpandedState$material_release() ? ModalBottomSheetValue.HalfExpanded : ModalBottomSheetValue.Expanded;
        } else {
            halfExpanded = this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.Expanded) ? ModalBottomSheetValue.Expanded : ModalBottomSheetValue.Hidden;
        }
        Object obj9 = ModalBottomSheetState.animateTo$material_release$default(this, halfExpanded, 0, $completion, 2, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public final Object snapTo$material_release(androidx.compose.material.ModalBottomSheetValue target, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, target, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
