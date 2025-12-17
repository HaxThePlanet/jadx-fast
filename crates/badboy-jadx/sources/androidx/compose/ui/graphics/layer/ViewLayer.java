package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 22\u00020\u0001:\u00012B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0014J\u0008\u0010%\u001a\u00020\u0016H\u0016J\u0008\u0010&\u001a\u00020\tH\u0016J\u0008\u0010'\u001a\u00020\u0016H\u0016J0\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+H\u0014J9\u0010/\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010 \u001a\u0004\u0018\u00010!2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\u0008\u0017J\u0010\u00100\u001a\u00020\t2\u0008\u00101\u001a\u0004\u0018\u00010\u001bR$\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\u0008\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u000c\"\u0004\u0008\u0019\u0010\u000eR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063", d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/view/View;", "ownerView", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroid/view/View;Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "canUseCompositingLayer", "getCanUseCompositingLayer$ui_graphics_release", "()Z", "setCanUseCompositingLayer$ui_graphics_release", "(Z)V", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "density", "Landroidx/compose/ui/unit/Density;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "isInvalidated", "setInvalidated", "layerOutline", "Landroid/graphics/Outline;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getOwnerView", "()Landroid/view/View;", "parentLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "forceLayout", "hasOverlappingRendering", "invalidate", "onLayout", "changed", "l", "", "t", "r", "b", "setDrawParams", "setLayerOutline", "outline", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewLayer extends View {

    public static final androidx.compose.ui.graphics.layer.ViewLayer.Companion Companion;
    private static final ViewOutlineProvider LayerOutlineProvider;
    private boolean canUseCompositingLayer;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private Density density;
    private Function1<? super DrawScope, Unit> drawBlock;
    private boolean isInvalidated;
    private Outline layerOutline;
    private LayoutDirection layoutDirection;
    private final View ownerView;
    private androidx.compose.ui.graphics.layer.GraphicsLayer parentLayer;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer$Companion;", "", "()V", "LayerOutlineProvider", "Landroid/view/ViewOutlineProvider;", "getLayerOutlineProvider$ui_graphics_release", "()Landroid/view/ViewOutlineProvider;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final ViewOutlineProvider getLayerOutlineProvider$ui_graphics_release() {
            return ViewLayer.access$getLayerOutlineProvider$cp();
        }
    }
    static {
        ViewLayer.Companion companion = new ViewLayer.Companion(0);
        ViewLayer.Companion = companion;
        ViewLayer.Companion.LayerOutlineProvider.1 anon = new ViewLayer.Companion.LayerOutlineProvider.1();
        ViewLayer.LayerOutlineProvider = (ViewOutlineProvider)anon;
    }

    public ViewLayer(View ownerView, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super(ownerView.getContext());
        this.ownerView = ownerView;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        setOutlineProvider(ViewLayer.LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayerImpl.Companion.getDefaultDrawBlock();
        setWillNotDraw(false);
        setClipBounds(0);
    }

    public ViewLayer(View view, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        CanvasHolder obj2;
        CanvasDrawScope obj3;
        if (i4 & 2 != 0) {
            obj2 = new CanvasHolder();
        }
        if (i4 &= 4 != 0) {
            obj3 = new CanvasDrawScope();
        }
        super(view, obj2, obj3);
    }

    public static final Outline access$getLayerOutline$p(androidx.compose.ui.graphics.layer.ViewLayer $this) {
        return $this.layerOutline;
    }

    public static final ViewOutlineProvider access$getLayerOutlineProvider$cp() {
        return ViewLayer.LayerOutlineProvider;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        final Object obj = this;
        CanvasHolder canvasHolder = obj.canvasHolder;
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas5 = androidCanvas3;
        float f2 = (float)height;
        final CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        final int i4 = 0;
        final int i5 = i2;
        Canvas canvas4 = canvasDrawScope2.getDrawContext().getCanvas();
        final int i6 = i3;
        DrawContext drawContext7 = canvasDrawScope2.getDrawContext();
        int i8 = 0;
        drawContext7.setDensity(obj.density);
        drawContext7.setLayoutDirection(obj.layoutDirection);
        drawContext7.setCanvas((Canvas)androidCanvas5);
        drawContext7.setSize-uvyYCjk(SizeKt.Size((float)width, f2));
        drawContext7.setGraphicsLayer(obj.parentLayer);
        androidCanvas5.save();
        obj.drawBlock.invoke(canvasDrawScope2);
        androidCanvas5.restore();
        DrawContext drawContext8 = canvasDrawScope2.getDrawContext();
        int i9 = 0;
        drawContext8.setDensity(canvasDrawScope2.getDrawContext().getDensity());
        drawContext8.setLayoutDirection(canvasDrawScope2.getDrawContext().getLayoutDirection());
        final AndroidCanvas androidCanvas6 = androidCanvas5;
        drawContext8.setCanvas(canvas4);
        drawContext8.setSize-uvyYCjk(canvasDrawScope2.getDrawContext().getSize-NH-jbRc());
        drawContext8.setGraphicsLayer(canvasDrawScope2.getDrawContext().getGraphicsLayer());
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvasHolder.getAndroidCanvas().getInternalCanvas());
        obj.isInvalidated = false;
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.View
    public final boolean getCanUseCompositingLayer$ui_graphics_release() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    @Override // android.view.View
    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public void invalidate() {
        boolean isInvalidated;
        if (!this.isInvalidated) {
            this.isInvalidated = true;
            super.invalidate();
        }
    }

    @Override // android.view.View
    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.View
    public final void setCanUseCompositingLayer$ui_graphics_release(boolean value) {
        if (this.canUseCompositingLayer != value) {
            this.canUseCompositingLayer = value;
            invalidate();
        }
    }

    public final void setDrawParams(Density density, LayoutDirection layoutDirection, androidx.compose.ui.graphics.layer.GraphicsLayer parentLayer, Function1<? super DrawScope, Unit> drawBlock) {
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = drawBlock;
        this.parentLayer = parentLayer;
    }

    @Override // android.view.View
    public final void setInvalidated(boolean <set-?>) {
        this.isInvalidated = <set-?>;
    }

    @Override // android.view.View
    public final boolean setLayerOutline(Outline outline) {
        this.layerOutline = outline;
        return OutlineUtils.INSTANCE.rebuildOutline((View)this);
    }
}
