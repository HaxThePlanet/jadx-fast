package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B&\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0002J\u0008\u0010(\u001a\u00020)H\u0016J\u0008\u0010*\u001a\u00020)H\u0016J\u0008\u0010+\u001a\u00020)H\u0016J\u0008\u0010,\u001a\u00020)H\u0016J\u000c\u0010-\u001a\u00020)*\u00020'H\u0016RF\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\n2\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u001a\u0010!\u001a\u00020\"8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008#\u0010$\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006.", d2 = {"Landroidx/compose/ui/draw/CacheDrawModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "cacheDrawScope", "Landroidx/compose/ui/draw/CacheDrawScope;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/draw/CacheDrawScope;Lkotlin/jvm/functions/Function1;)V", "value", "getBlock", "()Lkotlin/jvm/functions/Function1;", "setBlock", "(Lkotlin/jvm/functions/Function1;)V", "cachedGraphicsContext", "Landroidx/compose/ui/draw/ScopedGraphicsContext;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "isCacheValid", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "getOrBuildCachedDrawBlock", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invalidateDrawCache", "", "onDetach", "onMeasureResultChanged", "onObservedReadsChanged", "draw", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CacheDrawModifierNodeImpl extends Modifier.Node implements androidx.compose.ui.draw.CacheDrawModifierNode, ObserverModifierNode, androidx.compose.ui.draw.BuildDrawCacheParams {

    private Function1<? super androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.draw.DrawResult> block;
    private final androidx.compose.ui.draw.CacheDrawScope cacheDrawScope;
    private androidx.compose.ui.draw.ScopedGraphicsContext cachedGraphicsContext;
    private boolean isCacheValid;
    public CacheDrawModifierNodeImpl(androidx.compose.ui.draw.CacheDrawScope cacheDrawScope, Function1<? super androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.draw.DrawResult> block) {
        super();
        this.cacheDrawScope = cacheDrawScope;
        this.block = block;
        this.cacheDrawScope.setCacheParams$ui_release((BuildDrawCacheParams)this);
        CacheDrawModifierNodeImpl.1 anon = new CacheDrawModifierNodeImpl.1(this);
        this.cacheDrawScope.setGraphicsContextProvider$ui_release((Function0)anon);
    }

    private final androidx.compose.ui.draw.DrawResult getOrBuildCachedDrawBlock(ContentDrawScope contentDrawScope) {
        boolean isCacheValid;
        int i;
        androidx.compose.ui.draw.DrawResult drawResult$ui_release;
        int i2;
        if (!this.isCacheValid) {
            androidx.compose.ui.draw.CacheDrawScope cacheDrawScope = this.cacheDrawScope;
            i = 0;
            cacheDrawScope.setDrawResult$ui_release(0);
            cacheDrawScope.setContentDrawScope$ui_release(contentDrawScope);
            CacheDrawModifierNodeImpl.getOrBuildCachedDrawBlock.1.1 anon = new CacheDrawModifierNodeImpl.getOrBuildCachedDrawBlock.1.1(this, cacheDrawScope);
            ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
            i2 = 0;
            if (cacheDrawScope.getDrawResult$ui_release() == null) {
            } else {
                this.isCacheValid = true;
            }
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("DrawResult not defined, did you forget to call onDraw?");
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        androidx.compose.ui.draw.DrawResult drawResult$ui_release2 = this.cacheDrawScope.getDrawResult$ui_release();
        Intrinsics.checkNotNull(drawResult$ui_release2);
        return drawResult$ui_release2;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        getOrBuildCachedDrawBlock($this$draw).getBlock$ui_release().invoke($this$draw);
    }

    public final Function1<androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.draw.DrawResult> getBlock() {
        return this.block;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Density getDensity() {
        return DelegatableNodeKt.requireDensity((DelegatableNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final GraphicsContext getGraphicsContext() {
        androidx.compose.ui.draw.ScopedGraphicsContext localGraphicsContext;
        androidx.compose.ui.draw.ScopedGraphicsContext scopedGraphicsContext;
        GraphicsContext requireGraphicsContext;
        androidx.compose.ui.draw.ScopedGraphicsContext context;
        int i;
        if (this.cachedGraphicsContext == null) {
            scopedGraphicsContext = new ScopedGraphicsContext();
            i = 0;
            this.cachedGraphicsContext = scopedGraphicsContext;
            localGraphicsContext = scopedGraphicsContext;
        }
        if (localGraphicsContext.getGraphicsContext() == null) {
            localGraphicsContext.setGraphicsContext(DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this));
        }
        return (GraphicsContext)localGraphicsContext;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutDirection((DelegatableNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public long getSize-NH-jbRc() {
        int i = 0;
        int $i$f$getLayoutAwareOLwlOKw = NodeKind.constructor-impl(128);
        return IntSizeKt.toSize-ozmzZPI(DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)this, $i$f$getLayoutAwareOLwlOKw).getSize-YbymL2g());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void invalidateDrawCache() {
        androidx.compose.ui.draw.ScopedGraphicsContext cachedGraphicsContext = this.cachedGraphicsContext;
        if (cachedGraphicsContext != null) {
            cachedGraphicsContext.releaseGraphicsLayers();
        }
        this.isCacheValid = false;
        this.cacheDrawScope.setDrawResult$ui_release(0);
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        super.onDetach();
        final androidx.compose.ui.draw.ScopedGraphicsContext cachedGraphicsContext = this.cachedGraphicsContext;
        if (cachedGraphicsContext != null) {
            cachedGraphicsContext.releaseGraphicsLayers();
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onMeasureResultChanged() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onObservedReadsChanged() {
        invalidateDrawCache();
    }

    public final void setBlock(Function1<? super androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.draw.DrawResult> value) {
        this.block = value;
        invalidateDrawCache();
    }
}
