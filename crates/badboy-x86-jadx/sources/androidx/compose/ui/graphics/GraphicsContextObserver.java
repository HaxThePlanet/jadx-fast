package androidx.compose.ui.graphics;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\nH\u0016J\u0008\u0010\u000c\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Landroidx/compose/ui/graphics/GraphicsContextObserver;", "Landroidx/compose/runtime/RememberObserver;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/ui/graphics/GraphicsContext;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "onAbandoned", "", "onForgotten", "onRemembered", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class GraphicsContextObserver implements RememberObserver {

    private final androidx.compose.ui.graphics.GraphicsContext graphicsContext;
    private final GraphicsLayer graphicsLayer;
    public GraphicsContextObserver(androidx.compose.ui.graphics.GraphicsContext graphicsContext) {
        super();
        this.graphicsContext = graphicsContext;
        this.graphicsLayer = this.graphicsContext.createGraphicsLayer();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final GraphicsLayer getGraphicsLayer() {
        return this.graphicsLayer;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        this.graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
