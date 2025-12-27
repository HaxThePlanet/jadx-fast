package app.dogo.com.dogo_android.u.n.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.s2;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ReminderIntervalAdapter.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0013\u0014B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Holder;", "list", "", "", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class ReminderIntervalAdapter extends RecyclerView.h<m.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<Long> callback;
    /* renamed from: b, reason: from kotlin metadata */
    private final m.a list;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "", "onIntervalSelected", "", "selection", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: L, reason: from kotlin metadata */
        void onIntervalSelected(long selection);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellIntervalSelectorBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter;Lapp/dogo/com/dogo_android/databinding/CellIntervalSelectorBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellIntervalSelectorBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final s2 a;
        final /* synthetic */ m b;
        public b(s2 s2Var) {
            n.f(mVar, "this$0");
            n.f(s2Var, "binding");
            this.b = mVar;
            super(s2Var.w());
            this.a = s2Var;
            s2Var.w().setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.h(mVar, this));
        }

        private static final void a(m mVar, m.b bVar, View view) {
            n.f(mVar, "this$0");
            n.f(bVar, "this$1");
            List list = mVar.callback;
            mVar.list.onIntervalSelected((Number)list.get(bVar.getAdapterPosition()).longValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final s2 b() {
            return this.a;
        }

        public static /* synthetic */ void c(m mVar, m.b bVar, View view) {
            ReminderIntervalAdapter_Holder.a(mVar, bVar, view);
        }
    }
    public m(List<Long> list, m.a aVar) {
        n.f(list, "list");
        n.f(aVar, "callback");
        super();
        this.callback = list;
        this.list = aVar;
    }

    public static final /* synthetic */ m.a f(m mVar) {
        return mVar.list;
    }

    public static final /* synthetic */ List g(m mVar) {
        return mVar.callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callback.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(m.b holder, int position) {
        n.f(holder, "holder");
        holder.b().V(Long.valueOf((Number)this.callback.get(position).longValue()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public m.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final s2 s2Var = s2.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(s2Var, "inflate(inflater, parent, false)");
        return new ReminderIntervalAdapter_Holder(this, s2Var);
    }
}
