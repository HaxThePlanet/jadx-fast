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
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import app.dogo.com.dogo_android.b;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;

/* compiled from: ArcProgressBar.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u001f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!J\u0008\u0010\"\u001a\u00020\u0010H\u0002J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0008\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0014J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0012\u0010-\u001a\u00020\u001e2\u0008\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0008\u00100\u001a\u00020/H\u0014J(\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0007H\u0016J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u0007J\u0008\u0010<\u001a\u00020\u001eH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>", d2 = {"Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Landroid/animation/ValueAnimator;", "backgroundColor", "backgroundPaint", "Landroid/graphics/Paint;", "backgroundWidth", "", "getDefStyleAttr$app_release", "()I", "setDefStyleAttr$app_release", "(I)V", "mArcBounds", "Landroid/graphics/RectF;", "mRadius", "maxValue", "progressBarPaint", "progressColor", "progressValue", "strokeWidth", "animateProgressChange", "", "newProgress", "durationMs", "", "drawUpTo", "getMax", "getProgress", "initView", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "onSizeChanged", "w", "h", "oldw", "oldh", "setBackgroundColor", "color", "", "setMax", "setProgress", "progress", "updateProgress", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ArcProgressBar extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ArcProgressBar.a INSTANCE = new ArcProgressBar$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private final RectF animator;
    /* renamed from: B, reason: from kotlin metadata */
    private float backgroundColor;
    /* renamed from: C, reason: from kotlin metadata */
    private float backgroundPaint;
    /* renamed from: D, reason: from kotlin metadata */
    private ValueAnimator backgroundWidth;
    /* renamed from: a, reason: from kotlin metadata */
    private int defStyleAttr;
    /* renamed from: b, reason: from kotlin metadata */
    private int mArcBounds;
    /* renamed from: c, reason: from kotlin metadata */
    private int mRadius;
    /* renamed from: v, reason: from kotlin metadata */
    private int maxValue;
    /* renamed from: w, reason: from kotlin metadata */
    private int progressBarPaint;
    /* renamed from: x, reason: from kotlin metadata */
    private float progressColor;
    /* renamed from: y, reason: from kotlin metadata */
    private Paint progressValue;
    /* renamed from: z, reason: from kotlin metadata */
    private Paint strokeWidth;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar$Companion;", "", "()V", "CURRENT_PROGRESS_KEY", "", "MAX_VALUE_KEY", "START_ANGLE", "", "SUPER_STATE_KEY", "SWEEP_ANGLE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }
    public ArcProgressBar(Context context, AttributeSet set, int i) {
        n.f(context, "context");
        n.f(set, "attrs");
        super(context, set, i);
        this.animator = new RectF();
        setSaveEnabled(true);
        this.progressBarPaint = i;
        initView(context, set);
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final void animateProgressChange(ArcProgressBar newProgress, ValueAnimator durationMs) {
        n.f(newProgress, "this$0");
        Object animatedValue = durationMs.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        newProgress.setProgress(animatedValue.intValue());
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final float drawUpTo() {
        float f = 1131413504;
        f = 240f;
        f = (float)this.mArcBounds * f / (float)this.defStyleAttr;
        if (this.mArcBounds < f) {
        }
        return f;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final void initView(Context context, AttributeSet attrs) {
        String str = "java.lang.String.format(format, *args)";
        final String str2 = "#%06X";
        final int i2 = 0;
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(attrs, b.a, i2, i2);
        n.e(styledAttributes, "context.theme.obtainStyledAttributes(attrs, R.styleable.ArcProgressBar, 0, 0)");
        try {
            this.defStyleAttr = styledAttributes.getInteger(2, i2);
            this.mArcBounds = styledAttributes.getInteger(3, i2);
            final Resources.Theme theme = null;
            this.mRadius = styledAttributes.getColor(4, getResources().getColor(2131099772, theme));
            this.maxValue = styledAttributes.getColor(i2, getResources().getColor(2131100379, theme));
            float f = 14f;
            this.backgroundColor = styledAttributes.getFloat(5, f);
            int i11 = 1;
            this.backgroundPaint = styledAttributes.getFloat(i11, f);
            Paint paint = new Paint(i11);
            this.strokeWidth = paint;
        } finally {
            context.recycle();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) attrs;
        }
        String str3 = "progressBarPaint";
        if (b.a != null) {
            try {
                paint.setStyle(Paint.Style.FILL);
                this.strokeWidth.setStyle(Paint.Style.STROKE);
                this.strokeWidth.setStrokeWidth(this.backgroundColor * getResources().getDisplayMetrics().density);
                this.strokeWidth.setStrokeCap(Paint.Cap.ROUND);
                Object[] arr = new Object[i11];
                int i6 = 16777215;
                arr[i2] = Integer.valueOf(this.mRadius & i6);
                String formatted = String.format(str2, Arrays.copyOf(arr, i11));
                n.e(formatted, str);
                this.strokeWidth.setColor(Color.parseColor(formatted));
                Paint paint2 = new Paint(i11);
                this.progressValue = paint2;
            } finally {
                context.recycle();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) attrs;
            }
            try {
                n.w(str3);
            } finally {
                context.recycle();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) attrs;
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) theme;
        }
        try {
            n.w(str3);
        } finally {
            context.recycle();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) attrs;
        }
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) theme;
    }

    private final void f() {
        invalidate();
    }

    @Override // android.view.View
    public final void a(int i, long j) {
        int[] iArr;
        if (this.backgroundWidth != null) {
            this.backgroundWidth.cancel();
        }
        iArr = new int[2];
        ValueAnimator _int = ValueAnimator.ofInt(new int[] { getProgress(), i });
        this.backgroundWidth = _int;
        if (_int != null) {
            _int.setInterpolator(new LinearInterpolator());
        }
        if (this.backgroundWidth != null) {
            this.backgroundWidth.addUpdateListener(new a(this));
        }
        if (this.backgroundWidth != null) {
            this.backgroundWidth.setDuration(j);
        }
        if (this.backgroundWidth != null) {
            this.backgroundWidth.start();
        }
    }

    @Override // android.view.View
    public final int getDefStyleAttr$app_release() {
        return this.progressBarPaint;
    }

    @Override // android.view.View
    public final int getMax() {
        return this.defStyleAttr;
    }

    @Override // android.view.View
    public final int getProgress() {
        return this.mArcBounds;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.backgroundWidth != null) {
            this.backgroundWidth.cancel();
        }
        this.backgroundWidth = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        final String str3 = "progressBarPaint";
        final int i7 = 0;
        if (this.strokeWidth == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i7;
        } else {
            float strokeWidth = this.strokeWidth.getStrokeWidth();
            float f3 = (float)2;
            this.animator.set(strokeWidth, strokeWidth, (progressColor2 * f3) - strokeWidth, (progressColor2 * f3) - strokeWidth);
            if (this.progressValue == null) {
                n.w("backgroundPaint");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i7;
            } else {
                canvas.drawArc(this.animator, 150f, 240f, false, this.progressValue);
                if (this.strokeWidth == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i7;
                } else {
                    canvas.drawArc(this.animator, 150f, drawUpTo(), false, this.strokeWidth);
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = g.e(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Parcelable parcelable;
        z = state instanceof Bundle;
        if (state instanceof Bundle) {
            int i = 0;
            this.defStyleAttr = state.getInt("MAX_VALUE_KEY", i);
            this.mArcBounds = state.getInt("CURRENT_PROGRESS_KEY", i);
            parcelable = state.getParcelable("SUPER_STATE_KEY");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        final Bundle bundle = new Bundle();
        bundle.putInt("MAX_VALUE_KEY", this.defStyleAttr);
        bundle.putInt("CURRENT_PROGRESS_KEY", this.mArcBounds);
        bundle.putParcelable("SUPER_STATE_KEY", super.onSaveInstanceState());
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.progressColor = (float)(g.e(w, h)) / 2f;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.maxValue = color;
        if (this.progressValue == null) {
            n.w("backgroundPaint");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            this.progressValue.setColor(color);
            invalidate();
            return;
        }
    }

    @Override // android.view.View
    public final void setDefStyleAttr$app_release(int i) {
        this.progressBarPaint = i;
    }

    @Override // android.view.View
    public final void setMax(int maxValue) {
        this.defStyleAttr = maxValue;
        f();
    }

    @Override // android.view.View
    public final void setProgress(int progress) {
        this.mArcBounds = progress;
        f();
    }

    @Override // android.view.View
    public final void setBackgroundColor(String str) {
        n.f(str, "color");
        if (this.progressValue == null) {
            n.w("backgroundPaint");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            this.progressValue.setColor(Color.parseColor(str));
            invalidate();
            return;
        }
    }

    public ArcProgressBar(Context context, AttributeSet set) {
        n.f(context, "context");
        n.f(set, "attrs");
        this(context, set, 0);
        initView(context, set);
    }


    /* renamed from: e, reason: from kotlin metadata */
    public static /* synthetic */ void onMeasure(ArcProgressBar widthMeasureSpec, ValueAnimator heightMeasureSpec) {
        ArcProgressBar.animateProgressChange(widthMeasureSpec, heightMeasureSpec);
    }
}
