package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.util.Pair;

/* loaded from: classes5.dex */
public final class PaintCompat {

    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "󟿽";
    private static final java.lang.ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal;

    static class Api23Impl {
        static boolean hasGlyph(Paint paint, String string) {
            return paint.hasGlyph(string);
        }
    }

    static class Api29Impl {
        static void setBlendMode(Paint paint, Object blendmode) {
            paint.setBlendMode((BlendMode)blendmode);
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        PaintCompat.sRectThreadLocal = threadLocal;
    }

    public static boolean hasGlyph(Paint paint, String string) {
        return PaintCompat.Api23Impl.hasGlyph(paint, string);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        Object rects;
        Object sRectThreadLocal;
        Rect rect2;
        Rect rect;
        rects = PaintCompat.sRectThreadLocal.get();
        if ((Pair)rects == null) {
            rect2 = new Rect();
            rect = new Rect();
            Pair pair = new Pair(rect2, rect);
            PaintCompat.sRectThreadLocal.set(pair);
        } else {
            (Rect)rects.first.setEmpty();
            (Rect)rects.second.setEmpty();
        }
        return rects;
    }

    public static boolean setBlendMode(Paint paint, androidx.core.graphics.BlendModeCompat blendMode) {
        Object blendModeFromCompat;
        if (blendMode != null) {
            blendModeFromCompat = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(blendMode);
        } else {
            blendModeFromCompat = 0;
        }
        PaintCompat.Api29Impl.setBlendMode(paint, blendModeFromCompat);
        return 1;
    }
}
