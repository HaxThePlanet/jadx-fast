package app.dogo.com.dogo_android.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.w2;
import app.dogo.com.dogo_android.util.d0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: JsonArrayEditAdapter.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0016\u0017\u0018B\u001f\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "list", "", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "callbacks", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;)V", "getList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "CheckBoxHolder", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o0, reason: from kotlin metadata */
public final class JsonArrayEditAdapter extends RecyclerView.h<o0.c> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<q0> callbacks;
    private final o0.a b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "", "onItemTap", "", "item", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: D, reason: from kotlin metadata */
        void onItemTap(q0 item);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$CheckBoxHolder;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellJsonArrayEditBinding;", "(Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter;Lapp/dogo/com/dogo_android/databinding/CellJsonArrayEditBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellJsonArrayEditBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends o0.c {

        private final w2 b;
        final /* synthetic */ o0 c;
        public b(w2 w2Var) {
            n.f(o0Var, "this$0");
            n.f(w2Var, "binding");
            this.c = o0Var;
            super(w2Var);
            this.b = w2Var;
            w2Var.w().setOnClickListener(new app.dogo.com.dogo_android.debug.d0(o0Var, this));
        }

        private static final void b(o0 o0Var, o0.b bVar, View view) {
            n.f(o0Var, "this$0");
            n.f(bVar, "this$1");
            Object item = o0Var.getItemCount().get(bVar.getBindingAdapterPosition());
            item.equals(!item.b());
            bVar.c().V(item);
            final app.dogo.com.dogo_android.i.o0.a aVar = o0Var.b;
            if (aVar != null) {
                aVar.onItemTap(item);
            }
        }

        @Override // app.dogo.com.dogo_android.i.o0$c
        public final w2 c() {
            return this.b;
        }

        public static /* synthetic */ void d(o0 o0Var, o0.b bVar, View view) {
            JsonArrayEditAdapter_CheckBoxHolder.b(o0Var, bVar, view);
        }
    }
    public o0(List<q0> list, o0.a aVar) {
        n.f(list, "list");
        super();
        this.callbacks = list;
        this.b = aVar;
    }

    public static final /* synthetic */ o0.a f(o0 o0Var) {
        return o0Var.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<q0> getItemCount() {
        return this.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callbacks.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(o0.c holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof JsonArrayEditAdapter_CheckBoxHolder;
        if (holder instanceof JsonArrayEditAdapter_CheckBoxHolder) {
            (JsonArrayEditAdapter_CheckBoxHolder)holder.c().V((JsonArrayEditItem)this.callbacks.get(position));
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public o0.c onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final w2 w2Var = w2.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(w2Var, "inflate(inflater, parent, false)");
        return new JsonArrayEditAdapter_CheckBoxHolder(this, w2Var);
    }
}
