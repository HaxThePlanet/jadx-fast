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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u0014\u0015B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000c\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;", "items", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends RecyclerView.h<app.dogo.com.dogo_android.u.n.p.k.b> implements a {

    private final app.dogo.com.dogo_android.u.n.p.k.a a;
    private final List<i.b> b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;", "", "onTagSelected", "", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void Q0(e e);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeSelectionBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter;Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeSelectionBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellDogLogTypeSelectionBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final u1 a;
        final app.dogo.com.dogo_android.u.n.p.k b;
        public b(app.dogo.com.dogo_android.u.n.p.k k, u1 u12) {
            n.f(k, "this$0");
            n.f(u12, "binding");
            this.b = k;
            super(u12.w());
            this.a = u12;
            d dVar = new d(k, this);
            u12.w().setOnClickListener(dVar);
        }

        private static final void a(app.dogo.com.dogo_android.u.n.p.k k, app.dogo.com.dogo_android.u.n.p.k.b k$b2, View view3) {
            n.f(k, "this$0");
            n.f(b2, "this$1");
            k.f(k).Q0((i.b)k.g(k).get(b2.getBindingAdapterPosition()).a());
        }

        public static void c(app.dogo.com.dogo_android.u.n.p.k k, app.dogo.com.dogo_android.u.n.p.k.b k$b2, View view3) {
            k.b.a(k, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final u1 b() {
            return this.a;
        }
    }
    public k(app.dogo.com.dogo_android.u.n.p.k.a k$a, List<i.b> list2) {
        n.f(a, "callbacks");
        n.f(list2, "items");
        super();
        this.a = a;
        this.b = list2;
    }

    public static final app.dogo.com.dogo_android.u.n.p.k.a f(app.dogo.com.dogo_android.u.n.p.k k) {
        return k.a;
    }

    public static final List g(app.dogo.com.dogo_android.u.n.p.k k) {
        return k.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.n.p.k.b k$b, int i2) {
        n.f(b, "holder");
        b.b().V((i.b)this.b.get(i2).a());
        b.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.p.k.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final u1 obj3 = u1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        k.b bVar = new k.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((k.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
