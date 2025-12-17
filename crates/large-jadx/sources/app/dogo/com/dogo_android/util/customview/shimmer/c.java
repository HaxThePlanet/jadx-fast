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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u0018J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001cH\u0016J\u0012\u0010'\u001a\u00020\u00182\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0008\u0010,\u001a\u00020\u0018H\u0002J\u0008\u0010-\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/ShimmerDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "isShimmerStarted", "", "()Z", "mDrawRect", "Landroid/graphics/Rect;", "mShaderMatrix", "Landroid/graphics/Matrix;", "mShimmer", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "mShimmerPaint", "Landroid/graphics/Paint;", "mUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mValueAnimator", "Landroid/animation/ValueAnimator;", "shimmer", "getShimmer", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "setShimmer", "(Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "maybeStartShimmer", "offset", "", "start", "end", "percent", "onBoundsChange", "bounds", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "startShimmer", "stopShimmer", "updateShader", "updateValueAnimator", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Drawable {

    private final ValueAnimator.AnimatorUpdateListener a;
    private final Paint b;
    private final Rect c;
    private final Matrix d;
    private ValueAnimator e;
    private app.dogo.com.dogo_android.util.customview.shimmer.b f;
    public c() {
        super();
        a aVar = new a(this);
        this.a = aVar;
        Paint paint = new Paint();
        this.b = paint;
        Rect rect = new Rect();
        this.c = rect;
        Matrix matrix = new Matrix();
        this.d = matrix;
        paint.setAntiAlias(true);
    }

    public static void c(app.dogo.com.dogo_android.util.customview.shimmer.c c, ValueAnimator valueAnimator2) {
        c.d(c, valueAnimator2);
    }

    private static final void d(app.dogo.com.dogo_android.util.customview.shimmer.c c, ValueAnimator valueAnimator2) {
        n.f(c, "this$0");
        c.invalidateSelf();
    }

    private final float f(float f, float f2, float f3) {
        return f += obj2;
    }

    private final void i() {
        int height;
        int i7;
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar;
        int width;
        Object sqrt;
        int i5;
        int i6;
        int i2;
        int i4;
        float f3;
        float f;
        int[] iArr;
        float[] fArr;
        Shader.TileMode cLAMP;
        Object linearGradient;
        RadialGradient radialGradient;
        int i3;
        int i;
        float f2;
        int[] iArr2;
        float[] fArr2;
        Shader.TileMode cLAMP2;
        final Object obj = this;
        Rect bounds = getBounds();
        n.e(bounds, "bounds");
        width = bounds.width();
        height = bounds.height();
        if (width != 0 && height != 0) {
            if (height != 0) {
                sqrt = obj.f;
                if (sqrt == null) {
                } else {
                    n.d(sqrt);
                    width = sqrt.R(width);
                    app.dogo.com.dogo_android.util.customview.shimmer.b bVar5 = obj.f;
                    n.d(bVar5);
                    i7 = bVar5.v(height);
                    app.dogo.com.dogo_android.util.customview.shimmer.b bVar6 = obj.f;
                    n.d(bVar6);
                    int i10 = bVar6.r();
                    int i11 = 3;
                    i4 = 1;
                    f3 = 0;
                    if (i10 != 0) {
                        if (i10 != i4) {
                            app.dogo.com.dogo_android.util.customview.shimmer.b bVar7 = obj.f;
                            n.d(bVar7);
                            if (bVar7.g() != i4) {
                                app.dogo.com.dogo_android.util.customview.shimmer.b bVar8 = obj.f;
                                n.d(bVar8);
                                if (bVar8.g() == i11) {
                                } else {
                                    i4 = f3;
                                }
                            }
                            if (i4 != 0) {
                                width = f3;
                            }
                            if (i4 != 0) {
                            } else {
                                i7 = f3;
                            }
                            app.dogo.com.dogo_android.util.customview.shimmer.b bVar2 = obj.f;
                            n.d(bVar2);
                            bVar = obj.f;
                            n.d(bVar);
                            super(0, 0, (float)width, (float)i7, bVar2.f(), bVar.n(), Shader.TileMode.CLAMP);
                        } else {
                            i2 = 1073741824;
                            app.dogo.com.dogo_android.util.customview.shimmer.b bVar3 = obj.f;
                            n.d(bVar3);
                            bVar = obj.f;
                            n.d(bVar);
                            super(f4 / i2, f5 / i2, (float)i9, bVar3.f(), bVar.n(), Shader.TileMode.CLAMP);
                        }
                    } else {
                        app.dogo.com.dogo_android.util.customview.shimmer.b bVar9 = obj.f;
                        n.d(bVar9);
                        if (bVar9.g() != i4) {
                            app.dogo.com.dogo_android.util.customview.shimmer.b bVar10 = obj.f;
                            n.d(bVar10);
                            if (bVar10.g() == i11) {
                            } else {
                                i4 = f3;
                            }
                        }
                        if (i4 != 0) {
                            width = f3;
                        }
                        if (i4 != 0) {
                        } else {
                            i7 = f3;
                        }
                        app.dogo.com.dogo_android.util.customview.shimmer.b bVar4 = obj.f;
                        n.d(bVar4);
                        bVar = obj.f;
                        n.d(bVar);
                        super(0, 0, (float)width, (float)i7, bVar4.f(), bVar.n(), Shader.TileMode.CLAMP);
                    }
                    obj.b.setShader(linearGradient);
                }
            }
        }
    }

    private final void j() {
        boolean started;
        ValueAnimator valueAnimator;
        if (this.f == null) {
        }
        ValueAnimator valueAnimator2 = this.e;
        int i = 0;
        if (valueAnimator2 != null) {
            n.d(valueAnimator2);
            started = valueAnimator2.isStarted();
            ValueAnimator valueAnimator3 = this.e;
            n.d(valueAnimator3);
            valueAnimator3.cancel();
            valueAnimator = this.e;
            n.d(valueAnimator);
            valueAnimator.removeAllUpdateListeners();
        } else {
            started = i;
        }
        float[] fArr = new float[2];
        fArr[i] = 0;
        int i8 = 1065353216;
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar6 = this.f;
        n.d(bVar6);
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar8 = this.f;
        n.d(bVar8);
        fArr[1] = f += i8;
        ValueAnimator float = ValueAnimator.ofFloat(fArr);
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar2 = this.f;
        n.d(bVar2);
        float.setRepeatMode(bVar2.q());
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar3 = this.f;
        n.d(bVar3);
        float.setStartDelay(bVar3.s());
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar4 = this.f;
        n.d(bVar4);
        float.setRepeatCount(bVar4.o());
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar5 = this.f;
        n.d(bVar5);
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar7 = this.f;
        n.d(bVar7);
        float.setDuration(l2 += l4);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        float.setInterpolator(linearInterpolator);
        float.addUpdateListener(this.a);
        if (started) {
            float.start();
        }
        this.e = float;
    }

    @Override // android.graphics.drawable.Drawable
    public final app.dogo.com.dogo_android.util.customview.shimmer.b a() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean b() {
        ValueAnimator started;
        int i;
        started = this.e;
        n.d(started);
        if (started != null && started.isStarted()) {
            n.d(started);
            i = started.isStarted() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Object shader;
        float floatValue;
        float f;
        int i3;
        double d;
        int i2;
        float f2;
        int i4;
        float f3;
        String str;
        int i6;
        int i;
        int i5;
        n.f(canvas, "canvas");
        if (this.f != null) {
            if (this.b.getShader() == null) {
            } else {
                app.dogo.com.dogo_android.util.customview.shimmer.b bVar = this.f;
                n.d(bVar);
                float f5 = (float)d3;
                f6 += i8;
                f8 += i7;
                ValueAnimator valueAnimator = this.e;
                f3 = 0;
                if (valueAnimator != null) {
                    n.d(valueAnimator);
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    floatValue = (Float)animatedValue.floatValue();
                } else {
                    floatValue = f3;
                }
                app.dogo.com.dogo_android.util.customview.shimmer.b bVar3 = this.f;
                n.d(bVar3);
                int i9 = bVar3.g();
                if (i9 != 0) {
                    if (i9 != 1) {
                        if (i9 != 2) {
                            if (i9 != 3) {
                                f = f(-i4, i4, floatValue);
                                f3 = f;
                                i3 = i5;
                            } else {
                                i3 = f(i2, -i2, floatValue);
                            }
                        } else {
                            f = f(i4, -i4, floatValue);
                        }
                    } else {
                        i3 = f(-i2, i2, floatValue);
                    }
                } else {
                    f = f(-i4, i4, floatValue);
                }
                this.d.reset();
                app.dogo.com.dogo_android.util.customview.shimmer.b bVar2 = this.f;
                n.d(bVar2);
                i6 = 1073741824;
                this.d.setRotate(bVar2.t(), f10 /= i6, f11 /= i6);
                this.d.postTranslate(f3, i3);
                this.b.getShader().setLocalMatrix(this.d);
                canvas.drawRect(this.c, this.b);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void e() {
        ValueAnimator callback;
        callback = this.e;
        n.d(callback);
        callback = this.f;
        n.d(callback);
        if (callback != null && !callback.isStarted() && callback != null && callback.c() && getCallback() != null) {
            n.d(callback);
            if (!callback.isStarted()) {
                callback = this.f;
                if (callback != null) {
                    n.d(callback);
                    if (callback.c()) {
                        if (getCallback() != null) {
                            callback = this.e;
                            n.d(callback);
                            callback.start();
                        }
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void g(app.dogo.com.dogo_android.util.customview.shimmer.b b) {
        PorterDuffXfermode porterDuffXfermode;
        PorterDuff.Mode sRC_IN;
        Object obj3;
        this.f = b;
        if (b != null) {
            app.dogo.com.dogo_android.util.customview.shimmer.b bVar = this.f;
            n.d(bVar);
            sRC_IN = bVar.a() ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN;
            porterDuffXfermode = new PorterDuffXfermode(sRC_IN);
            this.b.setXfermode(porterDuffXfermode);
        }
        i();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        boolean bVar;
        int i;
        bVar = this.f;
        if (bVar != null) {
            n.d(bVar);
            if (!bVar.e()) {
                app.dogo.com.dogo_android.util.customview.shimmer.b bVar2 = this.f;
                n.d(bVar2);
                i = bVar2.a() ? -3 : -1;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public final void h() {
        ValueAnimator valueAnimator;
        if (this.e != null && b()) {
            if (b()) {
                valueAnimator = this.e;
                n.d(valueAnimator);
                valueAnimator.cancel();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        n.f(rect, "bounds");
        super.onBoundsChange(rect);
        this.c.set(rect);
        i();
        e();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
