package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\u00080\u00101J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\u00085\u00101J\u0008\u00106\u001a\u000207H\u0016J\u000c\u00108\u001a\u000209*\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\u0016\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J&\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\u0008L\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u000c\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010'\"\u0004\u0008)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010'\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006P", d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {

    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;
    public PainterNode(Painter painter, boolean sizeToIntrinsics, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        super();
        this.painter = painter;
        this.sizeToIntrinsics = sizeToIntrinsics;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
    }

    public PainterNode(Painter painter, boolean z2, Alignment alignment3, ContentScale contentScale4, float f5, ColorFilter colorFilter6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        Alignment alignment;
        ContentScale contentScale;
        int i2;
        int i;
        Alignment obj10;
        ContentScale obj11;
        int obj12;
        int obj13;
        if (i7 & 4 != 0) {
            alignment = obj10;
        } else {
            alignment = alignment3;
        }
        if (i7 & 8 != 0) {
            contentScale = obj11;
        } else {
            contentScale = contentScale4;
        }
        i2 = i7 & 16 != 0 ? obj12 : f5;
        i = i7 & 32 != 0 ? obj13 : colorFilter6;
        super(painter, z2, alignment, contentScale, i2, i);
    }

    private final long calculateScaledSize-E7KxVPU(long dstSize) {
        boolean useIntrinsicSize;
        long height-impl;
        long l;
        long times-UQTWf7w;
        int cmp;
        int i3;
        int i2;
        int i;
        if (!getUseIntrinsicSize()) {
            times-UQTWf7w = dstSize;
        } else {
            if (!hasSpecifiedAndFiniteWidth-uvyYCjk(this.painter.getIntrinsicSize-NH-jbRc())) {
                useIntrinsicSize = Size.getWidth-impl(dstSize);
            } else {
                useIntrinsicSize = Size.getWidth-impl(this.painter.getIntrinsicSize-NH-jbRc());
            }
            if (!hasSpecifiedAndFiniteHeight-uvyYCjk(this.painter.getIntrinsicSize-NH-jbRc())) {
                height-impl = Size.getHeight-impl(dstSize);
            } else {
                height-impl = Size.getHeight-impl(this.painter.getIntrinsicSize-NH-jbRc());
            }
            l = SizeKt.Size(useIntrinsicSize, height-impl);
            i3 = 0;
            i = 0;
            cmp = Float.compare(width-impl, i3) == 0 ? i2 : i;
            if (cmp == 0) {
                if (Float.compare(height-impl2, i3) == 0) {
                } else {
                    i2 = i;
                }
                if (i2 == 0) {
                    times-UQTWf7w = ScaleFactorKt.times-UQTWf7w(l, obj3);
                } else {
                    times-UQTWf7w = Size.Companion.getZero-NH-jbRc();
                }
            } else {
            }
        }
        return times-UQTWf7w;
    }

    private final boolean getUseIntrinsicSize() {
        boolean $i$f$isSpecifiedUvyYCjk;
        int i;
        long intrinsicSize-NH-jbRc;
        int cmp;
        int i2;
        if (this.sizeToIntrinsics) {
            int i3 = 0;
            i2 = 1;
            $i$f$isSpecifiedUvyYCjk = Long.compare(intrinsicSize-NH-jbRc, l) != 0 ? i2 : i;
            if ($i$f$isSpecifiedUvyYCjk != 0) {
                i = i2;
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean hasSpecifiedAndFiniteHeight-uvyYCjk(long $this$hasSpecifiedAndFiniteHeight_u2duvyYCjk) {
        boolean equals-impl0;
        float height-impl;
        int i;
        boolean infinite;
        int i2;
        if (!Size.equals-impl0($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk, obj6)) {
            height-impl = Size.getHeight-impl($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk);
            i2 = 1;
            if (!Float.isInfinite(height-impl) && !Float.isNaN(height-impl)) {
                equals-impl0 = !Float.isNaN(height-impl) ? i2 : i;
            } else {
            }
            if (equals-impl0 != 0) {
                i = i2;
            }
        }
        return i;
    }

    private final boolean hasSpecifiedAndFiniteWidth-uvyYCjk(long $this$hasSpecifiedAndFiniteWidth_u2duvyYCjk) {
        boolean equals-impl0;
        float width-impl;
        int i;
        boolean infinite;
        int i2;
        if (!Size.equals-impl0($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk, obj6)) {
            width-impl = Size.getWidth-impl($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk);
            i2 = 1;
            if (!Float.isInfinite(width-impl) && !Float.isNaN(width-impl)) {
                equals-impl0 = !Float.isNaN(width-impl) ? i2 : i;
            } else {
            }
            if (equals-impl0 != 0) {
                i = i2;
            }
        }
        return i;
    }

    private final long modifyConstraints-ZezNO4M(long constraints) {
        boolean hasBoundedWidth-impl;
        int i2;
        boolean hasFixedHeight-impl;
        int i3;
        int $this$fastRoundToInt$iv2;
        int $this$fastRoundToInt$iv;
        int i;
        final Object obj = this;
        int i4 = 0;
        if (Constraints.getHasBoundedWidth-impl(constraints) && Constraints.getHasBoundedHeight-impl(constraints)) {
            i2 = Constraints.getHasBoundedHeight-impl(constraints) ? i3 : i4;
        } else {
        }
        if (Constraints.getHasFixedWidth-impl(constraints) && Constraints.getHasFixedHeight-impl(constraints)) {
            if (Constraints.getHasFixedHeight-impl(constraints)) {
            } else {
                i3 = i4;
            }
        } else {
        }
        if (!obj.getUseIntrinsicSize()) {
            if (i2 == 0 && i3 != 0) {
                if (i3 != 0) {
                }
            }
            return Constraints.copy-Zbe2FdA$default(constraints, i3, Constraints.getMaxWidth-impl(constraints), 0, Constraints.getMaxHeight-impl(constraints), 0, 10);
        } else {
        }
        Object obj3 = constraints;
        final long intrinsicSize-NH-jbRc = obj.painter.getIntrinsicSize-NH-jbRc();
        if (obj.hasSpecifiedAndFiniteWidth-uvyYCjk(intrinsicSize-NH-jbRc)) {
            i = 0;
            $this$fastRoundToInt$iv2 = Math.round(Size.getWidth-impl(intrinsicSize-NH-jbRc));
        } else {
            $this$fastRoundToInt$iv2 = Constraints.getMinWidth-impl(obj3);
        }
        if (obj.hasSpecifiedAndFiniteHeight-uvyYCjk(intrinsicSize-NH-jbRc)) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(Size.getHeight-impl(intrinsicSize-NH-jbRc));
        } else {
            $this$fastRoundToInt$iv = Constraints.getMinHeight-impl(obj3);
        }
        int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(obj3, i3);
        float f2 = (float)constrainHeight-K40F9xA;
        final long scaledSize-E7KxVPU = obj.calculateScaledSize-E7KxVPU(SizeKt.Size((float)constrainWidth-K40F9xA2, f2));
        int i6 = 0;
        int i8 = 0;
        final int i18 = i9;
        return Constraints.copy-Zbe2FdA$default(obj3, i3, ConstraintsKt.constrainWidth-K40F9xA(obj3, i3), 0, ConstraintsKt.constrainHeight-K40F9xA(obj3, i3), 0, 10);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        float width-impl;
        float height-impl;
        int cmp;
        Object contentScale;
        int i2;
        int intrinsicSize;
        long size-NH-jbRc;
        long size-NH-jbRc3;
        long times-UQTWf7w;
        int i;
        long size-NH-jbRc2;
        int i3;
        int i4;
        Object obj = this;
        long intrinsicSize-NH-jbRc = obj.painter.getIntrinsicSize-NH-jbRc();
        if (obj.hasSpecifiedAndFiniteWidth-uvyYCjk(intrinsicSize-NH-jbRc)) {
            width-impl = Size.getWidth-impl(intrinsicSize-NH-jbRc);
        } else {
            width-impl = Size.getWidth-impl($this$draw.getSize-NH-jbRc());
        }
        if (obj.hasSpecifiedAndFiniteHeight-uvyYCjk(intrinsicSize-NH-jbRc)) {
            height-impl = Size.getHeight-impl(intrinsicSize-NH-jbRc);
        } else {
            height-impl = Size.getHeight-impl($this$draw.getSize-NH-jbRc());
        }
        final long l = SizeKt.Size(width-impl, height-impl);
        int i7 = 0;
        int i13 = 0;
        cmp = Float.compare(width-impl2, i7) == 0 ? i : i13;
        if (cmp == 0) {
            if (Float.compare(height-impl2, i7) == 0) {
            } else {
                i = i13;
            }
            if (i == 0) {
                times-UQTWf7w = ScaleFactorKt.times-UQTWf7w(l, obj7);
            } else {
                times-UQTWf7w = Size.Companion.getZero-NH-jbRc();
            }
        } else {
        }
        final long l2 = times-UQTWf7w;
        int i8 = 0;
        int i10 = 0;
        int i9 = 0;
        int i11 = 0;
        long align-KFBX0sM = obj.alignment.align-KFBX0sM(IntSizeKt.IntSize(Math.round(Size.getWidth-impl(l2)), Math.round(Size.getHeight-impl(l2))), obj16, IntSizeKt.IntSize(Math.round(Size.getWidth-impl($this$draw.getSize-NH-jbRc())), Math.round(Size.getHeight-impl($this$draw.getSize-NH-jbRc()))));
        float f4 = (float)x-impl;
        float f5 = (float)y-impl;
        final DrawScope drawScope = $this$draw;
        int i15 = 0;
        (DrawScope)drawScope.getDrawContext().getTransform().translate(f4, f5);
        int i5 = 0;
        final int i16 = 0;
        long dy3 = l5;
        obj.painter.draw-x_KDEd0(drawScope, l2, obj13, obj.alpha);
        drawScope.getDrawContext().getTransform().translate(-f, -intrinsicSize2);
        $this$draw.drawContent();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        long modifyConstraints-ZezNO4M;
        int i4;
        int width2;
        int minHeight-impl;
        int i3;
        int i;
        int i2;
        int obj10;
        if (getUseIntrinsicSize()) {
            i4 = 0;
            width2 = width;
            obj10 = Math.max(Constraints.getMinHeight-impl(modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(i4, width2, 0, 0, 13, 0))), measurable.maxIntrinsicHeight(width2));
        } else {
            obj10 = measurable.maxIntrinsicHeight(width);
        }
        return obj10;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        long modifyConstraints-ZezNO4M;
        int i2;
        int minWidth-impl;
        int i4;
        int height2;
        int i;
        int i3;
        int obj10;
        if (getUseIntrinsicSize()) {
            i2 = 0;
            height2 = height;
            obj10 = Math.max(Constraints.getMinWidth-impl(modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(i2, 0, 0, height2, 7, 0))), measurable.maxIntrinsicWidth(height2));
        } else {
            obj10 = measurable.maxIntrinsicWidth(height);
        }
        return obj10;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(modifyConstraints-ZezNO4M(constraints));
        PainterNode.measure.1 anon = new PainterNode.measure.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        long modifyConstraints-ZezNO4M;
        int i4;
        int width2;
        int minHeight-impl;
        int i3;
        int i2;
        int i;
        int obj10;
        if (getUseIntrinsicSize()) {
            i4 = 0;
            width2 = width;
            obj10 = Math.max(Constraints.getMinHeight-impl(modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(i4, width2, 0, 0, 13, 0))), measurable.minIntrinsicHeight(width2));
        } else {
            obj10 = measurable.minIntrinsicHeight(width);
        }
        return obj10;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        long modifyConstraints-ZezNO4M;
        int i4;
        int minWidth-impl;
        int i2;
        int height2;
        int i;
        int i3;
        int obj10;
        if (getUseIntrinsicSize()) {
            i4 = 0;
            height2 = height;
            obj10 = Math.max(Constraints.getMinWidth-impl(modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(i4, 0, 0, height2, 7, 0))), measurable.minIntrinsicWidth(height2));
        } else {
            obj10 = measurable.minIntrinsicWidth(height);
        }
        return obj10;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAlignment(Alignment <set-?>) {
        this.alignment = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAlpha(float <set-?>) {
        this.alpha = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setColorFilter(ColorFilter <set-?>) {
        this.colorFilter = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setContentScale(ContentScale <set-?>) {
        this.contentScale = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setPainter(Painter <set-?>) {
        this.painter = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setSizeToIntrinsics(boolean <set-?>) {
        this.sizeToIntrinsics = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PainterModifier(painter=").append(this.painter).append(", sizeToIntrinsics=").append(this.sizeToIntrinsics).append(", alignment=").append(this.alignment).append(", alpha=").append(this.alpha).append(", colorFilter=").append(this.colorFilter).append(')').toString();
    }
}
