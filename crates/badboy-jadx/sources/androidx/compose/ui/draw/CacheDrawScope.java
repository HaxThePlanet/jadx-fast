package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0007\u0008\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+J\u001f\u0010,\u001a\u00020\u00142\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u00081J\u001f\u00102\u001a\u00020\u00142\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u00081JK\u00103\u001a\u000200*\u00020+2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00012\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010&\u001a\u0002042\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u00081ø\u0001\u0000¢\u0006\u0004\u00085\u00106R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0012R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0017\u0010&\u001a\u00020'8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008(\u0010)\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00067", d2 = {"Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/unit/Density;", "()V", "cacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "getCacheParams$ui_release", "()Landroidx/compose/ui/draw/BuildDrawCacheParams;", "setCacheParams$ui_release", "(Landroidx/compose/ui/draw/BuildDrawCacheParams;)V", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "getContentDrawScope$ui_release", "()Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setContentDrawScope$ui_release", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "density", "", "getDensity", "()F", "drawResult", "Landroidx/compose/ui/draw/DrawResult;", "getDrawResult$ui_release", "()Landroidx/compose/ui/draw/DrawResult;", "setDrawResult$ui_release", "(Landroidx/compose/ui/draw/DrawResult;)V", "fontScale", "getFontScale", "graphicsContextProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContextProvider$ui_release", "()Lkotlin/jvm/functions/Function0;", "setGraphicsContextProvider$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "obtainGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "onDrawBehind", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "onDrawWithContent", "record", "Landroidx/compose/ui/unit/IntSize;", "record-TdoYBX4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CacheDrawScope implements Density {

    public static final int $stable;
    private androidx.compose.ui.draw.BuildDrawCacheParams cacheParams;
    private ContentDrawScope contentDrawScope;
    private androidx.compose.ui.draw.DrawResult drawResult;
    private Function0<? extends GraphicsContext> graphicsContextProvider;
    static {
    }

    public CacheDrawScope() {
        super();
        this.cacheParams = (BuildDrawCacheParams)EmptyBuildDrawCacheParams.INSTANCE;
    }

    public static void record-TdoYBX4$default(androidx.compose.ui.draw.CacheDrawScope cacheDrawScope, GraphicsLayer graphicsLayer2, Density density3, LayoutDirection layoutDirection4, long l5, Function1 function16, int i7, Object object8) {
        Density density;
        LayoutDirection layoutDirection;
        long l;
        Density obj9;
        LayoutDirection obj10;
        long obj11;
        if (object8 & 1 != 0) {
            density = obj9;
        } else {
            density = density3;
        }
        if (object8 & 2 != 0) {
            layoutDirection = obj10;
        } else {
            layoutDirection = layoutDirection4;
        }
        if (object8 & 4 != 0) {
            l = obj11;
        } else {
            l = l5;
        }
        cacheDrawScope.record-TdoYBX4(graphicsLayer2, density, layoutDirection, l, obj5);
    }

    @Override // androidx.compose.ui.unit.Density
    public final androidx.compose.ui.draw.BuildDrawCacheParams getCacheParams$ui_release() {
        return this.cacheParams;
    }

    @Override // androidx.compose.ui.unit.Density
    public final ContentDrawScope getContentDrawScope$ui_release() {
        return this.contentDrawScope;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final androidx.compose.ui.draw.DrawResult getDrawResult$ui_release() {
        return this.drawResult;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    public final Function0<GraphicsContext> getGraphicsContextProvider$ui_release() {
        return this.graphicsContextProvider;
    }

    @Override // androidx.compose.ui.unit.Density
    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.Density
    public final long getSize-NH-jbRc() {
        return this.cacheParams.getSize-NH-jbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    public final GraphicsLayer obtainGraphicsLayer() {
        Function0 graphicsContextProvider = this.graphicsContextProvider;
        Intrinsics.checkNotNull(graphicsContextProvider);
        return (GraphicsContext)graphicsContextProvider.invoke().createGraphicsLayer();
    }

    public final androidx.compose.ui.draw.DrawResult onDrawBehind(Function1<? super DrawScope, Unit> block) {
        CacheDrawScope.onDrawBehind.1 anon = new CacheDrawScope.onDrawBehind.1(block);
        return onDrawWithContent((Function1)anon);
    }

    public final androidx.compose.ui.draw.DrawResult onDrawWithContent(Function1<? super ContentDrawScope, Unit> block) {
        DrawResult drawResult = new DrawResult(block);
        final int i = 0;
        this.drawResult = drawResult;
        return drawResult;
    }

    public final void record-TdoYBX4(GraphicsLayer $this$record_u2dTdoYBX4, Density density, LayoutDirection layoutDirection, long size, Function1<? super ContentDrawScope, Unit> block) {
        CacheDrawScope.record.1 anon = new CacheDrawScope.record.1(this, density, layoutDirection, size, obj5, obj13);
        $this$record_u2dTdoYBX4.record-mL-hObY(density, layoutDirection, size, block);
    }

    @Override // androidx.compose.ui.unit.Density
    public final void setCacheParams$ui_release(androidx.compose.ui.draw.BuildDrawCacheParams <set-?>) {
        this.cacheParams = <set-?>;
    }

    @Override // androidx.compose.ui.unit.Density
    public final void setContentDrawScope$ui_release(ContentDrawScope <set-?>) {
        this.contentDrawScope = <set-?>;
    }

    @Override // androidx.compose.ui.unit.Density
    public final void setDrawResult$ui_release(androidx.compose.ui.draw.DrawResult <set-?>) {
        this.drawResult = <set-?>;
    }

    public final void setGraphicsContextProvider$ui_release(Function0<? extends GraphicsContext> <set-?>) {
        this.graphicsContextProvider = <set-?>;
    }
}
