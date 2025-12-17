package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u001b\u0010\n\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a#\u0010\u000e\u001a\u00020\u000f\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000b2\u0006\u0010\u0010\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u0012\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r¨\u0006\u0013", d2 = {"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "copy", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "newInstance", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationVectorsKt {
    public static final androidx.compose.animation.core.AnimationVector1D AnimationVector(float v1) {
        AnimationVector1D animationVector1D = new AnimationVector1D(v1);
        return animationVector1D;
    }

    public static final androidx.compose.animation.core.AnimationVector2D AnimationVector(float v1, float v2) {
        AnimationVector2D animationVector2D = new AnimationVector2D(v1, v2);
        return animationVector2D;
    }

    public static final androidx.compose.animation.core.AnimationVector3D AnimationVector(float v1, float v2, float v3) {
        AnimationVector3D animationVector3D = new AnimationVector3D(v1, v2, v3);
        return animationVector3D;
    }

    public static final androidx.compose.animation.core.AnimationVector4D AnimationVector(float v1, float v2, float v3, float v4) {
        AnimationVector4D animationVector4D = new AnimationVector4D(v1, v2, v3, v4);
        return animationVector4D;
    }

    public static final <T extends androidx.compose.animation.core.AnimationVector> T copy(T $this$copy) {
        int i;
        float f;
        final androidx.compose.animation.core.AnimationVector instance = AnimationVectorsKt.newInstance($this$copy);
        i = 0;
        while (i < instance.getSize$animation_core_release()) {
            instance.set$animation_core_release(i, $this$copy.get$animation_core_release(i));
            i++;
        }
        return instance;
    }

    public static final <T extends androidx.compose.animation.core.AnimationVector> void copyFrom(T $this$copyFrom, T source) {
        int i;
        float f;
        i = 0;
        while (i < $this$copyFrom.getSize$animation_core_release()) {
            $this$copyFrom.set$animation_core_release(i, source.get$animation_core_release(i));
            i++;
        }
    }

    public static final <T extends androidx.compose.animation.core.AnimationVector> T newInstance(T $this$newInstance) {
        final androidx.compose.animation.core.AnimationVector vector$animation_core_release = $this$newInstance.newVector$animation_core_release();
        Intrinsics.checkNotNull(vector$animation_core_release, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return vector$animation_core_release;
    }
}
