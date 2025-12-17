package androidx.compose.ui.draw;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000c\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b¨\u0006\u0011", d2 = {"Landroidx/compose/ui/draw/ScopedGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "()V", "allocatedGraphicsLayers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "value", "graphicsContext", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "setGraphicsContext", "(Landroidx/compose/ui/graphics/GraphicsContext;)V", "createGraphicsLayer", "releaseGraphicsLayer", "", "layer", "releaseGraphicsLayers", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScopedGraphicsContext implements GraphicsContext {

    private MutableObjectList<GraphicsLayer> allocatedGraphicsLayers;
    private GraphicsContext graphicsContext;
    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer createGraphicsLayer() {
        int i;
        String mutableObjectListOf;
        int i2;
        final GraphicsContext graphicsContext = this.graphicsContext;
        i = graphicsContext != null ? 1 : 0;
        int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("GraphicsContext not provided");
        }
        GraphicsLayer graphicsLayer = graphicsContext.createGraphicsLayer();
        MutableObjectList allocatedGraphicsLayers = this.allocatedGraphicsLayers;
        if (allocatedGraphicsLayers == null) {
            i2 = 0;
            this.allocatedGraphicsLayers = ObjectListKt.mutableObjectListOf(graphicsLayer);
        } else {
            allocatedGraphicsLayers.add(graphicsLayer);
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void releaseGraphicsLayer(GraphicsLayer layer) {
        final GraphicsContext graphicsContext = this.graphicsContext;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(layer);
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final void releaseGraphicsLayers() {
        int i;
        MutableObjectList list;
        int i2;
        Object[] content;
        int i$iv;
        int _size;
        Object obj;
        int i3;
        final MutableObjectList allocatedGraphicsLayers = this.allocatedGraphicsLayers;
        if (allocatedGraphicsLayers != null) {
            i = 0;
            list = allocatedGraphicsLayers;
            i2 = 0;
            i$iv = 0;
            while (i$iv < list._size) {
                i3 = 0;
                releaseGraphicsLayer((GraphicsLayer)list.content[i$iv]);
                i$iv++;
            }
            allocatedGraphicsLayers.clear();
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final void setGraphicsContext(GraphicsContext value) {
        releaseGraphicsLayers();
        this.graphicsContext = value;
    }
}
