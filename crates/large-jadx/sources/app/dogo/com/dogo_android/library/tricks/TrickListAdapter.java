package app.dogo.com.dogo_android.n.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.g3;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: TrickListAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001b\u001c\u001dB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tricks", "getTricks", "()Ljava/util/List;", "setTricks", "(Ljava/util/List;)V", "tricks$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "TrickItemViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class TrickListAdapter extends RecyclerView.h<o.b> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final o.a callbacks;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: j, reason: from kotlin metadata */
        void onTrickSelected(TrickItem trick);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$TrickItemViewHolder;", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickItemBinding;", "(Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends o.b {

        private final g3 b;
        final /* synthetic */ o c;
        public c(g3 g3Var) {
            n.f(oVar, "this$0");
            n.f(g3Var, "binding");
            this.c = oVar;
            super(g3Var);
            this.b = g3Var;
            g3Var.w().setOnClickListener(new app.dogo.com.dogo_android.library.tricks.a(this, oVar));
        }

        private static final void b(o.c cVar, o oVar, View view) {
            n.f(cVar, "this$0");
            n.f(oVar, "this$1");
            TrickItem trickItem = cVar.c().T();
        }

        @Override // app.dogo.com.dogo_android.n.m.o$b
        public final g3 c() {
            return this.b;
        }

        public static /* synthetic */ void d(o.c cVar, o oVar, View view) {
            TrickListAdapter_TrickItemViewHolder.b(cVar, oVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends TrickItem>> {

        final /* synthetic */ Object a;
        final /* synthetic */ o b;
        public d(Object object, Object object2, o oVar) {
            this.a = object;
            this.b = oVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends TrickItem> oldValue, List<? extends TrickItem> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.library.tricks.o.e.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.p<TrickItem, TrickItem, Boolean> {

        public static final o.e a = new o$e();
        @Override // kotlin.d0.d.p
        public final boolean a(TrickItem trickItem, TrickItem trickItem2) {
            n.f(trickItem, "o");
            n.f(trickItem2, "n");
            return n.b(trickItem.getId(), trickItem2.getId());
        }


        e() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        TrickListAdapter.c = new l[] { c0.f(new t(c0.b(TrickListAdapter.class), "tricks", "getTricks()Ljava/util/List;")) };
    }

    public /* synthetic */ o(o.a aVar, int i, g gVar) {
        app.dogo.com.dogo_android.n.m.o.a aVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(aVar2);
    }

    public static final /* synthetic */ o.a f(o oVar) {
        return oVar.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<TrickItem> getItemCount() {
        return (List)this.b.getValue(this, TrickListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(o.b holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof TrickListAdapter_TrickItemViewHolder;
        if (holder instanceof TrickListAdapter_TrickItemViewHolder) {
            (TrickListAdapter_TrickItemViewHolder)holder.c().W((TrickItem)getItemCount().get(position));
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public o.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final g3 g3Var = g3.U(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(g3Var, "inflate(inflater, parent, false)");
        return new TrickListAdapter_TrickItemViewHolder(this, g3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, TrickListAdapter.c[0], list);
    }

    public o(o.a aVar) {
        super();
        this.callbacks = aVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public o() {
        final app.dogo.com.dogo_android.n.m.o.a aVar = null;
        this(aVar, 1, aVar);
    }
}
