package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J$\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00032\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u001a0%H\u0087@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020#H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020#H\u0086@¢\u0006\u0002\u0010(J\u0008\u0010*\u001a\u00020\u0010H\u0002J\r\u0010+\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0008,J\u0016\u0010-\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010.R\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u001a8GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00038GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008 \u0010\u001c\u001a\u0004\u0008!\u0010\u000e¨\u00060", d2 = {"Landroidx/compose/material/DrawerState;", "", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/DrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "()Z", "isClosed", "isOpen", "offset", "", "getOffset$annotations", "()V", "getOffset", "()F", "targetValue", "getTargetValue$annotations", "getTargetValue", "animateTo", "", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "open", "requireDensity", "requireOffset", "requireOffset$material_release", "snapTo", "(Landroidx/compose/material/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawerState {

    public static final int $stable;
    public static final androidx.compose.material.DrawerState.Companion Companion;
    private final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.DrawerValue> anchoredDraggableState;
    private Density density;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¨\u0006\n", d2 = {"Landroidx/compose/material/DrawerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DrawerState;", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material.DrawerState, androidx.compose.material.DrawerValue> Saver(Function1<? super androidx.compose.material.DrawerValue, Boolean> confirmStateChange) {
            DrawerState.Companion.Saver.2 anon = new DrawerState.Companion.Saver.2(confirmStateChange);
            return SaverKt.Saver((Function2)DrawerState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        DrawerState.Companion companion = new DrawerState.Companion(0);
        DrawerState.Companion = companion;
    }

    public DrawerState(androidx.compose.material.DrawerValue initialValue, Function1<? super androidx.compose.material.DrawerValue, Boolean> confirmStateChange) {
        super();
        DrawerState.anchoredDraggableState.1 anon = new DrawerState.anchoredDraggableState.1(this);
        DrawerState.anchoredDraggableState.2 anon2 = new DrawerState.anchoredDraggableState.2(this);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, (Function1)anon, (Function0)anon2, (AnimationSpec)DrawerKt.access$getAnimationSpec$p(), confirmStateChange);
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public DrawerState(androidx.compose.material.DrawerValue drawerValue, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.material.DrawerState.1 obj2;
        if (i3 &= 2 != 0) {
            obj2 = DrawerState.1.INSTANCE;
        }
        super(drawerValue, obj2);
    }

    public static final Density access$requireDensity(androidx.compose.material.DrawerState $this) {
        return $this.requireDensity();
    }

    public static void getOffset$annotations() {
    }

    public static void getTargetValue$annotations() {
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density == null) {
        } else {
            return density;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The density on DrawerState (").append(this).append(") was not set. Did you use DrawerState with the Drawer composable?").toString().toString());
        throw illegalArgumentException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.")
    public final Object animateTo(androidx.compose.material.DrawerValue targetValue, AnimationSpec<Float> anim, Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, targetValue, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Closed, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.DrawerValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final androidx.compose.material.DrawerValue getCurrentValue() {
        return (DrawerValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material_release() {
        return this.density;
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final androidx.compose.material.DrawerValue getTargetValue() {
        return (DrawerValue)this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        int i;
        i = getCurrentValue() == DrawerValue.Closed ? 1 : 0;
        return i;
    }

    public final boolean isOpen() {
        int i;
        i = getCurrentValue() == DrawerValue.Open ? 1 : 0;
        return i;
    }

    public final Object open(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, DrawerValue.Open, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material_release(Density <set-?>) {
        this.density = <set-?>;
    }

    public final Object snapTo(androidx.compose.material.DrawerValue targetValue, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, targetValue, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
