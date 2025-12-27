package app.dogo.com.dogo_android.util.customview.shimmer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ShimmerDrawable.kt */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u0018J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001cH\u0016J\u0012\u0010'\u001a\u00020\u00182\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0008\u0010,\u001a\u00020\u0018H\u0002J\u0008\u0010-\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/ShimmerDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "isShimmerStarted", "", "()Z", "mDrawRect", "Landroid/graphics/Rect;", "mShaderMatrix", "Landroid/graphics/Matrix;", "mShimmer", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "mShimmerPaint", "Landroid/graphics/Paint;", "mUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mValueAnimator", "Landroid/animation/ValueAnimator;", "shimmer", "getShimmer", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "setShimmer", "(Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "maybeStartShimmer", "offset", "", "start", "end", "percent", "onBoundsChange", "bounds", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "startShimmer", "stopShimmer", "updateShader", "updateValueAnimator", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class ShimmerDrawable extends Drawable {

    private final ValueAnimator.AnimatorUpdateListener a = new a();
    /* renamed from: b, reason: from kotlin metadata */
    private final Paint mDrawRect = new Paint();
    /* renamed from: c, reason: from kotlin metadata */
    private final Rect mShaderMatrix = new Rect();
    /* renamed from: d, reason: from kotlin metadata */
    private final Matrix mShimmer = new Matrix();
    /* renamed from: e, reason: from kotlin metadata */
    private ValueAnimator mShimmerPaint;
    /* renamed from: f, reason: from kotlin metadata */
    private b mUpdateListener;
    public c() {
        super();
        app.dogo.com.dogo_android.util.customview.shimmer.a aVar = new a(this);
        Rect rect = new Rect();
        Matrix matrix = new Matrix();
        new Paint().setAntiAlias(true);
    }

    private static final void d(c cVar, ValueAnimator valueAnimator) {
        n.f(cVar, "this$0");
        cVar.invalidateSelf();
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final void getOpacity() {
        int width;
        LinearGradient linearGradient;
        float f = 0;
        float f2 = 0;
        float f3 = 0;
        float f4;
        int[] iArr;
        float[] fArr;
        Shader.TileMode cLAMP2;
        Object obj;
        RadialGradient radialGradient;
        float f5;
        float f6;
        float f7;
        int[] iArr2;
        float[] fArr2;
        Shader.TileMode cLAMP22;
        final Object obj2 = this;
        Rect bounds = getBounds();
        n.e(bounds, "bounds");
        width = bounds.width();
        int height = bounds.height();
    }

    private final void j() {
        boolean started;
        if (this.mUpdateListener == null) {
            return;
        }
        int i = 0;
        if (this.mShimmerPaint != null) {
            n.d(this.mShimmerPaint);
            started = this.mShimmerPaint.isStarted();
            n.d(this.mShimmerPaint);
            this.mShimmerPaint.cancel();
            n.d(this.mShimmerPaint);
            this.mShimmerPaint.removeAllUpdateListeners();
        } else {
        }
        float[] fArr = new float[2];
        float f = 1f;
        n.d(this.mUpdateListener);
        n.d(this.mUpdateListener);
        ValueAnimator _float = ValueAnimator.ofFloat(new float[] { 0, (float)(this.mUpdateListener.p() / this.mUpdateListener.b()) + f });
        n.d(this.mUpdateListener);
        _float.setRepeatMode(this.mUpdateListener.q());
        n.d(this.mUpdateListener);
        _float.setStartDelay(this.mUpdateListener.s());
        n.d(this.mUpdateListener);
        _float.setRepeatCount(this.mUpdateListener.o());
        n.d(this.mUpdateListener);
        n.d(this.mUpdateListener);
        _float.setDuration(this.mUpdateListener.b() + this.mUpdateListener.p());
        _float.setInterpolator(new LinearInterpolator());
        _float.addUpdateListener(this.a);
        if (this.mUpdateListener != null) {
            _float.start();
        }
        this.mShimmerPaint = _float;
    }

    @Override // android.graphics.drawable.Drawable
    public final b a() {
        return this.mUpdateListener;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean b() {
        boolean z = false;
        if (this.mShimmerPaint != null) {
            n.d(this.mShimmerPaint);
            int r0 = this.mShimmerPaint.isStarted() ? 1 : 0;
        }
        return (this.mShimmerPaint.isStarted() ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float value;
        float offset;
        int i;
        int i2;
        int i3 = 3;
        n.f(canvas, "canvas");
        if (this.mUpdateListener != null) {
            if (this.mDrawRect.getShader() != null) {
                n.d(this.mUpdateListener);
                float f7 = (float)Math.tan(Math.toRadians((double)this.mUpdateListener.t()));
                float f10 = (float)this.mShaderMatrix.height() + (float)this.mShaderMatrix.width() * f7;
                f2 = (float)this.mShaderMatrix.width() + (f7 * (float)this.mShaderMatrix.height());
                i = 0;
                if (this.mShimmerPaint != null) {
                    n.d(this.mShimmerPaint);
                    Object animatedValue = this.mShimmerPaint.getAnimatedValue();
                    str = "null cannot be cast to non-null type kotlin.Float";
                    Objects.requireNonNull(animatedValue, str);
                    value = animatedValue.floatValue();
                } else {
                }
                n.d(this.mUpdateListener);
                int i6 = this.mUpdateListener.g();
                if (i6 == 0) {
                    i2 = -f2;
                    offset = offset(i2, f2, value);
                } else {
                    i3 = 1;
                    if (i6 == 1) {
                        float offset2 = offset(-f10, f10, value);
                    } else {
                        i3 = 2;
                        if (i6 == 2) {
                            i2 = -f2;
                            offset = offset(f2, i2, value);
                        } else {
                            i3 = 3;
                            if (i6 != 3) {
                                i2 = -f2;
                                offset = offset(i2, f2, value);
                            } else {
                                float offset3 = offset(f10, -f10, value);
                            }
                        }
                    }
                }
                this.mShimmer.reset();
                n.d(this.mUpdateListener);
                float f4 = 2f;
                f3 = (float)this.mShaderMatrix.width() / f4;
                f5 = (float)this.mShaderMatrix.height() / f4;
                this.mShimmer.setRotate(this.mUpdateListener.t(), f3, f5);
                this.mShimmer.postTranslate(offset, i);
                this.mDrawRect.getShader().setLocalMatrix(this.mShimmer);
                canvas.drawRect(this.mShaderMatrix, this.mDrawRect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void e() {
        if (this.mShimmerPaint != null) {
            n.d(this.mShimmerPaint);
            if (!this.mShimmerPaint.isStarted() && this.mUpdateListener != null) {
                n.d(this.mUpdateListener);
                if (this.mUpdateListener.c() && this.getCallback() != null) {
                    n.d(this.mShimmerPaint);
                    this.mShimmerPaint.start();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: g, reason: from kotlin metadata */
    public final void onBoundsChange(b bounds) {
        PorterDuff.Mode sRC_IN2;
        this.mUpdateListener = bounds;
        if (bounds != null) {
            n.d(this.mUpdateListener);
            PorterDuff.Mode r1 = this.mUpdateListener.a() ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN;
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode((this.mUpdateListener.a() ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
            this.mDrawRect.setXfermode(porterDuffXfermode);
        }
        getOpacity();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i = -3;
        if (this.mUpdateListener != null) {
            n.d(this.mUpdateListener);
            if (!this.mUpdateListener.e()) {
                n.d(this.mUpdateListener);
                int r0 = this.mUpdateListener.a() ? -3 : -1;
            }
        }
        return (this.mUpdateListener.a() ? -3 : -1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void h() {
        if (this.mShimmerPaint != null && this.b()) {
            n.d(this.mShimmerPaint);
            this.mShimmerPaint.cancel();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        n.f(rect, "bounds");
        super.onBoundsChange(rect);
        this.mShaderMatrix.set(rect);
        getOpacity();
        e();
    }

    public static /* synthetic */ void c(c cVar, ValueAnimator valueAnimator) {
        ShimmerDrawable.d(cVar, valueAnimator);
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final float offset(float start, float end, float percent) {
        return start + (end - start) * percent;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
