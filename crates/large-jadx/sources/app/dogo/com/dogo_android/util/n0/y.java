package app.dogo.com.dogo_android.util.n0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.o;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/VerticalSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "verticalSpaceHeight", "", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y extends RecyclerView.o {

    private final int a;
    public y(int i) {
        super();
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView3, RecyclerView.b0 recyclerView$b04) {
        int obj3;
        int obj4;
        n.f(rect, "outRect");
        n.f(view2, "view");
        n.f(recyclerView3, "parent");
        n.f(b04, "state");
        obj4 = recyclerView3.getAdapter();
        if (obj4 == null) {
            obj4 = 0;
        } else {
            obj4--;
        }
        if (recyclerView3.g0(view2) != obj4) {
            rect.bottom = this.a;
        }
    }
}
