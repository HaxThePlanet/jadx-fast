package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0017\u0008\u0017\u0018\u0000 v*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001vBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\u0008\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0008¢\u0006\u0002\u0010\rJ$\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00062\u000c\u0010b\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u0010cJ&\u0010d\u001a\u00020`2\u0006\u0010P\u001a\u00028\u00002\u000e\u0008\u0002\u0010e\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@¢\u0006\u0002\u0010fJ!\u0010g\u001a\u00020`2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\u0008iJ\u000e\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0006J\u0016\u0010l\u001a\u00020`2\u0006\u0010m\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010nJ8\u0010o\u001a\u00020`2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0080@¢\u0006\u0004\u0008q\u0010rJ\u0016\u0010s\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010nJ\u0016\u0010t\u001a\u00020`2\u0006\u0010P\u001a\u00028\u0000H\u0087@¢\u0006\u0002\u0010uR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR+\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008$\u0010\u0018\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u001a\u0010%\u001a\u00020\u00068FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008&\u0010'\u001a\u0004\u0008(\u0010)R\u0014\u0010*\u001a\u00020+X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R+\u0010.\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u000c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00082\u0010\u0018\u001a\u0004\u0008.\u0010/\"\u0004\u00080\u00101R \u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001104X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u0010)\"\u0004\u00087\u00108R\u001a\u00109\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010)\"\u0004\u0008;\u00108R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00060=8F¢\u0006\u0006\u001a\u0004\u0008>\u0010?R\u000e\u0010@\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00060=8F¢\u0006\u0006\u001a\u0004\u0008B\u0010?R\u000e\u0010C\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010D\u001a\u0008\u0012\u0004\u0012\u00028\u00000E8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008F\u0010'\u001a\u0004\u0008G\u0010HR/\u0010J\u001a\u0004\u0018\u00010I2\u0008\u0010\u0010\u001a\u0004\u0018\u00010I8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008O\u0010\u0018\u001a\u0004\u0008K\u0010L\"\u0004\u0008M\u0010NR\u001a\u0010P\u001a\u00028\u00008FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008Q\u0010'\u001a\u0004\u0008R\u0010!RO\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060S2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060S8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008Y\u0010\u0018\u001a\u0004\u0008U\u0010V\"\u0004\u0008W\u0010XR+\u0010Z\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008]\u0010^\u001a\u0004\u0008[\u0010)\"\u0004\u0008\\\u00108¨\u0006w", d2 = {"Landroidx/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableFloatState;", "<set-?>", "", "anchors", "getAnchors$material_release", "()Ljava/util/Map;", "setAnchors$material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "Landroidx/compose/runtime/MutableState;", "getConfirmStateChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection$annotations", "()V", "getDirection", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$material_release", "setMaxBound$material_release", "(F)V", "minBound", "getMinBound$material_release", "setMinBound$material_release", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "offsetState", "overflow", "getOverflow", "overflowState", "progress", "Landroidx/compose/material/SwipeProgress;", "getProgress$annotations", "getProgress", "()Landroidx/compose/material/SwipeProgress;", "Landroidx/compose/material/ResistanceConfig;", "resistance", "getResistance$material_release", "()Landroidx/compose/material/ResistanceConfig;", "setResistance$material_release", "(Landroidx/compose/material/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue$annotations", "getTargetValue", "Lkotlin/Function2;", "thresholds", "getThresholds$material_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$material_release", "setVelocityThreshold$material_release", "velocityThreshold$delegate", "Landroidx/compose/runtime/MutableFloatState;", "animateInternalToOffset", "", "target", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$material_release", "performDrag", "delta", "performFling", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$material_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SwipeableState<T>  {

    public static final int $stable;
    public static final androidx.compose.material.SwipeableState.Companion Companion;
    private final MutableFloatState absoluteOffset;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;
    private final MutableState currentValue$delegate;
    private final DraggableState draggableState;
    private final MutableState isAnimationRunning$delegate;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;
    private final MutableState resistance$delegate;
    private final MutableState thresholds$delegate;
    private final MutableFloatState velocityThreshold$delegate;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0008\u0008\u0001\u0010\u0006*\u00020\u00012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u000c0\u000b¨\u0006\r", d2 = {"Landroidx/compose/material/SwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <T> Saver<androidx.compose.material.SwipeableState<T>, T> Saver(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange) {
            SwipeableState.Companion.Saver.2 anon = new SwipeableState.Companion.Saver.2(animationSpec, confirmStateChange);
            return SaverKt.Saver((Function2)SwipeableState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        SwipeableState.Companion companion = new SwipeableState.Companion(0);
        SwipeableState.Companion = companion;
    }

    public SwipeableState(T initialValue, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange) {
        super();
        this.animationSpec = animationSpec;
        this.confirmStateChange = confirmStateChange;
        int i = 0;
        final int i2 = 2;
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(initialValue, i, i2, i);
        this.isAnimationRunning$delegate = SnapshotStateKt.mutableStateOf$default(false, i, i2, i);
        int i4 = 0;
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(i4);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(i4);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(i4);
        this.animationTarget = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), i, i2, i);
        SwipeableState.latestNonEmptyAnchorsFlow.1 anon2 = new SwipeableState.latestNonEmptyAnchorsFlow.1(this);
        final int i7 = 0;
        final int i8 = 0;
        final int i9 = 0;
        SwipeableState.special$$inlined.filter.1 anon3 = new SwipeableState.special$$inlined.filter.1(SnapshotStateKt.snapshotFlow((Function0)anon2));
        this.latestNonEmptyAnchorsFlow = FlowKt.take((Flow)anon3, 1);
        this.minBound = -8388608;
        this.maxBound = 2139095040;
        this.thresholds$delegate = SnapshotStateKt.mutableStateOf$default(SwipeableState.thresholds.2.INSTANCE, i, i2, i);
        this.velocityThreshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i4);
        this.resistance$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        SwipeableState.draggableState.1 anon = new SwipeableState.draggableState.1(this);
        this.draggableState = DraggableKt.DraggableState((Function1)anon);
    }

    public SwipeableState(Object object, AnimationSpec animationSpec2, Function1 function13, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.compose.animation.core.SpringSpec obj2;
        androidx.compose.material.SwipeableState.1 obj3;
        if (i4 & 2 != 0) {
            obj2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (i4 &= 4 != 0) {
            obj3 = SwipeableState.1.INSTANCE;
        }
        super(object, obj2, obj3);
    }

    public static final Object access$animateInternalToOffset(androidx.compose.material.SwipeableState $this, float target, AnimationSpec spec, Continuation $completion) {
        return $this.animateInternalToOffset(target, spec, $completion);
    }

    public static final MutableFloatState access$getAbsoluteOffset$p(androidx.compose.material.SwipeableState $this) {
        return $this.absoluteOffset;
    }

    public static final MutableState access$getAnimationTarget$p(androidx.compose.material.SwipeableState $this) {
        return $this.animationTarget;
    }

    public static final MutableFloatState access$getOffsetState$p(androidx.compose.material.SwipeableState $this) {
        return $this.offsetState;
    }

    public static final MutableFloatState access$getOverflowState$p(androidx.compose.material.SwipeableState $this) {
        return $this.overflowState;
    }

    public static final void access$setAnimationRunning(androidx.compose.material.SwipeableState $this, boolean <set-?>) {
        $this.setAnimationRunning(<set-?>);
    }

    public static final void access$setCurrentValue(androidx.compose.material.SwipeableState $this, Object <set-?>) {
        $this.setCurrentValue(<set-?>);
    }

    public static final Object access$snapInternalToOffset(androidx.compose.material.SwipeableState $this, float target, Continuation $completion) {
        return $this.snapInternalToOffset(target, $completion);
    }

    private final Object animateInternalToOffset(float target, AnimationSpec<Float> spec, Continuation<? super Unit> $completion) {
        SwipeableState.animateInternalToOffset.2 anon = new SwipeableState.animateInternalToOffset.2(this, target, spec, 0);
        Object obj9 = DraggableState.drag$default(this.draggableState, 0, (Function2)anon, $completion, 1, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static Object animateTo$default(androidx.compose.material.SwipeableState swipeableState, Object object2, AnimationSpec animationSpec3, Continuation continuation4, int i5, Object object6) {
        AnimationSpec obj2;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj2 = swipeableState.animationSpec;
            }
            return swipeableState.animateTo(object2, obj2, continuation4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        throw obj0;
    }

    public static void getDirection$annotations() {
    }

    public static void getProgress$annotations() {
    }

    public static void getTargetValue$annotations() {
    }

    private final void setAnimationRunning(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setCurrentValue(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentValue$delegate.setValue(<set-?>);
    }

    private final Object snapInternalToOffset(float target, Continuation<? super Unit> $completion) {
        SwipeableState.snapInternalToOffset.2 anon = new SwipeableState.snapInternalToOffset.2(target, this, 0);
        Object obj8 = DraggableState.drag$default(this.draggableState, 0, (Function2)anon, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final Object animateTo(T targetValue, AnimationSpec<Float> anim, Continuation<? super Unit> $completion) {
        SwipeableState.animateTo.2 anon = new SwipeableState.animateTo.2(targetValue, this, anim);
        Object collect = this.latestNonEmptyAnchorsFlow.collect((FlowCollector)anon, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    public final void ensureInit$material_release(Map<Float, ? extends T> newAnchors) {
        boolean empty;
        MutableFloatState absoluteOffset;
        float floatValue;
        if (getAnchors$material_release().isEmpty()) {
            empty = SwipeableKt.access$getOffset(newAnchors, getCurrentValue());
            if (empty == null) {
            } else {
                this.offsetState.setFloatValue(empty.floatValue());
                this.absoluteOffset.setFloatValue(empty.floatValue());
            }
            int i = 0;
            IllegalArgumentException $i$a$RequireNotNullSwipeableState$ensureInit$1 = new IllegalArgumentException("The initial value must have an associated anchor.".toString());
            throw $i$a$RequireNotNullSwipeableState$ensureInit$1;
        }
    }

    public final Map<Float, T> getAnchors$material_release() {
        final int i = 0;
        final int i2 = 0;
        return (Map)(State)this.anchors$delegate.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$material_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.currentValue$delegate.getValue();
    }

    public final float getDirection() {
        float floatValue;
        int currentValue;
        float signum;
        floatValue = SwipeableKt.access$getOffset(getAnchors$material_release(), getCurrentValue());
        if (floatValue != null) {
            currentValue = 0;
            signum = Math.signum(floatValue2 -= floatValue);
        } else {
            signum = 0;
        }
        return signum;
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getMaxBound$material_release() {
        return this.maxBound;
    }

    public final float getMinBound$material_release() {
        return this.minBound;
    }

    public final State<Float> getOffset() {
        return (State)this.offsetState;
    }

    public final State<Float> getOverflow() {
        return (State)this.overflowState;
    }

    public final androidx.compose.material.SwipeProgress<T> getProgress() {
        Object from;
        Object to;
        int fraction;
        Map anchors$material_release;
        Pair pair;
        Object floatValue;
        Object obj;
        Object obj2;
        int i;
        List list = SwipeableKt.access$findBounds((Number)getOffset().getValue().floatValue(), getAnchors$material_release().keySet());
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        floatValue = 0;
        switch (anchors$material_release) {
            case 0:
                from = getCurrentValue();
                to = getCurrentValue();
                fraction = 1065353216;
                break;
            case 1:
                from = MapsKt.getValue(getAnchors$material_release(), list.get(floatValue));
                to = MapsKt.getValue(getAnchors$material_release(), list.get(floatValue));
                fraction = 1065353216;
                break;
            default:
                int i6 = 1;
                pair = TuplesKt.to(list.get(floatValue), list.get(i6));
                pair = TuplesKt.to(list.get(i6), list.get(floatValue));
                floatValue = (Number)pair.component1().floatValue();
                anchors$material_release = (Number)pair.component2().floatValue();
                from = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(floatValue));
                to = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(anchors$material_release));
                fraction = obj2 / i;
        }
        SwipeProgress b = new SwipeProgress(from, to, fraction);
        return b;
    }

    public final androidx.compose.material.ResistanceConfig getResistance$material_release() {
        final int i = 0;
        final int i2 = 0;
        return (ResistanceConfig)(State)this.resistance$delegate.getValue();
    }

    public final T getTargetValue() {
        float floatValue2;
        float floatValue3;
        float floatValue;
        Object currentValue;
        float f;
        java.util.Set keySet;
        Function2 thresholds$material_release;
        int i;
        int i2;
        Object value = this.animationTarget.getValue();
        if ((Float)value != null) {
            floatValue2 = (Float)value.floatValue();
        } else {
            Float num = SwipeableKt.access$getOffset(getAnchors$material_release(), getCurrentValue());
            if (num != null) {
                floatValue3 = num.floatValue();
            } else {
                floatValue3 = (Number)getOffset().getValue().floatValue();
            }
            floatValue2 = SwipeableKt.access$computeTarget((Number)getOffset().getValue().floatValue(), floatValue3, getAnchors$material_release().keySet(), getThresholds$material_release(), 0, 2139095040);
        }
        if (getAnchors$material_release().get(Float.valueOf(floatValue2)) == null) {
            currentValue = getCurrentValue();
        }
        return currentValue;
    }

    public final Function2<Float, Float, Float> getThresholds$material_release() {
        final int i = 0;
        final int i2 = 0;
        return (Function2)(State)this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material_release() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.velocityThreshold$delegate.getFloatValue();
    }

    public final boolean isAnimationRunning() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isAnimationRunning$delegate.getValue().booleanValue();
    }

    public final float performDrag(float delta) {
        int draggableState;
        int i2 = coerceIn - floatValue2;
        if (Float.compare(f, i3) > 0) {
            this.draggableState.dispatchRawDelta(i2);
        }
        return i2;
    }

    public final Object performFling(float velocity, Continuation<? super Unit> $completion) {
        SwipeableState.performFling.2 anon = new SwipeableState.performFling.2(this, velocity);
        Object collect = this.latestNonEmptyAnchorsFlow.collect((FlowCollector)anon, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    public final Object processNewAnchors$material_release(Map<Float, ? extends T> map, Map<Float, ? extends T> map2, Continuation<? super Unit> continuation3) {
        boolean anon;
        Throwable th;
        Object cOROUTINE_SUSPENDED;
        Throwable _this;
        Object label;
        Object currentValue;
        Object animateInternalToOffset;
        float floatValue;
        Object minElem$iv;
        int i;
        int iterator;
        Iterator iterator2;
        int compare;
        float f;
        int i2;
        float f2;
        Throwable th2;
        boolean obj13;
        Map obj14;
        Object obj15;
        anon = continuation3;
        _this = Integer.MIN_VALUE;
        if (continuation3 instanceof SwipeableState.processNewAnchors.1 && label2 &= _this != 0) {
            anon = continuation3;
            _this = Integer.MIN_VALUE;
            if (label2 &= _this != 0) {
                anon.label = obj15 -= _this;
            } else {
                anon = new SwipeableState.processNewAnchors.1(this, continuation3);
            }
        } else {
        }
        obj15 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                label = this;
                obj13 = CollectionsKt.minOrNull((Iterable)map2.keySet());
                Intrinsics.checkNotNull(obj13);
                label.minBound = obj13.floatValue();
                obj13 = CollectionsKt.maxOrNull((Iterable)map2.keySet());
                Intrinsics.checkNotNull(obj13);
                label.maxBound = obj13.floatValue();
                obj13 = SwipeableKt.access$getOffset(map2, label.getCurrentValue());
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj13 = 0;
                obj13 = new IllegalArgumentException("The initial value must have an associated anchor.".toString());
                throw obj13;
                label.minBound = -8388608;
                label.maxBound = 2139095040;
                currentValue = label.animationTarget.getValue();
                minElem$iv = 0;
                obj13 = SwipeableKt.access$getOffset(map2, map.get((Float)currentValue));
                floatValue = obj13.floatValue();
                iterator = 0;
                iterator2 = (Iterable)map2.keySet().iterator();
                compare = 0;
                f = Math.abs(obj13 - floatValue5);
                obj13 = iterator2.next();
                i2 = 0;
                f2 = Math.abs(floatValue3 - floatValue7);
                minElem$iv = obj13;
                f = compare;
                Intrinsics.checkNotNull(minElem$iv);
                floatValue = (Number)minElem$iv.floatValue();
                obj13 = currentValue;
                obj13 = SwipeableKt.access$getOffset(map2, obj13);
                floatValue = obj13.floatValue();
                currentValue = 0;
                iterator = (Iterable)map2.keySet().iterator();
                iterator2 = 0;
                compare = Math.abs(obj13 - floatValue4);
                obj13 = iterator.next();
                f = 0.0f;
                i2 = Math.abs(floatValue2 - floatValue6);
                minElem$iv = obj13;
                compare = iterator2;
                Intrinsics.checkNotNull(minElem$iv);
                floatValue = (Number)minElem$iv.floatValue();
                obj13 = floatValue;
                anon.L$0 = label;
                anon.L$1 = map2;
                anon.F$0 = obj13;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                label.setCurrentValue(MapsKt.getValue(obj14, Boxing.boxFloat(obj13)));
                obj13 = CollectionsKt.minOrNull((Iterable)obj14.keySet());
                Intrinsics.checkNotNull(obj13);
                label.minBound = obj13.floatValue();
                obj13 = CollectionsKt.maxOrNull((Iterable)obj14.keySet());
                Intrinsics.checkNotNull(obj13);
                label.maxBound = obj13.floatValue();
                break;
            case 1:
                ResultKt.throwOnFailure(obj15);
                break;
            case 2:
                obj13 = anon.F$0;
                obj14 = anon.L$1;
                label = anon.L$0;
                ResultKt.throwOnFailure(obj15);
                label.setCurrentValue(MapsKt.getValue(obj14, Boxing.boxFloat(obj13)));
                obj13 = CollectionsKt.minOrNull((Iterable)obj14.keySet());
                Intrinsics.checkNotNull(obj13);
                label.minBound = obj13.floatValue();
                obj13 = CollectionsKt.maxOrNull((Iterable)obj14.keySet());
                Intrinsics.checkNotNull(obj13);
                label.maxBound = obj13.floatValue();
                break;
            case 3:
                obj14 = anon.L$1;
                cOROUTINE_SUSPENDED = anon.L$0;
                ResultKt.throwOnFailure(obj15);
                cOROUTINE_SUSPENDED.setCurrentValue(MapsKt.getValue((Map)obj14, Boxing.boxFloat(anon.F$0)));
                obj13 = CollectionsKt.minOrNull((Iterable)obj14.keySet());
                Intrinsics.checkNotNull(obj13);
                cOROUTINE_SUSPENDED.minBound = obj13.floatValue();
                obj13 = CollectionsKt.maxOrNull((Iterable)obj14.keySet());
                Intrinsics.checkNotNull(obj13);
                cOROUTINE_SUSPENDED.maxBound = obj13.floatValue();
                break;
            default:
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
        }
        return Unit.INSTANCE;
    }

    public final void setAnchors$material_release(Map<Float, ? extends T> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.anchors$delegate.setValue(<set-?>);
    }

    public final void setMaxBound$material_release(float <set-?>) {
        this.maxBound = <set-?>;
    }

    public final void setMinBound$material_release(float <set-?>) {
        this.minBound = <set-?>;
    }

    public final void setResistance$material_release(androidx.compose.material.ResistanceConfig <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.resistance$delegate.setValue(<set-?>);
    }

    public final void setThresholds$material_release(Function2<? super Float, ? super Float, Float> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.thresholds$delegate.setValue(<set-?>);
    }

    public final void setVelocityThreshold$material_release(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.velocityThreshold$delegate.setFloatValue(<set-?>);
    }

    public final Object snapTo(T targetValue, Continuation<? super Unit> $completion) {
        SwipeableState.snapTo.2 anon = new SwipeableState.snapTo.2(targetValue, this);
        Object collect = this.latestNonEmptyAnchorsFlow.collect((FlowCollector)anon, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
