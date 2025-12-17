package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\tH\u0000\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006*\n\u0010\u000c\"\u00020\u00012\u00020\u0001¨\u0006\r", d2 = {"EmptyCanvas", "Landroid/graphics/Canvas;", "nativeCanvas", "Landroidx/compose/ui/graphics/NativeCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "ActualCanvas", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "NativeCanvas", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidCanvas_androidKt {

    private static final Canvas EmptyCanvas;
    static {
        Canvas canvas = new Canvas();
        AndroidCanvas_androidKt.EmptyCanvas = canvas;
    }

    public static final androidx.compose.ui.graphics.Canvas ActualCanvas(androidx.compose.ui.graphics.ImageBitmap image) {
        AndroidCanvas androidCanvas = new AndroidCanvas();
        final int i = 0;
        Canvas canvas = new Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(image));
        androidCanvas.setInternalCanvas(canvas);
        return (Canvas)androidCanvas;
    }

    public static final androidx.compose.ui.graphics.Canvas Canvas(Canvas c) {
        AndroidCanvas androidCanvas = new AndroidCanvas();
        final int i = 0;
        androidCanvas.setInternalCanvas(c);
        return (Canvas)androidCanvas;
    }

    public static final Canvas access$getEmptyCanvas$p() {
        return AndroidCanvas_androidKt.EmptyCanvas;
    }

    public static final Canvas getNativeCanvas(androidx.compose.ui.graphics.Canvas $this$nativeCanvas) {
        Intrinsics.checkNotNull($this$nativeCanvas, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return (AndroidCanvas)$this$nativeCanvas.getInternalCanvas();
    }
}
