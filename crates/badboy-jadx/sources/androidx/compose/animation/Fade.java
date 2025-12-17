package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Landroidx/compose/animation/Fade;", "", "alpha", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(FLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAlpha", "()F", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Fade {

    public static final int $stable;
    private final float alpha;
    private final FiniteAnimationSpec<Float> animationSpec;
    static {
    }

    public Fade(float alpha, FiniteAnimationSpec<Float> animationSpec) {
        super();
        this.alpha = alpha;
        this.animationSpec = animationSpec;
    }

    public static androidx.compose.animation.Fade copy$default(androidx.compose.animation.Fade fade, float f2, FiniteAnimationSpec finiteAnimationSpec3, int i4, Object object5) {
        float obj1;
        FiniteAnimationSpec obj2;
        if (i4 & 1 != 0) {
            obj1 = fade.alpha;
        }
        if (i4 &= 2 != 0) {
            obj2 = fade.animationSpec;
        }
        return fade.copy(obj1, obj2);
    }

    public final float component1() {
        return this.alpha;
    }

    public final FiniteAnimationSpec<Float> component2() {
        return this.animationSpec;
    }

    public final androidx.compose.animation.Fade copy(float f, FiniteAnimationSpec<Float> finiteAnimationSpec2) {
        Fade fade = new Fade(f, finiteAnimationSpec2);
        return fade;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Fade) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.alpha, obj.alpha) != 0) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.animationSpec, obj.animationSpec)) {
            return i2;
        }
        return i;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Fade(alpha=").append(this.alpha).append(", animationSpec=").append(this.animationSpec).append(')').toString();
    }
}
