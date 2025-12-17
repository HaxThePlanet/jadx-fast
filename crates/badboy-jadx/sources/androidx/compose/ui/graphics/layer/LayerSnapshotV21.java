package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV21;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayerSnapshotV21 implements androidx.compose.ui.graphics.layer.LayerSnapshotImpl {

    public static final androidx.compose.ui.graphics.layer.LayerSnapshotV21 INSTANCE;
    static {
        LayerSnapshotV21 layerSnapshotV21 = new LayerSnapshotV21();
        LayerSnapshotV21.INSTANCE = layerSnapshotV21;
    }

    public Object toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer, Continuation<? super Bitmap> $completion) {
        final long size-YbymL2g = graphicsLayer.getSize-YbymL2g();
        Bitmap bitmap = Bitmap.createBitmap(IntSize.getWidth-impl(size-YbymL2g), IntSize.getHeight-impl(size-YbymL2g), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(canvas), 0);
        return bitmap;
    }
}
