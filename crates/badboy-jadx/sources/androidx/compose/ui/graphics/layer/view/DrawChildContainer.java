package androidx.compose.ui.graphics.layer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.R.id;
import androidx.compose.ui.graphics.layer.ViewLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0014J%\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\u0008\u0011J\u0008\u0010\u0012\u001a\u00020\u0008H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J0\u0010\u001b\u001a\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0014J\u0018\u0010!\u001a\u00020\u00082\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0014J\u0008\u0010$\u001a\u00020\u0008H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDrawing", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "Landroidx/compose/ui/graphics/Canvas;", "view", "Landroid/view/View;", "drawingTime", "", "drawChild$ui_graphics_release", "forceLayout", "getChildCount", "", "invalidateChildInParent", "Landroid/view/ViewParent;", "location", "", "dirty", "Landroid/graphics/Rect;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class DrawChildContainer extends ViewGroup {

    private boolean isDrawing;
    public DrawChildContainer(Context context) {
        super(context);
        int i = 0;
        setClipChildren(i);
        setClipToPadding(i);
        setTag(R.id.hide_graphics_layer_in_inspector_tag, true);
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
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.graphics.layer.ViewLayer");
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
    public final void drawChild$ui_graphics_release(Canvas canvas, View view, long drawingTime) {
        super.drawChild(AndroidCanvas_androidKt.getNativeCanvas(canvas), view, drawingTime);
    }

    @Override // android.view.ViewGroup
    public void forceLayout() {
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
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        return null;
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
