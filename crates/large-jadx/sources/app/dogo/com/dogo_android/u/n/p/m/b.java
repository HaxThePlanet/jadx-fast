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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0013\u0014B\u001f\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DogLogSelectCallback", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends RecyclerView.h<app.dogo.com.dogo_android.u.n.p.m.b.b> {

    private final List<DogLog> a;
    private final app.dogo.com.dogo_android.u.n.p.m.b.a b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "", "onItemClick", "", "dogLog", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void s0(DogLog dogLog);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogSelectionBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogSelectionBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogSelectionBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final q1 a;
        final app.dogo.com.dogo_android.u.n.p.m.b b;
        public b(app.dogo.com.dogo_android.u.n.p.m.b b, q1 q12) {
            n.f(b, "this$0");
            n.f(q12, "binding");
            this.b = b;
            super(q12.w());
            this.a = q12;
            a aVar = new a(b, this);
            q12.w().setOnClickListener(aVar);
        }

        private static final void a(app.dogo.com.dogo_android.u.n.p.m.b b, app.dogo.com.dogo_android.u.n.p.m.b.b b$b2, View view3) {
            Object obj0;
            Object obj1;
            n.f(b, "this$0");
            n.f(b2, "this$1");
            app.dogo.com.dogo_android.u.n.p.m.b.a obj2 = b.f(b);
            if (obj2 == null) {
            } else {
                obj2.s0((DogLog)b.g(b).get(b2.getAdapterPosition()));
            }
        }

        public static void c(app.dogo.com.dogo_android.u.n.p.m.b b, app.dogo.com.dogo_android.u.n.p.m.b.b b$b2, View view3) {
            b.b.a(b, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final q1 b() {
            return this.a;
        }
    }
    public b(List<DogLog> list, app.dogo.com.dogo_android.u.n.p.m.b.a b$a2) {
        n.f(list, "list");
        super();
        this.a = list;
        this.b = a2;
    }

    public static final app.dogo.com.dogo_android.u.n.p.m.b.a f(app.dogo.com.dogo_android.u.n.p.m.b b) {
        return b.b;
    }

    public static final List g(app.dogo.com.dogo_android.u.n.p.m.b b) {
        return b.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.n.p.m.b.b b$b, int i2) {
        n.f(b, "holder");
        b.b().V((DogLog)this.a.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.p.m.b.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final q1 obj3 = q1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        b.b bVar = new b.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((b.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
