package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.content.res.Resources;
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
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/SpecialProgramVariationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dividerEndMargin", "", "dividerHeight", "endPadding", "mDivider", "Landroid/graphics/drawable/Drawable;", "startPadding", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w extends RecyclerView.o {

    private final Drawable a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    public w(Context context) {
        n.f(context, "context");
        super();
        Drawable drawable = f.f(context.getResources(), 2131230943, 0);
        n.d(drawable);
        n.e(drawable, "getDrawable(context.resources, R.drawable.divider_library_list, null)!!");
        this.a = drawable;
        this.b = context.getResources().getDimensionPixelSize(2131165626);
        this.c = context.getResources().getDimensionPixelSize(2131165620);
        this.d = context.getResources().getDimensionPixelSize(2131165638);
        this.e = context.getResources().getDimensionPixelSize(2131165617);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        int i2;
        Drawable drawable2;
        int i;
        int i3;
        Drawable drawable;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "parent");
        n.f(b03, "state");
        childCount--;
        if (i8 > 0) {
            i2 = 0;
            i = i2 + 1;
            View childAt = recyclerView2.getChildAt(i2);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            bottom += bottomMargin;
            this.a.setBounds(this.b, i9, i4 -= i7, i10 += i9);
            this.a.draw(canvas);
            while (i >= i8) {
                i2 = i;
                i = i2 + 1;
                childAt = recyclerView2.getChildAt(i2);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull((RecyclerView.q)layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                bottom += bottomMargin;
                this.a.setBounds(obj9, i9, i5, i10 += i9);
                this.a.draw(canvas);
            }
        }
    }
}
