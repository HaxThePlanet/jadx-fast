package app.dogo.com.dogo_android.u.n.r;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.y3;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.l0.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0012B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewAdapter$ScreenViewHolder;", "imageResources", "", "", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ScreenViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends RecyclerView.h<app.dogo.com.dogo_android.u.n.r.e.a> {

    private final List<Integer> a;
    private final b b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewAdapter$ScreenViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellPottyTrackerOverviewBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyTrackerOverviewBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellPottyTrackerOverviewBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends RecyclerView.e0 {

        private final y3 a;
        final app.dogo.com.dogo_android.u.n.r.e b;
        public a(app.dogo.com.dogo_android.u.n.r.e e, y3 y32) {
            n.f(e, "this$0");
            n.f(y32, "binding");
            this.b = e;
            super(y32.w());
            this.a = y32;
            final android.view.View obj3 = y32.w();
            n.e(obj3, "binding.root");
            j1.C0(this, obj3, e.f(e));
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final y3 a() {
            return this.a;
        }
    }
    public e(List<Integer> list, b b2) {
        n.f(list, "imageResources");
        n.f(b2, "callback");
        super();
        this.a = list;
        this.b = b2;
    }

    public static final b f(app.dogo.com.dogo_android.u.n.r.e e) {
        return e.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void g(app.dogo.com.dogo_android.u.n.r.e.a e$a, int i2) {
        n.f(a, "holder");
        a.a().V((Integer)this.a.get(i2));
        a.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.r.e.a h(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final y3 obj2 = y3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj2, "inflate(inflater, parent, false)");
        e.a obj3 = new e.a(this, obj2);
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        g((e.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return h(viewGroup, i2);
    }
}
