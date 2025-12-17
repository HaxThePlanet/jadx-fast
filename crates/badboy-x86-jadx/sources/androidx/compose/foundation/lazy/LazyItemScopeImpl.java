package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ<\u0010\u000b\u001a\u00020\u000c*\u00020\u000c2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0014\u0010\u0013\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0014\u0010\u0016\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "()V", "maxHeightState", "Landroidx/compose/runtime/MutableIntState;", "maxWidthState", "setMaxSize", "", "width", "", "height", "animateItem", "Landroidx/compose/ui/Modifier;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "fillParentMaxHeight", "fraction", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyItemScopeImpl implements androidx.compose.foundation.lazy.LazyItemScope {

    public static final int $stable;
    private MutableIntState maxHeightState;
    private MutableIntState maxWidthState;
    static {
    }

    public LazyItemScopeImpl() {
        super();
        int i = Integer.MAX_VALUE;
        this.maxWidthState = SnapshotIntStateKt.mutableIntStateOf(i);
        this.maxHeightState = SnapshotIntStateKt.mutableIntStateOf(i);
    }

    public Modifier animateItem(Modifier $this$animateItem, FiniteAnimationSpec<Float> fadeInSpec, FiniteAnimationSpec<IntOffset> placementSpec, FiniteAnimationSpec<Float> fadeOutSpec) {
        Modifier then;
        if (fadeInSpec == null && placementSpec == null && fadeOutSpec == null) {
            if (placementSpec == null) {
                if (fadeOutSpec == null) {
                    then = $this$animateItem;
                } else {
                    LazyLayoutAnimateItemElement lazyLayoutAnimateItemElement = new LazyLayoutAnimateItemElement(fadeInSpec, placementSpec, fadeOutSpec);
                    then = $this$animateItem.then((Modifier)lazyLayoutAnimateItemElement);
                }
            } else {
            }
        } else {
        }
        return then;
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxHeight(Modifier $this$fillParentMaxHeight, float fraction) {
        ParentSizeElement parentSizeElement = new ParentSizeElement(fraction, 0, (State)this.maxHeightState, "fillParentMaxHeight", 2, 0);
        return $this$fillParentMaxHeight.then((Modifier)parentSizeElement);
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxSize(Modifier $this$fillParentMaxSize, float fraction) {
        ParentSizeElement parentSizeElement = new ParentSizeElement(fraction, (State)this.maxWidthState, (State)this.maxHeightState, "fillParentMaxSize");
        return $this$fillParentMaxSize.then((Modifier)parentSizeElement);
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxWidth(Modifier $this$fillParentMaxWidth, float fraction) {
        ParentSizeElement parentSizeElement = new ParentSizeElement(fraction, (State)this.maxWidthState, 0, "fillParentMaxWidth", 4, 0);
        return $this$fillParentMaxWidth.then((Modifier)parentSizeElement);
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public final void setMaxSize(int width, int height) {
        this.maxWidthState.setIntValue(width);
        this.maxHeightState.setIntValue(height);
    }
}
