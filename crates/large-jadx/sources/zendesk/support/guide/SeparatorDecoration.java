package zendesk.support.guide;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.o;

/* loaded from: classes3.dex */
class SeparatorDecoration extends RecyclerView.o {

    private Drawable divider;
    SeparatorDecoration(Drawable drawable) {
        super();
        this.divider = drawable;
    }

    private boolean isItemACategory(RecyclerView.e0 recyclerView$e0) {
        return e0 instanceof HelpRecyclerViewAdapter.CategoryViewHolder;
    }

    private boolean isItemAnExpandedCategory(RecyclerView.e0 recyclerView$e0) {
        Object obj2;
        if (e0 instanceof HelpRecyclerViewAdapter.CategoryViewHolder && (HelpRecyclerViewAdapter.CategoryViewHolder)e0.isExpanded()) {
            obj2 = (HelpRecyclerViewAdapter.CategoryViewHolder)e0.isExpanded() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean isItemAnUnexpandedCategory(RecyclerView.e0 recyclerView$e0) {
        Object obj2;
        if (e0 instanceof HelpRecyclerViewAdapter.CategoryViewHolder && !(HelpRecyclerViewAdapter.CategoryViewHolder)e0.isExpanded()) {
            obj2 = !(HelpRecyclerViewAdapter.CategoryViewHolder)e0.isExpanded() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        int i2;
        View childAt;
        boolean showTopSeparator;
        int i;
        int i3;
        Drawable divider;
        RecyclerView.m obj9;
        super.onDraw(canvas, recyclerView2, b03);
        if (recyclerView2.getItemAnimator() != null && recyclerView2.getItemAnimator().isRunning()) {
            if (recyclerView2.getItemAnimator().isRunning()) {
            }
        }
        i2 = 0;
        while (i2 < recyclerView2.getChildCount()) {
            childAt = recyclerView2.getChildAt(i2);
            if (shouldShowTopSeparator(recyclerView2, i2)) {
            }
            i2++;
            top += topMargin;
            this.divider.setBounds(recyclerView2.getPaddingLeft(), i4, width -= paddingRight, intrinsicHeight += i4);
            this.divider.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    boolean shouldShowTopSeparator(RecyclerView recyclerView, int i2) {
        int i;
        boolean obj5;
        int obj6;
        final int i3 = 1;
        if (i2 > 0 && isItemAnUnexpandedCategory(recyclerView.j0(recyclerView.getChildAt(i2 -= i3)))) {
            obj5 = isItemAnUnexpandedCategory(recyclerView.j0(recyclerView.getChildAt(i2 -= i3))) ? i3 : i;
        } else {
        }
        if (isItemACategory(recyclerView.j0(recyclerView.getChildAt(i2)))) {
            if (!isItemAnExpandedCategory(recyclerView.j0(recyclerView.getChildAt(i2)))) {
                if (obj5 == null) {
                    i = i3;
                }
            } else {
            }
        }
        return i;
    }
}
