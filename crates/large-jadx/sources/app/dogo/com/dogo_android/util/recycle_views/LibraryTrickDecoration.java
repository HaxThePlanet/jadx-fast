package app.dogo.com.dogo_android.util.n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.o;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LibraryTrickDecoration.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/LibraryTrickDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sidePaddingPixels", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s, reason: from kotlin metadata */
public final class LibraryTrickDecoration extends RecyclerView.o {

    /* renamed from: a, reason: from kotlin metadata */
    private final float sidePaddingPixels;
    public s(Context context) throws android.content.res.Resources.NotFoundException {
        n.f(context, "context");
        super();
        this.sidePaddingPixels = context.getResources().getDimension(2131165445);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.b0 state) {
        Integer num = null;
        int i = 0;
        n.f(outRect, "outRect");
        n.f(view, "view");
        n.f(parent, "parent");
        n.f(state, "state");
        RecyclerView.h adapter = parent.getAdapter();
        if (adapter == null) {
            int i4 = 0;
        } else {
            num = Integer.valueOf(adapter.getItemCount());
        }
        i = 0;
        i = 1;
        if (num != null) {
            i3 = num.intValue() - i;
            if (parent.g0(view) == num.intValue() - i) {
            }
        }
        if (i == 0) {
            i2 = (int)this.sidePaddingPixels;
            outRect.right = i2;
        }
    }
}
