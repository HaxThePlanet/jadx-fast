package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008`\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H&J\u0008\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH&ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0010H&ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001eH&ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&ø\u0001\u0000¢\u0006\u0004\u0008$\u0010 JP\u0010%\u001a\u00020\u000328\u0010&\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008(\u0012\u0008\u0008)\u0012\u0004\u0008\u0008(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0008¢\u0006\u000c\u0008(\u0012\u0008\u0008)\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00030'2\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00030+H&J\u001a\u0010,\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH&ø\u0001\u0000¢\u0006\u0004\u0008-\u0010\u000eJ\u0008\u0010.\u001a\u00020\u0003H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u00062À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/OwnedLayer;", "", "destroy", "", "drawLayer", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "drawBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "invalidateParentLayer", "Lkotlin/Function0;", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface OwnedLayer {
    public abstract void destroy();

    public abstract void drawLayer(Canvas canvas, GraphicsLayer graphicsLayer2);

    public abstract void invalidate();

    public abstract void inverseTransform-58bKbWc(float[] fArr);

    public abstract boolean isInLayer-k-4lQ0M(long l);

    public abstract void mapBounds(MutableRect mutableRect, boolean z2);

    public abstract long mapOffset-8S9VItk(long l, boolean z2);

    public abstract void move--gyyYBs(long l);

    public abstract void resize-ozmzZPI(long l);

    public abstract void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function02);

    public abstract void transform-58bKbWc(float[] fArr);

    public abstract void updateDisplayList();

    public abstract void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope);
}
