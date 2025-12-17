package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010P\u001a\u00020\u0014H\u0016J\u0008\u0010Q\u001a\u00020RH\u0002J\u0008\u0010S\u001a\u00020RH\u0002J\u000c\u0010T\u001a\u00020R*\u00020UH\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c2\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R,\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020#@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008.\u0010/\u001a\u0004\u0008,\u0010-R\u000e\u00100\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u00101\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00082\u0010\u0007\"\u0004\u00083\u0010\tR$\u00104\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u0010\r\"\u0004\u00086\u0010\u000fR,\u00108\u001a\u0002072\u0006\u0010\u0003\u001a\u000207@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u00089\u0010&\"\u0004\u0008:\u0010(R,\u0010<\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020;@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u0008=\u0010&\"\u0004\u0008>\u0010(R$\u0010?\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010\r\"\u0004\u0008A\u0010\u000fR$\u0010B\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010\r\"\u0004\u0008D\u0010\u000fR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010G\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008H\u0010\r\"\u0004\u0008I\u0010\u000fR$\u0010J\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008K\u0010\r\"\u0004\u0008L\u0010\u000fR$\u0010M\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010\r\"\u0004\u0008O\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006V", d2 = {"Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "value", "Landroidx/compose/ui/graphics/Brush;", "fill", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "setFill", "(Landroidx/compose/ui/graphics/Brush;)V", "", "fillAlpha", "getFillAlpha", "()F", "setFillAlpha", "(F)V", "isPathDirty", "", "isStrokeDirty", "isTrimPathDirty", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "path", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathData", "getPathData", "()Ljava/util/List;", "setPathData", "(Ljava/util/List;)V", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "getPathFillType-Rg-k1Os", "()I", "setPathFillType-oQ8Xj4U", "(I)V", "I", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "pathMeasure$delegate", "Lkotlin/Lazy;", "renderPath", "stroke", "getStroke", "setStroke", "strokeAlpha", "getStrokeAlpha", "setStrokeAlpha", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "getStrokeLineCap-KaPHkGw", "setStrokeLineCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "getStrokeLineJoin-LxFBmk8", "setStrokeLineJoin-Ww9F2mQ", "strokeLineMiter", "getStrokeLineMiter", "setStrokeLineMiter", "strokeLineWidth", "getStrokeLineWidth", "setStrokeLineWidth", "strokeStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trimPathEnd", "getTrimPathEnd", "setTrimPathEnd", "trimPathOffset", "getTrimPathOffset", "setTrimPathOffset", "trimPathStart", "getTrimPathStart", "setTrimPathStart", "toString", "updatePath", "", "updateRenderPath", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathComponent extends androidx.compose.ui.graphics.vector.VNode {

    public static final int $stable = 8;
    private Brush fill;
    private float fillAlpha = 1f;
    private boolean isPathDirty = true;
    private boolean isStrokeDirty = true;
    private boolean isTrimPathDirty;
    private String name;
    private final Path path;
    private List<? extends androidx.compose.ui.graphics.vector.PathNode> pathData;
    private int pathFillType;
    private final Lazy pathMeasure$delegate;
    private Path renderPath;
    private Brush stroke;
    private float strokeAlpha = 1f;
    private int strokeLineCap;
    private int strokeLineJoin;
    private float strokeLineMiter = 4f;
    private float strokeLineWidth;
    private Stroke strokeStyle;
    private float trimPathEnd = 1f;
    private float trimPathOffset;
    private float trimPathStart;
    static {
        final int i = 8;
    }

    public PathComponent() {
        super(0);
        this.name = "";
        int i2 = 1065353216;
        this.pathData = VectorKt.getEmptyPath();
        this.pathFillType = VectorKt.getDefaultFillType();
        this.strokeLineCap = VectorKt.getDefaultStrokeLineCap();
        this.strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
        int i4 = 1082130432;
        int i3 = 1;
        this.path = AndroidPath_androidKt.Path();
        this.renderPath = this.path;
        this.pathMeasure$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)PathComponent.pathMeasure.2.INSTANCE);
    }

    private final PathMeasure getPathMeasure() {
        return (PathMeasure)this.pathMeasure$delegate.getValue();
    }

    private final void updatePath() {
        PathParserKt.toPath(this.pathData, this.path);
        updateRenderPath();
    }

    private final void updateRenderPath() {
        int i;
        int fillType-Rg-k1Os;
        float length;
        PathMeasure pathMeasure2;
        int i3;
        Path pathMeasure;
        Path renderPath;
        int i2;
        float trimPathOffset;
        pathMeasure2 = 0;
        i3 = 0;
        final int i6 = 1;
        i = Float.compare(trimPathStart, pathMeasure2) == 0 ? i6 : i3;
        pathMeasure = 1065353216;
        if (i != 0) {
            i = Float.compare(trimPathEnd, pathMeasure) == 0 ? i6 : i3;
            if (i != 0) {
                this.renderPath = this.path;
            } else {
                if (Intrinsics.areEqual(this.renderPath, this.path)) {
                    this.renderPath = AndroidPath_androidKt.Path();
                } else {
                    this.renderPath.rewind();
                    this.renderPath.setFillType-oQ8Xj4U(this.renderPath.getFillType-Rg-k1Os());
                }
                getPathMeasure().setPath(this.path, i3);
                length = getPathMeasure().getLength();
                i5 *= length;
                i8 *= length;
                if (Float.compare(i3, i2) > 0) {
                    getPathMeasure().getSegment(i3, length, this.renderPath, i6);
                    getPathMeasure().getSegment(pathMeasure2, i2, this.renderPath, i6);
                } else {
                    getPathMeasure().getSegment(i3, i2, this.renderPath, i6);
                }
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope $this$draw) {
        boolean isTrimPathDirty;
        Brush fill;
        DrawScope targetStroke;
        Path isStrokeDirty;
        Brush stroke2;
        float strokeLineWidth;
        int strokeLineMiter;
        int strokeLineCap;
        int strokeLineJoin;
        int i6;
        int i3;
        int i5;
        Path renderPath;
        float strokeAlpha;
        Stroke stroke;
        int i;
        int i2;
        int i4;
        int i7;
        final Object obj = this;
        if (obj.isPathDirty) {
            obj.updatePath();
        } else {
            if (obj.isTrimPathDirty) {
                obj.updateRenderPath();
            }
        }
        int i8 = 0;
        obj.isPathDirty = i8;
        obj.isTrimPathDirty = i8;
        fill = obj.fill;
        if (fill != null) {
            fill = 0;
            DrawScope.drawPath-GBMwjPU$default($this$draw, obj.renderPath, fill, obj.fillAlpha, 0, 0, 0, 56, 0);
        }
        final Brush stroke3 = obj.stroke;
        if (stroke3 != null) {
            fill = 0;
            if (!obj.isStrokeDirty) {
                if (obj.strokeStyle == null) {
                    stroke2 = new Stroke(obj.strokeLineWidth, obj.strokeLineMiter, obj.strokeLineCap, obj.strokeLineJoin, 0, 16, 0);
                    obj.strokeStyle = stroke2;
                    obj.isStrokeDirty = i8;
                }
            } else {
            }
            DrawScope.drawPath-GBMwjPU$default($this$draw, obj.renderPath, stroke3, obj.strokeAlpha, (DrawStyle)targetStroke, 0, 0, 48, 0);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final Brush getFill() {
        return this.fill;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final String getName() {
        return this.name;
    }

    public final List<androidx.compose.ui.graphics.vector.PathNode> getPathData() {
        return this.pathData;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final int getPathFillType-Rg-k1Os() {
        return this.pathFillType;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final Brush getStroke() {
        return this.stroke;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final int getStrokeLineCap-KaPHkGw() {
        return this.strokeLineCap;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final int getStrokeLineJoin-LxFBmk8() {
        return this.strokeLineJoin;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setFill(Brush value) {
        this.fill = value;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setFillAlpha(float value) {
        this.fillAlpha = value;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setName(String value) {
        this.name = value;
        invalidate();
    }

    public final void setPathData(List<? extends androidx.compose.ui.graphics.vector.PathNode> value) {
        this.pathData = value;
        this.isPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setPathFillType-oQ8Xj4U(int value) {
        this.pathFillType = value;
        this.renderPath.setFillType-oQ8Xj4U(value);
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setStroke(Brush value) {
        this.stroke = value;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setStrokeAlpha(float value) {
        this.strokeAlpha = value;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setStrokeLineCap-BeK7IIE(int value) {
        this.strokeLineCap = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setStrokeLineJoin-Ww9F2mQ(int value) {
        this.strokeLineJoin = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setStrokeLineMiter(float value) {
        this.strokeLineMiter = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setStrokeLineWidth(float value) {
        this.strokeLineWidth = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setTrimPathEnd(float value) {
        this.trimPathEnd = value;
        this.isTrimPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setTrimPathOffset(float value) {
        this.trimPathOffset = value;
        this.isTrimPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setTrimPathStart(float value) {
        this.trimPathStart = value;
        this.isTrimPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public String toString() {
        return this.path.toString();
    }
}
