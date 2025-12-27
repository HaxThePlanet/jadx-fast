package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SpecialProgramVariationTipDecoration.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/SpecialProgramVariationTipDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "padding", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x, reason: from kotlin metadata */
public final class SpecialProgramVariationTipDecoration extends RecyclerView.o {

    /* renamed from: a, reason: from kotlin metadata */
    private final Drawable mDivider;
    /* renamed from: b, reason: from kotlin metadata */
    private final int padding;
    public x(Context context) throws android.content.res.Resources.NotFoundException {
        n.f(context, "context");
        super();
        Drawable drawable = context.getResources().getDrawable(2131230943, null);
        n.e(drawable, "context.resources.getDrawable(R.drawable.divider_library_list, null)");
        this.mDivider = drawable;
        this.padding = context.getResources().getDimensionPixelSize(2131165626);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.b0 state) {
        n.f(outRect, "outRect");
        n.f(view, "view");
        n.f(parent, "parent");
        n.f(state, "state");
        outRect.left = this.padding;
        outRect.right = this.padding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.b0 state) {
        int i = 0;
        n.f(canvas, "canvas");
        n.f(parent, "parent");
        n.f(state, "state");
        int i4 = parent.getChildCount() - 1;
        if (this.padding > 0) {
            i = 0;
            i = i + 1;
            View childAt = parent.getChildAt(i);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int i5 = childAt.getBottom() + layoutParams.bottomMargin;
            i2 = this.mDivider.getIntrinsicHeight() + i5;
            this.mDivider.setBounds(this.padding, i5, parent.getWidth() - this.padding, i2);
            this.mDivider.draw(canvas);
            while (i >= this.padding) {
                i = i + 1;
                childAt = parent.getChildAt(i);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                i5 = childAt.getBottom() + layoutParams.bottomMargin;
                i2 = this.mDivider.getIntrinsicHeight() + i5;
                this.mDivider.setBounds(this.padding, i5, i3, this.mDivider.getIntrinsicHeight() + i5);
                this.mDivider.draw(canvas);
            }
        }
    }
}
