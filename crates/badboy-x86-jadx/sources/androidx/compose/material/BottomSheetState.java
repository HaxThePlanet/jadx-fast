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
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0008\u000f\u0008\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0014\u0008\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000cJ\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0008\u0008\u0002\u0010!\u001a\u00020\u0008H\u0080@¢\u0006\u0004\u0008\"\u0010#J\u000e\u0010$\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010%J\u0018\u0010\u0017\u001a\u00020\u00082\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0007J\u0006\u0010)\u001a\u00020\u0008J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0080@¢\u0006\u0004\u0008+\u0010,R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00088GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0013¨\u0006.", d2 = {"Landroidx/compose/material/BottomSheetState;", "", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/ui/unit/Density;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomSheetValue;", "isCollapsed", "()Z", "isExpanded", "progress", "getProgress$annotations", "()V", "getProgress", "()F", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/BottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "from", "to", "requireOffset", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/BottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetState {

    public static final int $stable;
    public static final androidx.compose.material.BottomSheetState.Companion Companion;
    private final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.BottomSheetValue> anchoredDraggableState;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f", d2 = {"Landroidx/compose/material/BottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BottomSheetValue;", "", "density", "Landroidx/compose/ui/unit/Density;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material.BottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BottomSheetValue, Boolean> confirmStateChange, Density density) {
            BottomSheetState.Companion.Saver.2 anon = new BottomSheetState.Companion.Saver.2(density, animationSpec, confirmStateChange);
            return SaverKt.Saver((Function2)BottomSheetState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        BottomSheetState.Companion companion = new BottomSheetState.Companion(0);
        BottomSheetState.Companion = companion;
    }

    public BottomSheetState(androidx.compose.material.BottomSheetValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BottomSheetValue, Boolean> confirmValueChange) {
        super();
        BottomSheetState.anchoredDraggableState.1 anon = new BottomSheetState.anchoredDraggableState.1(density);
        BottomSheetState.anchoredDraggableState.2 anon2 = new BottomSheetState.anchoredDraggableState.2(density);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, (Function1)anon, (Function0)anon2, animationSpec, confirmValueChange);
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public BottomSheetState(androidx.compose.material.BottomSheetValue bottomSheetValue, Density density2, AnimationSpec animationSpec3, Function1 function14, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        AnimationSpec obj3;
        androidx.compose.material.BottomSheetState.1 obj4;
        if (i5 & 4 != 0) {
            obj3 = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if (i5 &= 8 != 0) {
            obj4 = BottomSheetState.1.INSTANCE;
        }
        super(bottomSheetValue, density2, obj3, obj4);
    }

    public static Object animateTo$material_release$default(androidx.compose.material.BottomSheetState bottomSheetState, androidx.compose.material.BottomSheetValue bottomSheetValue2, float f3, Continuation continuation4, int i5, Object object6) {
        float obj2;
        if (i5 &= 2 != 0) {
            obj2 = bottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return bottomSheetState.animateTo$material_release(bottomSheetValue2, obj2, continuation4);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(...))
    public static void getProgress$annotations() {
    }

    public final Object animateTo$material_release(androidx.compose.material.BottomSheetValue target, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, target, velocity, $completion);
        if (animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animateTo;
        }
        return Unit.INSTANCE;
    }

    public final Object collapse(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomSheetValue.Collapsed, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final Object expand(Continuation<? super Unit> $completion) {
        androidx.compose.material.BottomSheetValue collapsed;
        collapsed = this.anchoredDraggableState.getAnchors().hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
        Object obj8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, collapsed, 0, $completion, 2, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.BottomSheetValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final androidx.compose.material.BottomSheetValue getCurrentValue() {
        return (BottomSheetValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final androidx.compose.material.BottomSheetValue getTargetValue() {
        return (BottomSheetValue)this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isCollapsed() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Collapsed ? 1 : 0;
        return i;
    }

    public final boolean isExpanded() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Expanded ? 1 : 0;
        return i;
    }

    public final float progress(androidx.compose.material.BottomSheetValue from, androidx.compose.material.BottomSheetValue to) {
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

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final Object snapTo$material_release(androidx.compose.material.BottomSheetValue target, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, target, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
