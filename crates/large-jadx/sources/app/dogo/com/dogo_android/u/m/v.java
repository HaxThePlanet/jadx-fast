package app.dogo.com.dogo_android.u.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.y;
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
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v extends RecyclerView.h<app.dogo.com.dogo_android.u.m.v.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.u.m.v.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;", "", "onVariationSelected", "", "variation", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void k0(TrickItem trickItem);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellBitingTrickVariationBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter;Lapp/dogo/com/dogo_android/databinding/CellBitingTrickVariationBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellBitingTrickVariationBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final y a;
        final app.dogo.com.dogo_android.u.m.v b;
        public b(app.dogo.com.dogo_android.u.m.v v, y y2) {
            n.f(v, "this$0");
            n.f(y2, "binding");
            this.b = v;
            super(y2.w());
            this.a = y2;
            k kVar = new k(v, this);
            y2.w().setOnClickListener(kVar);
        }

        private static final void a(app.dogo.com.dogo_android.u.m.v v, app.dogo.com.dogo_android.u.m.v.b v$b2, View view3) {
            n.f(v, "this$0");
            n.f(b2, "this$1");
            v.f(v).k0((TrickItem)v.g().get(b2.getAdapterPosition()));
        }

        public static void c(app.dogo.com.dogo_android.u.m.v v, app.dogo.com.dogo_android.u.m.v.b v$b2, View view3) {
            v.b.a(v, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final y b() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends TrickItem>> {

        final Object a;
        final app.dogo.com.dogo_android.u.m.v b;
        public d(Object object, Object object2, app.dogo.com.dogo_android.u.m.v v3) {
            this.a = object;
            this.b = v3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends TrickItem> list2, List<? extends TrickItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.u.m.v obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, v.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements p<TrickItem, TrickItem, Boolean> {

        public static final app.dogo.com.dogo_android.u.m.v.c a;
        static {
            v.c cVar = new v.c();
            v.c.a = cVar;
        }

        c() {
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
        t tVar = new t(c0.b(v.class), "items", "getItems()Ljava/util/List;");
        v.c = arr;
    }

    public v(app.dogo.com.dogo_android.u.m.v.a v$a) {
        n.f(a, "callback");
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        v.d dVar = new v.d(obj2, obj2, this);
        this.b = dVar;
    }

    public static final app.dogo.com.dogo_android.u.m.v.a f(app.dogo.com.dogo_android.u.m.v v) {
        return v.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<TrickItem> g() {
        return (List)this.b.getValue(this, v.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.m.v.b v$b, int i2) {
        n.f(b, "holder");
        b.b().V((TrickItem)g().get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.m.v.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final y obj3 = y.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        v.b bVar = new v.b(this, obj3);
        return bVar;
    }

    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, v.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((v.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
