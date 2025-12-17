package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001BR\u0012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\u0010\u000cJ?\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2'\u0010\u001b\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001c¢\u0006\u0002\u0008\u001fH\u0096@¢\u0006\u0002\u0010 R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000RV\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/foundation/gestures/DefaultTransformableState;", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "(Lkotlin/jvm/functions/Function3;)V", "isTransformInProgress", "", "()Z", "isTransformingState", "Landroidx/compose/runtime/MutableState;", "getOnTransformation", "()Lkotlin/jvm/functions/Function3;", "transformMutex", "Landroidx/compose/foundation/MutatorMutex;", "transformScope", "Landroidx/compose/foundation/gestures/TransformScope;", "transform", "transformPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultTransformableState implements androidx.compose.foundation.gestures.TransformableState {

    private final MutableState<Boolean> isTransformingState;
    private final Function3<Float, Offset, Float, Unit> onTransformation;
    private final MutatorMutex transformMutex;
    private final androidx.compose.foundation.gestures.TransformScope transformScope;
    public DefaultTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> onTransformation) {
        super();
        this.onTransformation = onTransformation;
        DefaultTransformableState.transformScope.1 anon = new DefaultTransformableState.transformScope.1(this);
        this.transformScope = (TransformScope)anon;
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.transformMutex = mutatorMutex;
        final int i2 = 0;
        this.isTransformingState = SnapshotStateKt.mutableStateOf$default(false, i2, 2, i2);
    }

    public static final MutatorMutex access$getTransformMutex$p(androidx.compose.foundation.gestures.DefaultTransformableState $this) {
        return $this.transformMutex;
    }

    public static final androidx.compose.foundation.gestures.TransformScope access$getTransformScope$p(androidx.compose.foundation.gestures.DefaultTransformableState $this) {
        return $this.transformScope;
    }

    public static final MutableState access$isTransformingState$p(androidx.compose.foundation.gestures.DefaultTransformableState $this) {
        return $this.isTransformingState;
    }

    public final Function3<Float, Offset, Float, Unit> getOnTransformation() {
        return this.onTransformation;
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    public boolean isTransformInProgress() {
        return (Boolean)this.isTransformingState.getValue().booleanValue();
    }

    public Object transform(MutatePriority transformPriority, Function2<? super androidx.compose.foundation.gestures.TransformScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        DefaultTransformableState.transform.2 anon = new DefaultTransformableState.transform.2(this, transformPriority, block, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
