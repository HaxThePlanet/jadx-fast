package app.dogo.com.dogo_android.y.z;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.y5;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: ProgramOverviewAdapter.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R7\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "()V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tricks", "getTricks", "()Ljava/util/List;", "setTricks", "(Ljava/util/List;)V", "tricks$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DefaultViewHolder", "TrickItemViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ProgramOverviewAdapter extends RecyclerView.h<d.a> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] b;
    private final c a = new d$c();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public a(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$TrickItemViewHolder;", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewTrickCardBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewTrickCardBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramOverviewTrickCardBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends d.a {

        private final y5 b;
        public b(y5 y5Var) {
            n.f(dVar, "this$0");
            n.f(y5Var, "binding");
            super(y5Var);
            this.b = y5Var;
        }

        @Override // app.dogo.com.dogo_android.y.z.d$a
        public final y5 b() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c extends b<List<? extends TrickItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ d b;
        public c(Object object, Object object2, d dVar) {
            this.a = object;
            this.b = dVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends TrickItem> oldValue, List<? extends TrickItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.d.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.p<TrickItem, TrickItem, Boolean> {

        public static final d.d a = new d$d();
        @Override // kotlin.d0.d.p
        public final boolean a(TrickItem trickItem, TrickItem trickItem2) {
            n.f(trickItem, "o");
            n.f(trickItem2, "n");
            return n.b(trickItem.getId(), trickItem2.getId());
        }


        d() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        ProgramOverviewAdapter.b = new l[] { c0.f(new t(c0.b(ProgramOverviewAdapter.class), "tricks", "getTricks()Ljava/util/List;")) };
    }

    public d() {
        super();
        List list = p.g();
        final app.dogo.com.dogo_android.y.z.d.c delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: f, reason: from kotlin metadata */
    public final List<TrickItem> getItemCount() {
        return (List)this.a.getValue(this, ProgramOverviewAdapter.b[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public void onBindViewHolder(d.a holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof ProgramOverviewAdapter_TrickItemViewHolder;
        if (holder instanceof ProgramOverviewAdapter_TrickItemViewHolder) {
            (ProgramOverviewAdapter_TrickItemViewHolder)holder.b().V((TrickItem)getItemCount().get(position % getItemCount().size()));
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public d.a onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final y5 y5Var = y5.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(y5Var, "inflate(inflater, parent, false)");
        return new ProgramOverviewAdapter_TrickItemViewHolder(this, y5Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void i(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.a.setValue(this, ProgramOverviewAdapter.b[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return 0x7fffffff /* Unknown resource */;
    }
}
