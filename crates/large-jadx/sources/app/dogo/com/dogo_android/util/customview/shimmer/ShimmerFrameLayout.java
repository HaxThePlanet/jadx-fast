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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nB)\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u001cJ\u001a\u0010 \u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0008\u0010!\u001a\u00020\u001cH\u0016J\u0008\u0010\"\u001a\u00020\u001cH\u0016J0\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0014J\u0010\u0010-\u001a\u00020\u00002\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u000eJ\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020\u001cJ\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0014R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/ShimmerFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isShimmerStarted", "", "()Z", "<set-?>", "isShimmerVisible", "mContentPaint", "Landroid/graphics/Paint;", "mShimmerDrawable", "Lapp/dogo/com/dogo_android/util/customview/shimmer/ShimmerDrawable;", "mStoppedShimmerBecauseVisibility", "shimmer", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "getShimmer", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "hideShimmer", "init", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "setShimmer", "showShimmer", "startShimmer", "stopShimmer", "verifyDrawable", "who", "Landroid/graphics/drawable/Drawable;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShimmerFrameLayout extends FrameLayout {

    private final Paint a;
    private final app.dogo.com.dogo_android.util.customview.shimmer.c b;
    private boolean c = true;
    private boolean v;
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        super(context, attributeSet2);
        Paint paint = new Paint();
        this.a = paint;
        c cVar = new c();
        this.b = cVar;
        int i = 1;
        a(context, attributeSet2);
    }

    private final void a(Context context, AttributeSet attributeSet2) {
        app.dogo.com.dogo_android.util.customview.shimmer.b.b obj4;
        final int i = 0;
        setWillNotDraw(i);
        this.b.setCallback(this);
        if (attributeSet2 == null) {
            b.a obj3 = new b.a();
            c(obj3.a());
        }
        obj3 = context.obtainStyledAttributes(attributeSet2, b.c, i, i);
        n.e(obj3, "context.obtainStyledAttributes(attrs, R.styleable.ShimmerFrameLayout, 0, 0)");
        obj4 = 4;
        if (obj3.hasValue(obj4) && obj3.getBoolean(obj4, i)) {
            if (obj3.getBoolean(obj4, i)) {
                obj4 = new b.c();
            } else {
                obj4 = new b.a();
            }
        } else {
        }
        obj4 = obj4.b(obj3);
        if (obj4 == null) {
            obj4 = 0;
        } else {
            obj4 = obj4.a();
        }
        c(obj4);
        obj3.recycle();
    }

    @Override // android.widget.FrameLayout
    public final boolean b() {
        return this.b.b();
    }

    @Override // android.widget.FrameLayout
    public final app.dogo.com.dogo_android.util.customview.shimmer.ShimmerFrameLayout c(app.dogo.com.dogo_android.util.customview.shimmer.b b) {
        int i;
        app.dogo.com.dogo_android.util.customview.shimmer.b obj2;
        this.b.g(b);
        if (b != null && b.e()) {
            if (b.e()) {
                setLayerType(2, this.a);
            } else {
                setLayerType(0, 0);
            }
        } else {
        }
        return this;
    }

    @Override // android.widget.FrameLayout
    public final void d() {
        this.v = false;
        this.b.h();
    }

    @Override // android.widget.FrameLayout
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        n.f(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.c) {
            this.b.draw(canvas);
        }
    }

    @Override // android.widget.FrameLayout
    public final app.dogo.com.dogo_android.util.customview.shimmer.b getShimmer() {
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        final int obj4 = 0;
        this.b.setBounds(obj4, obj4, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout
    protected void onVisibilityChanged(View view, int i2) {
        boolean obj2;
        n.f(view, "changedView");
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            if (b()) {
                d();
                this.v = true;
            }
        } else {
            if (this.v) {
                this.b.e();
                this.v = false;
            }
        }
    }

    @Override // android.widget.FrameLayout
    protected boolean verifyDrawable(Drawable drawable) {
        app.dogo.com.dogo_android.util.customview.shimmer.c verifyDrawable;
        int obj2;
        n.f(drawable, "who");
        if (!super.verifyDrawable(drawable)) {
            if (drawable == this.b) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}
