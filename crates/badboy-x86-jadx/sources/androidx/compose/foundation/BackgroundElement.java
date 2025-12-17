package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BD\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0002\u0008\u000f¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u000c\u0010\u001b\u001a\u00020\u000e*\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0002\u0008\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BackgroundNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BackgroundElement extends ModifierNodeElement<androidx.compose.foundation.BackgroundNode> {

    private final float alpha;
    private final Brush brush;
    private final long color;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final Shape shape;
    private BackgroundElement(long color, Brush brush, float alpha, Shape shape, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super();
        this.color = color;
        this.brush = alpha;
        this.alpha = shape;
        this.shape = inspectorInfo;
        this.inspectorInfo = obj6;
    }

    public BackgroundElement(long l, Brush brush2, float f3, Shape shape4, Function1 function15, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        long l2;
        int i;
        long obj9;
        int obj11;
        if (defaultConstructorMarker7 & 1 != 0) {
            l2 = obj9;
        } else {
            l2 = l;
        }
        i = defaultConstructorMarker7 & 2 != 0 ? obj11 : f3;
        super(l2, obj2, i, shape4, function15, i6, 0);
    }

    public BackgroundElement(long l, Brush brush2, float f3, Shape shape4, Function1 function15, DefaultConstructorMarker defaultConstructorMarker6) {
        super(l, brush2, f3, shape4, function15, defaultConstructorMarker6);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.BackgroundNode create() {
        BackgroundNode backgroundNode = new BackgroundNode(this.color, obj2, this.brush, this.alpha, this.shape, 0);
        return backgroundNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        Object obj;
        int i;
        boolean equal;
        int brush;
        Shape color;
        if (other instanceof BackgroundElement) {
            obj = other;
        } else {
            obj = 0;
        }
        i = 0;
        if (obj == null) {
            return i;
        }
        if (Color.equals-impl0(this.color, obj3) && Intrinsics.areEqual(this.brush, obj.brush)) {
            if (Intrinsics.areEqual(this.brush, obj.brush)) {
                brush = 1;
                equal = Float.compare(alpha, alpha2) == 0 ? brush : i;
                if (equal != 0 && Intrinsics.areEqual(this.shape, obj.shape)) {
                    if (Intrinsics.areEqual(this.shape, obj.shape)) {
                        i = brush;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        Brush brush = this.brush;
        if (brush != null) {
            i = brush.hashCode();
        } else {
            i = 0;
        }
        return result2 += i8;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.BackgroundNode node) {
        node.setColor-8_81llA(this.color);
        node.setBrush(this.brush);
        node.setAlpha(this.alpha);
        node.setShape(this.shape);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((BackgroundNode)node);
    }
}
