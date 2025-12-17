package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "()V", "animateItem", "Landroidx/compose/ui/Modifier;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridItemScopeImpl implements androidx.compose.foundation.lazy.grid.LazyGridItemScope {

    public static final int $stable;
    public static final androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl INSTANCE;
    static {
        LazyGridItemScopeImpl lazyGridItemScopeImpl = new LazyGridItemScopeImpl();
        LazyGridItemScopeImpl.INSTANCE = lazyGridItemScopeImpl;
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
}
