package androidx.compose.animation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00072\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u000c\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Landroidx/compose/animation/SkipToLookaheadElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SkipToLookaheadNode;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SkipToLookaheadElement extends ModifierNodeElement<androidx.compose.animation.SkipToLookaheadNode> {

    private final Function0<Boolean> isEnabled;
    private final androidx.compose.animation.ScaleToBoundsImpl scaleToBounds;
    public SkipToLookaheadElement() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public SkipToLookaheadElement(androidx.compose.animation.ScaleToBoundsImpl scaleToBounds, Function0<Boolean> isEnabled) {
        super();
        this.scaleToBounds = scaleToBounds;
        this.isEnabled = isEnabled;
    }

    public SkipToLookaheadElement(androidx.compose.animation.ScaleToBoundsImpl scaleToBoundsImpl, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        Function0 obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        if (i3 &= 2 != 0) {
            obj2 = SharedTransitionScopeKt.access$getDefaultEnabled$p();
        }
        super(obj1, obj2);
    }

    public static androidx.compose.animation.SkipToLookaheadElement copy$default(androidx.compose.animation.SkipToLookaheadElement skipToLookaheadElement, androidx.compose.animation.ScaleToBoundsImpl scaleToBoundsImpl2, Function0 function03, int i4, Object object5) {
        androidx.compose.animation.ScaleToBoundsImpl obj1;
        Function0 obj2;
        if (i4 & 1 != 0) {
            obj1 = skipToLookaheadElement.scaleToBounds;
        }
        if (i4 &= 2 != 0) {
            obj2 = skipToLookaheadElement.isEnabled;
        }
        return skipToLookaheadElement.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.ScaleToBoundsImpl component1() {
        return this.scaleToBounds;
    }

    public final Function0<Boolean> component2() {
        return this.isEnabled;
    }

    public final androidx.compose.animation.SkipToLookaheadElement copy(androidx.compose.animation.ScaleToBoundsImpl scaleToBoundsImpl, Function0<Boolean> function02) {
        SkipToLookaheadElement skipToLookaheadElement = new SkipToLookaheadElement(scaleToBoundsImpl, function02);
        return skipToLookaheadElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.animation.SkipToLookaheadNode create() {
        SkipToLookaheadNode skipToLookaheadNode = new SkipToLookaheadNode(this.scaleToBounds, this.isEnabled);
        return skipToLookaheadNode;
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
        if (!object instanceof SkipToLookaheadElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.scaleToBounds, obj.scaleToBounds)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.isEnabled, obj.isEnabled)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.scaleToBounds == null) {
            i = 0;
        } else {
            i = this.scaleToBounds.hashCode();
        }
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("skipToLookahead");
        $this$inspectableProperties.getProperties().set("scaleToBounds", this.scaleToBounds);
        $this$inspectableProperties.getProperties().set("isEnabled", this.isEnabled);
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SkipToLookaheadElement(scaleToBounds=").append(this.scaleToBounds).append(", isEnabled=").append(this.isEnabled).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.animation.SkipToLookaheadNode node) {
        node.setScaleToBounds(this.scaleToBounds);
        node.setEnabled(this.isEnabled);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SkipToLookaheadNode)node);
    }
}
