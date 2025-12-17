package app.dogo.com.dogo_android.n.m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.g3;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001b\u001c\u001dB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tricks", "getTricks", "()Ljava/util/List;", "setTricks", "(Ljava/util/List;)V", "tricks$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "TrickItemViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends RecyclerView.h<app.dogo.com.dogo_android.n.m.o.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.n.m.o.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void j(TrickItem trickItem);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$TrickItemViewHolder;", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickItemBinding;", "(Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.n.m.o.b {

        private final g3 b;
        final app.dogo.com.dogo_android.n.m.o c;
        public c(app.dogo.com.dogo_android.n.m.o o, g3 g32) {
            n.f(o, "this$0");
            n.f(g32, "binding");
            this.c = o;
            super(g32);
            this.b = g32;
            a aVar = new a(this, o);
            g32.w().setOnClickListener(aVar);
        }

        private static final void b(app.dogo.com.dogo_android.n.m.o.c o$c, app.dogo.com.dogo_android.n.m.o o2, View view3) {
            Object obj1;
            n.f(c, "this$0");
            n.f(o2, "this$1");
            TrickItem obj0 = c.c().T();
            if (obj0 != null) {
                obj1 = o.f(o2);
                if (obj1 == null) {
                } else {
                    obj1.j(obj0);
                }
            }
        }

        public static void d(app.dogo.com.dogo_android.n.m.o.c o$c, app.dogo.com.dogo_android.n.m.o o2, View view3) {
            o.c.b(c, o2, view3);
        }

        @Override // app.dogo.com.dogo_android.n.m.o$b
        public final g3 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends TrickItem>> {

        final Object a;
        final app.dogo.com.dogo_android.n.m.o b;
        public d(Object object, Object object2, app.dogo.com.dogo_android.n.m.o o3) {
            this.a = object;
            this.b = o3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends TrickItem> list2, List<? extends TrickItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.n.m.o obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, o.e.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements p<TrickItem, TrickItem, Boolean> {

        public static final app.dogo.com.dogo_android.n.m.o.e a;
        static {
            o.e eVar = new o.e();
            o.e.a = eVar;
        }

        e() {
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
        t tVar = new t(c0.b(o.class), "tricks", "getTricks()Ljava/util/List;");
        o.c = arr;
    }

    public o() {
        final int i = 0;
        super(i, 1, i);
    }

    public o(app.dogo.com.dogo_android.n.m.o.a o$a) {
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        o.d dVar = new o.d(obj2, obj2, this);
        this.b = dVar;
    }

    public o(app.dogo.com.dogo_android.n.m.o.a o$a, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.n.m.o.a f(app.dogo.com.dogo_android.n.m.o o) {
        return o.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<TrickItem> g() {
        return (List)this.b.getValue(this, o.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.n.m.o.b o$b, int i2) {
        boolean z;
        List list;
        int obj4;
        n.f(b, "holder");
        if (b instanceof o.c) {
            (o.c)b.c().W((TrickItem)g().get(i2));
        }
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.n.m.o.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final g3 obj3 = g3.U(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        o.c cVar = new o.c(this, obj3);
        return cVar;
    }

    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, o.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((o.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
