package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0001\u0008B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GraphicsLayerPicture", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayerSnapshotV28 implements androidx.compose.ui.graphics.layer.LayerSnapshotImpl {

    public static final androidx.compose.ui.graphics.layer.LayerSnapshotV28 INSTANCE;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0008H\u0016J\u0008\u0010\u000f\u001a\u00020\rH\u0016J\u0008\u0010\u0010\u001a\u00020\nH\u0016J\u0008\u0010\u0011\u001a\u00020\nH\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28$GraphicsLayerPicture;", "Landroid/graphics/Picture;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "beginRecording", "Landroid/graphics/Canvas;", "width", "", "height", "draw", "", "canvas", "endRecording", "getHeight", "getWidth", "requiresHardwareAcceleration", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class GraphicsLayerPicture extends Picture {

        private final androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer;
        public GraphicsLayerPicture(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer) {
            super();
            this.graphicsLayer = graphicsLayer;
        }

        @Override // android.graphics.Picture
        public Canvas beginRecording(int width, int height) {
            Canvas canvas = new Canvas();
            return canvas;
        }

        @Override // android.graphics.Picture
        public void draw(Canvas canvas) {
            this.graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(canvas), 0);
        }

        @Override // android.graphics.Picture
        public void endRecording() {
        }

        @Override // android.graphics.Picture
        public final androidx.compose.ui.graphics.layer.GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // android.graphics.Picture
        public int getHeight() {
            return IntSize.getHeight-impl(this.graphicsLayer.getSize-YbymL2g());
        }

        @Override // android.graphics.Picture
        public int getWidth() {
            return IntSize.getWidth-impl(this.graphicsLayer.getSize-YbymL2g());
        }

        @Override // android.graphics.Picture
        public boolean requiresHardwareAcceleration() {
            return 1;
        }
    }
    static {
        LayerSnapshotV28 layerSnapshotV28 = new LayerSnapshotV28();
        LayerSnapshotV28.INSTANCE = layerSnapshotV28;
    }

    public Object toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer, Continuation<? super Bitmap> $completion) {
        LayerSnapshotV28.GraphicsLayerPicture graphicsLayerPicture = new LayerSnapshotV28.GraphicsLayerPicture(graphicsLayer);
        return Bitmap.createBitmap((Picture)graphicsLayerPicture);
    }
}
