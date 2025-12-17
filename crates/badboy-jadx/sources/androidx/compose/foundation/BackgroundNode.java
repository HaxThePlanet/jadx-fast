package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010%\u001a\u00020&H\u0016J\u000c\u0010'\u001a\u00020&*\u00020(H\u0016J\u000c\u0010)\u001a\u00020&*\u00020(H\u0002J\u000c\u0010*\u001a\u00020&*\u00020(H\u0002J\u000c\u0010+\u001a\u00020\u001d*\u00020(H\u0002R\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u0005X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020 X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006,", d2 = {"Landroidx/compose/foundation/BackgroundNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastShape", "lastSize", "Landroidx/compose/ui/geometry/Size;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "onObservedReadsChanged", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "getOutline", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode {

    private float alpha;
    private Brush brush;
    private long color;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Shape shape;
    private BackgroundNode(long color, Brush brush, float alpha, Shape shape) {
        super();
        this.color = color;
        this.brush = alpha;
        this.alpha = shape;
        this.shape = obj7;
        this.lastSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public BackgroundNode(long l, Brush brush2, float f3, Shape shape4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, brush2, f3, shape4, defaultConstructorMarker5);
    }

    private final void drawOutline(ContentDrawScope $this$drawOutline) {
        boolean equals-impl0;
        long color;
        long alpha;
        long unspecified-0d7_KjU;
        int i5;
        int i4;
        int i;
        int i2;
        int i3;
        final Outline outline = getOutline($this$drawOutline);
        if (!Color.equals-impl0(this.color, obj3)) {
            OutlineKt.drawOutline-wDX37Ww$default((DrawScope)$this$drawOutline, outline, this.color, obj3, 0, 0, 0, 0, 60);
        }
        Brush brush = this.brush;
        if (brush != null) {
            i3 = 0;
            OutlineKt.drawOutline-hn5TExg$default((DrawScope)$this$drawOutline, outline, brush, this.alpha, 0, 0, 0, 56, 0);
        }
    }

    private final void drawRect(ContentDrawScope $this$drawRect) {
        Brush brush;
        long l;
        long unspecified-0d7_KjU;
        long i6;
        int i10;
        long i4;
        int i5;
        androidx.compose.ui.graphics.drawscope.DrawStyle alpha;
        int i;
        int i7;
        int i8;
        int i2;
        int i9;
        int i3;
        if (!Color.equals-impl0(this.color, obj1)) {
            DrawScope.drawRect-n-J9OG0$default((DrawScope)$this$drawRect, this.color, obj3, 0, obj5, 0, obj7, 0, 0, 0);
        }
        brush = this.brush;
        if (brush != null) {
            brush = 0;
            DrawScope.drawRect-AsUm42w$default((DrawScope)$this$drawRect, brush, 0, i10, 0, i5, this.alpha, 0, 0, 0);
        }
    }

    private final Outline getOutline(ContentDrawScope $this$getOutline) {
        Object lastOutline;
        boolean layoutDirection;
        Object lastLayoutDirection;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (Size.equals-impl0($this$getOutline.getSize-NH-jbRc(), obj2) && $this$getOutline.getLayoutDirection() == this.lastLayoutDirection && Intrinsics.areEqual(this.lastShape, this.shape)) {
            if ($this$getOutline.getLayoutDirection() == this.lastLayoutDirection) {
                if (Intrinsics.areEqual(this.lastShape, this.shape)) {
                    lastOutline = this.lastOutline;
                    Intrinsics.checkNotNull(lastOutline);
                    objectRef.element = lastOutline;
                } else {
                    lastLayoutDirection = new BackgroundNode.getOutline.1(objectRef, this, $this$getOutline);
                    ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)lastLayoutDirection);
                }
            } else {
            }
        } else {
        }
        this.lastOutline = (Outline)objectRef.element;
        this.lastSize = $this$getOutline.getSize-NH-jbRc();
        this.lastLayoutDirection = $this$getOutline.getLayoutDirection();
        this.lastShape = this.shape;
        Object element2 = objectRef.element;
        Intrinsics.checkNotNull(element2);
        return (Outline)element2;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect($this$draw);
        } else {
            drawOutline($this$draw);
        }
        $this$draw.drawContent();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getColor-0d7_KjU() {
        return this.color;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onObservedReadsChanged() {
        this.lastSize = Size.Companion.getUnspecified-NH-jbRc();
        int i = 0;
        this.lastLayoutDirection = i;
        this.lastOutline = i;
        this.lastShape = i;
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAlpha(float <set-?>) {
        this.alpha = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setBrush(Brush <set-?>) {
        this.brush = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setColor-8_81llA(long <set-?>) {
        this.color = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setShape(Shape <set-?>) {
        this.shape = <set-?>;
    }
}
