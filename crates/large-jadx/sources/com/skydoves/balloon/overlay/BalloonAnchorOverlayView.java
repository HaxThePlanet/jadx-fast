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

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B'\u0008\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\u0008\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\u0008\u0008\u0002\u0010M\u001a\u00020\u0005¢\u0006\u0004\u0008N\u0010OJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00022\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0014¢\u0006\u0004\u0008\n\u0010\u000bJ7\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR(\u0010#\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R&\u0010'\u001a\u00020\u00052\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00058G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008$\u0010\u0007\"\u0004\u0008%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008)\u0010*R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\u0008,\u0010-R&\u00104\u001a\u00020/2\u0008\u0008\u0001\u0010\u001e\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R(\u0010:\u001a\u0004\u0018\u0001052\u0008\u0010\u001e\u001a\u0004\u0018\u0001058F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u0016\u0010=\u001a\u00020\u000c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008;\u0010<R\u0016\u0010@\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\u0008>\u0010?R$\u0010E\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR\u0018\u0010H\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008F\u0010G¨\u0006P", d2 = {"Lcom/skydoves/balloon/overlay/BalloonAnchorOverlayView;", "Landroid/view/View;", "Lkotlin/w;", "a", "()V", "", "getStatusBarHeight", "()I", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/skydoves/balloon/overlay/e;", "w", "Lcom/skydoves/balloon/overlay/e;", "_balloonOverlayShape", "Landroid/view/View;", "_anchorView", "Landroid/graphics/Paint;", "y", "Landroid/graphics/Paint;", "paint", "value", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView", "getOverlayColor", "setOverlayColor", "(I)V", "overlayColor", "Landroid/graphics/Bitmap;", "x", "Landroid/graphics/Bitmap;", "bitmap", "b", "I", "_overlayColor", "", "getOverlayPadding", "()F", "setOverlayPadding", "(F)V", "overlayPadding", "Landroid/graphics/Point;", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "overlayPosition", "z", "Z", "invalidated", "c", "F", "_overlayPadding", "getBalloonOverlayShape", "()Lcom/skydoves/balloon/overlay/e;", "setBalloonOverlayShape", "(Lcom/skydoves/balloon/overlay/e;)V", "balloonOverlayShape", "v", "Landroid/graphics/Point;", "_overlayPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "balloon_release"}, k = 1, mv = {1, 4, 2})
public final class BalloonAnchorOverlayView extends View {

    private View a;
    private int b;
    private float c;
    private Point v;
    private com.skydoves.balloon.overlay.e w;
    private Bitmap x;
    private final Paint y;
    private boolean z;
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0, 4, 0);
    }

    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet2, int i3) {
        n.f(context, "context");
        super(context, attributeSet2, i3);
        this.w = c.a;
        final int obj3 = 1;
        Paint obj2 = new Paint(obj3);
        this.y = obj2;
        obj2.setAntiAlias(obj3);
        obj2.setFilterBitmap(obj3);
        obj2.setDither(obj3);
    }

    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet2, int i3, int i4, g g5) {
        int obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(context, obj2, obj3);
    }

    private final void a() {
        int anchorView;
        int rectF;
        int recycled;
        PorterDuff.Mode centerY;
        int floatValue;
        float f;
        float str;
        float floatValue2;
        Paint overlayPadding2;
        Canvas canvas;
        float overlayPadding;
        if (getWidth() != 0 && getHeight() != 0) {
            if (getHeight() != 0) {
                anchorView = getAnchorView();
                if (anchorView != null) {
                    if (anchorView.getWidth() != 0) {
                        anchorView = getAnchorView();
                        if (anchorView != null && anchorView.getHeight() == 0) {
                            if (anchorView.getHeight() == 0) {
                            } else {
                                Bitmap bitmap = this.x;
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    if (!bitmap.isRecycled()) {
                                        bitmap.recycle();
                                    }
                                }
                                Bitmap bitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                                this.x = bitmap2;
                                canvas = new Canvas(bitmap2);
                                Paint paint = this.y;
                                PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
                                paint.setXfermode(porterDuffXfermode);
                                paint.setColor(getOverlayColor());
                                canvas.drawRect(0, 0, (float)width2, (float)height, this.y);
                                Paint paint2 = this.y;
                                PorterDuffXfermode porterDuffXfermode2 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
                                paint2.setXfermode(porterDuffXfermode2);
                                recycled = 0;
                                paint2.setColor(recycled);
                                anchorView = getAnchorView();
                                if (anchorView != null) {
                                    Rect rect = new Rect();
                                    anchorView.getGlobalVisibleRect(rect);
                                    Point overlayPosition = getOverlayPosition();
                                    if (overlayPosition != null) {
                                        centerY = new RectF(f5 -= overlayPadding5, i8 += f9, f10 += overlayPadding, i += f);
                                    } else {
                                        rectF = new RectF(f4 -= overlayPadding4, f6 -= overlayPadding6, f8 += overlayPadding8, f3 += overlayPadding2);
                                        centerY = rectF;
                                    }
                                    com.skydoves.balloon.overlay.e balloonOverlayShape = getBalloonOverlayShape();
                                    if (balloonOverlayShape instanceof c) {
                                        canvas.drawOval(centerY, this.y);
                                    } else {
                                        str = "context";
                                        if (balloonOverlayShape instanceof b) {
                                            floatValue = (b)balloonOverlayShape.a();
                                            if (floatValue != null) {
                                                canvas.drawCircle(centerY.centerX(), centerY.centerY(), floatValue.floatValue(), this.y);
                                            }
                                            anchorView = balloonOverlayShape.b();
                                            if (anchorView != null) {
                                                floatValue2 = getContext();
                                                n.e(floatValue2, str);
                                                canvas.drawCircle(centerY.centerX(), centerY.centerY(), a.b(floatValue2, anchorView.intValue()), this.y);
                                            }
                                        } else {
                                            if (!balloonOverlayShape instanceof d) {
                                            } else {
                                                floatValue = (d)balloonOverlayShape.a();
                                                if (floatValue != null) {
                                                    canvas.drawRoundRect(centerY, (Number)floatValue.c().floatValue(), (Number)floatValue.d().floatValue(), this.y);
                                                }
                                                anchorView = balloonOverlayShape.b();
                                                if (anchorView != null) {
                                                    Context context = getContext();
                                                    n.e(context, str);
                                                    floatValue2 = getContext();
                                                    n.e(floatValue2, str);
                                                    canvas.drawRoundRect(centerY, a.b(context, (Number)anchorView.c().intValue()), a.b(floatValue2, (Number)anchorView.d().intValue()), this.y);
                                                }
                                            }
                                        }
                                    }
                                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                                    throw noWhenBranchMatchedException;
                                }
                                this.z = recycled;
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
    }

    private final int getStatusBarHeight() {
        int top;
        Object decorView;
        String str;
        Rect rect = new Rect();
        decorView = getContext();
        if (decorView instanceof Activity != null) {
            Window window = (Activity)decorView.getWindow();
            n.e(window, "context.window");
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            top = rect.top;
        } else {
            top = 0;
        }
        return top;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap recycled2;
        int recycled;
        int i;
        recycled2 = this.x;
        if (!this.z && recycled2 != null) {
            recycled2 = this.x;
            if (recycled2 != null) {
                if (recycled2 != null && recycled2.isRecycled() == 1) {
                    if (recycled2.isRecycled() == 1) {
                        a();
                    }
                }
            } else {
            }
        } else {
        }
        Bitmap bitmap = this.x;
        if (bitmap != null && !bitmap.isRecycled() && canvas != null) {
            if (!bitmap.isRecycled()) {
                if (canvas != null) {
                    i = 0;
                    canvas.drawBitmap(bitmap, i, i, 0);
                }
            }
        }
    }

    @Override // android.view.View
    public final View getAnchorView() {
        return this.a;
    }

    @Override // android.view.View
    public final com.skydoves.balloon.overlay.e getBalloonOverlayShape() {
        return this.w;
    }

    @Override // android.view.View
    public final int getOverlayColor() {
        return this.b;
    }

    @Override // android.view.View
    public final float getOverlayPadding() {
        return this.c;
    }

    @Override // android.view.View
    public final Point getOverlayPosition() {
        return this.v;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.z = true;
    }

    @Override // android.view.View
    public final void setAnchorView(View view) {
        this.a = view;
        invalidate();
    }

    @Override // android.view.View
    public final void setBalloonOverlayShape(com.skydoves.balloon.overlay.e e) {
        n.f(e, "value");
        this.w = e;
        invalidate();
    }

    @Override // android.view.View
    public final void setOverlayColor(int i) {
        this.b = i;
        invalidate();
    }

    @Override // android.view.View
    public final void setOverlayPadding(float f) {
        this.c = f;
        invalidate();
    }

    @Override // android.view.View
    public final void setOverlayPosition(Point point) {
        this.v = point;
        invalidate();
    }
}
