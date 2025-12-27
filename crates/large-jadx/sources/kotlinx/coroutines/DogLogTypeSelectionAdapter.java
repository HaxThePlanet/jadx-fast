package app.dogo.com.dogo_android.u.n.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.u1;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.n0.i.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogLogTypeSelectionAdapter.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u0014\u0015B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000c\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;", "items", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class DogLogTypeSelectionAdapter extends RecyclerView.h<k.b> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private final k.a callbacks;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<i.b> items;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;", "", "onTagSelected", "", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: Q0, reason: from kotlin metadata */
        void onTagSelected(e type);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeSelectionBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeSelectionBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeSelectionBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final u1 a;
        final /* synthetic */ k b;
        public b(u1 u1Var) {
            n.f(kVar, "this$0");
            n.f(u1Var, "binding");
            this.b = kVar;
            super(u1Var.w());
            this.a = u1Var;
            u1Var.w().setOnClickListener(new kotlinx.coroutines.d(kVar, this));
        }

        private static final void a(k kVar, k.b bVar, View view) {
            n.f(kVar, "this$0");
            n.f(bVar, "this$1");
            kVar.callbacks.onTagSelected((DogLogSelection_SelectionItem)kVar.items.get(bVar.getBindingAdapterPosition()).a());
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final u1 b() {
            return this.a;
        }

        public static /* synthetic */ void c(k kVar, k.b bVar, View view) {
            DogLogTypeSelectionAdapter_DefaultViewHolder.a(kVar, bVar, view);
        }
    }
    public k(k.a aVar, List<i.b> list) {
        n.f(aVar, "callbacks");
        n.f(list, "items");
        super();
        this.callbacks = aVar;
        this.items = list;
    }

    public static final /* synthetic */ k.a f(k kVar) {
        return kVar.callbacks;
    }

    public static final /* synthetic */ List g(k kVar) {
        return kVar.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(k.b holder, int position) {
        n.f(holder, "holder");
        holder.b().V((DogLogSelection_SelectionItem)this.items.get(position).a());
        holder.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public k.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final u1 u1Var = u1.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(u1Var, "inflate(inflater, parent, false)");
        return new DogLogTypeSelectionAdapter_DefaultViewHolder(this, u1Var);
    }
}
