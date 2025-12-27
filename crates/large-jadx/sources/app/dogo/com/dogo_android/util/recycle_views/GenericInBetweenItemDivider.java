package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.content.e.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: GenericInBetweenItemDivider.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/GenericInBetweenItemDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "sidePaddingPixels", "", "(Landroid/content/Context;I)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class GenericInBetweenItemDivider extends RecyclerView.o {

    /* renamed from: a, reason: from kotlin metadata */
    private final int mDivider;
    /* renamed from: b, reason: from kotlin metadata */
    private final Drawable sidePaddingPixels;
    public m(Context context, int i) {
        n.f(context, "context");
        super();
        this.mDivider = i;
        Drawable drawable = f.f(context.getResources(), 2131230943, null);
        n.d(drawable);
        n.e(drawable, "getDrawable(context.resources, R.drawable.divider_library_list, null)!!");
        this.sidePaddingPixels = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.b0 state) {
        int i = 0;
        n.f(canvas, "canvas");
        n.f(parent, "parent");
        n.f(state, "state");
        int i4 = parent.getChildCount() - 1;
        if (this.mDivider > 0) {
            i = 0;
            i = i + 1;
            View childAt = parent.getChildAt(i);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int i5 = childAt.getBottom() + layoutParams.bottomMargin;
            i2 = this.sidePaddingPixels.getIntrinsicHeight() + i5;
            this.sidePaddingPixels.setBounds(this.mDivider, i5, parent.getWidth() - this.mDivider, i2);
            this.sidePaddingPixels.draw(canvas);
            while (i >= this.mDivider) {
                i = i + 1;
                childAt = parent.getChildAt(i);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                i5 = childAt.getBottom() + layoutParams.bottomMargin;
                i2 = this.sidePaddingPixels.getIntrinsicHeight() + i5;
                this.sidePaddingPixels.setBounds(this.mDivider, i5, i3, this.sidePaddingPixels.getIntrinsicHeight() + i5);
                this.sidePaddingPixels.draw(canvas);
            }
        }
    }
}
