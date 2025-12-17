package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
@Metadata(d1 = "\u0000w\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0016*\u0001\u0018\u0008\u0007\u0018\u0000 p*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001pB\u008f\u0001\u0008\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\r\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0011\u0012#\u0008\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0015B\u007f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\r\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0011\u0012#\u0008\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0016Jy\u0010P\u001a\u00020Q2\u0006\u0010K\u001a\u00028\u00002\u0008\u0008\u0002\u0010R\u001a\u00020S2W\u0010T\u001aS\u0008\u0001\u0012\u0004\u0012\u00020V\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(W\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(K\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020Q0X\u0012\u0006\u0012\u0004\u0018\u00010\u00020U¢\u0006\u0002\u0008YH\u0086@¢\u0006\u0002\u0010ZJ\\\u0010P\u001a\u00020Q2\u0008\u0008\u0002\u0010R\u001a\u00020S2B\u0010T\u001a>\u0008\u0001\u0012\u0004\u0012\u00020V\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020Q0X\u0012\u0006\u0012\u0004\u0018\u00010\u00020[¢\u0006\u0002\u0008YH\u0086@¢\u0006\u0002\u0010\\J%\u0010]\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u00082\u0006\u0010#\u001a\u00028\u00002\u0006\u0010^\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0010_J\u000e\u0010`\u001a\u00020\u00082\u0006\u0010a\u001a\u00020\u0008J\u0015\u0010b\u001a\u00020\u00082\u0006\u0010a\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008cJ\u001d\u0010?\u001a\u00020\u00082\u0006\u0010d\u001a\u00028\u00002\u0006\u0010e\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020\u0008J\u0016\u0010h\u001a\u00020\u00082\u0006\u0010^\u001a\u00020\u0008H\u0086@¢\u0006\u0002\u0010iJ\u0015\u0010j\u001a\u00020\u00142\u0006\u0010K\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010kJ#\u0010l\u001a\u00020Q2\u000c\u0010m\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00052\u0008\u0008\u0002\u0010n\u001a\u00028\u0000¢\u0006\u0002\u0010oR\u0016\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R7\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00052\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001f\u0010 \u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR/\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00140\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R+\u0010#\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008(\u0010 \u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010-\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u001a\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u00080\u0010 \u001a\u0004\u0008.\u0010%\"\u0004\u0008/\u0010'R\u0011\u00101\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\u00081\u00102R+\u00103\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00088F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00088\u00109\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R+\u0010:\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00088F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008=\u00109\u001a\u0004\u0008;\u00105\"\u0004\u0008<\u00107R/\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00080\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010\"R!\u0010?\u001a\u00020\u00088GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\u0008C\u0010D\u0012\u0004\u0008@\u0010A\u001a\u0004\u0008B\u00105R+\u0010E\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008H\u0010 \u001a\u0004\u0008F\u0010%\"\u0004\u0008G\u0010'R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010JR\u001b\u0010K\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008M\u0010D\u001a\u0004\u0008L\u0010%R\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\rX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010O¨\u0006q", d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "", "initialValue", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "<set-?>", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "offset", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$foundation_release", "progress", "getProgress$annotations", "()V", "getProgress", "progress$delegate", "Landroidx/compose/runtime/State;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function4;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchor", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "newOffsetForDelta", "newOffsetForDelta$foundation_release", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "updateAnchors", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnchoredDraggableState<T>  {

    public static final int $stable;
    public static final androidx.compose.foundation.gestures.AnchoredDraggableState.Companion Companion;
    private final androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDragScope.1<T> anchoredDragScope;
    private final MutableState anchors$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    private final Function1<Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final MutableState settledValue$delegate;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final State targetValue$delegate;
    private final Function0<Float> velocityThreshold;

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0087\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0008\u0008\u0001\u0010\u0006*\u00020\u00012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000b2!\u0010\u000c\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u000e\u0012\u0008\u0008\u000f\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\t0\r2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00122\u0014\u0008\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00140\rH\u0007¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "confirmValueChange", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static Saver Saver$default(androidx.compose.foundation.gestures.AnchoredDraggableState.Companion anchoredDraggableState$Companion, AnimationSpec animationSpec2, DecayAnimationSpec decayAnimationSpec3, Function1 function14, Function0 function05, Function1 function16, int i7, Object object8) {
            androidx.compose.foundation.gestures.AnchoredDraggableState.Companion.Saver.1 anon;
            androidx.compose.foundation.gestures.AnchoredDraggableState.Companion.Saver.1 obj11;
            if (i7 &= 16 != 0) {
                anon = obj11;
            } else {
                anon = function16;
            }
            return companion.Saver(animationSpec2, decayAnimationSpec3, function14, function05, anon);
        }

        public final <T> Saver<androidx.compose.foundation.gestures.AnchoredDraggableState<T>, T> Saver(AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold, Function1<? super T, Boolean> confirmValueChange) {
            AnchoredDraggableState.Companion.Saver.3 anon = new AnchoredDraggableState.Companion.Saver.3(positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange);
            return SaverKt.Saver((Function2)AnchoredDraggableState.Companion.Saver.2.INSTANCE, (Function1)anon);
        }
    }
    static {
        AnchoredDraggableState.Companion companion = new AnchoredDraggableState.Companion(0);
        AnchoredDraggableState.Companion = companion;
    }

    public AnchoredDraggableState(T initialValue, androidx.compose.foundation.gestures.DraggableAnchors<T> anchors, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> confirmValueChange) {
        final Object obj2 = initialValue;
        super(obj2, positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange);
        setAnchors(anchors);
        trySnapTo(obj2);
    }

    public AnchoredDraggableState(Object object, androidx.compose.foundation.gestures.DraggableAnchors draggableAnchors2, Function1 function13, Function0 function04, AnimationSpec animationSpec5, DecayAnimationSpec decayAnimationSpec6, Function1 function17, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        androidx.compose.foundation.gestures.AnchoredDraggableState.2 iNSTANCE;
        androidx.compose.foundation.gestures.AnchoredDraggableState.2 anon;
        if (i8 & 64 != 0) {
            anon = iNSTANCE;
        } else {
            anon = function17;
        }
        super(object, draggableAnchors2, function13, function04, animationSpec5, decayAnimationSpec6, anon);
    }

    public AnchoredDraggableState(T initialValue, Function1<? super Float, Float> positionalThreshold, Function0<Float> velocityThreshold, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> confirmValueChange) {
        super();
        this.positionalThreshold = positionalThreshold;
        this.velocityThreshold = velocityThreshold;
        this.snapAnimationSpec = snapAnimationSpec;
        this.decayAnimationSpec = decayAnimationSpec;
        this.confirmValueChange = confirmValueChange;
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.dragMutex = mutatorMutex;
        int i = 0;
        final int i2 = 2;
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(initialValue, i, i2, i);
        this.settledValue$delegate = SnapshotStateKt.mutableStateOf$default(initialValue, i, i2, i);
        AnchoredDraggableState.targetValue.2 anon2 = new AnchoredDraggableState.targetValue.2(this);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf((Function0)anon2);
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(2143289344);
        AnchoredDraggableState.progress.2 anon3 = new AnchoredDraggableState.progress.2(this);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), (Function0)anon3);
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.access$emptyDraggableAnchors(), i, i2, i);
        AnchoredDraggableState.anchoredDragScope.1 anon = new AnchoredDraggableState.anchoredDragScope.1(this);
        this.anchoredDragScope = anon;
    }

    public AnchoredDraggableState(Object object, Function1 function12, Function0 function03, AnimationSpec animationSpec4, DecayAnimationSpec decayAnimationSpec5, Function1 function16, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        androidx.compose.foundation.gestures.AnchoredDraggableState.1 anon;
        androidx.compose.foundation.gestures.AnchoredDraggableState.1 obj13;
        if (i7 &= 32 != 0) {
            anon = obj13;
        } else {
            anon = function16;
        }
        super(object, function12, function03, animationSpec4, decayAnimationSpec5, anon);
    }

    public static final androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDragScope.1 access$getAnchoredDragScope$p(androidx.compose.foundation.gestures.AnchoredDraggableState $this) {
        return $this.anchoredDragScope;
    }

    public static final Object access$getDragTarget(androidx.compose.foundation.gestures.AnchoredDraggableState $this) {
        return $this.getDragTarget();
    }

    public static final void access$setCurrentValue(androidx.compose.foundation.gestures.AnchoredDraggableState $this, Object <set-?>) {
        $this.setCurrentValue(<set-?>);
    }

    public static final void access$setDragTarget(androidx.compose.foundation.gestures.AnchoredDraggableState $this, Object <set-?>) {
        $this.setDragTarget(<set-?>);
    }

    public static final void access$setLastVelocity(androidx.compose.foundation.gestures.AnchoredDraggableState $this, float <set-?>) {
        $this.setLastVelocity(<set-?>);
    }

    public static final void access$setOffset(androidx.compose.foundation.gestures.AnchoredDraggableState $this, float <set-?>) {
        $this.setOffset(<set-?>);
    }

    public static final void access$setSettledValue(androidx.compose.foundation.gestures.AnchoredDraggableState $this, Object <set-?>) {
        $this.setSettledValue(<set-?>);
    }

    public static Object anchoredDrag$default(androidx.compose.foundation.gestures.AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority2, Function3 function33, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (i5 &= 1 != 0) {
            obj1 = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj1, function33, continuation4);
    }

    public static Object anchoredDrag$default(androidx.compose.foundation.gestures.AnchoredDraggableState anchoredDraggableState, Object object2, MutatePriority mutatePriority3, Function4 function44, Continuation continuation5, int i6, Object object7) {
        MutatePriority obj2;
        if (i6 &= 2 != 0) {
            obj2 = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(object2, obj2, function44, continuation5);
    }

    private final T computeTarget(float offset, T currentValue, float velocity) {
        int closestAnchor;
        float positionOf;
        float i;
        float f;
        float f2;
        int cmp;
        final androidx.compose.foundation.gestures.DraggableAnchors anchors = getAnchors();
        final float positionOf2 = anchors.positionOf(currentValue);
        i = 0;
        closestAnchor = Float.compare(positionOf2, offset) == 0 ? positionOf : i;
        if (closestAnchor == 0) {
            if (Float.isNaN(positionOf2)) {
                closestAnchor = currentValue;
            } else {
                f = 0;
                if (Float.compare(f3, f4) >= 0) {
                    if (Float.compare(signum, f) > 0) {
                    } else {
                        positionOf = i;
                    }
                    Intrinsics.checkNotNull(anchors.closestAnchor(offset, positionOf));
                } else {
                    if (Float.compare(i2, f) > 0) {
                    } else {
                        positionOf = i;
                    }
                    closestAnchor = anchors.closestAnchor(offset, positionOf);
                    Intrinsics.checkNotNull(closestAnchor);
                    if (Float.compare(f2, f) <= 0) {
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

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(...))
    public static void getProgress$annotations() {
    }

    private final void setAnchors(androidx.compose.foundation.gestures.DraggableAnchors<T> <set-?>) {
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

    private final void setSettledValue(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.settledValue$delegate.setValue(<set-?>);
    }

    private final boolean trySnapTo(T targetValue) {
        Throwable th;
        androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDragScope.1 anchoredDragScope;
        int i3;
        float positionOf;
        boolean naN;
        int i;
        int i2;
        int i4;
        final MutatorMutex dragMutex = this.dragMutex;
        final int i5 = 0;
        final boolean tryLock = dragMutex.tryLock();
        th = 0;
        i3 = 0;
        positionOf = getAnchors().positionOf(targetValue);
        if (tryLock && !Float.isNaN(positionOf)) {
            th = 0;
            i3 = 0;
            positionOf = getAnchors().positionOf(targetValue);
            if (!Float.isNaN(positionOf)) {
                i4 = 0;
                AnchoredDragScope.dragTo$default((AnchoredDragScope)this.anchoredDragScope, positionOf, 0, 2, i4);
                setDragTarget(i4);
            }
            setCurrentValue(targetValue);
            setSettledValue(targetValue);
            dragMutex.unlock();
        }
        return tryLock;
    }

    public static void updateAnchors$default(androidx.compose.foundation.gestures.AnchoredDraggableState anchoredDraggableState, androidx.compose.foundation.gestures.DraggableAnchors draggableAnchors2, Object object3, int i4, Object object5) {
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

    public final Object anchoredDrag(MutatePriority dragPriority, Function3<? super androidx.compose.foundation.gestures.AnchoredDragScope, ? super androidx.compose.foundation.gestures.DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        AnchoredDraggableState.anchoredDrag.2 anon = new AnchoredDraggableState.anchoredDrag.2(this, block, 0);
        Object mutate = this.dragMutex.mutate(dragPriority, (Function1)anon, $completion);
        if (mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return mutate;
        }
        return Unit.INSTANCE;
    }

    public final Object anchoredDrag(T t, MutatePriority mutatePriority2, Function4<? super androidx.compose.foundation.gestures.AnchoredDragScope, ? super androidx.compose.foundation.gestures.DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function43, Continuation<? super Unit> continuation4) {
        boolean anon2;
        int i;
        int i2;
        int label;
        Object anchorFor;
        androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.4 anon;
        int i3;
        Object obj8;
        Throwable obj9;
        Object obj11;
        anon2 = continuation4;
        i2 = Integer.MIN_VALUE;
        if (continuation4 instanceof AnchoredDraggableState.anchoredDrag.3 && label2 &= i2 != 0) {
            anon2 = continuation4;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon2.label = obj11 -= i2;
            } else {
                anon2 = new AnchoredDraggableState.anchoredDrag.3(this, continuation4);
            }
        } else {
        }
        obj11 = anon2.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i4 = 0;
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                label = this;
                anon = new AnchoredDraggableState.anchoredDrag.4(label, t, function43, i4);
                anon2.L$0 = label;
                anon2.label = 1;
                return cOROUTINE_SUSPENDED;
                obj8 = label;
                label.setSettledValue(t);
                label.setCurrentValue(t);
                return Unit.INSTANCE;
            case 1:
                obj8 = anon2.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        obj8.setDragTarget(i4);
    }

    public final float dispatchRawDelta(float delta) {
        int offset;
        final float offsetForDelta$foundation_release = newOffsetForDelta$foundation_release(delta);
        if (Float.isNaN(getOffset())) {
            offset = 0;
        } else {
            offset = getOffset();
        }
        setOffset(offsetForDelta$foundation_release);
        return offsetForDelta$foundation_release - offset;
    }

    public final androidx.compose.foundation.gestures.DraggableAnchors<T> getAnchors() {
        final int i = 0;
        final int i2 = 0;
        return (DraggableAnchors)(State)this.anchors$delegate.getValue();
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.currentValue$delegate.getValue();
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        return this.decayAnimationSpec;
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

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        return this.positionalThreshold;
    }

    public final float getProgress() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.progress$delegate.getValue().floatValue();
    }

    public final T getSettledValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.settledValue$delegate.getValue();
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final T getTargetValue() {
        final int i = 0;
        final int i2 = 0;
        return this.targetValue$delegate.getValue();
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        return this.velocityThreshold;
    }

    public final boolean isAnimationRunning() {
        int i;
        i = getDragTarget() != null ? 1 : 0;
        return i;
    }

    public final float newOffsetForDelta$foundation_release(float delta) {
        int offset;
        if (Float.isNaN(getOffset())) {
            offset = 0;
        } else {
            offset = getOffset();
        }
        return RangesKt.coerceIn(offset += delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float progress(T from, T to) {
        boolean naN;
        int i;
        float positionOf = getAnchors().positionOf(from);
        float positionOf2 = getAnchors().positionOf(to);
        i2 /= i4;
        i = 1065353216;
        if (!Float.isNaN(i3)) {
            if (Float.compare(i3, i5) < 0) {
                i = 0;
            } else {
                if (Float.compare(i3, i6) > 0) {
                } else {
                    i = Math.abs(i3);
                }
            }
        } else {
        }
        return i;
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
        } else {
            return getOffset();
        }
        int i = 0;
        IllegalStateException $i$a$CheckAnchoredDraggableState$requireOffset$1 = new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        throw $i$a$CheckAnchoredDraggableState$requireOffset$1;
    }

    public final Object settle(float velocity, Continuation<? super Float> $completion) {
        Object animateToWithDecay;
        final Object currentValue = getCurrentValue();
        Object target = computeTarget(requireOffset(), currentValue, velocity);
        if ((Boolean)this.confirmValueChange.invoke(target).booleanValue()) {
            animateToWithDecay = AnchoredDraggableKt.animateToWithDecay(this, target, velocity, $completion);
        } else {
            animateToWithDecay = AnchoredDraggableKt.animateToWithDecay(this, currentValue, velocity, $completion);
        }
        return animateToWithDecay;
    }

    public final void updateAnchors(androidx.compose.foundation.gestures.DraggableAnchors<T> newAnchors, T newTarget) {
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
