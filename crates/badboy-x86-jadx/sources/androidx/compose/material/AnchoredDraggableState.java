package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\u0008\u0001\u0018\u0000 i*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001iB\u0081\u0001\u0008\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\r\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f\u0012#\u0008\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\u0002\u0010\u0013Bq\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\r\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f\u0012#\u0008\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\u0002\u0010\u0014Jy\u0010L\u001a\u00020M2\u0006\u0010G\u001a\u00028\u00002\u0008\u0008\u0002\u0010N\u001a\u00020O2W\u0010P\u001aS\u0008\u0001\u0012\u0004\u0012\u00020\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0004\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(G\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020M0R\u0012\u0006\u0012\u0004\u0018\u00010\u00020Q¢\u0006\u0002\u0008SH\u0086@¢\u0006\u0002\u0010TJ\\\u0010L\u001a\u00020M2\u0008\u0008\u0002\u0010N\u001a\u00020O2B\u0010P\u001a>\u0008\u0001\u0012\u0004\u0012\u00020\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020M0R\u0012\u0006\u0012\u0004\u0018\u00010\u00020U¢\u0006\u0002\u0008SH\u0086@¢\u0006\u0002\u0010VJ%\u0010W\u001a\u00028\u00002\u0006\u0010?\u001a\u00020\u00082\u0006\u0010'\u001a\u00028\u00002\u0006\u0010X\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0010YJ\u001d\u0010Z\u001a\u00028\u00002\u0006\u0010?\u001a\u00020\u00082\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020\u00082\u0006\u0010]\u001a\u00020\u0008J\u0015\u0010^\u001a\u00020\u00082\u0006\u0010]\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008_J\u0006\u0010`\u001a\u00020\u0008J\u0016\u0010a\u001a\u00020M2\u0006\u0010X\u001a\u00020\u0008H\u0086@¢\u0006\u0002\u0010bJ\u0015\u0010c\u001a\u00020\u00122\u0006\u0010G\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010dJ#\u0010e\u001a\u00020M2\u000c\u0010f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00052\u0008\u0008\u0002\u0010g\u001a\u00028\u0000¢\u0006\u0002\u0010hR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00052\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001b\u0010 \u001a\u00028\u00008@X\u0080\u0084\u0002¢\u0006\u000c\n\u0004\u0008#\u0010$\u001a\u0004\u0008!\u0010\"R/\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\u00120\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R+\u0010'\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008+\u0010\u001d\u001a\u0004\u0008(\u0010\"\"\u0004\u0008)\u0010*R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010.\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u0017\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u00081\u0010\u001d\u001a\u0004\u0008/\u0010\"\"\u0004\u00080\u0010*R\u0014\u00102\u001a\u000203X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u0011\u00106\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\u00086\u00107R+\u00108\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u00088F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008=\u0010>\u001a\u0004\u00089\u0010:\"\u0004\u0008;\u0010<R+\u0010?\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u00088F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008B\u0010>\u001a\u0004\u0008@\u0010:\"\u0004\u0008A\u0010<R/\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00080\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010&R\u001b\u0010D\u001a\u00020\u00088GX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008F\u0010$\u001a\u0004\u0008E\u0010:R\u001b\u0010G\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008I\u0010$\u001a\u0004\u0008H\u0010\"R\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\rX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008J\u0010K¨\u0006j", d2 = {"Landroidx/compose/material/AnchoredDraggableState;", "T", "", "initialValue", "anchors", "Landroidx/compose/material/DraggableAnchors;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/material/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "Landroidx/compose/material/AnchoredDragScope;", "<set-?>", "getAnchors", "()Landroidx/compose/material/DraggableAnchors;", "setAnchors", "(Landroidx/compose/material/DraggableAnchors;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "closestValue", "getClosestValue$material_release", "()Ljava/lang/Object;", "closestValue$delegate", "Landroidx/compose/runtime/State;", "getConfirmValueChange$material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "dragMutex", "Landroidx/compose/material/InternalMutatorMutex;", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "offset", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$material_release", "progress", "getProgress", "progress$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$material_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function4;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "newOffsetForDelta", "newOffsetForDelta$material_release", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "updateAnchors", "newAnchors", "newTarget", "(Landroidx/compose/material/DraggableAnchors;Ljava/lang/Object;)V", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnchoredDraggableState<T>  {

    public static final int $stable;
    public static final androidx.compose.material.AnchoredDraggableState.Companion Companion;
    private final androidx.compose.material.AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final State closestValue$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private final androidx.compose.material.InternalMutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    private final Function1<Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final Function0<Float> velocityThreshold;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Jw\u0010\u0003\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0008\u0008\u0001\u0010\u0006*\u00020\u00012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u000c0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\t0\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0012H\u0007¨\u0006\u0013", d2 = {"Landroidx/compose/material/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/AnchoredDraggableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <T> Saver<androidx.compose.material.AnchoredDraggableState<T>, T> Saver(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold) {
            AnchoredDraggableState.Companion.Saver.2 anon = new AnchoredDraggableState.Companion.Saver.2(positionalThreshold, velocityThreshold, animationSpec, confirmValueChange);
            return SaverKt.Saver((Function2)AnchoredDraggableState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        AnchoredDraggableState.Companion companion = new AnchoredDraggableState.Companion(0);
        AnchoredDraggableState.Companion = companion;
    }

    public AnchoredDraggableState(T initialValue, androidx.compose.material.DraggableAnchors<T> anchors, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange) {
        final Object obj2 = initialValue;
        super(obj2, positionalThreshold, velocityThreshold, animationSpec, confirmValueChange);
        setAnchors(anchors);
        trySnapTo(obj2);
    }

    public AnchoredDraggableState(Object object, androidx.compose.material.DraggableAnchors draggableAnchors2, Function1 function13, Function0 function04, AnimationSpec animationSpec5, Function1 function16, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        androidx.compose.material.AnchoredDraggableState.2 anon;
        androidx.compose.material.AnchoredDraggableState.2 obj13;
        if (i7 &= 32 != 0) {
            anon = obj13;
        } else {
            anon = function16;
        }
        super(object, draggableAnchors2, function13, function04, animationSpec5, anon);
    }

    public AnchoredDraggableState(T initialValue, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange) {
        super();
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = velocityThreshold;
        this.animationSpec = animationSpec;
        this.confirmValueChange = confirmValueChange;
        InternalMutatorMutex internalMutatorMutex = new InternalMutatorMutex();
        this.dragMutex = internalMutatorMutex;
        AnchoredDraggableState.draggableState.1 anon = new AnchoredDraggableState.draggableState.1(this);
        this.draggableState = (DraggableState)anon;
        int i = 0;
        final int i2 = 2;
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(initialValue, i, i2, i);
        AnchoredDraggableState.targetValue.2 anon3 = new AnchoredDraggableState.targetValue.2(this);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf((Function0)anon3);
        AnchoredDraggableState.closestValue.2 anon4 = new AnchoredDraggableState.closestValue.2(this);
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf((Function0)anon4);
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(2143289344);
        AnchoredDraggableState.progress.2 anon5 = new AnchoredDraggableState.progress.2(this);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)anon5);
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.access$emptyDraggableAnchors(), i, i2, i);
        AnchoredDraggableState.anchoredDragScope.1 anon2 = new AnchoredDraggableState.anchoredDragScope.1(this);
        this.anchoredDragScope = (AnchoredDragScope)anon2;
    }

    public AnchoredDraggableState(Object object, Function1 function12, Function0 function03, AnimationSpec animationSpec4, Function1 function15, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        androidx.compose.material.AnchoredDraggableState.1 anon;
        androidx.compose.material.AnchoredDraggableState.1 obj11;
        if (i6 &= 16 != 0) {
            anon = obj11;
        } else {
            anon = function15;
        }
        super(object, function12, function03, animationSpec4, anon);
    }

    public static final Object access$computeTarget(androidx.compose.material.AnchoredDraggableState $this, float offset, Object currentValue, float velocity) {
        return $this.computeTarget(offset, currentValue, velocity);
    }

    public static final Object access$computeTargetWithoutThresholds(androidx.compose.material.AnchoredDraggableState $this, float offset, Object currentValue) {
        return $this.computeTargetWithoutThresholds(offset, currentValue);
    }

    public static final androidx.compose.material.AnchoredDragScope access$getAnchoredDragScope$p(androidx.compose.material.AnchoredDraggableState $this) {
        return $this.anchoredDragScope;
    }

    public static final Object access$getDragTarget(androidx.compose.material.AnchoredDraggableState $this) {
        return $this.getDragTarget();
    }

    public static final void access$setCurrentValue(androidx.compose.material.AnchoredDraggableState $this, Object <set-?>) {
        $this.setCurrentValue(<set-?>);
    }

    public static final void access$setDragTarget(androidx.compose.material.AnchoredDraggableState $this, Object <set-?>) {
        $this.setDragTarget(<set-?>);
    }

    public static final void access$setLastVelocity(androidx.compose.material.AnchoredDraggableState $this, float <set-?>) {
        $this.setLastVelocity(<set-?>);
    }

    public static final void access$setOffset(androidx.compose.material.AnchoredDraggableState $this, float <set-?>) {
        $this.setOffset(<set-?>);
    }

    public static Object anchoredDrag$default(androidx.compose.material.AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority2, Function3 function33, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (i5 &= 1 != 0) {
            obj1 = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj1, function33, continuation4);
    }

    public static Object anchoredDrag$default(androidx.compose.material.AnchoredDraggableState anchoredDraggableState, Object object2, MutatePriority mutatePriority3, Function4 function44, Continuation continuation5, int i6, Object object7) {
        MutatePriority obj2;
        if (i6 &= 2 != 0) {
            obj2 = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(object2, obj2, function44, continuation5);
    }

    private final T computeTarget(float offset, T currentValue, float velocity) {
        int closestAnchor;
        float i;
        float i2;
        float f;
        int cmp;
        final androidx.compose.material.DraggableAnchors anchors = getAnchors();
        final float positionOf = anchors.positionOf(currentValue);
        float floatValue = (Number)this.velocityThreshold.invoke().floatValue();
        i = 1;
        i2 = 0;
        closestAnchor = Float.compare(positionOf, offset) == 0 ? i : i2;
        if (closestAnchor == 0) {
            if (Float.isNaN(positionOf)) {
                closestAnchor = currentValue;
            } else {
                if (Float.compare(positionOf, offset) < 0) {
                    if (Float.compare(velocity, floatValue) >= 0) {
                        Intrinsics.checkNotNull(anchors.closestAnchor(offset, i));
                    } else {
                        closestAnchor = anchors.closestAnchor(offset, i);
                        Intrinsics.checkNotNull(closestAnchor);
                        if (Float.compare(offset, f) < 0) {
                        } else {
                        }
                    }
                } else {
                    if (Float.compare(velocity, i3) <= 0) {
                        Intrinsics.checkNotNull(anchors.closestAnchor(offset, i2));
                    } else {
                        closestAnchor = anchors.closestAnchor(offset, i2);
                        Intrinsics.checkNotNull(closestAnchor);
                        f = Math.abs(positionOf - i2);
                        if (Float.compare(offset, i8) < 0) {
                            if (Float.compare(f2, f) < 0) {
                            }
                        } else {
                            if (Float.compare(offset, f) > 0) {
                            }
                        }
                    }
                }
            }
        } else {
        }
        return closestAnchor;
    }

    private final T computeTargetWithoutThresholds(float offset, T currentValue) {
        int closestAnchor;
        final androidx.compose.material.DraggableAnchors anchors = getAnchors();
        final float positionOf = anchors.positionOf(currentValue);
        final int i = 1;
        final int i2 = 0;
        closestAnchor = Float.compare(positionOf, offset) == 0 ? i : i2;
        if (closestAnchor == 0) {
            if (Float.isNaN(positionOf)) {
                closestAnchor = currentValue;
            } else {
                if (Float.compare(positionOf, offset) < 0) {
                    if (anchors.closestAnchor(offset, i) == null) {
                    }
                } else {
                    if (anchors.closestAnchor(offset, i2) == null) {
                    }
                }
            }
        } else {
        }
        return closestAnchor;
    }

    private final T getDragTarget() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.dragTarget$delegate.getValue();
    }

    private final void setAnchors(androidx.compose.material.DraggableAnchors<T> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.anchors$delegate.setValue(<set-?>);
    }

    private final void setCurrentValue(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentValue$delegate.setValue(<set-?>);
    }

    private final void setDragTarget(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.dragTarget$delegate.setValue(<set-?>);
    }

    private final void setLastVelocity(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.lastVelocity$delegate.setFloatValue(<set-?>);
    }

    private final void setOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.offset$delegate.setFloatValue(<set-?>);
    }

    private final boolean trySnapTo(T targetValue) {
        AnchoredDraggableState.trySnapTo.1 anon = new AnchoredDraggableState.trySnapTo.1(this, targetValue);
        return this.dragMutex.tryMutate((Function0)anon);
    }

    public static void updateAnchors$default(androidx.compose.material.AnchoredDraggableState anchoredDraggableState, androidx.compose.material.DraggableAnchors draggableAnchors2, Object object3, int i4, Object object5) {
        Object obj2;
        if (i4 &= 2 != 0) {
            if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                if (draggableAnchors2.closestAnchor(anchoredDraggableState.getOffset()) == null) {
                    obj2 = anchoredDraggableState.getTargetValue();
                }
            } else {
                obj2 = anchoredDraggableState.getTargetValue();
            }
        }
        anchoredDraggableState.updateAnchors(draggableAnchors2, obj2);
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super androidx.compose.material.AnchoredDragScope, ? super androidx.compose.material.DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function32, Continuation<? super Unit> continuation3) {
        boolean anon;
        androidx.compose.material.DraggableAnchors closestAnchor;
        float booleanValue;
        MutatePriority booleanValue2;
        int positionOf2;
        androidx.compose.material.DraggableAnchors positionOf;
        androidx.compose.material.AnchoredDraggableState.anchoredDrag.2 anon2;
        int i;
        Object obj8;
        Object obj10;
        anon = continuation3;
        booleanValue2 = Integer.MIN_VALUE;
        if (continuation3 instanceof AnchoredDraggableState.anchoredDrag.1 && label &= booleanValue2 != 0) {
            anon = continuation3;
            booleanValue2 = Integer.MIN_VALUE;
            if (label &= booleanValue2 != 0) {
                anon.label = obj10 -= booleanValue2;
            } else {
                anon = new AnchoredDraggableState.anchoredDrag.1(this, continuation3);
            }
        } else {
        }
        obj10 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (positionOf2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                positionOf2 = this;
                anon2 = new AnchoredDraggableState.anchoredDrag.2(positionOf2, function32, 0);
                anon.L$0 = positionOf2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj8 = positionOf2;
                break;
            case 1:
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        Object obj9 = obj8.getAnchors().closestAnchor(obj8.getOffset());
        if (obj9 != null && Float.compare(f, i3) <= 0 && (Boolean)obj8.confirmValueChange.invoke(obj9).booleanValue()) {
            if (Float.compare(f, i3) <= 0) {
                if ((Boolean)obj8.confirmValueChange.invoke(obj9).booleanValue()) {
                    obj8.setCurrentValue(obj9);
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final Object anchoredDrag(T t, MutatePriority mutatePriority2, Function4<? super androidx.compose.material.AnchoredDragScope, ? super androidx.compose.material.DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function43, Continuation<? super Unit> continuation4) {
        boolean anon;
        float booleanValue;
        Object cOROUTINE_SUSPENDED;
        Object positionOf;
        int label;
        Object anchorFor;
        androidx.compose.material.AnchoredDraggableState.anchoredDrag.4 anon2;
        int i;
        Object obj9;
        Object obj10;
        float obj11;
        Object obj12;
        anon = continuation4;
        positionOf = Integer.MIN_VALUE;
        if (continuation4 instanceof AnchoredDraggableState.anchoredDrag.3 && label2 &= positionOf != 0) {
            anon = continuation4;
            positionOf = Integer.MIN_VALUE;
            if (label2 &= positionOf != 0) {
                anon.label = obj12 -= positionOf;
            } else {
                anon = new AnchoredDraggableState.anchoredDrag.3(this, continuation4);
            }
        } else {
        }
        obj12 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i3 = 0;
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                label = this;
                anon2 = new AnchoredDraggableState.anchoredDrag.4(label, t, function43, i3);
                anon.L$0 = label;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj9 = label;
                label.setCurrentValue(t);
                return Unit.INSTANCE;
            case 1:
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj12);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        obj9.setDragTarget(i3);
        obj10 = obj9.getAnchors().closestAnchor(obj9.getOffset());
        if (obj10 != null && Float.compare(obj11, i2) <= 0 && (Boolean)obj9.confirmValueChange.invoke(obj10).booleanValue()) {
            if (Float.compare(obj11, i2) <= 0) {
                if ((Boolean)obj9.confirmValueChange.invoke(obj10).booleanValue()) {
                    obj9.setCurrentValue(obj10);
                }
            }
        }
    }

    public final float dispatchRawDelta(float delta) {
        int offset;
        final float offsetForDelta$material_release = newOffsetForDelta$material_release(delta);
        if (Float.isNaN(getOffset())) {
            offset = 0;
        } else {
            offset = getOffset();
        }
        setOffset(offsetForDelta$material_release);
        return offsetForDelta$material_release - offset;
    }

    public final androidx.compose.material.DraggableAnchors<T> getAnchors() {
        final int i = 0;
        final int i2 = 0;
        return (DraggableAnchors)(State)this.anchors$delegate.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final T getClosestValue$material_release() {
        final int i = 0;
        final int i2 = 0;
        return this.closestValue$delegate.getValue();
    }

    public final Function1<T, Boolean> getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.currentValue$delegate.getValue();
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.lastVelocity$delegate.getFloatValue();
    }

    public final float getOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.offset$delegate.getFloatValue();
    }

    public final Function1<Float, Float> getPositionalThreshold$material_release() {
        return this.positionalThreshold;
    }

    public final float getProgress() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.progress$delegate.getValue().floatValue();
    }

    public final T getTargetValue() {
        final int i = 0;
        final int i2 = 0;
        return this.targetValue$delegate.getValue();
    }

    public final Function0<Float> getVelocityThreshold$material_release() {
        return this.velocityThreshold;
    }

    public final boolean isAnimationRunning() {
        int i;
        i = getDragTarget() != null ? 1 : 0;
        return i;
    }

    public final float newOffsetForDelta$material_release(float delta) {
        int offset;
        if (Float.isNaN(getOffset())) {
            offset = 0;
        } else {
            offset = getOffset();
        }
        return RangesKt.coerceIn(offset += delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
        } else {
            return getOffset();
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        throw illegalStateException;
    }

    public final Object settle(float velocity, Continuation<? super Unit> $completion) {
        Unit iNSTANCE;
        Object cOROUTINE_SUSPENDED;
        final Object currentValue = getCurrentValue();
        Object target = computeTarget(requireOffset(), currentValue, velocity);
        if ((Boolean)this.confirmValueChange.invoke(target).booleanValue()) {
            Object animateTo2 = AnchoredDraggableKt.animateTo(this, target, velocity, $completion);
            if (animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return animateTo2;
            }
            iNSTANCE = Unit.INSTANCE;
        } else {
            Object animateTo = AnchoredDraggableKt.animateTo(this, currentValue, velocity, $completion);
            if (animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return animateTo;
            } else {
                iNSTANCE = Unit.INSTANCE;
            }
        }
        return iNSTANCE;
    }

    public final void updateAnchors(androidx.compose.material.DraggableAnchors<T> newAnchors, T newTarget) {
        boolean trySnapTo;
        setAnchors(newAnchors);
        if (!Intrinsics.areEqual(getAnchors(), newAnchors) && !trySnapTo(newTarget)) {
            setAnchors(newAnchors);
            if (!trySnapTo(newTarget)) {
                setDragTarget(newTarget);
            }
        }
    }
}
