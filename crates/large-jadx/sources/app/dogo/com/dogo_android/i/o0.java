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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0016\u0017\u0018B\u001f\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "list", "", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "callbacks", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;)V", "getList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "CheckBoxHolder", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o0 extends RecyclerView.h<app.dogo.com.dogo_android.i.o0.c> implements a {

    private final List<app.dogo.com.dogo_android.i.q0> a;
    private final app.dogo.com.dogo_android.i.o0.a b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "", "onItemTap", "", "item", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void D(app.dogo.com.dogo_android.i.q0 q0);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$CheckBoxHolder;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellJsonArrayEditBinding;", "(Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter;Lapp/dogo/com/dogo_android/databinding/CellJsonArrayEditBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellJsonArrayEditBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.i.o0.c {

        private final w2 b;
        final app.dogo.com.dogo_android.i.o0 c;
        public b(app.dogo.com.dogo_android.i.o0 o0, w2 w22) {
            n.f(o0, "this$0");
            n.f(w22, "binding");
            this.c = o0;
            super(w22);
            this.b = w22;
            d0 d0Var = new d0(o0, this);
            w22.w().setOnClickListener(d0Var);
        }

        private static final void b(app.dogo.com.dogo_android.i.o0 o0, app.dogo.com.dogo_android.i.o0.b o0$b2, View view3) {
            n.f(o0, "this$0");
            n.f(b2, "this$1");
            Object obj3 = o0.g().get(b2.getBindingAdapterPosition());
            obj3.c(z ^= 1);
            b2.c().V(obj3);
            final app.dogo.com.dogo_android.i.o0.a obj1 = o0.f(o0);
            if (obj1 == null) {
            } else {
                obj1.D(obj3);
            }
        }

        public static void d(app.dogo.com.dogo_android.i.o0 o0, app.dogo.com.dogo_android.i.o0.b o0$b2, View view3) {
            o0.b.b(o0, b2, view3);
        }

        @Override // app.dogo.com.dogo_android.i.o0$c
        public final w2 c() {
            return this.b;
        }
    }
    public o0(List<app.dogo.com.dogo_android.i.q0> list, app.dogo.com.dogo_android.i.o0.a o0$a2) {
        n.f(list, "list");
        super();
        this.a = list;
        this.b = a2;
    }

    public static final app.dogo.com.dogo_android.i.o0.a f(app.dogo.com.dogo_android.i.o0 o0) {
        return o0.b;
    }

    public final List<app.dogo.com.dogo_android.i.q0> g() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.i.o0.c o0$c, int i2) {
        boolean z;
        List list;
        int obj4;
        n.f(c, "holder");
        if (c instanceof o0.b) {
            (o0.b)c.c().V((q0)this.a.get(i2));
        }
        c.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.i.o0.c i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final w2 obj3 = w2.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        o0.b bVar = new o0.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((o0.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
