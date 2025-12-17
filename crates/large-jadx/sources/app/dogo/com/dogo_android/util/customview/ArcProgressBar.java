package app.dogo.com.dogo_android.util.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import app.dogo.com.dogo_android.b;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u001f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!J\u0008\u0010\"\u001a\u00020\u0010H\u0002J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0008\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0014J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0012\u0010-\u001a\u00020\u001e2\u0008\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0008\u00100\u001a\u00020/H\u0014J(\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0007H\u0016J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u0007J\u0008\u0010<\u001a\u00020\u001eH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>", d2 = {"Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundColor", "backgroundPaint", "Landroid/graphics/Paint;", "backgroundWidth", "", "getDefStyleAttr$app_release", "()I", "setDefStyleAttr$app_release", "(I)V", "mArcBounds", "Landroid/graphics/RectF;", "mRadius", "maxValue", "progressBarPaint", "progressColor", "progressValue", "strokeWidth", "animateProgressChange", "", "newProgress", "durationMs", "", "drawUpTo", "getMax", "getProgress", "initView", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSizeChanged", "w", "h", "oldw", "oldh", "setBackgroundColor", "color", "", "setMax", "setProgress", "progress", "updateProgress", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ArcProgressBar extends View {

    public static final app.dogo.com.dogo_android.util.customview.ArcProgressBar.a Companion;
    private final RectF A;
    private float B;
    private float C;
    private ValueAnimator D;
    private int a;
    private int b;
    private int c;
    private int v;
    private int w;
    private float x;
    private Paint y;
    private Paint z;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar$Companion;", "", "()V", "CURRENT_PROGRESS_KEY", "", "MAX_VALUE_KEY", "START_ANGLE", "", "SUPER_STATE_KEY", "SWEEP_ANGLE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        ArcProgressBar.a aVar = new ArcProgressBar.a(0);
        ArcProgressBar.Companion = aVar;
    }

    public ArcProgressBar(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        n.f(attributeSet2, "attrs");
        super(context, attributeSet2, 0);
        d(context, attributeSet2);
    }

    public ArcProgressBar(Context context, AttributeSet attributeSet2, int i3) {
        n.f(context, "context");
        n.f(attributeSet2, "attrs");
        super(context, attributeSet2, i3);
        RectF rectF = new RectF();
        this.A = rectF;
        setSaveEnabled(true);
        this.w = i3;
        d(context, attributeSet2);
    }

    private static final void b(app.dogo.com.dogo_android.util.customview.ArcProgressBar arcProgressBar, ValueAnimator valueAnimator2) {
        n.f(arcProgressBar, "this$0");
        Object obj2 = valueAnimator2.getAnimatedValue();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        arcProgressBar.setProgress((Integer)obj2.intValue());
    }

    private final float c() {
        int i;
        i = 1131413504;
        i3 /= f2;
        if (Float.compare(i4, i) < 0) {
            i = i4;
        }
        return i;
    }

    private final void d(Context context, AttributeSet attributeSet2) {
        String str = "java.lang.String.format(format, *args)";
        final String str2 = "#%06X";
        final int i3 = 0;
        TypedArray obj10 = context.getTheme().obtainStyledAttributes(attributeSet2, b.a, i3, i3);
        n.e(obj10, "context.theme.obtainStyledAttributes(attrs, R.styleable.ArcProgressBar, 0, 0)");
        this.a = obj10.getInteger(2, i3);
        this.b = obj10.getInteger(3, i3);
        final int i5 = 0;
        this.c = obj10.getColor(4, getResources().getColor(2131099772, i5));
        this.v = obj10.getColor(i3, getResources().getColor(2131100379, i5));
        int i2 = 1096810496;
        this.B = obj10.getFloat(5, i2);
        int obj11 = 1;
        this.C = obj10.getFloat(obj11, i2);
        Paint paint2 = new Paint(obj11);
        this.z = paint2;
        String str3 = "progressBarPaint";
        if (paint2 == null) {
        } else {
            paint2.setStyle(Paint.Style.FILL);
            Paint paint3 = this.z;
            if (paint3 == null) {
            } else {
                paint3.setStyle(Paint.Style.STROKE);
                Paint paint4 = this.z;
                if (paint4 == null) {
                } else {
                    paint4.setStrokeWidth(f *= density);
                    Paint paint5 = this.z;
                    if (paint5 == null) {
                    } else {
                        paint5.setStrokeCap(Paint.Cap.ROUND);
                        f0 f0Var = f0.a;
                        Object[] arr = new Object[obj11];
                        int i12 = 16777215;
                        arr[i3] = Integer.valueOf(i7 &= i12);
                        String format = String.format(str2, Arrays.copyOf(arr, obj11));
                        n.e(format, str);
                        Paint paint10 = this.z;
                        if (paint10 == null) {
                        } else {
                            paint10.setColor(Color.parseColor(format));
                            Paint paint6 = new Paint(obj11);
                            this.y = paint6;
                            String str4 = "backgroundPaint";
                            if (paint6 == null) {
                            } else {
                                paint6.setStyle(Paint.Style.FILL);
                                Paint paint7 = this.y;
                                if (paint7 == null) {
                                } else {
                                    paint7.setStyle(Paint.Style.STROKE);
                                    Paint paint8 = this.y;
                                    if (paint8 == null) {
                                    } else {
                                        paint8.setStrokeWidth(f2 *= density2);
                                        Paint paint9 = this.y;
                                        if (paint9 == null) {
                                        } else {
                                            paint9.setStrokeCap(Paint.Cap.ROUND);
                                            Object[] arr2 = new Object[obj11];
                                            arr2[i3] = Integer.valueOf(i10 &= i12);
                                            obj11 = String.format(str2, Arrays.copyOf(arr2, obj11));
                                            n.e(obj11, str);
                                            Paint paint = this.y;
                                            if (paint == null) {
                                            } else {
                                                paint.setColor(Color.parseColor(obj11));
                                                obj10.recycle();
                                            }
                                            n.w(str4);
                                            throw i5;
                                        }
                                        n.w(str4);
                                        throw i5;
                                    }
                                    n.w(str4);
                                    throw i5;
                                }
                                n.w(str4);
                                throw i5;
                            }
                            n.w(str4);
                            throw i5;
                        }
                        n.w(str3);
                        throw i5;
                    }
                    n.w(str3);
                    throw i5;
                }
                n.w(str3);
                throw i5;
            }
            n.w(str3);
            throw i5;
        }
        n.w(str3);
        throw i5;
    }

    public static void e(app.dogo.com.dogo_android.util.customview.ArcProgressBar arcProgressBar, ValueAnimator valueAnimator2) {
        ArcProgressBar.b(arcProgressBar, valueAnimator2);
    }

    private final void f() {
        invalidate();
    }

    @Override // android.view.View
    public final void a(int i, long l2) {
        int[] linearInterpolator;
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator == null) {
        } else {
            valueAnimator.cancel();
        }
        linearInterpolator = new int[2];
        ValueAnimator obj4 = ValueAnimator.ofInt(getProgress(), i);
        this.D = obj4;
        if (obj4 == null) {
        } else {
            linearInterpolator = new LinearInterpolator();
            obj4.setInterpolator(linearInterpolator);
        }
        obj4 = this.D;
        if (obj4 == null) {
        } else {
            linearInterpolator = new a(this);
            obj4.addUpdateListener(linearInterpolator);
        }
        obj4 = this.D;
        if (obj4 == null) {
        } else {
            obj4.setDuration(l2);
        }
        obj4 = this.D;
        if (obj4 == null) {
        } else {
            obj4.start();
        }
    }

    @Override // android.view.View
    public final int getDefStyleAttr$app_release() {
        return this.w;
    }

    @Override // android.view.View
    public final int getMax() {
        return this.a;
    }

    @Override // android.view.View
    public final int getProgress() {
        return this.b;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator == null) {
        } else {
            valueAnimator.cancel();
        }
        this.D = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        Paint paint = this.z;
        final String str3 = "progressBarPaint";
        final int i11 = 0;
        if (paint == null) {
        } else {
            float strokeWidth = paint.getStrokeWidth();
            float f = this.x;
            float f2 = (float)i3;
            this.A.set(strokeWidth, strokeWidth, i6 -= strokeWidth, i -= strokeWidth);
            Paint paint2 = this.y;
            if (paint2 == null) {
            } else {
                canvas.drawArc(this.A, 1125515264, 1131413504, false, paint2);
                Paint paint3 = this.z;
                if (paint3 == null) {
                } else {
                    canvas.drawArc(this.A, 1125515264, c(), false, paint3);
                }
                n.w(str3);
                throw i11;
            }
            n.w("backgroundPaint");
            throw i11;
        }
        n.w(str3);
        throw i11;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int obj1 = g.e(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        setMeasuredDimension(obj1, obj1);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        boolean str;
        int i;
        Object obj3;
        if (parcelable instanceof Bundle != null) {
            i = 0;
            this.a = (Bundle)parcelable.getInt("MAX_VALUE_KEY", i);
            this.b = parcelable.getInt("CURRENT_PROGRESS_KEY", i);
            obj3 = parcelable.getParcelable("SUPER_STATE_KEY");
        }
        super.onRestoreInstanceState(obj3);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt("MAX_VALUE_KEY", this.a);
        bundle.putInt("CURRENT_PROGRESS_KEY", this.b);
        bundle.putParcelable("SUPER_STATE_KEY", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.x = obj1 /= obj2;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.v = i;
        final Paint paint = this.y;
        if (paint == null) {
        } else {
            paint.setColor(i);
            invalidate();
        }
        n.w("backgroundPaint");
        throw 0;
    }

    @Override // android.view.View
    public final void setBackgroundColor(String string) {
        n.f(string, "color");
        Paint paint = this.y;
        if (paint == null) {
        } else {
            paint.setColor(Color.parseColor(string));
            invalidate();
        }
        n.w("backgroundPaint");
        throw 0;
    }

    @Override // android.view.View
    public final void setDefStyleAttr$app_release(int i) {
        this.w = i;
    }

    @Override // android.view.View
    public final void setMax(int i) {
        this.a = i;
        f();
    }

    @Override // android.view.View
    public final void setProgress(int i) {
        this.b = i;
        f();
    }
}
