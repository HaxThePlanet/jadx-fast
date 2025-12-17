package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0003\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0003\u0010\u0005\u001a\u00020\u0004\u001aI\u0010\u0006\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002\"\u0008\u0008\u0001\u0010\u0007*\u00020\u0008*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u0002H\u00022\u0006\u0010\u000c\u001a\u0002H\u0002¢\u0006\u0002\u0010\r\u001a \u0010\u0006\u001a\u00020\u0004*\u0008\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u0004\u001a\u0016\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u000f¨\u0006\u0010", d2 = {"exponentialDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "frictionMultiplier", "", "absVelocityThreshold", "calculateTargetValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "generateDecayAnimationSpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DecayAnimationSpecKt {
    public static final float calculateTargetValue(androidx.compose.animation.core.DecayAnimationSpec<Float> $this$calculateTargetValue, float initialValue, float initialVelocity) {
        return (AnimationVector1D)$this$calculateTargetValue.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)).getTargetValue((AnimationVector)AnimationVectorsKt.AnimationVector(initialValue), (AnimationVector)AnimationVectorsKt.AnimationVector(initialVelocity)).getValue();
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> T calculateTargetValue(androidx.compose.animation.core.DecayAnimationSpec<T> $this$calculateTargetValue, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, T initialVelocity) {
        return typeConverter.getConvertFromVector().invoke($this$calculateTargetValue.vectorize(typeConverter).getTargetValue((AnimationVector)typeConverter.getConvertToVector().invoke(initialValue), (AnimationVector)typeConverter.getConvertToVector().invoke(initialVelocity)));
    }

    public static final <T> androidx.compose.animation.core.DecayAnimationSpec<T> exponentialDecay(float frictionMultiplier, float absVelocityThreshold) {
        FloatExponentialDecaySpec floatExponentialDecaySpec = new FloatExponentialDecaySpec(frictionMultiplier, absVelocityThreshold);
        return DecayAnimationSpecKt.generateDecayAnimationSpec((FloatDecayAnimationSpec)floatExponentialDecaySpec);
    }

    public static androidx.compose.animation.core.DecayAnimationSpec exponentialDecay$default(float f, float f2, int i3, Object object4) {
        int obj0;
        int obj1;
        if (i3 & 1 != 0) {
            obj0 = 1065353216;
        }
        if (i3 &= 2 != 0) {
            obj1 = 1036831949;
        }
        return DecayAnimationSpecKt.exponentialDecay(obj0, obj1);
    }

    public static final <T> androidx.compose.animation.core.DecayAnimationSpec<T> generateDecayAnimationSpec(androidx.compose.animation.core.FloatDecayAnimationSpec $this$generateDecayAnimationSpec) {
        DecayAnimationSpecImpl decayAnimationSpecImpl = new DecayAnimationSpecImpl($this$generateDecayAnimationSpec);
        return (DecayAnimationSpec)decayAnimationSpecImpl;
    }
}
