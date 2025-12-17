package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.e.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/GenericInBetweenItemDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "sidePaddingPixels", "", "(Landroid/content/Context;I)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends RecyclerView.o {

    private final int a;
    private final Drawable b;
    public m(Context context, int i2) {
        n.f(context, "context");
        super();
        this.a = i2;
        Drawable obj2 = f.f(context.getResources(), 2131230943, 0);
        n.d(obj2);
        n.e(obj2, "getDrawable(context.resources, R.drawable.divider_library_list, null)!!");
        this.b = obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        int i3;
        Drawable drawable;
        int i;
        int i2;
        Drawable drawable2;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "parent");
        n.f(b03, "state");
        childCount--;
        if (i6 > 0) {
            i3 = 0;
            i = i3 + 1;
            View childAt = recyclerView2.getChildAt(i3);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            bottom += bottomMargin;
            this.b.setBounds(this.a, i7, width -= i5, intrinsicHeight += i7);
            this.b.draw(canvas);
            while (i >= i6) {
                i3 = i;
                i = i3 + 1;
                childAt = recyclerView2.getChildAt(i3);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull((RecyclerView.q)layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                bottom += bottomMargin;
                this.b.setBounds(obj9, i7, i4, intrinsicHeight += i7);
                this.b.draw(canvas);
            }
        }
    }
}
