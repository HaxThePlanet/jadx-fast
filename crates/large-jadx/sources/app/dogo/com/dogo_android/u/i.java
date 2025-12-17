package app.dogo.com.dogo_android.u;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.k7;
import app.dogo.com.dogo_android.h.m7;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.Collection;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005\u001c\u001d\u001e\u001f B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BasicTrickHolder", "Callback", "CellTypes", "DefaultViewHolder", "TrickWithVariationHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends RecyclerView.h<app.dogo.com.dogo_android.u.i.d> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.u.j a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$Callback;", "", "onCoreTrickSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void N(TrickItem trickItem);
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$CellTypes;", "", "(Ljava/lang/String;I)V", "TRICK_WITH_VARIATION", "BASIC_TRICK", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static enum c {

        TRICK_WITH_VARIATION,
        BASIC_TRICK;
        private static final app.dogo.com.dogo_android.u.i.c[] $values() {
            app.dogo.com.dogo_android.u.i.c[] arr = new i.c[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[i.c.TRICK_WITH_VARIATION.ordinal()] = 1;
            iArr[i.c.BASIC_TRICK.ordinal()] = 2;
            i.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class d extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public d(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "binding");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$BasicTrickHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.u.i.d {

        private final k7 b;
        final app.dogo.com.dogo_android.u.i c;
        public a(app.dogo.com.dogo_android.u.i i, k7 k72) {
            n.f(i, "this$0");
            n.f(k72, "bind");
            this.c = i;
            super(k72);
            this.b = k72;
            b bVar = new b(i, this);
            k72.O.setOnClickListener(bVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.i i, app.dogo.com.dogo_android.u.i.a i$a2, View view3) {
            n.f(i, "this$0");
            n.f(a2, "this$1");
            i.f(i).N((TrickItemWithVariations)i.g().get(a2.getAdapterPosition()).getCoreTrick());
        }

        public static void d(app.dogo.com.dogo_android.u.i i, app.dogo.com.dogo_android.u.i.a i$a2, View view3) {
            i.a.b(i, a2, view3);
        }

        @Override // app.dogo.com.dogo_android.u.i$d
        public final k7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$TrickWithVariationHolder;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter$DefaultViewHolder;", "bind", "Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseWithVariationsBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramExercisesAdapter;Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseWithVariationsBinding;)V", "getBind", "()Lapp/dogo/com/dogo_android/databinding/CellSpecialProgramExerciseWithVariationsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.u.i.d {

        private final m7 b;
        final app.dogo.com.dogo_android.u.i c;
        public e(app.dogo.com.dogo_android.u.i i, m7 m72) {
            n.f(i, "this$0");
            n.f(m72, "bind");
            this.c = i;
            super(m72);
            this.b = m72;
            c cVar = new c(i, this);
            m72.Q.setOnClickListener(cVar);
        }

        private static final void b(app.dogo.com.dogo_android.u.i i, app.dogo.com.dogo_android.u.i.e i$e2, View view3) {
            n.f(i, "this$0");
            n.f(e2, "this$1");
            i.f(i).N((TrickItemWithVariations)i.g().get(e2.getAdapterPosition()).getCoreTrick());
        }

        public static void d(app.dogo.com.dogo_android.u.i i, app.dogo.com.dogo_android.u.i.e i$e2, View view3) {
            i.e.b(i, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.u.i$d
        public final m7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class h extends b<List<? extends TrickItemWithVariations>> {

        final Object a;
        final app.dogo.com.dogo_android.u.i b;
        public h(Object object, Object object2, app.dogo.com.dogo_android.u.i i3) {
            this.a = object;
            this.b = i3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends TrickItemWithVariations> list2, List<? extends TrickItemWithVariations> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.u.i obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, i.g.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements p<TrickItemWithVariations, TrickItemWithVariations, Boolean> {

        public static final app.dogo.com.dogo_android.u.i.g a;
        static {
            i.g gVar = new i.g();
            i.g.a = gVar;
        }

        g() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(TrickItemWithVariations trickItemWithVariations, TrickItemWithVariations trickItemWithVariations2) {
            n.f(trickItemWithVariations, "o");
            n.f(trickItemWithVariations2, "n");
            return n.b(trickItemWithVariations.getCoreTrick().getId(), trickItemWithVariations2.getCoreTrick().getId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((TrickItemWithVariations)object, (TrickItemWithVariations)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(i.class), "items", "getItems()Ljava/util/List;");
        i.c = arr;
    }

    public i(app.dogo.com.dogo_android.u.j j) {
        n.f(j, "callbacks");
        super();
        this.a = j;
        a obj2 = a.a;
        obj2 = p.g();
        i.h hVar = new i.h(obj2, obj2, this);
        this.b = hVar;
    }

    public static final app.dogo.com.dogo_android.u.j f(app.dogo.com.dogo_android.u.i i) {
        return i.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<TrickItemWithVariations> g() {
        return (List)this.b.getValue(this, i.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.u.i.c obj2;
        obj2 = obj2 ^= 1 != 0 ? i.c.TRICK_WITH_VARIATION : i.c.BASIC_TRICK;
        return obj2.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.i.d i$d, int i2) {
        app.dogo.com.dogo_android.u.j jVar;
        Object m7Var;
        List list;
        m7 obj5;
        n.f(d, "holder");
        if (d instanceof i.e) {
            Object obj = d;
            (i.e)obj.c().W((TrickItemWithVariations)g().get(i2));
            obj.c().V(this.a);
        } else {
            if (d instanceof i.a) {
                (i.a)d.c().V((TrickItemWithVariations)g().get(i2).getCoreTrick());
            }
        }
        d.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.i.d i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.u.i.d obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = i.f.a[i.c.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = k7.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new i.a(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = m7.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new i.e(this, obj5);
    }

    public final void j(List<TrickItemWithVariations> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, i.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((i.d)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
