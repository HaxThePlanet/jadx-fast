package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/text/selection/HandleImageCache;", "", "()V", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "setCanvasDrawScope", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setImageBitmap", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HandleImageCache {

    public static final androidx.compose.foundation.text.selection.HandleImageCache INSTANCE;
    private static Canvas canvas;
    private static CanvasDrawScope canvasDrawScope;
    private static ImageBitmap imageBitmap;
    static {
        HandleImageCache handleImageCache = new HandleImageCache();
        HandleImageCache.INSTANCE = handleImageCache;
    }

    public final Canvas getCanvas() {
        return HandleImageCache.canvas;
    }

    public final CanvasDrawScope getCanvasDrawScope() {
        return HandleImageCache.canvasDrawScope;
    }

    public final ImageBitmap getImageBitmap() {
        return HandleImageCache.imageBitmap;
    }

    public final void setCanvas(Canvas <set-?>) {
        HandleImageCache.canvas = <set-?>;
    }

    public final void setCanvasDrawScope(CanvasDrawScope <set-?>) {
        HandleImageCache.canvasDrawScope = <set-?>;
    }

    public final void setImageBitmap(ImageBitmap <set-?>) {
        HandleImageCache.imageBitmap = <set-?>;
    }
}
