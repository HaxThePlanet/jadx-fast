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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0013\u0014B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Holder;", "list", "", "", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends RecyclerView.h<app.dogo.com.dogo_android.u.n.q.m.b> {

    private final List<Long> a;
    private final app.dogo.com.dogo_android.u.n.q.m.a b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "", "onIntervalSelected", "", "selection", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void L(long l);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellIntervalSelectorBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter;Lapp/dogo/com/dogo_android/databinding/CellIntervalSelectorBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellIntervalSelectorBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final s2 a;
        final app.dogo.com.dogo_android.u.n.q.m b;
        public b(app.dogo.com.dogo_android.u.n.q.m m, s2 s22) {
            n.f(m, "this$0");
            n.f(s22, "binding");
            this.b = m;
            super(s22.w());
            this.a = s22;
            h hVar = new h(m, this);
            s22.w().setOnClickListener(hVar);
        }

        private static final void a(app.dogo.com.dogo_android.u.n.q.m m, app.dogo.com.dogo_android.u.n.q.m.b m$b2, View view3) {
            n.f(m, "this$0");
            n.f(b2, "this$1");
            List obj2 = m.g(m);
            m.f(m).L((Number)obj2.get(b2.getAdapterPosition()).longValue());
        }

        public static void c(app.dogo.com.dogo_android.u.n.q.m m, app.dogo.com.dogo_android.u.n.q.m.b m$b2, View view3) {
            m.b.a(m, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final s2 b() {
            return this.a;
        }
    }
    public m(List<Long> list, app.dogo.com.dogo_android.u.n.q.m.a m$a2) {
        n.f(list, "list");
        n.f(a2, "callback");
        super();
        this.a = list;
        this.b = a2;
    }

    public static final app.dogo.com.dogo_android.u.n.q.m.a f(app.dogo.com.dogo_android.u.n.q.m m) {
        return m.b;
    }

    public static final List g(app.dogo.com.dogo_android.u.n.q.m m) {
        return m.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.n.q.m.b m$b, int i2) {
        n.f(b, "holder");
        b.b().V(Long.valueOf((Number)this.a.get(i2).longValue()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.q.m.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final s2 obj3 = s2.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        m.b bVar = new m.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((m.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
