package com.skydoves.balloon.radius;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: RadiusLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B'\u0008\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\u0008!\u0010\"J/\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\u000c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R&\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0001\u0010\u0016\u001a\u00020\u000e8G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006#", d2 = {"Lcom/skydoves/balloon/radius/RadiusLayout;", "Landroid/widget/FrameLayout;", "", "w", "h", "oldw", "oldh", "Lkotlin/w;", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "b", "F", "_radius", "Landroid/graphics/Path;", "a", "Landroid/graphics/Path;", "path", "value", "getRadius", "()F", "setRadius", "(F)V", "radius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "balloon_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RadiusLayout extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final Path path;
    /* renamed from: b, reason: from kotlin metadata */
    private float _radius;
    public /* synthetic */ RadiusLayout(Context context, AttributeSet set, int i, int i2, g gVar) {
        AttributeSet attributeSet = null;
        i2 = i2 & 2 != 0 ? 0 : i2;
        i = i2 & 4 != 0 ? 0 : i;
        this(context, attributeSet, i);
    }

    @Override // android.widget.FrameLayout
    protected void dispatchDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout
    public final float getRadius() {
        return this._radius;
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float f = 0.0f;
        this.path.addRoundRect(new RectF(f, f, (float)w, (float)h), getRadius(), getRadius(), Path.Direction.CW);
    }

    @Override // android.widget.FrameLayout
    public final void setRadius(float f) {
        Resources system = Resources.getSystem();
        n.e(system, "Resources.getSystem()");
        this._radius = TypedValue.applyDimension(1, f, system.getDisplayMetrics());
        invalidate();
    }

    public RadiusLayout(Context context, AttributeSet set, int i) {
        n.f(context, "context");
        super(context, set, i);
        this.path = new Path();
    }

    public RadiusLayout(Context context, AttributeSet set) {
        this(context, set, 0, 4, null);
    }
}
