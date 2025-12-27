package app.dogo.com.dogo_android.util.n0;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LibrarySpacesItemDecoration.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/LibrarySpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class LibrarySpacesItemDecoration extends RecyclerView.o {
    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.b0 state) throws android.content.res.Resources.NotFoundException {
        int i = 1;
        n.f(outRect, "outRect");
        n.f(view, "view");
        n.f(parent, "parent");
        n.f(state, "state");
        int i5 = (parent.getMeasuredWidth() / 2) - view.getResources().getDimensionPixelSize(2131165457);
        int i11 = (i5 * 2) / 7;
        int i7 = (i5 * 5) / 7;
        view = parent.g0(view) % 2 == 0 ? 1 : 0;
        if (i != 0) {
            outRect.left = i7;
            outRect.right = i11;
        } else {
            outRect.left = i11;
            outRect.right = i7;
        }
        outRect.bottom = view.getResources().getDimensionPixelSize(2131165437);
    }
}
