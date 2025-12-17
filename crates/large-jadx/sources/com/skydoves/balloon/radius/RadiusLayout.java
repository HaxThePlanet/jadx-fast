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

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B'\u0008\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\u0008!\u0010\"J/\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\u000c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R&\u0010\u001b\u001a\u00020\u000e2\u0008\u0008\u0001\u0010\u0016\u001a\u00020\u000e8G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006#", d2 = {"Lcom/skydoves/balloon/radius/RadiusLayout;", "Landroid/widget/FrameLayout;", "", "w", "h", "oldw", "oldh", "Lkotlin/w;", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "b", "F", "_radius", "Landroid/graphics/Path;", "a", "Landroid/graphics/Path;", "path", "value", "getRadius", "()F", "setRadius", "(F)V", "radius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "balloon_release"}, k = 1, mv = {1, 4, 2})
public final class RadiusLayout extends FrameLayout {

    private final Path a;
    private float b;
    public RadiusLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0, 4, 0);
    }

    public RadiusLayout(Context context, AttributeSet attributeSet2, int i3) {
        n.f(context, "context");
        super(context, attributeSet2, i3);
        Path obj2 = new Path();
        this.a = obj2;
    }

    public RadiusLayout(Context context, AttributeSet attributeSet2, int i3, int i4, g g5) {
        int obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(context, obj2, obj3);
    }

    @Override // android.widget.FrameLayout
    protected void dispatchDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        canvas.clipPath(this.a);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout
    public final float getRadius() {
        return this.b;
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = 0;
        RectF obj5 = new RectF(i5, i5, (float)i, (float)i2);
        this.a.addRoundRect(obj5, getRadius(), getRadius(), Path.Direction.CW);
    }

    @Override // android.widget.FrameLayout
    public final void setRadius(float f) {
        Resources system = Resources.getSystem();
        n.e(system, "Resources.getSystem()");
        this.b = TypedValue.applyDimension(1, f, system.getDisplayMetrics());
        invalidate();
    }
}
