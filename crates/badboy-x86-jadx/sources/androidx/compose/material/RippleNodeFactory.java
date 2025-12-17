package androidx.compose.material;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u001f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B\u001f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB)\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00032\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/material/RippleNodeFactory;", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "colorProducer", "Landroidx/compose/ui/graphics/ColorProducer;", "(ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "color", "Landroidx/compose/ui/graphics/Color;", "(ZFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZFLandroidx/compose/ui/graphics/ColorProducer;J)V", "J", "F", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RippleNodeFactory implements IndicationNodeFactory {

    private final boolean bounded;
    private final long color;
    private final ColorProducer colorProducer;
    private final float radius;
    private RippleNodeFactory(boolean bounded, float radius, long color) {
        super(bounded, radius, 0, color, obj5);
    }

    public RippleNodeFactory(boolean z, float f2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(z, f2, l3, defaultConstructorMarker4);
    }

    private RippleNodeFactory(boolean bounded, float radius, ColorProducer colorProducer) {
        super(bounded, radius, colorProducer, Color.Companion.getUnspecified-0d7_KjU(), obj6);
    }

    private RippleNodeFactory(boolean bounded, float radius, ColorProducer colorProducer, long color) {
        super();
        this.bounded = bounded;
        this.radius = radius;
        this.colorProducer = colorProducer;
        this.color = color;
    }

    public RippleNodeFactory(boolean z, float f2, ColorProducer colorProducer3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(z, f2, colorProducer3);
    }

    public static final long access$getColor$p(androidx.compose.material.RippleNodeFactory $this) {
        return $this.color;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource interactionSource) {
        ColorProducer colorProducer;
        if (this.colorProducer == null) {
            colorProducer = new RippleNodeFactory.create.colorProducer.1(this);
        }
        DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode = new DelegatingThemeAwareRippleNode(interactionSource, this.bounded, this.radius, colorProducer, 0);
        return (DelegatableNode)delegatingThemeAwareRippleNode;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (other instanceof RippleNodeFactory == null) {
            return i2;
        }
        if (this.bounded != obj.bounded) {
            return i2;
        }
        if (!Dp.equals-impl0(this.radius, obj2.radius)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.colorProducer, obj3.colorProducer)) {
            return i2;
        }
        return Color.equals-impl0(this.color, i2);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        int i;
        ColorProducer colorProducer = this.colorProducer;
        if (colorProducer != null) {
            i = colorProducer.hashCode();
        } else {
            i = 0;
        }
        return result2 += i8;
    }
}
