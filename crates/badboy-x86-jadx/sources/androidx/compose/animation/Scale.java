package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/animation/Scale;", "", "scale", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getScale", "()F", "getTransformOrigin-SzJe1aQ", "()J", "J", "component1", "component2", "component2-SzJe1aQ", "component3", "copy", "copy-bnNdC4k", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;)Landroidx/compose/animation/Scale;", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Scale {

    public static final int $stable;
    private final FiniteAnimationSpec<Float> animationSpec;
    private final float scale;
    private final long transformOrigin;
    static {
    }

    private Scale(float scale, long transformOrigin, FiniteAnimationSpec<Float> animationSpec) {
        super();
        this.scale = scale;
        this.transformOrigin = transformOrigin;
        this.animationSpec = obj4;
    }

    public Scale(float f, long l2, FiniteAnimationSpec finiteAnimationSpec3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(f, l2, finiteAnimationSpec3, defaultConstructorMarker4);
    }

    public static androidx.compose.animation.Scale copy-bnNdC4k$default(androidx.compose.animation.Scale scale, float f2, long l3, FiniteAnimationSpec finiteAnimationSpec4, int i5, Object object6) {
        float obj1;
        long obj2;
        FiniteAnimationSpec obj4;
        if (object6 & 1 != 0) {
            obj1 = scale.scale;
        }
        if (object6 & 2 != 0) {
            obj2 = scale.transformOrigin;
        }
        if (object6 &= 4 != 0) {
            obj4 = scale.animationSpec;
        }
        return scale.copy-bnNdC4k(obj1, obj2, finiteAnimationSpec4);
    }

    public final float component1() {
        return this.scale;
    }

    public final long component2-SzJe1aQ() {
        return this.transformOrigin;
    }

    public final FiniteAnimationSpec<Float> component3() {
        return this.animationSpec;
    }

    public final androidx.compose.animation.Scale copy-bnNdC4k(float f, long l2, FiniteAnimationSpec<Float> finiteAnimationSpec3) {
        Scale scale = new Scale(f, l2, obj3, obj10, 0);
        return scale;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Scale) {
            return i2;
        }
        Object obj = object;
        final float scale2 = obj.scale;
        if (Float.compare(this.scale, scale2) != 0) {
            return i2;
        }
        if (!TransformOrigin.equals-impl0(this.transformOrigin, scale2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.animationSpec, obj.animationSpec)) {
            return i2;
        }
        return i;
    }

    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final float getScale() {
        return this.scale;
    }

    public final long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    public int hashCode() {
        return i2 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Scale(scale=").append(this.scale).append(", transformOrigin=").append(TransformOrigin.toString-impl(this.transformOrigin)).append(", animationSpec=").append(this.animationSpec).append(')').toString();
    }
}
