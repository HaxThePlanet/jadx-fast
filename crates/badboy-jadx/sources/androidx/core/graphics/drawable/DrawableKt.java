package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0003\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0003\u0010\u0005\u001a\u00020\u00042\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\u0008\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0008\u0008\u0003\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0003\u0010\u0005\u001a\u00020\u00042\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\u0008\u0008\u0003\u0010\u000b\u001a\u00020\u00042\u0008\u0008\u0003\u0010\u000c\u001a\u00020\u00042\u0008\u0008\u0003\u0010\r\u001a\u00020\u00042\u0008\u0008\u0003\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f", d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable $this$toBitmap, int width, int height, Bitmap.Config config) {
        boolean bitmap;
        int height2;
        Bitmap.Config config2;
        if ($this$toBitmap instanceof BitmapDrawable) {
            if ((BitmapDrawable)$this$toBitmap.getBitmap() == null) {
            } else {
                if (config != null) {
                    if ((BitmapDrawable)$this$toBitmap.getBitmap().getConfig() == config && width == (BitmapDrawable)$this$toBitmap.getBitmap().getWidth() && height == (BitmapDrawable)$this$toBitmap.getBitmap().getHeight()) {
                        if (width == (BitmapDrawable)$this$toBitmap.getBitmap().getWidth()) {
                            if (height == (BitmapDrawable)$this$toBitmap.getBitmap().getHeight()) {
                                return (BitmapDrawable)$this$toBitmap.getBitmap();
                            }
                        }
                    }
                } else {
                }
                return Bitmap.createScaledBitmap((BitmapDrawable)$this$toBitmap.getBitmap(), width, height, true);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bitmap is null");
            throw illegalArgumentException;
        }
        android.graphics.Rect bounds = $this$toBitmap.getBounds();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        config2 = config == null ? Bitmap.Config.ARGB_8888 : config;
        Bitmap bitmap7 = Bitmap.createBitmap(width, height, config2);
        int i6 = 0;
        $this$toBitmap.setBounds(i6, i6, width, height);
        Canvas canvas = new Canvas(bitmap7);
        $this$toBitmap.draw(canvas);
        $this$toBitmap.setBounds(rect.left, rect2.top, rect3.right, bounds.bottom);
        return bitmap7;
    }

    public static Bitmap toBitmap$default(Drawable drawable, int i2, int i3, Bitmap.Config bitmap$Config4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = drawable.getIntrinsicWidth();
        }
        if (i5 & 2 != 0) {
            obj2 = drawable.getIntrinsicHeight();
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return DrawableKt.toBitmap(drawable, obj1, obj2, obj3);
    }

    public static final Bitmap toBitmapOrNull(Drawable $this$toBitmapOrNull, int width, int height, Bitmap.Config config) {
        boolean bitmap;
        if ($this$toBitmapOrNull instanceof BitmapDrawable && (BitmapDrawable)$this$toBitmapOrNull.getBitmap() == null) {
            if ((BitmapDrawable)$this$toBitmapOrNull.getBitmap() == null) {
                return null;
            }
        }
        return DrawableKt.toBitmap($this$toBitmapOrNull, width, height, config);
    }

    public static Bitmap toBitmapOrNull$default(Drawable drawable, int i2, int i3, Bitmap.Config bitmap$Config4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = drawable.getIntrinsicWidth();
        }
        if (i5 & 2 != 0) {
            obj2 = drawable.getIntrinsicHeight();
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return DrawableKt.toBitmapOrNull(drawable, obj1, obj2, obj3);
    }

    public static final void updateBounds(Drawable $this$updateBounds, int left, int top, int right, int bottom) {
        $this$updateBounds.setBounds(left, top, right, bottom);
    }

    public static void updateBounds$default(Drawable drawable, int i2, int i3, int i4, int i5, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = obj1.left;
        }
        if (i6 & 2 != 0) {
            obj2 = obj2.top;
        }
        if (i6 & 4 != 0) {
            obj3 = obj3.right;
        }
        if (i6 &= 8 != 0) {
            obj4 = obj4.bottom;
        }
        DrawableKt.updateBounds(drawable, obj1, obj2, obj3, obj4);
    }
}
