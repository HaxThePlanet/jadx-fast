package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\"\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000b\"\u0004\u0008\u000f\u0010\rR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b\"\u0004\u0008\u0011\u0010\r¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getFadeOutSpec", "setFadeOutSpec", "getPlacementSpec", "setPlacementSpec", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutAnimationSpecsNode extends Modifier.Node implements ParentDataModifierNode {

    public static final int $stable = 8;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    static {
        final int i = 8;
    }

    public LazyLayoutAnimationSpecsNode(FiniteAnimationSpec<Float> fadeInSpec, FiniteAnimationSpec<IntOffset> placementSpec, FiniteAnimationSpec<Float> fadeOutSpec) {
        super();
        this.fadeInSpec = fadeInSpec;
        this.placementSpec = placementSpec;
        this.fadeOutSpec = fadeOutSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        return this;
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> <set-?>) {
        this.fadeInSpec = <set-?>;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> <set-?>) {
        this.fadeOutSpec = <set-?>;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> <set-?>) {
        this.placementSpec = <set-?>;
    }
}
