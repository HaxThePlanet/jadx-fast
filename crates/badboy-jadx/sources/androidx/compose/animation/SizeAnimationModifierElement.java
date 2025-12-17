package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00128\u0010\u0008\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J_\u0010\u0019\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072:\u0008\u0002\u0010\u0008\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0001J\u0008\u0010\u001a\u001a\u00020\u0002H\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0002H\u0016J\u000c\u0010%\u001a\u00020\u000e*\u00020&H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013RC\u0010\u0008\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006'", d2 = {"Landroidx/compose/animation/SizeAnimationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SizeAnimationModifierNode;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "alignment", "Landroidx/compose/ui/Alignment;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getFinishedListener", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SizeAnimationModifierElement extends ModifierNodeElement<androidx.compose.animation.SizeAnimationModifierNode> {

    private final Alignment alignment;
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final Function2<IntSize, IntSize, Unit> finishedListener;
    public SizeAnimationModifierElement(FiniteAnimationSpec<IntSize> animationSpec, Alignment alignment, Function2<? super IntSize, ? super IntSize, Unit> finishedListener) {
        super();
        this.animationSpec = animationSpec;
        this.alignment = alignment;
        this.finishedListener = finishedListener;
    }

    public static androidx.compose.animation.SizeAnimationModifierElement copy$default(androidx.compose.animation.SizeAnimationModifierElement sizeAnimationModifierElement, FiniteAnimationSpec finiteAnimationSpec2, Alignment alignment3, Function2 function24, int i5, Object object6) {
        FiniteAnimationSpec obj1;
        Alignment obj2;
        Function2 obj3;
        if (i5 & 1 != 0) {
            obj1 = sizeAnimationModifierElement.animationSpec;
        }
        if (i5 & 2 != 0) {
            obj2 = sizeAnimationModifierElement.alignment;
        }
        if (i5 &= 4 != 0) {
            obj3 = sizeAnimationModifierElement.finishedListener;
        }
        return sizeAnimationModifierElement.copy(obj1, obj2, obj3);
    }

    public final FiniteAnimationSpec<IntSize> component1() {
        return this.animationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Alignment component2() {
        return this.alignment;
    }

    public final Function2<IntSize, IntSize, Unit> component3() {
        return this.finishedListener;
    }

    public final androidx.compose.animation.SizeAnimationModifierElement copy(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment2, Function2<? super IntSize, ? super IntSize, Unit> function23) {
        SizeAnimationModifierElement sizeAnimationModifierElement = new SizeAnimationModifierElement(finiteAnimationSpec, alignment2, function23);
        return sizeAnimationModifierElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.animation.SizeAnimationModifierNode create() {
        SizeAnimationModifierNode sizeAnimationModifierNode = new SizeAnimationModifierNode((AnimationSpec)this.animationSpec, this.alignment, this.finishedListener);
        return sizeAnimationModifierNode;
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
        if (!object instanceof SizeAnimationModifierElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.animationSpec, obj.animationSpec)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.finishedListener, obj.finishedListener)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function2<IntSize, IntSize, Unit> getFinishedListener() {
        return this.finishedListener;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.finishedListener == null) {
            i = 0;
        } else {
            i = this.finishedListener.hashCode();
        }
        return i3 += i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("animateContentSize");
        $this$inspectableProperties.getProperties().set("animationSpec", this.animationSpec);
        $this$inspectableProperties.getProperties().set("alignment", this.alignment);
        $this$inspectableProperties.getProperties().set("finishedListener", this.finishedListener);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SizeAnimationModifierElement(animationSpec=").append(this.animationSpec).append(", alignment=").append(this.alignment).append(", finishedListener=").append(this.finishedListener).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.animation.SizeAnimationModifierNode node) {
        node.setAnimationSpec((AnimationSpec)this.animationSpec);
        node.setListener(this.finishedListener);
        node.setAlignment(this.alignment);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SizeAnimationModifierNode)node);
    }
}
