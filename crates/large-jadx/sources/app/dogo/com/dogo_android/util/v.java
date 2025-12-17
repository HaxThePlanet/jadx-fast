package app.dogo.com.dogo_android.util;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.q3;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/PermissionExplanationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/util/PermissionExplanationAdapter$Holder;", "items", "", "Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v extends RecyclerView.h<app.dogo.com.dogo_android.util.v.a> {

    private final List<PermissionDescription> a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/PermissionExplanationAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellPermissionExplanationBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellPermissionExplanationBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellPermissionExplanationBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        private final q3 a;
        public a(q3 q3) {
            n.f(q3, "bind");
            super(q3.w());
            this.a = q3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final q3 a() {
            return this.a;
        }
    }
    public v(List<PermissionDescription> list) {
        n.f(list, "items");
        super();
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void f(app.dogo.com.dogo_android.util.v.a v$a, int i2) {
        n.f(a, "holder");
        a.a().V((PermissionDescription)this.a.get(i2));
        a.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.util.v.a g(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final q3 obj3 = q3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        v.a aVar = new v.a(obj3);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        f((v.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return g(viewGroup, i2);
    }
}
