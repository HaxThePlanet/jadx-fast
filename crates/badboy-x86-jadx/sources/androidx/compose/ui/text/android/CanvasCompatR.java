package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u000cH\u0007¨\u0006\u0010", d2 = {"Landroidx/compose/ui/text/android/CanvasCompatR;", "", "()V", "quickReject", "", "canvas", "Landroid/graphics/Canvas;", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CanvasCompatR {

    public static final androidx.compose.ui.text.android.CanvasCompatR INSTANCE;
    static {
        CanvasCompatR canvasCompatR = new CanvasCompatR();
        CanvasCompatR.INSTANCE = canvasCompatR;
    }

    public final boolean quickReject(Canvas canvas, float left, float top, float right, float bottom) {
        return canvas.quickReject(left, top, right, bottom);
    }

    public final boolean quickReject(Canvas canvas, Path path) {
        return canvas.quickReject(path);
    }

    public final boolean quickReject(Canvas canvas, RectF rect) {
        return canvas.quickReject(rect);
    }
}
