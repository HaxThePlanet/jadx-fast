package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J+\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0002\u0010\u001eR/\u0010\t\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u0008\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000bR\u0016\u0010\u0017\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/animation/core/DeferredTargetAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "vectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/TwoWayConverter;)V", "<set-?>", "_pendingTarget", "get_pendingTarget", "()Ljava/lang/Object;", "set_pendingTarget", "(Ljava/lang/Object;)V", "_pendingTarget$delegate", "Landroidx/compose/runtime/MutableState;", "animatable", "Landroidx/compose/animation/core/Animatable;", "isIdle", "", "()Z", "pendingTarget", "getPendingTarget", "target", "getTarget", "updateTarget", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/FiniteAnimationSpec;)Ljava/lang/Object;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeferredTargetAnimation<T, V extends androidx.compose.animation.core.AnimationVector>  {

    public static final int $stable = 8;
    private final MutableState _pendingTarget$delegate;
    private androidx.compose.animation.core.Animatable<T, V> animatable;
    private final androidx.compose.animation.core.TwoWayConverter<T, V> vectorConverter;
    static {
        final int i = 8;
    }

    public DeferredTargetAnimation(androidx.compose.animation.core.TwoWayConverter<T, V> vectorConverter) {
        super();
        this.vectorConverter = vectorConverter;
        int i = 0;
        this._pendingTarget$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
    }

    public static final Object access$get_pendingTarget(androidx.compose.animation.core.DeferredTargetAnimation $this) {
        return $this.get_pendingTarget();
    }

    private final T getTarget() {
        Object targetValue;
        androidx.compose.animation.core.Animatable animatable = this.animatable;
        if (animatable != null) {
            targetValue = animatable.getTargetValue();
        } else {
            targetValue = 0;
        }
        return targetValue;
    }

    private final T get_pendingTarget() {
        final int i = 0;
        final int i2 = 0;
        return (State)this._pendingTarget$delegate.getValue();
    }

    private final void set_pendingTarget(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._pendingTarget$delegate.setValue(<set-?>);
    }

    public static Object updateTarget$default(androidx.compose.animation.core.DeferredTargetAnimation deferredTargetAnimation, Object object2, CoroutineScope coroutineScope3, androidx.compose.animation.core.FiniteAnimationSpec finiteAnimationSpec4, int i5, Object object6) {
        androidx.compose.animation.core.SpringSpec obj3;
        int obj4;
        int obj5;
        if (i5 &= 4 != 0) {
            obj4 = 0;
            obj5 = 0;
            obj3 = AnimationSpecKt.spring$default(obj4, obj4, obj5, 7, obj5);
        }
        return deferredTargetAnimation.updateTarget(object2, coroutineScope3, obj3);
    }

    public final T getPendingTarget() {
        return get_pendingTarget();
    }

    public final boolean isIdle() {
        boolean equal;
        androidx.compose.animation.core.Animatable animatable;
        int i;
        int i2;
        if (Intrinsics.areEqual(get_pendingTarget(), getTarget())) {
            animatable = this.animatable;
            i2 = 1;
            if (animatable != null && animatable.isRunning() == i2) {
                equal = animatable.isRunning() == i2 ? i2 : i;
            } else {
            }
            if (equal == 0) {
                i = i2;
            }
        }
        return i;
    }

    public final T updateTarget(T target, CoroutineScope coroutineScope, androidx.compose.animation.core.FiniteAnimationSpec<T> animationSpec) {
        androidx.compose.animation.core.Animatable animatable3;
        androidx.compose.animation.core.Animatable animatable;
        int i;
        androidx.compose.animation.core.Animatable animatable2;
        int i5;
        int i3;
        int i4;
        int i2;
        set_pendingTarget(target);
        animatable3 = this.animatable;
        if (animatable3 == null) {
            animatable = new Animatable(target, this.vectorConverter, 0, 0, 12, 0);
            i = 0;
            this.animatable = animatable;
            animatable2 = animatable;
        } else {
            animatable2 = animatable3;
        }
        DeferredTargetAnimation.updateTarget.1 anon = new DeferredTargetAnimation.updateTarget.1(animatable2, this, target, animationSpec, 0);
        BuildersKt.launch$default(coroutineScope, 0, 0, (Function2)anon, 3, 0);
        return animatable2.getValue();
    }
}
