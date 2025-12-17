package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0003", d2 = {"Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "isInfinite", "", "()Z", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VectorizedFiniteAnimationSpec<V extends androidx.compose.animation.core.AnimationVector>  extends androidx.compose.animation.core.VectorizedAnimationSpec<V> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends androidx.compose.animation.core.AnimationVector> V getEndVelocity(androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> $this, V initialValue, V targetValue, V initialVelocity) {
            return VectorizedFiniteAnimationSpec.access$getEndVelocity$jd($this, initialValue, targetValue, initialVelocity);
        }

        @Deprecated
        public static <V extends androidx.compose.animation.core.AnimationVector> boolean isInfinite(androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> $this) {
            return VectorizedFiniteAnimationSpec.access$isInfinite$jd($this);
        }
    }
    public static androidx.compose.animation.core.AnimationVector access$getEndVelocity$jd(androidx.compose.animation.core.VectorizedFiniteAnimationSpec $this, androidx.compose.animation.core.AnimationVector initialValue, androidx.compose.animation.core.AnimationVector targetValue, androidx.compose.animation.core.AnimationVector initialVelocity) {
        return super.getEndVelocity(initialValue, targetValue, initialVelocity);
    }

    public static boolean access$isInfinite$jd(androidx.compose.animation.core.VectorizedFiniteAnimationSpec $this) {
        return super.isInfinite();
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return 0;
    }
}
