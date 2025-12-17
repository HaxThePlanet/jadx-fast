package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u001a$\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"negativeInfinityBounds1D", "Landroidx/compose/animation/core/AnimationVector1D;", "negativeInfinityBounds2D", "Landroidx/compose/animation/core/AnimationVector2D;", "negativeInfinityBounds3D", "Landroidx/compose/animation/core/AnimationVector3D;", "negativeInfinityBounds4D", "Landroidx/compose/animation/core/AnimationVector4D;", "positiveInfinityBounds1D", "positiveInfinityBounds2D", "positiveInfinityBounds3D", "positiveInfinityBounds4D", "Animatable", "Landroidx/compose/animation/core/Animatable;", "", "initialValue", "visibilityThreshold", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatableKt {

    private static final androidx.compose.animation.core.AnimationVector1D negativeInfinityBounds1D;
    private static final androidx.compose.animation.core.AnimationVector2D negativeInfinityBounds2D;
    private static final androidx.compose.animation.core.AnimationVector3D negativeInfinityBounds3D;
    private static final androidx.compose.animation.core.AnimationVector4D negativeInfinityBounds4D;
    private static final androidx.compose.animation.core.AnimationVector1D positiveInfinityBounds1D;
    private static final androidx.compose.animation.core.AnimationVector2D positiveInfinityBounds2D;
    private static final androidx.compose.animation.core.AnimationVector3D positiveInfinityBounds3D;
    private static final androidx.compose.animation.core.AnimationVector4D positiveInfinityBounds4D;
    static {
        int i = 2139095040;
        AnimatableKt.positiveInfinityBounds1D = AnimationVectorsKt.AnimationVector(i);
        AnimatableKt.positiveInfinityBounds2D = AnimationVectorsKt.AnimationVector(i, i);
        AnimatableKt.positiveInfinityBounds3D = AnimationVectorsKt.AnimationVector(i, i, i);
        AnimatableKt.positiveInfinityBounds4D = AnimationVectorsKt.AnimationVector(i, i, i, i);
        int i2 = -8388608;
        AnimatableKt.negativeInfinityBounds1D = AnimationVectorsKt.AnimationVector(i2);
        AnimatableKt.negativeInfinityBounds2D = AnimationVectorsKt.AnimationVector(i2, i2);
        AnimatableKt.negativeInfinityBounds3D = AnimationVectorsKt.AnimationVector(i2, i2, i2);
        AnimatableKt.negativeInfinityBounds4D = AnimationVectorsKt.AnimationVector(i2, i2, i2, i2);
    }

    public static final androidx.compose.animation.core.Animatable<Float, androidx.compose.animation.core.AnimationVector1D> Animatable(float initialValue, float visibilityThreshold) {
        Animatable animatable = new Animatable(Float.valueOf(initialValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(visibilityThreshold), 0, 8, 0);
        return animatable;
    }

    public static androidx.compose.animation.core.Animatable Animatable$default(float f, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 1008981770;
        }
        return AnimatableKt.Animatable(f, obj1);
    }

    public static final androidx.compose.animation.core.AnimationVector1D access$getNegativeInfinityBounds1D$p() {
        return AnimatableKt.negativeInfinityBounds1D;
    }

    public static final androidx.compose.animation.core.AnimationVector2D access$getNegativeInfinityBounds2D$p() {
        return AnimatableKt.negativeInfinityBounds2D;
    }

    public static final androidx.compose.animation.core.AnimationVector3D access$getNegativeInfinityBounds3D$p() {
        return AnimatableKt.negativeInfinityBounds3D;
    }

    public static final androidx.compose.animation.core.AnimationVector4D access$getNegativeInfinityBounds4D$p() {
        return AnimatableKt.negativeInfinityBounds4D;
    }

    public static final androidx.compose.animation.core.AnimationVector1D access$getPositiveInfinityBounds1D$p() {
        return AnimatableKt.positiveInfinityBounds1D;
    }

    public static final androidx.compose.animation.core.AnimationVector2D access$getPositiveInfinityBounds2D$p() {
        return AnimatableKt.positiveInfinityBounds2D;
    }

    public static final androidx.compose.animation.core.AnimationVector3D access$getPositiveInfinityBounds3D$p() {
        return AnimatableKt.positiveInfinityBounds3D;
    }

    public static final androidx.compose.animation.core.AnimationVector4D access$getPositiveInfinityBounds4D$p() {
        return AnimatableKt.positiveInfinityBounds4D;
    }
}
