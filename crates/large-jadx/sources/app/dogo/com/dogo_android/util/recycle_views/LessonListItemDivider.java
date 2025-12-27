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

/* compiled from: LessonListItemDivider.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/LessonListItemDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lessonSideOffset", "", "mDivider", "Landroid/graphics/drawable/Drawable;", "addLessonDivider", "", "canvas", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "addModuleDivider", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final class LessonListItemDivider extends RecyclerView.o {

    /* renamed from: a, reason: from kotlin metadata */
    private final Drawable lessonSideOffset;
    /* renamed from: b, reason: from kotlin metadata */
    private final int mDivider;
    public p(Context context) throws android.content.res.Resources.NotFoundException {
        n.f(context, "context");
        super();
        Drawable drawable = context.getResources().getDrawable(2131230943, null);
        n.e(drawable, "context.resources.getDrawable(R.drawable.divider_library_list, null)");
        this.lessonSideOffset = drawable;
        this.mDivider = (int)context.getResources().getDimension(2131165626);
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final void addLessonDivider(Canvas canvas, View child) {
        android.view.ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int i2 = child.getBottom() + layoutParams.bottomMargin;
        this.lessonSideOffset.setBounds(this.mDivider, i2, child.getWidth() - this.mDivider, this.lessonSideOffset.getIntrinsicHeight() + i2);
        this.lessonSideOffset.draw(canvas);
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final void addModuleDivider(Canvas canvas, View child) {
        android.view.ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int i2 = child.getBottom() + layoutParams.bottomMargin;
        this.lessonSideOffset.setBounds(0, i2, child.getWidth(), this.lessonSideOffset.getIntrinsicHeight() + i2);
        this.lessonSideOffset.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.b0 state) {
        n.f(outRect, "outRect");
        n.f(view, "view");
        n.f(parent, "parent");
        n.f(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.g0(view) == 0) {
            return;
        }
        outRect.top = this.lessonSideOffset.getIntrinsicHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.b0 state) {
        int i2 = 0;
        androidx.recyclerview.widget.RecyclerView.e0 e0Var;
        int i;
        n.f(canvas, "canvas");
        n.f(parent, "parent");
        n.f(state, "state");
        i = 1;
        int i3 = parent.getChildCount() - i;
        if (i3 > 0) {
            i2 = 0;
            i2 = i2 + 1;
            View childAt = parent.getChildAt(i2);
            e0Var = parent.j0(childAt);
            while (e0Var instanceof ProgramLessonsListAdapter_LockedHolder) {
                int r4 = i != 0 ? i : e0Var instanceof ProgramLessonsListAdapter_CompletedHolder;
                boolean z3 = e0Var instanceof ProgramLessonsListAdapter_ActiveHolder;
                r4 = i != 0 ? i : e0Var instanceof ProgramLessonsListAdapter_UnlockedHolder;
                str = "child";
            }
        }
    }
}
