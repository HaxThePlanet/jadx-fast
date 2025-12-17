package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/SpecialProgramVariationTipDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "padding", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x extends RecyclerView.o {

    private final Drawable a;
    private final int b;
    public x(Context context) {
        n.f(context, "context");
        super();
        Drawable drawable = context.getResources().getDrawable(2131230943, 0);
        n.e(drawable, "context.resources.getDrawable(R.drawable.divider_library_list, null)");
        this.a = drawable;
        this.b = context.getResources().getDimensionPixelSize(2131165626);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView3, RecyclerView.b0 recyclerView$b04) {
        n.f(rect, "outRect");
        n.f(view2, "view");
        n.f(recyclerView3, "parent");
        n.f(b04, "state");
        int obj3 = this.b;
        rect.left = obj3;
        rect.right = obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        int i2;
        Drawable drawable2;
        int i3;
        int i;
        Drawable drawable;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "parent");
        n.f(b03, "state");
        childCount--;
        if (i6 > 0) {
            i2 = 0;
            i3 = i2 + 1;
            View childAt = recyclerView2.getChildAt(i2);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            bottom += bottomMargin;
            this.a.setBounds(this.b, i7, width -= i5, intrinsicHeight += i7);
            this.a.draw(canvas);
            while (i3 >= i6) {
                i2 = i3;
                i3 = i2 + 1;
                childAt = recyclerView2.getChildAt(i2);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull((RecyclerView.q)layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                bottom += bottomMargin;
                this.a.setBounds(obj9, i7, i4, intrinsicHeight += i7);
                this.a.draw(canvas);
            }
        }
    }
}
