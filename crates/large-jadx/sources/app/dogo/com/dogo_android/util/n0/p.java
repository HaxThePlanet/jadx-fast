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
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/LessonListItemDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lessonSideOffset", "", "mDivider", "Landroid/graphics/drawable/Drawable;", "addLessonDivider", "", "canvas", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "addModuleDivider", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends RecyclerView.o {

    private final Drawable a;
    private final int b;
    public p(Context context) {
        n.f(context, "context");
        super();
        Drawable drawable = context.getResources().getDrawable(2131230943, 0);
        n.e(drawable, "context.resources.getDrawable(R.drawable.divider_library_list, null)");
        this.a = drawable;
        this.b = (int)obj4;
    }

    private final void f(Canvas canvas, View view2) {
        android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        bottom += bottomMargin;
        this.a.setBounds(this.b, i2, obj6 -= i4, intrinsicHeight += i2);
        this.a.draw(canvas);
    }

    private final void g(Canvas canvas, View view2) {
        android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        bottom += bottomMargin;
        this.a.setBounds(0, i2, view2.getWidth(), intrinsicHeight += i2);
        this.a.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView3, RecyclerView.b0 recyclerView$b04) {
        n.f(rect, "outRect");
        n.f(view2, "view");
        n.f(recyclerView3, "parent");
        n.f(b04, "state");
        super.getItemOffsets(rect, view2, recyclerView3, b04);
        if (recyclerView3.g0(view2) == 0) {
        }
        rect.top = this.a.getIntrinsicHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        int i5;
        View childAt;
        int i3;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        int i;
        int i2;
        int i4;
        String str;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "parent");
        n.f(b03, "state");
        int i6 = 1;
        obj9 -= i6;
        if (obj9 > 0) {
            i5 = 0;
            i3 = i5 + 1;
            childAt = recyclerView2.getChildAt(i5);
            view = recyclerView2.j0(childAt);
            while (view instanceof l.h) {
                i2 = i6;
                if (i2 != 0) {
                } else {
                }
                i4 = view instanceof l.d;
                if (i4 != 0) {
                } else {
                }
                i = view instanceof l.i;
                str = "child";
                if (i != 0) {
                } else {
                }
                if (view instanceof l.f) {
                }
                if (i3 < obj9) {
                }
                i5 = i3;
                i3 = i5 + 1;
                childAt = recyclerView2.getChildAt(i5);
                view = recyclerView2.j0(childAt);
                i2 = view instanceof l.a;
                n.e(childAt, str);
                g(canvas, childAt);
                n.e(childAt, str);
                f(canvas, childAt);
                i = i6;
                i4 = i6;
            }
        }
    }
}
