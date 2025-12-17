package app.dogo.com.dogo_android.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \u001c2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001b\u001c\u001dB%\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Holder;", "list", "", "", "callback", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "initialSelection", "", "(Ljava/util/List;Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;I)V", "getCallback", "()Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "clickTimeout", "", "lastSelectedPosition", "getList", "()Ljava/util/List;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Companion", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends RecyclerView.h<app.dogo.com.dogo_android.e.k.c> {

    public static final app.dogo.com.dogo_android.e.k.b Companion;
    private final List<String> a;
    private final app.dogo.com.dogo_android.e.k.a b;
    private long c;
    private int d;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "", "onSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void l(int i);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Companion;", "", "()V", "CLICK_TIMEOUT_VALUE_MS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellClickerSelectRowBinding;", "(Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellClickerSelectRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellClickerSelectRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends RecyclerView.e0 {

        private final e1 a;
        final app.dogo.com.dogo_android.e.k b;
        public c(app.dogo.com.dogo_android.e.k k, e1 e12) {
            n.f(k, "this$0");
            n.f(e12, "binding");
            this.b = k;
            super(e12.w());
            this.a = e12;
            d dVar = new d(k, this);
            e12.w().setOnClickListener(dVar);
        }

        private static final void a(app.dogo.com.dogo_android.e.k k, app.dogo.com.dogo_android.e.k.c k$c2, View view3) {
            long currentTimeMillis;
            long valueOf;
            Object obj6;
            Object obj7;
            int obj8;
            n.f(k, "this$0");
            n.f(c2, "this$1");
            if (Long.compare(currentTimeMillis, i2) > 0) {
                k.h(k, System.currentTimeMillis());
                k.i(k, c2.getAdapterPosition());
                int i = 0;
                k.notifyItemChanged(k.g(k), Integer.valueOf(i));
                k.notifyItemChanged(c2.getAdapterPosition(), Integer.valueOf(i));
                k.j().l(c2.getAdapterPosition());
            }
        }

        public static void c(app.dogo.com.dogo_android.e.k k, app.dogo.com.dogo_android.e.k.c k$c2, View view3) {
            k.c.a(k, c2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final e1 b() {
            return this.a;
        }
    }
    static {
        k.b bVar = new k.b(0);
        k.Companion = bVar;
    }

    public k(List<String> list, app.dogo.com.dogo_android.e.k.a k$a2, int i3) {
        n.f(list, "list");
        n.f(a2, "callback");
        super();
        this.a = list;
        this.b = a2;
        this.d = g.b(i3, 0);
    }

    public static final long f(app.dogo.com.dogo_android.e.k k) {
        return k.c;
    }

    public static final int g(app.dogo.com.dogo_android.e.k k) {
        return k.d;
    }

    public static final void h(app.dogo.com.dogo_android.e.k k, long l2) {
        k.c = l2;
    }

    public static final void i(app.dogo.com.dogo_android.e.k k, int i2) {
        k.d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final app.dogo.com.dogo_android.e.k.a j() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void l(app.dogo.com.dogo_android.e.k.c k$c, int i2) {
        int obj4;
        n.f(c, "holder");
        c.b().V((String)this.a.get(i2));
        obj4 = i2 == this.d ? 1 : 0;
        e1Var.O.setChecked(obj4);
        c.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.e.k.c m(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final e1 obj3 = e1.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        k.c cVar = new k.c(this, obj3);
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        l((k.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return m(viewGroup, i2);
    }
}
