package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u000fJ\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u000c\u0010$\u001a\u00020\"*\u00020%H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/foundation/BorderModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BorderModifierNode;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getWidth-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/foundation/BorderModifierNodeElement;", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BorderModifierNodeElement extends ModifierNodeElement<androidx.compose.foundation.BorderModifierNode> {

    public static final int $stable;
    private final Brush brush;
    private final Shape shape;
    private final float width;
    static {
    }

    private BorderModifierNodeElement(float width, Brush brush, Shape shape) {
        super();
        this.width = width;
        this.brush = brush;
        this.shape = shape;
    }

    public BorderModifierNodeElement(float f, Brush brush2, Shape shape3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(f, brush2, shape3);
    }

    public static androidx.compose.foundation.BorderModifierNodeElement copy-8Feqmps$default(androidx.compose.foundation.BorderModifierNodeElement borderModifierNodeElement, float f2, Brush brush3, Shape shape4, int i5, Object object6) {
        float obj1;
        Brush obj2;
        Shape obj3;
        if (i5 & 1 != 0) {
            obj1 = borderModifierNodeElement.width;
        }
        if (i5 & 2 != 0) {
            obj2 = borderModifierNodeElement.brush;
        }
        if (i5 &= 4 != 0) {
            obj3 = borderModifierNodeElement.shape;
        }
        return borderModifierNodeElement.copy-8Feqmps(obj1, obj2, obj3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component1-D9Ej5fM() {
        return this.width;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Brush component2() {
        return this.brush;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Shape component3() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.BorderModifierNodeElement copy-8Feqmps(float f, Brush brush2, Shape shape3) {
        BorderModifierNodeElement borderModifierNodeElement = new BorderModifierNodeElement(f, brush2, shape3, 0);
        return borderModifierNodeElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.BorderModifierNode create() {
        BorderModifierNode borderModifierNode = new BorderModifierNode(this.width, this.brush, this.shape, 0);
        return borderModifierNode;
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
        if (!object instanceof BorderModifierNodeElement) {
            return i2;
        }
        Object obj = object;
        if (!Dp.equals-impl0(this.width, obj.width)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.brush, obj.brush)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.shape, obj.shape)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Object properties;
        Object box-impl;
        Object brush;
        $this$inspectableProperties.setName("border");
        String str3 = "width";
        $this$inspectableProperties.getProperties().set(str3, Dp.box-impl(this.width));
        if (brush2 instanceof SolidColor) {
            box-impl = Color.box-impl((SolidColor)this.brush.getValue-0d7_KjU());
            $this$inspectableProperties.getProperties().set("color", box-impl);
            $this$inspectableProperties.setValue(Color.box-impl((SolidColor)this.brush.getValue-0d7_KjU()));
        } else {
            $this$inspectableProperties.getProperties().set("brush", this.brush);
        }
        $this$inspectableProperties.getProperties().set("shape", this.shape);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BorderModifierNodeElement(width=").append(Dp.toString-impl(this.width)).append(", brush=").append(this.brush).append(", shape=").append(this.shape).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.BorderModifierNode node) {
        node.setWidth-0680j_4(this.width);
        node.setBrush(this.brush);
        node.setShape(this.shape);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((BorderModifierNode)node);
    }
}
