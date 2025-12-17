package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0007\u0018\u0000 82\u00020\u0001:\u00018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J$\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u00032\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\r0+H\u0087@¢\u0006\u0002\u0010,J0\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u00032\u000e\u0008\u0002\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\r0+2\u0008\u0008\u0002\u0010.\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020)H\u0086@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u00020)H\u0086@¢\u0006\u0002\u00101J\u0008\u00103\u001a\u00020\u0014H\u0002J\r\u00104\u001a\u00020\rH\u0000¢\u0006\u0002\u00085J\u0016\u00106\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u00107R\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00030\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00148@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u001dR\"\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\r0!8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010%R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008'\u0010\u0012¨\u00069", d2 = {"Landroidx/compose/material3/DrawerState;", "", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentOffset", "", "getCurrentOffset", "()F", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/DrawerValue;", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "isAnimationRunning", "()Z", "isClosed", "isOpen", "offset", "Landroidx/compose/runtime/State;", "getOffset$annotations", "()V", "getOffset", "()Landroidx/compose/runtime/State;", "targetValue", "getTargetValue", "animateTo", "", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "velocity", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "open", "requireDensity", "requireOffset", "requireOffset$material3_release", "snapTo", "(Landroidx/compose/material3/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawerState {

    public static final int $stable;
    public static final androidx.compose.material3.DrawerState.Companion Companion;
    private final AnchoredDraggableState<androidx.compose.material3.DrawerValue> anchoredDraggableState;
    private final MutableState density$delegate;
    private final State<Float> offset;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¨\u0006\n", d2 = {"Landroidx/compose/material3/DrawerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DrawerState;", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.DrawerState, androidx.compose.material3.DrawerValue> Saver(Function1<? super androidx.compose.material3.DrawerValue, Boolean> confirmStateChange) {
            DrawerState.Companion.Saver.2 anon = new DrawerState.Companion.Saver.2(confirmStateChange);
            return SaverKt.Saver((Function2)DrawerState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        DrawerState.Companion companion = new DrawerState.Companion(0);
        DrawerState.Companion = companion;
    }

    public DrawerState(androidx.compose.material3.DrawerValue initialValue, Function1<? super androidx.compose.material3.DrawerValue, Boolean> confirmStateChange) {
        super();
        DrawerState.anchoredDraggableState.2 anon = new DrawerState.anchoredDraggableState.2(this);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, (Function1)DrawerState.anchoredDraggableState.1.INSTANCE, (Function0)anon, (AnimationSpec)NavigationDrawerKt.access$getAnimationSpec$p(), confirmStateChange);
        this.anchoredDraggableState = anchoredDraggableState;
        DrawerState.offset.1 obj8 = new DrawerState.offset.1(this);
        this.offset = (State)obj8;
        obj8 = 0;
        this.density$delegate = SnapshotStateKt.mutableStateOf$default(obj8, obj8, 2, obj8);
    }

    public DrawerState(androidx.compose.material3.DrawerValue drawerValue, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.material3.DrawerState.1 obj2;
        if (i3 &= 2 != 0) {
            obj2 = DrawerState.1.INSTANCE;
        }
        super(drawerValue, obj2);
    }

    public static final Object access$animateTo(androidx.compose.material3.DrawerState $this, androidx.compose.material3.DrawerValue targetValue, AnimationSpec animationSpec, float velocity, Continuation $completion) {
        return $this.animateTo(targetValue, animationSpec, velocity, $completion);
    }

    public static final Density access$requireDensity(androidx.compose.material3.DrawerState $this) {
        return $this.requireDensity();
    }

    private final Object animateTo(androidx.compose.material3.DrawerValue targetValue, AnimationSpec<Float> animationSpec, float velocity, Continuation<? super Unit> $completion) {
        final int i = 0;
        DrawerState.animateTo.3 anon = new DrawerState.animateTo.3(this, velocity, animationSpec, i);
        Object obj8 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, targetValue, i, (Function4)anon, $completion, 2, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    static Object animateTo$default(androidx.compose.material3.DrawerState drawerState, androidx.compose.material3.DrawerValue drawerValue2, AnimationSpec animationSpec3, float f4, Continuation continuation5, int i6, Object object7) {
        androidx.compose.animation.core.TweenSpec obj2;
        float obj3;
        if (i6 & 2 != 0) {
            obj2 = NavigationDrawerKt.access$getAnimationSpec$p();
        }
        if (i6 &= 4 != 0) {
            obj3 = drawerState.anchoredDraggableState.getLastVelocity();
        }
        return drawerState.animateTo(drawerValue2, obj2, obj3, continuation5);
    }

    @Deprecated(message = "Please access the offset through currentOffset, which returns the value directly instead of wrapping it in a state object.", replaceWith = @ReplaceWith(...))
    public static void getOffset$annotations() {
    }

    private final Density requireDensity() {
        Density density$material3_release = getDensity$material3_release();
        if (density$material3_release == null) {
        } else {
            return density$material3_release;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The density on DrawerState (").append(this).append(") was not set. Did you use DrawerState with the ModalNavigationDrawer or DismissibleNavigationDrawer composables?").toString().toString());
        throw illegalArgumentException;
    }

    @Deprecated(message = "This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.")
    public final Object animateTo(androidx.compose.material3.DrawerValue targetValue, AnimationSpec<Float> anim, Continuation<? super Unit> $completion) {
        Object obj8 = DrawerState.animateTo$default(this, targetValue, anim, 0, $completion, 4, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> $completion) {
        Object obj8 = DrawerState.animateTo$default(this, DrawerValue.Closed, 0, 0, $completion, 6, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final AnchoredDraggableState<androidx.compose.material3.DrawerValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final androidx.compose.material3.DrawerValue getCurrentValue() {
        return (DrawerValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material3_release() {
        final int i = 0;
        final int i2 = 0;
        return (Density)(State)this.density$delegate.getValue();
    }

    public final State<Float> getOffset() {
        return this.offset;
    }

    public final androidx.compose.material3.DrawerValue getTargetValue() {
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
        Object obj8 = DrawerState.animateTo$default(this, DrawerValue.Open, 0, 0, $completion, 6, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final float requireOffset$material3_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material3_release(Density <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.density$delegate.setValue(<set-?>);
    }

    public final Object snapTo(androidx.compose.material3.DrawerValue targetValue, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, targetValue, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
