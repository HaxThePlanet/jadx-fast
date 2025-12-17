package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\u0008\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0087\u0008\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010H\u0086\u0008\u001a\u0015\u0010\u0011\u001a\u00020\u0008*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0008*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u0008H\u0086\u0008\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n¨\u0006\u001c", d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap $this$applyCanvas, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        Canvas canvas = new Canvas($this$applyCanvas);
        block.invoke(canvas);
        return $this$applyCanvas;
    }

    public static final boolean contains(Bitmap $this$contains, Point p) {
        int i2;
        int height;
        int i;
        final int i3 = 0;
        height = p.x;
        final int i4 = 0;
        if (height >= 0 && height < $this$contains.getWidth()) {
            i2 = height < $this$contains.getWidth() ? i : i4;
        } else {
        }
        if (i2 != 0 && p.y >= 0 && p.y < $this$contains.getHeight()) {
            if (p.y >= 0) {
                if (p.y < $this$contains.getHeight()) {
                } else {
                    i = i4;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean contains(Bitmap $this$contains, PointF p) {
        int cmp;
        int i2;
        int i;
        float f;
        final int i3 = 0;
        i = 0;
        if (Float.compare(f2, i) >= 0 && Float.compare(f3, f) < 0 && Float.compare(f4, i) >= 0 && Float.compare(f5, i) < 0) {
            if (Float.compare(f3, f) < 0) {
                if (Float.compare(f4, i) >= 0) {
                    i2 = Float.compare(f5, i) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    public static final Bitmap createBitmap(int width, int height, Bitmap.Config config) {
        final int i = 0;
        return Bitmap.createBitmap(width, height, config);
    }

    public static final Bitmap createBitmap(int width, int height, Bitmap.Config config, boolean hasAlpha, ColorSpace colorSpace) {
        final int i = 0;
        return Bitmap.createBitmap(width, height, config, hasAlpha, colorSpace);
    }

    public static Bitmap createBitmap$default(int width, int height, Bitmap.Config config, int i4, Object object5) {
        Bitmap.Config obj2;
        if (i4 &= 4 != 0) {
            obj2 = Bitmap.Config.ARGB_8888;
        }
        int obj3 = 0;
        return Bitmap.createBitmap(width, height, obj2);
    }

    public static Bitmap createBitmap$default(int width, int height, Bitmap.Config config, boolean hasAlpha, ColorSpace colorSpace, int i6, Object object7) {
        Bitmap.Config obj2;
        int obj3;
        ColorSpace obj4;
        int obj5;
        if (i6 & 4 != 0) {
            obj2 = Bitmap.Config.ARGB_8888;
        }
        if (i6 & 8 != 0) {
            obj3 = 1;
        }
        if (i6 &= 16 != 0) {
            obj4 = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        obj5 = 0;
        return Bitmap.createBitmap(width, height, obj2, obj3, obj4);
    }

    public static final int get(Bitmap $this$get, int x, int y) {
        final int i = 0;
        return $this$get.getPixel(x, y);
    }

    public static final Bitmap scale(Bitmap $this$scale, int width, int height, boolean filter) {
        final int i = 0;
        return Bitmap.createScaledBitmap($this$scale, width, height, filter);
    }

    public static Bitmap scale$default(Bitmap $this$scale_u24default, int width, int height, boolean filter, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        int obj4 = 0;
        return Bitmap.createScaledBitmap($this$scale_u24default, width, height, obj3);
    }

    public static final void set(Bitmap $this$set, int x, int y, int color) {
        final int i = 0;
        $this$set.setPixel(x, y, color);
    }
}
