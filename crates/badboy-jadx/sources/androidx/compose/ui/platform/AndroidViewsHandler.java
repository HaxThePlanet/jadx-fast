package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0017J0\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0014J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020%H\u0014J\u0008\u0010,\u001a\u00020\u000fH\u0017J\u0008\u0010-\u001a\u00020\u0013H\u0016R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0008`\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR-\u0010\u000c\u001a\u001e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0007`\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000b¨\u0006.", d2 = {"Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "holderToLayoutNode", "Ljava/util/HashMap;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/collections/HashMap;", "getHolderToLayoutNode", "()Ljava/util/HashMap;", "layoutNodeToHolder", "getLayoutNodeToHolder", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "drawView", "view", "invalidateChildInParent", "", "location", "", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", "child", "Landroid/view/View;", "target", "onLayout", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidViewsHandler extends ViewGroup {

    public static final int $stable = 8;
    private final HashMap<AndroidViewHolder, LayoutNode> holderToLayoutNode;
    private final HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder;
    static {
        final int i = 8;
    }

    public AndroidViewsHandler(Context context) {
        super(context);
        setClipChildren(false);
        HashMap hashMap = new HashMap();
        this.holderToLayoutNode = hashMap;
        HashMap hashMap2 = new HashMap();
        this.layoutNodeToHolder = hashMap2;
    }

    @Override // android.view.ViewGroup
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return 1;
    }

    @Override // android.view.ViewGroup
    public final void drawView(AndroidViewHolder view, Canvas canvas) {
        view.draw(canvas);
    }

    public final HashMap<AndroidViewHolder, LayoutNode> getHolderToLayoutNode() {
        return this.holderToLayoutNode;
    }

    public final HashMap<LayoutNode, AndroidViewHolder> getLayoutNodeToHolder() {
        return this.layoutNodeToHolder;
    }

    @Override // android.view.ViewGroup
    public ViewParent invalidateChildInParent(int[] p0, Rect p1) {
        return (ViewParent)invalidateChildInParent(p0, p1);
    }

    @Override // android.view.ViewGroup
    public Void invalidateChildInParent(int[] location, Rect dirty) {
        return null;
    }

    @Override // android.view.ViewGroup
    public void onDescendantInvalidated(View child, View target) {
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Object next;
        Object obj;
        int i;
        int left;
        int top;
        int right;
        int bottom;
        final int i2 = 0;
        final Iterator iterator = (Iterable)this.holderToLayoutNode.keySet().iterator();
        for (Object next : iterator) {
            obj = next;
            i = 0;
            obj.layout((AndroidViewHolder)obj.getLeft(), obj.getTop(), obj.getRight(), obj.getBottom());
        }
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i2;
        int i;
        int $i$a$RequirePreconditionAndroidViewsHandler$onMeasure$2;
        int next;
        int i3;
        String $i$a$RequirePreconditionAndroidViewsHandler$onMeasure$1;
        $i$a$RequirePreconditionAndroidViewsHandler$onMeasure$2 = 0;
        next = 1073741824;
        i2 = View.MeasureSpec.getMode(widthMeasureSpec) == next ? i : $i$a$RequirePreconditionAndroidViewsHandler$onMeasure$2;
        i3 = 0;
        if (i2 == 0) {
            int i7 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("widthMeasureSpec should be EXACTLY");
        }
        if (View.MeasureSpec.getMode(heightMeasureSpec) == next) {
        } else {
            i = $i$a$RequirePreconditionAndroidViewsHandler$onMeasure$2;
        }
        int i4 = 0;
        if (i == 0) {
            int i6 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("heightMeasureSpec should be EXACTLY");
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        int i5 = 0;
        Iterator iterator = (Iterable)this.holderToLayoutNode.keySet().iterator();
        for (Object next : iterator) {
            $i$a$RequirePreconditionAndroidViewsHandler$onMeasure$1 = null;
            (AndroidViewHolder)next.remeasure();
        }
    }

    @Override // android.view.ViewGroup
    public void requestLayout() {
        int i4;
        View childAt;
        boolean layoutRequested;
        Object obj;
        int i2;
        int i;
        int i3;
        int i6;
        int i5;
        cleanupLayoutState((View)this);
        i4 = 0;
        while (i4 < getChildCount()) {
            childAt = getChildAt(i4);
            obj = obj2;
            if (childAt.isLayoutRequested() && (LayoutNode)obj != null) {
            }
            i4++;
            if ((LayoutNode)obj != null) {
            }
            LayoutNode.requestRemeasure$ui_release$default((LayoutNode)obj, false, false, false, 7, 0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}
