package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B9\u0008\u0016\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000bB9\u0008\u0016\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\u000c\u001a\u00028\u0000¢\u0006\u0002\u0010\rB7\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0002\u0010\u000fJ\u0015\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010'R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0013\u0010\n\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001eR\u0016\u0010\u001f\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008 \u0010\u0017R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u0006(", d2 = {"Landroidx/compose/animation/core/DecayAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)V", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "getInitialVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "isInfinite", "", "()Z", "targetValue", "getTargetValue", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DecayAnimation<T, V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.Animation<T, V> {

    public static final int $stable;
    private final androidx.compose.animation.core.VectorizedDecayAnimationSpec<V> animationSpec;
    private final long durationNanos;
    private final V endVelocity;
    private final T initialValue;
    private final V initialValueVector;
    private final V initialVelocityVector;
    private final boolean isInfinite;
    private final T targetValue;
    private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
    static {
    }

    public DecayAnimation(androidx.compose.animation.core.DecayAnimationSpec<T> animationSpec, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, V initialVelocityVector) {
        super(animationSpec.vectorize(typeConverter), typeConverter, initialValue, initialVelocityVector);
    }

    public DecayAnimation(androidx.compose.animation.core.DecayAnimationSpec<T> animationSpec, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, T initialVelocity) {
        super(animationSpec.vectorize(typeConverter), typeConverter, initialValue, (AnimationVector)typeConverter.getConvertToVector().invoke(initialVelocity));
    }

    public DecayAnimation(androidx.compose.animation.core.VectorizedDecayAnimationSpec<V> animationSpec, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, V initialVelocityVector) {
        int i;
        androidx.compose.animation.core.AnimationVector initialValueVector2;
        androidx.compose.animation.core.AnimationVector initialValueVector;
        int i2;
        float absVelocityThreshold;
        super();
        this.animationSpec = animationSpec;
        this.typeConverter = typeConverter;
        this.initialValue = initialValue;
        this.initialValueVector = (AnimationVector)getTypeConverter().getConvertToVector().invoke(this.initialValue);
        this.initialVelocityVector = AnimationVectorsKt.copy(initialVelocityVector);
        initialValueVector2 = this.initialValueVector;
        this.targetValue = getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getTargetValue(initialValueVector2, initialVelocityVector));
        this.durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, initialVelocityVector);
        this.endVelocity = AnimationVectorsKt.copy(this.animationSpec.getVelocityFromNanos(getDurationNanos(), initialValueVector2, this.initialValueVector));
        i = 0;
        while (i < this.endVelocity.getSize$animation_core_release()) {
            this.endVelocity.set$animation_core_release(i, RangesKt.coerceIn(this.endVelocity.get$animation_core_release(i), -absVelocityThreshold2, this.animationSpec.getAbsVelocityThreshold()));
            i++;
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public final V getInitialVelocityVector() {
        return this.initialVelocityVector;
    }

    public T getTargetValue() {
        return this.targetValue;
    }

    public androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public T getValueFromNanos(long playTimeNanos) {
        if (!isFinishedFromNanos(playTimeNanos)) {
            return getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(playTimeNanos, obj6, this.initialValueVector));
        }
        return getTargetValue();
    }

    public V getVelocityVectorFromNanos(long playTimeNanos) {
        if (!isFinishedFromNanos(playTimeNanos)) {
            return this.animationSpec.getVelocityFromNanos(playTimeNanos, obj5, this.initialValueVector);
        }
        return this.endVelocity;
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.isInfinite;
    }
}
