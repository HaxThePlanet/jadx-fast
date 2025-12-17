package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÂ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÂ\u0003J\u0011\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÂ\u0003J?\u0010\r\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0008\u0010\u000e\u001a\u00020\u0002H\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u000c\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "component1", "component2", "component3", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutAnimateItemElement extends ModifierNodeElement<androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode> {

    public static final int $stable;
    private final FiniteAnimationSpec<Float> fadeInSpec;
    private final FiniteAnimationSpec<Float> fadeOutSpec;
    private final FiniteAnimationSpec<IntOffset> placementSpec;
    static {
    }

    public LazyLayoutAnimateItemElement(FiniteAnimationSpec<Float> fadeInSpec, FiniteAnimationSpec<IntOffset> placementSpec, FiniteAnimationSpec<Float> fadeOutSpec) {
        super();
        this.fadeInSpec = fadeInSpec;
        this.placementSpec = placementSpec;
        this.fadeOutSpec = fadeOutSpec;
    }

    private final FiniteAnimationSpec<Float> component1() {
        return this.fadeInSpec;
    }

    private final FiniteAnimationSpec<IntOffset> component2() {
        return this.placementSpec;
    }

    private final FiniteAnimationSpec<Float> component3() {
        return this.fadeOutSpec;
    }

    public static androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement copy$default(androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement lazyLayoutAnimateItemElement, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3, FiniteAnimationSpec finiteAnimationSpec4, int i5, Object object6) {
        FiniteAnimationSpec obj1;
        FiniteAnimationSpec obj2;
        FiniteAnimationSpec obj3;
        if (i5 & 1 != 0) {
            obj1 = lazyLayoutAnimateItemElement.fadeInSpec;
        }
        if (i5 & 2 != 0) {
            obj2 = lazyLayoutAnimateItemElement.placementSpec;
        }
        if (i5 &= 4 != 0) {
            obj3 = lazyLayoutAnimateItemElement.fadeOutSpec;
        }
        return lazyLayoutAnimateItemElement.copy(obj1, obj2, obj3);
    }

    public final androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement copy(FiniteAnimationSpec<Float> finiteAnimationSpec, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2, FiniteAnimationSpec<Float> finiteAnimationSpec3) {
        LazyLayoutAnimateItemElement lazyLayoutAnimateItemElement = new LazyLayoutAnimateItemElement(finiteAnimationSpec, finiteAnimationSpec2, finiteAnimationSpec3);
        return lazyLayoutAnimateItemElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode create() {
        LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNode = new LazyLayoutAnimationSpecsNode(this.fadeInSpec, this.placementSpec, this.fadeOutSpec);
        return lazyLayoutAnimationSpecsNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LazyLayoutAnimateItemElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.fadeInSpec, obj.fadeInSpec)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.placementSpec, obj.placementSpec)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fadeOutSpec, obj.fadeOutSpec)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        int i2;
        int i3;
        i2 = 0;
        if (this.fadeInSpec == null) {
            i = i2;
        } else {
            i = this.fadeInSpec.hashCode();
        }
        if (this.placementSpec == null) {
            i3 = i2;
        } else {
            i3 = this.placementSpec.hashCode();
        }
        if (this.fadeOutSpec == null) {
        } else {
            i2 = this.fadeOutSpec.hashCode();
        }
        return i4 += i2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("animateItem");
        $this$inspectableProperties.getProperties().set("fadeInSpec", this.fadeInSpec);
        $this$inspectableProperties.getProperties().set("placementSpec", this.placementSpec);
        $this$inspectableProperties.getProperties().set("fadeOutSpec", this.fadeOutSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LazyLayoutAnimateItemElement(fadeInSpec=").append(this.fadeInSpec).append(", placementSpec=").append(this.placementSpec).append(", fadeOutSpec=").append(this.fadeOutSpec).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode node) {
        node.setFadeInSpec(this.fadeInSpec);
        node.setPlacementSpec(this.placementSpec);
        node.setFadeOutSpec(this.fadeOutSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((LazyLayoutAnimationSpecsNode)node);
    }
}
