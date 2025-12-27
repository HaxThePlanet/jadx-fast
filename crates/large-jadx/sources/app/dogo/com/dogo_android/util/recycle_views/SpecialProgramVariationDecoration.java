package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.content.res.Resources;
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

/* compiled from: SpecialProgramVariationDecoration.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/SpecialProgramVariationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dividerEndMargin", "", "dividerHeight", "endPadding", "mDivider", "Landroid/graphics/drawable/Drawable;", "startPadding", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final class SpecialProgramVariationDecoration extends RecyclerView.o {

    /* renamed from: a, reason: from kotlin metadata */
    private final Drawable dividerEndMargin;
    /* renamed from: b, reason: from kotlin metadata */
    private final int dividerHeight;
    /* renamed from: c, reason: from kotlin metadata */
    private final int endPadding;
    /* renamed from: d, reason: from kotlin metadata */
    private final int mDivider;
    /* renamed from: e, reason: from kotlin metadata */
    private final int startPadding;
    public w(Context context) throws android.content.res.Resources.NotFoundException {
        n.f(context, "context");
        super();
        Drawable drawable = f.f(context.getResources(), 2131230943, null);
        n.d(drawable);
        n.e(drawable, "getDrawable(context.resources, R.drawable.divider_library_list, null)!!");
        this.dividerEndMargin = drawable;
        this.dividerHeight = context.getResources().getDimensionPixelSize(2131165626);
        this.endPadding = context.getResources().getDimensionPixelSize(2131165620);
        this.mDivider = context.getResources().getDimensionPixelSize(2131165638);
        this.startPadding = context.getResources().getDimensionPixelSize(2131165617);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.b0 state) {
        int i = 0;
        n.f(canvas, "canvas");
        n.f(parent, "parent");
        n.f(state, "state");
        int i5 = parent.getChildCount() - 1;
        if (this.mDivider > 0) {
            i = 0;
            i = i + 1;
            View childAt = parent.getChildAt(i);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int i6 = childAt.getBottom() + layoutParams.bottomMargin;
            i2 = this.startPadding + i6;
            this.dividerEndMargin.setBounds(this.dividerHeight, i6, (parent.getWidth() - this.endPadding) - this.mDivider, i2);
            this.dividerEndMargin.draw(canvas);
            while (i >= this.mDivider) {
                i = i + 1;
                childAt = parent.getChildAt(i);
                layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                i6 = childAt.getBottom() + layoutParams.bottomMargin;
                i2 = this.startPadding + i6;
                this.dividerEndMargin.setBounds(this.dividerHeight, i6, i4, this.startPadding + i6);
                this.dividerEndMargin.draw(canvas);
            }
        }
    }
}
