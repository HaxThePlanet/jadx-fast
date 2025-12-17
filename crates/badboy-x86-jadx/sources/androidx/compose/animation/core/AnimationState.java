package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u001d\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004BK\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00018\u0001\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0008\u0010*\u001a\u00020+H\u0016R&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R$\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R&\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011\"\u0004\u0008\u0018\u0010\u0013R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008 \u0010!\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u0008#\u0010\u001dR&\u0010$\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u0001@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(¨\u0006,", d2 = {"Landroidx/compose/animation/core/AnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)V", "<set-?>", "getFinishedTimeNanos", "()J", "setFinishedTimeNanos$animation_core_release", "(J)V", "()Z", "setRunning$animation_core_release", "(Z)V", "getLastFrameTimeNanos", "setLastFrameTimeNanos$animation_core_release", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "()Ljava/lang/Object;", "setValue$animation_core_release", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core_release", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimationState<T, V extends androidx.compose.animation.core.AnimationVector>  implements State<T> {

    public static final int $stable;
    private long finishedTimeNanos;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
    private final MutableState value$delegate;
    private V velocityVector;
    static {
    }

    public AnimationState(androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, V initialVelocityVector, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        androidx.compose.animation.core.AnimationVector mutableStateOf$default;
        super();
        this.typeConverter = typeConverter;
        int i = 0;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(initialValue, i, 2, i);
        if (initialVelocityVector != null) {
            if (AnimationVectorsKt.copy(initialVelocityVector) == null) {
                mutableStateOf$default = AnimationStateKt.createZeroVectorFrom(this.typeConverter, initialValue);
            }
        } else {
        }
        this.velocityVector = mutableStateOf$default;
        this.lastFrameTimeNanos = lastFrameTimeNanos;
        this.finishedTimeNanos = isRunning;
        this.isRunning = obj10;
    }

    public AnimationState(androidx.compose.animation.core.TwoWayConverter twoWayConverter, Object object2, androidx.compose.animation.core.AnimationVector animationVector3, long l4, long l5, boolean z6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int i2;
        long l2;
        long l;
        int i;
        int obj12;
        i2 = obj18 & 4 != 0 ? obj12 : animationVector3;
        long l3 = Long.MIN_VALUE;
        l2 = obj18 & 8 != 0 ? l3 : l4;
        l = obj18 & 16 != 0 ? l3 : z6;
        i = obj18 & 32 != 0 ? obj12 : defaultConstructorMarker8;
        super(twoWayConverter, object2, i2, l2, obj5, l, obj7, i);
    }

    @Override // androidx.compose.runtime.State
    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    @Override // androidx.compose.runtime.State
    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public T getValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.value$delegate.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public final V getVelocityVector() {
        return this.velocityVector;
    }

    @Override // androidx.compose.runtime.State
    public final boolean isRunning() {
        return this.isRunning;
    }

    @Override // androidx.compose.runtime.State
    public final void setFinishedTimeNanos$animation_core_release(long <set-?>) {
        this.finishedTimeNanos = <set-?>;
    }

    @Override // androidx.compose.runtime.State
    public final void setLastFrameTimeNanos$animation_core_release(long <set-?>) {
        this.lastFrameTimeNanos = <set-?>;
    }

    @Override // androidx.compose.runtime.State
    public final void setRunning$animation_core_release(boolean <set-?>) {
        this.isRunning = <set-?>;
    }

    public void setValue$animation_core_release(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setValue(<set-?>);
    }

    public final void setVelocityVector$animation_core_release(V <set-?>) {
        this.velocityVector = <set-?>;
    }

    @Override // androidx.compose.runtime.State
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AnimationState(value=").append(getValue()).append(", velocity=").append(getVelocity()).append(", isRunning=").append(this.isRunning).append(", lastFrameTimeNanos=").append(this.lastFrameTimeNanos).append(", finishedTimeNanos=").append(this.finishedTimeNanos).append(')').toString();
    }
}
