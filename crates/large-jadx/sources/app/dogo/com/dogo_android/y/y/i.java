package app.dogo.com.dogo_android.y.y;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ZeroStateDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "layoutId", "", "(I)V", "getLayoutId", "()I", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends RecyclerView.o {

    private final int a;
    private View b;
    public i(int i) {
        super();
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDraw(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        String measureSpec2;
        int measureSpec;
        int height;
        Object obj5;
        View obj6;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "parent");
        n.f(b03, "state");
        super.onDraw(canvas, recyclerView2, b03);
        if (recyclerView2.getChildCount() == 0 && this.b == null) {
            if (this.b == null) {
                this.b = LayoutInflater.from(recyclerView2.getContext()).inflate(this.a, recyclerView2, false);
            }
            obj6 = this.b;
            if (obj6 == null) {
            } else {
                int i = 1073741824;
                obj6.measure(View.MeasureSpec.makeMeasureSpec(recyclerView2.getWidth(), i), View.MeasureSpec.makeMeasureSpec(recyclerView2.getHeight(), i));
            }
            obj6 = this.b;
            if (obj6 == null) {
            } else {
                obj6.layout(recyclerView2.getLeft(), recyclerView2.getTop(), recyclerView2.getRight(), recyclerView2.getBottom());
            }
            obj5 = this.b;
            if (obj5 == null) {
            } else {
                obj5.draw(canvas);
            }
        }
    }
}
