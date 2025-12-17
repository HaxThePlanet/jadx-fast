package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.R.id;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0014J%\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\u0008\u0011J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J0\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0014J\u0018\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0014J\u0008\u0010\u001d\u001a\u00020\u0008H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/ui/platform/DrawChildContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDrawing", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "Landroidx/compose/ui/graphics/Canvas;", "view", "Landroid/view/View;", "drawingTime", "", "drawChild$ui_release", "getChildCount", "", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class DrawChildContainer extends ViewGroup {

    public static final int $stable = 8;
    private boolean isDrawing;
    static {
        final int i = 8;
    }

    public DrawChildContainer(Context context) {
        super(context);
        setClipChildren(false);
        setTag(R.id.hide_in_inspector_tag, true);
    }

    @Override // android.view.ViewGroup
    protected void dispatchDraw(Canvas canvas) {
        int doDispatch;
        int i;
        View childAt;
        boolean invalidated;
        doDispatch = 0;
        i = 0;
        while (i < super.getChildCount()) {
            childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            if ((ViewLayer)childAt.isInvalidated()) {
                break;
            } else {
            }
            i++;
        }
        if (doDispatch != 0) {
            this.isDrawing = true;
            super.dispatchDraw(canvas);
            this.isDrawing = false;
        }
    }

    @Override // android.view.ViewGroup
    public final void drawChild$ui_release(Canvas canvas, View view, long drawingTime) {
        super.drawChild(AndroidCanvas_androidKt.getNativeCanvas(canvas), view, drawingTime);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        int childCount;
        if (this.isDrawing) {
            childCount = super.getChildCount();
        } else {
            childCount = 0;
        }
        return childCount;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int i = 0;
        setMeasuredDimension(i, i);
    }

    @Override // android.view.ViewGroup
    public void requestLayout() {
    }
}
