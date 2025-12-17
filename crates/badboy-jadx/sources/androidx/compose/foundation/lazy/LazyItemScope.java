package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@LazyScopeMarker
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008g\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0010\u0008\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00052\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00032\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005H\u0017J\u0016\u0010\u000c\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0003\u0010\r\u001a\u00020\u0006H&J\u0016\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0003\u0010\r\u001a\u00020\u0006H&J\u0016\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0003\u0010\r\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0003", d2 = {"Landroidx/compose/foundation/lazy/LazyItemScope;", "", "animateItem", "Landroidx/compose/ui/Modifier;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "animateItemPlacement", "animationSpec", "fillParentMaxHeight", "fraction", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyItemScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Modifier animateItem(androidx.compose.foundation.lazy.LazyItemScope $this, Modifier $receiver, FiniteAnimationSpec<Float> fadeInSpec, FiniteAnimationSpec<IntOffset> placementSpec, FiniteAnimationSpec<Float> fadeOutSpec) {
            return LazyItemScope.access$animateItem$jd($this, $receiver, fadeInSpec, placementSpec, fadeOutSpec);
        }

        public static Modifier animateItem$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, FiniteAnimationSpec finiteAnimationSpec3, FiniteAnimationSpec finiteAnimationSpec4, FiniteAnimationSpec finiteAnimationSpec5, int i6, Object object7) {
            return LazyItemScope.animateItem$default(lazyItemScope, modifier2, finiteAnimationSpec3, finiteAnimationSpec4, finiteAnimationSpec5, i6, object7);
        }

        @Deprecated
        @Deprecated(message = "Use Modifier.animateItem() instead", replaceWith = @ReplaceWith(...))
        public static Modifier animateItemPlacement(androidx.compose.foundation.lazy.LazyItemScope $this, Modifier $receiver, FiniteAnimationSpec<IntOffset> animationSpec) {
            return LazyItemScope.access$animateItemPlacement$jd($this, $receiver, animationSpec);
        }

        public static Modifier animateItemPlacement$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, FiniteAnimationSpec finiteAnimationSpec3, int i4, Object object5) {
            return LazyItemScope.animateItemPlacement$default(lazyItemScope, modifier2, finiteAnimationSpec3, i4, object5);
        }

        public static Modifier fillParentMaxHeight$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, float f3, int i4, Object object5) {
            return LazyItemScope.fillParentMaxHeight$default(lazyItemScope, modifier2, f3, i4, object5);
        }

        public static Modifier fillParentMaxSize$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, float f3, int i4, Object object5) {
            return LazyItemScope.fillParentMaxSize$default(lazyItemScope, modifier2, f3, i4, object5);
        }

        public static Modifier fillParentMaxWidth$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, float f3, int i4, Object object5) {
            return LazyItemScope.fillParentMaxWidth$default(lazyItemScope, modifier2, f3, i4, object5);
        }
    }
    public static Modifier access$animateItem$jd(androidx.compose.foundation.lazy.LazyItemScope $this, Modifier $receiver, FiniteAnimationSpec fadeInSpec, FiniteAnimationSpec placementSpec, FiniteAnimationSpec fadeOutSpec) {
        return super.animateItem($receiver, fadeInSpec, placementSpec, fadeOutSpec);
    }

    public static Modifier access$animateItemPlacement$jd(androidx.compose.foundation.lazy.LazyItemScope $this, Modifier $receiver, FiniteAnimationSpec animationSpec) {
        return super.animateItemPlacement($receiver, animationSpec);
    }

    public static Modifier animateItem$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, FiniteAnimationSpec finiteAnimationSpec3, FiniteAnimationSpec finiteAnimationSpec4, FiniteAnimationSpec finiteAnimationSpec5, int i6, Object object7) {
        long visibilityThreshold;
        androidx.compose.animation.core.SpringSpec obj8;
        androidx.compose.animation.core.SpringSpec obj9;
        androidx.compose.animation.core.SpringSpec obj10;
        int obj12;
        if (object7 != null) {
        } else {
            final int i = 5;
            final int i2 = 1137180672;
            final int i3 = 0;
            final int i4 = 0;
            if (i6 & 1 != 0) {
                obj8 = AnimationSpecKt.spring$default(i3, i2, i4, i, i4);
            }
            if (i6 & 2 != 0) {
                obj9 = AnimationSpecKt.spring$default(i3, i2, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, i4);
            }
            if (i6 &= 4 != 0) {
                obj10 = AnimationSpecKt.spring$default(i3, i2, i4, i, i4);
            }
            return lazyItemScope.animateItem(modifier2, obj8, obj9, obj10);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItem");
        throw obj6;
    }

    public static Modifier animateItemPlacement$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, FiniteAnimationSpec finiteAnimationSpec3, int i4, Object object5) {
        int i;
        int i2;
        androidx.compose.animation.core.SpringSpec obj4;
        int obj5;
        if (object5 != null) {
        } else {
            final int obj6 = 1;
            i4 &= obj6;
            if (obj5 != null) {
                obj4 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), obj6, 0);
            }
            return lazyItemScope.animateItemPlacement(modifier2, obj4);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
        throw obj2;
    }

    public static Modifier fillParentMaxHeight$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 1065353216;
            }
            return lazyItemScope.fillParentMaxHeight(modifier2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
        throw obj0;
    }

    public static Modifier fillParentMaxSize$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 1065353216;
            }
            return lazyItemScope.fillParentMaxSize(modifier2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxSize");
        throw obj0;
    }

    public static Modifier fillParentMaxWidth$default(androidx.compose.foundation.lazy.LazyItemScope lazyItemScope, Modifier modifier2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 1065353216;
            }
            return lazyItemScope.fillParentMaxWidth(modifier2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
        throw obj0;
    }

    public Modifier animateItem(Modifier $this$animateItem, FiniteAnimationSpec<Float> fadeInSpec, FiniteAnimationSpec<IntOffset> placementSpec, FiniteAnimationSpec<Float> fadeOutSpec) {
        return $this$animateItem;
    }

    @Deprecated(message = "Use Modifier.animateItem() instead", replaceWith = @ReplaceWith(...))
    public Modifier animateItemPlacement(Modifier $this$animateItemPlacement, FiniteAnimationSpec<IntOffset> animationSpec) {
        int i = 0;
        return animateItem($this$animateItemPlacement, i, animationSpec, i);
    }

    public abstract Modifier fillParentMaxHeight(Modifier modifier, float f2);

    public abstract Modifier fillParentMaxSize(Modifier modifier, float f2);

    public abstract Modifier fillParentMaxWidth(Modifier modifier, float f2);
}
