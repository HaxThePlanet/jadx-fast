package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001B6\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\n¢\u0006\u0002\u0010\u000bJ$\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\nHÆ\u0003J>\u0010\u0012\u001a\u00020\u00002#\u0008\u0002\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00032\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\nHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001a", d2 = {"Landroidx/compose/animation/Slide;", "", "slideOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "Landroidx/compose/ui/unit/IntOffset;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getSlideOffset", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Slide {

    public static final int $stable;
    private final FiniteAnimationSpec<IntOffset> animationSpec;
    private final Function1<IntSize, IntOffset> slideOffset;
    static {
    }

    public Slide(Function1<? super IntSize, IntOffset> slideOffset, FiniteAnimationSpec<IntOffset> animationSpec) {
        super();
        this.slideOffset = slideOffset;
        this.animationSpec = animationSpec;
    }

    public static androidx.compose.animation.Slide copy$default(androidx.compose.animation.Slide slide, Function1 function12, FiniteAnimationSpec finiteAnimationSpec3, int i4, Object object5) {
        Function1 obj1;
        FiniteAnimationSpec obj2;
        if (i4 & 1 != 0) {
            obj1 = slide.slideOffset;
        }
        if (i4 &= 2 != 0) {
            obj2 = slide.animationSpec;
        }
        return slide.copy(obj1, obj2);
    }

    public final Function1<IntSize, IntOffset> component1() {
        return this.slideOffset;
    }

    public final FiniteAnimationSpec<IntOffset> component2() {
        return this.animationSpec;
    }

    public final androidx.compose.animation.Slide copy(Function1<? super IntSize, IntOffset> function1, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2) {
        Slide slide = new Slide(function1, finiteAnimationSpec2);
        return slide;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Slide) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.slideOffset, obj.slideOffset)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.animationSpec, obj.animationSpec)) {
            return i2;
        }
        return i;
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1<IntSize, IntOffset> getSlideOffset() {
        return this.slideOffset;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Slide(slideOffset=").append(this.slideOffset).append(", animationSpec=").append(this.animationSpec).append(')').toString();
    }
}
