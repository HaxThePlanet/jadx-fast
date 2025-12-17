package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/* loaded from: classes5.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity = true;
    final Bitmap mBitmap;
    private int mBitmapHeight = -1;
    private final BitmapShader mBitmapShader = null;
    private int mBitmapWidth = -1;
    private float mCornerRadius;
    final Rect mDstRect;
    private final RectF mDstRectF;
    private int mGravity = 119;
    private boolean mIsCircular;
    private final Paint mPaint;
    private final Matrix mShaderMatrix;
    private int mTargetDensity = 160;
    RoundedBitmapDrawable(Resources res, Bitmap bitmap) {
        int densityDpi;
        BitmapShader bitmapShader;
        Bitmap mBitmap;
        Shader.TileMode cLAMP;
        Shader.TileMode cLAMP2;
        super();
        int i = 160;
        int i2 = 119;
        Paint paint = new Paint(3);
        this.mPaint = paint;
        Matrix matrix = new Matrix();
        this.mShaderMatrix = matrix;
        Rect rect = new Rect();
        this.mDstRect = rect;
        RectF rectF = new RectF();
        this.mDstRectF = rectF;
        densityDpi = 1;
        if (res != null) {
            this.mTargetDensity = displayMetrics.densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            computeBitmapSize();
            bitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mBitmapShader = bitmapShader;
        } else {
            int i3 = -1;
            bitmapShader = 0;
        }
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float toCompare) {
        int i;
        i = Float.compare(toCompare, i2) > 0 ? 1 : 0;
        return i;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = (float)i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Object mDstRectF;
        Paint mCornerRadius2;
        int mCornerRadius;
        Paint mPaint;
        final Bitmap mBitmap = this.mBitmap;
        if (mBitmap == null) {
        }
        updateDstRect();
        if (this.mPaint.getShader() == null) {
            canvas.drawBitmap(mBitmap, 0, this.mDstRect, this.mPaint);
        } else {
            canvas.drawRoundRect(this.mDstRectF, this.mCornerRadius, this.mCornerRadius, this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int mIsCircular;
        int greaterThanZero;
        int i;
        int i2;
        if (this.mGravity == 119) {
            if (this.mIsCircular) {
            } else {
                Bitmap mBitmap = this.mBitmap;
                if (mBitmap != null && !mBitmap.hasAlpha() && this.mPaint.getAlpha() >= 255) {
                    if (!mBitmap.hasAlpha()) {
                        if (this.mPaint.getAlpha() >= 255) {
                            if (RoundedBitmapDrawable.isGreaterThanZero(this.mCornerRadius)) {
                            } else {
                                i = -1;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final Paint getPaint() {
        return this.mPaint;
    }

    @Override // android.graphics.drawable.Drawable
    void gravityCompatApply(int gravity, int bitmapWidth, int bitmapHeight, Rect bounds, Rect outRect) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean hasMipMap() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isCircular() {
        return this.mIsCircular;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (this.mIsCircular) {
            updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Paint mPaint;
        if (alpha != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAntiAlias(boolean aa) {
        this.mPaint.setAntiAlias(aa);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setCircular(boolean circular) {
        Paint mPaint;
        BitmapShader mBitmapShader;
        this.mIsCircular = circular;
        this.mApplyGravity = true;
        if (circular) {
            updateCircularCornerRadius();
            this.mPaint.setShader(this.mBitmapShader);
            invalidateSelf();
        } else {
            setCornerRadius(0);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.mPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setCornerRadius(float cornerRadius) {
        Paint mPaint;
        BitmapShader mBitmapShader;
        if (Float.compare(mCornerRadius, cornerRadius) == 0) {
        }
        this.mIsCircular = false;
        if (RoundedBitmapDrawable.isGreaterThanZero(cornerRadius)) {
            this.mPaint.setShader(this.mBitmapShader);
        } else {
            this.mPaint.setShader(0);
        }
        this.mCornerRadius = cornerRadius;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        this.mPaint.setDither(dither);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.mPaint.setFilterBitmap(filter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setGravity(int gravity) {
        int mGravity;
        if (this.mGravity != gravity) {
            this.mGravity = gravity;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setMipMap(boolean mipMap) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTargetDensity(int density) {
        int mTargetDensity;
        int i;
        if (this.mTargetDensity != density) {
            i = density == 0 ? 160 : density;
            this.mTargetDensity = i;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTargetDensity(DisplayMetrics metrics) {
        setTargetDensity(metrics.densityDpi);
    }

    @Override // android.graphics.drawable.Drawable
    void updateDstRect() {
        boolean mIsCircular;
        Object mApplyGravity;
        int i2;
        int mBitmapShader;
        Object obj;
        int i5;
        int i4;
        int i;
        int i3;
        Rect mDstRect2;
        Object obj2;
        int mGravity;
        int mBitmapWidth;
        int mBitmapHeight;
        Rect bounds;
        Rect mDstRect;
        if (this.mApplyGravity) {
            i2 = 0;
            if (this.mIsCircular) {
                i4 = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                obj = this;
                obj.gravityCompatApply(this.mGravity, i4, i4, getBounds(), this.mDstRect);
                mIsCircular = Math.min(obj.mDstRect.width(), obj.mDstRect.height());
                obj.mDstRect.inset(Math.max(i2, i6 /= 2), Math.max(i2, i9 /= 2));
                obj.mCornerRadius = f2 *= i;
            } else {
                obj = this;
                obj.gravityCompatApply(obj.mGravity, obj.mBitmapWidth, obj.mBitmapHeight, getBounds(), obj.mDstRect);
            }
            obj.mDstRectF.set(obj.mDstRect);
            if (obj.mBitmapShader != null) {
                obj.mShaderMatrix.setTranslate(mDstRectF2.left, mDstRectF4.top);
                obj.mShaderMatrix.preScale(width3 /= f, height3 /= i4);
                obj.mBitmapShader.setLocalMatrix(obj.mShaderMatrix);
                obj.mPaint.setShader(obj.mBitmapShader);
            }
            obj.mApplyGravity = i2;
        } else {
            obj = this;
        }
    }
}
