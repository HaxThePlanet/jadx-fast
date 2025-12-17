package app.dogo.com.dogo_android.u;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.o7;
import app.dogo.com.dogo_android.h.q7;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "CellTypes", "DefaultViewHolder", "LockedVariationViewHolder", "VariationViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends RecyclerView.h<app.dogo.com.dogo_android.u.l.c> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.u.l.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;", "", "onLockedTrickSelected", "", "onVariationTrickSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void Y();

        public abstract void p0(TrickItem trickItem);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$CellTypes;", "", "(Ljava/lang/String;I)V", "VARIATION", "LOCKED_VARIATION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static enum b {

        VARIATION,
        LOCKED_VARIATION;
        private static final app.dogo.com.dogo_android.u.l.b[] $values() {
            app.dogo.com.dogo_android.u.l.b[] arr = new l.b[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[l.b.LOCKED_VARIATION.ordinal()] = 1;
            iArr[l.b.VARIATION.ordinal()] = 2;
            l.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$LockedVariationViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramLockedVariationsBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramLockedVariationsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramLockedVariationsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.u.l.c {

        private final o7 b;
        final app.dogo.com.dogo_android.u.l c;
        public d(app.dogo.com.dogo_android.u.l l, o7 o72) {
            n.f(l, "this$0");
            n.f(o72, "binding");
            this.c = l;
            super(o72);
            this.b = o72;
            d dVar = new d(l);
            a().w().setOnClickListener(dVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.l l, View view2) {
            n.f(l, "this$0");
            l.f(l).Y();
        }

        public static void d(app.dogo.com.dogo_android.u.l l, View view2) {
            l.d.b(l, view2);
        }

        @Override // app.dogo.com.dogo_android.u.l$c
        public final o7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$VariationViewHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramVariationsBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramVariationsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramVariationsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.u.l.c {

        private final q7 b;
        final app.dogo.com.dogo_android.u.l c;
        public e(app.dogo.com.dogo_android.u.l l, q7 q72) {
            n.f(l, "this$0");
            n.f(q72, "binding");
            this.c = l;
            super(q72);
            this.b = q72;
            e eVar = new e(l, this);
            a().w().setOnClickListener(eVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.l l, app.dogo.com.dogo_android.u.l.e l$e2, View view3) {
            n.f(l, "this$0");
            n.f(e2, "this$1");
            l.f(l).p0((TrickItem)l.g().get(e2.getAdapterPosition()));
        }

        public static void d(app.dogo.com.dogo_android.u.l l, app.dogo.com.dogo_android.u.l.e l$e2, View view3) {
            l.e.b(l, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.u.l$c
        public final q7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends TrickItem>> {

        final Object a;
        final app.dogo.com.dogo_android.u.l b;
        public h(Object object, Object object2, app.dogo.com.dogo_android.u.l l3) {
            this.a = object;
            this.b = l3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends TrickItem> list2, List<? extends TrickItem> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.u.l obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, l.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements p<TrickItem, TrickItem, Boolean> {

        public static final app.dogo.com.dogo_android.u.l.g a;
        static {
            l.g gVar = new l.g();
            l.g.a = gVar;
        }

        g() {
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
        t tVar = new t(c0.b(l.class), "items", "getItems()Ljava/util/List;");
        l.c = arr;
    }

    public l(app.dogo.com.dogo_android.u.l.a l$a) {
        n.f(a, "callbacks");
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        l.h hVar = new l.h(obj2, obj2, this);
        this.b = hVar;
    }

    public static final app.dogo.com.dogo_android.u.l.a f(app.dogo.com.dogo_android.u.l l) {
        return l.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<TrickItem> g() {
        return (List)this.b.getValue(this, l.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.u.l.b obj2;
        obj2 = (TrickItem)g().get(i).getLocked() ? l.b.LOCKED_VARIATION : l.b.VARIATION;
        return obj2.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.l.c l$c, int i2) {
        o7 o7Var;
        List list;
        Object obj4;
        n.f(c, "holder");
        if (c instanceof l.d) {
            (l.d)c.c().V((TrickItem)g().get(i2));
        } else {
            if (c instanceof l.e) {
                (l.e)c.c().V((TrickItem)g().get(i2));
            }
        }
        c.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.l.c i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.u.l.c obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = l.f.a[l.b.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = q7.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new l.e(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = o7.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new l.d(this, obj5);
    }

    public final void j(List<TrickItem> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, l.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((l.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
