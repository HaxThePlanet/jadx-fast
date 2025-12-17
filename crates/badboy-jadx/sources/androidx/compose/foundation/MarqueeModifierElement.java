package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0010\u001a\u00020\u0004HÂ\u0003J\u0016\u0010\u0011\u001a\u00020\u0006HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\nHÂ\u0003J\u0016\u0010\u0017\u001a\u00020\u000cHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019JO\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0008\u0010\u001d\u001a\u00020\u0002H\u0016J\u0013\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0002H\u0016J\u000c\u0010(\u001a\u00020&*\u00020)H\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u000cX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006*", d2 = {"Landroidx/compose/foundation/MarqueeModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MarqueeModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "F", "component1", "component2", "component2-ZbEOnfQ", "()I", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "()F", "copy", "copy-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/foundation/MarqueeModifierElement;", "create", "equals", "", "other", "", "hashCode", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MarqueeModifierElement extends ModifierNodeElement<androidx.compose.foundation.MarqueeModifierNode> {

    private final int animationMode;
    private final int delayMillis;
    private final int initialDelayMillis;
    private final int iterations;
    private final androidx.compose.foundation.MarqueeSpacing spacing;
    private final float velocity;
    private MarqueeModifierElement(int iterations, int animationMode, int delayMillis, int initialDelayMillis, androidx.compose.foundation.MarqueeSpacing spacing, float velocity) {
        super();
        this.iterations = iterations;
        this.animationMode = animationMode;
        this.delayMillis = delayMillis;
        this.initialDelayMillis = initialDelayMillis;
        this.spacing = spacing;
        this.velocity = velocity;
    }

    public MarqueeModifierElement(int i, int i2, int i3, int i4, androidx.compose.foundation.MarqueeSpacing marqueeSpacing5, float f6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(i, i2, i3, i4, marqueeSpacing5, f6);
    }

    private final int component1() {
        return this.iterations;
    }

    private final int component2-ZbEOnfQ() {
        return this.animationMode;
    }

    private final int component3() {
        return this.delayMillis;
    }

    private final int component4() {
        return this.initialDelayMillis;
    }

    private final androidx.compose.foundation.MarqueeSpacing component5() {
        return this.spacing;
    }

    private final float component6-D9Ej5fM() {
        return this.velocity;
    }

    public static androidx.compose.foundation.MarqueeModifierElement copy-lWfNwf4$default(androidx.compose.foundation.MarqueeModifierElement marqueeModifierElement, int i2, int i3, int i4, int i5, androidx.compose.foundation.MarqueeSpacing marqueeSpacing6, float f7, int i8, Object object9) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        androidx.compose.foundation.MarqueeSpacing obj5;
        float obj6;
        if (i8 & 1 != 0) {
            obj1 = marqueeModifierElement.iterations;
        }
        if (i8 & 2 != 0) {
            obj2 = marqueeModifierElement.animationMode;
        }
        if (i8 & 4 != 0) {
            obj3 = marqueeModifierElement.delayMillis;
        }
        if (i8 & 8 != 0) {
            obj4 = marqueeModifierElement.initialDelayMillis;
        }
        if (i8 & 16 != 0) {
            obj5 = marqueeModifierElement.spacing;
        }
        if (i8 &= 32 != 0) {
            obj6 = marqueeModifierElement.velocity;
        }
        return marqueeModifierElement.copy-lWfNwf4(obj1, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.MarqueeModifierElement copy-lWfNwf4(int i, int i2, int i3, int i4, androidx.compose.foundation.MarqueeSpacing marqueeSpacing5, float f6) {
        MarqueeModifierElement marqueeModifierElement = new MarqueeModifierElement(i, i2, i3, i4, marqueeSpacing5, f6, 0);
        return marqueeModifierElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.MarqueeModifierNode create() {
        MarqueeModifierNode marqueeModifierNode = new MarqueeModifierNode(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity, 0);
        return marqueeModifierNode;
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
        if (!object instanceof MarqueeModifierElement) {
            return i2;
        }
        Object obj = object;
        if (this.iterations != obj.iterations) {
            return i2;
        }
        if (!MarqueeAnimationMode.equals-impl0(this.animationMode, obj.animationMode)) {
            return i2;
        }
        if (this.delayMillis != obj.delayMillis) {
            return i2;
        }
        if (this.initialDelayMillis != obj.initialDelayMillis) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.spacing, obj.spacing)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.velocity, obj.velocity)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i10 += i16;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("basicMarquee");
        $this$inspectableProperties.getProperties().set("iterations", Integer.valueOf(this.iterations));
        $this$inspectableProperties.getProperties().set("animationMode", MarqueeAnimationMode.box-impl(this.animationMode));
        $this$inspectableProperties.getProperties().set("delayMillis", Integer.valueOf(this.delayMillis));
        $this$inspectableProperties.getProperties().set("initialDelayMillis", Integer.valueOf(this.initialDelayMillis));
        $this$inspectableProperties.getProperties().set("spacing", this.spacing);
        $this$inspectableProperties.getProperties().set("velocity", Dp.box-impl(this.velocity));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MarqueeModifierElement(iterations=").append(this.iterations).append(", animationMode=").append(MarqueeAnimationMode.toString-impl(this.animationMode)).append(", delayMillis=").append(this.delayMillis).append(", initialDelayMillis=").append(this.initialDelayMillis).append(", spacing=").append(this.spacing).append(", velocity=").append(Dp.toString-impl(this.velocity)).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.MarqueeModifierNode node) {
        node.update-lWfNwf4(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((MarqueeModifierNode)node);
    }
}
