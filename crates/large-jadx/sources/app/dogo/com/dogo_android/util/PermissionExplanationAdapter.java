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

/* compiled from: PermissionExplanationAdapter.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/PermissionExplanationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/util/PermissionExplanationAdapter$Holder;", "items", "", "Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v, reason: from kotlin metadata */
public final class PermissionExplanationAdapter extends RecyclerView.h<v.a> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<PermissionDescription> items;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/PermissionExplanationAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellPermissionExplanationBinding;", "(Lapp/dogo/com/dogo_android/databinding/CellPermissionExplanationBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellPermissionExplanationBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        private final q3 a;
        public a(q3 q3Var) {
            n.f(q3Var, "bind");
            super(q3Var.w());
            this.a = q3Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final q3 a() {
            return this.a;
        }
    }
    public v(List<PermissionDescription> list) {
        n.f(list, "items");
        super();
        this.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: f, reason: from kotlin metadata */
    public void onBindViewHolder(v.a holder, int position) {
        n.f(holder, "holder");
        holder.a().V((PermissionDescription)this.items.get(position));
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public v.a onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final q3 q3Var = q3.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(q3Var, "inflate(inflater, parent, false)");
        return new PermissionExplanationAdapter_Holder(q3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.items.size();
    }
}
