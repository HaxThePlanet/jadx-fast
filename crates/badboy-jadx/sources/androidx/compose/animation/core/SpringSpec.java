package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0008\u0008\u0001\u0010\u0016*\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00160\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Landroidx/compose/animation/core/SpringSpec;", "T", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)V", "getDampingRatio", "()F", "getStiffness", "getVisibilityThreshold", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SpringSpec<T>  implements androidx.compose.animation.core.FiniteAnimationSpec<T> {

    public static final int $stable;
    private final float dampingRatio;
    private final float stiffness;
    private final T visibilityThreshold;
    static {
    }

    public SpringSpec() {
        super(0, 0, 0, 7, 0);
    }

    public SpringSpec(float dampingRatio, float stiffness, T visibilityThreshold) {
        super();
        this.dampingRatio = dampingRatio;
        this.stiffness = stiffness;
        this.visibilityThreshold = visibilityThreshold;
    }

    public SpringSpec(float f, float f2, Object object3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        int obj3;
        obj1 = i4 & 1 != 0 ? 1065353216 : obj1;
        obj2 = i4 & 2 != 0 ? 1153138688 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(obj1, obj2, obj3);
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public boolean equals(Object other) {
        int equal;
        int i2;
        int i;
        float visibilityThreshold;
        i2 = 0;
        if (other instanceof SpringSpec) {
            i = 1;
            equal = Float.compare(dampingRatio, dampingRatio2) == 0 ? i : i2;
            if (equal != 0) {
                equal = Float.compare(stiffness, visibilityThreshold) == 0 ? i : i2;
                if (equal != 0 && Intrinsics.areEqual(obj3.visibilityThreshold, this.visibilityThreshold)) {
                    if (Intrinsics.areEqual(obj3.visibilityThreshold, this.visibilityThreshold)) {
                        i2 = i;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public final float getStiffness() {
        return this.stiffness;
    }

    public final T getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public int hashCode() {
        int i;
        Object visibilityThreshold = this.visibilityThreshold;
        if (visibilityThreshold != null) {
            i = visibilityThreshold.hashCode();
        } else {
            i = 0;
        }
        return i4 += i7;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public androidx.compose.animation.core.VectorizedFiniteAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedFiniteAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedSpringSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        VectorizedSpringSpec vectorizedSpringSpec = new VectorizedSpringSpec(this.dampingRatio, this.stiffness, AnimationSpecKt.access$convert(converter, this.visibilityThreshold));
        return vectorizedSpringSpec;
    }
}
