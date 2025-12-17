package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u000b\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0008B\u001f\u0008\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\r¨\u0006\u001e", d2 = {"Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLandroidx/compose/animation/core/AnimationVector;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(FFLandroidx/compose/animation/core/Animations;)V", "getDampingRatio", "()F", "isInfinite", "", "()Z", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedSpringSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.VectorizedFloatAnimationSpec<V> $$delegate_0;
    private final float dampingRatio;
    private final float stiffness;
    static {
        final int i = 8;
    }

    public VectorizedSpringSpec(float dampingRatio, float stiffness, V visibilityThreshold) {
        super(dampingRatio, stiffness, VectorizedAnimationSpecKt.access$createSpringAnimations(visibilityThreshold, dampingRatio, stiffness));
    }

    public VectorizedSpringSpec(float f, float f2, androidx.compose.animation.core.AnimationVector animationVector3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        int obj3;
        obj1 = i4 & 1 != 0 ? 1065353216 : obj1;
        obj2 = i4 & 2 != 0 ? 1153138688 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(obj1, obj2, obj3);
    }

    private VectorizedSpringSpec(float dampingRatio, float stiffness, androidx.compose.animation.core.Animations anims) {
        super();
        this.dampingRatio = dampingRatio;
        this.stiffness = stiffness;
        VectorizedFloatAnimationSpec vectorizedFloatAnimationSpec = new VectorizedFloatAnimationSpec(anims);
        this.$$delegate_0 = vectorizedFloatAnimationSpec;
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public long getDurationNanos(V v, V v2, V v3) {
        return this.$$delegate_0.getDurationNanos(v, v2, v3);
    }

    public V getEndVelocity(V v, V v2, V v3) {
        return this.$$delegate_0.getEndVelocity(v, v2, v3);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec
    public final float getStiffness() {
        return this.stiffness;
    }

    public V getValueFromNanos(long l, V v2, V v3, V v4) {
        return this.$$delegate_0.getValueFromNanos(l, obj2, v3, v4);
    }

    public V getVelocityFromNanos(long l, V v2, V v3, V v4) {
        return this.$$delegate_0.getVelocityFromNanos(l, obj2, v3, v4);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec
    public boolean isInfinite() {
        return this.$$delegate_0.isInfinite();
    }
}
