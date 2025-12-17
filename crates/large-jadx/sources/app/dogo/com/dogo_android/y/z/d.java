package app.dogo.com.dogo_android.y.z;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.y5;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R7\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "()V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tricks", "getTricks", "()Ljava/util/List;", "setTricks", "(Ljava/util/List;)V", "tricks$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DefaultViewHolder", "TrickItemViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends RecyclerView.h<app.dogo.com.dogo_android.y.z.d.a> implements a {

    static final l<Object>[] b;
    private final c a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public a(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$TrickItemViewHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewTrickCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewTrickCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewTrickCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.y.z.d.a {

        private final y5 b;
        public b(app.dogo.com.dogo_android.y.z.d d, y5 y52) {
            n.f(d, "this$0");
            n.f(y52, "binding");
            super(y52);
            this.b = y52;
        }

        @Override // app.dogo.com.dogo_android.y.z.d$a
        public final y5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c extends b<List<? extends TrickItem>> {

        final Object a;
        final app.dogo.com.dogo_android.y.z.d b;
        public c(Object object, Object object2, app.dogo.com.dogo_android.y.z.d d3) {
            this.a = object;
            this.b = d3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends TrickItem> list2, List<? extends TrickItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.y.z.d obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, d.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements p<TrickItem, TrickItem, Boolean> {

        public static final app.dogo.com.dogo_android.y.z.d.d a;
        static {
            d.d dVar = new d.d();
            d.d.a = dVar;
        }

        d() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(TrickItem trickItem, TrickItem trickItem2) {
            n.f(trickItem, "o");
            n.f(trickItem2, "n");
            return n.b(trickItem.getId(), trickItem2.getId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((TrickItem)object, (TrickItem)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(d.class), "tricks", "getTricks()Ljava/util/List;");
        d.b = arr;
    }

    public d() {
        super();
        a aVar = a.a;
        List list = p.g();
        d.c cVar = new d.c(list, list, this);
        this.a = cVar;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<TrickItem> f() {
        return (List)this.a.getValue(this, d.b[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void g(app.dogo.com.dogo_android.y.z.d.a d$a, int i2) {
        boolean z;
        List list;
        int size;
        int obj5;
        n.f(a, "holder");
        if (a instanceof d.b) {
            (d.b)a.b().V((TrickItem)f().get(i2 %= size));
        }
        a.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.z.d.a h(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final y5 obj3 = y5.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        d.b bVar = new d.b(this, obj3);
        return bVar;
    }

    public final void i(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.a.setValue(this, d.b[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        g((d.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return h(viewGroup, i2);
    }
}
