package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0006\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ-\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0019", d2 = {"Landroidx/compose/animation/core/VectorizedTweenSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "anim", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "getDelayMillis", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedTweenSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.VectorizedFloatAnimationSpec<V> anim;
    private final int delayMillis;
    private final int durationMillis;
    private final androidx.compose.animation.core.Easing easing;
    static {
        final int i = 8;
    }

    public VectorizedTweenSpec() {
        super(0, 0, 0, 7, 0);
    }

    public VectorizedTweenSpec(int durationMillis, int delayMillis, androidx.compose.animation.core.Easing easing) {
        super();
        this.durationMillis = durationMillis;
        this.delayMillis = delayMillis;
        this.easing = easing;
        FloatTweenSpec floatTweenSpec = new FloatTweenSpec(getDurationMillis(), getDelayMillis(), this.easing);
        VectorizedFloatAnimationSpec vectorizedFloatAnimationSpec = new VectorizedFloatAnimationSpec((FloatAnimationSpec)floatTweenSpec);
        this.anim = vectorizedFloatAnimationSpec;
    }

    public VectorizedTweenSpec(int i, int i2, androidx.compose.animation.core.Easing easing3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        androidx.compose.animation.core.Easing obj3;
        obj1 = i4 & 1 != 0 ? 300 : obj1;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        if (i4 &= 4 != 0) {
            obj3 = EasingKt.getFastOutSlowInEasing();
        }
        super(obj1, obj2, obj3);
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public final androidx.compose.animation.core.Easing getEasing() {
        return this.easing;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        return this.anim.getValueFromNanos(playTimeNanos, obj2, targetValue, initialVelocity);
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        return this.anim.getVelocityFromNanos(playTimeNanos, obj2, targetValue, initialVelocity);
    }
}
