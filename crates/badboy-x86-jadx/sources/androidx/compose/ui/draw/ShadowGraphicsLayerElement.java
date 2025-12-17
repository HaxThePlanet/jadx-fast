package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\u0016\u0010\u0018\u001a\u00020\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u0013J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0008HÆ\u0003J\u0016\u0010\u001c\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\nHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010\u000eJE\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J\u0008\u0010#\u001a\u00020\u0002H\u0016J\u0019\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\u0008(H\u0002J\u0013\u0010)\u001a\u00020\u00082\u0008\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0002H\u0016J\u000c\u00102\u001a\u00020'*\u000203H\u0016R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0017\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00064", d2 = {"Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "(FLandroidx/compose/ui/graphics/Shape;ZJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAmbientColor-0d7_KjU", "()J", "J", "getClip", "()Z", "getElevation-D9Ej5fM", "()F", "F", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSpotColor-0d7_KjU", "component1", "component1-D9Ej5fM", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "copy", "copy-gNMxBKI", "(FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "create", "createBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ShadowGraphicsLayerElement extends ModifierNodeElement<BlockGraphicsLayerModifier> {

    public static final int $stable;
    private final long ambientColor;
    private final boolean clip;
    private final float elevation;
    private final Shape shape;
    private final long spotColor;
    static {
    }

    private ShadowGraphicsLayerElement(float elevation, Shape shape, boolean clip, long ambientColor, long spotColor) {
        super();
        this.elevation = elevation;
        this.shape = shape;
        this.clip = clip;
        this.ambientColor = ambientColor;
        this.spotColor = obj6;
    }

    public ShadowGraphicsLayerElement(float f, Shape shape2, boolean z3, long l4, long l5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(f, shape2, z3, l4, l5, defaultConstructorMarker6, obj7);
    }

    public static androidx.compose.ui.draw.ShadowGraphicsLayerElement copy-gNMxBKI$default(androidx.compose.ui.draw.ShadowGraphicsLayerElement shadowGraphicsLayerElement, float f2, Shape shape3, boolean z4, long l5, long l6, int i7, Object object8) {
        float obj1;
        Shape obj2;
        boolean obj3;
        long obj4;
        long obj6;
        if (obj8 & 1 != 0) {
            obj1 = shadowGraphicsLayerElement.elevation;
        }
        if (obj8 & 2 != 0) {
            obj2 = shadowGraphicsLayerElement.shape;
        }
        if (obj8 & 4 != 0) {
            obj3 = shadowGraphicsLayerElement.clip;
        }
        int obj9 = obj8 & 8;
        if (obj9 != null) {
            obj4 = shadowGraphicsLayerElement.ambientColor;
        }
        if (obj8 &= 16 != 0) {
            obj6 = shadowGraphicsLayerElement.spotColor;
        }
        return shadowGraphicsLayerElement.copy-gNMxBKI(obj1, obj2, obj3, obj4, object8);
    }

    private final Function1<GraphicsLayerScope, Unit> createBlock() {
        ShadowGraphicsLayerElement.createBlock.1 anon = new ShadowGraphicsLayerElement.createBlock.1(this);
        return (Function1)anon;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component1-D9Ej5fM() {
        return this.elevation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Shape component2() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component3() {
        return this.clip;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long component4-0d7_KjU() {
        return this.ambientColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long component5-0d7_KjU() {
        return this.spotColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.draw.ShadowGraphicsLayerElement copy-gNMxBKI(float f, Shape shape2, boolean z3, long l4, long l5) {
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = new ShadowGraphicsLayerElement(f, shape2, z3, l4, obj5, obj15, obj7, 0);
        return shadowGraphicsLayerElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public BlockGraphicsLayerModifier create() {
        BlockGraphicsLayerModifier blockGraphicsLayerModifier = new BlockGraphicsLayerModifier(createBlock());
        return blockGraphicsLayerModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ShadowGraphicsLayerElement) {
            return i2;
        }
        Object obj = object;
        if (!Dp.equals-impl0(this.elevation, obj.elevation)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.shape, obj.shape)) {
            return i2;
        }
        boolean clip2 = obj.clip;
        if (this.clip != clip2) {
            return i2;
        }
        if (!Color.equals-impl0(this.ambientColor, clip2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.spotColor, clip2)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long getAmbientColor-0d7_KjU() {
        return this.ambientColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getElevation-D9Ej5fM() {
        return this.elevation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long getSpotColor-0d7_KjU() {
        return this.spotColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i4 += i13;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("shadow");
        $this$inspectableProperties.getProperties().set("elevation", Dp.box-impl(this.elevation));
        $this$inspectableProperties.getProperties().set("shape", this.shape);
        String str4 = "clip";
        $this$inspectableProperties.getProperties().set(str4, Boolean.valueOf(this.clip));
        String str5 = "ambientColor";
        $this$inspectableProperties.getProperties().set(str5, Color.box-impl(this.ambientColor));
        $this$inspectableProperties.getProperties().set("spotColor", Color.box-impl(this.spotColor));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ShadowGraphicsLayerElement(elevation=").append(Dp.toString-impl(this.elevation)).append(", shape=").append(this.shape).append(", clip=").append(this.clip).append(", ambientColor=").append(Color.toString-impl(this.ambientColor)).append(", spotColor=").append(Color.toString-impl(this.spotColor)).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((BlockGraphicsLayerModifier)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(BlockGraphicsLayerModifier node) {
        node.setLayerBlock(createBlock());
        node.invalidateLayerBlock();
    }
}
