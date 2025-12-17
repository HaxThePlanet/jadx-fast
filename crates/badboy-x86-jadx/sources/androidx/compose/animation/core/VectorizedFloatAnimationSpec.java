package androidx.compose.animation.core;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u000b\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\u0008\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u000c\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001a", d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(Landroidx/compose/animation/core/Animations;)V", "endVelocityVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedFloatAnimationSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;
    static {
        final int i = 8;
    }

    public VectorizedFloatAnimationSpec(androidx.compose.animation.core.Animations anims) {
        super();
        this.anims = anims;
    }

    public VectorizedFloatAnimationSpec(androidx.compose.animation.core.FloatAnimationSpec anim) {
        VectorizedFloatAnimationSpec.1 anon = new VectorizedFloatAnimationSpec.1(anim);
        super((Animations)anon);
    }

    public long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        int maxDuration;
        int nextInt;
        int i;
        int i2;
        long l;
        float f2;
        float f;
        float f3;
        maxDuration = 0;
        int i4 = 0;
        final Iterator iterator = (Iterable)RangesKt.until(0, initialValue.getSize$animation_core_release()).iterator();
        while (iterator.hasNext()) {
            i = nextInt;
            i2 = 0;
            f2 = initialValue.get$animation_core_release(i);
            maxDuration = l;
        }
        return maxDuration;
    }

    public V getEndVelocity(V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector endVelocityVector3;
        int i2;
        androidx.compose.animation.core.AnimationVector endVelocityVector;
        androidx.compose.animation.core.AnimationVector i;
        androidx.compose.animation.core.AnimationVector endVelocityVector2;
        float endVelocity;
        float f3;
        float f2;
        float f;
        if (this.endVelocityVector == null) {
            this.endVelocityVector = AnimationVectorsKt.newInstance(initialVelocity);
        }
        i2 = 0;
        i = 0;
        final String str = "endVelocityVector";
        if (this.endVelocityVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            endVelocityVector = i;
        }
        while (i2 < endVelocityVector.getSize$animation_core_release()) {
            if (this.endVelocityVector == null) {
            }
            endVelocityVector2.set$animation_core_release(i2, this.anims.get(i2).getEndVelocity(initialValue.get$animation_core_release(i2), targetValue.get$animation_core_release(i2), initialVelocity.get$animation_core_release(i2)));
            i2++;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            endVelocityVector2 = i;
        }
        androidx.compose.animation.core.AnimationVector i3 = this.endVelocityVector;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            i = i3;
        }
        return i;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector valueVector3;
        int i;
        androidx.compose.animation.core.AnimationVector valueVector;
        androidx.compose.animation.core.AnimationVector i2;
        androidx.compose.animation.core.AnimationVector valueVector2;
        androidx.compose.animation.core.AnimationVector animationVector;
        float valueFromNanos;
        long l;
        float f;
        float f3;
        float f2;
        Object obj;
        Object obj3;
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(targetValue);
        }
        i = 0;
        i2 = 0;
        final String str = "valueVector";
        if (this.valueVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            valueVector = i2;
        }
        while (i < valueVector.getSize$animation_core_release()) {
            if (this.valueVector == null) {
            }
            valueVector2.set$animation_core_release(i, this.anims.get(i).getValueFromNanos(playTimeNanos, obj8, targetValue.get$animation_core_release(i), initialVelocity.get$animation_core_release(i)));
            i++;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            valueVector2 = i2;
        }
        androidx.compose.animation.core.AnimationVector animationVector2 = targetValue;
        Object obj2 = initialVelocity;
        Object obj4 = obj19;
        androidx.compose.animation.core.AnimationVector i3 = this.valueVector;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            i2 = i3;
        }
        return i2;
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector velocityVector3;
        int i2;
        androidx.compose.animation.core.AnimationVector velocityVector;
        androidx.compose.animation.core.AnimationVector i;
        androidx.compose.animation.core.AnimationVector velocityVector2;
        Object obj;
        float velocityFromNanos;
        long l;
        float f;
        float f2;
        float f3;
        Object obj3;
        androidx.compose.animation.core.AnimationVector animationVector;
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(obj19);
        }
        i2 = 0;
        i = 0;
        final String str = "velocityVector";
        if (this.velocityVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            velocityVector = i;
        }
        while (i2 < velocityVector.getSize$animation_core_release()) {
            if (this.velocityVector == null) {
            }
            velocityVector2.set$animation_core_release(i2, this.anims.get(i2).getVelocityFromNanos(playTimeNanos, obj8, targetValue.get$animation_core_release(i2), initialVelocity.get$animation_core_release(i2)));
            i2++;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            velocityVector2 = i;
        }
        Object obj2 = targetValue;
        Object obj4 = initialVelocity;
        androidx.compose.animation.core.AnimationVector animationVector2 = obj19;
        androidx.compose.animation.core.AnimationVector i3 = this.velocityVector;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            i = i3;
        }
        return i;
    }
}
