package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
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
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/LibrarySectionDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "sidePaddingPixels", "", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q extends RecyclerView.o {

    private final Drawable a;
    public q(Context context) {
        n.f(context, "context");
        super();
        Drawable drawable = context.getResources().getDrawable(2131230943, 0);
        n.e(drawable, "context.resources.getDrawable(R.drawable.divider_library_list, null)");
        this.a = drawable;
        context.getResources().getDimension(2131165456);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        int i;
        int i3;
        Drawable drawable2;
        int i4;
        int i2;
        Drawable drawable;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "parent");
        n.f(b03, "state");
        childCount--;
        if (i5 > 0) {
            i = 0;
            i3 = i;
            i4 = i3 + 1;
            View childAt = recyclerView2.getChildAt(i3);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            bottom += bottomMargin;
            this.a.setBounds(i, i6, recyclerView2.getWidth(), intrinsicHeight += i6);
            this.a.draw(canvas);
            while (i4 >= i5) {
                i3 = i4;
                i4 = i3 + 1;
                childAt = recyclerView2.getChildAt(i3);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull((RecyclerView.q)layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                bottom += bottomMargin;
                this.a.setBounds(i, i6, obj9, intrinsicHeight += i6);
                this.a.draw(canvas);
            }
        }
    }
}
