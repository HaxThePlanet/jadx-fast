package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\u000cHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000eHÆ\u0003JG\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0008\u0010#\u001a\u00020\u0002H\u0016J\u0013\u0010$\u001a\u00020\u00062\u0008\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0016J\u000c\u0010.\u001a\u00020,*\u00020/H\u0016R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b¨\u00060", d2 = {"Landroidx/compose/ui/draw/PainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/PainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PainterElement extends ModifierNodeElement<androidx.compose.ui.draw.PainterNode> {

    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;
    public PainterElement(Painter painter, boolean sizeToIntrinsics, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        super();
        this.painter = painter;
        this.sizeToIntrinsics = sizeToIntrinsics;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
    }

    public static androidx.compose.ui.draw.PainterElement copy$default(androidx.compose.ui.draw.PainterElement painterElement, Painter painter2, boolean z3, Alignment alignment4, ContentScale contentScale5, float f6, ColorFilter colorFilter7, int i8, Object object9) {
        Painter obj1;
        boolean obj2;
        Alignment obj3;
        ContentScale obj4;
        float obj5;
        ColorFilter obj6;
        if (i8 & 1 != 0) {
            obj1 = painterElement.painter;
        }
        if (i8 & 2 != 0) {
            obj2 = painterElement.sizeToIntrinsics;
        }
        if (i8 & 4 != 0) {
            obj3 = painterElement.alignment;
        }
        if (i8 & 8 != 0) {
            obj4 = painterElement.contentScale;
        }
        if (i8 & 16 != 0) {
            obj5 = painterElement.alpha;
        }
        if (i8 &= 32 != 0) {
            obj6 = painterElement.colorFilter;
        }
        return painterElement.copy(obj1, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Painter component1() {
        return this.painter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component2() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Alignment component3() {
        return this.alignment;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final ContentScale component4() {
        return this.contentScale;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component5() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final ColorFilter component6() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.draw.PainterElement copy(Painter painter, boolean z2, Alignment alignment3, ContentScale contentScale4, float f5, ColorFilter colorFilter6) {
        PainterElement painterElement = new PainterElement(painter, z2, alignment3, contentScale4, f5, colorFilter6);
        return painterElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.draw.PainterNode create() {
        PainterNode painterNode = new PainterNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
        return painterNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PainterElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.painter, obj.painter)) {
            return i2;
        }
        if (this.sizeToIntrinsics != obj.sizeToIntrinsics) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.contentScale, obj.contentScale)) {
            return i2;
        }
        if (Float.compare(this.alpha, obj.alpha) != 0) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.colorFilter, obj.colorFilter)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.colorFilter == null) {
            i = 0;
        } else {
            i = this.colorFilter.hashCode();
        }
        return i11 += i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("paint");
        $this$inspectableProperties.getProperties().set("painter", this.painter);
        $this$inspectableProperties.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.sizeToIntrinsics));
        $this$inspectableProperties.getProperties().set("alignment", this.alignment);
        $this$inspectableProperties.getProperties().set("contentScale", this.contentScale);
        $this$inspectableProperties.getProperties().set("alpha", Float.valueOf(this.alpha));
        $this$inspectableProperties.getProperties().set("colorFilter", this.colorFilter);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PainterElement(painter=").append(this.painter).append(", sizeToIntrinsics=").append(this.sizeToIntrinsics).append(", alignment=").append(this.alignment).append(", contentScale=").append(this.contentScale).append(", alpha=").append(this.alpha).append(", colorFilter=").append(this.colorFilter).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((PainterNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.draw.PainterNode node) {
        int i;
        boolean sizeToIntrinsics;
        Object colorFilter;
        long intrinsicSize-NH-jbRc;
        boolean sizeToIntrinsics2 = this.sizeToIntrinsics;
        if (node.getSizeToIntrinsics() == sizeToIntrinsics2) {
            if (this.sizeToIntrinsics && !Size.equals-impl0(node.getPainter().getIntrinsicSize-NH-jbRc(), sizeToIntrinsics2)) {
                if (!Size.equals-impl0(node.getPainter().getIntrinsicSize-NH-jbRc(), sizeToIntrinsics2)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        node.setPainter(this.painter);
        node.setSizeToIntrinsics(this.sizeToIntrinsics);
        node.setAlignment(this.alignment);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        if (i != 0) {
            LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)node);
        }
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)node);
    }
}
