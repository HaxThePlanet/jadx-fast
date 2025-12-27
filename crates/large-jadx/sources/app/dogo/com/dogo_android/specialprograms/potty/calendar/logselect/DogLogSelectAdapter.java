package app.dogo.com.dogo_android.u.n.p.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.q1;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogLogSelectAdapter.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0013\u0014B\u001f\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DogLogSelectCallback", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class DogLogSelectAdapter extends RecyclerView.h<b.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<DogLog> callbacks;
    /* renamed from: b, reason: from kotlin metadata */
    private final b.a list;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "", "onItemClick", "", "dogLog", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: s0, reason: from kotlin metadata */
        void onItemClick(DogLog dogLog);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogSelectionBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogSelectionBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogSelectionBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final q1 a;
        final /* synthetic */ b b;
        public b(q1 q1Var) {
            n.f(bVar, "this$0");
            n.f(q1Var, "binding");
            this.b = bVar;
            super(q1Var.w());
            this.a = q1Var;
            q1Var.w().setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.calendar.logselect.a(bVar, this));
        }

        private static final void a(b bVar, b.b bVar2, View view) {
            n.f(bVar, "this$0");
            n.f(bVar2, "this$1");
            app.dogo.com.dogo_android.u.n.p.m.b.a aVar = bVar.list;
            if (aVar != null) {
                aVar.onItemClick((DogLog)bVar.callbacks.get(bVar2.getAdapterPosition()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final q1 b() {
            return this.a;
        }

        public static /* synthetic */ void c(b bVar, b.b bVar2, View view) {
            DogLogSelectAdapter_Holder.a(bVar, bVar2, view);
        }
    }
    public b(List<DogLog> list, b.a aVar) {
        n.f(list, "list");
        super();
        this.callbacks = list;
        this.list = aVar;
    }

    public static final /* synthetic */ b.a f(b bVar) {
        return bVar.list;
    }

    public static final /* synthetic */ List g(b bVar) {
        return bVar.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callbacks.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(b.b holder, int position) {
        n.f(holder, "holder");
        holder.b().V((DogLog)this.callbacks.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public b.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final q1 q1Var = q1.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(q1Var, "inflate(inflater, parent, false)");
        return new DogLogSelectAdapter_Holder(this, q1Var);
    }
}
