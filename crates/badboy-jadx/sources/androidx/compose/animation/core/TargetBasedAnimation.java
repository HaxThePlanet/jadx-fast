package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0014\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BE\u0008\u0016\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000cBE\u0008\u0000\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000eJ\u0015\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00028\u00012\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0002\u00102J\u0008\u00103\u001a\u000204H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\rX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000b\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010 R&\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\u0008#\u0010\u001c\"\u0004\u0008$\u0010%R&\u0010'\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\u0008(\u0010\u001c\"\u0004\u0008)\u0010%R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010\u001cR\u0010\u0010+\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-¨\u00065", d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "_durationNanos", "", "_endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "durationNanos", "getDurationNanos", "()J", "endVelocity", "getEndVelocity", "()Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "initialValueVector", "isInfinite", "", "()Z", "value", "mutableInitialValue", "getMutableInitialValue$animation_core_release", "setMutableInitialValue$animation_core_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "mutableTargetValue", "getMutableTargetValue$animation_core_release", "setMutableTargetValue$animation_core_release", "getTargetValue", "targetValueVector", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TargetBasedAnimation<T, V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.Animation<T, V> {

    public static final int $stable = 8;
    private long _durationNanos;
    private V _endVelocity;
    private final androidx.compose.animation.core.VectorizedAnimationSpec<V> animationSpec;
    private V initialValueVector;
    private final V initialVelocityVector;
    private T mutableInitialValue;
    private T mutableTargetValue;
    private V targetValueVector;
    private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
    static {
        final int i = 8;
    }

    public TargetBasedAnimation(androidx.compose.animation.core.AnimationSpec<T> animationSpec, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, T targetValue, V initialVelocityVector) {
        super(animationSpec.vectorize(typeConverter), typeConverter, initialValue, targetValue, initialVelocityVector);
    }

    public TargetBasedAnimation(androidx.compose.animation.core.AnimationSpec animationSpec, androidx.compose.animation.core.TwoWayConverter twoWayConverter2, Object object3, Object object4, androidx.compose.animation.core.AnimationVector animationVector5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        int obj11;
        i = i6 &= 16 != 0 ? obj11 : animationVector5;
        super(animationSpec, twoWayConverter2, object3, object4, i);
    }

    public TargetBasedAnimation(androidx.compose.animation.core.VectorizedAnimationSpec<V> animationSpec, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, T targetValue, V initialVelocityVector) {
        androidx.compose.animation.core.AnimationVector instance;
        super();
        this.animationSpec = animationSpec;
        this.typeConverter = typeConverter;
        this.mutableTargetValue = targetValue;
        this.mutableInitialValue = initialValue;
        this.initialValueVector = (AnimationVector)getTypeConverter().getConvertToVector().invoke(initialValue);
        this.targetValueVector = (AnimationVector)getTypeConverter().getConvertToVector().invoke(targetValue);
        if (initialVelocityVector != null) {
            if (AnimationVectorsKt.copy(initialVelocityVector) == null) {
                instance = AnimationVectorsKt.newInstance((AnimationVector)getTypeConverter().getConvertToVector().invoke(initialValue));
            }
        } else {
        }
        this.initialVelocityVector = instance;
        this._durationNanos = -1;
    }

    public TargetBasedAnimation(androidx.compose.animation.core.VectorizedAnimationSpec vectorizedAnimationSpec, androidx.compose.animation.core.TwoWayConverter twoWayConverter2, Object object3, Object object4, androidx.compose.animation.core.AnimationVector animationVector5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        int obj11;
        i = i6 &= 16 != 0 ? obj11 : animationVector5;
        super(vectorizedAnimationSpec, twoWayConverter2, object3, object4, i);
    }

    private final V getEndVelocity() {
        androidx.compose.animation.core.AnimationVector _endVelocity;
        androidx.compose.animation.core.AnimationVector animationVector;
        int i;
        androidx.compose.animation.core.AnimationVector initialVelocityVector;
        if (this._endVelocity == null) {
            i = 0;
            this._endVelocity = this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return _endVelocity;
    }

    public final androidx.compose.animation.core.VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        int durationNanos;
        androidx.compose.animation.core.AnimationVector initialValueVector;
        int targetValueVector;
        androidx.compose.animation.core.AnimationVector initialVelocityVector;
        if (Long.compare(_durationNanos, targetValueVector) < 0) {
            this._durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return this._durationNanos;
    }

    public final T getInitialValue() {
        return this.mutableInitialValue;
    }

    public final T getMutableInitialValue$animation_core_release() {
        return this.mutableInitialValue;
    }

    public final T getMutableTargetValue$animation_core_release() {
        return this.mutableTargetValue;
    }

    public T getTargetValue() {
        return this.mutableTargetValue;
    }

    public androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public T getValueFromNanos(long playTimeNanos) {
        int i;
        boolean finishedFromNanos;
        int size$animation_core_release;
        long playTimeNanos2;
        androidx.compose.animation.core.AnimationVector initialValueVector;
        androidx.compose.animation.core.AnimationVector targetValueVector;
        androidx.compose.animation.core.AnimationVector $i$a$CheckPreconditionTargetBasedAnimation$getValueFromNanos$1$1;
        StringBuilder append;
        String str;
        Object obj10;
        int obj11;
        if (!isFinishedFromNanos(playTimeNanos)) {
            playTimeNanos2 = playTimeNanos;
            obj10 = this.animationSpec.getValueFromNanos(playTimeNanos2, obj3, this.initialValueVector, this.targetValueVector);
            obj11 = 0;
            i = 0;
            while (i < obj10.getSize$animation_core_release()) {
                targetValueVector = null;
                if (naN ^= 1 == null) {
                }
                i++;
                int i2 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder.append("AnimationVector cannot contain a NaN. ").append(obj10).append(". Animation: ").append(this).append(", playTimeNanos: ").append(playTimeNanos2).toString());
            }
            obj10 = getTypeConverter().getConvertFromVector().invoke(obj10);
        } else {
            playTimeNanos2 = playTimeNanos;
            obj10 = getTargetValue();
        }
        return obj10;
    }

    public V getVelocityVectorFromNanos(long playTimeNanos) {
        androidx.compose.animation.core.VectorizedAnimationSpec animationSpec;
        long playTimeNanos2;
        androidx.compose.animation.core.AnimationVector initialValueVector;
        androidx.compose.animation.core.AnimationVector targetValueVector;
        androidx.compose.animation.core.AnimationVector initialVelocityVector;
        androidx.compose.animation.core.AnimationVector obj8;
        if (!isFinishedFromNanos(playTimeNanos)) {
            obj8 = this.animationSpec.getVelocityFromNanos(playTimeNanos, obj3, this.initialValueVector, this.targetValueVector);
        } else {
            playTimeNanos2 = playTimeNanos;
            obj8 = getEndVelocity();
        }
        return obj8;
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public final void setMutableInitialValue$animation_core_release(T value) {
        boolean equal;
        if (!Intrinsics.areEqual(value, this.mutableInitialValue)) {
            this.mutableInitialValue = value;
            this.initialValueVector = (AnimationVector)getTypeConverter().getConvertToVector().invoke(value);
            this._endVelocity = 0;
            this._durationNanos = -1;
        }
    }

    public final void setMutableTargetValue$animation_core_release(T value) {
        boolean equal;
        if (!Intrinsics.areEqual(this.mutableTargetValue, value)) {
            this.mutableTargetValue = value;
            this.targetValueVector = (AnimationVector)getTypeConverter().getConvertToVector().invoke(value);
            this._endVelocity = 0;
            this._durationNanos = -1;
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TargetBasedAnimation: ").append(getInitialValue()).append(" -> ").append(getTargetValue()).append(",initial velocity: ").append(this.initialVelocityVector).append(", duration: ").append(AnimationKt.getDurationMillis((Animation)this)).append(" ms,animationSpec: ").append(this.animationSpec).toString();
    }
}
