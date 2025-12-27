package com.skydoves.balloon.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import com.skydoves.balloon.a0.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;

/* compiled from: BalloonAnchorOverlayView.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B'\u0008\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\u0008\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\u0008\u0008\u0002\u0010M\u001a\u00020\u0005¢\u0006\u0004\u0008N\u0010OJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00022\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0014¢\u0006\u0004\u0008\n\u0010\u000bJ7\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR(\u0010#\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R&\u0010'\u001a\u00020\u00052\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00058G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008$\u0010\u0007\"\u0004\u0008%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008)\u0010*R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\u0008,\u0010-R&\u00104\u001a\u00020/2\u0008\u0008\u0001\u0010\u001e\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R(\u0010:\u001a\u0004\u0018\u0001052\u0008\u0010\u001e\u001a\u0004\u0018\u0001058F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u0016\u0010=\u001a\u00020\u000c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008;\u0010<R\u0016\u0010@\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\u0008>\u0010?R$\u0010E\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR\u0018\u0010H\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008F\u0010G¨\u0006P", d2 = {"Lcom/skydoves/balloon/overlay/BalloonAnchorOverlayView;", "Landroid/view/View;", "Lkotlin/w;", "a", "()V", "", "getStatusBarHeight", "()I", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/skydoves/balloon/overlay/e;", "w", "Lcom/skydoves/balloon/overlay/e;", "_balloonOverlayShape", "Landroid/view/View;", "_anchorView", "Landroid/graphics/Paint;", "y", "Landroid/graphics/Paint;", "paint", "value", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView", "getOverlayColor", "setOverlayColor", "(I)V", "overlayColor", "Landroid/graphics/Bitmap;", "x", "Landroid/graphics/Bitmap;", "bitmap", "b", "I", "_overlayColor", "", "getOverlayPadding", "()F", "setOverlayPadding", "(F)V", "overlayPadding", "Landroid/graphics/Point;", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "overlayPosition", "z", "Z", "invalidated", "c", "F", "_overlayPadding", "getBalloonOverlayShape", "()Lcom/skydoves/balloon/overlay/e;", "setBalloonOverlayShape", "(Lcom/skydoves/balloon/overlay/e;)V", "balloonOverlayShape", "v", "Landroid/graphics/Point;", "_overlayPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "balloon_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BalloonAnchorOverlayView extends View {

    /* renamed from: a, reason: from kotlin metadata */
    private View _anchorView;
    /* renamed from: b, reason: from kotlin metadata */
    private int _overlayColor;
    /* renamed from: c, reason: from kotlin metadata */
    private float _overlayPadding;
    /* renamed from: v, reason: from kotlin metadata */
    private Point _overlayPosition;
    /* renamed from: w, reason: from kotlin metadata */
    private e _balloonOverlayShape;
    /* renamed from: x, reason: from kotlin metadata */
    private Bitmap bitmap;
    /* renamed from: y, reason: from kotlin metadata */
    private final Paint paint;
    /* renamed from: z, reason: from kotlin metadata */
    private boolean invalidated;
    public /* synthetic */ BalloonAnchorOverlayView(Context context, AttributeSet set, int i, int i2, g gVar) {
        AttributeSet attributeSet = null;
        i2 = i2 & 2 != 0 ? 0 : i2;
        i = i2 & 4 != 0 ? 0 : i;
        this(context, attributeSet, i);
    }

    private final void a() throws NoWhenBranchMatchedException {
        View anchorView3;
        PorterDuff.Mode cLEAR2;
        RectF rectF;
        float centerX = 0;
        o oVar;
        Float f3;
        float f4;
        float floatValue;
        Paint paint2;
        float overlayPadding;
        float overlayPadding2;
    }

    private final int getStatusBarHeight() {
        int top2 = 0;
        Rect rect = new Rect();
        Context context = getContext();
        if (context instanceof Activity) {
            Window window = context.getWindow();
            str = "context.window";
            n.e(window, str);
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
        } else {
            top2 = 0;
        }
        return top2;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean recycled;
        int i = 1;
        if (this.invalidated || !(this.bitmap == null && this.bitmap == null)) {
            a();
        }
        if (this.bitmap != null && !this.bitmap.isRecycled() && canvas != null) {
            float f = 0.0f;
            canvas.drawBitmap(this.bitmap, f, f, null);
        }
    }

    @Override // android.view.View
    public final View getAnchorView() {
        return this._anchorView;
    }

    @Override // android.view.View
    public final e getBalloonOverlayShape() {
        return this._balloonOverlayShape;
    }

    @Override // android.view.View
    public final int getOverlayColor() {
        return this._overlayColor;
    }

    @Override // android.view.View
    public final float getOverlayPadding() {
        return this._overlayPadding;
    }

    @Override // android.view.View
    public final Point getOverlayPosition() {
        return this._overlayPosition;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.invalidated = true;
    }

    @Override // android.view.View
    public final void setAnchorView(View view) {
        this._anchorView = view;
        invalidate();
    }

    @Override // android.view.View
    public final void setBalloonOverlayShape(e eVar) {
        n.f(eVar, "value");
        this._balloonOverlayShape = eVar;
        invalidate();
    }

    @Override // android.view.View
    public final void setOverlayColor(int i) {
        this._overlayColor = i;
        invalidate();
    }

    @Override // android.view.View
    public final void setOverlayPadding(float f) {
        this._overlayPadding = f;
        invalidate();
    }

    @Override // android.view.View
    public final void setOverlayPosition(Point point) {
        this._overlayPosition = point;
        invalidate();
    }

    public BalloonAnchorOverlayView(Context context, AttributeSet set, int i) {
        n.f(context, "context");
        super(context, set, i);
        this._balloonOverlayShape = c.a;
        i = 1;
        Paint paint = new Paint(i);
        this.paint = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
    }

    public BalloonAnchorOverlayView(Context context, AttributeSet set) {
        this(context, set, 0, 4, null);
    }
}
