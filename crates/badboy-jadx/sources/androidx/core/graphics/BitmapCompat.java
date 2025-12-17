package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Build.VERSION;
import androidx.annotation.ReplaceWith;

/* loaded from: classes5.dex */
public final class BitmapCompat {

    static class Api27Impl {
        static Bitmap copyBitmapIfHardware(Bitmap bm) {
            Bitmap.Config newConfig;
            newConfig = Bitmap.Config.ARGB_8888;
            if (bm.getConfig() == Bitmap.Config.HARDWARE && Build.VERSION.SDK_INT >= 31) {
                newConfig = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    newConfig = BitmapCompat.Api31Impl.getHardwareBitmapConfig(bm);
                }
                return bm.copy(newConfig, true);
            }
            return bm;
        }

        static Bitmap createBitmapWithSourceColorspace(int w, int h, Bitmap src, boolean linear) {
            Bitmap.Config config;
            ColorSpace colorSpace;
            boolean sDK_INT;
            Bitmap.Config hARDWARE;
            config = src.getConfig();
            colorSpace = src.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (linear && !src.getColorSpace().equals(colorSpace2)) {
                if (!src.getColorSpace().equals(colorSpace2)) {
                    config = Bitmap.Config.RGBA_F16;
                    colorSpace = colorSpace2;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                    if (src.getConfig() == Bitmap.Config.HARDWARE && Build.VERSION.SDK_INT >= 31) {
                        config = Bitmap.Config.ARGB_8888;
                        if (Build.VERSION.SDK_INT >= 31) {
                            config = BitmapCompat.Api31Impl.getHardwareBitmapConfig(src);
                        }
                    }
                }
            } else {
            }
            return Bitmap.createBitmap(w, h, config, src.hasAlpha(), colorSpace);
        }

        static boolean isAlreadyF16AndLinear(Bitmap b) {
            Bitmap.Config config;
            int i;
            if (b.getConfig() == Bitmap.Config.RGBA_F16 && b.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB))) {
                i = b.getColorSpace().equals(colorSpace) ? 1 : 0;
            } else {
            }
            return i;
        }
    }

    static class Api29Impl {
        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        static Bitmap.Config getHardwareBitmapConfig(Bitmap bm) {
            if (bm.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
    public static Bitmap createScaledBitmap(Bitmap srcBm, int dstW, int dstH, Rect srcRect, boolean scaleInLinearSpace) {
        int canvas2;
        int i7;
        int linear;
        int i2;
        Object canvas;
        int bottom;
        Bitmap src;
        int height3;
        int width;
        int height;
        int sx;
        int sy;
        int srcX2;
        int dst3;
        int i;
        int left;
        Paint dst2;
        int srcY;
        int srcY2;
        int i6;
        int stepsX;
        int stepsY;
        int height2;
        double d;
        double sizeAtStep2;
        int sx2;
        int sizeAtStep;
        int srcX;
        int i5;
        int totalStepsY;
        int totalStepsY2;
        int dst;
        int needFinalConversion;
        int allocW;
        Paint allocH;
        int i10;
        int i3;
        boolean alreadyF16AndLinear;
        int i4;
        int i8;
        int i9;
        final Bitmap bitmap = srcBm;
        canvas2 = dstW;
        linear = dstH;
        canvas = srcRect;
        if (canvas2 <= 0) {
        } else {
            if (linear <= 0) {
            } else {
                if (canvas != null) {
                    if (canvas.isEmpty()) {
                    } else {
                        if (canvas.left < 0) {
                        } else {
                            if (canvas.right > bitmap.getWidth()) {
                            } else {
                                if (canvas.top < 0) {
                                } else {
                                    if (canvas.bottom > bitmap.getHeight()) {
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("srcRect must be contained by srcBm!");
                    throw illegalArgumentException2;
                }
                Bitmap bitmap3 = srcBm;
                src = BitmapCompat.Api27Impl.copyBitmapIfHardware(bitmap);
                if (canvas != null) {
                    width = canvas.width();
                } else {
                    width = bitmap.getWidth();
                }
                if (canvas != null) {
                    height = canvas.height();
                } else {
                    height = bitmap.getHeight();
                }
                f /= f2;
                f3 /= f5;
                left = canvas != null ? canvas.left : 0;
                srcY = canvas != null ? canvas.top : 0;
                int i16 = 1;
                if (left == 0 && srcY == 0 && canvas2 == bitmap.getWidth() && linear == bitmap.getHeight() && bitmap.isMutable() && bitmap == src) {
                    if (srcY == 0) {
                        if (canvas2 == bitmap.getWidth()) {
                            if (linear == bitmap.getHeight()) {
                                if (bitmap.isMutable()) {
                                    if (bitmap == src) {
                                        return bitmap.copy(bitmap.getConfig(), i16);
                                    }
                                }
                                return src;
                            }
                        }
                    }
                }
                Paint paint = new Paint(i16);
                paint.setFilterBitmap(i16);
                BitmapCompat.Api29Impl.setPaintBlendMode(paint);
                if (width == canvas2 && height == linear) {
                    if (height == linear) {
                        Bitmap bitmap4 = Bitmap.createBitmap(canvas2, linear, src.getConfig());
                        Canvas canvas3 = new Canvas(bitmap4);
                        canvas3.drawBitmap(src, (float)i20, (float)i21, paint);
                        return bitmap4;
                    }
                }
                d = Math.log(4611686018427387904L);
                int i22 = 1065353216;
                if (Float.compare(i12, i22) > 0) {
                    srcX = left;
                    i = (int)ceil;
                } else {
                    srcX = left;
                    i = (int)floor;
                }
                if (Float.compare(i13, i22) > 0) {
                    dst2 = paint;
                    stepsY = (int)ceil2;
                } else {
                    dst2 = paint;
                    stepsY = (int)floor2;
                }
                int i19 = i;
                int i24 = stepsY;
                dst = 0;
                needFinalConversion = 0;
                if (scaleInLinearSpace) {
                    if (!BitmapCompat.Api27Impl.isAlreadyF16AndLinear(bitmap)) {
                        if (i > 0) {
                            sizeAtStep = BitmapCompat.sizeAtStep(width, canvas2, 1, i19);
                        } else {
                            i2 = 1;
                            sizeAtStep = width;
                        }
                        if (stepsY > 0) {
                            sx2 = i12;
                            totalStepsY2 = BitmapCompat.sizeAtStep(height, linear, i2, i24);
                        } else {
                            sx2 = i12;
                            sx = i24;
                            totalStepsY2 = height;
                        }
                        totalStepsY = i13;
                        int sy2 = i25;
                        allocW = i;
                        int stepsX2 = i26;
                        Bitmap bitmapWithSourceColorspace = BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(sy2, stepsX2, bitmap, i2);
                        canvas = new Canvas(bitmapWithSourceColorspace);
                        i10 = sy2;
                        int allocW2 = srcX;
                        srcX = stepsX2;
                        i3 = allocW2;
                        canvas.drawBitmap(src, (float)allocH3, (float)srcX3, dst2);
                        sy = 0;
                        srcY = 0;
                        dst = src;
                        src = i;
                        needFinalConversion = 1;
                    } else {
                        sx2 = i12;
                        allocW = i;
                        i3 = srcX;
                        sx = i24;
                        totalStepsY = i13;
                        sy = i3;
                    }
                } else {
                    sx2 = i12;
                    allocW = i;
                    i3 = srcX;
                    sx = i24;
                    totalStepsY = i13;
                }
                Rect rect = new Rect(sy, srcY, width, height);
                Rect rect2 = new Rect();
                int i23 = sy;
                srcX2 = dst;
                while (allocW == 0) {
                    if (stepsY != 0) {
                    }
                    if (allocW < 0) {
                    } else {
                    }
                    if (allocW > 0) {
                    } else {
                    }
                    dst = srcY;
                    srcY2 = allocW;
                    if (stepsY < 0) {
                    } else {
                    }
                    if (stepsY > 0) {
                    }
                    i10 = srcY2;
                    stepsX = 0;
                    rect2.set(stepsX, stepsX, BitmapCompat.sizeAtStep(width, canvas2, srcY2, i19), BitmapCompat.sizeAtStep(height, linear, stepsY, sx));
                    if (i10 == 0 && stepsY == 0) {
                    } else {
                    }
                    i5 = stepsX;
                    if (srcX2 != 0 && srcX2.getWidth() == canvas2 && srcX2.getHeight() == linear) {
                    } else {
                    }
                    i6 = 0;
                    if (srcX2 != 0 && srcX2 != bitmap) {
                    } else {
                    }
                    if (srcX2 != bitmap) {
                    }
                    alreadyF16AndLinear = needFinalConversion;
                    i4 = srcX2;
                    if (i10 > 0) {
                    } else {
                    }
                    dst3 = i10;
                    if (stepsY > 0) {
                    } else {
                    }
                    i7 = stepsY;
                    if (scaleInLinearSpace && i5 == 0) {
                    } else {
                    }
                    i8 = 0;
                    srcX2 = linear;
                    Canvas allocH2 = new Canvas(srcX2);
                    allocH2.drawBitmap(src, rect, rect2, dst2);
                    src = srcX2;
                    srcX2 = bitmap2;
                    rect.set(rect2);
                    canvas2 = dstW;
                    linear = dstH;
                    srcY = dst;
                    d = d10;
                    allocW = i10;
                    if (i5 == 0) {
                    } else {
                    }
                    i8 = 1;
                    i7 = alreadyF16AndLinear;
                    dst3 = alreadyF16AndLinear;
                    if (srcX2 != 0) {
                    }
                    srcX2.recycle();
                    if (srcX2 != bitmap) {
                    } else {
                    }
                    if (scaleInLinearSpace) {
                    } else {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    } else {
                    }
                    if (needFinalConversion != 0 && srcX2 != bitmap && srcX2 != 0) {
                    }
                    if (BitmapCompat.Api27Impl.isAlreadyF16AndLinear(srcX2)) {
                    } else {
                    }
                    if (srcX2.getWidth() == canvas2) {
                    } else {
                    }
                    if (srcX2.getHeight() == linear) {
                    } else {
                    }
                    i6 = 1;
                    if (stepsY == 0) {
                    } else {
                    }
                    i5 = 1;
                    stepsY--;
                    stepsY++;
                    dst = srcY;
                    srcY2 = allocW;
                    dst = srcY;
                    srcY2 = allocW;
                }
                if (srcX2 != bitmap && srcX2 != 0) {
                    if (srcX2 != 0) {
                        srcX2.recycle();
                    }
                }
                return src;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dstW and dstH must be > 0!");
        throw illegalArgumentException;
    }

    @ReplaceWith(expression = "bitmap.getAllocationByteCount()")
    @Deprecated
    public static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    @ReplaceWith(expression = "bitmap.hasMipMap()")
    @Deprecated
    public static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    @ReplaceWith(expression = "bitmap.setHasMipMap(hasMipMap)")
    @Deprecated
    public static void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
        bitmap.setHasMipMap(hasMipMap);
    }

    static int sizeAtStep(int srcSize, int dstSize, int step, int totalSteps) {
        if (step == 0) {
            return dstSize;
        }
        int i = 1;
        if (step > 0) {
            return i2 *= srcSize;
        }
        return dstSize << i7;
    }
}
