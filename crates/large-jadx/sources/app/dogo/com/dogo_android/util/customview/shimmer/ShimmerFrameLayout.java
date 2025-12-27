package app.dogo.com.dogo_android.util.customview.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import app.dogo.com.dogo_android.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ShimmerFrameLayout.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nB)\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u001cJ\u001a\u0010 \u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0008\u0010!\u001a\u00020\u001cH\u0016J\u0008\u0010\"\u001a\u00020\u001cH\u0016J0\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0014J\u0010\u0010-\u001a\u00020\u00002\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u000eJ\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020\u001cJ\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0014R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/ShimmerFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isShimmerStarted", "", "()Z", "<set-?>", "isShimmerVisible", "mContentPaint", "Landroid/graphics/Paint;", "mShimmerDrawable", "Lapp/dogo/com/dogo_android/util/customview/shimmer/ShimmerDrawable;", "mStoppedShimmerBecauseVisibility", "shimmer", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "getShimmer", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "hideShimmer", "init", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "setShimmer", "showShimmer", "startShimmer", "stopShimmer", "verifyDrawable", "who", "Landroid/graphics/drawable/Drawable;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ShimmerFrameLayout extends FrameLayout {

    private final Paint a = new Paint();
    private final c b = new c();
    /* renamed from: c, reason: from kotlin metadata */
    private boolean mContentPaint = true;
    /* renamed from: v, reason: from kotlin metadata */
    private boolean mShimmerDrawable;
    public ShimmerFrameLayout(Context context, AttributeSet set) {
        n.f(context, "context");
        super(context, set);
        Paint paint = new Paint();
        app.dogo.com.dogo_android.util.customview.shimmer.c shimmerDrawable = new ShimmerDrawable();
        init(context, set);
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final void init(Context context, AttributeSet attrs) {
        app.dogo.com.dogo_android.util.customview.shimmer.b.a shimmer_AlphaHighlightBuilder;
        app.dogo.com.dogo_android.util.customview.shimmer.b bVar = null;
        final boolean z = false;
        setWillNotDraw(z);
        this.b.setCallback(this);
        if (attrs == null) {
            dispatchDraw(new Shimmer_AlphaHighlightBuilder().a());
            return;
        }
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, b.c, z, z);
        n.e(styledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ShimmerFrameLayout, 0, 0)");
        int i = 4;
        try {
            attrs = styledAttributes.hasValue(i) && styledAttributes.getBoolean(i, z) ? new Shimmer_ColorHighlightBuilder() : new Shimmer_AlphaHighlightBuilder();
            app.dogo.com.dogo_android.util.customview.shimmer.b.b bVar3 = (styledAttributes.hasValue(i) && styledAttributes.getBoolean(i, z) ? new Shimmer_ColorHighlightBuilder() : new Shimmer_AlphaHighlightBuilder()).b(styledAttributes);
            if (bVar3 == null) {
                int i2 = 0;
            } else {
                bVar = bVar3.a();
            }
            dispatchDraw(bVar);
        } finally {
            context.recycle();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) attrs;
        }
        styledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout
    /* renamed from: b, reason: from kotlin metadata */
    public final boolean hideShimmer() {
        return this.b.b();
    }

    @Override // android.widget.FrameLayout
    /* renamed from: c, reason: from kotlin metadata */
    public final ShimmerFrameLayout dispatchDraw(b canvas) {
        this.b.onBoundsChange(canvas);
        if (canvas == null || !canvas.e()) {
            int i = 0;
            Paint paint = null;
            setLayerType(i, paint);
        } else {
            i = 2;
            setLayerType(i, this.a);
        }
        return this;
    }

    @Override // android.widget.FrameLayout
    public final void d() {
        this.mShimmerDrawable = false;
        this.b.h();
    }

    @Override // android.widget.FrameLayout
    public void dispatchDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.mContentPaint) {
            this.b.draw(canvas);
        }
    }

    @Override // android.widget.FrameLayout
    public final b getShimmer() {
        return this.b.a();
    }

    @Override // android.widget.FrameLayout
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.e();
    }

    @Override // android.widget.FrameLayout
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.widget.FrameLayout
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        final int i = 0;
        this.b.setBounds(i, i, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout
    protected void onVisibilityChanged(View changedView, int visibility) {
        n.f(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            if (hideShimmer()) {
                d();
                boolean hideShimmer = true;
                this.mShimmerDrawable = hideShimmer;
            }
        } else {
            if (this.mShimmerDrawable) {
                this.b.e();
                hideShimmer = false;
                this.mShimmerDrawable = hideShimmer;
            }
        }
    }

    @Override // android.widget.FrameLayout
    protected boolean verifyDrawable(Drawable who) {
        boolean verifyDrawable;
        boolean z = false;
        n.f(who, "who");
        if (super.verifyDrawable(who) || who == this.b) {
            int i2 = 1;
        }
        return z;
    }
}
