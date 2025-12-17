package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u0000 02\u00020\u0001:\u00010B?\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000e\u0010'\u001a\u00020(H\u0086@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0007J\u0008\u0010-\u001a\u00020\u0017H\u0002J\u0006\u0010.\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020(H\u0086@¢\u0006\u0002\u0010)R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020 X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0015¨\u00061", d2 = {"Landroidx/compose/material/BackdropScaffoldState;", "", "initialValue", "Landroidx/compose/material/BackdropValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material_release", "()Landroidx/compose/material/AnchoredDraggableState;", "getConfirmValueChange", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BackdropValue;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material_release", "(Landroidx/compose/ui/unit/Density;)V", "isConcealed", "()Z", "isRevealed", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "targetValue", "getTargetValue", "conceal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progress", "from", "to", "requireDensity", "requireOffset", "reveal", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackdropScaffoldState {

    public static final int $stable;
    public static final androidx.compose.material.BackdropScaffoldState.Companion Companion;
    private final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.BackdropValue> anchoredDraggableState;
    private final Function1<androidx.compose.material.BackdropValue, Boolean> confirmValueChange;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;
    private final androidx.compose.material.SnackbarHostState snackbarHostState;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011", d2 = {"Landroidx/compose/material/BackdropScaffoldState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BackdropScaffoldState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BackdropValue;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "density", "Landroidx/compose/ui/unit/Density;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material.BackdropScaffoldState, ?> Saver(AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BackdropValue, Boolean> confirmStateChange, androidx.compose.material.SnackbarHostState snackbarHostState, Density density) {
            BackdropScaffoldState.Companion.Saver.2 anon = new BackdropScaffoldState.Companion.Saver.2(density, animationSpec, confirmStateChange, snackbarHostState);
            return SaverKt.Saver((Function2)BackdropScaffoldState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        BackdropScaffoldState.Companion companion = new BackdropScaffoldState.Companion(0);
        BackdropScaffoldState.Companion = companion;
    }

    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(...))
    public BackdropScaffoldState(androidx.compose.material.BackdropValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super androidx.compose.material.BackdropValue, Boolean> confirmValueChange, androidx.compose.material.SnackbarHostState snackbarHostState) {
        super();
        this.confirmValueChange = confirmValueChange;
        this.snackbarHostState = snackbarHostState;
        BackdropScaffoldState.anchoredDraggableState.1 anon = new BackdropScaffoldState.anchoredDraggableState.1(this);
        BackdropScaffoldState.anchoredDraggableState.2 anon2 = new BackdropScaffoldState.anchoredDraggableState.2(this);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, (Function1)anon, (Function0)anon2, animationSpec, this.confirmValueChange);
        this.anchoredDraggableState = anchoredDraggableState;
        this.nestedScrollConnection = BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection(this.anchoredDraggableState, Orientation.Vertical);
    }

    public BackdropScaffoldState(androidx.compose.material.BackdropValue backdropValue, AnimationSpec animationSpec2, Function1 function13, androidx.compose.material.SnackbarHostState snackbarHostState4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        AnimationSpec obj2;
        androidx.compose.material.BackdropScaffoldState.1 obj3;
        androidx.compose.material.SnackbarHostState obj4;
        if (i5 & 2 != 0) {
            obj2 = BackdropScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if (i5 & 4 != 0) {
            obj3 = BackdropScaffoldState.1.INSTANCE;
        }
        if (i5 &= 8 != 0) {
            obj4 = new SnackbarHostState();
        }
        super(backdropValue, obj2, obj3, obj4);
    }

    public static final Density access$requireDensity(androidx.compose.material.BackdropScaffoldState $this) {
        return $this.requireDensity();
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density == null) {
        } else {
            return density;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The density on BackdropScaffoldState (").append(this).append(") was not set. Did you use BackdropScaffoldState with the BackdropScaffold composable?").toString().toString());
        throw illegalArgumentException;
    }

    public final Object conceal(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Concealed, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final androidx.compose.material.AnchoredDraggableState<androidx.compose.material.BackdropValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final Function1<androidx.compose.material.BackdropValue, Boolean> getConfirmValueChange() {
        return this.confirmValueChange;
    }

    public final androidx.compose.material.BackdropValue getCurrentValue() {
        return (BackdropValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material_release() {
        return this.density;
    }

    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    public final androidx.compose.material.SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public final androidx.compose.material.BackdropValue getTargetValue() {
        return (BackdropValue)this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isConcealed() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() == BackdropValue.Concealed ? 1 : 0;
        return i;
    }

    public final boolean isRevealed() {
        int i;
        i = this.anchoredDraggableState.getCurrentValue() == BackdropValue.Revealed ? 1 : 0;
        return i;
    }

    public final float progress(androidx.compose.material.BackdropValue from, androidx.compose.material.BackdropValue to) {
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

    public final Object reveal(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Revealed, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final void setDensity$material_release(Density <set-?>) {
        this.density = <set-?>;
    }
}
